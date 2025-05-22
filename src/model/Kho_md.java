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
public class Kho_md {
     
    private static String db_url;
    private static String username;
    private static String password;
    private static Connection conn;
    
    public Kho_md() throws SQLException, ClassNotFoundException{
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
        String sql = "select * from KhoVatTu";
        rs = st.executeQuery(sql);
        return rs;
    }
    public void Insert(String MaKho, String TenKho, int SoLuong) throws SQLException{
        Statement st = conn.createStatement();
        String sql = "insert into KhoVatTu (MaKho, TenKho, SoLuong) values" +
"	('"+MaKho+"', N'"+TenKho+"', N'"+SoLuong+"')";
        st.executeUpdate(sql);
    }
    public void Delete(String MaKho) throws SQLException{
        Statement st = conn.createStatement();
        String sql = "delete from KhoVatTu where MaKho = '"+MaKho+"'";
        st.executeUpdate(sql);
    }
    public void Fix(String MaKho, String TenKho, int SoLuong) throws SQLException{
        Statement st = conn.createStatement();
        String sql = "UPDATE KhoVatTu SET TenKho = N'"+TenKho+"', SoLuong = '"+SoLuong+"' WHERE MaKho = '"+MaKho+"'";
        st.executeUpdate(sql);
    }
    public ResultSet Search(String text) throws SQLException{
        ResultSet rs = null;   
        Statement st = conn.createStatement();
        String sql = "SELECT * FROM KhoVatTu WHERE MaKho LIKE '%" + text + "%' "
           + "OR TenKho LIKE N'%" + text + "%'";
        rs = st.executeQuery(sql);
        return rs;
    }
    public ResultSet ChiTietKho(String makho) throws SQLException{
        ResultSet rs = null;   
        Statement st = conn.createStatement(); 
        String sql = "select * from KhoVatTu where MaKho = '"+makho+"'";
        rs = st.executeQuery(sql);
        return rs;
    }
    public void Close() throws SQLException{
        if(conn != null)
            conn.close();
    }
}
