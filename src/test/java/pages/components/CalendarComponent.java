package pages.components;

import com.codeborne.selenide.SelenideElement;
import testdata.RegisterFormData;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    private SelenideElement yearSelection = $(".react-datepicker__year-select");
    private SelenideElement monthSelection = $(".react-datepicker__month-select");
    private SelenideElement dateSelection = $(".react-datepicker__month");

    public void setDate(String day, String month, String year) {
        yearSelection.selectOption(year);
        monthSelection.selectOption(month);
        dateSelection.$(byText(RegisterFormData.birthDate)).click();
    }
}
