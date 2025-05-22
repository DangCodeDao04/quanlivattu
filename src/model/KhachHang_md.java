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
public class KhachHang_md {
    
    private static String db_url;
    private static String username;
    private static String password;
    private static Connection conn;
    
    public KhachHang_md() throws SQLException, ClassNotFoundException{
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
        String sql = "select * from KhachHang";
        rs = st.executeQuery(sql);
        return rs;
    }
    public void Insert(String MaKH, String TenKH, String DiaChi, String SDT) throws SQLException{
        Statement st = conn.createStatement();
        String sql = "insert into KhachHang (MaKH, TenKH, DiaChi, SDT) values" +
"	('"+MaKH+"', N'"+TenKH+"', N'"+DiaChi+"', '"+SDT+"')";
        st.executeUpdate(sql);
    }
    public void Delete(String MaKH) throws SQLException{
        Statement st = conn.createStatement();
        String sql = "delete from KhachHang where MaKH = '"+MaKH+"'";
        st.executeUpdate(sql);
    }
    public void Fix(String MaKH, String TenKH, String DiaChi, String SDT) throws SQLException{
        Statement st = conn.createStatement();
        String sql = "UPDATE KhachHang SET TenKH = N'"+TenKH+"',"
                + " DiaChi = N'"+DiaChi+"', SDT = '"+SDT+"' WHERE MaKH = '"+MaKH+"'";
        st.executeUpdate(sql);
    }
    public ResultSet Search(String text) throws SQLException{
        ResultSet rs = null;   
        Statement st = conn.createStatement();
        String sql = "SELECT * FROM KhachHang WHERE MaKH LIKE N'%" + text + "%' "
           + "OR TenKH LIKE N'%" + text + "%' OR DiaChi LIKE N'%" + text + "%'";
        rs = st.executeQuery(sql);
        return rs;
    }
    public void Close() throws SQLException{
        if(conn != null)
            conn.close();
    }
}
