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
import model.Kho_md;
import model.NhaCungCap_md;
import model.Product_md;

/**
 *
 * @author HoangHiep
 */
public class UpdateProduct extends javax.swing.JFrame {

    public UpdateProduct(String mavattu) throws SQLException, ClassNotFoundException {
        initComponents();
        this.setLocationRelativeTo(null);    //căn cửa sổ ra giữa màn hình
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);   //đóng cửa sổ hiện tại các cửa sổ khác giữ nguyên
        init_kho();
        init_nhacungcap();
        set_thuoc_tinh(mavattu);
    }
    public void set_thuoc_tinh(String mavattu) throws SQLException, ClassNotFoundException{
        Product_md product = new Product_md();
        ResultSet rs = product.GetData_Fix();
        while(rs.next()){
            if(rs.getString("MaVatTu").equals(mavattu) == true){
                tfmavattu.setText(rs.getString("MaVatTu"));
                tfmavattu.setEditable(false);
                tftenvattu.setText(rs.getString("TenVatTu"));
                cbbmanhacungcap.setSelectedItem(rs.getString("MaNCC"));
                cbbmakho.setSelectedItem(rs.getString("MaKho"));
                tfsoluong.setText(rs.getString("SoLuong"));
                tfdonvitinh.setText(rs.getString("DonViTinh"));
                tfgianhap.setText(rs.getString("GiaNhap"));
                tfgiaxuat.setText(rs.getString("GiaXuat"));
            }
        }
        product.Close();
    }
      
    public void init_kho() throws SQLException, ClassNotFoundException{
        Kho_md kho = new Kho_md();
        ResultSet rs = kho.GetData();
        int i = 0;
        while(rs.next()){
            cbbmakho.addItem(rs.getString("MaKho"));
            i++;
        }
        kho.Close();
    }
    public void init_nhacungcap() throws SQLException, ClassNotFoundException{
        NhaCungCap_md nhacungcap = new NhaCungCap_md();
        ResultSet rs = nhacungcap.GetData();
        int i = 0;
        while(rs.next()){
            cbbmanhacungcap.addItem(rs.getString("MaNCC"));
            i++;
        }
        nhacungcap.Close();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfmavattu = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tfgiaxuat = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tftenvattu = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfdonvitinh = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfsoluong = new javax.swing.JTextField();
        tfgianhap = new javax.swing.JTextField();
        bthuybo = new javax.swing.JButton();
        btcapnhat = new javax.swing.JButton();
        cbbmakho = new javax.swing.JComboBox<>();
        cbbmanhacungcap = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cập nhật sản phẩm");
        setMaximumSize(new java.awt.Dimension(830, 400));
        setMinimumSize(new java.awt.Dimension(830, 400));

        jPanel1.setBackground(new java.awt.Color(89, 165, 104));
        jPanel1.setMaximumSize(new java.awt.Dimension(830, 50));
        jPanel1.setMinimumSize(new java.awt.Dimension(830, 50));
        jPanel1.setPreferredSize(new java.awt.Dimension(830, 50));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CẬP NHẬT SẢN PHẨM");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(277, 277, 277)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(281, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        tfmavattu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Giá nhập");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mã vật tư");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Giá xuất");

        tfgiaxuat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Tên vật tư");

        tftenvattu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Đơn vị tính");

        tfdonvitinh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Mã kho");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Số lượng");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã nhà cung cấp");

        tfsoluong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        tfgianhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        bthuybo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bthuybo.setForeground(new java.awt.Color(255, 0, 51));
        bthuybo.setText("Hủy bỏ");
        bthuybo.setToolTipText("");
        bthuybo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bthuyboMouseClicked(evt);
            }
        });

        btcapnhat.setBackground(new java.awt.Color(89, 165, 104));
        btcapnhat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btcapnhat.setText("Cập nhật");
        btcapnhat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btcapnhatMouseClicked(evt);
            }
        });

        cbbmakho.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cbbmanhacungcap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                    .addComponent(tfmavattu, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                    .addComponent(tftenvattu, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                    .addComponent(cbbmanhacungcap, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                    .addComponent(tfsoluong, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                    .addComponent(tfdonvitinh, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                    .addComponent(cbbmakho, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfgianhap, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfgiaxuat, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(209, 209, 209)
                .addComponent(btcapnhat, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(bthuybo, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(1, 1, 1)
                        .addComponent(tfmavattu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addGap(1, 1, 1)
                        .addComponent(tftenvattu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6))
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbbmakho, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)
                                .addGap(1, 1, 1)
                                .addComponent(tfsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfdonvitinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbmanhacungcap, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tfgianhap, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10)
                                .addGap(1, 1, 1)
                                .addComponent(tfgiaxuat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btcapnhat, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bthuybo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bthuyboMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bthuyboMouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_bthuyboMouseClicked

    private void btcapnhatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btcapnhatMouseClicked
        String mavattu = tfmavattu.getText();
        String tenvattu = tftenvattu.getText();
        String manhacungcap = cbbmanhacungcap.getSelectedItem().toString();
        String makho = cbbmakho.getSelectedItem().toString();
        int soluong = Integer.parseInt(tfsoluong.getText());
        String donvitinh = tfdonvitinh.getText();
        float gianhap = Float.parseFloat(tfgianhap.getText());
        float giaxuat = Float.parseFloat(tfgiaxuat.getText());
        try {
            Product_md product = new Product_md();
            product.Fix(mavattu, tenvattu, manhacungcap, makho, soluong, donvitinh, gianhap, giaxuat);
            product.Close();
            JOptionPane.showMessageDialog(this, "Thay đổi thông tin thành công!");
        } catch (SQLException ex) {
            Logger.getLogger(UpdateProduct.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btcapnhatMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new UpdateProduct("").setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(UpdateProduct.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(UpdateProduct.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btcapnhat;
    private javax.swing.JButton bthuybo;
    private javax.swing.JComboBox<String> cbbmakho;
    private javax.swing.JComboBox<String> cbbmanhacungcap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tfdonvitinh;
    private javax.swing.JTextField tfgianhap;
    private javax.swing.JTextField tfgiaxuat;
    private javax.swing.JTextField tfmavattu;
    private javax.swing.JTextField tfsoluong;
    private javax.swing.JTextField tftenvattu;
    // End of variables declaration//GEN-END:variables
}
