/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 *
 * @author HoangHiep
 */
public class test {
   
    public static void main(String[] args) {
        String tongTien = "1.200.000 đ";
        String tienChuoi = tongTien.replaceAll("[^\\d.,]", "");  // giữ lại số, dấu chấm và phẩy
        float tongtien = 0;
        try {
            NumberFormat vnFormat = NumberFormat.getInstance(new Locale("vi", "VN"));
            Number number = vnFormat.parse(tienChuoi);
            tongtien = number.floatValue(); // để chuẩn bị insert vào DB
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi chuyển tổng tiền về dạng số!", "Lỗi định dạng", JOptionPane.ERROR_MESSAGE);
        }
        System.out.println("Tong Tien: "+ tongtien);
    }
}
/*
// Giả sử bạn có JTable
JTable table = new JTable(data, columnNames);

// Lấy mô hình cột (TableColumnModel)
TableColumnModel columnModel = table.getColumnModel();

// Ví dụ muốn chỉnh cột số 2 (chỉ số bắt đầu từ 0)
TableColumn column = columnModel.getColumn(1);

// Đặt độ rộng mong muốn
column.setPreferredWidth(200); // 200 pixels


------------------------------
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import javax.swing.JTable;
import java.io.FileOutputStream;

public class ExportPDF {

    public void taoHoaDonPDF(String maPhieu, String ngayTao, String khachHang, JTable table, String tongTien) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("HoaDonXuat.pdf"));
            document.open();

            // Tiêu đề
            Paragraph title = new Paragraph("THÔNG TIN PHIẾU XUẤT", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20, BaseColor.BLACK));
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            
            document.add(new Paragraph(" ")); // dòng trống

            // Thông tin chung
            document.add(new Paragraph("Mã phiếu xuất: " + maPhieu));
            document.add(new Paragraph("Ngày tạo: " + ngayTao));
            document.add(new Paragraph("Khách hàng: " + khachHang));
            
            document.add(new Paragraph(" ")); // dòng trống

            // Tạo bảng
            PdfPTable pdfTable = new PdfPTable(5); // 5 cột
            pdfTable.setWidthPercentage(100);

            // Thêm tiêu đề cột
            String[] headers = {"STT", "Mã vật tư", "Tên vật tư", "Số lượng", "Đơn giá"};
            for (String header : headers) {
                PdfPCell cell = new PdfPCell(new Phrase(header));
                cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                pdfTable.addCell(cell);
            }

            // Đổ dữ liệu từ JTable vào
            for (int row = 0; row < table.getRowCount(); row++) {
                for (int col = 0; col < table.getColumnCount(); col++) {
                    Object value = table.getValueAt(row, col);
                    pdfTable.addCell(value != null ? value.toString() : "");
                }
            }

            document.add(pdfTable);

            document.add(new Paragraph(" ")); // dòng trống

            // Tổng tiền
            Paragraph total = new Paragraph("Tổng tiền: " + tongTien + "đ", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, BaseColor.RED));
            total.setAlignment(Element.ALIGN_RIGHT);
            document.add(total);

            document.close();
            System.out.println("Tạo hóa đơn PDF thành công!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
*/
