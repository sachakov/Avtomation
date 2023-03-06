package Tests.All.TheInternetTest;

import Testdata.User;
import Tests.All.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.theInternet.InternetLoginPage;

public class TheInternetTest extends BaseTest {

    //делаем негативный тест, что появляется Эррор


    @Test
    public void errorMessageShouldAppear(){
        User user = new User("tomsmith", "quertyio");//передаем юзера с неверными кредами
        InternetLoginPage internetLoginPage = new InternetLoginPage(driver); //создаем страницу
        internetLoginPage.navigate();// переходим на страницу
        internetLoginPage.login(user);//логинимся
        Assert.assertEquals(internetLoginPage.getErrorMessage(),
                "Your password is invalid!\n×",
                "Test failed");

    }

}
