package TestsAllSelenium.Yahoo;

import Testdata.User;
import TestsAllSelenium.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.yahoo.HomePage;
import pages.yahoo.LoginPageYahoo;

public class YahooMail extends BaseTest {

    //ранее делали тут и ВебДрайвер и Бефор и АфтерМетод, потом перенесли в BaseTest

    //создаем методы. В методе создаем логинПейдж (стандартная)- куда передаем драйвер. И Логинпейдж(логин) передаем юзера.
    @Test
    public void sendEmailToMailinatorTest () throws InterruptedException {
        User user = new User("etorets", "Sobranie1990");
        LoginPageYahoo loginPage = new LoginPageYahoo(driver);
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
