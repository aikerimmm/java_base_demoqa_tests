package tests.examples;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class IssuesTest {

    @BeforeAll
    static void prepareEnvironment() {
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @Test
    void issuesTitleTest() {
        open("https://github.com/aikerimmm/java_base_demoqa_tests/issues");
        $(withText("First issue")).should(Condition.exist);
    }
}