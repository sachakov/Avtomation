package pages.yep;

import org.openqa.selenium.By;
import pages.theInternet.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class YepHomePage extends BasePage {

    //@FindBy(css = "[placeholder='Start searching']")
   // public SelenideElement searchField;

    private static final By SEARCH_FIELD = By.cssSelector("[placeholder='Start searching']");//константа с локатором для серчфилда

    public YepHomePage waitUntilSearchFieldDisplayed() { //сделали метод, который ждет пока загрузится серчфилд
        $(SEARCH_FIELD).shouldBe(visible);
        return this;//возвращаем обїект yepHomePage
    }

    public YepHomePage setSearchText(String text) { //сделали метод, который вводит текст в серчфилд, метод не войд, чтобы можно было после него вызывать другие методы
        $(SEARCH_FIELD).setValue(text); //вместо войда называлось SelenidElement
        return this;
    }

    public YepHomePage pressEnter() { //сделали метод, который жмет эннтер
        $(SEARCH_FIELD).pressEnter();
        return this;
    }
}
