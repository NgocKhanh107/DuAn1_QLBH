package view;

import custom.BanCustom;
import custom.KhuVucCustom;
import entity.Ban;
import entity.KhuVuc;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.impl.BanServiceImpl;
import service.impl.KhuVucServiceImpl;
import util.Validate;

public class BanJPanel extends javax.swing.JPanel {
    
    BanServiceImpl banser;
    KhuVucServiceImpl khuvucser;
    List<Ban> listBan;
    List<KhuVucCustom> listKhuVucCustom;
    DefaultTableModel banModel;
    DefaultComboBoxModel modelKhuVuc;
    Validate valid ;
     public static int count = 0;
    
    public BanJPanel() {
        initComponents();
        banser = new BanServiceImpl();
        khuvucser = new KhuVucServiceImpl();
        listBan = banser.getAll();
        listKhuVucCustom = khuvucser.findByKey("");
        valid = new Validate();
        loadTable(listBan);
        loadCbKhuVuc(listKhuVucCustom);
    }

    private void loadTable(List<Ban> list) {
        banModel = new DefaultTableModel();
        banModel.setColumnIdentifiers(new String[]{"ID","Mã bàn", "Số lượng chỗ ngồi", "Trạng thái", "Vị trí"});
        for (Ban o : list) {
            banModel.addRow(new Object[]{o.getId(),o.getMaBan(), o.getSoLuongChoNgoi(),
                o.getTrangThai() == 0 ? "Ban trong" : "Dang phuc vu",
                 o.getIdKhuVuc().getTenKV()});
        }
        tblBan.setModel(banModel);
    }

    private void loadCbKhuVuc(List<KhuVucCustom> list) {
        modelKhuVuc = new DefaultComboBoxModel();
        cbbKhuVuc.setModel(modelKhuVuc);
        for (KhuVucCustom o : list) {
            modelKhuVuc.addElement(o.getTenKV());
        }
    }

    private void mouseClick(int index) {
        Ban ban = listBan.get(index);
        int idKhuVuc = ban.getIdKhuVuc().getId();
        txtMaBan.setText(ban.getMaBan());
        txtSoLuong.setText(String.valueOf(ban.getSoLuongChoNgoi()));
        cbbTrangThai.setSelectedIndex(ban.getTrangThai());
        if (idKhuVuc == 1) {
            cbbKhuVuc.setSelectedIndex(idKhuVuc - 1);
        }
    }

    private BanCustom getData() {
        BanCustom ban = new BanCustom();

        List<Ban> list = banser.getAll();
         int so = list.size();
        int so1 = so + 1;
        String AUTOMAHD = "BA".concat(String.valueOf(so1));
        ban.setMaBan(AUTOMAHD);
        String soLuong = txtSoLuong.getText().trim();
        ban.setSoLuongChoNgoi(Integer.parseInt(soLuong));

        int trangThai = cbbTrangThai.getSelectedIndex();
        ban.setTrangThai(trangThai);

        String khuVuc = (String) cbbKhuVuc.getSelectedItem();
        KhuVuc kv = khuvucser.getByTen(khuVuc);
        
        ban.setKhuVuc(kv.getId());

        return ban;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtSoLuong = new javax.swing.JTextField();
        cbbKhuVuc = new javax.swing.JComboBox<>();
        btnSua = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbbTrangThai = new javax.swing.JComboBox<>();
        txtMaBan = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBan = new javax.swing.JTable();
        txtTimKiem = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setForeground(new java.awt.Color(153, 153, 255));

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1025, 605));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("QL Bàn");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin bàn"));

        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon("C:\\Test\\QLNhaHang\\src\\main\\java\\image\\edit.png")); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon("C:\\Test\\QLNhaHang\\src\\main\\java\\image\\plus.png")); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Khu vực:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Trạng thái");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Số lượng");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Mã Bàn:");

        cbbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Còn hoạt động", "Không còn hoạt động" }));

        txtMaBan.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(35, 35, 35)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                    .addComponent(txtMaBan)))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbbKhuVuc, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(18, 18, 18)
                                    .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(btnThem)
                        .addGap(32, 32, 32)
                        .addComponent(btnSua)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbbKhuVuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua))
                .addContainerGap(214, Short.MAX_VALUE))
        );

        tblBan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Mã bàn", "Số lượng ghế", "Vị trí", "Trạng thái"
            }
        ));
        tblBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBan);

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Tìm kiếm");

        jButton8.setIcon(new javax.swing.ImageIcon("C:\\Test\\QLNhaHang\\src\\main\\java\\image\\previous.png")); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setIcon(new javax.swing.ImageIcon("C:\\Test\\QLNhaHang\\src\\main\\java\\image\\rewind-button.png")); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setIcon(new javax.swing.ImageIcon("C:\\Test\\QLNhaHang\\src\\main\\java\\image\\forward-button.png")); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setIcon(new javax.swing.ImageIcon("C:\\Test\\QLNhaHang\\src\\main\\java\\image\\next.png")); // NOI18N
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 697, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jButton8)
                .addGap(102, 102, 102)
                .addComponent(jButton9)
                .addGap(57, 57, 57)
                .addComponent(jButton10)
                .addGap(82, 82, 82)
                .addComponent(jButton11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton11)
                    .addComponent(jButton10)
                    .addComponent(jButton9)
                    .addComponent(jButton8))
                .addContainerGap(117, Short.MAX_VALUE))
        );

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setText("Khu Vực");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(318, 318, 318)
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(12, 12, 12))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1091, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new KhuVucJDialog(null, true).setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tblBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBanMouseClicked
        // TODO add your handling code here:
        int index = tblBan.getSelectedRow();
        mouseClick(index);
    }//GEN-LAST:event_tblBanMouseClicked
   public void clearForm(){
       txtMaBan.setText("");
       txtSoLuong.setText("");
       
   }
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if(!txtMaBan.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Mã trùng");
            clearForm();
            return;
        }
         if (txtSoLuong.getText().equals("0") ) {
            JOptionPane.showMessageDialog(this, "Lớn hơn 0");
            return;
        }
        if ( valid.checkNullString(txtSoLuong.getText()) )                 
                  {
            JOptionPane.showMessageDialog(this, "Không để trống");
            return;
        }
          
          if (!valid.checksoThuc(txtSoLuong.getText())) {
             JOptionPane.showMessageDialog(this, "Phải là số");
            return;
        }
//    
            BanCustom ban = this.getData();
         JOptionPane.showMessageDialog(this,banser.addOrUpdate(ban));
        listBan = banser.getAll();
        loadTable(listBan);
        
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
       int index = tblBan.getSelectedRow();
       int id = Integer.parseInt(tblBan.getValueAt(index, 0).toString());
       KhuVuc kv = khuvucser.getByTen(cbbKhuVuc.getSelectedItem().toString());
//        listBan = banser.getAll();
//        Ban banIndex = listBan.get(index);
//        BanCustom ban = this.getData();
//        BanCustom ban2 = this.getData();
//        ban.setId(banIndex.getId());
//        ban.setMaBan(banIndex.getMaBan());
//        String result = banser.checkInfor(ban, ban2);
//        if (result.equals("OK")) {
//            if (banser.checkNumber(txtSoLuong.getText()).equals("OK")){
//                ban2.setId(banIndex.getId());
//                JOptionPane.showMessageDialog(this, banser.addOrUpdate(ban2));
//            } else {
//                JOptionPane.showMessageDialog(this, banser.checkNumber(txtSoLuong.getText()));
//            }
//        } else {
//            JOptionPane.showMessageDialog(this, result);
//        }
         if (txtSoLuong.getText().equals("0") ) {
            JOptionPane.showMessageDialog(this, "Lớn hơn 0");
            return;
        }
        if ( valid.checkNullString(txtSoLuong.getText()) )                 
                  {
            JOptionPane.showMessageDialog(this, "Không để trống");
            return;
        }
          
          if (!valid.checksoThuc(txtSoLuong.getText())) {
             JOptionPane.showMessageDialog(this, "Phải là số");
            return;
        }
        Ban b = new Ban();
        b.setSoLuongChoNgoi(Integer.parseInt(txtSoLuong.getText()));
        b.setTrangThai(cbbTrangThai.getSelectedIndex());
        b.setIdKhuVuc(kv);
        b.setId(id);
        String up = banser.Update(b);
        JOptionPane.showMessageDialog(this, "Cập nhật thành công");
        listBan = banser.getAll();
        loadTable(listBan);
    }//GEN-LAST:event_btnSuaActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        try {
            if (count > 0) {
                count--;
                tblBan.setRowSelectionInterval(count, count);
                mouseClick(count);
                if (count == 0) {
                    count = listBan.size();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Danh sach trong");
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        try {
            if (count < listBan.size() - 1) {
                count++;
                tblBan.setRowSelectionInterval(count, count);
                mouseClick(count);
                if (count == listBan.size() - 1) {
                    count = -1;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Danh sach trong");
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        try {
            count = 0;
            tblBan.setRowSelectionInterval(count, count);
            mouseClick(count);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Danh sach trong");
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        count = listBan.size() - 1;
        try {
            tblBan.setRowSelectionInterval(count, count);
            mouseClick(count);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Danh sach trong");
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        // TODO add your handling code here:
        String search = txtTimKiem.getText().trim();
        listBan = banser.findBan(search);
        loadTable(listBan);
    }//GEN-LAST:event_txtTimKiemKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JComboBox<String> cbbKhuVuc;
    private javax.swing.JComboBox<String> cbbTrangThai;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblBan;
    private javax.swing.JTextField txtMaBan;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
