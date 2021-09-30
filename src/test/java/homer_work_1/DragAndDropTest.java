package homer_work_1;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * Запрограммируйте Drag&Drop с помощью Selenide.actions()
 * <p>
 * - Откройте https://the-internet.herokuapp.com/drag_and_drop
 * <p>
 * - Перенесите прямоугольник А на место В
 * <p>
 * - Проверьте, что прямоугольники действительно поменялись
 * <p>
 * P.S. В Selenide есть команда $(element).dragAndDrop($(to-element)), проверьте работает ли тест, если использовать её вместо actions()
 * <p>
 * (раньше не работала из-за ошибки в ChromeDriver, но может быть уже починили? :-)).
 * <p>
 * Если работает - сообщите в группе курса.
 */

public class DragAndDropTest {

    @Test
    void shouldChangerRectangleAAndB() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDropTo("#column-b");
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));


    }


}
