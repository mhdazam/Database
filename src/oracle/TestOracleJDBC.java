package oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class TestOracleJDBC {
    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@//localhost:1521/xe";
            String username = "ziyadusa";
            String password = "ziyad05";
            con= DriverManager.getConnection(url, username, password);
            System.out.println("Connectied");
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM person order by pid");
            while(rs.next()) {
                System.out.print(rs.getInt(1) + "\t");
                System.out.println(rs.getString(2));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}