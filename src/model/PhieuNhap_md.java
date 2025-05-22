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
public class PhieuNhap_md {
    
    private static String db_url;
    private static String username;
    private static String password;
    private static Connection conn;
    
    public PhieuNhap_md() throws SQLException, ClassNotFoundException{
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
        String sql = "SELECT pn.*, ncc.TenNCC FROM PhieuNhap pn JOIN NCC ncc ON pn.MaNCC = ncc.MaNCC";
        rs = st.executeQuery(sql);
        return rs;
    }
    public void Delete(String MaPN) throws SQLException{
        Statement st = conn.createStatement();
        String sql = "delete from ChiTietPhieuNhap where MaPN = '"+MaPN+"'";
        String sql2 = "delete from PhieuNhap where MaPN = '"+MaPN+"'";
        st.executeUpdate(sql);
        st.executeUpdate(sql2);
    }
    public ResultSet Search(String text) throws SQLException{
        ResultSet rs = null;   
        Statement st = conn.createStatement();
        String sql = "SELECT pn.*, ncc.TenNCC FROM PhieuNhap pn JOIN NCC ncc ON pn.MaNCC = ncc.MaNCC"
                + " WHERE pn.MaPN LIKE '%" + text + "%' "
           + "OR pn.MaNCC LIKE '%" + text + "%' "
           + "OR ncc.TenNCC LIKE N'%" + text + "%'";
        rs = st.executeQuery(sql);
        return rs;
    }
    public ResultSet TimKiemForDetail_PN(String MaPN) throws SQLException{
        ResultSet rs = null;   
        Statement st = conn.createStatement();
        String sql = "SELECT pn.*, ncc.TenNCC FROM PhieuNhap pn JOIN NCC ncc ON pn.MaNCC = ncc.MaNCC WHERE pn.MaPN = '"+MaPN+"'";
        rs = st.executeQuery(sql);
        return rs;
    }
    public ResultSet TimKiemForDetail_CTPN(String MaPN) throws SQLException{
        ResultSet rs = null;   
        Statement st = conn.createStatement();
        String sql = "select ctpn.MaVatTu, ctpn.SoLuong, ctpn.DonGia, vt.TenVatTu from ChiTietPhieuNhap ctpn "
                + "join VatTu vt on ctpn.MaVatTu = vt.MaVatTu WHERE ctpn.MaPN = '"+MaPN+"'";
        rs = st.executeQuery(sql);
        return rs;
    }
    public ResultSet TimKiemTheoGia(float tugia, float dengia) throws SQLException{
        ResultSet rs = null;   
        Statement st = conn.createStatement();
        String sql = "SELECT pn.*, ncc.TenNCC FROM PhieuNhap pn JOIN NCC ncc ON pn.MaNCC = ncc.MaNCC "
                + "WHERE TongTien BETWEEN "+tugia+" AND "+dengia+"";
        rs = st.executeQuery(sql);
        return rs;
    }
    public ResultSet TimKiemTheoNgay(String tungay, String denngay) throws SQLException{
        ResultSet rs = null;   
        Statement st = conn.createStatement();
        String sql = "SELECT pn.*, ncc.TenNCC FROM PhieuNhap pn JOIN NCC ncc ON pn.MaNCC = ncc.MaNCC "
                + "WHERE NgayNhap BETWEEN '"+tungay+"' AND '"+denngay+"'";
        rs = st.executeQuery(sql);
        return rs;
    }
    public void CapNhapTrangThai(String MaPN, String TrangThai) throws SQLException{   
        Statement st = conn.createStatement();
        String sql = "update PhieuNhap set TrangThai = N'"+TrangThai+"' where MaPN = '"+MaPN+"'";
        st.executeUpdate(sql);
    }
    public void Close() throws SQLException{
        if(conn != null)
            conn.close();
    }
}
