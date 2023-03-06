package pages.yahoo;

import pages.theInternet.BasePage;
import Testdata.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageYahoo extends BasePage {

                                                                   //private WebDriver driver; убрали, когда абстрактный класс объявили
                                                                  // private String pageUrl = "https://login.yahoo.com/";
    //прописываем локаторы для ввода мыла, пароля и кнопки войти
                                                                //private By loginField = By.cssSelector("[name = 'login'");
                                                                //private By passwordField = By.cssSelector("[name = 'password'");
    //в классе Ву есть готовый метод для работы с атрибутом Name - By.name, запись меняется на
    private By loginField = By.xpath("//*[@id=\"login-username\"]");
    private By passwordField = By.name("password");
    private By submitButton = By.name("verifyPassword");
    private By firstButton = By.name("signin");
    private By toMailButton = By.xpath("//*[@id=\'ybarMailLink\']");
// нам, чтобы взаимодействовать с браузером нужен вебдрайвер, объявили в начале, теперь в конструкторе реализуем
//(конструктор из абстрактного класса) переопределяем

    public LoginPageYahoo(WebDriver driver){
     super(driver);
        pageUrl = "https://login.yahoo.com/";//присваиваем юрл в конструкторе
    }
    //делаем метод навигейт для открытия веб-сторинки
    public void navigate(){
        driver.get(pageUrl);
    }


    //теперь делаем Метод для логина, для логина нам нужен Юзер - делаем класс юзер с мылом и паролем

   public void login(User user) throws InterruptedException{
     driver.findElement(loginField).sendKeys(user.getLogin());
     driver.findElement(firstButton).click();
       Thread.sleep(500);
     driver.findElement(passwordField).sendKeys(user.getPassword());
       Thread.sleep(4000);
       driver.findElement(submitButton).click();
       Thread.sleep(4000);
       driver.findElement(toMailButton).click();
   }
}
