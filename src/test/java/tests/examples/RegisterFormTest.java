package tests.examples;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegisterFormTest {
    @BeforeAll
    static void prepareEnvironment() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void filledFormTest(){
        open("https://demoqa.com/automation-practice-form");
        $("[id=firstName]").setValue("Amir");
        $("[id=lastName]").setValue("Dastan");
        $("[id=userEmail]").setValue("amir@gmail.com");
        $("label[for='gender-radio-1']").click();
        $("[id=userNumber]").setValue("0559118799");
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__year-select").selectOption("1999");
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__month").$(byText("15")).click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("[id=hobbies-checkbox-1]").click();
        $("[id=uploadPicture]").uploadFile(new File("src/test/resources/IMG_1075.JPG"));
        $("[id=currentAddress]").setValue("Nurkamal 14/2");
        $("#state").scrollTo();
        actions().scrollByAmount(0, -200).perform();
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Gurgaon")).click();
        $("#submit").click();



        $(By.xpath("//td[text()='Student Name']/following-sibling::td"))
                .shouldHave(text("Amir Dastan"));
        $(By.xpath("//td[text()='Student Email']/following-sibling::td"))
                .shouldHave(text("amir@gmail.com"));
        $(By.xpath("//td[text()='Gender']/following-sibling::td"))
                .shouldHave(text("Male"));
        $(By.xpath("//td[text()='Mobile']/following-sibling::td"))
                .shouldHave(text("0559118799"));
        $(By.xpath("//td[text()='Date of Birth']/following-sibling::td"))
                .shouldHave(text("15 July,1999"));
        $(By.xpath("//td[text()='Subjects']/following-sibling::td"))
                .shouldHave(text("English"));
        $(By.xpath("//td[text()='Hobbies']/following-sibling::td"))
                .shouldHave(text("Sports"));
        $(By.xpath("//td[text()='Picture']/following-sibling::td"))
                .shouldHave(text("IMG_1075.JPG"));
        $(By.xpath("//td[text()='Address']/following-sibling::td"))
                .shouldHave(text("Nurkamal 14/2"));
        $(By.xpath("//td[text()='State and City']/following-sibling::td"))
                .shouldHave(text("NCR Gurgaon"));

        $("#closeLargeModal").click();


    }

    @Test
    void requiredFormTest(){
        open("https://demoqa.com/automation-practice-form");
        $("[id=firstName]").setValue("Amir");
        $("[id=lastName]").setValue("Dastan");
        $("label[for='gender-radio-1']").click();
        $("[id=userNumber]").setValue("0559118799");
        $("#state").scrollTo();
        actions().scrollByAmount(0, -200).perform();
        $("#submit").click();


        $(By.xpath("//td[text()='Student Name']/following-sibling::td"))
                .shouldHave(text("Amir Dastan"));
        $(By.xpath("//td[text()='Gender']/following-sibling::td"))
                .shouldHave(text("Male"));
        $(By.xpath("//td[text()='Mobile']/following-sibling::td"))
                .shouldHave(text("0559118799"));

        $("#closeLargeModal").click();


    }

    @Test
    void successfulFillFormTest() {
        open("https://demoqa.com/automation-practice-form");
        $("[id=firstName]").setValue("Amir");
        $("[id=lastName]").setValue("Dastan");
        $("label[for='gender-radio-1']").click();
        $("[id=userNumber]").setValue("0559118799");
        $("#state").scrollTo();
        actions().scrollByAmount(0, -200).perform();
        $("#submit").click();


        $(By.xpath("//td[text()='Student Name']/following-sibling::td"))
                .shouldHave(text("Amir Dastan"));
        $(By.xpath("//td[text()='Gender']/following-sibling::td"))
                .shouldHave(text("Male"));
        $(By.xpath("//td[text()='Mobile']/following-sibling::td"))
                .shouldHave(text("0559118799"));

        $("#closeLargeModal").click();


    }

    @Test
    void invalidEmailTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Amir");
        $("#lastName").setValue("Dastan");
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue("1234567890");
        $("#userEmail").setValue("amir");
        $("#state").scrollTo();
        actions().scrollByAmount(0, -200).perform();

        $("#submit").click();

        $(".modal-content").shouldNot(appear);

    }

    @Test
    void emptyFirstNameTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("");
        $("#lastName").setValue("Dastan");
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue("1234567890");
        $("#userEmail").setValue("amir");
        $("#state").scrollTo();
        actions().scrollByAmount(0, -200).perform();

        $("#submit").click();

        $(".modal-content").shouldNot(appear);

    }

    @Test
    void emptyLastNameTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Amir");
        $("#lastName").setValue("");
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue("1234567890");
        $("#userEmail").setValue("amir");
        $("#state").scrollTo();
        actions().scrollByAmount(0, -200).perform();

        $("#submit").click();

        $(".modal-content").shouldNot(appear);

    }
}


