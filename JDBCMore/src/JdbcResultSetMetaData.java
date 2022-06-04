import java.sql.*;
public class JdbcResultSetMetaData {
    public static void main(String[] args) throws SQLException{
        try(
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop", "root", "");
                Statement stmt = conn.createStatement();
        ){
            try{
//                ResultSet rset = stmt.executeQuery("select * from books");
//                ResultSetMetaData rsetMD = rset.getMetaData();
//                int numColumns = rsetMD.getColumnCount();
//
//                for (int i = 1; i<= numColumns; ++i){
//                    System.out.printf("%-30s", "(" + rsetMD.getColumnClassName(i) + ")");
//                }
//                System.out.println();
//
//                //print column contents for all the rows
//                while (rset.next()){
//                    for (int i = 1; i<= numColumns; ++i){
//                        System.out.printf("%-30s", rset.getString(i));
//                    }
//                    System.out.println();
//                }

                conn.setAutoCommit(false);

                stmt.addBatch("insert into books values (8001, 'java abc','kevin jones', 1.1, 99");
                stmt.addBatch("insert into books values (8002, 'java xyz','kevin jones', 1.1, 99");
                stmt.addBatch("update books set price = 11.11 where id = 8001 or id = 8002");
                int[] returnCOdes = stmt.executeBatch();

                System.out.println("return code are: ");
                for (int code : returnCOdes){
                    System.out.println(code + ", ");
                }
                System.out.println();
                conn.commit();
            }catch(SQLException ex){
                System.out.println("-- Rolling back changes --");
                conn.rollback();
                ex.printStackTrace();
            }
        }
    }
}
