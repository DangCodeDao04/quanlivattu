/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import model.ThongKe_md;
import model.XuatExcel;

/**
 *
 * @author HoangHiep
 */
public class ThongKe extends javax.swing.JInternalFrame {

    public ThongKe() throws SQLException, ClassNotFoundException {
        initComponents();
        this.setBorder(null);  // Ẩn viền
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        JTableHeader header = tbphieuxuat.getTableHeader();
        header.setFont(new Font("SansSerif", Font.BOLD, 14));
        init();
        khoitao_vt_ncc_user();
    }

    public void khoitao_vt_ncc_user() throws SQLException, ClassNotFoundException{
        ThongKe_md thongke = new ThongKe_md();
        ResultSet rs1, rs2, rs3;
        rs1 = thongke.DemVatTu();
        rs2 = thongke.DemNCC();
        rs3 = thongke.DemUser();
        if(rs1.next()){
            lbsanpham.setText(rs1.getString("SoLuongVatTu"));
        }
        if(rs2.next()){
            lbncc.setText(rs2.getString("SoLuongNCC"));
        }
        if(rs3.next()){
            lbnguoidung.setText(rs3.getString("SoLuongTaiKhoan"));
        }
    }
    
    public void init() throws SQLException, ClassNotFoundException{
        ThongKe_md thongke = new ThongKe_md();
        ResultSet rs = thongke.GetData();
        ResultSet rs2 = thongke.TongDoanhThu();
        ResetTable();
        int i = 0;
        DecimalFormat formatter = new DecimalFormat("#,###");
        while(rs.next()){
            tbphieuxuat.setValueAt(rs.getString("MaPX"), i, 0);
            tbphieuxuat.setValueAt(rs.getString("MaKH"), i, 1);
            tbphieuxuat.setValueAt(rs.getString("TenKH"), i, 2);
            tbphieuxuat.setValueAt(rs.getString("NgayBan"), i, 3);      
            String tien = formatter.format(rs.getDouble("TongTien"));
            tbphieuxuat.setValueAt(tien + " đ", i, 4);       
            i++;
        }
        if(rs2.next()){
            String doanhthu = formatter.format(rs2.getDouble("TongTatCaDonHang"));
            lbtongtien.setText(doanhthu+" VND");
        }
        thongke.Close();
    }
    
    public void ResetTable(){
        DefaultTableModel model = (DefaultTableModel) tbphieuxuat.getModel();
        model.setRowCount(0);
        model.setRowCount(30);
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

        jPanel9 = new javax.swing.JPanel();
        lbsanpham = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        lbncc = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        lbnguoidung = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbphieuxuat = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfdenngay = new javax.swing.JTextField();
        tftungay = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        lbtongtien = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btxuatexcel = new javax.swing.JButton();
        btloc = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(1110, 650));
        setMinimumSize(new java.awt.Dimension(1110, 650));
        setPreferredSize(new java.awt.Dimension(1110, 650));

        jPanel9.setBackground(new java.awt.Color(255, 204, 0));

        lbsanpham.setFont(new java.awt.Font("SF Pro Display", 1, 36)); // NOI18N
        lbsanpham.setForeground(new java.awt.Color(255, 255, 255));
        lbsanpham.setText("100");

        jLabel10.setFont(new java.awt.Font("SF Pro Display", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Sản phẩm trong kho");

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/123.png"))); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(lbsanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(81, 81, 81))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbsanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(73, 73, 73))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(255, 102, 0));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-supplier-80.png"))); // NOI18N

        lbncc.setFont(new java.awt.Font("SF Pro Display", 1, 36)); // NOI18N
        lbncc.setForeground(new java.awt.Color(255, 255, 255));
        lbncc.setText("100");

        jLabel14.setFont(new java.awt.Font("SF Pro Display", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Nhà cung cấp ");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel13)
                .addGap(43, 43, 43)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbncc, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbncc, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)))
                .addGap(10, 10, 10))
        );

        jPanel11.setBackground(new java.awt.Color(0, 204, 204));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-account-80.png"))); // NOI18N

        lbnguoidung.setFont(new java.awt.Font("SF Pro Display", 1, 36)); // NOI18N
        lbnguoidung.setForeground(new java.awt.Color(255, 255, 255));
        lbnguoidung.setText("100");

        jLabel17.setFont(new java.awt.Font("SF Pro Display", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Tài khoản người dùng");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbnguoidung, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(73, 73, 73))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbnguoidung, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)))
                .addGap(10, 10, 10))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1085, 520));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbphieuxuat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbphieuxuat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã phiếu xuất", "Mã khách hàng", "Tên khách hàng", "Ngày tạo", "Tổng tiền"
            }
        ));
        tbphieuxuat.setGridColor(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(tbphieuxuat);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 137, 1080, 370));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Lọc theo ngày"));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Đến");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 40, 20));

        jLabel5.setFont(new java.awt.Font("SF Pro Display", 0, 14)); // NOI18N
        jLabel5.setText("Từ");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 20, 20));

        tfdenngay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel4.add(tfdenngay, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 150, 30));

        tftungay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel4.add(tftungay, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 150, 30));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 430, 90));

        lbtongtien.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lbtongtien.setForeground(new java.awt.Color(255, 0, 0));
        lbtongtien.setText("1000000000 đ");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Tổng doanh thu:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lbtongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 30, 470, 70));

        btxuatexcel.setBackground(new java.awt.Color(51, 153, 0));
        btxuatexcel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btxuatexcel.setForeground(new java.awt.Color(255, 255, 255));
        btxuatexcel.setText("Xuất Excel");
        btxuatexcel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btxuatexcelMouseClicked(evt);
            }
        });
        jPanel1.add(btxuatexcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 130, 40));

        btloc.setBackground(new java.awt.Color(51, 153, 0));
        btloc.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btloc.setForeground(new java.awt.Color(255, 255, 255));
        btloc.setText("Lọc");
        btloc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btlocMouseClicked(evt);
            }
        });
        jPanel1.add(btloc, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, 80, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1090, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btxuatexcelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btxuatexcelMouseClicked
        int result = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xuất file excel chứ?", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION){
            XuatExcel xuatexcel = new XuatExcel();
            xuatexcel.exportTableToExcel(tbphieuxuat);
        }  
    }//GEN-LAST:event_btxuatexcelMouseClicked

    private void btlocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btlocMouseClicked
        String tungay = tftungay.getText();
        String denngay = tfdenngay.getText();    
        try {
                String ngaybatdau = dinh_dang_ngay(tungay);
                String ngayketthuc = dinh_dang_ngay(denngay);
                ThongKe_md thongke = new ThongKe_md();
                ResultSet rs = thongke.TimKiemTheoNgay(ngaybatdau, ngayketthuc);
                ResetTable();
                DecimalFormat formatter = new DecimalFormat("#,###");
                double doanhthu = 0;
                int i = 0;
                while (rs.next()) {
                    tbphieuxuat.setValueAt(rs.getString("MaPX"), i, 0);
                    tbphieuxuat.setValueAt(rs.getString("MaKH"), i, 1);
                    tbphieuxuat.setValueAt(rs.getString("TenKH"), i, 2);
                    tbphieuxuat.setValueAt(rs.getString("NgayBan"), i, 3);
                    
                    String tien = formatter.format(rs.getFloat("TongTien"));
                    tbphieuxuat.setValueAt(tien + " đ", i, 4);
                    doanhthu += rs.getDouble("TongTien");
                    i++;
                }
                lbtongtien.setText(formatter.format(doanhthu) + " VND");
                thongke.Close();
            } catch (SQLException ex) {
                Logger.getLogger(PhieuXuat.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PhieuXuat.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_btlocMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btloc;
    private javax.swing.JButton btxuatexcel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbncc;
    private javax.swing.JLabel lbnguoidung;
    private javax.swing.JLabel lbsanpham;
    private javax.swing.JLabel lbtongtien;
    private javax.swing.JTable tbphieuxuat;
    private javax.swing.JTextField tfdenngay;
    private javax.swing.JTextField tftungay;
    // End of variables declaration//GEN-END:variables
}
