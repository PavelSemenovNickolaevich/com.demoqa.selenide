package parameterized_tests.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ResumeAddPage {

    private SelenideElement fullName = $(By.name("fullName"));
    private SelenideElement phone = $(By.name("PHONE"));
    private SelenideElement mail = $(By.name("MAIL"));
    private SelenideElement saveResume = $(byXpath("//button[@type='submit']"));

    public ResumeMainPage fillAndSaveResume(String name, String phoneNum, String email) {
        fullName.setValue(name);
        phone.setValue(phoneNum);
        mail.setValue(email);
        saveResume.scrollTo().click();
        return new ResumeMainPage();
    }

}
