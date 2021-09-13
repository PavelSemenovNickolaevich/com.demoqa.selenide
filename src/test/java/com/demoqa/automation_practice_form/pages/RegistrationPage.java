package com.demoqa.automation_practice_form.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.automation_practice_form.components.CalendarForm;

import java.io.File;
import java.util.Calendar;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.demoqa.automation_practice_form.tests.TestData.*;
import static com.demoqa.automation_practice_form.tests.TestData.cityOfState;

public class RegistrationPage {

    CalendarForm calendarForm = new CalendarForm();

    private final SelenideElement
            firstName = $("#firstName"),
            lastName = $("#lastName"),
            email = $("#userEmail"),
            radioButtonMale = $(byXpath("//label[@for='gender-radio-1']")),
            mobilePhone = $("#userNumber"),
            subjects = $("#subjectsInput"),
            checkBoxHobbiesSport = $(byXpath("//label[@for='hobbies-checkbox-1']")),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            state = $("#state"),
            city = $("#city"),
            submit = $("#submit");

    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
    }

    public void typeFirstName(String name) {
        firstName.setValue(name);
    }

    public void typeLastName(String surname) {
        lastName.setValue(surname);
    }

    public void setEmail(String mail) {
        email.setValue(mail);
    }

    public void setRadioButtonMale() {
        radioButtonMale.click();
    }

    public void setMobilePhone(String phone) {
        mobilePhone.setValue(phone);
    }

    public void setAddress(String address) {
        currentAddress.setValue(address);
    }

    public void setCheckBoxHobbiesSport() {
        checkBoxHobbiesSport.click();
    }

    public void setBirthDate(String monthOfBirth, String yearOfBirth, String dayOfBirth) {
        calendarForm.setDateOfBirth(monthOfBirth, yearOfBirth, dayOfBirth);
    }

    public void uploadPicture(String path) {
        uploadPicture.uploadFile(new File(path));
    }

    public void setSubjects(String favoriteSub) {
        subjects.setValue(favoriteSub).pressEnter();
    }

    public void setState(String stateOfCountry) {
        state.find("input").setValue(stateOfCountry).pressEnter();
    }

    public void setCity(String cityOfCountry) {
        city.find("input").setValue(cityOfCountry).pressEnter();
    }

    public void submitPage() {
        submit.scrollTo().click();
    }

    public void checkForm() {
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
    }

}
