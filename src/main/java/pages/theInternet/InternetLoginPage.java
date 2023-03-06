package pages.theInternet;

import Testdata.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InternetLoginPage extends BasePage {

    @FindBy(id = "username")                        //по PageOb1ject делаем эл-ты полей логина, кнопки, error
    private WebElement loginField;

    @FindBy(id = "password")
    private WebElement passwField;

    @FindBy(css = "[type = 'submit']")
    private WebElement loginButton;

    @FindBy(css = "#flash")
    private WebElement errorMessage;


//конструктор супер-класса, можем каждую пейдж инициализировать так по простому
    public InternetLoginPage(WebDriver driver) {
        super(driver);
        pageUrl = "https://the-internet.herokuapp.com/login";
    }

    //напишем основные методы для работы с этой стр. Метод Логин Т.к у нас уже есть класс Юзер, то берем его
    //public void navigate (){driver.get(pageUrl);}
    public void login (User user){
        loginField.sendKeys(user.getLogin());
        passwField.sendKeys(user.getPassword());
        loginButton.click();
    }

    //метод для ошибки. надо будет проверить, что ошибка вообще видна на стр. и что текст соответствует
    //подождать, чтобы отобразилась
    //на этом этапе вернулись в класс Бейс пейдж и сделали там метод waitAndGetText т.к это повторяющееся действие, можно загнать в абстрактный
    public String getErrorMessage (){
        return waitAndGetText(errorMessage);
    }
}
