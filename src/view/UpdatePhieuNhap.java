/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.PhieuNhap_md;
import model.PhieuNhap_md;

/**
 *
 * @author HoangHiep
 */
public class UpdatePhieuNhap extends javax.swing.JFrame {

    public UpdatePhieuNhap(String maphieunhap) throws SQLException, ClassNotFoundException {
        initComponents();
        this.setLocationRelativeTo(null);    //căn cửa sổ ra giữa màn hình
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);   //đóng cửa sổ hiện tại các cửa sổ khác giữ nguyên
        set_thuoc_tinh(maphieunhap);
    }
    
    public void set_thuoc_tinh(String maphieunhap) throws SQLException, ClassNotFoundException{
        PhieuNhap_md phieunhap = new PhieuNhap_md();
        ResultSet rs = phieunhap.TimKiemForDetail_PN(maphieunhap);
        if(rs.next()){
            tfmaphieunhap.setText(rs.getString("MaPN"));
            cbbtrangthai.setSelectedItem(rs.getString("TrangThai"));
        }
        phieunhap.Close();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfmaphieunhap = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbbtrangthai = new javax.swing.JComboBox<>();
        bthuybo = new javax.swing.JButton();
        btcapnhat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(89, 165, 104));
        jPanel2.setMaximumSize(new java.awt.Dimension(800, 50));
        jPanel2.setMinimumSize(new java.awt.Dimension(800, 50));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CẬP NHẬT PHIẾU NHẬP");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Trạng thái thanh toán");

        tfmaphieunhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Mã phiếu nhập");

        cbbtrangthai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbbtrangthai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chưa thanh toán", "Đã thanh toán" }));

        bthuybo.setBackground(new java.awt.Color(204, 0, 0));
        bthuybo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bthuybo.setForeground(new java.awt.Color(255, 255, 255));
        bthuybo.setText("Hủy bỏ");
        bthuybo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bthuyboMouseClicked(evt);
            }
        });

        btcapnhat.setBackground(new java.awt.Color(89, 165, 104));
        btcapnhat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btcapnhat.setForeground(new java.awt.Color(255, 255, 255));
        btcapnhat.setText("Cập nhật");
        btcapnhat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btcapnhatMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(160, 160, 160)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btcapnhat, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfmaphieunhap, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(60, 60, 60)
                                        .addComponent(cbbtrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(bthuybo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(2, 2, 2))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfmaphieunhap, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbtrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bthuybo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btcapnhat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bthuyboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bthuyboMouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_bthuyboMouseClicked

    private void btcapnhatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btcapnhatMouseClicked
        String maphieunhap = tfmaphieunhap.getText();
        String trangthai = cbbtrangthai.getSelectedItem().toString();
        try {
            PhieuNhap_md phieunhap = new PhieuNhap_md();
            phieunhap.CapNhapTrangThai(maphieunhap, trangthai);
            JOptionPane.showMessageDialog(this, "Thay đổi thông tin thành công!");
            phieunhap.Close();
        } catch (SQLException ex) {
            Logger.getLogger(UpdatePhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdatePhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btcapnhatMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new UpdatePhieuNhap("").setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(UpdatePhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(UpdatePhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btcapnhat;
    private javax.swing.JButton bthuybo;
    private javax.swing.JComboBox<String> cbbtrangthai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField tfmaphieunhap;
    // End of variables declaration//GEN-END:variables
}
