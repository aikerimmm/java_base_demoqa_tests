package tests.examples;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import testdata.RegisterFormData;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
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
        $("[id=firstName]").setValue(RegisterFormData.userName);
        $("[id=lastName]").setValue(RegisterFormData.lastname);
        $("[id=userEmail]").setValue(RegisterFormData.userEmail);
        $("#genterWrapper").$(byText(RegisterFormData.genterWrapper)).click();
        $("[id=userNumber]").setValue(RegisterFormData.userNumber);
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__year-select").selectOption(RegisterFormData.birthYear);
        $(".react-datepicker__month-select").selectOption(RegisterFormData.birthMonth);
        $(".react-datepicker__month").$(byText(RegisterFormData.birthDate)).click();
        $("#subjectsInput").setValue(RegisterFormData.subjectsInput).pressEnter();
        $("#hobbiesWrapper").$(byText(RegisterFormData.hobbiesWrapper)).click();
        $("#uploadPicture").uploadFromClasspath(RegisterFormData.uploadPicture);;
        $("[id=currentAddress]").setValue(RegisterFormData.currentAddress);
        $("#state").scrollTo();
        actions().scrollByAmount(0, -200).perform();
        $("#state").click();
        $("#stateCity-wrapper").$(byText(RegisterFormData.stateCity)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(RegisterFormData.stateCity2)).click();
        $("#submit").click();


        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(RegisterFormData.userName));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text(RegisterFormData.userEmail));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(RegisterFormData.genterWrapper));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(RegisterFormData.userNumber));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text(RegisterFormData.birthDate));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text(RegisterFormData.subjectsInput));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text(RegisterFormData.hobbiesWrapper));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text(RegisterFormData.uploadPicture));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text(RegisterFormData.currentAddress));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text(RegisterFormData.stateCity));

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


