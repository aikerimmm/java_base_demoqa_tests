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
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";
    }


    @Test
    void filledFormTest(){
        open("/automation-practice-form");
        $("[id=firstName]").setValue("Amir");
        $("[id=lastName]").setValue("Dastan");
        $("[id=userEmail]").setValue("amir@gmail.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("[id=userNumber]").setValue("0559118799");
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__year-select").selectOption("1999");
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__month").$(byText("15")).click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("IMG_1075.JPG");;
        $("[id=currentAddress]").setValue("Nurkamal 14/2");
        $("#state").scrollTo();
        actions().scrollByAmount(0, -200).perform();
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Gurgaon")).click();
        $("#submit").click();


        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Amir Dastan"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("amir@gmail.com"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("0559118799"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("15 July,1999"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("English"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("IMG_1075.JPG"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("Nurkamal 14/2"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("NCR Gurgaon"));

        $("#closeLargeModal").click();


    }

    @Test
    void requiredFormTest(){
        open("/automation-practice-form");
        $("[id=firstName]").setValue("Amir");
        $("[id=lastName]").setValue("Dastan");
        $("#genterWrapper").$(byText("Male")).click();
        $("[id=userNumber]").setValue("0559118799");
        $("#state").scrollTo();
        actions().scrollByAmount(0, -200).perform();
        $("#submit").click();

        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Amir Dastan"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("0559118799"));

        $("#closeLargeModal").click();


    }

    @Test
    void successfulFillFormTest() {
        open("/automation-practice-form");
        $("[id=firstName]").setValue("Amir");
        $("[id=lastName]").setValue("Dastan");
        $("#genterWrapper").$(byText("Male")).click();
        $("[id=userNumber]").setValue("0559118799");
        $("#state").scrollTo();
        actions().scrollByAmount(0, -200).perform();
        $("#submit").click();


        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Amir Dastan"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("0559118799"));

        $("#closeLargeModal").click();


    }

    @Test
    void invalidEmailTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Amir");
        $("#lastName").setValue("Dastan");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#userEmail").setValue("amir");
        $("#state").scrollTo();
        actions().scrollByAmount(0, -200).perform();

        $("#submit").click();

        $(".modal-content").shouldNot(appear);

    }

    @Test
    void emptyFirstNameTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("");
        $("#lastName").setValue("Dastan");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#userEmail").setValue("amir");
        $("#state").scrollTo();
        actions().scrollByAmount(0, -200).perform();

        $("#submit").click();

        $(".modal-content").shouldNot(appear);

    }

    @Test
    void emptyLastNameTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Amir");
        $("#lastName").setValue("");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#userEmail").setValue("amir");
        $("#state").scrollTo();
        actions().scrollByAmount(0, -200).perform();

        $("#submit").click();

        $(".modal-content").shouldNot(appear);

    }
}


