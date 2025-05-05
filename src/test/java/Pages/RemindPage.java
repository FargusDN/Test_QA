package Pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;


public class RemindPage {

//    private static final String FULL_URL  = "https://lmslite47vr.demo.mirapolis.ru/mira//Do?doaction=Go&s=FvkU3GxNSkSee4z0wqLs&id=0&type=remindpassword";

    private final SelenideElement exittoLoginPage = $x("//a[@class='mira-page-forgot-password-link']"); // Возврат обратно на стр авторизации

    public RemindPage go_login_page() {
        exittoLoginPage.click();
        return this;
    }

    public RemindPage CheckRemindPage() {
        webdriver().shouldHave(urlContaining("remindpassword"), Duration.ofSeconds(10));
        return this;
    }

}