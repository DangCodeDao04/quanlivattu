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
public class Product_md {
    
    private static String db_url;
    private static String username;
    private static String password;
    private static Connection conn;
    
    public Product_md() throws SQLException, ClassNotFoundException{
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
    public ResultSet GetData_Fix() throws SQLException{
        ResultSet rs = null;   
        Statement st = conn.createStatement(); 
        String sql = "select * from VatTu";
        rs = st.executeQuery(sql);
        return rs;
    }
    public ResultSet GetData() throws SQLException{
        ResultSet rs = null;   
        Statement st = conn.createStatement(); 
        String sql = "SELECT v.MaVatTu, v.TenVatTu, v.SoLuong, v.GiaXuat, n.TenNCC, k.TenKho FROM VatTu v "
                + "JOIN NCC n ON v.MaNCC = n.MaNCC JOIN KhoVatTu k ON v.MaKho = k.MaKho;";
        rs = st.executeQuery(sql);
        return rs;
    }
    public void Insert(String MaVatTu, String TenVatTu, String MaNCC, String MaKho, int SoLuong,
            String DonViTinh, float GiaNhap, float GiaXuat) throws SQLException{
        Statement st = conn.createStatement();
        String sql1 = "insert into VatTu (MaVatTu, TenVatTu, MaNCC, MaKho, SoLuong, DonViTinh, GiaNhap, GiaXuat) values" +
        "('"+MaVatTu+"', N'"+TenVatTu+"', '"+MaNCC+"', '"+MaKho+"', "+SoLuong+", N'"+DonViTinh+"', "+GiaNhap+", "+GiaXuat+")";
        String sql2 = "insert into ChiTietKho (MaKho, MaVatTu) values\n" +
        "('"+MaKho+"', '"+MaVatTu+"')";
        st.executeUpdate(sql1);
        st.execute(sql2);
    }
    public void Delete(String MaVatTu) throws SQLException{
        Statement st = conn.createStatement();
        String sql = "delete from VatTu where MaVatTu = '"+MaVatTu+"'";
        String sql2 = "delete from ChiTietKho where MaVatTu = '"+MaVatTu+"'";
        st.executeUpdate(sql);
        st.executeUpdate(sql2);
    }
    public void Fix(String MaVatTu, String TenVatTu, String MaNCC, String MaKho, int SoLuong,
            String DonViTinh, float GiaNhap, float GiaXuat) throws SQLException{
        Statement st = conn.createStatement();
        String sql = "UPDATE VatTu SET TenVatTu = N'"+TenVatTu+"', MaNCC = '"+MaNCC+"', MaKho = '"+MaKho+"',"
                + " SoLuong = "+SoLuong+", DonViTinh = N'"+DonViTinh+"',"
                + " GiaNhap = "+GiaNhap+", GiaXuat = "+GiaXuat+" WHERE MaVatTu = '"+MaVatTu+"'";
        st.executeUpdate(sql);
    }
    public ResultSet Search(String text) throws SQLException{
        ResultSet rs = null;   
        Statement st = conn.createStatement();
        String sql = "SELECT v.MaVatTu, v.TenVatTu, v.SoLuong, v.GiaXuat, n.TenNCC, k.TenKho FROM VatTu v JOIN NCC n ON v.MaNCC = n.MaNCC "
                + "JOIN KhoVatTu k ON v.MaKho = k.MaKho "
                + "WHERE v.MaVatTu LIKE '%"+text+"%' OR v.TenVatTu LIKE N'%"+text+"%' "
                + "OR n.TenNCC LIKE N'%"+text+"%';";
        rs = st.executeQuery(sql);
        return rs;
    }
    public ResultSet ChiTietKho(String makho) throws SQLException{
        ResultSet rs = null;   
        Statement st = conn.createStatement(); 
        String sql = "select MaVatTu, TenVatTu, MaNCC, SoLuong, DonViTinh from VatTu where MaKho = '"+makho+"'";
        rs = st.executeQuery(sql);
        return rs;
    }
    public ResultSet VatTuKho(String manhacungcap) throws SQLException{
        ResultSet rs = null;   
        Statement st = conn.createStatement(); 
        String sql = "select MaVatTu, TenVatTu, SoLuong, GiaXuat from VatTu where MaNCC = '"+manhacungcap+"'";
        rs = st.executeQuery(sql);
        return rs;
    }
    public void CapNhatSoLuong_Them(String MaKho) throws SQLException{
        Statement st = conn.createStatement();
        String sql = "update KhoVatTu set SoLuong = SoLuong + 1 where MaKho = '"+MaKho+"'";
        st.executeUpdate(sql);
    }
    public void CapNhatSoLuong_Xoa(String MaKho) throws SQLException{
        Statement st = conn.createStatement();
        String sql = "update KhoVatTu set SoLuong = SoLuong - 1 where MaKho = '"+MaKho+"'";
        st.executeUpdate(sql);
    }
    public void Close() throws SQLException{
        if(conn != null)
            conn.close();
    }
}
