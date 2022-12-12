package view;

import custom.NhanVienCustom;
import entity.NhanVien;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.ICommonService;
import service.impl.NhanVienServiceImpl;
import util.Validate;

public class NhanVienJpanel extends javax.swing.JPanel {

    private DefaultTableModel model;
    private NhanVienServiceImpl service;
    private List<NhanVienCustom> lists; 
    public static int count = 0;
    public Validate valid;
    public NhanVienJpanel() {
        initComponents();
        service = new NhanVienServiceImpl();
        lists = service.findByKey("");
        loadDataToTable(lists);
        valid = new Validate();
    }
    
    private NhanVienCustom getData(){
        NhanVienCustom nhanVien = new NhanVienCustom();
         List<NhanVien> list = service.getAll();
         int so = list.size();
        int so1 = so + 1;
        String AUTOMAHD = "NV".concat(String.valueOf(so1));
        nhanVien.setMaNV(AUTOMAHD);
        
//        String ma = txtMaNV.getText().trim();
//        nhanVien.setMaNV(ma);
       // JOptionPane.showMessageDialog(this, nhanVien.getMaNV());
        String ten = txtTenNV.getText().trim();
        nhanVien.setHoTenNV(ten);
        
        if (radioNam.isSelected()) {
            nhanVien.setGioiTinh(0);
        }else{
            nhanVien.setGioiTinh(1);
        }
        
        String diaChi = txtDiaChi.getText().trim();
        nhanVien.setDiaChi(diaChi);
         
        String thanhPho = txtThanhPho.getText().trim();
        nhanVien.setThanhPho(thanhPho);
        
        String sdt = txtSdt.getText().trim();
        nhanVien.setSdt(sdt);
        
        String email = txtEmail.getText().trim();
        nhanVien.setEmail(email);
        
        
        Date ngaySinh = txtNgSinh.getDate();
        nhanVien.setNgaySinh(ngaySinh);
        
       // String matKhau = txtMatKhau.getText().trim();
       // nhanVien.setMatKhau(matKhau);
        
        if (radioQuanLy.isSelected()) {
            nhanVien.setVaiTro(true);
        }else{
            nhanVien.setVaiTro(false);
        }
        
        int trangThai = cbbTrangThai.getSelectedIndex();
        nhanVien.setTrangThai(trangThai);
        String mk = "123456";
        nhanVien.setMatKhau(mk);
        
         
        return nhanVien;
    }

    private void loadDataToTable(List<NhanVienCustom> lists){
        model = (DefaultTableModel) tblNhanVien.getModel();
        model.setRowCount(0);
        for (NhanVienCustom list : lists) {
            model.addRow(list.toRowData());
        }
    }
//      private void loadTable(){
//          List<NhanVien> lists = service.getAll();
//        model = (DefaultTableModel) tblNhanVien.getModel();
//        model.setRowCount(0);
//        for (NhanVien nv : lists) {
//            model.addRow(new Object[]{
//                nv.getId(),nv.getMaNV(),nv.getMatKhau(),nv.getEmail(),nv.getGioiTinh(),nv.getHoTenNV(),nv.getNgaySinh(),nv.getSdt(),nv.getDiaChi(),nv.getThanhPho(),
//               nv.getTrangThai()
//            });
//        }
//    }
    private void fillData(int index){
        NhanVienCustom nhanVien = lists.get(index);
        
        txtMaNV.setText(nhanVien.getMaNV());
        txtTenNV.setText(nhanVien.getHoTenNV());
        if (nhanVien.getGioiTinh() == 0) {
            radioNam.setSelected(true);
        }else{
            radioNu.setSelected(true);
        }
        txtDiaChi.setText(nhanVien.getDiaChi());
        txtThanhPho.setText(nhanVien.getThanhPho());
        txtSdt.setText(nhanVien.getSdt());
        txtEmail.setText(nhanVien.getEmail());
        txtNgSinh.setDate(nhanVien.getNgaySinh());
       // txtMatKhau.setText(nhanVien.getMatKhau());
        if (nhanVien.isVaiTro() == true) {
            radioQuanLy.setSelected(true);
        }else{
            radioNhanVien.setSelected(true);
        }
        cbbTrangThai.setSelectedItem(nhanVien.TrangThaiToString());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTenNV = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtThanhPho = new javax.swing.JTextField();
        txtSdt = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        txtNgSinh = new com.toedter.calendar.JDateChooser();
        radioNu = new javax.swing.JRadioButton();
        radioNhanVien = new javax.swing.JRadioButton();
        radioNam = new javax.swing.JRadioButton();
        radioQuanLy = new javax.swing.JRadioButton();
        cbbTrangThai = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnLast = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1259, 6050));

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1259, 605));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("QL Nhân Viên");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin nhân viên"));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Mã nhân viên:");

        txtMaNV.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Tên nhân viên:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Thành phố:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Địa chỉ:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Số điện thoại:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Email:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Giới tính:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Ngày sinh:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Vai trò:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Trạng thái:");

        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon("C:\\Test\\QLNhaHang\\src\\main\\java\\image\\plus.png")); // NOI18N
        btnThem.setText("Thêm ");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon("C:\\Test\\QLNhaHang\\src\\main\\java\\image\\edit.png")); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioNu);
        radioNu.setText("Nữ");

        buttonGroup2.add(radioNhanVien);
        radioNhanVien.setSelected(true);
        radioNhanVien.setText("Nhân viên");

        buttonGroup1.add(radioNam);
        radioNam.setSelected(true);
        radioNam.setText("Nam");

        buttonGroup2.add(radioQuanLy);
        radioQuanLy.setText("Quản lý");

        cbbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Full time", "Part time", "Đã nghỉ việc" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtThanhPho, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(radioNam)
                                        .addGap(53, 53, 53)
                                        .addComponent(radioNu)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel11))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(radioNhanVien)
                                            .addGap(18, 18, 18)
                                            .addComponent(radioQuanLy))
                                        .addComponent(txtNgSinh, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(btnThem)
                .addGap(61, 61, 61)
                .addComponent(btnSua)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaNV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(radioNam)
                    .addComponent(radioNu))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtThanhPho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(txtNgSinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(radioNhanVien)
                    .addComponent(radioQuanLy))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(100, 100, 100))
        );

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã nhân viên", "Email", "Giới tính", "Họ tên", "Ngày sinh", "Sdt", "Địa chỉ", "Thành phố", "Trạng thái", "Vai trò"
            }
        ));
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhanVien);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Tìm kiếm:");

        txtTimKiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemCaretUpdate(evt);
            }
        });

        btnLast.setIcon(new javax.swing.ImageIcon("C:\\Test\\QLNhaHang\\src\\main\\java\\image\\previous.png")); // NOI18N
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        btnPrevious.setIcon(new javax.swing.ImageIcon("C:\\Test\\QLNhaHang\\src\\main\\java\\image\\rewind-button.png")); // NOI18N
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreviousActionPerformed(evt);
            }
        });

        btnNext.setIcon(new javax.swing.ImageIcon("C:\\Test\\QLNhaHang\\src\\main\\java\\image\\forward-button.png")); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnFirst.setIcon(new javax.swing.ImageIcon("C:\\Test\\QLNhaHang\\src\\main\\java\\image\\next.png")); // NOI18N
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 873, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addGap(38, 38, 38)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addComponent(btnLast)
                .addGap(18, 18, 18)
                .addComponent(btnPrevious)
                .addGap(34, 34, 34)
                .addComponent(btnNext)
                .addGap(18, 18, 18)
                .addComponent(btnFirst)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLast)
                    .addComponent(btnPrevious)
                    .addComponent(btnNext)
                    .addComponent(btnFirst))
                .addContainerGap(93, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(381, 381, 381)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        // TODO add your handling code here:
        int index = tblNhanVien.getSelectedRow();
        fillData(index);
    }//GEN-LAST:event_tblNhanVienMouseClicked
    public void clear(){
        txtMaNV.setText("");
        txtEmail.setText("");
        txtDiaChi.setText("");
        txtSdt.setText("");
        txtTenNV.setText("");
        txtThanhPho.setText("");
        
    }
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if(!txtMaNV.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "mã trùng");
            clear();
            return;
        }
        if ( valid.checkNullString(txtTenNV.getText())|| valid.checkNullString(txtSdt.getText()) || valid.checkNullString(txtNgSinh.getDateFormatString())
                || valid.checkNullString(txtDiaChi.getText()) || valid.checkNullString(txtEmail.getText())) {
            JOptionPane.showMessageDialog(this, "Không để trống");
            return ;
        }
         if(valid.checkso(txtTenNV.getText())){
            JOptionPane.showMessageDialog(this, "Tên phải là chữ");
            return ;
       }
        String rx =  "0\\d{9}";
        if (!txtSdt.getText().matches(rx)) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ");
            return;
           }
        String checkemail
                = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        if (!txtEmail.getText().matches(checkemail)) {
            JOptionPane.showMessageDialog(this, "Email ko đúng định dạng");
            return;
        }
        NhanVienCustom nhanVien = this.getData();
        NhanVienCustom nv = service.getByEmail(nhanVien.getEmail());
        NhanVienCustom nv1 = service.getNhanVienByPhone(nhanVien.getSdt());
        if(nv != null){
            JOptionPane.showMessageDialog(this, "Email trùng");
            return;
        }
        if(nv1 != null){
            JOptionPane.showMessageDialog(this, "SĐT trùng");
            return;
        }
        String result = service.addOrUpdate(nhanVien);
        
        JOptionPane.showMessageDialog(this, result);
        lists = service.findByKey("");
        loadDataToTable(lists);
    }//GEN-LAST:event_btnThemActionPerformed

    private void txtTimKiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemCaretUpdate
        // TODO add your handling code here:
        String search = txtTimKiem.getText().trim();
        lists = service.findByKey(search);
        loadDataToTable(lists);
    }//GEN-LAST:event_txtTimKiemCaretUpdate

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        if ( valid.checkNullString(txtTenNV.getText())|| valid.checkNullString(txtSdt.getText()) || valid.checkNullString(txtNgSinh.getDateFormatString())
                || valid.checkNullString(txtDiaChi.getText()) || valid.checkNullString(txtEmail.getText())) {
            JOptionPane.showMessageDialog(this, "Không để trống");
            return ;
        }
         if(valid.checkso(txtTenNV.getText())){
            JOptionPane.showMessageDialog(this, "Tên phải là chữ");
            return ;
       }
        String rx =  "0\\d{9}";
        if (!txtSdt.getText().matches(rx)) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ");
            return;
           }
        String checkemail
                = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        if (!txtEmail.getText().matches(checkemail)) {
            JOptionPane.showMessageDialog(this, "Email ko đúng định dạng");
            return;
        }
        
        NhanVienCustom nhanVien = this.getData();
        
        int index = tblNhanVien.getSelectedRow();
        int id = (int) tblNhanVien.getValueAt(index, 0);
        nhanVien.setId(id);
        NhanVien nv = new NhanVien();
        nv.setHoTenNV(txtTenNV.getText());
        if (radioNam.isSelected()) {
            nv.setGioiTinh(0);
        }else{
            nv.setGioiTinh(1);
        }
        nv.setDiaChi(txtDiaChi.getText());
        nv.setThanhPho(txtThanhPho.getText());
        nv.setSdt(txtSdt.getText());
        nv.setEmail(txtEmail.getText());
        nv.setNgaySinh(txtNgSinh.getDate());
         if (radioQuanLy.isSelected()) {
            nv.setVaiTro(true);
        }else{
            nv.setVaiTro(false);
        }
        nv.setTrangThai(cbbTrangThai.getSelectedIndex());
        //nhanVien.setId(id);
        NhanVienCustom nhanVienCheck = service.getNhanVienByEmail(nv.getEmail(), id);
        if (nhanVienCheck != null) {
            JOptionPane.showMessageDialog(this, "Email  trùng");
            return;
        }
        //String up = service.UpdateNhanVien(nv);
        JOptionPane.showMessageDialog(this, "Cập nhật thành công");
        String result = service.addOrUpdate(nhanVien);
        JOptionPane.showMessageDialog(this, result);
        lists = service.findByKey("");
        loadDataToTable(lists);
        //loadTable();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        try {
            count = 0;
            tblNhanVien.setRowSelectionInterval(count, count);
            fillData(count);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Danh sach trong");
        }
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreviousActionPerformed
        // TODO add your handling code here:
        try {
            if (count > 0) {
                count--;
                tblNhanVien.setRowSelectionInterval(count, count);
                fillData(count);
                if (count == 0) {
                    count = lists.size();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Danh sach trong");
        }
    }//GEN-LAST:event_btnPreviousActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        try {
            if (count < lists.size() - 1) {
                count++;
                tblNhanVien.setRowSelectionInterval(count, count);
                fillData(count);
                if (count == lists.size() - 1) {
                    count = -1;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Danh sach trong");
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
        count = lists.size() - 1;
        try {
            tblNhanVien.setRowSelectionInterval(count, count);
            fillData(count);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Danh sach trong");
        }
    }//GEN-LAST:event_btnFirstActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbbTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton radioNam;
    private javax.swing.JRadioButton radioNhanVien;
    private javax.swing.JRadioButton radioNu;
    private javax.swing.JRadioButton radioQuanLy;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaNV;
    private com.toedter.calendar.JDateChooser txtNgSinh;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtThanhPho;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
