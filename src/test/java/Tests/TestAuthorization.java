package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RemindPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;



public class TestAuthorization extends BaseTest {

    private LoginPage loginPage;
    private HomePage homePage;
    private RemindPage remindPage;

    @BeforeEach
    void setUp() {
        loginPage = new LoginPage();
        homePage = new HomePage();
        remindPage = new RemindPage();

    }

    // Проверка работающих аккаунтов c выходом из аккаунта
    @ParameterizedTest
    @CsvSource({
            "fominaelena, 1P73BP4Z"
    })
    void testSuccessfulLogin(String user, String pass) {
        loginPage
                .open()
                .CheckLoginPage()
                .enterUsername(user)
                .enterPassword(pass)
                .submit();
        homePage
                .CheckHomePage()
                .Profilemenu_open()
                .ExitProfil();
        loginPage.CheckLoginPage();

    }


    // Проверка НЕ работающих аккаунтов
    @ParameterizedTest
    @CsvSource({
            "fominaelena, 1fsdfs",
            "sdasdfds, 1P73BP4Z",


    })
    void testFailLogin(String user, String pass) {
        loginPage
                .open()
                .CheckLoginPage()
                .enterUsername(user)
                .enterPassword(pass)
                .submit();
        loginPage.errorDisplayed();
    }


    // Проверка работы раскрытия пароля
    @Test
    void testPasswordReveal() {
        loginPage
                .open()
                .CheckLoginPage()
                .enterPassword("1P73BP4Z")
                .verifyPasswordIsHidden()
                .PasswordReveal()
                .verifyPasswordIsVisible();
    }


    //Проверка перехода на страницу востановления пароля
    @Test
    void test_loginPage_transition_RemindPage() {
        loginPage
                .open()
                .CheckLoginPage()
                .Reveal();
        remindPage
                .CheckRemindPage()
                .go_login_page();
        loginPage.CheckLoginPage();
    }

}

