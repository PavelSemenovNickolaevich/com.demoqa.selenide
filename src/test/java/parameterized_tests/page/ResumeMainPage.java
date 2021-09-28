package parameterized_tests.page;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ResumeMainPage {

    private SelenideElement addResume = $(byXpath("//img[@src='img/add.png']"));
    private SelenideElement header = $(byXpath("//a[@href='resume']"));
    private SelenideElement footer = $(byXpath("//a[@href='http://javaops.ru/reg/basejava']"));

    public ResumeAddPage addResume() {
        addResume.click();
        return new ResumeAddPage();
    }

    public void checkForm(String nameCon, String email) {
        $("tbody").shouldHave(text(nameCon),
                text(email)
        );
    }

    public void getContactList(String nameFromCSV, String emailFromCSV) {
        List<WebElement> rows = WebDriverRunner.getWebDriver().findElements(By.tagName("tr"));
        rows.remove(0);
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            String name = cells.get(0).getText();
            String email = cells.get(1).getText().replaceAll("\\s", "").replaceAll("[Почта:]", "");
            Assertions.assertEquals(name, nameFromCSV);
            Assertions.assertEquals(email, emailFromCSV);
        }
    }

    public void getAndCheckHeaderAndFooter(String head, String foot) {
        header.shouldHave(text(head));
        footer.shouldHave(text(foot));
    }
}
