/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.Font;
import java.awt.event.ItemEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import model.Kho_md;
import model.Product_md;

/**
 *
 * @author HoangHiep
 */
public class DetailKho extends javax.swing.JFrame {

    public DetailKho() throws SQLException, ClassNotFoundException {
        initComponents();
        this.setLocationRelativeTo(null);    //căn cửa sổ ra giữa màn hình
        setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);   //đóng cửa sổ hiện tại các cửa sổ khác giữ nguyên
        JTableHeader header = tbvattu.getTableHeader();
        header.setFont(new Font("SansSerif", Font.BOLD, 14)); 
        init_kho();
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
    
     public void ResetTable(){
        DefaultTableModel model = (DefaultTableModel) tbvattu.getModel();
        model.setRowCount(0);
        model.setRowCount(40);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbbmakho = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfsoluongvattu = new javax.swing.JTextField();
        tftenkho = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbvattu = new javax.swing.JTable();
        btxemchitiet = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Thông tin chi tiết kho");
        setMaximumSize(new java.awt.Dimension(960, 520));
        setMinimumSize(new java.awt.Dimension(960, 520));
        setPreferredSize(new java.awt.Dimension(960, 520));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(89, 165, 104));
        jPanel1.setMaximumSize(new java.awt.Dimension(960, 50));
        jPanel1.setMinimumSize(new java.awt.Dimension(960, 50));
        jPanel1.setPreferredSize(new java.awt.Dimension(960, 50));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÔNG TIN CHI TIẾT KHO");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(309, 309, 309)
                .addComponent(jLabel1)
                .addContainerGap(353, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Danh sách vật tư");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(395, 166, 148, 27));

        cbbmakho.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(cbbmakho, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 68, 176, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mã Kho");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 69, 70, 27));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Tên Kho");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 70, 27));

        tfsoluongvattu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(tfsoluongvattu, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 124, 74, -1));

        tftenkho.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        getContentPane().add(tftenkho, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, 254, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Số lượng vật tư trong kho:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 124, 175, 27));

        tbvattu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbvattu.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null}
            },
            new String [] {
                "Mã vật tư", "Tên vật tư", "Mã nhà cung cấp", "Số lượng", "Đơn vị tính"
            }
        ));
        tbvattu.setGridColor(new java.awt.Color(204, 204, 204));
        tbvattu.setShowGrid(true);
        jScrollPane1.setViewportView(tbvattu);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 940, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 940, 310));

        btxemchitiet.setBackground(new java.awt.Color(89, 165, 104));
        btxemchitiet.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btxemchitiet.setForeground(new java.awt.Color(255, 255, 255));
        btxemchitiet.setText("Xem chi tiết");
        btxemchitiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btxemchitietMouseClicked(evt);
            }
        });
        getContentPane().add(btxemchitiet, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 70, 130, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btxemchitietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btxemchitietMouseClicked
            String makho = cbbmakho.getSelectedItem().toString();
            Kho_md kho;
        try {
            kho = new Kho_md();
            Product_md product = new Product_md();
            ResultSet rs1 = kho.ChiTietKho(makho);
            ResultSet rs2 = product.ChiTietKho(makho);          
            while(rs1.next()){
                tftenkho.setText(rs1.getString("TenKho"));
                tfsoluongvattu.setText(rs1.getString("SoLuong"));
            }
            ResetTable();
            int i = 0;
            while(rs2.next()){
                tbvattu.setValueAt(rs2.getString("MaVatTu"), i, 0);
                tbvattu.setValueAt(rs2.getString("TenVatTu"), i, 1);
                tbvattu.setValueAt(rs2.getString("MaNCC"), i, 2);
                tbvattu.setValueAt(rs2.getString("SoLuong"), i, 3);
                tbvattu.setValueAt(rs2.getString("DonViTinh"), i, 4);
                i++;
            }
            kho.Close();
            product.Close();
        } catch (SQLException ex) {
            Logger.getLogger(DetailKho.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DetailKho.class.getName()).log(Level.SEVERE, null, ex);
        }          
    }//GEN-LAST:event_btxemchitietMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new DetailKho().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(DetailKho.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DetailKho.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btxemchitiet;
    private javax.swing.JComboBox<String> cbbmakho;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbvattu;
    private javax.swing.JTextField tfsoluongvattu;
    private javax.swing.JTextField tftenkho;
    // End of variables declaration//GEN-END:variables
}
