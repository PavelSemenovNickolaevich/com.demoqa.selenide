package parameterized_tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {


    @BeforeAll()
    static void setUp() throws Exception {
        Configuration.startMaximized = true;
        open("https://java-reume-project.herokuapp.com/resume");

    }

    @AfterAll()
    static void tearDown() throws Exception {

    }
}
