import java.sql.*;

public class JdbcTest {
    public static void main(String[] args) {
        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/category", "root", "");
                Statement stmt = conn.createStatement();
                ){
            String strSelect = "select genre, nameCate from tblcategory";
            System.out.println(strSelect + "\n");
            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println("The reconds selected are: ");
            int rCount = 0;
            while (rset.next()){
                int genre = rset.getInt("genre");
                String nameCate = rset.getString("nameCate");
                System.out.println(genre + ", " + nameCate );
                ++rCount;
            }
            System.out.println("Total number of records = " + rCount);
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
