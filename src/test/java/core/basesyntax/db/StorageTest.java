package core.basesyntax.db;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StorageTest {

    @BeforeEach
    void setUp() {
        Storage.fruitStorage.clear();
    }

    @Test
    void generate_Ok() {
        Storage.fruitStorage.put("banana", 20);
        assertEquals(20, Storage.fruitStorage.get("banana"));
    }

    @Test
    void updateFruitQuantity() {
        Storage.fruitStorage.put("apple", 15);
        Storage.fruitStorage.put("apple", 20);
        assertEquals(20, Storage.fruitStorage.get("apple"));
    }

    @Test
    void removeFruit_Ok() {
        Storage.fruitStorage.put("apple", 20);
        Storage.fruitStorage.remove("apple");
        assertFalse(Storage.fruitStorage.containsKey("apple"));
    }

    @Test
    void storageInitiallyEmpty_Ok() {
        assertTrue(Storage.fruitStorage.isEmpty());
    }

    @Test
    void multipleFruits_Ok() {
        Storage.fruitStorage.put("apple", 20);
        Storage.fruitStorage.put("banana", 15);
        Storage.fruitStorage.put("cherry", 25);
        assertEquals(3, Storage.fruitStorage.size());
    }
}
