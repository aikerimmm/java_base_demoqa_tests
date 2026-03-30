package tests.examples;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTest {
    @BeforeAll
    static void prepareEnvironment() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successfulFillFormTest() {
        open("https://demoqa.com/text-box");
        $("[id=userName]").setValue("Aikerim");
        $("[id=userEmail]").setValue("aikerim.879@gmail.com");
        $("[id=currentAddress]").setValue("Nurkamal 14/2");
        $("[id=permanentAddress]").setValue("Povarinskaya ");
        $("#submit").click();

        $("[id=output] [id=name]").scrollTo();
        actions().scrollByAmount(0, -200).perform();

        $("[id=output] [id=name]").shouldHave(text("Aikerim"));
        $("[id=output] [id=email]").shouldHave(text("aikerim.879@gmail.com"));
        $("[id=output] [id=currentAddress]").shouldHave(text("Nurkamal 14/2"));
        $("[id=output] [id=permanentAddress]").shouldHave(text("Povarinskaya"));

    }

    @Test
    void invalidEmailTest() {
        open("https://demoqa.com/text-box");
        $("[id=userEmail]").setValue("koko");
        $("#submit").click();
        $("#userEmail").shouldHave(cssClass("field-error"));
    }
}