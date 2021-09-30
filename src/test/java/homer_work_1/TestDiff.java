package homer_work_1;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

public class TestDiff {


    @Test
    void shouldDiff() {

        /* 1. Есть ли разница между $("h1 div"); и $("h1").$("div"); - может ли привести к тому что, поиск найдёт разные элементы?

         Если может - приведите пример, когда.*/

        //Да может! Разве возможно, что ("h1 div") могут быть на одном уровне идив быть вложенным а h1? Так недопутимо.
        //Есть варинат стдеать h1 + div, тогда будет выбран следующий элемент , как в варианте $("h1").$("div").


        Configuration.startMaximized = true;
        //open("https://www.sitepoint.com/community/t/how-problematic-is-it-to-wrap-h1-tag-within-divs/6823");
        //  open("https://ru.wikipedia.org/wiki/Google");
        //$("h1 div").shouldHave(Condition.id("ember30"));
        // String text = $("h1 div").getText();
        //  $("h1").$("div").should(Condition.visible);
        // $("h1 div").should(Condition.visible);
        //  System.out.println(text);

//        sleep(4000);
//      // $("h1").$("div").shouldHave(Condition.id("ember30"));
//       $("h1").$("div").should(Condition.visible);
//       $("h1 div").should(Condition.visible);
//       if (element1 == element) {
//           System.out.println("3t3t3t");
//       }

    }
}
