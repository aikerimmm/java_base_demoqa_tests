package tests.examples;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.RegisterPage;
import pages.components.ResultFormComponent;

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
                .setGender(genterWrapper)
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


