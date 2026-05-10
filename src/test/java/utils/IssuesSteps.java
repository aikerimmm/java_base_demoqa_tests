package utils;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class IssuesSteps {

        @Step("Открыть страницу Issues")
        public void openIssuesPage() {
            open("https://github.com/aikerimmm/java_base_demoqa_tests/issues");
        }

        @Step("Проверить название issue")
        public void checkIssueTitle(String title) {
            $(withText(title)).should(exist);
        }
    }

