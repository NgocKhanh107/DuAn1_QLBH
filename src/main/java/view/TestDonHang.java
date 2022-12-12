package view;

import custom.BanCustom;
import custom.KhuVucCustom;
import entity.Ban;
import entity.KhuVuc;
import java.awt.Color;
import java.awt.Dimension;
import static java.awt.Frame.DEFAULT_CURSOR;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import service.ICommonService;
import service.impl.BanServiceImpl;
import service.impl.KhuVucServiceImpl;

public class TestDonHang extends javax.swing.JPanel {

    private BanServiceImpl bandao;
    KhuVucServiceImpl kvdao;
    public static TestDonHang dh;
    JPanel jps;
    List<BanCustom> arrBan;
    List<Ban> listBan;
    List<KhuVucCustom> khuvucList;
    List<JPanel> listjp = new ArrayList<JPanel>();
    BanCustom ban;
    int idBan;

    public TestDonHang() {
        initComponents();
        dh = this;
        bandao = new BanServiceImpl();
        kvdao = new KhuVucServiceImpl();
        load();
    }

    public void load() {
        khuvucList = kvdao.findByKey("");
        List<String> abc = new ArrayList<>();
        List<BanCustom> listban = bandao.findByKey("");
        List<BanCustom> arrBan = bandao.getkhuvuc(1);
        for (KhuVucCustom nv : khuvucList) {
            jps = new JPanel();
            jps.setSize(362, DEFAULT_CURSOR);
            jps.setName(nv.getTenKV());
            listjp.add(jps);
            abc.add(nv.getTenKV());

        }
        for (int a = 0; a < listjp.size(); a++) {
            tab.add(listjp.get(a));
            tab.repaint();
        }
        FillBan(arrBan);
    }

    public void FillBan(List<BanCustom> arrBan) {
        if (arrBan != null) {
            jpBan.removeAll();
            JButton[] btn = new JButton[arrBan.size()];
            for (int i = 0; i < arrBan.size(); i++) {
                btn[i] = new JButton();
                String name = String.valueOf(arrBan.get(i).getMaBan());
                btn[i].setName(name);
                String[] mb = arrBan.get(i).getMaBan().split(" ");
                btn[i].setText(mb[0]);
                btn[i].setIcon(new javax.swing.ImageIcon("C:\\\\Test\\\\QLNhaHang\\\\image\\\\iconApp\\\\restaurant (1).png"));
                btn[i].setBackground(Color.decode("#8080ff"));
                btn[i].setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
                btn[i].setForeground(new java.awt.Color(51, 51, 51));
                //btn[i].setPreferredSize(new Dimension(90, 70));
                if (arrBan.get(i).getTrangThai() == 1) {
                    btn[i].setBackground(Color.decode("#66ff66"));
                   
                }
                if (arrBan.get(i).getTrangThai() == 0) {
                    btn[i].setBackground(Color.decode("#8080ff"));
                   
                }
                if (arrBan.get(i).getTrangThai() == 2) {
                    btn[i].setBackground(Color.decode("#ff6699"));
                    
                }
                btn[i].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        JpGoiMon1 goimon;
                        System.out.println(e.getComponent().getName());
                        ban = bandao.Getban(e.getComponent().getName());
                        if (ban != null) {
                            goimon = new JpGoiMon1(ban.getTrangThai(), ban.getMaBan());
                            pnlBanHang.removeAll();
                            pnlBanHang.add(goimon);
                            pnlBanHang.updateUI();
                        }
                    }
                });
                jpBan.add(btn[i]);
                jpBan.updateUI();

            }
        }

    }

    public void fillLb() {
        pnlBanHang.removeAll();
        pnlBanHang.updateUI();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        pnlBan = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tab = new javax.swing.JTabbedPane();
        jpBan = new javax.swing.JPanel();
        pnlBanHang = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(1057, 600));

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1057, 605));

        pnlBan.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh Sách Bàn"));
        pnlBan.setPreferredSize(new java.awt.Dimension(369, 605));

        jButton4.setBackground(new java.awt.Color(204, 0, 204));

        jButton6.setBackground(new java.awt.Color(0, 204, 0));

        jLabel11.setText("Bàn trống");

        jLabel13.setText("Đang phục vụ");

        tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlBanLayout = new javax.swing.GroupLayout(pnlBan);
        pnlBan.setLayout(pnlBanLayout);
        pnlBanLayout.setHorizontalGroup(
            pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBanLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpBan, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tab, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );
        pnlBanLayout.setVerticalGroup(
            pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBanLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(tab, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpBan, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)))
                .addGap(494, 494, 494))
        );

        pnlBanHang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 255)));
        pnlBanHang.setPreferredSize(new java.awt.Dimension(729, 605));
        pnlBanHang.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBan, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBanHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlBan, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabMouseClicked
        // TODO add your handling code here:
        int index = tab.getSelectedIndex();
        String tenKV = tab.getTitleAt(index);
        List<KhuVucCustom> listKhuVuc = kvdao.findByKey(tenKV);
        List<BanCustom> listBan = bandao.getkhuvuc(listKhuVuc.get(0).getId());
        FillBan(listBan);
    }//GEN-LAST:event_tabMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jpBan;
    private javax.swing.JPanel pnlBan;
    private javax.swing.JPanel pnlBanHang;
    private javax.swing.JTabbedPane tab;
    // End of variables declaration//GEN-END:variables
}
