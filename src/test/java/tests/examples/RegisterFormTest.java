package tests.examples;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.RegisterPage;
import pages.components.ResultFormComponent;
import testdata.RegisterFormData;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static testdata.RegisterFormData.*;
import static utils.RandomUtils.*;

public class RegisterFormTest {
    RegisterPage registerPage = new RegisterPage();
    ResultFormComponent resultFormComponent = new ResultFormComponent();

    @BeforeAll
    static void prepareEnvironment() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";
    }

    String firstName;
    String lastName;
    String email;
    String gender;
    String phone;
    String day;
    String month;
    String year;
    String subject;
    String hobbies;
    String picture;
    String address;
    String state;
    String city;

    @BeforeEach
    void prepareRandomData() {
        firstName = getRandomString(10);
        lastName = getRandomString(10);
        email = getRandomEmail();

        String[] genders = {"Male", "Female", "Other"};
        gender = getRandomItemFromStringArray(genders);

        phone = getRandomPhone();

        day = getDay(getRandomDate());
        month = getMonth(getRandomDate());
        year = getYear(getRandomDate());

        subject = getSubject();
        hobbies = getRandomHobbies();

        picture = "1.png";

        address = getRandomString(30);

        state = "NCR";
        city = getRandomCityByState(state);

    }


    @Test
    void filledFormTest() {
        registerPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserEmail(userEmail)
                .setGender(gender)
                .typeUserNumber(phone)
                .setDateOfBirth(day,month,year)
                .setSubject(subject)
                .setHobbies(hobbies)
                .uploadPicture(picture)
                .typecurrentAddress(address)
                .setStateAndCity(state,city)
                .submitForm()
                .checkSuccessSubmitText();

        resultFormComponent.checkFormResults("Student Name", firstName);
        resultFormComponent.checkFormResults("Student Name", lastName);
        resultFormComponent.checkFormResults("Student Email", userEmail);
        resultFormComponent.checkFormResults("Gender", genterWrapper);
        resultFormComponent.checkFormResults("Mobile", userNumber);
        resultFormComponent.checkFormResults("Date of Birth", birthDate);
        resultFormComponent.checkFormResults("Subjects", subjectsInput);
        resultFormComponent.checkFormResults("Hobbies", hobbiesWrapper);
        resultFormComponent.checkFormResults("Picture", uploadPicture);
        resultFormComponent.checkFormResults("Address", currentAddress);
        resultFormComponent.checkFormResults("State and City", stateCity);

        registerPage.closeForm();
    }
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



