package tests.examples;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import testdata.UserType;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ParameterizedTests {

    @ParameterizedTest
    @ValueSource(strings = {
            "standard_user",
            "problem_user",
            "performance_glitch_user"
    })
    void loginTest(String username) {
        open("https://www.saucedemo.com/");

        $("#user-name").setValue(username);
        $("#password").setValue("secret_sauce");
        $("#login-button").click();

        $(".inventory_list").shouldBe(visible);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test_data/loginTest.csv")
    void loginCsvSourceTest(String username, String password, String result) {

        open("https://www.saucedemo.com/");

        $("#user-name").setValue(username);
        $("#password").setValue(password);
        $("#login-button").click();

        if (result.equals("success")) {
            $(".inventory_list").shouldBe(visible);
        } else {
            $(".error-message-container").shouldBe(visible);
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test_data/loginTest.csv")
    void loginCsvTest(String username, String password, String result) {

        open("https://www.saucedemo.com/");

        $("#user-name").setValue(username);
        $("#password").setValue(password);
        $("#login-button").click();

        if (result.equals("success")) {
            $(".inventory_list").shouldBe(visible);
        } else {
            $(".error-message-container").shouldBe(visible);
        }
    }

    @EnumSource(UserType.class)
    @ParameterizedTest
    void saucedemoSiteShouldDisplayCorrectNames(UserType usertype) {
        open("https://www.saucedemo.com/");
        $("#user-name").setValue(usertype.description);
        $("#password").setValue("secret_sauce");
        $("#login-button").click();
    }

    static Stream<Arguments> saucedemoSiteShouldDisplayCorrectNames () {
        return Stream.of(
                Arguments.of (UserType.standard_user),
                Arguments.of (UserType.problem_user),
                Arguments.of (UserType.visual_user)
        );
    }

    @ParameterizedTest
    @MethodSource("saucedemoSiteShouldDisplayCorrectNames")
    void saucedemoLoginTest(UserType usertype) {
        open("https://www.saucedemo.com/");

        $("#user-name").setValue(usertype.description);
        $("#password").setValue("secret_sauce");
        $("#login-button").click();

        $(".inventory_list").shouldBe(visible);
    }
}
