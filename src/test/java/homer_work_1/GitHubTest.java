package homer_work_1;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GitHubTest {

    /**2. Разработайте следующий автотест:

     - Откройте страницу Selenide в Github

     - Перейдите в раздел Wiki проекта

     - Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions

     - Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5*/

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
        open("https://github.com");
    }

    @Test
    void shouldExistExamplesOfJunit5() {
        $("[data-test-selector='nav-search-input']").setValue("selenide").pressEnter();
        $(byText("Wikis")).click();
        $("#wiki_search_results").$(byText("SoftAssertions")).shouldBe(visible);
        $(byText("SoftAssertions")).click();
        $$(".highlight-source-java").get(3).shouldBe(visible).shouldHave(text("@ExtendWith"));
        $$(".highlight-source-java").get(4).shouldBe(visible).shouldHave(text("@RegisterExtension"));
    }
}
