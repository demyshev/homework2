package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        clearBrowserCookies();
        Configuration.browserSize = "600x1800";
        Configuration.holdBrowserOpen = false;
    }

    @Test
    void successTest() {
        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("Anton");
        $("#lastName").setValue("Demyshev");
        $("#userEmail").setValue("demyshev14@gmail.com");
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue("9857999889");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("1997");
        $(byText("14")).click();

        $("#subjectsInput").setValue("English").pressEnter();

        $("[for='hobbies-checkbox-1']").click();
        $("[for='hobbies-checkbox-3']").click();

        File file = new File("src/test/resources/1mb.jpeg");
        $("input[id='uploadPicture']").uploadFile(file);

        $("#currentAddress").setValue("Moscow");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();

        $("#submit").scrollTo();
        $("#submit").click();

    }

    void checkTest() {
        $(byText("Thanks for submitting the form")).should(appear);
        $(byText("Anton Demyshev")).should(appear);
        $(byText("demyshev14@gmail.com")).should(appear);
        $(byText("Male")).should(visible);
        $(byText("9857999889")).should(appear);
        $(byText("14 June, 1997")).should(appear);
        $(byText("English")).should(appear);
        $(byText("Sports, Music")).should(appear);
        $(byText("1mb.jpeg")).should(appear);
        $(byText("Moscow")).should(appear);
        $(byText("NCR Delhi")).should(appear);
    }
}



