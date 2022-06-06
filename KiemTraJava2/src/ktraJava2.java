import java.sql.*;
import java.util.Scanner;
public class ktraJava2 {
    public static void main(String[] args) throws SQLException{
        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema", "root", "");
                PreparedStatement pstmtInsert = conn.prepareStatement("insert into tblcinema values (?,?,?,?,?)");
                PreparedStatement pstmtUpdate = conn.prepareStatement("update tblcinema set maphim = ? where tenphim = ?");
                PreparedStatement pstmtDelete = conn.prepareStatement("delete from tblcinema where maphim = ? ");
                PreparedStatement pstmtSearch = conn.prepareStatement("Select * from  tblcinema where maphim = ?");
                PreparedStatement pstmtSelect = conn.prepareStatement("select * from tblcinema");
                ) {
            try {
                //insert
                Scanner scn = new Scanner(System.in);
                System.out.print("Nhap ma phim : ");
                String id1 = scn.nextLine();
                Scanner scn1 = new Scanner(System.in);
                System.out.print("Nhap ten phim : ");
                String id2 = scn1.nextLine();
                Scanner scn2 = new Scanner(System.in);
                System.out.print("Nhap giờ khởi chiếu : ");
                String id3 = scn2.nextLine();
                Scanner scn3 = new Scanner(System.in);
                System.out.print("Nhap đạo diến : ");
                String id4 = scn3.nextLine();
                Scanner scn4 = new Scanner(System.in);
                System.out.print("Nhap thời gian : ");
                Integer id5 = scn4.nextInt();
                pstmtInsert.setString(1, id1);
                pstmtInsert.setString(2, id2);
                pstmtInsert.setString(3, id3);
                pstmtInsert.setString(4, id4);
                pstmtInsert.setInt(5, id5);
                System.out.println(pstmtInsert);
                pstmtInsert.executeUpdate();
                System.out.println("insert done");
                ResultSet rset = pstmtSelect.executeQuery();
                while (rset.next()){
                    System.out.println(rset.getString("maphim") + ", "
                            + rset.getString("tenphim") + ", "
                            + rset.getString("giochieu") + ", "
                            + rset.getString("daodien") + ", "
                            + rset.getInt("time"));
                }
                System.out.println("----------------------------");

                //Update
                Scanner scnUpdate1 = new Scanner(System.in);
                System.out.print("Nhap mã phim : ");
                String iUpdate1 = scnUpdate1.nextLine();
                Scanner scnUpdate2 = new Scanner(System.in);
                System.out.print("Nhap tên phim : ");
                String iUpdate2 = scnUpdate2.nextLine();
                pstmtUpdate.setString(1, iUpdate1);
                pstmtUpdate.setString(2, iUpdate2);
                System.out.println(pstmtUpdate);
                pstmtUpdate.executeUpdate();
                System.out.println("Update done");
                System.out.println("----------------------------");

                //delete
                Scanner scnDelete = new Scanner(System.in);
                System.out.print("Nhap mã phim : ");
                String iDelete = scnDelete.nextLine();
                pstmtDelete.setString(1, iDelete);
                System.out.println(pstmtDelete);
                pstmtDelete.executeUpdate();
                System.out.println("Delete done");
                System.out.println("----------------------------");

                //search
                Scanner scnSearch = new Scanner(System.in);
                System.out.print("Nhap mã phim : ");
                String iSearch = scnSearch.nextLine();
                pstmtSearch.setString(1, iSearch);
                System.out.println(pstmtSearch);
                
                rset = pstmtSelect.executeQuery();
                while (rset.next()) {
                    System.out.println(rset.getString("maphim") + ", " + rset.getString("tenphim")
                            + ", " + rset.getString("giochieu") + ", " + rset.getString("daodien")
                            + ", " + rset.getInt("time"));
                }
                conn.commit();
            } catch (SQLException ex) {

                ex.printStackTrace();
            }
        }
    }
}
