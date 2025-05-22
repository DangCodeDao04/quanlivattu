/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.NhapHang_md;
import model.NhaCungCap_md;
import model.Product_md;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.JTableHeader;
import model.XuatHang_md;

public class NhapHang extends javax.swing.JInternalFrame {

    private DefaultTableModel modelNhapHang;

    public NhapHang() throws SQLException, ClassNotFoundException {
        this.setBorder(null);  // Ẩn viền
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        initComponents();
        JTableHeader header = tbvattutrongkho.getTableHeader();
        header.setFont(new Font("SansSerif", Font.BOLD, 14)); 
        JTableHeader header2 = tbvattunhapkho.getTableHeader();
        header2.setFont(new Font("SansSerif", Font.BOLD, 14)); 
        init();
        init_nhacungcap();
        String[] columnNhapHang = {"STT", "Mã vật tư", "Tên vật tư", "Số lượng", "Đơn giá"};
        modelNhapHang = new DefaultTableModel(columnNhapHang, 0);
        tbvattunhapkho.setModel(modelNhapHang); //liên kết table và model trong một lần và không cần gọi liên kết lại
        //dữ liệu trong model vẫn còn sau khi thoát khỏi các hàm
//        placeholder();
    }
    
    public void init_nhacungcap() throws SQLException, ClassNotFoundException{
        NhaCungCap_md nhacungcap = new NhaCungCap_md();
        ResultSet rs = nhacungcap.GetData();
        int i = 0;
        while(rs.next()){
            cbbnhacungcap.addItem(rs.getString("MaNCC"));
            i++;
        }
        nhacungcap.Close();
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
            tbvattutrongkho.setValueAt(tien + " đ", i, 3);
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
            NhapHang_md nhaphang = new NhapHang_md();
            ResultSet rs = nhaphang.GetData();
            while (rs.next()) {
                if (rs.getString("MaPN").equals(ID) == true) {
                    check = true;
                }
            }
            nhaphang.Close();       
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
    
//    public void placeholder(){
//        tfngaytao.setForeground(Color.GRAY);
//
//        // Thêm sự kiện focus
//        tfngaytao.addFocusListener(new FocusAdapter() {
//            public void focusGained(FocusEvent e) {
//                if (tfngaytao.getText().equals("Nhập ngày (dd/MM/yyyy)...")) {
//                    tfngaytao.setText("");
//                    tfngaytao.setForeground(Color.BLACK);
//                }
//            }
//
//            public void focusLost(FocusEvent e) {
//                if (tfngaytao.getText().isEmpty()) {
//                    tfngaytao.setForeground(Color.GRAY);
//                    tfngaytao.setText("Nhập ngày (dd/MM/yyyy)...");
//                }
//            }
//        });
//    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfmaphieunhap = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbvattunhapkho = new javax.swing.JTable();
        btnhaphang = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lbtongtien = new javax.swing.JLabel();
        btxoasanpham = new javax.swing.JButton();
        btsuasoluong = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cbbnhacungcap = new javax.swing.JComboBox<>();
        tfngaytao = new javax.swing.JTextField();
        bthienthi = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbvattutrongkho = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        tfsoluong = new javax.swing.JTextField();
        btthem = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        tftimkiem = new javax.swing.JTextField();
        btlammoi = new javax.swing.JButton();

        setBorder(null);
        setMaximumSize(new java.awt.Dimension(1110, 650));
        setMinimumSize(new java.awt.Dimension(1110, 650));
        setPreferredSize(new java.awt.Dimension(1110, 650));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Mã phiếu nhập");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Nhà cung cấp");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, 30));

        tfmaphieunhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel2.add(tfmaphieunhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 340, 30));

        tbvattunhapkho.setFont(tbvattunhapkho.getFont().deriveFont((float)14));
        tbvattunhapkho.setModel(new javax.swing.table.DefaultTableModel(
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
        tbvattunhapkho.setGridColor(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(tbvattunhapkho);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 540, 330));

        btnhaphang.setBackground(new java.awt.Color(90, 168, 106));
        btnhaphang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnhaphang.setForeground(new java.awt.Color(102, 102, 102));
        btnhaphang.setText("Nhập hàng");
        btnhaphang.setToolTipText("");
        btnhaphang.setBorder(null);
        btnhaphang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnhaphang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnhaphangMouseClicked(evt);
            }
        });
        jPanel2.add(btnhaphang, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 540, 123, 40));

        jLabel5.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel5.setText("Tổng tiền:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 550, 100, 30));

        lbtongtien.setFont(new java.awt.Font("SF Pro Display", 1, 16)); // NOI18N
        lbtongtien.setForeground(new java.awt.Color(255, 0, 0));
        lbtongtien.setText("0đ");
        jPanel2.add(lbtongtien, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 550, 190, 30));

        btxoasanpham.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btxoasanpham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_delete_25px_1.png"))); // NOI18N
        btxoasanpham.setText("Xoá sản phẩm");
        btxoasanpham.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btxoasanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btxoasanphamMouseClicked(evt);
            }
        });
        jPanel2.add(btxoasanpham, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 490, 160, 40));

        btsuasoluong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btsuasoluong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_edit_25px.png"))); // NOI18N
        btsuasoluong.setText("Sửa số lượng");
        jPanel2.add(btsuasoluong, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 490, -1, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Ngày tạo");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, 30));

        cbbnhacungcap.setEditable(true);
        cbbnhacungcap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel2.add(cbbnhacungcap, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 200, 30));

        tfngaytao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel2.add(tfngaytao, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 340, 30));

        bthienthi.setBackground(new java.awt.Color(91, 165, 106));
        bthienthi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bthienthi.setForeground(new java.awt.Color(255, 255, 255));
        bthienthi.setText("Hiển thị");
        bthienthi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bthienthiMouseClicked(evt);
            }
        });
        jPanel2.add(bthienthi, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 129, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 570, 620));

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
        btlammoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btlammoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btlammoiMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tftimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btlammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btlammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tftimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(tfsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btthem, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(170, 170, 170))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btthem, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 620));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tftimkiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tftimkiemKeyReleased
        String timkiem = tftimkiem.getText();
        String manhacungcap = cbbnhacungcap.getSelectedItem().toString();
        try {
            NhapHang_md nhaphang = new NhapHang_md();
            ResultSet rs = nhaphang.Search(timkiem, manhacungcap);
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
            nhaphang.Close();
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
            int soluong = Integer.parseInt(tfsoluong.getText());
            if(soluong <= 0){
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng hợp lệ!");
            }
            else{
                modelNhapHang.addRow(new Object[]{modelNhapHang.getRowCount() + 1, mavattu, tenvattu, soluong, dongia});
                int tongTien = tinhTongTien(modelNhapHang);
                NumberFormat vnFormat = NumberFormat.getInstance(new Locale("vi", "VN"));
                String hienThiTien = vnFormat.format(tongTien);

                lbtongtien.setText(hienThiTien + " đ");
//                lbtongtien.setText(tongTien + " VND");
            }     
        }
        else
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một vật tư!");
    }//GEN-LAST:event_btthemMouseClicked

    private void btxoasanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btxoasanphamMouseClicked
            int selectedRow = tbvattunhapkho.getSelectedRow();
            if(selectedRow >= 0) {
                modelNhapHang.removeRow(selectedRow);
                capNhatSTT(modelNhapHang);  // Cập nhật lại STT sau khi xoá
                
                int tongTien = tinhTongTien(modelNhapHang);
                NumberFormat vnFormat = NumberFormat.getInstance(new Locale("vi", "VN"));
                String hienThiTien = vnFormat.format(tongTien);

                lbtongtien.setText(hienThiTien + " đ");
//                lbtongtien.setText(tongTien + " VND");
                
            }else{
                JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để xoá!");
            }
        
    }//GEN-LAST:event_btxoasanphamMouseClicked

    private void btnhaphangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhaphangMouseClicked
        NhapHang_md nhaphang;
        String maphieunhap = tfmaphieunhap.getText();
        String manhacungcap = cbbnhacungcap.getSelectedItem().toString();
     
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
        String ngaynhap = tfngaytao.getText();
        String date; 
            if(maphieunhap.equals("") || ngaynhap.equals("")){ 
                    JOptionPane.showMessageDialog(this, "Vui lòng nhập vào đầy đủ thông tin!");
            }
            else{
                if(check_id(maphieunhap) == true){
                    JOptionPane.showMessageDialog(this, "Mã phiếu nhập đã tồn tại");
                }
                else{
                    date = dinh_dang_ngay(ngaynhap);
                    if (date.isEmpty()) return;
                    try {
                        nhaphang =  new NhapHang_md();
                        nhaphang.Insert_PhieuNhap(maphieunhap, manhacungcap, date, tongtien, trangthai);
                     
                        for(int i = 0; i < modelNhapHang.getRowCount(); i++){
                            dongia = modelNhapHang.getValueAt(i, 4).toString();
                            dongia = dongia.replace(" đ", "").trim();
                            String donGia = dongia.replace(",", "");
                            float Dongia = Float.parseFloat(donGia);
                            
                            nhaphang.Insert_ChiTietPhieuNhap(maphieunhap, modelNhapHang.getValueAt(i, 1).toString(),
                                Integer.parseInt(modelNhapHang.getValueAt(i, 3).toString()), Dongia);
                        }
                        JOptionPane.showMessageDialog(this, "Thêm phiếu nhập thành công!");
                        for(int i = 0; i < modelNhapHang.getRowCount(); i++){                          
                            nhaphang.CapNhatSoLuong(modelNhapHang.getValueAt(i, 1).toString(),
                                    Integer.parseInt(modelNhapHang.getValueAt(i, 3).toString()));
                        }
                        modelNhapHang.setRowCount(0);
                        nhaphang.Close();
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(this, "Lỗi truy vấn!");
                    } catch (ClassNotFoundException ex) {
                        JOptionPane.showMessageDialog(this, "Đường dẫn sai!");
                    }
                }
            }           
    }//GEN-LAST:event_btnhaphangMouseClicked

    private void btlammoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btlammoiMouseClicked
        tftimkiem.setText("");
        String manhacungcap = cbbnhacungcap.getSelectedItem().toString();
        try {
            Product_md product = new Product_md();
            ResultSet rs = product.VatTuKho(manhacungcap);
            ResetTable();
            int i = 0;
            while(rs.next()){
                tbvattutrongkho.setValueAt(rs.getString("MaVatTu"), i, 0);
                tbvattutrongkho.setValueAt(rs.getString("TenVatTu"), i, 1);
                tbvattutrongkho.setValueAt(rs.getString("SoLuong"), i, 2);
                DecimalFormat formatter = new DecimalFormat("#,###");
                String tien = formatter.format(rs.getFloat("GiaXuat"));
                tbvattutrongkho.setValueAt(tien + " đ", i, 3);
                i++;
            }
            product.Close();
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btlammoiMouseClicked

    private void bthienthiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bthienthiMouseClicked
        String manhacungcap = cbbnhacungcap.getSelectedItem().toString();
        try {
            Product_md product = new Product_md();
            ResultSet rs = product.VatTuKho(manhacungcap);
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
        } catch (SQLException ex) {
            Logger.getLogger(NhapHang.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NhapHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_bthienthiMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bthienthi;
    private javax.swing.JButton btlammoi;
    private javax.swing.JButton btnhaphang;
    private javax.swing.JButton btsuasoluong;
    private javax.swing.JButton btthem;
    private javax.swing.JButton btxoasanpham;
    private javax.swing.JComboBox<String> cbbnhacungcap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbtongtien;
    private javax.swing.JTable tbvattunhapkho;
    private javax.swing.JTable tbvattutrongkho;
    private javax.swing.JTextField tfmaphieunhap;
    private javax.swing.JTextField tfngaytao;
    private javax.swing.JTextField tfsoluong;
    private javax.swing.JTextField tftimkiem;
    // End of variables declaration//GEN-END:variables

}
