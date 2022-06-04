import java.sql.*;
import java.util.Scanner;

public class JdbcTest3 {
    public static void main(String[] args) {
        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/diemthithptqg" ,"root","");
                Statement stmt = conn.createStatement();
        ){
            //delete
            System.out.println("nhập giá trị id cần xoá: ");
            Scanner scnDelete = new Scanner(System.in);
            String snDelete = scnDelete.nextLine();
            String sqlDelete = "delete from diem where id = " + snDelete;
            System.out.println(sqlDelete);
            int countDelete = stmt.executeUpdate(sqlDelete);
            System.out.println(countDelete);

            String strSelect = "select * from Diem";
            System.out.println(strSelect + "\n");
            ResultSet rset = stmt.executeQuery(strSelect);
            while(rset.next()){
                System.out.println(rset.getInt("id") + "\n"
                        + rset.getString("name") + ", " + rset.getString("SBD") + ", "
                        + rset.getDouble("monToan")  + ", "
                        + rset.getDouble("monVan" )  + ", "
                        + rset.getDouble("monAnh")  + ", " + rset.getString("monTohop")
                        +rset.getDouble("diemTohop"));
            }
            String sqlInsert = "insert into Diem values " +
                    "(5, N'Dũng', 'SBD2125', 8,7.75,7.5,N'Sử - Địa - GDCD', 7.6), "
                    + " (6, N'Trung', 'SBD2126', 9.6,8.75,8,N'Lý - Hoá - Sinh', 8.4), ";
            System.out.println(sqlInsert + "\n");
            int countInsert = stmt.executeUpdate(sqlInsert);
            System.out.println(countInsert);



            //tim du lieu
            System.out.println("--------------");
            Scanner scn = new Scanner(System.in);
            String snID = scn.nextLine();
            String sqlID = "select * from diem where ID = " + snID;
            System.out.println(sqlID);
            int cInsert = stmt.executeUpdate(sqlID);
            System.out.println(cInsert);
            strSelect = "select * from Diem";
            System.out.println(strSelect + "\n");
            rset = stmt.executeQuery(strSelect);
            while(rset.next()){
                System.out.println(rset.getInt("id") + "\n"
                        + rset.getString("name") + ", " + rset.getString("SBD") + ", "
                        + rset.getDouble("monToan")  + ", "
                        + rset.getDouble("monVan" )  + ", "
                        + rset.getDouble("monAnh")  + ", " + rset.getString("monTohop")
                        +rset.getDouble("diemTohop"));
            }
            
            strSelect = "select * from Diem";
            System.out.println(strSelect + "\n");
            rset = stmt.executeQuery(strSelect);
            while(rset.next()){
                System.out.println(rset.getInt("id") + "\n"
                        + rset.getString("name") + ", " + rset.getString("SBD") + ", "
                        + rset.getDouble("monToan")  + ", "
                        + rset.getDouble("monVan" )  + ", "
                        + rset.getDouble("monAnh")  + ", " + rset.getString("monTohop")
                        +rset.getDouble("diemTohop"));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
    }
}
