/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

/**
 *
 * @author HoangHiep
 */

public class XuatHoaDonPDF {

    public void XuatHoaDon(String maPX, String ngayTao, String tenKH, JTable table, String tongTien) {
        try {
            // 1. Mở hộp thoại chọn nơi lưu
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Chọn nơi lưu hóa đơn PDF");
            fileChooser.setSelectedFile(new File("HoaDon_" + maPX + ".pdf")); // gợi ý tên

            int userSelection = fileChooser.showSaveDialog(null);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                String filePath = fileToSave.getAbsolutePath();
                if (!filePath.endsWith(".pdf")) {
                    filePath += ".pdf"; // thêm đuôi .pdf nếu thiếu
                }

                // 2. Bắt đầu xuất file PDF
                Document document = new Document();
                PdfWriter.getInstance(document, new FileOutputStream(filePath));
                document.open();

                // 3. Nạp font Unicode
                BaseFont bf = BaseFont.createFont("src/arial/arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
                Font font = new Font(bf, 12);
                Font fonttitle = new Font(bf, 16, Font.BOLD);

                // 4. Viết nội dung
                Paragraph title = new Paragraph("THÔNG TIN PHIẾU XUẤT", fonttitle);
                title.setAlignment(Element.ALIGN_CENTER);
                document.add(title);

                document.add(new Paragraph(" ")); // Khoảng trắng
                document.add(new Paragraph("Mã phiếu xuất: " + maPX, font));
                document.add(new Paragraph("Ngày tạo: " + ngayTao, font));
                document.add(new Paragraph("Khách hàng: " + tenKH, font));
                document.add(new Paragraph(" "));

                // 5. Bảng dữ liệu
                PdfPTable pdfTable = new PdfPTable(5);
                pdfTable.setWidthPercentage(100);
                pdfTable.setSpacingBefore(10f);
                pdfTable.setSpacingAfter(10f);

                String[] headers = {"STT", "Mã vật tư", "Tên vật tư", "Số lượng", "Đơn giá"};
                for (String header : headers) {
                    PdfPCell cell = new PdfPCell(new Phrase(header, font));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    pdfTable.addCell(cell);
                }

                // Đổ dữ liệu từ JTable
                TableModel model = table.getModel();
                for (int row = 0; row < model.getRowCount(); row++) {
                    for (int col = 0; col < model.getColumnCount(); col++) {
                        Object value = model.getValueAt(row, col);
                        if (value != null) {
                            pdfTable.addCell(new Phrase(value.toString(), font));
                        } else {
                            pdfTable.addCell("");
                        }
                    }
                }
                document.add(pdfTable);

                // 6. Tổng tiền
                Paragraph total = new Paragraph("Tổng tiền: " + tongTien, font);
                total.setAlignment(Element.ALIGN_RIGHT);
                document.add(total);

                document.close();

                // 7. Thông báo thành công
                JOptionPane.showMessageDialog(null, "Xuất hóa đơn thành công!");

                // 8. Mở file PDF vừa tạo
                Desktop.getDesktop().open(new File(filePath));
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Xuất hóa đơn thất bại: " + e.getMessage());
        }
    }
    public void XuatHoaDon_CT(String maPX, String ngayTao, String tenKH,String diaChi, JTable table, String tongTien) {
    try {
        // 1. Mở hộp thoại chọn nơi lưu
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Chọn nơi lưu hóa đơn PDF");
        fileChooser.setSelectedFile(new File("HoaDon_" + maPX + ".pdf")); // gợi ý tên

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            String filePath = fileToSave.getAbsolutePath();
            if (!filePath.endsWith(".pdf")) {
                filePath += ".pdf"; // thêm đuôi .pdf nếu thiếu
            }

            // 2. Bắt đầu xuất file PDF
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            // 3. Nạp font Unicode
            BaseFont bf = BaseFont.createFont("src/arial/arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font font = new Font(bf, 12);
            Font fonttitle = new Font(bf, 16, Font.BOLD);

            // 4. Viết nội dung
            Paragraph title = new Paragraph("THÔNG TIN PHIẾU XUẤT", fonttitle);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            document.add(new Paragraph(" ")); // Khoảng trắng
            document.add(new Paragraph("Mã phiếu xuất: " + maPX, font));
            document.add(new Paragraph("Ngày tạo: " + ngayTao, font));
            document.add(new Paragraph("Khách hàng: " + tenKH, font));
            document.add(new Paragraph("Địa chỉ: " + diaChi, font));
            document.add(new Paragraph(" "));

            // 5. Bảng dữ liệu
            PdfPTable pdfTable = new PdfPTable(4);
            pdfTable.setWidthPercentage(100);
            pdfTable.setSpacingBefore(10f);
            pdfTable.setSpacingAfter(10f);

            String[] headers = {"Mã vật tư", "Tên vật tư", "Số lượng", "Đơn giá"};
            for (String header : headers) {
                PdfPCell cell = new PdfPCell(new Phrase(header, font));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                pdfTable.addCell(cell);
            }

            // Đổ dữ liệu từ JTable
            TableModel model = table.getModel();
            for (int row = 0; row < model.getRowCount(); row++) {
                for (int col = 0; col < model.getColumnCount(); col++) {
                    Object value = model.getValueAt(row, col);
                    if (value != null) {
                        pdfTable.addCell(new Phrase(value.toString(), font));
                    } else {
                        pdfTable.addCell("");
                    }
                }
            }
            document.add(pdfTable);

            // 6. Tổng tiền
            Paragraph total = new Paragraph("Tổng tiền: " + tongTien, font);
            total.setAlignment(Element.ALIGN_RIGHT);
            document.add(total);

            document.close();

            // 7. Thông báo thành công
            JOptionPane.showMessageDialog(null, "Xuất hóa đơn thành công!");

            // 8. Mở file PDF vừa tạo
            Desktop.getDesktop().open(new File(filePath));
        }

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Xuất hóa đơn thất bại: " + e.getMessage());
    }
}
}
