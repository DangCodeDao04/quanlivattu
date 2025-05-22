/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.Image;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import model.Account_md;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;
import model.NumberOnlyFilter;

/**
 *
 * @author HoangHiep
 */
public class DangKy extends javax.swing.JFrame {
    private boolean isPasswordVisible = false;
    private ImageIcon eyeOpen;
    private ImageIcon eyeClosed;
    public DangKy() {
        initComponents();
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon/building48px.png"));
        this.setIconImage(icon);
        eyeOpen = new ImageIcon(getClass().getResource("/icon/eyeopen.png"));
        eyeClosed = new ImageIcon(getClass().getResource("/icon/eyeclosed.png"));

        lbeye.setIcon(eyeClosed);
        lbeye.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ((AbstractDocument) tfsodienthoai.getDocument()).setDocumentFilter(new NumberOnlyFilter());
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        tfemail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfsodienthoai = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfusername = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfpassword = new javax.swing.JPasswordField();
        lbeye = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btdong = new javax.swing.JButton();
        btdangky = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ĐĂNG KÝ");
        setMaximumSize(new java.awt.Dimension(472, 515));
        setMinimumSize(new java.awt.Dimension(472, 515));

        jPanel1.setBackground(new java.awt.Color(89, 165, 104));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(630, 50));
        jPanel1.setMinimumSize(new java.awt.Dimension(630, 50));
        jPanel1.setPreferredSize(new java.awt.Dimension(630, 50));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ĐĂNG KÝ TÀI KHOẢN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setMaximumSize(new java.awt.Dimension(630, 252));
        jPanel2.setMinimumSize(new java.awt.Dimension(630, 252));
        jPanel2.setPreferredSize(new java.awt.Dimension(630, 252));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfemail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel2.add(tfemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 210, 274, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Email");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 183, 223, -1));

        tfsodienthoai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel2.add(tfsodienthoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 280, 274, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Số điện thoại");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 253, 274, -1));

        tfusername.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel2.add(tfusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 65, 274, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("UserName");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 38, 223, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Password");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 108, 223, -1));

        tfpassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel2.add(tfpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(107, 135, 274, 30));

        lbeye.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/eyeclosed.png"))); // NOI18N
        lbeye.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbeyeMouseClicked(evt);
            }
        });
        jPanel2.add(lbeye, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, -1, 20));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Thông tin cá nhân");

        btdong.setBackground(new java.awt.Color(204, 0, 51));
        btdong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btdong.setForeground(new java.awt.Color(255, 255, 255));
        btdong.setText("Đóng");
        btdong.setBorder(null);
        btdong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btdongMouseClicked(evt);
            }
        });

        btdangky.setBackground(new java.awt.Color(89, 165, 104));
        btdangky.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btdangky.setForeground(new java.awt.Color(255, 255, 255));
        btdangky.setText("Đăng Ký");
        btdangky.setBorder(null);
        btdangky.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btdangkyMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(btdangky, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btdong, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btdangky, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btdong, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btdongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btdongMouseClicked
        new Login().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btdongMouseClicked

    private void btdangkyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btdangkyMouseClicked
        String username = tfusername.getText();
        String password = tfpassword.getText();
        String email = tfemail.getText();
        String sodienthoai = tfsodienthoai.getText();
        String vaitro = "Employee";
        if(username.equals("") || password.equals("") || email.equals("") || sodienthoai.equals("")){
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin!");
        }
        else{
            try {
                Account_md account = new Account_md();
                account.Insert(username, password, email, sodienthoai, vaitro);
                JOptionPane.showMessageDialog(this, "Đăng ký thành công!");
                new Login().setVisible(true);
                this.setVisible(false);
                account.Close();
            } catch (SQLException ex) {
                System.out.println("Class Not Found!");
            } catch (ClassNotFoundException ex) {
                System.out.println("Execute Failure!");
            }          
        }
    }//GEN-LAST:event_btdangkyMouseClicked

    private void lbeyeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbeyeMouseClicked
        isPasswordVisible = !isPasswordVisible;
        if (isPasswordVisible) {
            tfpassword.setEchoChar((char) 0);  // Hiện mật khẩu
            lbeye.setIcon(eyeOpen);
        } else {
            tfpassword.setEchoChar('•');       // Ẩn mật khẩu
            lbeye.setIcon(eyeClosed);
        }
    }//GEN-LAST:event_lbeyeMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangKy().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btdangky;
    private javax.swing.JButton btdong;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbeye;
    private javax.swing.JTextField tfemail;
    private javax.swing.JPasswordField tfpassword;
    private javax.swing.JTextField tfsodienthoai;
    private javax.swing.JTextField tfusername;
    // End of variables declaration//GEN-END:variables
}
