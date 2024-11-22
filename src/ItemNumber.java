
public class ItemNumber implements DI {
    private double yProperty;
    private Inventory inventory;
    private String clothingType;

    public ItemNumber(double yProperty, Inventory inventory, String clothingType) {
        this.yProperty = yProperty;
        this.inventory = inventory;
        this.clothingType = clothingType;
    }


    @Override
    public void displayInfo() {

        displayTotalItems();
    }
    void displayTotalItems() {
        Clothing clothing = inventory.getClothingMember();
        ClothesInfo[] items = inventory.getCArrayMember();

        System.out.println("Number of " + clothingType + ": " + items.length);

        System.out.println();
    }

    public String getClothingType() {
        return this.clothingType;
    }

    public double getyProperty() {
        return yProperty;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
