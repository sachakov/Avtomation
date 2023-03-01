package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage{
//когда создали новый класс, заметили, что для каждой пейджи у нас есть общее: драйвер и пейджЮрл - делаем абстрактный класс
   // private String pageUrl = "https://mail.yahoo.com/d/folders/1";

    WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(4));
    private By writeMailButton = By.xpath("//*[@id=\'app\']/div[2]/div/div[1]/nav/div/div[1]/a");
    private By sendeeEmail = By.xpath("//*[@id=\'message-to-field\']");
    private By emailSubject = By.xpath("//*[@id=\'mail-app-component\']/div/div/div/div[1]/div[3]/div/div/input");
    private By emailBody = By.xpath("//*[@id=\'editor-container\']/div[1]");
    private By sendButton = By.xpath("//*[@id=\'mail-app-component\']/div/div/div/div[2]/div[2]/div/button");
    private By sortMails = By.xpath("//*[@id=\'mail-app-component\']/div/div/div/div[1]/div/div[3]/div/div/button/span");

    public HomePage (WebDriver driver){
        super(driver);
        pageUrl = "https://mail.yahoo.com/d/folders/1";//присваиваем юрл в конструкторе
    }

    public void writeEmail(String to, String subject, String body){
        driver.findElement(writeMailButton).click();
        driver.findElement(sendeeEmail).sendKeys(to);
        driver.findElement(emailSubject).sendKeys(subject);
        driver.findElement(emailBody).sendKeys(body);
    }
    //делаем метод, чтобы кликал на отправить, перед этим пишем waiter, чтобы ждал пока появится кнопка
    public void sendMail(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(sendButton));
        driver.findElement(sendButton).click();
    }

    //была роблема на лекции, что не находило текст всплывающего окна, делаем Waiter

    //посмотрим, какой текст вернет после отправки, там где написано Сортувати

    public String getTestSortuvaty(){
       // webDriverWait.until(ExpectedConditions.textMatches(sortMails, Pattern.compile("^Сортувати\n.*")));
        return driver.findElement(sortMails).getText();
    }
}
