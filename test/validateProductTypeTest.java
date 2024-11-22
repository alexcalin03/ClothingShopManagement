import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class validateProductTypeTest {

    @Test
    void testValidateProductType() {

        assertDoesNotThrow(() -> ClothingShopManagement.validateProductType("hat"));
        assertDoesNotThrow(() -> ClothingShopManagement.validateProductType("hoodie"));
        assertDoesNotThrow(() -> ClothingShopManagement.validateProductType("pant"));

        assertThrows(InvalidProductException.class, () -> ClothingShopManagement.validateProductType("shirt"));
        assertThrows(InvalidProductException.class, () -> ClothingShopManagement.validateProductType("shoes"));
        assertThrows(InvalidProductException.class, () -> ClothingShopManagement.validateProductType("invalid"));
    }
}
