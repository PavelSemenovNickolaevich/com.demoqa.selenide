package lesson7_parallel_tests.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class JetBrainsMainPage {

    public static final String URL = "https://www.jetbrains.com/";

    private SelenideElement searchBtn = $("button[data-test='site-header-search-action']");
    private SelenideElement  inputSearch= $("input[data-test='search-input']");

    public JetBrainsResultsPage doSearch(String searchQuery) {
        searchBtn.click();
        inputSearch.setValue(searchQuery);
        sleep(2000);
        inputSearch.pressEnter();
        return new JetBrainsResultsPage();
    }
}
