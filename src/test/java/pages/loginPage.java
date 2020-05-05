package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.annotations.Element;
import pages.annotations.Page;

import static com.codeborne.selenide.Selenide.$;


@Page(title = "Страница входа", url = " ")
public class loginPage extends AbstractPage {

    @Element("Логин")
    public SelenideElement inputLogin(){
        return $(By.xpath("//div[@class='control-input']/input[@id='id_username']"));
    }

    @Element("Пароль")
    public SelenideElement inputPassword(){
        return $(By.xpath("//div[@class='control-input']/input[@id='id_password']"));
    }

    @Element("Кнопка войти")
    public SelenideElement buttonSignIn(){
        return $(By.xpath("//*[@class='modal-footer']/button")).should(Condition.visible);
    }

}
