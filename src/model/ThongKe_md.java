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
public class ThongKe_md {
     private static String db_url;
    private static String username;
    private static String password;
    private static Connection conn;
    
    public ThongKe_md() throws SQLException, ClassNotFoundException{
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
        String sql = "SELECT px.*, kh.TenKH FROM PhieuXuat px JOIN KhachHang kh ON px.MaKH = kh.MaKH";
        rs = st.executeQuery(sql);
        return rs;
    }
    public ResultSet DemVatTu() throws SQLException{
        ResultSet rs = null;   
        Statement st = conn.createStatement(); 
        String sql = "SELECT COUNT(*) AS SoLuongVatTu FROM VatTu";
        rs = st.executeQuery(sql);
        return rs;
    }
    public ResultSet DemNCC() throws SQLException{
        ResultSet rs = null;   
        Statement st = conn.createStatement(); 
        String sql = "SELECT COUNT(*) AS SoLuongNCC FROM NCC";
        rs = st.executeQuery(sql);
        return rs;
    }
    public ResultSet DemUser() throws SQLException{
        ResultSet rs = null;   
        Statement st = conn.createStatement(); 
        String sql = "SELECT COUNT(*) AS SoLuongTaiKhoan FROM TaiKhoan";
        rs = st.executeQuery(sql);
        return rs;
    }
    public ResultSet TongDoanhThu() throws SQLException{
        ResultSet rs = null;   
        Statement st = conn.createStatement(); 
        String sql = "SELECT SUM(TongTien) AS TongTatCaDonHang FROM PhieuXuat";
        rs = st.executeQuery(sql);
        return rs;
    }
    public ResultSet TimKiemTheoNgay(String tungay, String denngay) throws SQLException{
        ResultSet rs = null;   
        Statement st = conn.createStatement();
        String sql = "SELECT px.*, kh.TenKH FROM PhieuXuat px JOIN KhachHang kh ON px.MaKH = kh.MaKH "
                + "WHERE NgayBan BETWEEN '"+tungay+"' AND '"+denngay+"'";
        rs = st.executeQuery(sql);
        return rs;
    }
    public void Close() throws SQLException{
        if(conn != null)
            conn.close();
    }
}
