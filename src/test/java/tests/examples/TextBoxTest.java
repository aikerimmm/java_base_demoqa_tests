package tests.examples;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
import utils.RandomUtils;

import java.util.Locale;

import static testdata.TextBoxData.*;
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

//    @Test
//    void successfulFillFormTest_with_faker() {
//        Faker faker = new Faker();
//        String userName = faker.name().fullName();
//        String userEmail = faker.internet().emailAddress();
//        String currentAddress = faker.address().fullAddress();
//        String permanentAddress = faker.address().secondaryAddress();
//
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
//        textBoxPage.checkField("permanentAddress", permanentAddress);
//
//    }

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