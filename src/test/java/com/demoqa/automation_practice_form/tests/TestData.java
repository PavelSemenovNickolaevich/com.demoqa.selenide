package com.demoqa.automation_practice_form.tests;

import com.github.javafaker.Faker;

public class TestData {

    static Faker faker = new Faker();

    public static String name = faker.name().firstName();
    public static String surname = faker.name().lastName();
    public static String mail = faker.internet().emailAddress();
    public static String phone = faker.phoneNumber().subscriberNumber(10);
    public static String favoriteSubject = "English";
    public static String monthOfBirth = "September";
    public static String yearOfBirth = "1987";
    public static String dayOfBirth = "15";
    public static String address = faker.address().fullAddress();
    public static String stateOfCountry = "Haryana";
    public static String cityOfState = "Karnal";
    public static String path = "src/test/resources/arni.jpg";

}
