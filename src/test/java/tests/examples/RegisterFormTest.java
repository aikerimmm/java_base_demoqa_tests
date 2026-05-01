package tests.examples;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegisterPage;
import pages.components.ResultFormComponent;
import testdata.RegisterFormData;

public class RegisterFormTest {
    RegisterPage registerPage = new RegisterPage();
    ResultFormComponent resultFormComponent = new ResultFormComponent();
    RegisterFormData registerFormData = new RegisterFormData();

    @BeforeAll
    static void prepareEnvironment() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";
    }

    @Test
    void filledFormTest() {
        registerPage.openPage()
                .typeFirstName(registerFormData.firstName)
                .typeLastName(registerFormData.lastName)
                .typeUserEmail(registerFormData.email)
                .setGender(registerFormData.genterWrapper)
                .typeUserNumber(registerFormData.userNumber)
                .setDateOfBirth(registerFormData.birthDate, registerFormData.birthMonth, registerFormData.birthYear)
                .setSubject(registerFormData.subjectsInput)
                .setHobbies(registerFormData.hobbiesWrapper)
                .uploadPicture(registerFormData.uploadPicture)
                .typecurrentAddress(registerFormData.currentAddress)
                .setStateAndCity(registerFormData.state,registerFormData.city)
                .submitForm()
                .checkSuccessSubmitText();

        resultFormComponent.checkFormResults("Student Name", registerFormData.firstName);
        resultFormComponent.checkFormResults("Student Name", registerFormData.lastName);
        resultFormComponent.checkFormResults("Student Email", registerFormData.email);
        resultFormComponent.checkFormResults("Gender", registerFormData.genterWrapper);
        resultFormComponent.checkFormResults("Mobile", registerFormData.userNumber);
        resultFormComponent.checkFormResults("Date of Birth", registerFormData.birthDate);
        resultFormComponent.checkFormResults("Subjects", registerFormData.subjectsInput);
        resultFormComponent.checkFormResults("Hobbies", registerFormData.hobbiesWrapper);
        resultFormComponent.checkFormResults("Picture", registerFormData.uploadPicture);
        resultFormComponent.checkFormResults("Address", registerFormData.currentAddress);
        resultFormComponent.checkFormResults("State and City", registerFormData.state);

        registerPage.closeForm();
    }
}


