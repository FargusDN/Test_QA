package Pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPage {

    private static final String FULL_URL  = "https://lmslite47vr.demo.mirapolis.ru/mira/Do?doaction=Go&s=6A7uqfzcGVMrcK73DIBv&id=0&type=customloginpage";

    private final SelenideElement usernameInput = $x("//input[@name='user']"); // поле логин

    private final SelenideElement passwordInput = $x("//input[@name='password']"); // поле пароля


    private final SelenideElement passwordReveal = $("#show_password"); // Глазик (Раскрытие пароля)
    private final SelenideElement submitButton = $x("//button[@type=\"submit\"]"); // Кнопка войти

    private final SelenideElement RemindPassword = $x("//a[@class= 'mira-default-login-page-link']"); //Забыли пароль


    public LoginPage open() {
        Selenide.open(FULL_URL);
        return this;
    }

    public LoginPage errorDisplayed() {
        String alertText = com.codeborne.selenide.Selenide.switchTo().alert().getText();
        assertTrue(alertText.contains("Неверные данные для авторизации"));
        com.codeborne.selenide.Selenide.switchTo().alert().accept();
        return this;
    }

    public LoginPage CheckLoginPage() {
        webdriver().shouldHave(urlContaining("customloginpage"));
        return this;
    }


    public LoginPage enterUsername(String user) {
        usernameInput.setValue(user);
        return this;
    }

    public LoginPage enterPassword(String pass) {
        passwordInput.setValue(pass);
        return this;
    }

    // Проверка срабатывания глазика
    public LoginPage PasswordReveal() {
        passwordReveal.click();
        return this;
    }

    // Проверка что пароль скрыт ****
    public LoginPage verifyPasswordIsHidden() {
        passwordInput.shouldHave(attribute("type", "password"));
        return this;
    }

    // Проверка что пароль открыт
    public LoginPage verifyPasswordIsVisible() {
        passwordInput.shouldHave(attribute("type", "text"));
        return this;
    }

    public void Reveal() {
        RemindPassword.click();
    }

    public void submit() {
        submitButton.click();
    }



}