import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ItemNumberTest {

    @Test
    void testItemNumberConstructor() {

        double yProperty = 10.5;
        Inventory inventory = new Inventory(new Clothing("Shirt"), new ClothesInfo[]{});

        ItemNumber itemNumber = new ItemNumber(yProperty, inventory, "Shirt");


        assertNotNull(itemNumber);

        assertEquals(yProperty, itemNumber.getyProperty());
        assertEquals(inventory, itemNumber.getInventory());
        assertEquals("Shirt", itemNumber.getClothingType());
    }
}
