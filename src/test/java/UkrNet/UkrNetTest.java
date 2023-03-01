package UkrNet;

import Testdata.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class UkrNetTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp(){
        System.setProperty("selenium.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
    }


    //создаем методы. В методе создаем логинПейдж (стандартная)- куда передаем драйвер. И Логинпейдж(логин) передаем юзера.
    @Test
    public void sendEmailToMailinatorTest () throws InterruptedException {
        User user = new User("etorets", "Sobranie1990");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigate();
        driver.manage().window().maximize();
        loginPage.login(user);
//делаем проверку, что попали на правильный юрл
        HomePage homePage = new HomePage(driver);
        homePage.waitUntilLoaded();
       // Assert.assertTrue(driver.getCurrentUrl().contains(homePage.getPageUrl()), "URL is not good");
        homePage.writeEmail("kovalinskyi@gmail.com", "first auto-email", "hello MTF yoh");
        homePage.sendMail();
        Assert.assertEquals(homePage.getTestSortuvaty(), "Сортувати"); //проверка, что есть поле СОртувати
    }

}
