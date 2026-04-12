package tests.examples;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegisterPage;
import testdata.RegisterFormData;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static testdata.RegisterFormData.*;

public class RegisterFormTest {
    RegisterPage registerPage = new RegisterPage();
    @BeforeAll
    static void prepareEnvironment() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";
    }


    @Test
    void filledFormTest(){
        registerPage .openPage()
                .typeFirstName("Alex")
                .typeLastName("Karlov")
                .typeUserEmail("alex@gmail.com")
                .setGender("Other")
                .typeUserNumber("0559118799")
                .setDateOfBirth("30","July","2008")
                .setSubject("Math")
                .setHobbies("Reading")
                .uploadPicture("img/1.png")
                .typecurrentAddress("Nurkamal 14/2")
                .setStateAndCity("NCR", "Delhi")
                .submitForm()
                .checkSuccessSubmitText()
                .checkFormResults("Student Name",userName)
                .checkFormResults("Student Email",userEmail)
                .checkFormResults("Gender",genterWrapper)
                .checkFormResults("Mobile",userNumber)
                .checkFormResults("Date of Birth",birthDate)
                .checkFormResults("Subjects",subjectsInput)
                .checkFormResults("Hobbies",hobbiesWrapper)
                .checkFormResults("Picture",uploadPicture)
                .checkFormResults("Address",currentAddress)
                .checkFormResults("State and City",stateCity)
                .closeForm();


    }

//    @Test
//    void requiredFormTest(){
//        open("/automation-practice-form");
//        $("[id=firstName]").setValue("Amir");
//        $("[id=lastName]").setValue("Dastan");
//        $("#genterWrapper").$(byText("Male")).click();
//        $("[id=userNumber]").setValue("0559118799");
//        $("#state").scrollTo();
//        actions().scrollByAmount(0, -200).perform();
//        $("#submit").click();
//
//        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Amir Dastan"));
//        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
//        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("0559118799"));
//
//        $("#closeLargeModal").click();
//
//
//    }
//
//    @Test
//    void successfulFillFormTest() {
//        open("/automation-practice-form");
//        $("[id=firstName]").setValue("Amir");
//        $("[id=lastName]").setValue("Dastan");
//        $("#genterWrapper").$(byText("Male")).click();
//        $("[id=userNumber]").setValue("0559118799");
//        $("#state").scrollTo();
//        actions().scrollByAmount(0, -200).perform();
//        $("#submit").click();
//
//
//        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Amir Dastan"));
//        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Male"));
//        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("0559118799"));
//
//        $("#closeLargeModal").click();
//
//
//    }
//
//    @Test
//    void invalidEmailTest() {
//        open("/automation-practice-form");
//        $("#firstName").setValue("Amir");
//        $("#lastName").setValue("Dastan");
//        $("#genterWrapper").$(byText("Male")).click();
//        $("#userNumber").setValue("1234567890");
//        $("#userEmail").setValue("amir");
//        $("#state").scrollTo();
//        actions().scrollByAmount(0, -200).perform();
//
//        $("#submit").click();
//
//        $(".modal-content").shouldNot(appear);
//
//    }
//
//    @Test
//    void emptyFirstNameTest() {
//        open("/automation-practice-form");
//        $("#firstName").setValue("");
//        $("#lastName").setValue("Dastan");
//        $("#genterWrapper").$(byText("Male")).click();
//        $("#userNumber").setValue("1234567890");
//        $("#userEmail").setValue("amir");
//        $("#state").scrollTo();
//        actions().scrollByAmount(0, -200).perform();
//
//        $("#submit").click();
//
//        $(".modal-content").shouldNot(appear);
//
//    }
//
//    @Test
//    void emptyLastNameTest() {
//        open("/automation-practice-form");
//        $("#firstName").setValue("Amir");
//        $("#lastName").setValue("");
//        $("#genterWrapper").$(byText("Male")).click();
//        $("#userNumber").setValue("1234567890");
//        $("#userEmail").setValue("amir");
//        $("#state").scrollTo();
//        actions().scrollByAmount(0, -200).perform();
//
//        $("#submit").click();
//
//        $(".modal-content").shouldNot(appear);
//
//    }appear
}


