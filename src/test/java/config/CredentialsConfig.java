package config;

import org.aeonbits.owner.Config;
/*Библиотека Owner
Owner позволяет убирать из кода приватные данные и прятать их. В качестве таких данных могут быть пароли, логины, имена пользователей, адреса хостов, ключи и другие параметры.

Как подключить
В Gradle-файл добавляем следующее:

dependencies {
    testImplementation(
            "org.aeonbits.owner:owner:1.0.12",
    )
}*/
/*Работа с Owner
Сначала надо создать и заполнить файл из которого мы будем брать данные. Файл создается по следующему пути:
src -> test -> resources -> config -> credentials.properties
Расширение файла обязательно должно быть .properties.

Далее в файле указываем все необходимые данные следующим образом:

login=admin
password=admin
Чтобы все это заработало необходимо создать класс CredentialsConfig в папке config и заполнить его таким образом:

@Config.Sources("classpath:config/credentials.properties")
public interface CredentialsConfig extends Config {
    String login();
    String password();
}
А в классе теста следует создать экземпляр класса CredentialsConfig и тогда мы сможем обращаться к данным из Owner-файла.

public class OwnerTests {
    CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);

    @Test
    @Tag("owner")
    void loginTest() {
        String login = config.login();
        String password = config.password();
    }
}
Owner-файл также можно добавить в сборку Jenkins.*/
@Config.Sources({"classpath:config/credentials.properties"})
public interface CredentialsConfig extends Config {
    String login();
    String password();
}
