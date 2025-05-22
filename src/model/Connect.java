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
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author HoangHiep
 */
public class Connect {
    
    private static String db_url;
    private static String username;
    private static String password;
    private static Connection conn;
    
    public Connect() throws SQLException, ClassNotFoundException{
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
    public ResultSet GetData(String NameTable) throws SQLException{
        ResultSet rs = null;   
        Statement st = conn.createStatement(); 
        String sql = "select * from " + NameTable;
        rs = st.executeQuery(sql);
        return rs;
    }
    public void Close() throws SQLException{
        if(conn != null)
            conn.close();
    }
    public static void main(String[] args) throws ClassNotFoundException {  
        try {
            Connect cn = new Connect();
            ResultSet rs = cn.GetData("KhachHang");
            while(rs.next()){
                System.out.println(rs.getString(1)+"--"+rs.getString(2)+"--"+rs.getString(3)+"--"+rs.getString(4));
            }
            cn.Close();
        } catch (SQLException ex) {
            System.out.println("Nap trinh dieu khien that bai");
        }
    }
    /*
    1. Cho người dùng nhập ngày:
    Ví dụ người dùng nhập theo định dạng "dd/MM/yyyy":

    String input = textField.getText();  // Ví dụ: "17/04/2025"
    📌 2. Chuyển đổi sang định dạng "yyyy-MM-dd":

    import java.text.SimpleDateFormat;
    import java.util.Date;

    try {
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = inputFormat.parse(input);  // chuyển từ String sang Date

        SimpleDateFormat sqlFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = sqlFormat.format(date);  // chuyển lại thành String theo định dạng của SQL

        System.out.println("Chuỗi date gửi vào SQL: " + formattedDate);

        // Sau đó dùng `formattedDate` để đưa vào câu lệnh SQL

    } catch (Exception e) {
        System.out.println("Lỗi định dạng ngày!"); 
        e.printStackTrace();
    }
    ✅ 3. Chèn vào SQL Server
    Nếu Hiệp dùng PreparedStatement thì quá chuẩn luôn:


    String query = "INSERT INTO KhachHang (MaKH, TenKH, NgaySinh) VALUES (?, ?, ?)";
    PreparedStatement stmt = conn.prepareStatement(query);
    stmt.setInt(1, maKH);
    stmt.setString(2, tenKH);
    stmt.setString(3, formattedDate);  // vì SQL Server hiểu chuỗi yyyy-MM-dd là ngày

    stmt.executeUpdate();
    
    import java.text.NumberFormat;
    import java.util.Locale;

    int tongTien = 1500000;

    NumberFormat vnFormat = NumberFormat.getInstance(new Locale("vi", "VN"));
    String hienThiTien = vnFormat.format(tongTien);

    myLabel.setText(hienThiTien + " đ");
    */
}
