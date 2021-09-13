package com.demoqa.automation_practice_form.tests;

import com.demoqa.automation_practice_form.components.CalendarForm;
import com.demoqa.automation_practice_form.pages.RegistrationPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.demoqa.automation_practice_form.tests.TestData.*;

public class CheckFormTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void shouldSaveCheckRegistrationForm() {

        registrationPage.typeFirstName(name);
        registrationPage.typeLastName(surname);
        registrationPage.setEmail(mail);
        registrationPage.setRadioButtonMale();
        registrationPage.setMobilePhone(phone);
        registrationPage.setBirthDate(monthOfBirth, yearOfBirth, dayOfBirth);
        registrationPage.setCheckBoxHobbiesSport();
        registrationPage.uploadPicture(path);
        registrationPage.setAddress(address);
        registrationPage.setSubjects(favoriteSubject);
        registrationPage.setState(stateOfCountry);
        registrationPage.setCity(cityOfState);
        registrationPage.submitPage();
        registrationPage.checkForm();
    }


}
