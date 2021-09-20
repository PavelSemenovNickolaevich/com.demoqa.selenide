package homework_with_files;

import com.codeborne.xlstest.XLS;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;


import static org.assertj.core.api.Assertions.assertThat;

public class HomeWorkFilesTest {

    @Test
    void checkFilesTxt() throws IOException {

        try (FileWriter writer = new FileWriter("src/test/resources/checkTxtFiles.txt", false)) {
            String text = "Hello from Izhevsk!";
            writer.write(text);

            String result;

            InputStream stream = getClass().getClassLoader().getResourceAsStream("checkTxtFiles.txt");
            result = new String(Objects.requireNonNull(stream).readAllBytes(), StandardCharsets.UTF_8);

            assertThat(result).contains("Hello from Izhevsk!");
        }

    }

    @Test
    void checkFilesPdf() throws IOException {
        createFilePDF();
        PdfReader reader = new PdfReader("HelloWorld.pdf");
        for (int i = 1; i <= reader.getNumberOfPages(); ++i) {
            TextExtractionStrategy strategy = new SimpleTextExtractionStrategy();
            String text = PdfTextExtractor.getTextFromPage(reader, i, strategy);
            assertThat(text).contains("Hello World");

        }
        reader.close();
    }

    @Test
    void checkFilesXLS() throws IOException {
        createFileXLS();
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("homework.xls")) {
            XLS parsed = new XLS(Objects.requireNonNull(stream));
            assertThat(parsed.excel.getSheetAt(0).getRow(1).getCell(1).getStringCellValue())
                    .isEqualTo("John");
        }

    }

    @Test
    void shouldCheckPasswordInZip() throws IOException {
        String result;
        createFileZIP();
        try (FileInputStream stream = new FileInputStream("src/test/resources/extract_zip/password.txt")) {
            result = new String(stream.readAllBytes(), StandardCharsets.UTF_8);
        }
        assertThat(result).contains("Password");
    }

    @Test
    void checkDOCFiles() throws IOException, InvalidFormatException {
        createFileDOCX();
        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/homework.docx")) {
            XWPFDocument docxFile = new XWPFDocument(OPCPackage.open(fileInputStream));
            XWPFWordExtractor extractor = new XWPFWordExtractor(docxFile);
            assertThat(extractor.getText().contains("Hello from SaintP, Moscow and Izhevsk"));
        }
    }

    private void createFileDOCX() {
        try {
            // создаем модель docx документа,
            // к которой будем прикручивать наполнение (колонтитулы, текст)
            XWPFDocument docxModel = new XWPFDocument();
            CTSectPr ctSectPr = docxModel.getDocument().getBody().addNewSectPr();

            XWPFParagraph bodyParagraph = docxModel.createParagraph();
            bodyParagraph.setAlignment(ParagraphAlignment.RIGHT);
            XWPFRun paragraphConfig = bodyParagraph.createRun();
            paragraphConfig.setItalic(true);
            paragraphConfig.setFontSize(25);
            // HEX цвет без решетки #
            paragraphConfig.setColor("06357a");
            paragraphConfig.setText(
                    "Hello from SaintP, Moscow and Izhevsk"
            );
            // сохраняем модель docx документа в файл
            FileOutputStream outputStream = new FileOutputStream("src/test/resources/homework.docx");
            docxModel.write(outputStream);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createFileXLS() {
        try {
            String filename = "src/test/resources/homework.xls";
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("FirstSheet");

            HSSFRow rowhead = sheet.createRow((short) 0);
            rowhead.createCell(0).setCellValue("No.");
            rowhead.createCell(1).setCellValue("Name");
            rowhead.createCell(2).setCellValue("Address");
            rowhead.createCell(3).setCellValue("Email");

            HSSFRow row = sheet.createRow((short) 1);
            row.createCell(0).setCellValue("1");
            row.createCell(1).setCellValue("John");
            row.createCell(2).setCellValue("Rambo");
            row.createCell(3).setCellValue("holliwood@gmail.com");

            FileOutputStream fileOut = new FileOutputStream(filename);
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
            System.out.println("Your excel file has been generated!");
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private void createFileZIP() throws ZipException {
        ZipFile zipFile = new ZipFile("src/test/resources/password.zip");
        File file = new File("src/test/resources/extract_zip/password.txt");
        if (!file.isFile()) {
            if (zipFile.isEncrypted())
                zipFile.setPassword("warhammer".toCharArray());
            zipFile.extractAll("src/test/resources/extract_zip");
        }
    }

    private void createFilePDF() {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("src/test/resources/HelloWorld.pdf"));
            document.open();
            document.add(
                    new Paragraph("Hello World"));
            document.addAuthor("Test");

        } catch (Exception e) {
        }
        document.close();
    }
}


