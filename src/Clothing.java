// Clothing.java
public class Clothing implements CH {
    private String type;

    public Clothing(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public void countHoodies() {
        System.out.println("Clothing class is performing an action.");
    }
}
