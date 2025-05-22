/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import model.Account_md;
import model.XuatExcel;

/**
 *
 * @author HoangHiep
 */
public class Account extends javax.swing.JInternalFrame {

   
    public Account() throws SQLException, ClassNotFoundException {
        this.setBorder(null);  // Ẩn viền
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        initComponents();
        JTableHeader header = tbtaikhoan.getTableHeader();
        header.setFont(new Font("SansSerif", Font.BOLD, 14)); 
        init();
    }
    
    public void init() throws SQLException, ClassNotFoundException{
        Account_md account = new Account_md();
        ResultSet rs = account.GetData();
        ResetTable();
        int i = 0;
        while(rs.next()){
            tbtaikhoan.setValueAt(rs.getString("ID"), i, 0);
            tbtaikhoan.setValueAt(rs.getString("UserName"), i, 1);
            tbtaikhoan.setValueAt(rs.getString("Pass"), i, 2);
            tbtaikhoan.setValueAt(rs.getString("Email"), i, 3);
            tbtaikhoan.setValueAt(rs.getString("SDT"), i, 4);
            tbtaikhoan.setValueAt(rs.getString("VaiTro"), i, 5);
            i++;
        }
        account.Close();
    }
    public void ResetTable(){
        DefaultTableModel model = (DefaultTableModel) tbtaikhoan.getModel();
        model.setRowCount(0);
        model.setRowCount(40);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btxoa = new javax.swing.JButton();
        btsua = new javax.swing.JButton();
        btxuatexcel = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        tftimkiem = new javax.swing.JTextField();
        btlammoi = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbtaikhoan = new javax.swing.JTable();

        setBorder(null);
        setMaximumSize(new java.awt.Dimension(1110, 650));
        setMinimumSize(new java.awt.Dimension(1110, 650));
        setPreferredSize(new java.awt.Dimension(1110, 650));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setMaximumSize(new java.awt.Dimension(360, 90));
        jPanel1.setMinimumSize(new java.awt.Dimension(360, 90));
        jPanel1.setPreferredSize(new java.awt.Dimension(360, 90));

        btxoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_delete_40px.png"))); // NOI18N
        btxoa.setText("Xóa");
        btxoa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btxoa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btxoaActionPerformed(evt);
            }
        });

        btsua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_edit_40px.png"))); // NOI18N
        btsua.setText("Sửa");
        btsua.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btsua.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btsua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btsuaMouseClicked(evt);
            }
        });

        btxuatexcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_spreadsheet_file_40px.png"))); // NOI18N
        btxuatexcel.setText("Xuất Excel");
        btxuatexcel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btxuatexcel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btxuatexcel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btxuatexcelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btsua, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btxoa, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btxuatexcel)
                .addContainerGap(160, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btsua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btxuatexcel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btxoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 13, 386, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 2));
        jPanel2.setMaximumSize(new java.awt.Dimension(701, 90));
        jPanel2.setMinimumSize(new java.awt.Dimension(701, 90));
        jPanel2.setPreferredSize(new java.awt.Dimension(710, 90));

        jComboBox1.setBackground(new java.awt.Color(204, 204, 204));
        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tìm theo Email", "Tìm theo UserName" }));

        tftimkiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tftimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tftimkiemActionPerformed(evt);
            }
        });
        tftimkiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tftimkiemKeyReleased(evt);
            }
        });

        btlammoi.setBackground(new java.awt.Color(204, 204, 204));
        btlammoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btlammoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_reset_25px_1.png"))); // NOI18N
        btlammoi.setText("Làm mới");
        btlammoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btlammoiMouseClicked(evt);
            }
        });
        btlammoi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btlammoiKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                btlammoiKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tftimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btlammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btlammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tftimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(393, 13, 701, -1));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        tbtaikhoan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbtaikhoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "UserName", "Password", "Email", "Số điện thoại", "Vai trò"
            }
        ));
        tbtaikhoan.setGridColor(new java.awt.Color(204, 204, 204));
        tbtaikhoan.setRowHeight(20);
        jScrollPane1.setViewportView(tbtaikhoan);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1074, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tftimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tftimkiemActionPerformed
        
    }//GEN-LAST:event_tftimkiemActionPerformed

    private void btsuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btsuaMouseClicked
        int n = tbtaikhoan.getSelectedRow();
        String id = tbtaikhoan.getValueAt(n, 0).toString();
        try {
            new UpdateAccount(id).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btsuaMouseClicked

    private void btxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btxoaActionPerformed
        int n = tbtaikhoan.getSelectedRow();
        String id = tbtaikhoan.getValueAt(n, 0).toString();
        try {
            int result = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa chứ?", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (result == JOptionPane.YES_OPTION){
                Account_md account = new Account_md();
                account.Delete(id);
                account.Close();
                init();
            }                                   
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btxoaActionPerformed

    private void btlammoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btlammoiMouseClicked
        tftimkiem.setText("");
          try {
              init();
          } catch (SQLException ex) {
              Logger.getLogger(KhachHang.class.getName()).log(Level.SEVERE, null, ex);
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(KhachHang.class.getName()).log(Level.SEVERE, null, ex);
          }
    }//GEN-LAST:event_btlammoiMouseClicked

    private void btlammoiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btlammoiKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btlammoiKeyPressed

    private void btlammoiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btlammoiKeyReleased
        
    }//GEN-LAST:event_btlammoiKeyReleased

    private void tftimkiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tftimkiemKeyReleased
        String timkiem = tftimkiem.getText();
        try {
            Account_md account = new Account_md();
            ResultSet rs = account.Search(timkiem);
            ResetTable();
            int i = 0;
            while(rs.next()){
                tbtaikhoan.setValueAt(rs.getString("ID"), i, 0);
                tbtaikhoan.setValueAt(rs.getString("UserName"), i, 1);
                tbtaikhoan.setValueAt(rs.getString("Pass"), i, 2);
                tbtaikhoan.setValueAt(rs.getString("Email"), i, 3);
                tbtaikhoan.setValueAt(rs.getString("SDT"), i, 4);
                tbtaikhoan.setValueAt(rs.getString("VaiTro"), i, 5);
                i++;
            }
            account.Close();
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tftimkiemKeyReleased

    private void btxuatexcelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btxuatexcelMouseClicked
        int result = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xuất file excel chứ?", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION){
            XuatExcel xuatexcel = new XuatExcel();
            xuatexcel.exportTableToExcel(tbtaikhoan);
        }
    }//GEN-LAST:event_btxuatexcelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btlammoi;
    private javax.swing.JButton btsua;
    private javax.swing.JButton btxoa;
    private javax.swing.JButton btxuatexcel;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbtaikhoan;
    private javax.swing.JTextField tftimkiem;
    // End of variables declaration//GEN-END:variables
}
