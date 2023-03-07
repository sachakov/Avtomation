package SelenidTest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class GoogleTest {
//выше импотрты статических методов очень важно, позволяют писать не Selenid.open а просто open, так же с visible
//хромдрайвер.ексе уже не нужен, селенд сам качает и открывает драйвер и сам закрывает
    @Test
    public void userShouldSearch(){
        Configuration.holdBrowserOpen = true;  //Селенид конфигурируемся через класс Configuration. Тут сделали, чтобы браузер не закрывался.
        Configuration.browserSize = "1920x1080"; // тут сделали фул скрин
        Configuration.timeout = 4000;
        open("https://you.com");
      //  $("#sb_form_q").shouldBe(Condition.visible); //сразу сделали эл-т поле ввода и сразу сделали проверку, что этот эл-т должен быть видимый, shouldBe еще и как waiter работает
       //$ аналог .findElement в вебдпайвере, метод, который возращает нам элемент
        SelenideElement searchField = $("#section > main > div.sc-aa45d2c7-1.iwkLRV > div.sc-aa45d2c7-3.edYBoD > div > div.sc-aa45d2c7-7.bdIGLM > div > div > div.sc-c1c5339b-2.kIEyDR > div > input");
        searchField.shouldBe(visible).setValue("Selenide").pressEnter(); // в одну строчку проверили наличие серчФилда, ввели стово и нажали Энтер
        $("#header > nav > ul > div:nth-child(1) > li > a > div > span").click();
    }
}
