import java.util.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Random;
import java.io.FileNotFoundException;


public class ClothingShopManagement {
    public static void main(String[] args) {

        FileOutputStream fileStream = null;
        PrintStream filePrintStream = null;

        admin_system admin=new admin_system();
        admin.clearDb();


        try {

            fileStream = new FileOutputStream("outputFile.txt", false);
            filePrintStream = new PrintStream(fileStream);

            Clothing hoodieInstance = new Clothing("hoodie");
            ClothesInfo[] hoodieArray = generateRandomItems();
            Inventory hoodieInventory = new Inventory(hoodieInstance, hoodieArray);
            admin.addToDb(hoodieInventory);

            Clothing hatInstance = new Clothing("hat");
            ClothesInfo[] hatArray = generateRandomItems();
            Inventory hatInventory = new Inventory(hatInstance, hatArray);
            admin.addToDb(hatInventory);

            Clothing pantsInstance = new Clothing("pant");
            ClothesInfo[] pantsArray = generateRandomItems();
            Inventory pantsInventory = new Inventory(pantsInstance, pantsArray);
            admin.addToDb(pantsInventory);

            CH xInstance = new HoodieNumber(42, hoodieInventory, "Hoodie");
            ItemNumber yInstanceForHats = new ItemNumber(3.14, hatInventory, "Hats");
            ItemNumber yInstanceForPants = new ItemNumber(3.14, pantsInventory, "Pants");

//            displayInventoryToConsole(hoodieInventory);
//            displayInventoryToConsole(hatInventory);
//            displayInventoryToConsole(pantsInventory);
            admin.printFromDb();

            hoodieInstance.countHoodies();
            hatInventory.displayInfo();
            xInstance.countHoodies();

            yInstanceForHats.displayInfo();
            yInstanceForPants.displayInfo();

            displayInventoryToFile(hoodieInventory, filePrintStream);
            displayInventoryToFile(hatInventory, filePrintStream);
            displayInventoryToFile(pantsInventory, filePrintStream);


            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Menu:");
                System.out.println("1. Add a product");
                System.out.println("2. Exit program");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        try {
                            addProduct(scanner, hoodieInventory, hatInventory, pantsInventory, filePrintStream);
                        } catch (InventoryFullException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;
                    case 2:

                        System.out.println("Exiting program.");
                        filePrintStream.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please enter 1 or 2.");
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found. Check the file path.");
            e.printStackTrace(System.err);
        } catch (IOException e) {
            e.printStackTrace(System.err);
        } finally {
            try {
                if (filePrintStream != null) {
                    filePrintStream.close();
                }
                if (fileStream != null) {
                    fileStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static ClothesInfo[] generateRandomItems() {
        Random random = new Random();
        int itemCount = random.nextInt(5) + 3;
        String[] sizes = {"Xtra small", "Small", "Medium", "Large", "Xtra large"};
        String[] colors = {"Red", "Blue", "Green", "Black", "White", "Orange", "Yellow", "Purple", "Pink"};
        double[] prices = {19.99, 24.99, 29.99, 14.99, 12.99, 15.99, 13.99, 39.99, 42.99, 37.99, 44.99, 40.99};

        ClothesInfo[] items = new ClothesInfo[itemCount];
        for (int i = 0; i < itemCount; i++) {
            String size = sizes[random.nextInt(sizes.length)];
            String color = colors[random.nextInt(colors.length)];
            double price = prices[random.nextInt(prices.length)];
            items[i] = new ClothesInfo(size, color, price);
        }

        return items;
    }

    protected static void displayInventoryToConsole(Inventory inventory) {
        Clothing clothing = inventory.getClothingMember();
        ClothesInfo[] items = inventory.getCArrayMember();

        System.out.println("Inventory for " + clothing.getType() + "s:");

        for (int i = 0; i < items.length; i++) {
            ClothesInfo item = items[i];
            System.out.println("Item " + (i + 1) + ": Size - " + item.getSize() + ", Color - " + item.getColor() +
                    ", Price - $" + item.getPrice());
        }

        System.out.println();
    }

    private static void displayInventoryToFile(Inventory inventory, PrintStream filePrintStream) {
        Clothing clothing = inventory.getClothingMember();
        ClothesInfo[] items = inventory.getCArrayMember();

        filePrintStream.println("Inventory for " + clothing.getType() + "s:");

        for (int i = 0; i < items.length; i++) {
            ClothesInfo item = items[i];
            filePrintStream.println("Item " + (i + 1) + ": Size - " + item.getSize() + ", Color - " + item.getColor() +
                    ", Price - $" + item.getPrice());
        }

        filePrintStream.println();
    }

    static void displayEntireInventory(Inventory hoodieInventory, Inventory hatInventory, Inventory pantsInventory, PrintStream filePrintStream) {
        displayInventoryToConsole(hoodieInventory);
        displayInventoryToConsole(hatInventory);
        displayInventoryToConsole(pantsInventory);

        displayInventoryToFile(hoodieInventory, filePrintStream);
        displayInventoryToFile(hatInventory, filePrintStream);
        displayInventoryToFile(pantsInventory, filePrintStream);
    }


    protected static void addProduct(Scanner scanner, Inventory hoodieInventory, Inventory hatInventory, Inventory pantsInventory, PrintStream filePrintStream) throws InventoryFullException {
        System.out.println("Enter the type of product (hat, hoodie, or pant): ");
        String productType = scanner.nextLine().toLowerCase();

        try {
            validateProductType(productType);

            Clothing clothingInstance = new Clothing(productType);

            Inventory productInventory = getProductInventory(productType, hoodieInventory, hatInventory, pantsInventory);

            String[] sizes = {"Xtra small", "Small", "Medium", "Large", "Xtra large"};
            String[] colors = {"Red", "Blue", "Green", "Black", "White", "Orange", "Yellow", "Purple", "Pink"};
            Double[] prices = {19.99, 24.99, 29.99, 14.99, 12.99, 15.99, 13.99, 39.99, 42.99, 37.99, 44.99, 40.99};

            addProductToInventory(productInventory, clothingInstance, sizes, colors, prices);

            filePrintStream.close();

            filePrintStream = new PrintStream(new FileOutputStream("outputFile.txt"));

            displayEntireInventory(hoodieInventory, hatInventory, pantsInventory, filePrintStream);

            System.out.println("Product added to inventory.");
        } catch (InvalidProductException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error updating the file: " + e.getMessage());
        }
    }



    static void addProductToInventory(Inventory inventory, Clothing product, String[] sizes, String[] colors, Double[] prices) throws InventoryFullException {

        if (inventory.getCArrayMember().length >= 10) {
            throw new InventoryFullException("Inventory is full. Cannot add more items.");
        }

        Clothing clothing = inventory.getClothingMember();
        ClothesInfo[] items = inventory.getCArrayMember();

        ClothesInfo[] newItems = Arrays.copyOf(items, items.length + 1);

        String size = sizes[new Random().nextInt(sizes.length)];
        String color = colors[new Random().nextInt(colors.length)];
        Double price = prices[new Random().nextInt(prices.length)];
        newItems[items.length] = new ClothesInfo(size, color, price);

        inventory.setCArrayMember(newItems);
    }



    protected static Inventory getProductInventory(String productType, Inventory hoodieInventory, Inventory hatInventory, Inventory pantsInventory) {
        switch (productType) {
            case "hat":
                return hatInventory;
            case "hoodie":
                return hoodieInventory;
            case "pant":
                return pantsInventory;
            default:
                try {
                    throw new InvalidProductException("Invalid product type. Please enter hat, hoodie, or pant.");
                } catch (InvalidProductException e) {
                    throw new RuntimeException(e);
                }
        }
    }

    static void validateProductType(String productType) throws InvalidProductException {
        if (!"hat".equals(productType) && !"hoodie".equals(productType) && !"pant".equals(productType)) {
            throw new InvalidProductException("Invalid product type. Please enter hat, hoodie, or pant.");
        }
    }
}
