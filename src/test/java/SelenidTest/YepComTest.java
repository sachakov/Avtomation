package SelenidTest;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.yep.YepHomePage;

import static com.codeborne.selenide.Selenide.open;

public class YepComTest {
//выше импотрты статических методов очень важно, позволяют писать не Selenid.open а просто open, так же с visible
//хромдрайвер.ексе уже не нужен, селенд сам качает и открывает драйвер и сам закрывает
   @BeforeTest
   public void setUp() {
       Configuration.holdBrowserOpen = true;  //Селенид конфигурируемся через класс Configuration. Тут сделали, чтобы браузер не закрывался.
       Configuration.browserSize = "1920x1080"; // тут сделали фул скрин
       Configuration.timeout = 4000;
   }

    @Test
    public void userShouldSearch(){
        open("https://yep.com/");
        YepHomePage yepHomePage = new YepHomePage();
        yepHomePage.waitUntilSearchFieldDisplayed()
                .setSearchText("Selenide")
                .pressEnter();
    }




   /* @Test - выше переписали упрощенную версию(но только ввод текста и поиска) для этого сделали ЙепХомПейдж, там @Find
    public void userShouldSearch(){
        Configuration.holdBrowserOpen = true;  //Селенид конфигурируемся через класс Configuration. Тут сделали, чтобы браузер не закрывался.
        Configuration.browserSize = "1920x1080"; // тут сделали фул скрин
        Configuration.timeout = 4000;
        open("https://yep.com/");
      //  $("#sb_form_q").shouldBe(Condition.visible); //сразу сделали эл-т поле ввода и сразу сделали проверку, что этот эл-т должен быть видимый, shouldBe еще и как waiter работает
       //$ аналог .findElement в вебдпайвере, метод, который возращает нам элемент
        SelenideElement searchField = $("#root > div > div.css-1gff5l7-main > div > div.css-mucg5v-searchBlockContainer > div > div > form > div > div > input");
        searchField.shouldBe(visible).setValue("Selenide").pressEnter(); // в одну строчку проверили наличие серчФилда, ввели стово и нажали Энтер

        // //h3[text()='selenide'] - поиск по полной фразе в тэге
        // //h3[contains(text(),'selenide')] - поиск по части текста в тэге h3

        $$x("//span[contains(text(),'selenide')]")//тут хотим проверить, что кол-во тэгов где есть слово селенид более 1, как коллекцию понимает
                .shouldHave(CollectionCondition.sizeGreaterThanOrEqual(5))
                .filter(visible)//отфильтровали видимые, чтобы кликнуть потом, много невидимых в html
                .get(0)//взять первый элемент
                .click();//кликнуть на нем
        $x("/html/body/div[2]/section/div[1]/div/h1") //проверили, что какой-то элемент содержит текст
                .shouldHave(text("Selenide Supports Ukraine \uD83C\uDDFA\uD83C\uDDE6"));*/






    }

