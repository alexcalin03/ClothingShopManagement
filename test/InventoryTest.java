import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class InventoryTest {

    @Test
    void testInventoryConstructor() {
        Clothing clothing = new Clothing("hoodie");
        ClothesInfo[] clothesInfoArray = new ClothesInfo[5];
        Inventory inventory = new Inventory(clothing, clothesInfoArray);
        assertEquals(clothing, inventory.getClothingMember());
        assertEquals(clothesInfoArray, inventory.getCArrayMember());
    }


}