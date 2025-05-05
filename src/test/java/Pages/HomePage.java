package Pages;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class HomePage {

//    private staticic final String FULL_URL  = "https://lmslite47vr.demo.mirapolis.ru/mira/#&s=xGQN3A8QwphsErZFcMnG&stype=nps&name=%D0%93%D0%BB%D0%B0%D0%B2%D0%BD%D0%B0%D1%8F+%D1%81%D1%82%D1%80%D0%B0%D0%BD%D0%B8%D1%86%D0%B0&doaction=Go&id=0&type=myMeasureList";

    private final SelenideElement Profilemenu  = $x("//div[@data-mira-id=\"Template29\"]"); // Меню профилья
    private final SelenideElement ExitProfil = $x("//span[text()=\"Выйти\"]"); //Выход из аккаунта

    public HomePage Profilemenu_open() {
        Profilemenu.click();
        return this;
    }

    public HomePage ExitProfil() {
        ExitProfil.click();
        return this;
    }

    public HomePage CheckHomePage() {

        webdriver().shouldHave(urlContaining("myMeasureList"), Duration.ofSeconds(10));
        return this;
    }
}




