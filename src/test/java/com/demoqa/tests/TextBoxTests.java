package com.demoqa.tests;

import org.junit.jupiter.api.Test;

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
        $("#dateOfBirthInput.form-control");

    }
}
