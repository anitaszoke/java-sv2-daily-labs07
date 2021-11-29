package day05;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {

    Store store = new Store();

    @TempDir
    File tempDir;

    @BeforeEach
    void init() {
        store.addProduct(new Product("milk", LocalDate.of(2021, 11, 24), 300));
    }

    @Test
    void testAddCorrectProduct() {
        assertEquals(1, store.getProducts().size());
        assertEquals("milk", store.getProducts().get(0).getProductName());
    }

    @Test
    void testAddWrongProduct() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class,
                () -> store.addProduct(new Product("bread", LocalDate.of(2021, 11, 30), 400)));
        assertEquals("Out of date.", iae.getMessage());
    }

    @Test
    void testWriteFile() throws IOException {
        Path dir = tempDir.toPath();

        Path resultPath = store.writeProductListByMonth(Month.NOVEMBER, dir);
        List<String> result = Files.readAllLines(resultPath);
        assertEquals(1, result.size());
        assertEquals("milk", result.get(0).split(";")[0]);
    }
}