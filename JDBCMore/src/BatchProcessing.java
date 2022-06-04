import java.sql.*;
public class BatchProcessing {
    public static void main(String[] args) throws SQLException{
        try(
                //step 1 alkocate a connection
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ebookshop", "root", "");
                //step 2 allocate a preparedStatement instead of statement
                PreparedStatement pstmt = conn.prepareStatement("insert into books values (?,?,?,?,?)");

        ) {
            try {
                conn.setAutoCommit(false);
                pstmt.setInt(1, 8003);
                pstmt.setString(2, "java 123");
                pstmt.setString(3, "kevin jones");
                pstmt.setDouble(4, 12.34);
                pstmt.setInt(5, 88);
                pstmt.addBatch();//add the statement for batch processing

                pstmt.setInt(1, 8004);
                pstmt.setString(2, "java 456");
//                no change in values for parameters 3 to 5
                pstmt.addBatch();
                int[] returnCodes = pstmt.executeBatch();
                System.out.print("return codes are: ");
                for (int code : returnCodes)
                    System.out.println(code + ", ");
                System.out.println();
                conn.commit();

            }catch(SQLException ex){

                ex.printStackTrace();
            }//close the resources

        }
    }
}
