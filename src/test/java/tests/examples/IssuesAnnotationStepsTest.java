package tests.examples;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utils.IssuesSteps;

public class IssuesAnnotationStepsTest {


    @BeforeAll
    static void prepareEnvironment() {
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
    }

    @Test
    void issuesTitleTest() {
        IssuesSteps steps = new IssuesSteps();
        steps.openIssuesPage();
        steps.checkIssueTitle("First issue");
    }

}
