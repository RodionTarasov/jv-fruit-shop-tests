package core.basesyntax.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReportServiceImplTest {
    private ReportService reportService;

    @BeforeEach
    void setUp() {
        reportService = new ReportServiceImpl();
        Storage.fruitStorage.clear();
    }

    @Test
    void emptyReport_Ok() {
        String expected = "fruit,quantity" + System.lineSeparator();
        String actual = reportService.generateReport();
        assertEquals(expected, actual);
    }

    @Test
    void oneFruit_Ok() {
        String expected = "fruit,quantity" + System.lineSeparator()
                + "apple,10" + System.lineSeparator();
        Storage.fruitStorage.put("apple", 10);
        String actual = reportService.generateReport();
        assertEquals(expected, actual);
    }
}
