package qa.guru;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.*;

public class JsonTest {
    @Test
    void jsonFileParsingTest() throws Exception {
        ClassLoader cl = JsonTest.class.getClassLoader();
        ObjectMapper objectMapper = new ObjectMapper();

        try (InputStream is = cl.getResourceAsStream("test_data/student.json")) {
            Book book = objectMapper.readValue(is, Book.class);
            assertEquals("Materinskoe pole", book.book);
            assertEquals("Aitmatov", book.authors.get(0).name);
        }
    }
}