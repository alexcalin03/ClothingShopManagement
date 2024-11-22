import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class AddProductFunctionTest {

    @Test
    void testAddProduct() throws InventoryFullException, IOException {
        Scanner scanner = new Scanner(new ByteArrayInputStream("hat\n".getBytes()));
        Inventory hoodieInventory = new Inventory(new Clothing("hoodie"), new ClothesInfo[0]);
        Inventory hatInventory = new Inventory(new Clothing("hat"), new ClothesInfo[0]);
        Inventory pantsInventory = new Inventory(new Clothing("pant"), new ClothesInfo[0]);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream filePrintStream = new PrintStream(outputStream);

        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        ClothingShopManagement.addProduct(scanner, hoodieInventory, hatInventory, pantsInventory, filePrintStream);

        System.setOut(originalOut);

        assertEquals(1, hatInventory.getCArrayMember().length);

        assertTrue(outputStream.toString().contains("Product added to inventory."));
    }

}
