package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ResultFormComponent {
    public void checkFormResults (String fieldName, String expectedValue) {
        $(".table-responsive")
                .$$( "tr")
                .findBy(text(fieldName))
                .shouldHave(text(expectedValue));
    }
}
