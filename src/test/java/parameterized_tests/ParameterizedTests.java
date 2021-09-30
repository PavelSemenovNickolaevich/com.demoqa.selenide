package parameterized_tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import parameterized_tests.domain.Header;
import parameterized_tests.domain.MenuFooterAndHeader;
import parameterized_tests.page.ResumeAddPage;
import parameterized_tests.page.ResumeMainPage;

import java.io.IOException;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.$$;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ParameterizedTests extends TestBase {

    ResumeMainPage mainPage = new ResumeMainPage();
    ResumeAddPage addPage = new ResumeAddPage();


    @DisplayName("Test for fill contact from CSV file")
    @org.junit.jupiter.params.ParameterizedTest
    @CsvFileSource(resources = "/ContactData.csv")
    void fillAndCheckResumeFromCSVFile(String name, String phone, String email) throws IOException {
        int beforeCountResume = $$(byTagName("tr")).size();
        mainPage.addResume();
        addPage.fillAndSaveResume(name, phone, email);
        mainPage.checkForm(name, email);
        int afterCountResume = $$(byTagName("tr")).size();
        assertEquals(afterCountResume, beforeCountResume + 1);
        mainPage.getContactList(name, email);

    }

    @DisplayName("Test for fill contact from csv source")
    @org.junit.jupiter.params.ParameterizedTest
    @CsvSource({"Test1,Test1,12345", "Test2,Test2,67890", "Test3,Test3,12345"})
    void fillAndCheckResumeFromCSVSource(String name, String phone, String email) {
        mainPage.addResume();
        addPage.fillAndSaveResume(name, phone, email);
        mainPage.checkForm(name, email);
    }

    @ParameterizedTest
    @EnumSource(value = MenuFooterAndHeader.class)
    void shouldContainHeaderAndFooterFromENUM(MenuFooterAndHeader menuFooterAndHeader) {
        mainPage.getAndCheckHeaderAndFooter(MenuFooterAndHeader.HEADER.getDesc(), MenuFooterAndHeader.FOOTER.getDesc());
    }

    @ParameterizedTest
    @EnumSource(value = Header.class)
    void shouldContainHeaderENUM(Header header) {
        mainPage.getAndCheckHeader(header.getDesc());
    }

    static Stream<Arguments> testWithMethodSource() {
        return Stream.of(
                Arguments.of(
                        "Test1", "Test2", "12345"
                ),
                Arguments.of(
                        "Test2", "Test2", "67890"
                )
        );
    }

    @MethodSource("testWithMethodSource")
    @ParameterizedTest()
    @DisplayName("Added resume from Stream")
    void openTabsWithMethodSource(String name, String phone, String email) {
        mainPage.addResume();
        addPage.fillAndSaveResume(name, phone, email);
        mainPage.checkForm(name, email);
    }


}
