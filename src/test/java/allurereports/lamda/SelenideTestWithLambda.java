package allurereports.lamda;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class SelenideTestWithLambda {

    private final static String REPOSITORY = "PavelSemenovNickolaevich/spring_course_security";

    @BeforeAll
    static void setUp() {
        Configuration.startMaximized = true;
    }

    @Test
    public void shouldCheckIssue() {
        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").setValue("PavelSemenovNickolaevich/spring_course_security").submit();
        });
        step("Переходим в репозиторий " + REPOSITORY, () -> {
            $(linkText("PavelSemenovNickolaevich/spring_course_security")).click();
        });
        step("Проверяем, что существует раздел Issues", () -> {
            $("span[data-content='Issues']").shouldBe(visible).shouldHave(text("Issues"));
        });
    }
}
