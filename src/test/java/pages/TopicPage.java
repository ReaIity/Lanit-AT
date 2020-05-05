package pages;

import static  test.strings.userMessage;
import static test.strings.userLogin;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import pages.annotations.Element;
import pages.annotations.Page;

import static com.codeborne.selenide.Selenide.$;


import static com.codeborne.selenide.Selenide.$;


@Page(title = "Страница топик", url = "")
public class TopicPage extends AbstractPage{

    @Element("Ответить")
       public SelenideElement buttonAnswerClick() {
          return  $(By.xpath("//div[@class='col-sm-4 hidden-xs']/button[@class='btn btn-primary btn-block btn-outline']"));
       }
    @Element("Текст")
       public SelenideElement inputTextBox(){
           return $(By.xpath("//textarea[@id='editor-textarea']"));
       }

    @Element("Отправить ответ")
       public SelenideElement sendResponse() {
           return $(By.xpath("//*[@id='posting-mount']//*[text()='Отправить ответ']"));
       }
    @Element("Ответ")
       public SelenideElement checkMessageIsDisplayed(){
           return $(By.xpath("//*[@class='panel-body']//*[text()='" + userLogin+ "' and '" + userMessage + "']"));
       }
    @Element("Темы")
       public SelenideElement goToMainPage() {
           return $(By.xpath("//ul[@class='nav navbar-nav']//a[contains(text(),'Темы')]"));
       }

}
