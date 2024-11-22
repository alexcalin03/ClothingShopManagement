import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClothesInfoTest {

    @Test
    void testClothesInfoConstructorAndGetters() {

        String size = "Medium";
        String color = "Blue";
        double price = 29.99;


        ClothesInfo clothesInfo = new ClothesInfo(size, color, price);


        assertEquals(size, clothesInfo.getSize());
        assertEquals(color, clothesInfo.getColor());
        assertEquals(price, clothesInfo.getPrice(), 0.01);
    }


}
