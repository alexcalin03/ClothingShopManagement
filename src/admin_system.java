import java.sql.*;

public class admin_system {
    private static final String jdbc_url="jdbc:mysql://localhost:3306/clothing_shop";
    private static final String username="root";
    private static final String password="Championsleague@0";

    public void printFromDb(){
        String sqlQuery = "select * from inventory";

        try {
            int i=1;
            String checkType = "type";
            Connection connection=DriverManager.getConnection(jdbc_url,username,password);
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                String type = resultSet.getString("type");
                String size = resultSet.getString("size");
                String color = resultSet.getString("color");
                Double price = resultSet.getDouble("price");
                if(!checkType.equals(type)){
                    System.out.println("Inventory for " + type + "s:");
                    checkType = type;
                    i = 1;
                }
                System.out.println("Item " + (i++) + ": Size - " + size + ", Color - " + color +
                        ", Price - $" + price);

            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    public void addToDb(Inventory inventory){
        for(int i =0; i<= inventory.getCArrayMember().length-1;i++){
        String type= inventory.getClothingMember().getType();
        String color= inventory.getCArrayMember()[i].getColor();
        String size= inventory.getCArrayMember()[i].getSize();
        Double price= inventory.getCArrayMember()[i].getPrice();
        try{
            Connection connection=DriverManager.getConnection(jdbc_url,username,password);
            String sqlQuery = "INSERT INTO inventory (type,size,color,price) VALUES (?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, type);
            preparedStatement.setString(2, size);
            preparedStatement.setString(3, color);
            preparedStatement.setDouble(4, price);
            preparedStatement.executeUpdate();
        }catch (Exception e)
        {
            e.printStackTrace();
        }}
    }
    public void clearDb(){
        try{
            Connection connection=DriverManager.getConnection(jdbc_url,username,password);
            String sqlQuery = "delete from inventory";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.executeUpdate();
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
