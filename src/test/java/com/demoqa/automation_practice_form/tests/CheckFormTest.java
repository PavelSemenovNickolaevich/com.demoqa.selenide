package com.demoqa.automation_practice_form.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class CheckFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
        open("https://demoqa.com/automation-practice-form");
    }

    @Test
    void shouldSaveCheckRegistrationForm() {

        SelenideElement firstName = $("#firstName");
        SelenideElement lastName = $("#lastName");
        SelenideElement email = $("#userEmail");
        SelenideElement radioButtonMale = $(byXpath("//label[@for='gender-radio-1']"));
        SelenideElement mobilePhone = $("#userNumber");
        SelenideElement dateOfBirth = $("#dateOfBirthInput");
        SelenideElement subjects = $("#subjectsInput");
        SelenideElement checkBoxHobbiesSport = $(byXpath("//label[@for='hobbies-checkbox-1']"));
        SelenideElement uploadPicture = $("#uploadPicture");
        SelenideElement currentAddress = $("#currentAddress");
        SelenideElement state = $("#state");
        SelenideElement city =  $("#city");
        SelenideElement month =  $(byXpath("//select[@class='react-datepicker__month-select']"));
        SelenideElement year =  $(byXpath("//select[@class='react-datepicker__year-select']"));
        SelenideElement day =  $(byXpath("//div[@class='react-datepicker__day react-datepicker__day--015']"));
        SelenideElement submit = $("#submit");

        String name = "Iron";
        String surname = "Arni";
        String mail = "natitshow@gmail.com";
        String phone = "1234557890";
        String favoriteSubject = "English";
        String monthOfBirth = "September";
        String yearOfBirth = "1987";
        String address = "Los-Angeles";
        String stateOfCountry = "Haryana";
        String cityOfState = "Karnal";

        fillRegistrationForm(firstName, lastName, email, radioButtonMale, mobilePhone, dateOfBirth, subjects
                , checkBoxHobbiesSport, uploadPicture, currentAddress, state, city, month, year, day, submit, name
                , surname, mail, phone, favoriteSubject, monthOfBirth, yearOfBirth, address, stateOfCountry, cityOfState);

        $("tbody").shouldHave(text(name + " " + surname),
                text(mail),
                text("Male"),
                text(phone),
                text("15 September,1987"),
                text(favoriteSubject),
                text("arni.jpg"),
                text(address),
                text(stateOfCountry),
                text(cityOfState)
        );

//        ElementsCollection elements = $$x("//div[@class='modal-content']//tbody/tr");
//        for (SelenideElement e: elements) {
//            ElementsCollection el2 = e.findAll("td");
//
//        }
    }

    private void fillRegistrationForm(SelenideElement firstName, SelenideElement lastName, SelenideElement email
            , SelenideElement radioButtonMale, SelenideElement mobilePhone, SelenideElement dateOfBirth
            , SelenideElement subjects, SelenideElement checkBoxHobbiesSport, SelenideElement uploadPicture
            , SelenideElement currentAddress, SelenideElement state, SelenideElement city, SelenideElement month
            , SelenideElement year, SelenideElement day, SelenideElement submit, String name, String surname
            , String mail, String phone, String favoriteSubject, String monthOfBirth, String yearOfBirth, String address
            , String stateOfCountry, String cityOfState) {
        firstName.setValue(name);
        lastName.setValue(surname);
        email.setValue(mail);
        radioButtonMale.click();
        mobilePhone.setValue(phone);
        dateOfBirth.click();
        month.selectOption(monthOfBirth);
        year.selectOption(yearOfBirth);
        day.click();
        subjects.setValue(favoriteSubject).pressEnter();
        checkBoxHobbiesSport.click();
        uploadPicture.uploadFile(new File("src/test/resources/arni.jpg"));
        currentAddress.setValue(address);
        state.find("input").setValue(stateOfCountry).pressEnter();
        city.find("input").setValue(cityOfState).pressEnter();
        submit.scrollTo().click();
        sleep(3000);
    }
}
