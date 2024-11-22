
public class HoodieNumber implements CH {
    private int xProperty;
    private Inventory inventory;
    private String clothingType;

    public HoodieNumber(int xProperty, Inventory inventory, String clothingType) {
        this.xProperty = xProperty;
        this.inventory = inventory;
        this.clothingType = clothingType;
    }

    @Override
    public void countHoodies() {


        countTotalItems();
    }

    private void countTotalItems() {
        Clothing clothing = inventory.getClothingMember();
        ClothesInfo[] items = inventory.getCArrayMember();

        System.out.println("Number of Hoodies: " + items.length);

        System.out.println();
    }
}
