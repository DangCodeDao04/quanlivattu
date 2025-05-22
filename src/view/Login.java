/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.Image;
import java.awt.Toolkit;
import model.Account_md;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

/**
 *
 * @author HoangHiep
 */
public class Login extends javax.swing.JFrame {
    private boolean isPasswordVisible = false;
    private ImageIcon eyeOpen;
    private ImageIcon eyeClosed;
    public Login() {
        initComponents();
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icon/building48px.png"));
        this.setIconImage(icon);
        eyeOpen = new ImageIcon(getClass().getResource("/icon/eyeopen.png"));
        eyeClosed = new ImageIcon(getClass().getResource("/icon/eyeclosed.png"));

        lbeye.setIcon(eyeClosed);
        lbeye.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        this.setLocationRelativeTo(null);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfusername = new javax.swing.JTextField();
        btdangky = new javax.swing.JButton();
        btdangnhap = new javax.swing.JButton();
        tfpassword = new javax.swing.JPasswordField();
        lbeye = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/HDH.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(" Login");
        setPreferredSize(new java.awt.Dimension(800, 550));

        jPanel3.setBackground(new java.awt.Color(87, 165, 104));
        jPanel3.setPreferredSize(new java.awt.Dimension(430, 550));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/vt.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel5)
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );

        jPanel4.setPreferredSize(new java.awt.Dimension(370, 550));

        jLabel6.setBackground(new java.awt.Color(89, 165, 104));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 51));
        jLabel6.setText("LOGIN");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Custom-Icon-Design-Silky-Line-User-User.24.png"))); // NOI18N
        jLabel3.setText("Username");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Icons8-Ios7-User-Interface-Password.24.png"))); // NOI18N
        jLabel7.setText("Password");

        tfusername.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btdangky.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btdangky.setText("Đăng Ký");
        btdangky.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btdangkyMouseClicked(evt);
            }
        });

        btdangnhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btdangnhap.setText("Đăng nhập");
        btdangnhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btdangnhapMouseClicked(evt);
            }
        });

        tfpassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        lbeye.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbeye.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/eyeclosed.png"))); // NOI18N
        lbeye.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbeyeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfusername, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                            .addComponent(tfpassword))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbeye, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btdangky, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btdangnhap, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel6)
                .addGap(39, 39, 39)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfusername, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbeye, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(btdangnhap, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btdangky, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btdangnhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btdangnhapMouseClicked
        String username = tfusername.getText();
        String password = tfpassword.getText();
        boolean check = false;
        try {
            Account_md account = new Account_md();
            ResultSet rs = account.GetData();
            while(rs.next()){
                if(username.equals(rs.getString("UserName")) && password.equals(rs.getString("Pass"))){
                    if(rs.getString("VaiTro").equals("admin")){
                        JOptionPane.showMessageDialog(this, "Đăng nhập thành công!");
                        Admin admin = new Admin();
                        admin.setVisible(true);
                        this.setVisible(false);
                        check = true;
                        break;
                    }
                    else if(rs.getString("VaiTro").equals("employee")){
                        JOptionPane.showMessageDialog(this, "Đăng nhập thành công!");
                        Employee employee = new Employee();
                        employee.setVisible(true);
                        this.setVisible(false);
                        check = true;
                        break;
                    }
                }
            }
//            tfusername.setText("");
//            tfpassword.setText("");
            if(check == false){
                JOptionPane.showMessageDialog(this, "Tài khoản hoặc mật khẩu không đúng");
            }
            account.Close();
        } catch (ClassNotFoundException ex) {
            System.out.println("Class Not Found!");
        } catch (SQLException ex) {
            System.out.println("Execute failure!");
        }
    }//GEN-LAST:event_btdangnhapMouseClicked

    private void btdangkyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btdangkyMouseClicked
        new DangKy().setVisible(true);
        this.setVisible(false);
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
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btdangky;
    private javax.swing.JButton btdangnhap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lbeye;
    private javax.swing.JPasswordField tfpassword;
    private javax.swing.JTextField tfusername;
    // End of variables declaration//GEN-END:variables
}
