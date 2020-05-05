package test;

import com.codeborne.selenide.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

/**
 * Unit test for simple App.
 */
public class AppTest {

    public WebDriver driver;

    @Before
    public void before() {

        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-save-password-bubble");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        WebDriverRunner.setWebDriver(driver);
        Configuration.timeout = 3000;

    }

    @After
    public void After() {
        System.out.println("Тест завершен");
        WebDriverRunner.closeWebDriver();
    }

    @Test
    public void testLogin() throws InterruptedException {

        open("https://dev.n7lanit.ru/");
        $(By.xpath("//button[contains(text(), 'Войти')]/..")).should(Condition.visible).click();
        $(By.xpath("//div[@class='control-input']/input[@id='id_username']")).val("TestCor");
        $(By.xpath("//div[@class='control-input']/input[@id='id_password']")).val("1111111g").pressEnter();
        $(By.xpath("//*[@id=\"user-menu-mount\"]/ul/li[3]/a/img")).should(Condition.visible);

    }

    @Test
    public void randomTheme() throws InterruptedException {

        open("https://dev.n7lanit.ru/");
        ElementsCollection collection = $$(By.xpath("//span[@class='thread-detail-replies' and not(preceding-sibling::span)]/ancestor::div[3]/a"));
        collection.get((int) (collection.size()*Math.random())).click();
        Selenide.sleep(6000);
        $(By.xpath("//div[@class='col-sm-4 hidden-xs']/button[@class='btn btn-primary btn-block btn-outline']")).shouldHave(text("Ответить")).click();
        $(By.xpath("//textarea[@id='editor-textarea']")).shouldBe(Condition.visible).val("Новый интересный комментарий").submit();
        $(By.xpath("//div[@class='post-body']/article/p[contains(text(),'Новый интересный комментарий')]")).isDisplayed();
        $(By.xpath("//ul[@class='nav navbar-nav']//a[contains(text(),'Темы')]")).shouldBe(visible).click();

    }

    @Test
    public void newComment() throws InterruptedException {

        open("https://dev.n7lanit.ru/");
        ElementsCollection collection = $$(By.xpath("//span[@class='thread-detail-replies' and not(preceding-sibling::span)]/ancestor::div[3]/a"));
        collection.get((int) (collection.size()*Math.random())).click();
        Selenide.sleep(6000);
        $(By.xpath("//div[@class='col-sm-4 hidden-xs']/button[@class='btn btn-primary btn-block btn-outline']")).shouldHave(text("Ответить")).click();
        $(By.xpath("//textarea[@id='editor-textarea']")).shouldBe(Condition.visible).val("Самый новый комментарий").submit();
        $(By.xpath("//div[@class='post-body']/article/p[contains(text(),'Самый новый комментарий')]")).isDisplayed();
        $(By.xpath("//ul[@class='nav navbar-nav']//a[contains(text(),'Темы')]")).shouldBe(visible).click();

    }
}
