import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClothingTest {

    @Test
    void testClothingConstructor() {
        Clothing clothing = new Clothing("hoodie");
        assertEquals("hoodie", clothing.getType());
    }


}