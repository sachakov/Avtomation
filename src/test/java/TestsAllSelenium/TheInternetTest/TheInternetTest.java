package TestsAllSelenium.TheInternetTest;

import Testdata.User;
import TestsAllSelenium.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.theInternet.InternetLoginPage;

public class TheInternetTest extends BaseTest {

    //делаем негативный тест, что появляется Эррор
    @Test(dataProvider = "userCredentialsDataProvider")//вписали ДатаПровайдер, когда сделали его
    //@Test(dataProvider = "userCredentialsDataProvider", dataProviderClass = DataProviders.class)
    //строчка выше, если храним ДатаПровайдер в отдельном классе, то надо указать не только его имя Но и класс, где хранится
    public void errorMessageShouldAppear(String login, String password, String errorMessage){  //вписали параметры, после того как сделали ДатаПровайдер
        User user = new User("tomsmith", "quertyio");//передаем юзера с неверными кредами
        InternetLoginPage internetLoginPage = new InternetLoginPage(driver); //создаем страницу
        internetLoginPage.navigate();// переходим на страницу
        internetLoginPage.login(user);//логинимся, дальше этот кусок кода от логин(юзер) до проверки можно размножить для других проверок
        Assert.assertEquals(internetLoginPage.getErrorMessage(), errorMessage);
           //     "Your password is invalid!\n×", это убрали, после того как ввели дата провайдер
           //     "Test failed"); это убрали, после того как ввели дата провайдер, а в основное выражение добавили просто errorMessage)

    }
    @DataProvider
         public Object [][] userCredentialsDataProvider (){ //готовим тестовые данные в двумерном массиве
        return new Object[][]{
                {"tomsmith", "quertio", "Your password is invalid!\n×"},
                {"quertio", "SecretPass", "YYour password is invalid!\n×"},
                {"Tomsmith", "quertio", "Your password is invalid!\n×"},
                {"tomsmith", "1quertiowee", "Your password is invalid!\n×"}
        };
}
}
