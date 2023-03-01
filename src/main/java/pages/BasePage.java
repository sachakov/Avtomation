package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriver driver;
    protected String pageUrl;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageUrl() {
        return pageUrl;
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
}
