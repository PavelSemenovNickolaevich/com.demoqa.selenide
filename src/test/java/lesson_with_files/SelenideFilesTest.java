package lesson_with_files;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;


public class SelenideFilesTest {

    @Test
    void downloadFileTest() throws Exception {
        open("https://github.com/selenide/selenide/blob/master/README.md");
        File download = $("#raw-url").download();
        String result;

        try (InputStream is = new FileInputStream(download)) {
            result = new String(is.readAllBytes(), "UTF-8");
            System.out.println(result.toString());

            System.out.println();
        }
        assertThat(result).contains("Selenide = UI Testing Framework powered by Selenium WebDriver");
    }

    @Test
    void uploadFileTest() {
        open("https://the-internet.herokuapp.com/upload");
        $("input[type='file']").uploadFromClasspath("example.txt");
        $("#file-submit").click();
        $("#uploaded-files")
                .shouldHave(text("example.txt"));

    }

    @Test
    void downloadPdfTest() throws Exception {
        open("https://junit.org/junit5/docs/current/user-guide/");
        File download = $(byText("PDF download")).download();
        PDF parsed = new PDF(download);
        assertThat(parsed.author).contains("Marc Philipp");
    }

    @Test
    void downloadExcelTest() throws Exception {
//        Selenide.open("https://junit.org/junit5/docs/current/user-guide/");
//        File download = $(byText("PDF download")).download();
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("175.xlsx")) {
            XLS parsed = new XLS(stream);
            assertThat(parsed.excel.getSheetAt(1).getRow(4).getCell(1).getStringCellValue())
                    .isEqualTo("Алешина Ольга Валентиновна");
        }
    }

    @Test
    void parseCsvTest() throws Exception {
        URL url = getClass().getClassLoader().getResource("file.csv");
        CSVReader reader = new CSVReader(new FileReader(new File(url.toURI())));

        List<String[]> strings = reader.readAll();

        assertThat(strings).contains(
                new String[]{"lector", "lecture"},
                new String[]{"Tuchs", "JUnit"},
                new String[]{"Eroshenko", "Allure"}
        );
    }

    @Test
    void parseZipFileTest() throws Exception {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream("zip_2MB.zip")) {
            ZipInputStream zis = new ZipInputStream(is);
            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                System.out.println(entry.getName());
            }
            //           for text zipped files
//            Scanner sc = new Scanner(zis);
//            while (sc.hasNext()) {
//                System.out.println(sc.nextLine());
//            }
        }
    }

}
