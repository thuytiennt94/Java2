import java.sql.*;
public class JdbcInsertTest {
    public static void main(String[] args) {
        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop", "root", "");
                Statement stmt = conn.createStatement();
                ){
            String sqlDelete = "delete from books where id >= 3000 and id <= 4000";
            System.out.println("The sql statement is: " + sqlDelete + "\n");
            int countDelete = stmt.executeUpdate(sqlDelete);
            System.out.println(countDelete);

            //insert
            String sqlInsert = "insert into books values (3001, 'Gone Fishing','Kumar', 11.11, 11)";
            System.out.println("The sql statement is" + sqlInsert + "\n");
            int countInsert = stmt.executeUpdate(sqlInsert);
            System.out.println(countInsert);

            //insert multiple
            sqlInsert = "insert into books values " + "(3002, 'Gone Fishing 2', 'Kumar', 22.22, 22), " + "(3003, 'Gone FIshing 3', 'Kumar', 33.33, 33)";
            System.out.println("the sql statement is: " + sqlInsert + "\n");
            countInsert = stmt.executeUpdate(sqlInsert);
            System.out.println(countInsert);
            //insert
            sqlInsert = "insert into books (id, title, author) values (3004, 'Gone Fishing 4', 'Kumar')";
            System.out.println("the sql statement is: " + sqlInsert + "\n");
            countInsert = stmt.executeUpdate(sqlInsert);
            System.out.println(countInsert);

            //insert
            String strSelect = "select * from books";
            System.out.println("the sql statement is: " + strSelect + "\n");
            ResultSet rset = stmt.executeQuery(strSelect);
            while (rset.next()){
                System.out.println(rset.getInt("id") + ","
                + rset.getString("author") + ", " + rset.getString("title") + ", " 
                + rset.getDouble("price") + ", "+ rset.getInt("qty"));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}
