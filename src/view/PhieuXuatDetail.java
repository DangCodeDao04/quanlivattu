/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;
import model.PhieuXuat_md;
import model.XuatHoaDonPDF;

/**
 *
 * @author HoangHiep
 */
public class PhieuXuatDetail extends javax.swing.JFrame {

    public PhieuXuatDetail(String maphieuxuat) throws SQLException, ClassNotFoundException {      
        initComponents();
        this.setLocationRelativeTo(null);    //căn cửa sổ ra giữa màn hình
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);   //đóng cửa sổ hiện tại các cửa sổ khác giữ nguyên
        JTableHeader header = tbvattu.getTableHeader();
        header.setFont(new Font("SansSerif", Font.BOLD, 14)); 
        init_px(maphieuxuat);
        init_ctpx(maphieuxuat);
    }
    
    public void init_px(String maphieuxuat) throws SQLException, ClassNotFoundException{
        PhieuXuat_md phieuxuat = new PhieuXuat_md();
        ResultSet rs = phieuxuat.TimKiemForDetail_PX(maphieuxuat);
        
        if (rs.next()){
            tfmaphieuxuat.setText(rs.getString("MaPX"));
            tfmakhachhang.setText(rs.getString("MaKH"));
            tftenkhachhang.setText(rs.getString("TenKH"));
            tfngayban.setText(rs.getString("NgayBan"));
            DecimalFormat formatter = new DecimalFormat("#,###");
            String tien = formatter.format(rs.getFloat("TongTien"));
            lbtongtien.setText(tien + " đ");
            tfdiachi.setText(rs.getString("DiaChi"));
            tftrangthai.setText(rs.getString("TrangThai"));
        }     
        phieuxuat.Close();
    }
    
    public void init_ctpx(String maphieuxuat) throws SQLException, ClassNotFoundException{
        PhieuXuat_md phieuxuat = new PhieuXuat_md();
        ResultSet rs = phieuxuat.TimKiemForDetail_CTPX(maphieuxuat);     
        int i = 0;
            while(rs.next()){
                tbvattu.setValueAt(rs.getString("MaVatTu"), i, 0);
                tbvattu.setValueAt(rs.getString("TenVatTu"), i, 1);
                tbvattu.setValueAt(rs.getString("SoLuong"), i, 2);
                DecimalFormat formatter = new DecimalFormat("#,###");
                String tien = formatter.format(rs.getFloat("DonGia"));
                tbvattu.setValueAt(tien + " đ", i, 3);     
                i++;
            } 
        phieuxuat.Close();
    }
    
    public String dinh_dang_ngay(String ngay){
        String formattedDate = "";
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        inputFormat.setLenient(false);    // Không chấp nhận ngày sai
        try {      
        Date date = inputFormat.parse(ngay);  // chuyển từ String sang Date

        SimpleDateFormat sqlFormat = new SimpleDateFormat("yyyy-MM-dd");
        formattedDate = sqlFormat.format(date);  // chuyển lại thành String theo định dạng của SQL
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ngày không tồn tại hoặc ngày sai định dạng dd/MM/yyyy!");
            e.printStackTrace();
        }
        return formattedDate;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        tftenkhachhang = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfmaphieuxuat = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfmakhachhang = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tftrangthai = new javax.swing.JTextField();
        tfngayban = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tfdiachi = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbvattu = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        btxuatpdf = new javax.swing.JButton();
        lbtongtien = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(89, 165, 104));
        jPanel2.setMaximumSize(new java.awt.Dimension(800, 50));
        jPanel2.setMinimumSize(new java.awt.Dimension(800, 50));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("THÔNG TIN CHI TIẾT PHIẾU XUẤT");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(jLabel1)
                .addContainerGap(252, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tftenkhachhang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Tên khách hàng");

        tfmaphieuxuat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Ngày bán");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mã phiếu xuất");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Mã khách hàng");

        tfmakhachhang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Trạng thái thanh toán");

        tftrangthai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        tfngayban.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Địa chỉ");

        tfdiachi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfmaphieuxuat, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfmakhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(75, 75, 75)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfngayban, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tftenkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tftrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfmaphieuxuat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tftenkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(1, 1, 1)
                        .addComponent(tftrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfmakhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tfngayban, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel11))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 870, 140));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbvattu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbvattu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã vật tư", "Tên vật tư", "Số lượng", "Đơn giá"
            }
        ));
        tbvattu.setGridColor(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(tbvattu);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 0, 844, 298));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Tổng tiền");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 319, 92, 31));

        btxuatpdf.setBackground(new java.awt.Color(255, 153, 0));
        btxuatpdf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btxuatpdf.setForeground(new java.awt.Color(255, 255, 255));
        btxuatpdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_pdf_25px.png"))); // NOI18N
        btxuatpdf.setText("Xuất PDF");
        btxuatpdf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btxuatpdfMouseClicked(evt);
            }
        });
        btxuatpdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btxuatpdfActionPerformed(evt);
            }
        });
        jPanel3.add(btxuatpdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 320, -1, 40));

        lbtongtien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbtongtien.setForeground(new java.awt.Color(255, 0, 0));
        jPanel3.add(lbtongtien, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 218, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 870, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btxuatpdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btxuatpdfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btxuatpdfActionPerformed

    private void btxuatpdfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btxuatpdfMouseClicked
        String maphieuxuat = tfmaphieuxuat.getText();
        String ngayban = tfngayban.getText();
//        String date = dinh_dang_ngay(ngayban);
        String tenkhachhang = tftenkhachhang.getText();
        String tongTien = lbtongtien.getText();
        String diachi = tfdiachi.getText();
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn xuất hóa đơn ra file PDF không?", "Xác nhận", 
        JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION){
            XuatHoaDonPDF xuatpdf = new XuatHoaDonPDF();
            xuatpdf.XuatHoaDon_CT(maphieuxuat, ngayban, tenkhachhang, diachi, tbvattu, tongTien);
        }            
    }//GEN-LAST:event_btxuatpdfMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new PhieuXuatDetail("").setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(PhieuXuatDetail.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(PhieuXuatDetail.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btxuatpdf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbtongtien;
    private javax.swing.JTable tbvattu;
    private javax.swing.JTextField tfdiachi;
    private javax.swing.JTextField tfmakhachhang;
    private javax.swing.JTextField tfmaphieuxuat;
    private javax.swing.JTextField tfngayban;
    private javax.swing.JTextField tftenkhachhang;
    private javax.swing.JTextField tftrangthai;
    // End of variables declaration//GEN-END:variables
}
