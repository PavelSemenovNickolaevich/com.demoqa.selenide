package lesson7_parallel_tests.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import lesson7_parallel_tests.pages.JetBrainsMainPage;
import lesson7_parallel_tests.pages.JetBrainsResultsPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceLock;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ParallelTests {


    JetBrainsMainPage jetBrainsMainPage = new JetBrainsMainPage();
    JetBrainsResultsPage jetBrainsResultsPage = new JetBrainsResultsPage();


    @ResourceLock("SelenideConfig")
    @ValueSource(strings = {
            "ide",
            "java",
            "test"
    })
    @ParameterizedTest(name = "Check search results for input string: {0}")
    void searchResult(String query) {
        Configuration.startMaximized = true;
        Selenide.open(jetBrainsMainPage.URL);
        jetBrainsMainPage.doSearch(query).checkResults(query);

    }


    @ResourceLock("SelenideConfig")
    @DisplayName("IJ should be present in search results")
    @Test
    void minimizedWindowTest() {
        Configuration.startMaximized = false;
        Selenide.open(jetBrainsMainPage.URL);
        jetBrainsMainPage.doSearch("IJ")
                .checkResults("IJ");
    }
}
