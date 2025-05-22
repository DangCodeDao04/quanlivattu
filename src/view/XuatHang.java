/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.XuatHang_md;
import model.KhachHang_md;
import model.Product_md;
import model.XuatHang_md;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.table.JTableHeader;
import model.KhachHang_md;
import model.Product_md;
import model.XuatHang_md;
import model.XuatHoaDonPDF;
import javax.swing.JButton;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class XuatHang extends javax.swing.JInternalFrame {

    private DefaultTableModel modelXuatHang;

    public XuatHang() throws SQLException, ClassNotFoundException {
        this.setBorder(null);  // Ẩn viền
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        initComponents();
        JTableHeader header = tbvattutrongkho.getTableHeader();
        header.setFont(new Font("SansSerif", Font.BOLD, 14)); 
        JTableHeader header2 = tbvattuxuatkho.getTableHeader();
        header2.setFont(new Font("SansSerif", Font.BOLD, 14)); 
        init();
        init_khachhang();
        String[] columnXuatHang = {"STT", "Mã vật tư", "Tên vật tư", "Số lượng", "Đơn giá"};
        modelXuatHang = new DefaultTableModel(columnXuatHang, 0);
        tbvattuxuatkho.setModel(modelXuatHang); //liên kết table và model trong một lần và không cần gọi liên kết lại
        //dữ liệu trong model vẫn còn sau khi thoát khỏi các hàm
//        placeholder();
        tfmaphieuxuat.setEnabled(true);
        tfmaphieuxuat.setEditable(true);
    }
    
    public void init_khachhang() throws SQLException, ClassNotFoundException{
        KhachHang_md khachhang = new KhachHang_md();
        ResultSet rs = khachhang.GetData();
        int i = 0;
        while(rs.next()){
            cbbkhachhang.addItem(rs.getString("MaKH"));
            i++;
        }
        khachhang.Close();
    }
    
    public void init() throws SQLException, ClassNotFoundException{
        Product_md product = new Product_md();
        ResultSet rs = product.GetData();
        ResetTable();
        int i = 0;
        while(rs.next()){
            tbvattutrongkho.setValueAt(rs.getString("MaVatTu"), i, 0);
            tbvattutrongkho.setValueAt(rs.getString("TenVatTu"), i, 1);
            tbvattutrongkho.setValueAt(rs.getString("SoLuong"), i, 2);
            DecimalFormat formatter = new DecimalFormat("#,###");
            String tien = formatter.format(rs.getFloat("GiaXuat"));
            tbvattutrongkho.setValueAt(tien+" đ", i, 3);
            i++;
        }
        product.Close();
    }
    public void ResetTable(){
        DefaultTableModel model = (DefaultTableModel) tbvattutrongkho.getModel();
        model.setRowCount(0);
        model.setRowCount(30);
    }
    
    public void capNhatSTT(DefaultTableModel model) {
        for (int i = 0; i < model.getRowCount(); i++) {
            model.setValueAt(i + 1, i, 0);  // Cột 0 là cột STT
        }
    }
    
    public int tinhTongTien(DefaultTableModel model) {
        int tong = 0;

        for (int i = 0; i < model.getRowCount(); i++) {
            String donGiaStr = model.getValueAt(i, 4).toString(); // Giả sử cột 4 là đơn giá
            String DongiaStr = donGiaStr.replace(" đ", "").replace(",", "").trim();
            
            String soLuongStr = model.getValueAt(i, 3).toString(); // Giả sử cột 3 là số lượng

            int donGia = (int) Double.parseDouble(DongiaStr);
            int soLuong = Integer.parseInt(soLuongStr);

            tong += soLuong * donGia;
        }

        return tong;
    }
    
    public boolean check_id(String ID){
        boolean check = false;
        try {         
            XuatHang_md xuathang = new XuatHang_md();
            ResultSet rs = xuathang.GetData();
            while (rs.next()) {
                if (rs.getString("MaPX").equals(ID) == true) {
                    check = true;
                }
            }
            xuathang.Close();       
        } catch (SQLException ex) {
            System.out.println("error");
        } catch (ClassNotFoundException ex) {
            System.out.println("error");
        }
        return check;
    }
    
    public String dinh_dang_ngay(String ngay){
        String formattedDate = "";
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        inputFormat.setLenient(false);    // Không chấp nhận ngày sai
        try {      
        Date date = inputFormat.parse(ngay);  // chuyển từ String sang Date

        SimpleDateFormat sqlFormat = new SimpleDateFormat("yyyy-MM-dd");
        formattedDate = sqlFormat.format(date);  // chuyển lại thành String theo định dạng của SQL
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ngày không tồn tại hoặc ngày sai định dạng dd/MM/yyyy!");
//            e.printStackTrace();
        }
        return formattedDate;
    }
    
    public void placeholder(){
        tfngaytao.setForeground(Color.GRAY);

        // Thêm sự kiện focus
        tfngaytao.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                if (tfngaytao.getText().equals("Nhập ngày (dd/MM/yyyy)...")) {
                    tfngaytao.setText("");
                    tfngaytao.setForeground(Color.BLACK);
                }
            }

            public void focusLost(FocusEvent e) {
                if (tfngaytao.getText().isEmpty()) {
                    tfngaytao.setForeground(Color.GRAY);
                    tfngaytao.setText("Nhập ngày (dd/MM/yyyy)...");
                }
            }
        });
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbvattutrongkho = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        tfsoluong = new javax.swing.JTextField();
        btthem = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        tftimkiem = new javax.swing.JTextField();
        btlammoi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbbkhachhang = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbvattuxuatkho = new javax.swing.JTable();
        btxuathang = new javax.swing.JButton();
        lbtongtien = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btsuasoluong = new javax.swing.JButton();
        btxoasanpham = new javax.swing.JButton();
        tfmaphieuxuat = new javax.swing.JTextField();
        tfngaytao = new javax.swing.JTextField();

        setBorder(null);
        setMaximumSize(new java.awt.Dimension(1110, 650));
        setMinimumSize(new java.awt.Dimension(1110, 650));
        setPreferredSize(new java.awt.Dimension(1110, 650));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1110, 650));
        jPanel1.setMinimumSize(new java.awt.Dimension(1110, 650));
        jPanel1.setPreferredSize(new java.awt.Dimension(1110, 650));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tbvattutrongkho.setFont(tbvattutrongkho.getFont().deriveFont((float)14));
        tbvattutrongkho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã vật tư", "Tên vật tư", "Số lượng", "Đơn giá"
            }
        ));
        tbvattutrongkho.setGridColor(new java.awt.Color(204, 204, 204));
        jScrollPane2.setViewportView(tbvattutrongkho);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Số lượng");

        tfsoluong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfsoluong.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfsoluong.setText("1");

        btthem.setBackground(new java.awt.Color(89, 165, 104));
        btthem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btthem.setForeground(new java.awt.Color(102, 102, 102));
        btthem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_add_25px_5.png"))); // NOI18N
        btthem.setText("Thêm");
        btthem.setBorder(null);
        btthem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btthem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btthemMouseClicked(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        tftimkiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tftimkiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tftimkiemKeyReleased(evt);
            }
        });

        btlammoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btlammoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_reset_25px_1.png"))); // NOI18N
        btlammoi.setText("Làm mới");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tftimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btlammoi)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tftimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btlammoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(tfsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btthem, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(170, 170, 170))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btthem, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 620));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Mã phiếu xuất");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, -1, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Ngày tạo");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 50, -1, 30));

        cbbkhachhang.setEditable(true);
        cbbkhachhang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(cbbkhachhang, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 90, 340, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Khách hàng");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 90, -1, 30));

        tbvattuxuatkho.setFont(tbvattuxuatkho.getFont().deriveFont((float)14));
        tbvattuxuatkho.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã vật tư", "Tên vật tư", "Số lượng", "Đơn giá"
            }
        ));
        tbvattuxuatkho.setGridColor(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(tbvattuxuatkho);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, 550, 330));

        btxuathang.setBackground(new java.awt.Color(90, 168, 106));
        btxuathang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btxuathang.setForeground(new java.awt.Color(102, 102, 102));
        btxuathang.setText("Xuất hàng");
        btxuathang.setBorder(null);
        btxuathang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btxuathang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btxuathangMouseClicked(evt);
            }
        });
        jPanel1.add(btxuathang, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 540, 123, 40));

        lbtongtien.setFont(new java.awt.Font("SF Pro Display", 1, 16)); // NOI18N
        lbtongtien.setForeground(new java.awt.Color(255, 0, 0));
        lbtongtien.setText("0đ");
        jPanel1.add(lbtongtien, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 550, 190, 30));

        jLabel5.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel5.setText("Tổng tiền:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 550, 100, 30));

        btsuasoluong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btsuasoluong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_edit_25px.png"))); // NOI18N
        btsuasoluong.setText("Sửa số lượng");
        btsuasoluong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btsuasoluongMouseClicked(evt);
            }
        });
        jPanel1.add(btsuasoluong, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 490, -1, 40));

        btxoasanpham.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btxoasanpham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_delete_25px_1.png"))); // NOI18N
        btxoasanpham.setText("Xoá sản phẩm");
        btxoasanpham.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btxoasanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btxoasanphamMouseClicked(evt);
            }
        });
        jPanel1.add(btxoasanpham, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 490, 160, 40));

        tfmaphieuxuat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(tfmaphieuxuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 340, 30));

        tfngaytao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(tfngaytao, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 50, 340, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tftimkiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tftimkiemKeyReleased
        String timkiem = tftimkiem.getText();
        try {
            XuatHang_md xuathang = new XuatHang_md();
            ResultSet rs = xuathang.Search(timkiem);
            ResetTable();
            int i = 0;
            while(rs.next()){
                tbvattutrongkho.setValueAt(rs.getString("MaVatTu"), i, 0);
                tbvattutrongkho.setValueAt(rs.getString("TenVatTu"), i, 1);
                tbvattutrongkho.setValueAt(rs.getString("SoLuong"), i, 2);
                DecimalFormat formatter = new DecimalFormat("#,###");
                String tien = formatter.format(rs.getFloat("GiaXuat"));
                tbvattutrongkho.setValueAt(tien+" đ", i, 3);
                i++;
            }
            xuathang.Close();
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }//GEN-LAST:event_tftimkiemKeyReleased

    private void btthemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btthemMouseClicked
        int selectedRow = tbvattutrongkho.getSelectedRow();
        if (selectedRow >= 0) {
            String mavattu = tbvattutrongkho.getValueAt(selectedRow, 0).toString();
            String tenvattu = tbvattutrongkho.getValueAt(selectedRow, 1).toString();
            String dongia = tbvattutrongkho.getValueAt(selectedRow, 3).toString();
            int soluongTon = Integer.parseInt(tbvattutrongkho.getValueAt(selectedRow, 2).toString());

            int soluong;
            try {
                soluong = Integer.parseInt(tfsoluong.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số!");
                return;
            }

            if (soluong <= 0) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng hợp lệ!");
            } else if (soluong > soluongTon) {
                JOptionPane.showMessageDialog(this, "Số lượng tồn không đủ!");
            } else {
                //Kiểm tra xem mã vật tư đã tồn tại trong bảng xuất kho chưa
                boolean daTonTai = false;
                for (int i = 0; i < modelXuatHang.getRowCount(); i++) {
                    String maTrongModel = modelXuatHang.getValueAt(i, 1).toString();
                    if (maTrongModel.equals(mavattu)) {
                        daTonTai = true;
                        break;
                    }
                }
                if (daTonTai) {
                    JOptionPane.showMessageDialog(this, "Vật tư này đã được thêm vào trước đó!");
                } else {
                    modelXuatHang.addRow(new Object[]{
                        modelXuatHang.getRowCount() + 1, mavattu, tenvattu, soluong, dongia
                    });

                    int tongTien = tinhTongTien(modelXuatHang);
                    NumberFormat vnFormat = NumberFormat.getInstance(new Locale("vi", "VN"));
                    String hienThiTien = vnFormat.format(tongTien);
                    lbtongtien.setText(hienThiTien + " đ");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một vật tư!");
        }
    }//GEN-LAST:event_btthemMouseClicked

    private void btxoasanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btxoasanphamMouseClicked
        int selectedRow = tbvattuxuatkho.getSelectedRow();
        if(selectedRow >= 0) {
            modelXuatHang.removeRow(selectedRow);
            capNhatSTT(modelXuatHang);  // Cập nhật lại STT sau khi xoá

            float tongTien = tinhTongTien(modelXuatHang);
            NumberFormat vnFormat = NumberFormat.getInstance(new Locale("vi", "VN"));
            String hienThiTien = vnFormat.format(tongTien);

            lbtongtien.setText(hienThiTien + " đ");
            //                lbtongtien.setText(tongTien + " VND");

        }else{
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để xoá!");
        }

    }//GEN-LAST:event_btxoasanphamMouseClicked

    private void btxuathangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btxuathangMouseClicked
        XuatHang_md xuathang;
        String maphieuxuat = tfmaphieuxuat.getText();
        String makhachhang = cbbkhachhang.getSelectedItem().toString();
     
//        String tienSo = tongTien.replaceAll("[^\\d]", ""); // giữ lại toàn bộ chữ số, bỏ dấu chấm, chữ đ, v.v.
//        float tongtien = Float.parseFloat(tienSo);
        String tongTien = lbtongtien.getText();
        String tienChuoi = tongTien.replaceAll("[^\\d.,]", "");  // giữ lại số, dấu chấm và phẩy
        float tongtien = 0;
        try {
            NumberFormat vnFormat = NumberFormat.getInstance(new Locale("vi", "VN"));
            Number number = vnFormat.parse(tienChuoi);
            tongtien = number.floatValue(); // float để chuẩn bị insert vào DB
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi chuyển tổng tiền về dạng số!", "Lỗi định dạng", JOptionPane.ERROR_MESSAGE);
        }

        String trangthai = "Đã thanh toán";
        String dongia;
        String ngayban = tfngaytao.getText();
        String date; 
            if(maphieuxuat.equals("") || ngayban.equals("")){ 
                JOptionPane.showMessageDialog(this, "Vui lòng nhập vào đầy đủ thông tin!");
            }       
            else{
                if(check_id(maphieuxuat) == true){
                    JOptionPane.showMessageDialog(this, "Mã phiếu xuất đã tồn tại");
                }
                else{
                    date = dinh_dang_ngay(ngayban);
                    if (date.isEmpty()) return;
                        try {
                            xuathang =  new XuatHang_md();
                            xuathang.Insert_PhieuXuat(maphieuxuat, makhachhang, date, tongtien, trangthai);

                            for(int i = 0; i < modelXuatHang.getRowCount(); i++){
                                dongia = modelXuatHang.getValueAt(i, 4).toString();
                                dongia = dongia.replace(" đ", "").trim();
                                String donGia = dongia.replace(",", "");
                                float Dongia = Float.parseFloat(donGia);
                                xuathang.Insert_ChiTietPhieuXuat(maphieuxuat, modelXuatHang.getValueAt(i, 1).toString(),
                                    Integer.parseInt(modelXuatHang.getValueAt(i, 3).toString()), Dongia);
                            }
                            JOptionPane.showMessageDialog(this, "Thêm phiếu xuất thành công!");
                            for(int i = 0; i < modelXuatHang.getRowCount(); i++){
                                xuathang.CapNhatSoLuong(modelXuatHang.getValueAt(i, 1).toString(),
                                        Integer.parseInt(modelXuatHang.getValueAt(i, 3).toString()));
                            }
                            int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn xuất hóa đơn ra file PDF không?", "Xác nhận", 
                            JOptionPane.YES_NO_OPTION);
                            if (confirm == JOptionPane.YES_OPTION){
                                XuatHoaDonPDF xuatpdf = new XuatHoaDonPDF();
                                xuatpdf.XuatHoaDon(maphieuxuat, date, makhachhang, tbvattuxuatkho, tongTien);
                            }             
                            modelXuatHang.setRowCount(0);
                            xuathang.Close();       
                        } catch (SQLException ex) {
                            Logger.getLogger(XuatHang.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(XuatHang.class.getName()).log(Level.SEVERE, null, ex);
                        }
                }
            }    
    }//GEN-LAST:event_btxuathangMouseClicked

    private void btsuasoluongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btsuasoluongMouseClicked
        
    }//GEN-LAST:event_btsuasoluongMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btlammoi;
    private javax.swing.JButton btsuasoluong;
    private javax.swing.JButton btthem;
    private javax.swing.JButton btxoasanpham;
    private javax.swing.JButton btxuathang;
    private javax.swing.JComboBox<String> cbbkhachhang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbtongtien;
    private javax.swing.JTable tbvattutrongkho;
    private javax.swing.JTable tbvattuxuatkho;
    private javax.swing.JTextField tfmaphieuxuat;
    private javax.swing.JTextField tfngaytao;
    private javax.swing.JTextField tfsoluong;
    private javax.swing.JTextField tftimkiem;
    // End of variables declaration//GEN-END:variables

}
