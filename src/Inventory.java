// Inventory.java
public class Inventory implements DI {
    private Clothing clothingMember;
    private ClothesInfo[] cArrayMember;

    public Inventory(Clothing clothingMember, ClothesInfo[] cArrayMember) {
        this.clothingMember = clothingMember;
        this.cArrayMember = cArrayMember;
    }

    public Clothing getClothingMember() {
        return clothingMember;
    }

    public ClothesInfo[] getCArrayMember() {
        return cArrayMember;
    }
    public void setCArrayMember(ClothesInfo[] cArrayMember) {
        this.cArrayMember = cArrayMember;
    }

    @Override
    public void displayInfo() {
        System.out.println("Inventory class is displaying information.");
    }
}
