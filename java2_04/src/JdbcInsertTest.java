import java.sql.*;
import java.util.Scanner;

public class JdbcInsertTest {
    public static void main(String[] args) {
        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop", "root", "");
                Statement stmt = conn.createStatement();
                ) {
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

            //delete books where id >8000;
            System.out.println("-----------");
            String sqlDELETE = "delete from books where id > 8000";
            System.out.println(sqlDELETE + "\n");
            countDelete = stmt.executeUpdate(sqlDELETE);
            System.out.println(countDelete);

            //2.insert into 2 bản ghi
            System.out.println("-----------");
            sqlInsert = "insert into books values " +
                    "(8001, 'java core' ,'dang thi kim',15.55,15), " + "(8002,'java advanced', 'jamer osling', 25.55,25)";
            System.out.println(sqlInsert + "\n");
            countInsert = stmt.executeUpdate(sqlInsert);
            System.out.println(countInsert);

            //3.insert 1 book
            System.out.println("-----------");
            String sqlInsert1 = "insert into books(id, title, author) values (2005, 'java jdbc my sql' , 'thidk')";
            System.out.println(sqlInsert1 + "\n");
            int countInsert1 = stmt.executeUpdate(sqlInsert1);
            System.out.println(countInsert1);

            //4.xoá thêm 1 cuốn sách voới id = 2001
            System.out.println("-----------");
            String sqlDelete1 = "delete from books where id = 2001";
            System.out.println(sqlDelete);
            int countDelete1 = stmt.executeUpdate(sqlDelete1);
            System.out.println(countDelete1);

            //5.thêm 1 bản ghi hoàn chỉnh
            System.out.println("------------");
            System.out.println("Nhap: ");
            Scanner sntitle = new Scanner(System.in);
            String title = sntitle.nextLine();
            Scanner snauthor = new Scanner(System.in);
            String author = snauthor.nextLine();
            Scanner snprice = new Scanner(System.in);
            String price = snprice.nextLine();
            String sqlInsert3 = "title " + sntitle + ", author = " + snauthor + ", price = " + snprice;
            System.out.println(sqlInsert3);
            int countInsert2 = stmt.executeUpdate(sqlInsert3);
            System.out.println(countInsert2);

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
