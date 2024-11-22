import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HoodieNumberTest {

    @Test
    void testCountHoodies() {

        int xProperty = 42;
        Clothing hoodie = new Clothing("hoodie");
        ClothesInfo[] items = {new ClothesInfo("Medium", "Blue", 29.99)};
        Inventory inventory = new Inventory(hoodie, items);
        String clothingType = "Hoodie";

        HoodieNumber hoodieNumber = new HoodieNumber(xProperty, inventory, clothingType);


        hoodieNumber.countHoodies();

        assertEquals(1, items.length);
    }


}
