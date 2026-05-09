package qa.guru;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.junit.jupiter.api.Assertions.*;

public class ZipTest {

    @Test
    void zipFileParsingTest() throws Exception {

        ClassLoader cl = ZipTest.class.getClassLoader();

        try (InputStream is = cl.getResourceAsStream("files/archive.zip");
             ZipInputStream zis = new ZipInputStream(is)) {

            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                String name = entry.getName();

                if (name.startsWith("__MACOSX") || name.startsWith(".")) {
                    zis.closeEntry();
                    continue;
                }

                System.out.println("📄 Reading: " + name);
                byte[] bytes = zis.readAllBytes();

                if (name.endsWith(".pdf")) {
                    checkPdf(bytes);
                } else if (name.endsWith(".xlsx")) {
                    checkXlsx(bytes);
                } else if (name.endsWith(".csv")) {
                    checkCsv(bytes);
                }

                zis.closeEntry();
            }
        }
    }

    void checkPdf(byte[] bytes) throws Exception {
        try (PDDocument doc = Loader.loadPDF(bytes)) {
            String text = new PDFTextStripper().getText(doc);
            System.out.println("PDF text: " + text);
            assertFalse(text.isBlank(), "PDF не должен быть пустым");
        }
    }

    void checkXlsx(byte[] bytes) throws Exception {
        try (XSSFWorkbook wb = new XSSFWorkbook(new ByteArrayInputStream(bytes))) {
            var sheet = wb.getSheetAt(0);
            var firstRow = sheet.getRow(0);
            assertNotNull(firstRow, "Первая строка не должна быть null");
            String cellValue = firstRow.getCell(0).getStringCellValue();
            System.out.println("XLSX first cell: " + cellValue);
            assertFalse(cellValue.isBlank(), "Ячейка не должна быть пустой");
        }
    }

    void checkCsv(byte[] bytes) throws Exception {
        String content = new String(bytes);
        System.out.println("CSV content:\n" + content);
        String[] lines = content.split("\n");
        assertTrue(lines.length > 0, "CSV не должен быть пустым");
    }
}