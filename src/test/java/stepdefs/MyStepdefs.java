package stepdefs;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import cucumber.api.java.ru.Затем;
import cucumber.api.java.ru.И;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MyStepdefs {


    @И("Начинаем тест {string}")
    public void начинаемТест(String arg0) {

        System.out.println("Начинаем тест");

    }



    @И("Открываем сайт")
    public void открываемСайт() {

        open("https://dev.n7lanit.ru/");

    }

    @И("Выполняем поиск кнопки Войти")
    public void выполняемПоискКнопкиВойти() {

        $(By.xpath("//button[contains(text(), 'Войти')]/..")).should(Condition.visible).click();

    }

    @Затем("Проходим авторизацию")
    public void проходимАвторизацию() {

        $(By.xpath("//*[@id='id_username']")).should(Condition.visible).sendKeys("TestCor");
        $(By.xpath("//*[@id='id_password']")).should(Condition.visible).sendKeys("1111111g");
        $(By.xpath("//button[@class='btn btn-primary btn-block']")).should(Condition.visible).click();

    }

    @И("Производим проверку авторизации")
    public void производимПроверкуАвторизации() {

        $(By.xpath("//*[@id=\"user-menu-mount\"]/ul/li[3]/a/img")).shouldBe(Condition.visible);

    }

    @И("Ищем случайную тему")
    public void ищемСлучайнуюТему() {

        Selenide.sleep(4000);
        $(By.xpath("//button/span[contains(text(), 'Категория')]/..")).should(Condition.visible).click();
        $(By.xpath("//a[@class='btn btn-link']")).should(Condition.visible).click();

        ElementsCollection collection = $$(By.xpath("//span[@class='thread-detail-replies' and not(preceding-sibling::span)]/ancestor::div[3]/a"));
        collection.get((int) (collection.size()*Math.random())).click();

    }

    @И("Выполняем поиск кнопки Ответить и кликаем на неё")
    public void выполняемПоискКнопкиОтветитьИКликаемНаНеё() {

        $(By.xpath("//div[@class='col-sm-4 hidden-xs']/button[@class='btn btn-primary btn-block btn-outline']")).shouldHave(text("Ответить")).click();

    }

    @И("Оставляем комментарий")
    public void оставляемКомментарий() {

        $(By.xpath("//textarea[@id='editor-textarea']")).shouldBe(Condition.visible).val("Интересный текст для сообщения").submit();

    }

    @И("Выполняем проверку наличия комментария")
    public void выполняемПроверкуНаличияКомментария() {

        $(By.xpath("//div[@class='post-body']/article/p[contains(text(),'Интересный текст для сообщения')]")).isDisplayed();

    }

    @Затем("Переходим во вкладку темы")
    public void переходимВоВкладкуТемы() {

        $(By.xpath("//ul[@class='nav navbar-nav']//a[contains(text(),'Темы')]")).shouldBe(Condition.visible).click();

    }

    @Затем("Повторяем шаги комментария")
    public void повторяемШагиКомментария() {

        ElementsCollection collection = $$(By.xpath("//span[@class='thread-detail-replies' and not(preceding-sibling::span)]/ancestor::div[3]/a"));
        collection.get((int) (collection.size()*Math.random())).shouldBe(Condition.visible).click();
        $(By.xpath("//div[@class='col-sm-4 hidden-xs']/button[@class='btn btn-primary btn-block btn-outline']")).shouldHave(text("Ответить")).click();
        Selenide.sleep(6000);
        $(By.xpath("//textarea[@id='editor-textarea']")).shouldBe(Condition.visible).val("Другой интересный текст для сообщения").submit();
        $(By.xpath("//div[@class='post-body']/article/p[contains(text(),'Другой интересный текст для сообщения')]")).isDisplayed();

    }
}
