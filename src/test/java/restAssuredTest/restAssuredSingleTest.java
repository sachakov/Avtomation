package restAssuredTest;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class restAssuredSingleTest {

    private static final String BASE_URL = "https://petstore.swagger.io/v2";

    @Test
    public void createPet(){//составляем типа хттп запрос
        String petID = RestAssured//сделали пет ИД, чтобы потом вытянуть его из респонса
                .given()
                .baseUri(BASE_URL)
                //.header(new Header("api_token", RestAssuredHelper.getToken()))
                .header(new Header("Content-Type", "application/json")) //заполнили хедер, если бы их надо было много, то передали бы Мапой
                .body(new File("src/main/resources/testdata.petstore/barsik.json"))
//ранее в боди был пойный джейсон, потом сделали файл барсик.json и вставилю сюда путь к файлу, путь брали правой кнопкой
                .when()
                .post("/pet")//взяли из Постмана {{BaseURL}}/pet последняя часть и есть директория
                .then()
                .statusCode(200)//приверяем, что барсик создался
//когда создали барсика, нам в респонсе возвращается ID нового барсика
                .extract()
                .body()
                .jsonPath()
                .getString("name"); //если бы хотели взять ИД вложенного то category.id
        System.out.println(petID);
        Assert.assertEquals(petID, "barsik");
    }

}
