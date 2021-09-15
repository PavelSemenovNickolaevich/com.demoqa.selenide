package allurereports.annotation;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AnnotatedStepTest {

    //WebSteps steps = new WebSteps();
    private final static String REPOSITORY = "PavelSemenovNickolaevich/spring_course_security";

    @BeforeAll
    static void setUp() {
        Configuration.startMaximized = true;
    }

    @Test
    public void shouldCheckIssue() {
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.checkIssueTab();
    }
}
