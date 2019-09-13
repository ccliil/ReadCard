package rfid.DoorControl.src.com.cn.util;
import java.sql.*;



public class Dbutil {
    private  static  final String URl="jdbc:sqlserver://localhost:1434;DataBaseName=RFID";
    private static Connection conn=null;
    static {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn=(Connection)DriverManager.getConnection(URl,"sa","123456");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection()throws SQLException{
        return conn;
    }


}
