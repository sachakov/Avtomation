package TestsAllSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

//когда создали папку для второго теста, поняли, что Бефор и Афтер тест надо повторить, а это значит, можно загнать в
//общий класс Tests.YahooTess.BaseTest (но не абстрактный хз).с !Должен находиться в одной папке с тестами наследниками

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp(){
        System.setProperty("selenium.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
