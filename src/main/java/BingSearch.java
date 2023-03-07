import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class BingSearch {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("selenium.chrome.driver", "chromedriver.exe");

        //создаем объект типа ВебДрайвер. КОнкретный инстанс Хромдрайвер. Сам по себе Вебдрайвер - интерфейс;
        //теперь с этим объектом Драйвер можем работать как с браузером, у него есть все методы.

        WebDriver driver = new ChromeDriver();
        //зададим переменную бейсЮрл куда будет навигироваться запрос
        String baseUrl = "https://www.bing.com/";
        //Как сделать, чтобы эту ЮРЛ открыл драйвер?
        driver.get(baseUrl);
        //дальше ждем 4 сек (в миллисек) и потом переходим на сайт Розетки. Чтобы на sleep не делать трай-кетч
        //развернуть вкладку на весь экран
        driver.manage().window().maximize();

//локаторы хранятся в классе/типе данных By (бай), конструктора нет, пользуемся методами By.xpath и By.id равнозначны (адреса эл-тов);
        //id также могли бы найти на html странице, но айди есть не всегда! By.id не отдельный локатор, java его потом преобразует в css
        By searchFieldLocator = By.xpath("//textarea[@id='sb_form_q']");
//адрес эл-та есть, но чтобы к нему обратиться, надо сахранить его под типом данных web element

        WebElement searchFieldElement = driver.findElement(searchFieldLocator);

        //чтобы ввести данные в этот эл-то пользуемся методом sendKeys (имитация клавы, можно даже код F5 для перезагрузки стр.
        searchFieldElement.sendKeys("How to sew the leather");
        searchFieldElement.sendKeys(Keys.ENTER);



        /*это обязательно для этого метода, в метод Мейн тулим throws...
        Thread.sleep(4000); // засыпааай, под пенье дождя
        теперь закроем окно командой клосе
        driver.close();*/


        /*для открытия в новом окне, делаем новый экземпляр класса Драйвер
        driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua");*/


    }
}
