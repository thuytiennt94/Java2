import java.sql.*;
import java.util.Scanner;

public class JdbcTest2 {
    public static void main(String[] args) {
        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer", "root", "");
                Statement stmt = conn.createStatement();
                ){
            //tim khasch hang
            System.out.println("Nhap ");
            Scanner sn = new Scanner(System.in);
            String searchname = sn.nextLine();
            String sSelectname = "select * from customers where CompanyName like '%" + searchname + "%'";
            ResultSet rset2 = stmt.executeQuery(sSelectname);
            int rCount = 0;
            while (rset2.next()){
                String CustomerID = rset2.getString("CustomerID");
                String CompanyName = rset2.getString("CompanyName");
                System.out.println(CustomerID + " , " + CompanyName);
                ++rCount;
            }
            System.out.println("SearchName: " + rCount);

            //3.hien thi san pham
            System.out.println("--------------------");
            String strSelect = "select * from products ";
            System.out.println("title = " + strSelect + "\n");
            ResultSet rset = stmt.executeQuery(strSelect);
            System.out.println("the records selected are: ");
            int rowCount = 0;
            while(rset.next()){
                int ProductID = rset.getInt("ProductID");
                String ProductName = rset.getString("ProductName");

                System.out.println(ProductID + ", " + ProductName);
                ++rowCount;
            }
            System.out.println("total number of records = " + rowCount);

            //tim san pham theo gia nhap vao
            System.out.println("------------");
            System.out.println("Nhap: ");
            Scanner sn1 = new Scanner(System.in);
            String price1 = sn1.nextLine();
            Scanner sn2 = new Scanner(System.in);
            String price2 = sn2.nextLine();
            String strSelect1 = "select ProductName from products where UnitPrice > " + price1 + " and UnitPrice < " + price2 ;
            System.out.println(strSelect + "\n") ;
            ResultSet rset3 = stmt.executeQuery(strSelect);
            System.out.println("the records selected are: ");
            while(rset3.next()){
                String ProductName = rset3.getString("ProductName");
                double UnitPrice = rset3.getDouble("UnitPrice");
                System.out.println(ProductName + " - " + UnitPrice);
                ++rowCount;
            }
            System.out.println("total number of records = " + rowCount);
            
            //Hieern thij thong tin chi tiet của 1 khach hang

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
