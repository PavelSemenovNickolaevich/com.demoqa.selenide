package com.demoqa.automation_practice_form.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class CalendarForm {

    SelenideElement dateOfBirth = $("#dateOfBirthInput"),
            monthSelect = $(byXpath("//select[@class='react-datepicker__month-select']")),
            yearSelect = $(byXpath("//select[@class='react-datepicker__year-select']"));

    public void setDateOfBirth(String monthOfBirth, String yearOfBirth, String dayOfBirth) {
        dateOfBirth.click();
        monthSelect.selectOption(monthOfBirth);
        yearSelect.selectOption(yearOfBirth);
        String dayLocator = format("//div[@class='react-datepicker__day react-datepicker__day--0%s']", dayOfBirth);
        $(byXpath(dayLocator)).click();

    }
}
