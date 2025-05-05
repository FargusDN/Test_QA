package Tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseTest {
    @BeforeAll
    static void setUpAll() {
        Configuration.headless = true;
        Configuration.browser = "Chrome";
        Configuration.timeout = 5000;

    }
}