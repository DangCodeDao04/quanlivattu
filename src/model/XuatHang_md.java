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
public class XuatHang_md {
    
    private static String db_url;
    private static String username;
    private static String password;
    private static Connection conn;
    
    public XuatHang_md() throws SQLException, ClassNotFoundException{
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
        String sql = "select * from PhieuXuat";
        rs = st.executeQuery(sql);
        return rs;
    }
    public void Insert_PhieuXuat(String MaPX, String MaKH, String NgayBan, float TongTien, String TrangThai) throws SQLException{
        Statement st = conn.createStatement();
        String sql = "insert into PhieuXuat (MaPX, MaKH, NgayBan, TongTien, TrangThai) values" +
        "('"+MaPX+"', N'"+MaKH+"', '"+NgayBan+"', "+TongTien+", N'"+TrangThai+"')";
        st.executeUpdate(sql);    
    }
    public void Insert_ChiTietPhieuXuat(String MaPX, String MaVatTu, int SoLuong, float DonGia) throws SQLException{
        Statement st = conn.createStatement();
        String sql = "insert into ChiTietPhieuXuat (MaPX, MaVatTu, SoLuong, DonGia) values" +
        "('"+MaPX+"', N'"+MaVatTu+"', "+SoLuong+", "+DonGia+")";
        st.executeUpdate(sql);
    }
    public ResultSet Search(String text) throws SQLException{
        ResultSet rs = null;   
        Statement st = conn.createStatement();
        String sql = "SELECT * FROM VatTu WHERE MaVatTu LIKE N'%" + text + "%' "
           + "OR TenVatTu LIKE N'%" + text + "%' ";
        rs = st.executeQuery(sql);
        return rs;
    }
    public void CapNhatSoLuong(String MaVatTu, int SoLuong) throws SQLException{
        Statement st = conn.createStatement();
        String sql = "update VatTu set SoLuong = SoLuong - "+SoLuong+" where MaVatTu = '"+MaVatTu+"'";
        st.executeUpdate(sql);
    }
    public void Close() throws SQLException{
        if(conn != null)
            conn.close();
    }
}
