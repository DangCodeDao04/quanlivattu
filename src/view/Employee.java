/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HoangHiep
 */
public class Employee extends javax.swing.JFrame {
    Color DefaultColor, ClickedColor;

    public Employee() throws SQLException, ClassNotFoundException {
        initComponents();
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon/building48px.png"));
        this.setIconImage(icon);
        this.setLocationRelativeTo(null);
        khoitao();
        DefaultColor = new Color(89, 168, 105);
        ClickedColor = new Color(26, 188, 156);
        lbxuathang.setOpaque(true);     //bật nền cho lable\mặc định là trong suốt
        lbxuathang.setBackground(ClickedColor);     //đặt lại cho màu nền
    }
    
    public void khoitao() throws SQLException, ClassNotFoundException{
        XuatHang xuathang = new XuatHang();       
        jpanelMain.removeAll();
        jpanelMain.add(xuathang).setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbname = new javax.swing.JLabel();
        lbphieuxuat = new javax.swing.JLabel();
        lbxuathang = new javax.swing.JLabel();
        lbdangxuat = new javax.swing.JLabel();
        lbnhaphang = new javax.swing.JLabel();
        lbdoithongtin = new javax.swing.JLabel();
        lbphieunhap = new javax.swing.JLabel();
        jpanelMain = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Employee");
        setMaximumSize(new java.awt.Dimension(1350, 650));
        setMinimumSize(new java.awt.Dimension(1350, 650));
        setPreferredSize(new java.awt.Dimension(1350, 650));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(89, 165, 104));
        jPanel1.setMaximumSize(new java.awt.Dimension(240, 650));
        jPanel1.setMinimumSize(new java.awt.Dimension(240, 650));
        jPanel1.setPreferredSize(new java.awt.Dimension(240, 650));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Hi!");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 31, 31, -1));

        lbname.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbname.setForeground(new java.awt.Color(255, 255, 255));
        lbname.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbname.setText("Have a good day!");
        jPanel1.add(lbname, new org.netbeans.lib.awtextra.AbsoluteConstraints(46, 63, -1, -1));

        lbphieuxuat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbphieuxuat.setForeground(new java.awt.Color(255, 255, 255));
        lbphieuxuat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbphieuxuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_database_daily_export_25px.png"))); // NOI18N
        lbphieuxuat.setText("PHIẾU XUẤT");
        lbphieuxuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbphieuxuatMouseClicked(evt);
            }
        });
        jPanel1.add(lbphieuxuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 240, 32));

        lbxuathang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbxuathang.setForeground(new java.awt.Color(255, 255, 255));
        lbxuathang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbxuathang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_export_25px.png"))); // NOI18N
        lbxuathang.setText("XUẤT HÀNG");
        lbxuathang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbxuathangMouseClicked(evt);
            }
        });
        jPanel1.add(lbxuathang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 129, 240, 34));

        lbdangxuat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbdangxuat.setForeground(new java.awt.Color(255, 255, 255));
        lbdangxuat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbdangxuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_shutdown_25px.png"))); // NOI18N
        lbdangxuat.setText("ĐĂNG XUẤT");
        lbdangxuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbdangxuatMouseClicked(evt);
            }
        });
        jPanel1.add(lbdangxuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 240, 32));

        lbnhaphang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbnhaphang.setForeground(new java.awt.Color(255, 255, 255));
        lbnhaphang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbnhaphang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_import_25px.png"))); // NOI18N
        lbnhaphang.setText("NHẬP HÀNG");
        lbnhaphang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbnhaphangMouseClicked(evt);
            }
        });
        jPanel1.add(lbnhaphang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 240, 30));

        lbdoithongtin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbdoithongtin.setForeground(new java.awt.Color(255, 255, 255));
        lbdoithongtin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbdoithongtin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-information-25.png"))); // NOI18N
        lbdoithongtin.setText("Đổi thông tin");
        lbdoithongtin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbdoithongtinMouseClicked(evt);
            }
        });
        jPanel1.add(lbdoithongtin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 240, 30));

        lbphieunhap.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbphieunhap.setForeground(new java.awt.Color(255, 255, 255));
        lbphieunhap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbphieunhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_add_file_25px_2.png"))); // NOI18N
        lbphieunhap.setText("PHIẾU NHẬP");
        lbphieunhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbphieunhapMouseClicked(evt);
            }
        });
        jPanel1.add(lbphieunhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 240, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jpanelMain.setBackground(new java.awt.Color(204, 204, 204));
        jpanelMain.setMaximumSize(new java.awt.Dimension(1110, 650));
        jpanelMain.setMinimumSize(new java.awt.Dimension(1110, 650));
        jpanelMain.setPreferredSize(new java.awt.Dimension(1110, 650));

        javax.swing.GroupLayout jpanelMainLayout = new javax.swing.GroupLayout(jpanelMain);
        jpanelMain.setLayout(jpanelMainLayout);
        jpanelMainLayout.setHorizontalGroup(
            jpanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1110, Short.MAX_VALUE)
        );
        jpanelMainLayout.setVerticalGroup(
            jpanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );

        getContentPane().add(jpanelMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(247, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbxuathangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbxuathangMouseClicked
        lbdoithongtin.setBackground(DefaultColor);
        lbdoithongtin.setOpaque(false);
        lbnhaphang.setBackground(DefaultColor);
        lbnhaphang.setOpaque(false);
        lbxuathang.setBackground(ClickedColor);
        lbxuathang.setOpaque(true);
        lbphieuxuat.setBackground(DefaultColor);
        lbphieuxuat.setOpaque(false);
        lbdangxuat.setBackground(DefaultColor);
        lbdangxuat.setOpaque(false);
        try {
            khoitao();
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lbxuathangMouseClicked

    private void lbdangxuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbdangxuatMouseClicked
        lbdoithongtin.setBackground(DefaultColor);
        lbdoithongtin.setOpaque(false);
        lbnhaphang.setBackground(DefaultColor);
        lbnhaphang.setOpaque(false);
        lbxuathang.setBackground(DefaultColor);
        lbxuathang.setOpaque(false);
        lbphieuxuat.setBackground(DefaultColor);
        lbphieuxuat.setOpaque(false);
        lbdangxuat.setBackground(ClickedColor);
        lbdangxuat.setOpaque(true);
        new Login().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lbdangxuatMouseClicked

    private void lbphieuxuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbphieuxuatMouseClicked
        lbdoithongtin.setBackground(DefaultColor);
        lbdoithongtin.setOpaque(false);
        lbnhaphang.setBackground(DefaultColor);
        lbnhaphang.setOpaque(false);
        lbxuathang.setBackground(DefaultColor);
        lbxuathang.setOpaque(false);
        lbphieuxuat.setBackground(ClickedColor);
        lbphieuxuat.setOpaque(true);
        lbdangxuat.setBackground(DefaultColor);
        lbdangxuat.setOpaque(false);
        PhieuNhap phieuxuat;
        try {
            phieuxuat = new PhieuNhap();
            jpanelMain.removeAll();
            jpanelMain.add(phieuxuat).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lbphieuxuatMouseClicked

    private void lbnhaphangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbnhaphangMouseClicked
        lbdoithongtin.setBackground(DefaultColor);
        lbdoithongtin.setOpaque(false);
        lbnhaphang.setBackground(ClickedColor);
        lbnhaphang.setOpaque(true);
        lbxuathang.setBackground(DefaultColor);
        lbxuathang.setOpaque(false);
        lbphieuxuat.setBackground(DefaultColor);
        lbphieuxuat.setOpaque(false);
        lbdangxuat.setBackground(DefaultColor);
        lbdangxuat.setOpaque(false);
        NhapHang nhaphang;
        try {
            nhaphang = new NhapHang();
            jpanelMain.removeAll();
            jpanelMain.add(nhaphang).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lbnhaphangMouseClicked

    private void lbdoithongtinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbdoithongtinMouseClicked
        lbdoithongtin.setBackground(ClickedColor);
        lbdoithongtin.setOpaque(true);
        lbnhaphang.setBackground(DefaultColor);
        lbnhaphang.setOpaque(false);
        lbxuathang.setBackground(DefaultColor);
        lbxuathang.setOpaque(false);
        lbphieuxuat.setBackground(DefaultColor);
        lbphieuxuat.setOpaque(false);
        lbdangxuat.setBackground(DefaultColor);
        lbdangxuat.setOpaque(false);
        PhieuNhap phieunhap;
        try {
            phieunhap = new PhieuNhap();
            jpanelMain.removeAll();
            jpanelMain.add(phieunhap).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lbdoithongtinMouseClicked

    private void lbphieunhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbphieunhapMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbphieunhapMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Employee().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jpanelMain;
    private javax.swing.JLabel lbdangxuat;
    private javax.swing.JLabel lbdoithongtin;
    private javax.swing.JLabel lbname;
    private javax.swing.JLabel lbnhaphang;
    private javax.swing.JLabel lbphieunhap;
    private javax.swing.JLabel lbphieuxuat;
    private javax.swing.JLabel lbxuathang;
    // End of variables declaration//GEN-END:variables
}
