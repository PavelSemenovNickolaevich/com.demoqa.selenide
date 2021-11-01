package lesson7_parallel_tests.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;

import java.awt.*;

import static com.codeborne.selenide.Selenide.$$;

public class JetBrainsResultsPage {

    private ElementsCollection results = $$(".full-search__item");

    public void checkResults(String expected) {
        results.shouldBe(CollectionCondition.sizeGreaterThan(0))
                .get(1)
                .shouldHave(Condition.text(expected));
    }

//    public YandexResultsPage switchToMenuItem(MenuItem menuItem) {
//        $$("li[role='listitem']").find(Condition.text(menuItem.getDesc())).click();
//        return this;
//    }
}
