/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.awt.Desktop;
import java.io.File;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javax.swing.*;
import javax.swing.table.TableModel;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author HoangHiep
 */
public class XuatExcel {
    
    public void exportTableToExcel(JTable table) {
        // Lấy TableModel từ JTable
        TableModel model = table.getModel();

        // Tạo workbook và sheet cho Excel
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet 1");
        
        // Tạo dòng tiêu đề
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < model.getColumnCount(); i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(model.getColumnName(i));
        }
        
        // Thêm dữ liệu vào các dòng tiếp theo
        for (int rowIndex = 0; rowIndex < model.getRowCount(); rowIndex++) {
            Row row = sheet.createRow(rowIndex + 1);  // Dòng đầu tiên đã là tiêu đề
            for (int colIndex = 0; colIndex < model.getColumnCount(); colIndex++) {
                Cell cell = row.createCell(colIndex);

                Object value = model.getValueAt(rowIndex, colIndex); // lấy giá trị ra trước
                if (value != null) {
                    cell.setCellValue(value.toString()); // nếu có giá trị thì mới set
                } else {
                    cell.setCellValue(""); // nếu null thì set ô trống
                }
            }
        }
        // Mở JFileChooser cho người dùng chọn nơi lưu file
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Chọn nơi lưu file");
        fileChooser.setSelectedFile(new File("data.xlsx"));  // Đặt tên mặc định cho file

        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();

            // Kiểm tra nếu file chưa có phần mở rộng .xlsx thì thêm vào
            if (!fileToSave.getName().endsWith(".xlsx")) {
                fileToSave = new File(fileToSave.getAbsolutePath() + ".xlsx");
            }

            // Ghi workbook vào file Excel
            try (FileOutputStream fileOut = new FileOutputStream(fileToSave)) {
                workbook.write(fileOut);
                System.out.println("Dữ liệu đã được xuất ra file Excel thành công tại: " + fileToSave.getAbsolutePath());
                
                 // Mở file Excel sau khi lưu
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(fileToSave); // Mở file bằng ứng dụng mặc định
                } else {
                    System.out.println("Không thể mở file tự động. Desktop không được hỗ trợ.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}