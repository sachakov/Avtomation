package configTest;

import configReader.FrameworkProperties;
import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.Test;

public class ConfigTest {
//Интерфейс содержит абстрактные методы. И для того, чтобы создать объект, нам надо создать класс, который будет
    //имплементировать этот интерфейс, и который будет реализовывать эти методы. У нас тут интерфейс FrameworkProperteis.
    //Owner может это сделать за нас. Он создаст анонимный класс, имплементирует этот интерфейс и напишет реализацию для этих методов.
    //Чтобы создать объект типа frameworkProperties у Owner есть ConfigFactory спец класс

    @Test
    public void ownerConfigTest(){
        FrameworkProperties frameworkProperties =               //ConfigFactory спец класс в Овнере, который создаст объект
                ConfigFactory.create(FrameworkProperties.class); //в метод креейт передаем класс объекта, который хотим создать
        System.out.println(frameworkProperties.getFooBar());
        System.out.println(frameworkProperties.getTimeout());
    }
}
