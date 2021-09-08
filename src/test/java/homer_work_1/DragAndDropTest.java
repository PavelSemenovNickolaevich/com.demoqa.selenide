package homer_work_1;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**Запрограммируйте Drag&Drop с помощью Selenide.actions()

 - Откройте https://the-internet.herokuapp.com/drag_and_drop

 - Перенесите прямоугольник А на место В

 - Проверьте, что прямоугольники действительно поменялись

 P.S. В Selenide есть команда $(element).dragAndDrop($(to-element)), проверьте работает ли тест, если использовать её вместо actions()

 (раньше не работала из-за ошибки в ChromeDriver, но может быть уже починили? :-)).

 Если работает - сообщите в группе курса.*/

public class DragAndDropTest {

    @Test
    void shouldChangerRectangleAAndB() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDropTo("#column-b");
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));


    }


}
