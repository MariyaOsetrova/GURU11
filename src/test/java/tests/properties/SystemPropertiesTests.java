package tests.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {
    @Test
    void someTest() {
        String value = System.getProperty("value"); // внутреннее хранилище переменных. используется что бы данные из вне прокинуть
        System.out.println(value); // вывлдим в консоль
        // выводится в консоль null
    }

    @Test
    void someTest1() {
        String value = System.getProperty("value", "default_value");
        System.out.println(value);
        // выводится в консоль  default_value
    }

    @Test
    void someTest2() {
        System.setProperty("value", "another_value");
        String value = System.getProperty("value");
        System.out.println(value);
        // выводится в консоль   another_value
    }

    @Test
    void someTest3() {
        System.setProperty("value", "another_value");
        String value = System.getProperty("value", "default_value"); //(дефолтное значение )
        System.out.println(value);
        // ?
        //  выводится в консоль   another_value !
    }

    @Test
    @Tag("properties")
    void someTest4() {
        String value = System.getProperty("browser", "chrome"); // // Записываем значение ключа browser в строковую переменную
        System.out.println(value);
        //  gradle clean properties_tests
        //  chrome

        //  gradle clean properties_tests -Dbrowser=opera -- вводить через терминал
        //  opera
    }

    @Test
    @Tag("properties")
    void someTest5() {
        String browser = System.getProperty("browser", "chrome");
        String version = System.getProperty("version", "91");
        String browserSize = System.getProperty("browserSize", "300x300");

        System.out.println(browser);
        System.out.println(version);
        System.out.println(browserSize);

        // gradle clean properties_tests -Dbrowser=opera -Dversion=93
    }
}
