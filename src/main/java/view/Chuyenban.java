/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;


import custom.DHCTBanHangCustom;
import custom.DonHangCustom;
import entity.Ban;
import entity.DonHang;
import entity.DonHangChiTiet;
import entity.HoaDon;
import entity.KhuVuc;
import entity.MonAn;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.impl.BanServiceImpl;
import service.impl.DonHangChiTietServiceImpl;
import service.impl.DonHangServiceImpl;
import service.impl.MonAnServiceImpl;


/**
 *
 * @author ngocKhanh
 */
public class Chuyenban extends javax.swing.JDialog {

//    HoaDonService hddao = new HoaDonService();
//    BanService bandao = new BanService();
    DonHangServiceImpl dhdao = new DonHangServiceImpl();
    DonHangChiTietServiceImpl dhctdao = new DonHangChiTietServiceImpl();
    BanServiceImpl bandao = new BanServiceImpl();
    MonAnServiceImpl tddao = new MonAnServiceImpl();
    private DefaultTableModel modelDHCT;
    private DefaultTableModel model;
    HoaDon hd;
    DonHang arrhd;
    String MaBan, MaDH, TenBan;

    public Chuyenban(java.awt.Frame parent, boolean modal, String maBan, String maDH) {
        super(parent, modal);
        initComponents();
        MaBan = maBan;

        MaDH = maDH;
        txtbanchon.setText(maBan);
        // hd = hddao.getHD(maDH);
        txtmahd.setText(maDH);
        loadCBBMaBan();
        loadtblChiTietban();
    }

    void loadCBBMaBan() {
        List<Ban> listBan = bandao.getAll();
        List<DonHang> listDH = dhdao.getLists();

        for (Ban b : listBan) {
            cboban.addItem(b.getMaBan());
        }
//         loadDHCT();
        // loadtblChiTietban();
    }

    void loadDHCT() {
        String key = (String) cboban.getSelectedItem();
        List<DonHang> dh = dhdao.getListDHMa(key);
        for (DonHang donhang : dh) {
            //System.out.println("mã hd: "+nv.getMahd());
            txtmahdbanchuyen.setText(donhang.getMaDH());
        }
        if (dh.size() == 0) {
            txtmahdbanchuyen.setText("TRỐNG");
        }
        try {
            arrhd = dhdao.getDHByMaDH(txtmahdbanchuyen.getText());
            List<DHCTBanHangCustom> list = dhctdao.getDSOder(arrhd.getId());
            modelDHCT = (DefaultTableModel) tblchitietban2.getModel();
            modelDHCT.setRowCount(0);
            int stt = 1;
            for (DHCTBanHangCustom dhct : list) {
                modelDHCT.addRow(new Object[]{
                    stt++, dhct.getId(), dhct.getTenMon(), dhct.getSoLuong(), dhct.getDonGia()
                });
            }

        } catch (Exception e) {

        }

       // double Tongtien = 0;

//        try {
//            DonHang hd = dhdao.getDHbyMa(txtmahd.getText());
//            List<DHCTBanHangCustom> listhd = dhctdao.getDSOder(hd.getId());
//
//            model = (DefaultTableModel) tblchitietban.getModel();
//            model.setRowCount(0);
//            int stt = 1;
//            for (DHCTBanHangCustom dhct : listhd) {
//                model.addRow(new Object[]{
//                    stt++, dhct.getId(), dhct.getTenMon(), dhct.getSoLuong(), dhct.getDonGia()
//                });
//            }
//
//            String tt = String.valueOf(Tongtien);
//            String tt2 = tt.replace(".0", "");
//
//        } catch (Exception e) {
//
//        }

    }

    void loadtblChiTietban() {
        double Tongtien = 0;
        DonHang hd = dhdao.getDHbyMa(MaBan);
        List<DHCTBanHangCustom> listhd = dhctdao.getDSOder(hd.getId());
        model = (DefaultTableModel) tblchitietban.getModel();
        model.setRowCount(0);
        int stt = 1;
        for (DHCTBanHangCustom dhct : listhd) {
            model.addRow(new Object[]{
                stt++, dhct.getId(), dhct.getTenMon(), dhct.getSoLuong(), dhct.getDonGia()
            });
        }

        String tt = String.valueOf(Tongtien);
        String tt2 = tt.replace(".0", "");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtbanchon = new javax.swing.JTextField();
        txtmahd = new javax.swing.JTextField();
        cboban = new javax.swing.JComboBox<>();
        txtmahdbanchuyen = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblchitietban2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblchitietban = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txttk3 = new javax.swing.JTextField();
        txtsoluong = new javax.swing.JSpinner();
        btnTaoDH = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Bàn Đang Chọn");

        jLabel2.setText("Mã ĐH");

        jLabel3.setText("Chuyển-Ghép");

        jLabel4.setText("Mã ĐH bàn chuyển");

        cboban.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbobanItemStateChanged(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Chuyển- Ghép"));

        tblchitietban2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "IDDHCT", "Tên Món", "SL", "Giá"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblchitietban2);

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Test\\QLNhaHang\\src\\main\\java\\image\\forward-button.png")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tblchitietban.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "IDDHCT", "Ten Mon", "SL", "Gia"
            }
        ));
        tblchitietban.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblchitietbanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblchitietban);

        jLabel5.setText("Món");

        jLabel6.setText("Số Lượng");

        btnTaoDH.setIcon(new javax.swing.ImageIcon("C:\\Test\\QLNhaHang\\src\\main\\java\\image\\add.png")); // NOI18N
        btnTaoDH.setText("Tao DH");
        btnTaoDH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoDHActionPerformed(evt);
            }
        });

        btnThoat.setIcon(new javax.swing.ImageIcon("C:\\Test\\QLNhaHang\\src\\main\\java\\image\\Dang xuat.png")); // NOI18N
        btnThoat.setText("Hoàn Tất");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnTaoDH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnThoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(18, 18, 18)
                            .addComponent(txtsoluong))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(45, 45, 45)
                            .addComponent(txttk3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnTaoDH, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnThoat)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5))
                    .addComponent(txttk3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtmahd, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtbanchon, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtmahdbanchuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboban, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(txtbanchon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(txtmahd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmahdbanchuyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbobanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbobanItemStateChanged
        // TODO add your handling code here:
        String key = (String) cboban.getSelectedItem();
        List<DonHang> dh = dhdao.getListDHMa(key);
        for (DonHang donhang : dh) {
            //System.out.println("mã hd: "+nv.getMahd());
            txtmahdbanchuyen.setText(donhang.getMaDH());
        }
        if (dh.size() == 0) {
            txtmahdbanchuyen.setText("TRỐNG");

        }
        // loadDHCT();
        DonHang donhang = dhdao.getDH(key);
        arrhd = dhdao.getDHByMaDH(donhang.getMaDH());
        List<DHCTBanHangCustom> list = dhctdao.getDSOder(arrhd.getId());
        modelDHCT = (DefaultTableModel) tblchitietban2.getModel();
        modelDHCT.setRowCount(0);
        int stt = 1;
        for (DHCTBanHangCustom dhct : list) {
            modelDHCT.addRow(new Object[]{
                stt++, dhct.getId(), dhct.getTenMon(), dhct.getSoLuong(), dhct.getDonGia()
            });
        }
       // loadDHCT();
    }//GEN-LAST:event_cbobanItemStateChanged
    List<DHCTBanHangCustom> listDHCT = new ArrayList<>();
    int r = 0;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int soluongchuyen = (int) txtsoluong.getValue();
        if (soluongchuyen == 0) {

            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cần chuyển!");
        } else {
            listDHCT.retainAll(listDHCT);
            model = (DefaultTableModel) tblchitietban.getModel();
            modelDHCT = (DefaultTableModel) tblchitietban2.getModel();
            if (soluongchuyen < 0) {
                JOptionPane.showMessageDialog(this, "Bạn không thể chuyển bằng cách trừ sản phẩm");
            } else {
                     int soluongbang = (int) model.getValueAt(r, 3);
                DonHang dh = dhdao.getDHByMaDH(txtmahdbanchuyen.getText());
                MonAn ma = tddao.getIdByTenMon((String) model.getValueAt(r, 2));
                List<DonHangChiTiet> list = dhctdao.getDHCT(dh.getId(), ma.getId());

                if (list.size() == 0) {
                    if (soluongbang > soluongchuyen) {
                        DonHangChiTiet newup = new DonHangChiTiet();

                        newup.setId((int) model.getValueAt(r, 1));
                        newup.setIdDonHang(dhdao.getDHByMaDH(txtmahd.getText()));
                        newup.setIdMonAn(tddao.getIdByTenMon((String) model.getValueAt(r, 2)));
                        newup.setSoLuong(soluongbang - soluongchuyen);
                        newup.setDonGia((BigDecimal) model.getValueAt(r, 4));
                        dhctdao.UpdateChiTiet(newup);
                        DonHangChiTiet newup2 = new DonHangChiTiet();
                        newup2.setIdDonHang(dh);
                        newup2.setIdMonAn(ma);
                        newup2.setSoLuong(soluongchuyen);
                        newup2.setDonGia((BigDecimal) tblchitietban.getValueAt(r, 4));
                        dhctdao.insert(newup2);

                    } else if (soluongchuyen > soluongbang) {
                        JOptionPane.showMessageDialog(this, "Số lượng chuyển không chính xác");
                    } else if (soluongbang == soluongchuyen) {
                        DonHangChiTiet newup = new DonHangChiTiet();
                        // newup.setId((int) model.getValueAt(r, 1));
                        newup.setIdDonHang(dh);
                        newup.setIdMonAn(ma);
                        newup.setSoLuong(soluongchuyen);
                        newup.setDonGia((BigDecimal) model.getValueAt(r, 4));
                        //dhctdao.UpdateChiTiet(newup);
                        dhctdao.insert(newup);
                        dhctdao.xoadhct((int) model.getValueAt(r, 1));
                    }
                } else {
                    if (soluongbang > soluongchuyen) {
                        DonHangChiTiet newup = new DonHangChiTiet();

                        newup.setId((int) model.getValueAt(r, 1));
                        newup.setIdDonHang(dhdao.getDHByMaDH(txtmahd.getText()));
                        newup.setIdMonAn(tddao.getIdByTenMon((String) model.getValueAt(r, 2)));
                        newup.setSoLuong(soluongbang - soluongchuyen);
                        newup.setDonGia((BigDecimal) model.getValueAt(r, 4));
                        dhctdao.UpdateChiTiet(newup);

                        for (DonHangChiTiet dhct : list) {
                            DonHangChiTiet dhup = new DonHangChiTiet();
                            dhup.setId(dhct.getId());
                            dhup.setIdDonHang(dhct.getIdDonHang());
                            dhup.setIdMonAn(dhct.getIdMonAn());
                            dhup.setSoLuong(dhct.getSoLuong() + soluongchuyen);
                            dhup.setDonGia(dhct.getDonGia());
                            dhctdao.UpdateChiTiet(dhup);
                        }

                    } else if (soluongbang == soluongchuyen) {
                        for (DonHangChiTiet donhangct : list) {
                            DonHangChiTiet newup2 = new DonHangChiTiet();
                            newup2.setId(donhangct.getId());
                            newup2.setIdDonHang(donhangct.getIdDonHang());
                            newup2.setIdMonAn(donhangct.getIdMonAn());
                            newup2.setSoLuong(donhangct.getSoLuong() + soluongchuyen);
                            newup2.setDonGia(donhangct.getDonGia());
                            dhctdao.UpdateChiTiet(newup2);
                        }

                        dhctdao.xoadhct((int) model.getValueAt(r, 1));
                    } else if (soluongbang < soluongchuyen) {
                        //alert("Số lượng chuyển không chính xác!");
                        JOptionPane.showMessageDialog(this, "Số lượng chuyển không chính xác");
                    }
                }
            }
            loadtblChiTietban();
        }
        loadDHCT();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblchitietbanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblchitietbanMouseClicked
        // TODO add your handling code here:
        String tenmon = "";
        int soluong = 0;
        r = 0;
        r = tblchitietban.rowAtPoint(evt.getPoint());
        int keyma = tblchitietban.rowAtPoint(evt.getPoint());
        tenmon = (String) tblchitietban.getValueAt(keyma, 2);
        soluong = (int) tblchitietban.getValueAt(keyma, 3);
        txtsoluong.setValue(soluong);
        txttk3.setText(tenmon);
    }//GEN-LAST:event_tblchitietbanMouseClicked

    private void btnTaoDHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoDHActionPerformed
        // TODO add your handling code here:
        String key = (String) cboban.getSelectedItem();
        List<DonHang> list = dhdao.getLists();
        Ban ban = bandao.getIDbyMa(key);
        int so = list.size();
        int so1 = so + 1;
        String AUTOMAHD = "DH".concat(String.valueOf(so1));
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm a");
        DonHang dh = new DonHang();
        dh.setMaDH(AUTOMAHD);
        //   dh.setIdKhuyenMai(km);
        dh.setIdBan(ban);
        dh.setNgayTao(date);
        dhdao.insert(dh);
        //Ban ban = bandao.getIDbyMa(MaBan);
        ban.setTrangThai(1);
        bandao.UpdateBan(ban);
        loadDHCT();
    }//GEN-LAST:event_btnTaoDHActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Tách bàn thành công");
        Ban ban = bandao.getIDbyMa(MaBan);
        KhuVuc kv = ban.getIdKhuVuc();
        TestDonHang.dh.FillBan(bandao.getkhuvuc(kv.getId()));
        JpGoiMon1.gm.removeAll();
        TestDonHang.dh.fillLb();
        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

    /**
     * @param args the command line arguments
     */
    //    public static void main(String args[]) {
    //        /* Set the Nimbus look and feel */
    //        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    //        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
    //         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
    //         */
    //        try {
    //            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
    //                if ("Nimbus".equals(info.getName())) {
    //                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
    //                    break;
    //                }
    //            }
    //        } catch (ClassNotFoundException ex) {
    //            java.util.logging.Logger.getLogger(Chuyenban.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //        } catch (InstantiationException ex) {
    //            java.util.logging.Logger.getLogger(Chuyenban.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //        } catch (IllegalAccessException ex) {
    //            java.util.logging.Logger.getLogger(Chuyenban.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
    //            java.util.logging.Logger.getLogger(Chuyenban.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    //        }
    //        //</editor-fold>
    //
    //        /* Create and display the dialog */
    //        java.awt.EventQueue.invokeLater(new Runnable() {
    //            public void run() {
    //                Chuyenban dialog = new Chuyenban(new javax.swing.JFrame(), true);
    //                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
    //                    @Override
    //                    public void windowClosing(java.awt.event.WindowEvent e) {
    //                        System.exit(0);
    //                    }
    //                });
    //                dialog.setVisible(true);
    //            }
    //        });
    //    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTaoDH;
    private javax.swing.JButton btnThoat;
    private javax.swing.JComboBox<String> cboban;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblchitietban;
    private javax.swing.JTable tblchitietban2;
    private javax.swing.JTextField txtbanchon;
    private javax.swing.JTextField txtmahd;
    private javax.swing.JTextField txtmahdbanchuyen;
    private javax.swing.JSpinner txtsoluong;
    private javax.swing.JTextField txttk3;
    // End of variables declaration//GEN-END:variables
}
