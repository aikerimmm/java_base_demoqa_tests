package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import pages.components.Calendar.CalendarComponent;
import testdata.RegisterFormData;

import java.util.Calendar;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

public class RegisterPage {
    CalendarComponent calender = new CalendarComponent();

    private SelenideElement firstNameInput = $("firstName");
    private SelenideElement lastNameInput = $("lastName");
    private SelenideElement userEmailInput = $("emailName");
    private SelenideElement genderContainer = $("#$(Other);");
    private SelenideElement userNumber = $("userNumber");
    private SelenideElement subjectContainer = $("#subjectsInput;");
    private SelenideElement hobbiesWrapper = $("#hobbiesWrapper;");
    private SelenideElement uploadPicture = $("#uploadPicture;");
    private SelenideElement currentAddress = $("#currentAddress;");
    private SelenideElement stateSelelct = $("#state");
    private SelenideElement citySelect = $("#city");
    private SelenideElement stateCityContainer = $("#stateCity-wrapper;");
    private SelenideElement submitButton = $("[#submit");
    private SelenideElement closeButton = $("#closeLargeModal;");

    public RegisterPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegisterPage typeFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegisterPage typeLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegisterPage typeUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegisterPage setGender(String value) {
        genderContainer.$(byText(value)).click();

        return this;
    }

    public RegisterPage typeUserNumber(String value) {
        userNumber.setValue(value);

        return this;
    }

    public RegisterPage setDateOfBirth(String day, String month, String year) {
        $("[id=dateOfBirthInput]").click();
        calender.setDate(day, month, year);

        return this;
    }

    public RegisterPage setSubject(String value) {
        subjectContainer.$(byText(value)).click();

        return this;
    }

    public RegisterPage uploadPicture(String value) {
        uploadPicture.$(byText(value)).click();

        return this;
    }

    public RegisterPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }

    public RegisterPage typecurrentAddress(String value) {
        currentAddress.setValue(value);

        return this;
    }

    public RegisterPage setState(String value) {
        stateSelelct.click();
        stateCityContainer.$(byText(value)).click();

        return this;
    }

    public RegisterPage setCity(String value) {
        citySelect.click();
        stateCityContainer.$(byText(value)).click();

        return this;
    }

    public RegisterPage setStateAndCity(String state, String city) {
        setState(state);
        setCity(city);

        return this;
    }

    public RegisterPage submitForm() {
        submitButton.click();

        return this;
    }

    public RegisterPage checkSuccessSubmitText() {
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(Condition.exactText("Thanks for submitting form"));
        return this;
    }

    public RegisterPage checkFormResults(String fieldName, String expectedValue) {
        $(".table-responsive")
                .$$( "tr")
                .findBy(text(fieldName))
                .shouldHave(text(expectedValue));
        return this;
    }

    public RegisterPage closeForm() {
        closeButton().click();

        return this;
    }
}