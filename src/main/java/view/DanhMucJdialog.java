package view;

import custom.DanhMucCustom;
import entity.DanhMuc;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.ICommonService;
import service.impl.DanhMucService;
import util.Validate;

public class DanhMucJdialog extends javax.swing.JDialog {

    private DanhMucService _DanhMucService;
    private ICommonService<DanhMucCustom> _ICommonService;
    private DanhMucCustom _DanhMucCustom;
    private DefaultTableModel _DefaultTableModel;
    private Validate valid;

    public DanhMucJdialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        _DanhMucService = new DanhMucService();
        _ICommonService = new DanhMucService();
        valid = new Validate();
        loadDataToTable(_DanhMucService.findByKey(""));
    }

    public void loadDataToTable(List<DanhMucCustom> lists) {
        _DefaultTableModel = (DefaultTableModel) tblDanhMuc.getModel();
        _DefaultTableModel.setRowCount(0);
        for (DanhMucCustom x : lists) {
            _DefaultTableModel.addRow(new Object[]{x.getId(), x.getMaLoai(), x.getTenLoai(), x.TrangThaiToString()});
        }
    }
     public void loadDataTable() {
          List<DanhMuc> list = _DanhMucService.getLists();
        _DefaultTableModel = (DefaultTableModel) tblDanhMuc.getModel();
        _DefaultTableModel.setRowCount(0);
        for (DanhMuc x : list) {
            _DefaultTableModel.addRow(new Object[]{x.getId(), x.getMaLoai(), x.getTenLoai(), x.getTrangThai()==0 ?"Còn kinh doanh":"Không còn kinh doanh"});
        }
    }
    private DanhMucCustom getData() {
        DanhMucCustom danhMuc = new DanhMucCustom();

        //String ma = txtMaLoai.getText();
        List<DanhMuc> list = _DanhMucService.getLists();
         int so = list.size();
        int so1 = so + 1;
        String AUTOMAHD = "Loai".concat(String.valueOf(so1));
        danhMuc.setMaLoai(AUTOMAHD);

        String ten = txtTenLoai.getText();
        danhMuc.setTenLoai(ten);

        int trangThai = cbbTrangThai.getSelectedIndex();
        danhMuc.setTrangThai(trangThai);

        return danhMuc;
    }

    private void clearData() {
        //lblId.setText("");
        txtMaLoai.setText("");
        txtTenLoai.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhMuc = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMaLoai = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTenLoai = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txt_timkiem = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbbTrangThai = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 255));

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        tblDanhMuc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Mã danh mục", "Tên danh mục", "Trạng thái"
            }
        ));
        tblDanhMuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhMucMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDanhMuc);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Danh Mục Thực đơn");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin"));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Mã Danh Mục:");

        txtMaLoai.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Tên Danh Mục:");

        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon("C:\\Test\\QLNhaHang\\src\\main\\java\\image\\plus.png")); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon("C:\\Test\\QLNhaHang\\src\\main\\java\\image\\edit.png")); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Tìm Kiếm:");

        txt_timkiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txt_timkiemCaretUpdate(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Trạng thái :");

        cbbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Còn kinh doanh", "Không còn kinh doanh" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btnThem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSua)
                        .addGap(51, 51, 51))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaLoai, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTenLoai)
                            .addComponent(cbbTrangThai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(314, 314, 314))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void clear(){
        txtMaLoai.setText("");
        txtTenLoai.setText("");
    }
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

//      
        if(!txtMaLoai.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "mã trùng");
            clear();
            return;
        }
        if ( valid.checkNullString(txtTenLoai.getText())   ) {
            JOptionPane.showMessageDialog(this, "Không để trống");
            
            return;
        }
//        if(valid.checkKyTuCoDau(txtTenLoai.getText())){
//        JOptionPane.showMessageDialog(this, "nhập phải có dấu");
//            return;
//        }
//        List<DanhMuc> list = _DanhMucService.getLists();
//        for (int i = 0; i < list.size(); i++) {
//            if(txtMaLoai.getText().equals(list.get(i).getMaLoai())){
//                JOptionPane.showMessageDialog(this, "Mã đã tồn tại. Nhập lại mã!");
//                return;
//            }
//        }
         if(valid.checkso(txtMaLoai.getText())){
            JOptionPane.showMessageDialog(this, "Đơn vị tính phải là chữ");
            return;
       }
       if(valid.checkso(txtTenLoai.getText())){
            JOptionPane.showMessageDialog(this, "tên món phải là chữ");
            return;
       }
        DanhMucCustom spMoi = getData();
        JOptionPane.showMessageDialog(this, _DanhMucService.addOrUpdate(spMoi));
        List<DanhMucCustom> ds = _DanhMucService.findByKey("");
        loadDataToTable(ds);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed

       
        
        if (valid.checkNullString(txtMaLoai.getText()) || valid.checkNullString(txtTenLoai.getText())   ) {
            JOptionPane.showMessageDialog(this, "Không để trống");
            return;
        }
//       List<DanhMuc> list = _DanhMucService.getLists();
//        for (int i = 0; i < list.size(); i++) {
//            if(txtMaLoai.getText().equals(list.get(i).getMaLoai())){
//                JOptionPane.showMessageDialog(this, "Mã đã tồn tại. Nhập lại mã!");
//                return;
//            }
//        } 
        int index = tblDanhMuc.getSelectedRow();
        DanhMucCustom spMoi = getData();
        int id = Integer.parseInt(tblDanhMuc.getValueAt(index, 0).toString());
        List<DanhMucCustom> ds = _DanhMucService.findByKey("");
        List<DanhMuc> list = _DanhMucService.getLists();
        spMoi.setId(index);
        DanhMuc sp = new DanhMuc();
        sp.setId(id);
      //  sp.setMaLoai(txtMaLoai.getText());
        sp.setTenLoai(txtTenLoai.getText());
        sp.setTrangThai(cbbTrangThai.getSelectedIndex());
        String upString = _DanhMucService.UpdateBan(sp);
        
        
        JOptionPane.showMessageDialog(this, "Update thành công");
        loadDataTable();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void tblDanhMucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhMucMouseClicked
        int row = tblDanhMuc.getSelectedRow();
        txtMaLoai.setText(tblDanhMuc.getValueAt(row, 1).toString());
        txtTenLoai.setText(tblDanhMuc.getValueAt(row, 2).toString());
    }//GEN-LAST:event_tblDanhMucMouseClicked

    private void txt_timkiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txt_timkiemCaretUpdate
        loadDataToTable(_DanhMucService.findByKey(txt_timkiem.getText()));
    }//GEN-LAST:event_txt_timkiemCaretUpdate

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DanhMucJdialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DanhMucJdialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DanhMucJdialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DanhMucJdialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DanhMucJdialog dialog = new DanhMucJdialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JComboBox<String> cbbTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDanhMuc;
    private javax.swing.JTextField txtMaLoai;
    private javax.swing.JTextField txtTenLoai;
    private javax.swing.JTextField txt_timkiem;
    // End of variables declaration//GEN-END:variables
}
