import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.*;

class DisplayInfoTest {

    @Test
    void testDisplayInfo() {

        double yProperty = 3.14;
        Clothing clothing = new Clothing("Hat");
        ClothesInfo[] items = {new ClothesInfo("Medium", "Red", 19.99), new ClothesInfo("Large", "Blue", 24.99)};
        Inventory inventory = new Inventory(clothing, items);
        String clothingType = "Hats";

        ItemNumber itemNumber = new ItemNumber(yProperty, inventory, clothingType);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        itemNumber.displayInfo();

        System.setOut(System.out);

        String expectedOutput = "Number of Hats: " + items.length + System.lineSeparator() + System.lineSeparator();
        assertEquals(expectedOutput, outputStream.toString());
    }


}
