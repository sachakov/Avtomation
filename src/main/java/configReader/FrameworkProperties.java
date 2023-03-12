package configReader;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:framework_config.properties")//аннотацией указываем какой файл надо читать проперти
//БЫЛ ПРОБЕЛ ПОСЛЕ classpath И БЫЛ НОПОИНТЕР!!!
public interface FrameworkProperties extends Config {
//дальше надо для каждой строки проперти объявить метод

    @Key("foo.bar") //указали ключ, какую строку из проперти брать этим методом
    String getFooBar(); //метод для чтени стринги из проперти
    //в проперти ключ - foo.bar, а значение - Hello World

    @Key("seleniumm.timeout")
    int getTimeout(); //метод для чтени инта из проперти
}
