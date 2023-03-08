package restAssuredTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import lombok.SneakyThrows;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import restassuredAPI.PetDto;

import java.io.File;

import static javafx.scene.input.KeyCode.O;

public class restAssuredMultiTest {
    private static final String BASE_URL = "https://petstore.swagger.io/v2";
    private RequestSpecification requestSpecification;//делаем на уровне класса, чтобы был доступ к нему

    @BeforeClass//загнали сюда общее, юрл, хедер
    public void setUp() {
        requestSpecification = new RequestSpecBuilder()
                        .setBaseUri(BASE_URL)
                        .addHeader("Content-Type", "application/json")
                        .build();
    }
        @Test
        @SneakyThrows //аннотация из Ломбока - игнорировать ошибки
        public void createPet () {//составляем типа хттп запрос
//создаем в начале пета c несколькими параметрами и надо его засунуть в боди, джава объект в json спарсит Джексон
            PetDto requestPet = PetDto
                    .builder()
                    .name("barsik")
                    .status("available")
                    .build();
//созаем пэт запросом (пост)
            String petID = RestAssured//сделали пет ИД, чтобы потом вытянуть его из респонса
                    .given()
                    .spec(requestSpecification)                                //добавили после того как сделали БефорКласс
                    .body(new ObjectMapper().writeValueAsString(requestPet))   //выбираем фастер хмл, поставили@SneakyThrows, чтобы игнорить ошибку сереализации
                                                                               //ObjectMapper превращает джава объекты в json и потом наоборот
                    .when()
                    .post("/pet")
                    .then()
                    .statusCode(200)
                    .extract()
                    .body()
                    .jsonPath()
                    .getString("id"); //если бы хотели взять ИД вложенного то category.id
//берем данные пэт запросом (гет) уже для проверки
            JsonPath jsonResponsePet = RestAssured
                    .given()
                    .spec(requestSpecification)
                    .when()
                    .get("/pet/" + petID)
                    .then()
                    .statusCode(200)
                    .extract()
                    .body()
                    .jsonPath();
//превращаем полученный json в PetDto класс и можно будет сравнивать
            PetDto responsePet = new ObjectMapper().readValue(jsonResponsePet.prettify(), PetDto.class);

            //Assert.assertEquals(requestPet, responsePet);
            Assert.assertEquals(requestPet.getName(), responsePet.getName());
            Assert.assertEquals(requestPet.getStatus(), responsePet.getStatus());
        }




    }
