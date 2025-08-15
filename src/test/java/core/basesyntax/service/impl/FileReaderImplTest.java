package core.basesyntax.service.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import core.basesyntax.service.FileReader;
import java.util.List;
import org.junit.jupiter.api.Test;

class FileReaderImplTest {
    private static final String INPUT_FILE_PATH = "src/test/resources/reportToRead.csv";
    private FileReader fileReader = new FileReaderImpl();

    @Test
    void addString_Ok() {
        List<String> actual = fileReader.read(INPUT_FILE_PATH);
        assertTrue(actual.contains("b,banana,20"));
        assertTrue(actual.contains("b,apple,100"));
    }

    @Test
    void invalidFilePath_NotOk() {
        assertThrows(RuntimeException.class, () -> {
            fileReader.read("invalid/path/reportToRead.csv");
        });
    }
}
