package allurereports;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {

    @BeforeAll
    static void setUp() {
        Configuration.startMaximized = true;
    }

    @Test
    public void testGithub() {

        open("https://github.com");

        $(".header-search-input").setValue("PavelSemenovNickolaevich/spring_course_security").submit();
        $(linkText("PavelSemenovNickolaevich/spring_course_security")).click();
        $("span[data-content='Issues']").shouldBe(visible).shouldHave(text("Issues"));
    }

}
