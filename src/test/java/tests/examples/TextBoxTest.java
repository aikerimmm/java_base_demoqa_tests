package tests.examples;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import static utils.RandomUtils.getRandomEmail;
import static utils.RandomUtils.getRandomString;


public class TextBoxTest {
    TextBoxPage textBoxPage = new TextBoxPage();

    @BeforeAll
    static void prepareEnvironment() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";
    }


        String userNameU;
        String userEmailU;
        String currentAddressU;
        String permanentAddressU;

        @BeforeEach
        void prepareRandomData() {
            userNameU = getRandomString(10);
            userEmailU = getRandomEmail();
            currentAddressU = getRandomString(100);
            permanentAddressU = getRandomString(90);

        }

        @Test
        void successfulFillFormTest_with_utils_with_before_each() {
        textBoxPage.openPage()
                .typeUserName(userNameU)
                .typeUserEmail(userEmailU)
                .typeCurrentAddress(currentAddressU)
                .typePermanentAddress(permanentAddressU)
                .submitForm();

        textBoxPage.checkField("name", userNameU);
        textBoxPage.checkField("email", userEmailU);
        textBoxPage.checkField("currentAddress", currentAddressU);
        textBoxPage.checkField("permanentAddress", permanentAddressU);

    }
}