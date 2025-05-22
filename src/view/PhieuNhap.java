/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;
import java.awt.Font;
import model.PhieuNhap_md;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;
import model.XuatExcel;

/**
 *
 * @author HoangHiep
 */
public class PhieuNhap extends javax.swing.JInternalFrame {
    
    public PhieuNhap() throws SQLException, ClassNotFoundException {
        this.setBorder(null);  // Ẩn viền
        ((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
        initComponents();
        init();
        JTableHeader header = tbphieunhap.getTableHeader();
        header.setFont(new Font("SansSerif", Font.BOLD, 14)); 
    }
    
    public void init() throws SQLException, ClassNotFoundException{
        PhieuNhap_md phieunhap = new PhieuNhap_md();
        ResultSet rs = phieunhap.GetData();
        ResetTable();
        int i = 0;
        while(rs.next()){
            tbphieunhap.setValueAt(rs.getString("MaPN"), i, 0);
            tbphieunhap.setValueAt(rs.getString("MaNCC"), i, 1);
            tbphieunhap.setValueAt(rs.getString("TenNCC"), i, 2);
            tbphieunhap.setValueAt(rs.getString("NgayNhap"), i, 3);
            DecimalFormat formatter = new DecimalFormat("#,###");
            String tien = formatter.format(rs.getFloat("TongTien"));
            tbphieunhap.setValueAt(tien + " đ", i, 4);
            tbphieunhap.setValueAt(rs.getString("TrangThai"), i, 5);         
            i++;
        }
        phieunhap.Close();
    }
    
    public void ResetTable(){
        DefaultTableModel model = (DefaultTableModel) tbphieunhap.getModel();
        model.setRowCount(0);
        model.setRowCount(30);
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
            e.printStackTrace();
        }
        return formattedDate;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btxoa = new javax.swing.JButton();
        btsua = new javax.swing.JButton();
        btxemchitiet = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btxuatexcel = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jComboBoxLuaChon = new javax.swing.JComboBox<>();
        tftimkiem = new javax.swing.JTextField();
        bttimkiem = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfdenngay = new javax.swing.JTextField();
        tftungay = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tftugia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfdengia = new javax.swing.JTextField();
        btlammoi = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbphieunhap = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(1110, 650));
        setMinimumSize(new java.awt.Dimension(1110, 650));
        setPreferredSize(new java.awt.Dimension(1110, 650));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng"));
        jToolBar1.setRollover(true);

        btxoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_delete_40px.png"))); // NOI18N
        btxoa.setText("Xoá");
        btxoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btxoa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btxoa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btxoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btxoaMouseClicked(evt);
            }
        });
        jToolBar1.add(btxoa);

        btsua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_edit_40px.png"))); // NOI18N
        btsua.setText("Sửa");
        btsua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btsua.setFocusable(false);
        btsua.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btsua.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btsua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btsuaMouseClicked(evt);
            }
        });
        jToolBar1.add(btsua);

        btxemchitiet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Fatcow-Farm-Fresh-Application-view-detail.24.png"))); // NOI18N
        btxemchitiet.setText("Xem chi tiết");
        btxemchitiet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btxemchitiet.setFocusable(false);
        btxemchitiet.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btxemchitiet.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btxemchitiet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btxemchitietMouseClicked(evt);
            }
        });
        jToolBar1.add(btxemchitiet);
        jToolBar1.add(jSeparator1);

        btxuatexcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_spreadsheet_file_40px.png"))); // NOI18N
        btxuatexcel.setText("Xuất Excel");
        btxuatexcel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btxuatexcel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btxuatexcel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btxuatexcel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btxuatexcelMouseClicked(evt);
            }
        });
        jToolBar1.add(btxuatexcel);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBoxLuaChon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBoxLuaChon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã phiếu nhập", "Mã nhà cung cấp", "Tên nhà cung cấp" }));
        jPanel3.add(jComboBoxLuaChon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 170, 40));

        tftimkiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tftimkiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tftimkiemKeyReleased(evt);
            }
        });
        jPanel3.add(tftimkiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 370, 40));

        bttimkiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bttimkiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_search_25px.png"))); // NOI18N
        bttimkiem.setText("Tìm kiếm");
        bttimkiem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bttimkiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bttimkiemMouseClicked(evt);
            }
        });
        jPanel3.add(bttimkiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, 140, 40));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Lọc theo ngày"));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Đến");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 40, 20));

        jLabel5.setFont(new java.awt.Font("SF Pro Display", 0, 14)); // NOI18N
        jLabel5.setText("Từ");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 20, 20));

        tfdenngay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel4.add(tfdenngay, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 150, 30));

        tftungay.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel4.add(tftungay, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 150, 30));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Lọc theo giá"));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Từ");

        tftugia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Đến");

        tfdengia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(32, 32, 32)
                .addComponent(tftugia, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(tfdengia, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfdengia)
                    .addComponent(tftugia)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(0, 11, Short.MAX_VALUE)))
                .addContainerGap())
        );

        btlammoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btlammoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_reset_25px_1.png"))); // NOI18N
        btlammoi.setText("Làm mới");
        btlammoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btlammoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btlammoiMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 744, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btlammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(626, 626, 626))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btlammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 190));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        tbphieunhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbphieunhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã phiếu nhập", "Mã nhà cung cấp", "Tên nhà cung cấp", "Ngày tạo", "Tổng tiền", "Trạng thái"
            }
        ));
        tbphieunhap.setGridColor(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(tbphieunhap);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1066, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 1100, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btxoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btxoaMouseClicked
        int n = tbphieunhap.getSelectedRow();
        String maphieunhap = tbphieunhap.getValueAt(n, 0).toString();       
        try {
            int result = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa chứ?", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (result == JOptionPane.YES_OPTION){
                PhieuNhap_md phieunhap = new PhieuNhap_md();
                phieunhap.Delete(maphieunhap);
                phieunhap.Close();
                init();
            }                                   
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btxoaMouseClicked

    private void tftimkiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tftimkiemKeyReleased
        String timkiem = tftimkiem.getText();
        try {
            PhieuNhap_md phieunhap = new PhieuNhap_md();
            ResultSet rs = phieunhap.Search(timkiem);
            ResetTable();
            int i = 0;
            while(rs.next()){
                tbphieunhap.setValueAt(rs.getString("MaPN"), i, 0);
                tbphieunhap.setValueAt(rs.getString("MaNCC"), i, 1);
                tbphieunhap.setValueAt(rs.getString("TenNCC"), i, 2);
                tbphieunhap.setValueAt(rs.getString("NgayNhap"), i, 3);
                DecimalFormat formatter = new DecimalFormat("#,###");
                String tien = formatter.format(rs.getFloat("TongTien"));
                tbphieunhap.setValueAt(tien + " đ", i, 4);
                tbphieunhap.setValueAt(rs.getString("TrangThai"), i, 5);         
                i++;
            }
            phieunhap.Close();
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }//GEN-LAST:event_tftimkiemKeyReleased

    private void btlammoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btlammoiMouseClicked
        tftimkiem.setText("");
        tftugia.setText("");
        tfdengia.setText("");
        tftungay.setText("");
        tfdenngay.setText("");
        try {
            init();
        } catch (SQLException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btlammoiMouseClicked

    private void btxemchitietMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btxemchitietMouseClicked
        int n = tbphieunhap.getSelectedRow();
        if(n == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn 1 dòng trước khi xem chi tiết!");
            return; 
        }
        else{
            String maphieunhap = tbphieunhap.getValueAt(n, 0).toString(); 
            try {
                new PhieuNhapDetail(maphieunhap).setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(PhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btxemchitietMouseClicked

    private void bttimkiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttimkiemMouseClicked
        String tugia = tftugia.getText();
        String dengia = tfdengia.getText();
        String tungay = tftungay.getText();
        String denngay = tfdenngay.getText();
        if(!tugia.isEmpty() && !dengia.isEmpty()){
            float tu = Float.parseFloat(tugia);
            float den = Float.parseFloat(dengia);
            PhieuNhap_md phieunhap;
            try {
                phieunhap = new PhieuNhap_md();
                ResultSet rs = phieunhap.TimKiemTheoGia(tu, den);
                ResetTable();
                int i = 0;
                while(rs.next()){
                    tbphieunhap.setValueAt(rs.getString("MaPN"), i, 0);
                    tbphieunhap.setValueAt(rs.getString("MaNCC"), i, 1);
                    tbphieunhap.setValueAt(rs.getString("TenNCC"), i, 2);
                    tbphieunhap.setValueAt(rs.getString("NgayNhap"), i, 3);
                    DecimalFormat formatter = new DecimalFormat("#,###");
                    String tien = formatter.format(rs.getFloat("TongTien"));
                    tbphieunhap.setValueAt(tien + " đ", i, 4);
                    tbphieunhap.setValueAt(rs.getString("TrangThai"), i, 5);         
                    i++;
                }
                phieunhap.Close();
            } catch (SQLException ex) {
                Logger.getLogger(PhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{  
            try {
                String ngaybatdau = dinh_dang_ngay(tungay);
                String ngayketthuc = dinh_dang_ngay(denngay);
                PhieuNhap_md phieunhap = new PhieuNhap_md();
                ResultSet rs = phieunhap.TimKiemTheoNgay(ngaybatdau, ngayketthuc);
                ResetTable();
                int i = 0;
                while (rs.next()) {
                    tbphieunhap.setValueAt(rs.getString("MaPN"), i, 0);
                    tbphieunhap.setValueAt(rs.getString("MaNCC"), i, 1);
                    tbphieunhap.setValueAt(rs.getString("TenNCC"), i, 2);
                    tbphieunhap.setValueAt(rs.getString("NgayNhap"), i, 3);
                    DecimalFormat formatter = new DecimalFormat("#,###");
                    String tien = formatter.format(rs.getFloat("TongTien"));
                    tbphieunhap.setValueAt(tien + " đ", i, 4);
                    tbphieunhap.setValueAt(rs.getString("TrangThai"), i, 5);         
                    i++;
                }
                phieunhap.Close();
            } catch (SQLException ex) {
                Logger.getLogger(PhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(PhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_bttimkiemMouseClicked

    private void btsuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btsuaMouseClicked
        int n = tbphieunhap.getSelectedRow();
        String maphieunhap = tbphieunhap.getValueAt(n, 0).toString();    
        try {
            new UpdatePhieuNhap(maphieunhap).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(PhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btsuaMouseClicked

    private void btxuatexcelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btxuatexcelMouseClicked
         int result = JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xuất file excel chứ?", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION){
            XuatExcel xuatexcel = new XuatExcel();
            xuatexcel.exportTableToExcel(tbphieunhap);
        }
    }//GEN-LAST:event_btxuatexcelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btlammoi;
    private javax.swing.JButton btsua;
    private javax.swing.JButton bttimkiem;
    private javax.swing.JButton btxemchitiet;
    private javax.swing.JButton btxoa;
    private javax.swing.JButton btxuatexcel;
    private javax.swing.JComboBox<String> jComboBoxLuaChon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tbphieunhap;
    private javax.swing.JTextField tfdengia;
    private javax.swing.JTextField tfdenngay;
    private javax.swing.JTextField tftimkiem;
    private javax.swing.JTextField tftugia;
    private javax.swing.JTextField tftungay;
    // End of variables declaration//GEN-END:variables
}
