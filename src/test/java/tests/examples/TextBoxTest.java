package tests.examples;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import java.util.Locale;

import static testdata.TextBoxData.*;


public class TextBoxTest {
    TextBoxPage textBoxPage = new TextBoxPage();

    @BeforeAll
    static void prepareEnvironment() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";
    }


    @Test
    void successfulFillFormTest_with_faker() {
        Faker faker = new Faker();
        String userName = faker.name().fullName();
        String userEmail = faker.internet().emailAddress();
        String currentAddress = faker.address().fullAddress();
        String permanentAddress = faker.address().secondaryAddress();

        textBoxPage.openPage()
                .typeUserName(userName)
                .typeUserEmail(userEmail)
                .typeCurrentAddress(currentAddress)
                .typePermanentAddress(permanentAddress)
                .submitForm();

        textBoxPage.checkField("name", userName);
        textBoxPage.checkField("email", userEmail);
        textBoxPage.checkField("currentAddress", currentAddress);
        textBoxPage.checkField("permanentAddress", permanentAddress);

    }

//    @Test
//    void successfulFillFormTest() {
//        textBoxPage.openPage()
//                .typeUserName(userName)
//                .typeUserEmail(userEmail)
//                .typeCurrentAddress(currentAddress)
//                .typePermanentAddress(permanentAddress)
//                .submitForm();
//
//        textBoxPage.checkField("name", userName);
//        textBoxPage.checkField("email", userEmail);
//        textBoxPage.checkField("currentAddress", currentAddress);
//        textBoxPage.checkField("permanent", permanentAddress);
//
//    }
}