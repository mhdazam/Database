package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class PntMembers {
    public static void main(String[] args) throws Exception {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/pntdb?" +
                                                "user=root&password=dipu67");
            stmt = con.createStatement();
            //rs = stmt.executeQuery("SELECT * FROM Members WHERE Student_id = '5716'");
            rs = stmt.executeQuery("SELECT * FROM PntMembers");
            
            while(rs.next()) {
                System.out.print(rs.getString(1) + "\t");
                System.out.print(rs.getString(2) + "\t");
                System.out.print(rs.getString(3) + "\t");
               System.out.print(rs.getString(4) + "\t");
                System.out.println(rs.getString(5));
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