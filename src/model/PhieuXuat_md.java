/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author HoangHiep
 */
public class PhieuXuat_md {
    
    private static String db_url;
    private static String username;
    private static String password;
    private static Connection conn;
    
    public PhieuXuat_md() throws SQLException, ClassNotFoundException{
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
    public void Delete(String MaPX) throws SQLException{
        Statement st = conn.createStatement();
        String sql = "delete from ChiTietPhieuXuat where MaPX = '"+MaPX+"'";
        String sql2 = "delete from PhieuXuat where MaPX = '"+MaPX+"'";
        st.executeUpdate(sql);
        st.executeUpdate(sql2);
    }
    public ResultSet Search(String text) throws SQLException{
        ResultSet rs = null;   
        Statement st = conn.createStatement();
        String sql = "SELECT px.*, kh.TenKH FROM PhieuXuat px JOIN KhachHang kh ON px.MaKH = kh.MaKH"
                + " WHERE px.MaPX LIKE '%" + text + "%' "
           + "OR px.MaKH LIKE '%" + text + "%' "
           + "OR kh.TenKH LIKE N'%" + text + "%'";
        rs = st.executeQuery(sql);
        return rs;
    }
    public ResultSet TimKiemForDetail_PX(String MaPX) throws SQLException{
        ResultSet rs = null;   
        Statement st = conn.createStatement();
        String sql = "SELECT px.*, kh.TenKH, kh.DiaChi FROM PhieuXuat px JOIN KhachHang kh ON px.MaKH = kh.MaKH WHERE px.MaPX = '"+MaPX+"'";
        rs = st.executeQuery(sql);
        return rs;
    }
    public ResultSet TimKiemForDetail_CTPX(String MaPX) throws SQLException{
        ResultSet rs = null;   
        Statement st = conn.createStatement();
        String sql = "select ctpx.MaVatTu, ctpx.SoLuong, ctpx.DonGia, vt.TenVatTu from ChiTietPhieuXuat ctpx "
                + "join VatTu vt on ctpx.MaVatTu = vt.MaVatTu WHERE ctpx.MaPX = '"+MaPX+"'";
        rs = st.executeQuery(sql);
        return rs;
    }
    public ResultSet TimKiemTheoGia(float tugia, float dengia) throws SQLException{
        ResultSet rs = null;   
        Statement st = conn.createStatement();
        String sql = "SELECT px.*, kh.TenKH FROM PhieuXuat px JOIN KhachHang kh ON px.MaKH = kh.MaKH "
                + "WHERE TongTien BETWEEN "+tugia+" AND "+dengia+"";
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
    public void CapNhapTrangThai(String MaPX, String TrangThai) throws SQLException{   
        Statement st = conn.createStatement();
        String sql = "update PhieuXuat set TrangThai = N'"+TrangThai+"' where MaPX = '"+MaPX+"'";
        st.executeUpdate(sql);
    }
    public void Close() throws SQLException{
        if(conn != null)
            conn.close();
    }
}
