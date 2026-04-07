package tests.examples;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import testdata.TextBoxData;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTest {
    @BeforeAll
    static void prepareEnvironment() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";
    }

    @Test
    void successfulFillFormTest() {
        open("https://demoqa.com/text-box");
        $("[id=userName]").setValue(TextBoxData.userName);
        $("[id=userEmail]").setValue(TextBoxData.userEmail);
        $("[id=currentAddress]").setValue(TextBoxData.currentAddress);
        $("[id=permanentAddress]").setValue(TextBoxData.permanentAddress);
        $("#submit").click();

        $("[id=output] [id=name]").scrollTo();
        actions().scrollByAmount(0, -200).perform();

        $("[id=output] [id=name]").shouldHave(text(TextBoxData.userName));
        $("[id=output] [id=email]").shouldHave(text(TextBoxData.userEmail));
        $("[id=output] [id=currentAddress]").shouldHave(text(TextBoxData.currentAddress));
        $("[id=output] [id=permanentAddress]").shouldHave(text(TextBoxData.permanentAddress));

    }

    @Test
    void invalidEmailTest() {
        open("https://demoqa.com/text-box");
        $("[id=userEmail]").setValue("koko");
        $("#submit").click();
        $("#userEmail").shouldHave(cssClass("field-error"));
    }
}