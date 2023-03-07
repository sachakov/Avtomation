import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestNGNovaPoshta {
    WebDriver driver;
    //выше объявили драйвер на уровне класса, чтобы в афтерметоде можно было закрывать браузер, после теста каждый раз

@Test
    public void inputTest() throws InterruptedException {
    System.setProperty ("selenium.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String baseUrl = "https://npshopping.com/";
        driver.get(baseUrl);
        driver.manage().window().maximize();

        By enterButtonLocator = By.xpath("/html/body/header/div[2]/div/div[2]/a/span");
        WebElement enterButtonElement = driver.findElement(enterButtonLocator);
        enterButtonElement.click();
        Thread.sleep(1000);

    By enterEmailLocator = By.xpath("//*[@id=\"email\"]");
    WebElement enterEmailElement = driver.findElement(enterEmailLocator);
    enterEmailElement.sendKeys("kovalinskyi@gmail.com");
    Thread.sleep(500);

    By enterPassLocator = By.xpath("//*[@id=\"password\"]");
    WebElement enterPassElement = driver.findElement(enterPassLocator);
    enterPassElement.sendKeys("silicagel1988");
    Thread.sleep(500);

    By enterCabinetLocator = By.xpath("/html/body/div[1]/div[2]/div/div[2]/form/div[3]/div/button");
    WebElement enterCabinetElement = driver.findElement(enterCabinetLocator);
    enterCabinetElement.click();
    Thread.sleep(1000);

    By addDeliveryLocator = By.xpath("/html/body/div[1]/div/div/div/div[1]/div/a[1]");
    WebElement addDeliveryElement = driver.findElement(addDeliveryLocator);
    addDeliveryElement.click();
    Thread.sleep(500);
//добавляем в поле текст
    By shipNameLocator = By.xpath("/html/body/div[1]/div[2]/div/div/div/form/div[1]/div[1]/span/div/div[1]/div[2]/input");
    WebElement shipNameElement = driver.findElement(shipNameLocator);
   shipNameElement.sendKeys("Some name");
   Thread.sleep(500);
//теперь проверим асссерт иквалс, что текст в поле таки присутствует. Иногда .getText() не работает, истользуем getAttribute("value")
    Assert.assertEquals(shipNameElement.getAttribute("value"), "Some name", "Text is not equal");
    Thread.sleep(1000);
    //теперь сотрем текст из поля и проверим, что оно пустое
    shipNameElement.clear();
    Thread.sleep(500);
    Assert.assertTrue(ExpectedConditions.attributeToBe(shipNameElement, "value", "").apply(driver));
//пример проверки, что поле дизейбл(нельзя ввести туда ничего, проверяем что энейблд, но АссертФолс
   // Assert.assertFalse(shipNameElement.isEnabled());
//тут Икспас пишем только название тэга (инпутс). Потом загоняем все инпут поля в Лист (коллекцию)
    //findElements - метод который возвращает Лист, потом по индексу можно обращаться
  //  By inputs = By.xpath("//input_data");
    //List<WebElement> secondInput = driver.findElements(inputs);
    //secondInput.get(1).sendKeys("second");
////*[@id="forward_order_name"]
    //searchFieldElement.sendKeys(Keys.ENTER);

////*[@id="forward_order_name"]
}
@AfterMethod
    public void closeDown (){
    driver.close();
    }

}
