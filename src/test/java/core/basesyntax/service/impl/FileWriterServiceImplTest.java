package core.basesyntax.service.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import core.basesyntax.service.FileWriterService;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileWriterServiceImplTest {
    private static final String REPORT = "fruit,quantity" + System.lineSeparator()
            + "banana,20" + System.lineSeparator();
    private static final String FILE_PATH = "src/test/resources/finalReport.csv";
    private FileWriterService writerService;

    @BeforeEach
    void setUp() {
        writerService = new FileWriterServiceImpl();
    }

    @Test
    void writeReport_Ok() {
        writerService.write(REPORT, FILE_PATH);
        assertTrue(Files.exists(Path.of(FILE_PATH)));
    }

    @Test
    void invalidFilePath_NotOk() {
        String actualPath = "invalid/file/path/finalReport.csv";
        assertThrows(RuntimeException.class, () -> writerService.write(REPORT, actualPath));
    }

    @Test
    void invalidReport_NotOk() {
        assertThrows(RuntimeException.class, () -> {
            writerService.write(null, FILE_PATH);
        });
    }
}
