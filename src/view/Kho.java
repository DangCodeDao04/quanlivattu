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
import model.Kho_md;
import model.XuatExcel;

/**
 *
 * @author HoangHiep
 */
public class Kho extends javax.swing.JInternalFrame {

   
    public Kho() throws SQLException, ClassNotFoundException {
        this.setBorder(null);  // Ẩn viền
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);      
        initComponents();
        JTableHeader header = tbkho.getTableHeader();
        header.setFont(new Font("SansSerif", Font.BOLD, 14)); 
        init();
    }
    
     public void init() throws SQLException, ClassNotFoundException{
        Kho_md kho = new Kho_md();
        ResultSet rs = kho.GetData();
        ResetTable();
        int i = 0;
        while(rs.next()){
            tbkho.setValueAt(rs.getString("MaKho"), i, 0);
            tbkho.setValueAt(rs.getString("TenKho"), i, 1);
            tbkho.setValueAt(rs.getString("SoLuong"), i, 2);
            i++;
        }
        kho.Close();
    }
    public void ResetTable(){
        DefaultTableModel model = (DefaultTableModel) tbkho.getModel();
        model.setRowCount(0);
        model.setRowCount(40);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btxoa = new javax.swing.JButton();
        btsua = new javax.swing.JButton();
        btxemchitiet = new javax.swing.JButton();
        btxuatexcel = new javax.swing.JButton();
        btthem = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        tftimkiem = new javax.swing.JTextField();
        btlammoi = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbkho = new javax.swing.JTable();

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
        btxoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btxoaMouseClicked(evt);
            }
        });

        btsua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_edit_25px.png"))); // NOI18N
        btsua.setText("Sửa");
        btsua.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btsua.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btsua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btsuaMouseClicked(evt);
            }
        });

        btxemchitiet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Fatcow-Farm-Fresh-Application-view-detail.24.png"))); // NOI18N
        btxemchitiet.setText("Xem chi tiết");
        btxemchitiet.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btxemchitiet.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btxemchitiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btxemchitietMouseClicked(evt);
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

        btthem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_add_40px.png"))); // NOI18N
        btthem.setText("Thêm");
        btthem.setBorder(null);
        btthem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btthem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btthem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btthemMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(btthem, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(btsua, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(btxoa, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(btxemchitiet, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btxuatexcel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btsua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btthem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btxuatexcel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btxemchitiet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tìm theo mã", "Tìm theo tên" }));

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

        tbkho.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbkho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã kho", "Tên kho", "Số lượng vật tư"
            }
        ));
        tbkho.setGridColor(new java.awt.Color(204, 204, 204));
        tbkho.setRowHeight(20);
        jScrollPane1.setViewportView(tbkho);

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

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 1094, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tftimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tftimkiemActionPerformed
        
    }//GEN-LAST:event_tftimkiemActionPerformed

    private void btthemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btthemMouseClicked
        new AddKho().setVisible(true);
    }//GEN-LAST:event_btthemMouseClicked

    private void btsuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btsuaMouseClicked
        int n = tbkho.getSelectedRow();
        String makho = tbkho.getValueAt(n, 0).toString();
        try {
            new UpdateKho(makho).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Kho.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Kho.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btsuaMouseClicked

    private void btlammoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btlammoiMouseClicked
        tftimkiem.setText("");
        try {
            init();
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btlammoiMouseClicked

    private void btxoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btxoaMouseClicked
        int n = tbkho.getSelectedRow();
        String makho = tbkho.getValueAt(n, 0).toString();
        try {
            int result = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa chứ?", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (result == JOptionPane.YES_OPTION){
                Kho_md product = new Kho_md();
                product.Delete(makho);
                product.Close();
                init();
            }                                   
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btxoaMouseClicked

    private void btxemchitietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btxemchitietMouseClicked
        try {
            new DetailKho().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Kho.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Kho.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btxemchitietMouseClicked

    private void tftimkiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tftimkiemKeyReleased
        String timkiem = tftimkiem.getText();
        try {
            Kho_md kho = new Kho_md();
            ResultSet rs = kho.Search(timkiem);
            ResetTable();
            int i = 0;
            while(rs.next()){
                tbkho.setValueAt(rs.getString("MaKho"), i, 0);
                tbkho.setValueAt(rs.getString("TenKho"), i, 1);
                tbkho.setValueAt(rs.getString("SoLuong"), i, 2);
                i++;
            }
            kho.Close();
        } catch (SQLException ex) {
            System.out.println("Truy vấn sai!");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tftimkiemKeyReleased

    private void btxuatexcelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btxuatexcelMouseClicked
         int result = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xuất file excel chứ?", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION){
            XuatExcel xuatexcel = new XuatExcel();
            xuatexcel.exportTableToExcel(tbkho);
        }
    }//GEN-LAST:event_btxuatexcelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btlammoi;
    private javax.swing.JButton btsua;
    private javax.swing.JButton btthem;
    private javax.swing.JButton btxemchitiet;
    private javax.swing.JButton btxoa;
    private javax.swing.JButton btxuatexcel;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbkho;
    private javax.swing.JTextField tftimkiem;
    // End of variables declaration//GEN-END:variables
}
