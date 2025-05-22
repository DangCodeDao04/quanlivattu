/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author HoangHiep
 */
public class Account_md {
    
    private static String db_url;
    private static String username;
    private static String password;
    private static Connection conn;
    
    public Account_md() throws SQLException, ClassNotFoundException{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        db_url = "jdbc:sqlserver://HOANGHIEP:1433;databaseName=QuanLiVatTu;";
        username = "sa";
        password = "123";    
        conn = DriverManager.getConnection(db_url, username, password);
        if(conn != null)
            System.out.println("Connect Successfully!");
        else
            System.out.println("Connect Failure!");
    }
    public ResultSet GetData() throws SQLException{
        ResultSet rs = null;   
        Statement st = conn.createStatement(); 
        String sql = "select * from TaiKhoan";
        rs = st.executeQuery(sql);
        return rs;
    }
    public void Insert(String UserName, String Pass, String Email, String SDT, String VaiTro) throws SQLException{
        Statement st = conn.createStatement();
        String sql = "INSERT INTO TaiKhoan (UserName, Pass, Email, SDT, VaiTro) VALUES\n" +
"	('"+UserName+"', '"+Pass+"', '"+Email+"', '"+SDT+"', N'"+VaiTro+"')";
        st.executeUpdate(sql);
    }
    public void Delete(String ID) throws SQLException{
        Statement st = conn.createStatement();
        String sql = "delete from TaiKhoan where ID = '"+ID+"'";
        st.executeUpdate(sql);
    }
    public void Fix(int ID, String UserName, String Pass, String Email, String SDT, String VaiTro) throws SQLException{
        Statement st = conn.createStatement();
        String sql = "UPDATE TaiKhoan SET UserName = N'"+UserName+"',"
                + " Pass = '"+Pass+"', Email = '"+Email+"', SDT = '"+SDT+"', VaiTro = '"+VaiTro+"' WHERE ID = '"+ID+"'";
        st.executeUpdate(sql);
    }
    public ResultSet Search(String text) throws SQLException{
        ResultSet rs = null;   
        Statement st = conn.createStatement();
        String sql = "SELECT * FROM TaiKhoan WHERE UserName LIKE N'%" + text + "%' "
           + "OR Email LIKE '%" + text + "%'";
        rs = st.executeQuery(sql);
        return rs;
    }
    public void Close() throws SQLException{
        if(conn != null)
            conn.close();
    }
}
