package pages.theInternet;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver;
    protected String pageUrl;
    protected WebDriverWait webDriverWait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);//это чтобы можно было делать @Find
    }
//когда проходили Селенид добавили этот конструктор без Вебдрайвера, чтобы пользоваться БейсПейдж без вебдрайвера
    public BasePage() {
    PageFactory.initElements(WebDriverRunner.getWebDriver(), this);//это чтобы можно было делать @Find
    }

    //делаем метод для ожидания загрузки страницы
    public void waitUntilLoaded(){
        new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.urlContains(pageUrl));
       // new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.textToBe(locator, String)); - вариант, чтобы органировать
        //ожидание загрузки сообщения (типа "Письмо отправлено" когда спиннер крутится)

        //была проблема, что никак не появлялся эл-т на странице, это оббошли таким методом, через ДжаваСкрипт Экзекьютор
      //  public void waitUntilJSisReady (){
      //      ((JavascriptExecutor)driver).executeScript(сюда JS код, который хотим выполнить на странице);//- приведение типов, драйвер привели к JS экзекьютору
      //  }
    }
    public void navigate() {
        driver.get(pageUrl);
    }

    protected String waitAndGetText(WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(4))
                .until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }
}
