package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.*;

public class StudentsRegistrationFormTests {

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "600x1800";
    }

    @Test
    void fillFormTest() {
        open ("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        $("[alt=\"adplus-dvertising\"]").click();

        $("#firstName").setValue("Anton");
        $("#lastName").setValue("Demyshev");
        $("#userEmail").setValue("anton@demyshev.com");

//        $("#gender-radio-3").click(); //NOT WORKING
//        $("#gender-radio-3").doubleClick(); //BUT WHY?
//        $("#gender-radio-3").parent().click();
//        $("label[for=gender-radio-3]").click(); //хороший вариант, еще внутри [] нужны '', если в значении есть пробелы
//        $(byText("Other")).click(); //BAD PRACTICE - ищет по всей странице и кликнет на первый попавшийся
        $("#genterWrapper").$(byText("Other")).click();

        $("#userNumber").setValue("1231231230");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("2008");

//        SelenideElement a = $(""); //один, первого встречного вернет
//        ElementsCollection b = $$(""); //много = список, вернет все
//        $("") == $$("").first(); //p.s. псевдокод так на java не пишут, это объяснение когда $, когда $$

//        $(".react-datepicker__day--30:not(react-datepicker__day--outside-month)").click();
////      $(byValue("30")) //BAD PRACTICE с днем, потому что в форме может быть "30" предыдущего месяца - сломается
//        $$(".react-datepicker__day--30")
//                .filter(not(cssClass("react-datepicker__day--outside-month")))
//                .first() // or .get(0)
//                .click();
//        $("[aria-label=Choose Monday, July 30th, 2008]").click(); //NOT WORKING
//        $("[aria-label='Choose Monday, July 30th, 2008']").click();
//        $("[aria-label=\"Choose Monday, July 30th, 2008\"]").click(); //  \" = '
//        $x("//*[contains(@aria-label, \"July 30th, 2008\")]").click();
//        $("[aria-label*='July 30th, 2008']").click();
        $("[aria-label$='July 30th, 2008']").click();

//<div class="react-datepicker__day react-datepicker__day--030 react-datepicker__day--outside-month" aria-label="Choose Monday, June 30th, 2008" >30</div>
//<div class="react-datepicker__day react-datepicker__day--030"                                      aria-label="Choose Wednesday, July 30th, 2008" >30</div>

        $("#subjectsInput").setValue("Maths").pressEnter();
//        $("#subjectsInput").setValue("M"); // todo Why not working
//        $("subjectsWrapper").$(byText("Maths")).click();

        $("#hobbiesWrapper").$(byText("Sports")).click();

//        $("#uploadPicture").uploadFile(new File("src/test/resources/img/1.png"));
//        File someFile = new File("src/test/resources/img/1.png");
//        $("#uploadPicture").uploadFile(someFile);
        $("#uploadPicture").uploadFromClasspath("img/1.png");

        $("#currentAddress").setValue("some address");

        $("#state").scrollTo().click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Noida")).click();

        $("#submit").scrollTo();
        $("#submit").click();
    }
}
