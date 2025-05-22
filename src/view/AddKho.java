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
import javax.swing.text.AbstractDocument;
import model.Kho_md;
import model.NumberOnlyFilter;

/**
 *
 * @author HoangHiep
 */
public class AddKho extends javax.swing.JFrame {

    public AddKho() {
        initComponents();
        // Gắn filter cho TextField chỉ cho nhập số
        ((AbstractDocument) tfsoluong.getDocument()).setDocumentFilter(new NumberOnlyFilter());
        this.setLocationRelativeTo(null);    //căn cửa sổ ra giữa màn hình
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);   //đóng cửa sổ hiện tại các cửa sổ khác giữ nguyên
    }
    
    public boolean check_id(String ID){
        boolean check = false;
        try {         
            Kho_md kho = new Kho_md();
            ResultSet rs = kho.GetData();
            while (rs.next()) {
                if (rs.getString("MaKho").equals(ID) == true) {
                    check = true;
                }
            }
            kho.Close();       
        } catch (SQLException ex) {
            System.out.println("error");
        } catch (ClassNotFoundException ex) {
            System.out.println("error");
        }
        return check;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfsoluong = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfmakho = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tftenkho = new javax.swing.JTextField();
        btthem = new javax.swing.JButton();
        bthuybo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cập nhật thông tin");
        setMinimumSize(new java.awt.Dimension(390, 500));

        jPanel1.setBackground(new java.awt.Color(89, 165, 104));
        jPanel1.setMaximumSize(new java.awt.Dimension(390, 70));
        jPanel1.setMinimumSize(new java.awt.Dimension(390, 70));
        jPanel1.setPreferredSize(new java.awt.Dimension(390, 70));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("THÊM KHO MỚI");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Số lượng vật tư trong kho");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mã kho");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Tên kho");

        btthem.setBackground(new java.awt.Color(89, 165, 104));
        btthem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btthem.setForeground(new java.awt.Color(255, 255, 255));
        btthem.setText("Thêm");
        btthem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btthemMouseClicked(evt);
            }
        });

        bthuybo.setBackground(new java.awt.Color(255, 0, 0));
        bthuybo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bthuybo.setForeground(new java.awt.Color(255, 255, 255));
        bthuybo.setText("Hủy bỏ");
        bthuybo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bthuyboMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(tfsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(btthem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(bthuybo, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(tfmakho, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tftenkho, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfmakho, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tftenkho, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btthem, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bthuybo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bthuyboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bthuyboMouseClicked
        tfmakho.setText("");
        tftenkho.setText("");
        tfsoluong.setText("");
    }//GEN-LAST:event_bthuyboMouseClicked

    private void btthemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btthemMouseClicked
        String makho = tfmakho.getText();
        String tenkho = tftenkho.getText();
        String sl = tfsoluong.getText();
        int soluong; 
        if(makho.equals("")||tenkho.equals("")||sl.equals("")){
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
        }
        else{
            soluong = Integer.parseInt(tfsoluong.getText());
            if(check_id(makho) == true){
                JOptionPane.showMessageDialog(this, "Mã kho đã tồn tại");
            }
            else{
                try {
                    Kho_md kho = new Kho_md();
                    kho.Insert(makho, tenkho, soluong);
                    kho.Close();
                    JOptionPane.showMessageDialog(this, "Thêm kho thành công!");
                } catch (SQLException ex) {
                    Logger.getLogger(AddKhachHang.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AddKhachHang.class.getName()).log(Level.SEVERE, null, ex);
                }             
            }
        }
    }//GEN-LAST:event_btthemMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddKho().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bthuybo;
    private javax.swing.JButton btthem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tfmakho;
    private javax.swing.JTextField tfsoluong;
    private javax.swing.JTextField tftenkho;
    // End of variables declaration//GEN-END:variables
}
