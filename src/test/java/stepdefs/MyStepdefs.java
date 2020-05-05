package stepdefs;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideWait;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Затем;
import cucumber.api.java.ru.Также;
import org.openqa.selenium.By;
import static pages.AbstractPage.getPageByTitle;
import static pages.AbstractPage.getUrlByTitle;
import static test.strings.userMessage;
import static test.strings.userLogin;
import static test.strings.userPassword;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class MyStepdefs {

    @И("Начинаем тест")
    public void начинаемТест() {

        System.out.println("Старт теста");

    }

    @И("Открываем главную страницу {string}")
    public void открываемСайт(String site) throws ClassNotFoundException, InterruptedException  {

        open(getUrlByTitle(site));

    }

    @И("На странице {string} выполняем поиск кнопки {string}")
    public void поискКнопкиВойти(String str, String nameEL) throws ClassNotFoundException,InterruptedException {

        System.out.println("Находим кнопку Войти");
        getPageByTitle(str).getElementByName(nameEL).click();

    }

    @Затем("на странице {string} вводим логин {string}")
    public void вводимЛогин(String str, String login) throws ClassNotFoundException, InterruptedException {

        System.out.println("Процесс авторизации");
        getPageByTitle(str).getElementByName(login).val(userLogin);

    }

    @Также("на странице {string} вводим пароль {string}")
    public void вводимПароль(String str, String pass) throws ClassNotFoundException, InterruptedException {

        getPageByTitle(str).getElementByName(pass).val(userPassword).pressEnter();

    }

    @И("На главной странице {string} проверяем наличие иконки {string}")
    public void проверяемАвторизацию(String str, String icon) throws ClassNotFoundException, InterruptedException {

        System.out.println("Проверяем авторизацию");
        Selenide.sleep(3000);
        getPageByTitle(str).getElementByName(icon).should(Condition.image);

    }
    @Затем("на странице {string} откроем случайную тему {string}")
    public void откроемСлучайнуюТему(String str, String page) throws ClassNotFoundException {

        System.out.println("Находим случайную тему");
        Selenide.sleep(6000);
        getPageByTitle(str).getElementByName(page).should(Condition.visible).click();

    }


    @И("На странице {string} найдем и кликнем по кнопке {string}")
    public void наСтраницеНайдемИКликнемПоКнопке(String str, String answer) throws ClassNotFoundException {
        System.out.println("Клик по кнопке Ответить");
        getPageByTitle(str).getElementByName(answer).should(Condition.visible).click();

    }


    @И("На странице {string} напишем комментарий {string}")
    public void наСтраницеНапишемКомментарий(String str, String text) throws ClassNotFoundException {
        System.out.println("Оставляем комментарий");
        getPageByTitle(str).getElementByName(text).val(userMessage).submit();

    }

    @И("На странице {string} проверим наличие комментария {string}")
    public void наСтраницеПроверимНаличиеКомментария(String str, String checkAnswer) throws ClassNotFoundException {

        System.out.println("Проверяем наличие комментария");
        getPageByTitle(str).getElementByName(checkAnswer).should(Condition.visible);

    }

    @Затем("на странице {string} перейдем на страницу с темами {string}")
    public void наСтраницеПерейдемНаСтраницуСТемами(String str, String bar) throws ClassNotFoundException {

        System.out.println("Переход на страницу с темами");
        getPageByTitle(str).getElementByName(bar).should(Condition.visible).click();

    }

    @Также("повторим комментарий")
    public void повторимКомментарий() {



    }
}
