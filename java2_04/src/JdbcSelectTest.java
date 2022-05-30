import java.sql.*;
import java.util.Scanner;

public class JdbcSelectTest {   //save ad JdbcSelectTest.java
    public static void main(String[] args) {
        try (
                //step1 allocate a database 'connection' object
                Connection conn = DriverManager.getConnection("jdbc:mysql:// localhost:3306/ebookshop", "root",""); // for mysql only
                //the format is 'jdbc:mysql://hostname:port/database,"usename", "password"

                //step2; allocate w 'statement' object in te connection
                Statement stmt = conn.createStatement();
                ){
            //step3 excute a sql select query. the query result is returned in a 'result'
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
/*
* 1.tạo ra 1 kết nối cơ sở dữ liệu dối tượng đó là connection
* 2.tạo ra đối tượng câu lệnh statêmnt theo connection để giứ lệnh sql
* 3. viết 1 tuy vấn sel và thực hiện truy vấn thông qua statement và connection được tạo ra
* 4. xử lý keest quar truy vấn
* 5. đóng statement và connectioon giải phóng tài nguyên
*/