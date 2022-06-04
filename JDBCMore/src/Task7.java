import java.sql.*;
import java.util.Scanner;
public class Task7 {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/subjects", "root", "");
                PreparedStatement pstmt = conn.prepareStatement("insert into tblsubject values (?, ?)");
                PreparedStatement ptmtSelect = conn.prepareStatement("select * from tblsubject");
                PreparedStatement pstmt1 = conn.prepareStatement("update namesubject = ? from tblsubject where id =?");
                PreparedStatement pstmt2 = conn.prepareStatement("delete from tblsubject where id = ?");
                Statement stmt = conn.createStatement();
        ) {
            try {
//            pstmt.setInt(1,4);
//            pstmt.setString(2,"Lys");
//            int rowsinserted = pstmt.executeUpdate();
//            System.out.println(rowsinserted + "rows affexted");
//
//            pstmt.setInt(1, 5);
//            pstmt.setString(2,"Văn");
//            int rowsinserted = pstmt.executeUpdate();
//            System.out.println(rowsinserted + "rows affexted");

//            update
//            pstmt1.setInt(1, Integer.parseInt("anh"));
//            pstmt1.setString(2, String.valueOf(4));
//            int rUpdate = pstmt1.executeUpdate();
//            System.out.println(rUpdate);

                //delete
//            pstmt2.setInt(1, 5);
//            int rDelete = pstmt2.executeUpdate();
//            System.out.println(rDelete);

                //search
                conn.setAutoCommit(false);
                Scanner scanner = new Scanner(System.in);
                System.out.print("Nhap ID cần tìm: ");
                int id = scanner.nextInt();
                String sqlSearch = "select * from tblsubject where id = " + id;
                System.out.println("The SQL statement is: " + sqlSearch + "\n");
//                int countSearch = stmt.executeUpdate(sqlSearch);
//                System.out.println(countSearch);
                conn.commit();

                ResultSet rset = ptmtSelect.executeQuery();
                while (rset.next()) {
                    System.out.println(rset.getInt("id") + ", " + rset.getString("namesubject"));
                }

            } catch (SQLException e) {
                conn.rollback();
                e.printStackTrace();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
