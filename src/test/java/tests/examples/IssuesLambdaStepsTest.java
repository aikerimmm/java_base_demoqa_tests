package tests.examples;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class IssuesLambdaStepsTest {

    @BeforeAll
    static void prepareEnvironment() {
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
    }

    @Test
    void issuesTitleTest() {
        step("Открыть страницу Issues", () -> {
            open("https://github.com/aikerimmm/java_base_demoqa_tests/issues");
        });

        step("Проверить название issue", () -> {
            $(withText("First issue")).should(exist);
        });
    }
}


