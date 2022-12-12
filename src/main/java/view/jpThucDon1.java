/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import custom.DHCTBanHangCustom;
import entity.DanhMuc;
import entity.MonAn;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import service.impl.DanhMucService;
import service.impl.DonHangChiTietServiceImpl;
import service.impl.MonAnServiceImpl;



public class jpThucDon1 extends javax.swing.JPanel {

   private MonAnServiceImpl thucdondao = new MonAnServiceImpl();
    private DanhMucService danhmucdao = new DanhMucService();
    private DonHangChiTietServiceImpl dhctdao = new DonHangChiTietServiceImpl();
    public String gioden, tenban;
    public String maban;
    public ArrayList<MonAn> arrdsmon;
    List<MonAn> listtd;
    List<MonAn> arrThucDon;
    NumberFormat chuyentien = new DecimalFormat("#,###,###");
    public static jpThucDon1 td;

    public void FillLoai() {
        List<DanhMuc> arrDanhMuc = danhmucdao.getLists();
        if (arrDanhMuc != null) {
            JButton btn;
            jpLoai.setLayout(new BoxLayout(jpLoai, BoxLayout.PAGE_AXIS));
            jpLoai.removeAll();
            jpChonMon.setLayout(new FlowLayout(FlowLayout.CENTER));
            for (DanhMuc ds : arrDanhMuc) {
                btn = new JButton(ds.getTenLoai());
                btn.setName(ds.getMaLoai());
                btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btn.setMaximumSize(new Dimension(140, 40));
                btn.setForeground(Color.decode("#331a00"));
                btn.setBackground(Color.ORANGE);
                btn.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
                btn.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        lblNhom.setText("    Nhóm " + ds.getTenLoai());
                        List<MonAn> arrThucDon = thucdondao.GetThucDon(ds.getMaLoai());
                        jpChonMon.removeAll();
                        jpChonMon.updateUI();
                        if (arrThucDon != null) {
                            JTextField txt = new JTextField();
                            JPanel[] pn = new JPanel[arrThucDon.size()];
//                                PopupMenu popupmenu = new PopupMenu("Edit");
//                                MenuItem hh = new MenuItem("Hết Hàng");
//                                hh.setActionCommand("Hết hàng");
//                                popupmenu.add(hh);
                            //jPanel4.setLayout(new BoxLayout(jPanel4, BoxLayout.PAGE_AXIS));
                            for (int i = 0; i < arrThucDon.size(); i++) {
                                pn[i] = new JPanel();
                                pn[i].setName(arrThucDon.get(i).getMaMon());
                                pn[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
                                pn[i].setBackground(Color.decode("#dfff80"));
                                pn[i].setBorder(BorderFactory.createLineBorder(Color.decode("#a3a375"), 2));
                                pn[i].setPreferredSize(new Dimension(128, 60));
                                pn[i].add(new JLabel(arrThucDon.get(i).getTenMon())).setFont(new java.awt.Font("Tahoma", 1, 12));
                                pn[i].add(new JLabel(String.valueOf(chuyentien.format(arrThucDon.get(i).getDonGia())) + " VNĐ/ " + arrThucDon.get(i).getDonViTinh())).setForeground(Color.decode("#ff0000"));


                                pn[i].addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mousePressed(MouseEvent e) {
                                        // listtd = thucdondao.getBytenmon(e.getComponent().getName());
                                        // DHCTBanHangCustom mon = dhctdao.GetDsChiTiet(e.getComponent().getName(), maban);
                                        DLSoLuong sl = new DLSoLuong(TrangChu.main, true, e.getComponent().getName(), tenban, maban);
                                        sl.gioden = gioden;
                                        sl.setVisible(true);
                                    }
                                });
//                              

                                jpChonMon.add(pn[i]);
                                jpChonMon.updateUI();
                            }
                        }

                    }
                });
                jpLoai.add(btn);
                jpLoai.updateUI();
           }

        }

    }

    public jpThucDon1() {
        initComponents();
        td = this;
        FillLoai();
   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblNhom = new javax.swing.JLabel();
        jpChonMon = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jpLoai = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(Color.decode("#e6e6e6"));

        jPanel1.setBackground(Color.decode("#e6e6e6"));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setAlignmentX(0.0F);

        lblNhom.setBackground(new java.awt.Color(11, 112, 14));
        lblNhom.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNhom.setForeground(new java.awt.Color(253, 253, 253));
        lblNhom.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNhom.setText("                          Chọn món");
        lblNhom.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblNhom.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        lblNhom.setIconTextGap(7);
        lblNhom.setOpaque(true);

        jpChonMon.setBackground(Color.decode("#e6e6e6"));
        jpChonMon.setAutoscrolls(true);
        jpChonMon.setPreferredSize(new java.awt.Dimension(289, 420));

        jLabel2.setText("Tìm Kiếm");

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblNhom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jpChonMon, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblNhom, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpChonMon, javax.swing.GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        jpLoai.setBackground(Color.decode("#e6e6e6"));
        jpLoai.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 102, 51));
        jLabel4.setText("Danh Mục");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(13, 13, 13)
                .addComponent(jpLoai, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE)
                .addGap(143, 143, 143))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        // TODO add your handling code here:
               List<MonAn> arrThucDon = thucdondao.TimKiem(txtTimKiem.getText());
                        jpChonMon.removeAll();
                        jpChonMon.updateUI();
                        if (arrThucDon != null) {
                            JTextField txt = new JTextField();
                            JPanel[] pn = new JPanel[arrThucDon.size()];
//                               
                            for (int i = 0; i < arrThucDon.size(); i++) {
                                pn[i] = new JPanel();
                                pn[i].setName(arrThucDon.get(i).getMaMon());
                                pn[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
                                pn[i].setBackground(Color.decode("#dfff80"));
                                pn[i].setBorder(BorderFactory.createLineBorder(Color.decode("#a3a375"), 2));
                                pn[i].setPreferredSize(new Dimension(128, 60));
                                pn[i].add(new JLabel(arrThucDon.get(i).getTenMon())).setFont(new java.awt.Font("Tahoma", 1, 12));
                                pn[i].add(new JLabel(String.valueOf(chuyentien.format(arrThucDon.get(i).getDonGia())) + " VNĐ/ " + arrThucDon.get(i).getDonViTinh())).setForeground(Color.decode("#ff0000"));

                                pn[i].addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mousePressed(MouseEvent e) {
                                        // listtd = thucdondao.getBytenmon(e.getComponent().getName());
                                     
                                        DLSoLuong sl = new DLSoLuong(TrangChu.main, true, e.getComponent().getName(), tenban, maban);
                                        sl.gioden = gioden;
                                        sl.setVisible(true);
                                    }
                                });
//                              
                                jpChonMon.add(pn[i]);
                                jpChonMon.updateUI();
    }//GEN-LAST:event_txtTimKiemKeyReleased
    }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jpChonMon;
    private javax.swing.JPanel jpLoai;
    private javax.swing.JLabel lblNhom;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

}
