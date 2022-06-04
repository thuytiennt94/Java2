import java.sql.*;

public class JdbcCommitCatchTest {
    public static void main(String[] args) throws SQLException {
        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop", "root", "");
                Statement stmt = conn.createStatement();
                ){
            try {
                conn.setAutoCommit(false);//
                //stmt.executeUpdate("insert into books values (4001, 'Paul Chan', 'Mahjong 101', 4.4, 4)");
                //duplicate primary key which triggers a SQLException
                //stmt.executeUpdate("insert into books values (4001, 'Peter Chan', 'Mahjong 102', 4.4, 4)");
                //conn.commit();//commit changes only if all statement succeed
                ResultSet rset = stmt.executeQuery("select id, qty from books where id in (1001,1002)");
                System.out.println("-- Before Update --");
                while(rset.next()){
                    System.out.println(rset.getInt("id") + ", " + rset.getInt("qty"));
                }
                conn.commit();//commit select

                //issue
                stmt.executeUpdate("update books set qty = qty + 1 where id = 1001");
                stmt.executeUpdate("update books set qty = qty + 1 where id = 1002");
                conn.commit();//commit update

                rset = stmt.executeQuery("select id, qty from books where id in (1001,1002)");
                System.out.println("-- After updte and commit --");
                while(rset.next()){
                    System.out.println(rset.getInt("id") + ", " + rset.getInt("qty"));
                }
                conn.commit();//commit select

                //issue
                stmt.executeUpdate("update books set qty = qty - 99  where id = 1001");
                stmt.executeUpdate("update books set qty = qty - 99 where id = 1002");
                conn.rollback();//commit update

                rset = stmt.executeQuery("select id, qty from books where id in (1001,1002)");
                System.out.println("-- After updte and rollback--");
                while(rset.next()){
                    System.out.println(rset.getInt("id") + ", " + rset.getInt("qty"));
                }
                conn.commit();//commit select

            }catch(SQLException ex){
                System.out.println("-- Rolling back changes --");
                conn.rollback();
                ex.printStackTrace();
            }
        }
    }
}
