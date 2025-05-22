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
import javax.swing.JPanel;

/**
 *
 * @author HoangHiep
 */
public class Admin extends javax.swing.JFrame {
    Color DefaultColor, ClickedColor;
    
    public Admin() throws SQLException, ClassNotFoundException {    
        initComponents();
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon/building48px.png"));
        this.setIconImage(icon);
        this.setLocationRelativeTo(null);
        khoitao();
        DefaultColor = new Color(89, 168, 105);
        ClickedColor = new Color(26, 188, 156);
        lbsanpham.setOpaque(true);      //bật nền cho lable\mặc định là trong suốt
        lbsanpham.setBackground(ClickedColor);     //đặt lại cho màu nền
    }
    
    public void khoitao() throws SQLException, ClassNotFoundException{
        Product product = new Product();       
        jpanelMain.removeAll();
        jpanelMain.add(product).setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbsanpham = new javax.swing.JLabel();
        lbnhacungcap = new javax.swing.JLabel();
        lbnhaphang = new javax.swing.JLabel();
        lbphieunhap = new javax.swing.JLabel();
        lbxuathang = new javax.swing.JLabel();
        lbphieuxuat = new javax.swing.JLabel();
        lbkho = new javax.swing.JLabel();
        lbtaikhoan = new javax.swing.JLabel();
        lbthongke = new javax.swing.JLabel();
        lbkhachhang = new javax.swing.JLabel();
        lbdangxuat = new javax.swing.JLabel();
        jpanelMain = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admin");
        setMaximumSize(new java.awt.Dimension(1350, 660));
        setMinimumSize(new java.awt.Dimension(1350, 660));
        setPreferredSize(new java.awt.Dimension(1350, 660));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(89, 165, 104));
        jPanel1.setMaximumSize(new java.awt.Dimension(240, 650));
        jPanel1.setMinimumSize(new java.awt.Dimension(240, 650));
        jPanel1.setPreferredSize(new java.awt.Dimension(240, 650));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Hi!");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 28, 31, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ADMIN");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 60, 72, -1));

        lbsanpham.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbsanpham.setForeground(new java.awt.Color(255, 255, 255));
        lbsanpham.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbsanpham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_product_25px_2.png"))); // NOI18N
        lbsanpham.setText("SẢN PHẨM");
        lbsanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbsanphamMouseClicked(evt);
            }
        });
        jPanel1.add(lbsanpham, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 251, 30));

        lbnhacungcap.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbnhacungcap.setForeground(new java.awt.Color(255, 255, 255));
        lbnhacungcap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbnhacungcap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_supplier_25px.png"))); // NOI18N
        lbnhacungcap.setText("NHÀ CUNG CẤP");
        lbnhacungcap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbnhacungcapMouseClicked(evt);
            }
        });
        jPanel1.add(lbnhacungcap, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 204, 251, 30));

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
        jPanel1.add(lbnhaphang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 251, 30));

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
        jPanel1.add(lbphieunhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 279, 251, 30));

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
        jPanel1.add(lbxuathang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 317, 251, 30));

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
        jPanel1.add(lbphieuxuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 355, 251, 30));

        lbkho.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbkho.setForeground(new java.awt.Color(255, 255, 255));
        lbkho.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbkho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-warehouse-25.png"))); // NOI18N
        lbkho.setText("KHO");
        lbkho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbkhoMouseClicked(evt);
            }
        });
        jPanel1.add(lbkho, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 393, 251, 30));

        lbtaikhoan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbtaikhoan.setForeground(new java.awt.Color(255, 255, 255));
        lbtaikhoan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbtaikhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_test_account_25px.png"))); // NOI18N
        lbtaikhoan.setText("TÀI KHOẢN");
        lbtaikhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbtaikhoanMouseClicked(evt);
            }
        });
        jPanel1.add(lbtaikhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 431, 251, 30));

        lbthongke.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbthongke.setForeground(new java.awt.Color(255, 255, 255));
        lbthongke.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbthongke.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/statisticals.png"))); // NOI18N
        lbthongke.setText("THỐNG KÊ");
        lbthongke.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbthongkeMouseClicked(evt);
            }
        });
        jPanel1.add(lbthongke, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 469, 251, 30));

        lbkhachhang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbkhachhang.setForeground(new java.awt.Color(255, 255, 255));
        lbkhachhang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbkhachhang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_supplier_25px.png"))); // NOI18N
        lbkhachhang.setText("KHÁCH HÀNG");
        lbkhachhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbkhachhangMouseClicked(evt);
            }
        });
        jPanel1.add(lbkhachhang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 251, 30));

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
        jPanel1.add(lbdangxuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, 251, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 251, -1));

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

        getContentPane().add(jpanelMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 0, 1090, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbsanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbsanphamMouseClicked
        lbsanpham.setBackground(ClickedColor);
        lbsanpham.setOpaque(true);
        lbdangxuat.setBackground(DefaultColor);
        lbdangxuat.setOpaque(false);
        lbkhachhang.setBackground(DefaultColor);
        lbkhachhang.setOpaque(false);
        lbkho.setBackground(DefaultColor);
        lbkho.setOpaque(false);
        lbnhacungcap.setBackground(DefaultColor);
        lbnhacungcap.setOpaque(false);
        lbnhaphang.setBackground(DefaultColor);
        lbnhaphang.setOpaque(false);
        lbphieunhap.setBackground(DefaultColor);
        lbphieunhap.setOpaque(false);
        lbphieuxuat.setBackground(DefaultColor);
        lbphieuxuat.setOpaque(false);
        lbtaikhoan.setBackground(DefaultColor);
        lbtaikhoan.setOpaque(false);
        lbthongke.setBackground(DefaultColor);
        lbthongke.setOpaque(false);
        lbxuathang.setBackground(DefaultColor);
        lbxuathang.setOpaque(false);
        try {
            khoitao();
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lbsanphamMouseClicked

    private void lbnhacungcapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbnhacungcapMouseClicked
        lbsanpham.setBackground(DefaultColor);
        lbsanpham.setOpaque(false);
        lbdangxuat.setBackground(DefaultColor);
        lbdangxuat.setOpaque(false);
        lbkhachhang.setBackground(DefaultColor);
        lbkhachhang.setOpaque(false);
        lbkho.setBackground(DefaultColor);
        lbkho.setOpaque(false);
        lbnhacungcap.setOpaque(true);
        lbnhacungcap.setBackground(ClickedColor);
        lbnhaphang.setBackground(DefaultColor);
        lbnhaphang.setOpaque(false);
        lbphieunhap.setBackground(DefaultColor);
        lbphieunhap.setOpaque(false);
        lbphieuxuat.setBackground(DefaultColor);
        lbphieuxuat.setOpaque(false);
        lbtaikhoan.setBackground(DefaultColor);
        lbtaikhoan.setOpaque(false);
        lbthongke.setBackground(DefaultColor);
        lbthongke.setOpaque(false);
        lbxuathang.setBackground(DefaultColor);
        lbxuathang.setOpaque(false);
        NhaCungCap nhacungcap;       
        try {
            nhacungcap = new NhaCungCap();
            jpanelMain.removeAll();
            jpanelMain.add(nhacungcap).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_lbnhacungcapMouseClicked

    private void lbkhachhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbkhachhangMouseClicked
        lbsanpham.setBackground(DefaultColor);
        lbsanpham.setOpaque(false);
        lbdangxuat.setBackground(DefaultColor);
        lbdangxuat.setOpaque(false);
        lbkhachhang.setBackground(ClickedColor);
        lbkhachhang.setOpaque(true);
        lbkho.setBackground(DefaultColor);
        lbkho.setOpaque(false);
        lbnhacungcap.setBackground(DefaultColor);
        lbnhacungcap.setOpaque(false);
        lbnhaphang.setBackground(DefaultColor);
        lbnhaphang.setOpaque(false);
        lbphieunhap.setBackground(DefaultColor);
        lbphieunhap.setOpaque(false);
        lbphieuxuat.setBackground(DefaultColor);
        lbphieuxuat.setOpaque(false);
        lbtaikhoan.setBackground(DefaultColor);
        lbtaikhoan.setOpaque(false);
        lbthongke.setBackground(DefaultColor);
        lbthongke.setOpaque(false);
        lbxuathang.setBackground(DefaultColor);
        lbxuathang.setOpaque(false);
        KhachHang khachhang;       
        try {
            khachhang = new KhachHang();
            jpanelMain.removeAll();
            jpanelMain.add(khachhang).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_lbkhachhangMouseClicked

    private void lbkhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbkhoMouseClicked
        try {
            lbsanpham.setBackground(DefaultColor);
            lbsanpham.setOpaque(false);
            lbdangxuat.setBackground(DefaultColor);
            lbdangxuat.setOpaque(false);
            lbkhachhang.setBackground(DefaultColor);
            lbkhachhang.setOpaque(false);
            lbkho.setBackground(ClickedColor);
            lbkho.setOpaque(true);
            lbnhacungcap.setBackground(DefaultColor);
            lbnhacungcap.setOpaque(false);
            lbnhaphang.setBackground(DefaultColor);
            lbnhaphang.setOpaque(false);
            lbphieunhap.setBackground(DefaultColor);
            lbphieunhap.setOpaque(false);
            lbphieuxuat.setBackground(DefaultColor);
            lbphieuxuat.setOpaque(false);
            lbtaikhoan.setBackground(DefaultColor);
            lbtaikhoan.setOpaque(false);
            lbthongke.setBackground(DefaultColor);
            lbthongke.setOpaque(false);
            lbxuathang.setBackground(DefaultColor);
            lbxuathang.setOpaque(false);
            Kho kho = new Kho();
            jpanelMain.removeAll();
            jpanelMain.add(kho).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_lbkhoMouseClicked

    private void lbtaikhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbtaikhoanMouseClicked
        lbsanpham.setBackground(DefaultColor);
        lbsanpham.setOpaque(false);
        lbdangxuat.setBackground(DefaultColor);
        lbdangxuat.setOpaque(false);
        lbkhachhang.setBackground(DefaultColor);
        lbkhachhang.setOpaque(false);
        lbkho.setBackground(DefaultColor);
        lbkho.setOpaque(false);
        lbnhacungcap.setBackground(DefaultColor);
        lbnhacungcap.setOpaque(false);
        lbnhaphang.setBackground(DefaultColor);
        lbnhaphang.setOpaque(false);
        lbphieunhap.setBackground(DefaultColor);
        lbphieunhap.setOpaque(false);
        lbphieuxuat.setBackground(DefaultColor);
        lbphieuxuat.setOpaque(false);
        lbtaikhoan.setBackground(ClickedColor);
        lbtaikhoan.setOpaque(true);
        lbthongke.setBackground(DefaultColor);
        lbthongke.setOpaque(false);
        lbxuathang.setBackground(DefaultColor);
        lbxuathang.setOpaque(false);
        Account account;       
        try {
            account = new Account();
            jpanelMain.removeAll();
            jpanelMain.add(account).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }//GEN-LAST:event_lbtaikhoanMouseClicked

    private void lbdangxuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbdangxuatMouseClicked
        new Login().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_lbdangxuatMouseClicked

    private void lbxuathangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbxuathangMouseClicked
        lbsanpham.setBackground(DefaultColor);
        lbsanpham.setOpaque(false);
        lbdangxuat.setBackground(DefaultColor);
        lbdangxuat.setOpaque(false);
        lbkhachhang.setBackground(DefaultColor);
        lbkhachhang.setOpaque(false);
        lbkho.setBackground(DefaultColor);
        lbkho.setOpaque(false);
        lbnhacungcap.setBackground(DefaultColor);
        lbnhacungcap.setOpaque(false);
        lbnhaphang.setBackground(DefaultColor);
        lbnhaphang.setOpaque(false);
        lbphieunhap.setBackground(DefaultColor);
        lbphieunhap.setOpaque(false);
        lbphieuxuat.setBackground(DefaultColor);
        lbphieuxuat.setOpaque(false);
        lbtaikhoan.setBackground(DefaultColor);
        lbtaikhoan.setOpaque(false);
        lbthongke.setBackground(DefaultColor);
        lbthongke.setOpaque(false);
        lbxuathang.setBackground(ClickedColor);
        lbxuathang.setOpaque(true);       
        XuatHang xuathang;
        try {
            xuathang = new XuatHang();
            jpanelMain.removeAll();
            jpanelMain.add(xuathang).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }          
    }//GEN-LAST:event_lbxuathangMouseClicked

    private void lbnhaphangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbnhaphangMouseClicked
        lbsanpham.setBackground(DefaultColor);
        lbsanpham.setOpaque(false);
        lbdangxuat.setBackground(DefaultColor);
        lbdangxuat.setOpaque(false);
        lbkhachhang.setBackground(DefaultColor);
        lbkhachhang.setOpaque(false);
        lbkho.setBackground(DefaultColor);
        lbkho.setOpaque(false);
        lbnhacungcap.setBackground(DefaultColor);
        lbnhacungcap.setOpaque(false);
        lbnhaphang.setBackground(ClickedColor);
        lbnhaphang.setOpaque(true);
        lbphieunhap.setBackground(DefaultColor);
        lbphieunhap.setOpaque(false);
        lbphieuxuat.setBackground(DefaultColor);
        lbphieuxuat.setOpaque(false);
        lbtaikhoan.setBackground(DefaultColor);
        lbtaikhoan.setOpaque(false);
        lbthongke.setBackground(DefaultColor);
        lbthongke.setOpaque(false);
        lbxuathang.setBackground(DefaultColor);
        lbxuathang.setOpaque(false);       
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

    private void lbphieuxuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbphieuxuatMouseClicked
        lbsanpham.setBackground(DefaultColor);
        lbsanpham.setOpaque(false);
        lbdangxuat.setBackground(DefaultColor);
        lbdangxuat.setOpaque(false);
        lbkhachhang.setBackground(DefaultColor);
        lbkhachhang.setOpaque(false);
        lbkho.setBackground(DefaultColor);
        lbkho.setOpaque(false);
        lbnhacungcap.setBackground(DefaultColor);
        lbnhacungcap.setOpaque(false);
        lbnhaphang.setBackground(DefaultColor);
        lbnhaphang.setOpaque(false);
        lbphieunhap.setBackground(DefaultColor);
        lbphieunhap.setOpaque(false);
        lbphieuxuat.setBackground(ClickedColor);
        lbphieuxuat.setOpaque(true);
        lbtaikhoan.setBackground(DefaultColor);
        lbtaikhoan.setOpaque(false);
        lbthongke.setBackground(DefaultColor);
        lbthongke.setOpaque(false);
        lbxuathang.setBackground(DefaultColor);
        lbxuathang.setOpaque(false);       
        PhieuXuat phieuxuat;
        try {
            phieuxuat = new PhieuXuat();
            jpanelMain.removeAll();
            jpanelMain.add(phieuxuat).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }//GEN-LAST:event_lbphieuxuatMouseClicked

    private void lbphieunhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbphieunhapMouseClicked
        lbsanpham.setBackground(DefaultColor);
        lbsanpham.setOpaque(false);
        lbdangxuat.setBackground(DefaultColor);
        lbdangxuat.setOpaque(false);
        lbkhachhang.setBackground(DefaultColor);
        lbkhachhang.setOpaque(false);
        lbkho.setBackground(DefaultColor);
        lbkho.setOpaque(false);
        lbnhacungcap.setBackground(DefaultColor);
        lbnhacungcap.setOpaque(false);
        lbnhaphang.setBackground(DefaultColor);
        lbnhaphang.setOpaque(false);
        lbphieunhap.setBackground(ClickedColor);
        lbphieunhap.setOpaque(true);
        lbphieuxuat.setBackground(DefaultColor);
        lbphieuxuat.setOpaque(false);
        lbtaikhoan.setBackground(DefaultColor);
        lbtaikhoan.setOpaque(false);
        lbthongke.setBackground(DefaultColor);
        lbthongke.setOpaque(false);
        lbxuathang.setBackground(DefaultColor);
        lbxuathang.setOpaque(false);       
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
    }//GEN-LAST:event_lbphieunhapMouseClicked

    private void lbthongkeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbthongkeMouseClicked
        lbsanpham.setBackground(DefaultColor);
        lbsanpham.setOpaque(false);
        lbdangxuat.setBackground(DefaultColor);
        lbdangxuat.setOpaque(false);
        lbkhachhang.setBackground(DefaultColor);
        lbkhachhang.setOpaque(false);
        lbkho.setBackground(DefaultColor);
        lbkho.setOpaque(false);
        lbnhacungcap.setBackground(DefaultColor);
        lbnhacungcap.setOpaque(false);
        lbnhaphang.setBackground(DefaultColor);
        lbnhaphang.setOpaque(false);
        lbphieunhap.setBackground(DefaultColor);
        lbphieunhap.setOpaque(false);
        lbphieuxuat.setBackground(DefaultColor);
        lbphieuxuat.setOpaque(false);
        lbtaikhoan.setBackground(DefaultColor);
        lbtaikhoan.setOpaque(false);
        lbthongke.setBackground(ClickedColor);
        lbthongke.setOpaque(true);
        lbxuathang.setBackground(DefaultColor);
        lbxuathang.setOpaque(false);       
        ThongKe thongke;
        try {
            thongke = new ThongKe();
            jpanelMain.removeAll();
            jpanelMain.add(thongke).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }//GEN-LAST:event_lbthongkeMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Admin().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jpanelMain;
    private javax.swing.JLabel lbdangxuat;
    private javax.swing.JLabel lbkhachhang;
    private javax.swing.JLabel lbkho;
    private javax.swing.JLabel lbnhacungcap;
    private javax.swing.JLabel lbnhaphang;
    private javax.swing.JLabel lbphieunhap;
    private javax.swing.JLabel lbphieuxuat;
    private javax.swing.JLabel lbsanpham;
    private javax.swing.JLabel lbtaikhoan;
    private javax.swing.JLabel lbthongke;
    private javax.swing.JLabel lbxuathang;
    // End of variables declaration//GEN-END:variables
}
