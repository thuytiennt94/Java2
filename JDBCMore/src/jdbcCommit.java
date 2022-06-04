import java.sql.*;
import java.util.Scanner;
public class jdbcCommit {
    public static void main(String[] args) throws SQLException{
        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/account", "root", "");
                Statement stmt = conn.createStatement();
                ){
            try {
                conn.setAutoCommit(false);
                Scanner scanner = new Scanner(System.in);
                System.out.print("Nhap ID nguoi chuyen: ");
                int ip = scanner.nextInt();
                int ip1;
                do {
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.print("Nhap So Tien Can Chuyen: ");
                    ip1 = scanner1.nextInt();
                } while (ip1 < 0);

                String sqlMoney = "update tbAccount set balance=balance-" + ip1 + " where id=" + ip;
                System.out.println("The SQL statement is: " + sqlMoney + "\n");
                int countInsert = stmt.executeUpdate(sqlMoney);

                Scanner scanner2 = new Scanner(System.in);
                System.out.print("Nhap ID nguoi Nhan: ");
                Integer ip2 = scanner2.nextInt();

                String sqlMoney2 = "update tbAccount set balance=balance+" + ip1 + " where id=" + ip2;
                System.out.println("The SQL statement is: " + sqlMoney2 + "\n");
                int countInsert2 = stmt.executeUpdate(sqlMoney2);
                conn.commit();
                String sqlSelect = "select * from tbAccount";
                ResultSet rset = stmt.executeQuery(sqlSelect);
                while (rset.next()) {
                    System.out.println(rset.getInt("id") + ", "
                            + rset.getString("name") + ", "
                            + rset.getDouble("balance")
                    );
                }
            }catch (SQLException ex) {
                System.out.println("Vui long nhap lai so tien.");
                conn.rollback();
                ex.printStackTrace();

            }
        }
    }
}