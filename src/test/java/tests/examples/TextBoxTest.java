package tests.examples;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
import testdata.TextBoxData;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static testdata.TextBoxData.userEmail;
import static testdata.TextBoxData.userName;
import static testdata.TextBoxData.currentAddress;
import static testdata.TextBoxData.permanentAddress;


public class TextBoxTest {
    TextBoxPage textBoxPage = new TextBoxPage();

    @BeforeAll
    static void prepareEnvironment() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";
    }

    @Test
    void successfulFillFormTest() {
        textBoxPage.openPage()
                .typeUserName(userName)
                .typeUserEmail(userEmail)
                .typeCurrentAddress(currentAddress)
                .typePermanentAddress(permanentAddress)
                .submitForm();

        textBoxPage.checkField("name", userName);
        textBoxPage.checkField("email", userEmail);
        textBoxPage.checkField("currentAddress", currentAddress);
        textBoxPage.checkField("permanent", permanentAddress);

    }
}