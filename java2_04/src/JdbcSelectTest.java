import java.sql.*;
public class JdbcSelectTest {   //save ad JdbcSelectTest.java
    public static void main(String[] args) throws SQLException {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql:// localhost:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&severTimezone=UTC",
                        "root","");
                Statement stmt = conn.createStatement();
                ){
            String strSelect = "select title, price, qty from books";
            System.out.println("the SQL statement is: " + strSelect + "\n");
            ResultSet rset = stmt.executeQuery(strSelect);

            //step4 process the resultSet by scrolling the cursor forward
            //for each row, retrieve the contents of the cells with getXXX()
            System.out.println("the records selected are: ");
            int rowCount = 0;
            while(rset.next()){
                String title = rset.getString("title");
                double price = rset.getDouble("price");
                int qty = rset.getInt("qty");
                System.out.println(title +", " + price +", " + qty);
                ++rowCount;
            }
            System.out.println("total number of records = " + rowCount);
        }catch(SQLException ex){
            ex.printStackTrace();
        }//step 5: close conn and stmt - done automatcally by try - with - resources
    }
}
