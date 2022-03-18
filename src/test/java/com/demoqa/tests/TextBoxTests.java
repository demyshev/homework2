package com.demoqa.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @Test
    void successTest() {
        open("https://demoqa.com/automation-practice-form");

        $("#firstName").setValue("Anton");
        $("#lastName").setValue("Demyshev");
        $("#userEmail").setValue("demyshev14@gmail.com");
        $("#gender-radio-1.custom-control-label").click();
        $("#userNumber").setValue("+79857999889");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("1997");
        $(byText("14")).click();

//        $(".subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3").setValue("asd");
//        $("#hobbies-checkbox-1.custom-control-input").click();
//        $("#uploadPicture").uploadFile("/Users/demyshev/Pictures/1.jpg");
//        $("#currentAddress").setValue("Moscow");
//        $(". css-1wa3eu0-placeholder").selectOption("NCR");
    }
}

