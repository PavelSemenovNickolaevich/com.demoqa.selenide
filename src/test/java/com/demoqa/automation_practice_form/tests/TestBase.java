package com.demoqa.automation_practice_form.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.automation_practice_form.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    static RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
        registrationPage.openPage();
    }
}
