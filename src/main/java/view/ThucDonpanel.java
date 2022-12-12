package view;

import custom.DanhMucCustom;
import custom.MonAnCustom;
import entity.DanhMuc;
import entity.MonAn;
import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.ICommonService;
import service.impl.DanhMucService;
import service.impl.MonAnServiceImpl;
import util.XImage;
import util.Validate;

public class ThucDonpanel extends javax.swing.JPanel {

    MonAnServiceImpl monanservice;
    DanhMucService danhmucservice;
    DefaultTableModel defaultTableModel;
    Validate valid;

    public ThucDonpanel() {
        initComponents();
        monanservice = new MonAnServiceImpl();
        danhmucservice = new DanhMucService();
        valid = new Validate();
        cbxdanhmuc();
        cbxTrangThai();
        Loadtable(monanservice.getAll());
    }

    public void cbxdanhmuc() {
        DefaultComboBoxModel cbx = new DefaultComboBoxModel();
        for (DanhMucCustom x : danhmucservice.findByKey("")) {
            cbx.addElement(x.getTenLoai());
        }
        cbxdanhmuc.setModel(cbx);
    }

    public void cbxTrangThai() {
        DefaultComboBoxModel cbx = new DefaultComboBoxModel();
        cbx.addElement("Đang Bán");
        cbx.addElement("Ngưng Bán");
        cbxtrangthai.setModel(cbx);
    }

    public MonAnCustom getdata() {
        MonAnCustom monAn = new MonAnCustom();
        
        List<MonAn> list = monanservice.getAll();
         int so = list.size();
        int so1 = so + 1;
        String AUTOMAHD = "Mon".concat(String.valueOf(so1));
        monAn.setMaMon(AUTOMAHD);
      //  String maMon = txtmamon.getText().trim();
        //monAn.setMaMon(maMon);

        String tenMon = txttenmon.getText().trim();
        monAn.setTenMon(tenMon);

        String donViTinh = txtdonvitinh.getText().trim();
        monAn.setDonViTinh(donViTinh);
        
        String hinhAnh = lbl_hinhanh.getText().trim();
        monAn.setHinhAnh(hinhAnh);

        BigDecimal donGia = new BigDecimal(txtdongia.getText().trim());
        monAn.setDonGia(donGia);

        String ghiChu = txtghichu.getText().trim();
        monAn.setGhiChu(ghiChu);

        int trangThai = cbxtrangthai.getSelectedIndex();
        monAn.setTrangThai(trangThai);

        int idDanhMuc = cbxdanhmuc.getSelectedIndex();
        monAn.setIdDanhMuc(idDanhMuc + 1);

        //JOptionPane.showMessageDialog(this, idDanhMuc);
        return monAn;

    }

    public void getImg() {
        JFileChooser _filechooser = new JFileChooser("C:\\Test\\QLNhaHang\\image\\iconApp");
        if (_filechooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = _filechooser.getSelectedFile();
            XImage.save(file);
            ImageIcon icon = XImage.read(file.getName());
//            lbl_hinhanh.setIcon(icon);
//            lbl_hinhanh.setText(file.getName());
//            lbl_hinhanh.setToolTipText(file.getName());
           
            lbl_hinhanh.setIcon(icon);
            lbl_hinhanh.setText(file.getName());
            lbl_hinhanh.setToolTipText(file.getName());
        }
    }

    public void Loadtable(List<MonAn> lstthucdoncus) {
        defaultTableModel = new DefaultTableModel();
        defaultTableModel = (DefaultTableModel) tblthucdon.getModel();
        defaultTableModel.setRowCount(0);
        for (MonAn x : lstthucdoncus) {
            defaultTableModel.addRow(new Object[]{x.getId(), x.getMaMon(),
                x.getTenMon(), x.getDonViTinh(), x.getDonGia(),
                x.getTrangThai() == 0 ? "Đang Bán"
                : "Ngưng Bán", x.getGhiChu(), x.getDanhMuc().getTenLoai(),
                x.getHinhAnh()});
        }
    }
    public void LoadtableMon() {
        List<MonAn> lstthucdoncus = monanservice.getAll();
        defaultTableModel = new DefaultTableModel();
        defaultTableModel = (DefaultTableModel) tblthucdon.getModel();
        defaultTableModel.setRowCount(0);
        for (MonAn x : lstthucdoncus) {
            defaultTableModel.addRow(new Object[]{x.getId(), x.getMaMon(),
                x.getTenMon(), x.getDonViTinh(), x.getDonGia(),
                x.getTrangThai() == 0 ? "Đang Bán"
                : "Ngưng Bán", x.getGhiChu(), x.getDanhMuc().getTenLoai(),
                x.getHinhAnh()});
        }
    }

    public void fillData(int index) {
        List<MonAn> lists = monanservice.getAll();
        MonAn monAn = lists.get(index);

        txtmamon.setText(monAn.getMaMon());
        txttenmon.setText(monAn.getTenMon());
        txtdonvitinh.setText(monAn.getDonViTinh());
        txtdongia.setText(String.valueOf(monAn.getDonGia()));
        txtghichu.setText(txtghichu.getText());
        cbxdanhmuc.setSelectedIndex(monAn.getDanhMuc().getId() - 1);
        cbxtrangthai.setSelectedIndex(monAn.getTrangThai());
         lbl_hinhanh.setIcon(XImage.read(monAn.getHinhAnh()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtmamon = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txttenmon = new javax.swing.JTextField();
        cbxdanhmuc = new javax.swing.JComboBox<>();
        txtdonvitinh = new javax.swing.JTextField();
        cbxtrangthai = new javax.swing.JComboBox<>();
        txtghichu = new javax.swing.JTextField();
        btnthem = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtdongia = new javax.swing.JTextField();
        btnchonanh = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lbl_hinhanh = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnDanhMuc = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblthucdon = new javax.swing.JTable();
        txtTimKiem = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1234, 605));

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setForeground(new java.awt.Color(102, 153, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1234, 605));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin món ăn"));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Mã Món:");

        txtmamon.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Tên Món:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Danh mục:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Đơn vị tính:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Trạng Thái:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Ghi chú:");

        cbxdanhmuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtdonvitinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdonvitinhActionPerformed(evt);
            }
        });

        cbxtrangthai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnthem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnthem.setIcon(new javax.swing.ImageIcon("C:\\Test\\QLNhaHang\\src\\main\\java\\image\\plus.png")); // NOI18N
        btnthem.setText("Thêm");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        btnsua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnsua.setIcon(new javax.swing.ImageIcon("C:\\Test\\QLNhaHang\\src\\main\\java\\image\\edit.png")); // NOI18N
        btnsua.setText("Sửa");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Đơn giá:");

        btnchonanh.setIcon(new javax.swing.ImageIcon("C:\\Test\\QLNhaHang\\src\\main\\java\\image\\Tim kiem.png")); // NOI18N
        btnchonanh.setText("Chọn ảnh");
        btnchonanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchonanhActionPerformed(evt);
            }
        });

        jPanel4.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2)))
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtdonvitinh)
                            .addComponent(txttenmon)
                            .addComponent(txtmamon)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cbxdanhmuc, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 24, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtdongia)
                                    .addComponent(cbxtrangthai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtghichu)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(btnchonanh)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnthem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnsua)))
                        .addGap(6, 6, 6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(lbl_hinhanh, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtmamon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txttenmon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxdanhmuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdonvitinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbxtrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdongia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtghichu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(lbl_hinhanh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnchonanh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnthem)
                    .addComponent(btnsua))
                .addGap(14, 14, 14))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("QL Thực Đơn");

        btnDanhMuc.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDanhMuc.setIcon(new javax.swing.ImageIcon("C:\\Test\\QLNhaHang\\src\\main\\java\\image\\menu.png")); // NOI18N
        btnDanhMuc.setText("Danh mục");
        btnDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDanhMucActionPerformed(evt);
            }
        });

        tblthucdon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Mã món", "Tên món", "Đơn vị tính", "đơn giá", "trạng thái", "ghi chú", "danh mục", "hình ảnh"
            }
        ));
        tblthucdon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblthucdonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblthucdon);

        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Tìm kiếm :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnDanhMuc)
                        .addGap(267, 267, 267)
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnDanhMuc)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDanhMucActionPerformed
        new DanhMucJdialog(null, true).setVisible(true);
    }//GEN-LAST:event_btnDanhMucActionPerformed

    private void btnchonanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnchonanhActionPerformed
        getImg();
    }//GEN-LAST:event_btnchonanhActionPerformed
    public void clear(){
        txtmamon.setText("");
        txttenmon.setText("");
        txtdongia.setText("");
        txtdonvitinh.setText("");
        txtghichu.setText("");
        cbxdanhmuc.setSelectedItem(0);
        cbxtrangthai.setSelectedIndex(0);
        cbxdanhmuc.setSelectedIndex(0);
    }
    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed

//        MonAnCustom monAn = this.getdata();
//        JOptionPane.showMessageDialog(this, monanservice.addOrUpdate(monAn));
//        Loadtable(monanservice.getAll());
        
        if(!txtmamon.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Mã trùng");
            clear();
            return;
        }
        if ( valid.checkNullString(txttenmon.getText())
                || valid.checkNullString(txtdongia.getText()) || valid.checkNullString(txtdonvitinh.getText())) {
            JOptionPane.showMessageDialog(this, "Không để trống");
            return;
        }
//         MonAn ma = monanservice.getIdByMa(txtmamon.getText());
//         if(ma != null){
//             JOptionPane.showMessageDialog(this, "Mã không được trùng");
//            return;
//         }
//        List<MonAn> list = monanservice.getAll();
//        for (int i = 0; i < list.size(); i++) {
//            if(txtmamon.getText().equals(list.get(i).getMaMon())){
//                JOptionPane.showMessageDialog(this, "Mã đã tồn tại. Nhập lại mã!");
//                return;
//            }
//        }
       // if(txtmamon.getText().equals(list.get))
       if(valid.checkso(txtdonvitinh.getText())){
            JOptionPane.showMessageDialog(this, "Đơn vị tính phải là chữ");
            return;
       }
       if(valid.checkso(txttenmon.getText())){
            JOptionPane.showMessageDialog(this, "tên món phải là chữ");
            return;
       }
        if (!valid.checksoThuc(txtdongia.getText())) {
            JOptionPane.showMessageDialog(this, "Phải là số");
            return;
        }
        if (valid.chekcKhoangTrang(txtdongia.getText())) {
            JOptionPane.showMessageDialog(this, "Không được chứa khoảng trắng");
            return;
        }
        if (txtdongia.getText().equals("0")) {
            JOptionPane.showMessageDialog(this, "Lớn hơn 0");
            return;
        }
        MonAnCustom monAn = this.getdata();
        JOptionPane.showMessageDialog(this, monanservice.addOrUpdate(monAn));
        //Loadtable(monanservice.getAll());
        LoadtableMon();
    }//GEN-LAST:event_btnthemActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        // TODO add your handling code here:


    if ( valid.checkNullString(txttenmon.getText()) 
                  ||valid.checkNullString(txtdongia.getText())||valid.checkNullString(txtdonvitinh.getText()))
                  {
            JOptionPane.showMessageDialog(this, "Không để trống");
            return;
        }
          
          if (!valid.checksoThuc(txtdongia.getText())) {
             JOptionPane.showMessageDialog(this, "Phải là số");
            return;
        }
          if (valid.chekcKhoangTrang(txtdongia.getText())) {
             JOptionPane.showMessageDialog(this, "Không được chứa khoảng trắng");
            return;
        }
          if (txtdongia.getText().equals("0") ) {
            JOptionPane.showMessageDialog(this, "Lớn hơn 0");
            return;
        }
        int index = tblthucdon.getSelectedRow();
        int id = Integer.parseInt(tblthucdon.getValueAt(index, 0).toString());
        BigDecimal donGia = new BigDecimal(txtdongia.getText().trim());
        DanhMuc dm = danhmucservice.getByTenDM(cbxdanhmuc.getSelectedItem().toString());
        MonAn ma = new MonAn();
        
        ma.setTenMon(txttenmon.getText());
        ma.setDonGia(donGia);
        ma.setTrangThai( cbxtrangthai.getSelectedIndex());
        ma.setDanhMuc(dm);
        ma.setDonViTinh(txtdonvitinh.getText());
        ma.setGhiChu(txtghichu.getText());
        ma.setId(id);
       // MonAnCustom monAn = this.getdata();
        String update = monanservice.UpdateMon(ma);
        JOptionPane.showMessageDialog(this, "Update thanh cong");
       // JOptionPane.showMessageDialog(this, monanservice.addOrUpdate(monAn));
        Loadtable(monanservice.getAll());

    }//GEN-LAST:event_btnsuaActionPerformed

    private void tblthucdonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblthucdonMouseClicked
        // TODO add your handling code here:
        int row = tblthucdon.getSelectedRow();
        fillData(row);
    }//GEN-LAST:event_tblthucdonMouseClicked

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void txtdonvitinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdonvitinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdonvitinhActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        // TODO add your handling code here:
        String search = txtTimKiem.getText().trim();
        List<MonAn> lstthucdoncus = monanservice.TimKiem(search);
        Loadtable(lstthucdoncus);
    }//GEN-LAST:event_txtTimKiemKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDanhMuc;
    private javax.swing.JButton btnchonanh;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.JComboBox<String> cbxdanhmuc;
    private javax.swing.JComboBox<String> cbxtrangthai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_hinhanh;
    private javax.swing.JTable tblthucdon;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtdongia;
    private javax.swing.JTextField txtdonvitinh;
    private javax.swing.JTextField txtghichu;
    private javax.swing.JTextField txtmamon;
    private javax.swing.JTextField txttenmon;
    // End of variables declaration//GEN-END:variables
}
