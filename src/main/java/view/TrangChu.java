package view;

import entity.Ban;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import javax.swing.JPanel;
import service.impl.BanServiceImpl;
import util.UserHelper;

public class TrangChu extends javax.swing.JFrame {

    public static TrangChu main;
    public BanServiceImpl bandao ;
    public TrangChu() {
        initComponents();
        setLocationRelativeTo(this);
        setExtendedState(TrangChu.MAXIMIZED_BOTH); 
        main = this;
        bandao = new BanServiceImpl();
        show(new ThongKe());
       Clock clock= new Clock(); 
        clock.start(); 
        lblTaiKhoan.setText(UserHelper.getUser.getMaNV());
        lblVaiTro.setText(UserHelper.getUser.VaiTroToString());
//////        if(lblVaiTro.getText().equals("Nhân viên")){
//////             r = false;
//////        }
       checkRole(UserHelper.getUser.isVaiTro());

    }
     SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss_a");
     public class Clock extends Thread{ 
    public Clock(){    } 
    @Override
    public void run(){ 
        while(true){ 
            int bandat =0, banpv=0;
            List<Ban> arrBan = bandao.GetTrangThai(0);
            for(int i = 0;i<arrBan.size();i++){
                if(arrBan.get(i).getTrangThai()==0){
                    banpv++;
                }
                        
            } 
            lblbantrong.setText(+banpv+" bàn trống");
            //lbldat.setText(+bandat+" bàn đặt trước");
            Calendar calendar = Calendar.getInstance();                
            String str;  
            str= sdf.format(calendar.getTime()); 
            lbltime.setText(str); 
        try{ 
            sleep(1000); 
          } catch(Exception e){ 
             System.out.println(e); 
            } 
      } 
    }
    }
    public void checkRole(boolean vaiTro) {
        if (vaiTro == false) {
            btn_ban.setEnabled(false);
            btn_hoadon.setEnabled(false);
            btn_khuyenmai.setEnabled(false);
            btn_nhanvien.setEnabled(false);
            btn_thongke.setEnabled(false);
            btn_thucdon.setEnabled(false);
        }else{
            btn_ban.setEnabled(true);
            btn_hoadon.setEnabled(true);
            btn_khuyenmai.setEnabled(true);
            btn_nhanvien.setEnabled(true);
            btn_thongke.setEnabled(true);
            btn_thucdon.setEnabled(true);
        }
    }
    public void show(JPanel a) {
        lbl_hihi.removeAll();
        lbl_hihi.add(a);
        lbl_hihi.validate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton14 = new javax.swing.JButton();
        btn_hoadon = new javax.swing.JButton();
        btn_thucdon = new javax.swing.JButton();
        btn_khuyenmai = new javax.swing.JButton();
        btn_nhanvien = new javax.swing.JButton();
        btn_thongke = new javax.swing.JButton();
        btn_ban = new javax.swing.JButton();
        btn_donhang = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        lbl_hihi = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblVaiTro = new javax.swing.JLabel();
        lblTaiKhoan = new javax.swing.JLabel();
        lbltime = new javax.swing.JLabel();
        lblbantrong = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 204, 255));
        setPreferredSize(new java.awt.Dimension(1010, 679));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Trang Chủ");

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Menu"));

        jButton14.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton14.setText("Đăng Xuất");
        jButton14.setBorder(null);
        jButton14.setBorderPainted(false);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        btn_hoadon.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_hoadon.setIcon(new javax.swing.ImageIcon("C:\\Test\\QLNhaHang\\src\\main\\java\\image\\bill.png")); // NOI18N
        btn_hoadon.setText("QL Hoá Đơn");
        btn_hoadon.setBorder(null);
        btn_hoadon.setBorderPainted(false);
        btn_hoadon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hoadonActionPerformed(evt);
            }
        });

        btn_thucdon.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_thucdon.setIcon(new javax.swing.ImageIcon("C:\\Test\\QLNhaHang\\src\\main\\java\\image\\menu.png")); // NOI18N
        btn_thucdon.setText("Thực đơn");
        btn_thucdon.setBorder(null);
        btn_thucdon.setBorderPainted(false);
        btn_thucdon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thucdonActionPerformed(evt);
            }
        });

        btn_khuyenmai.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_khuyenmai.setIcon(new javax.swing.ImageIcon("C:\\Test\\QLNhaHang\\src\\main\\java\\image\\sale-tag.png")); // NOI18N
        btn_khuyenmai.setText("Khuyến Mãi");
        btn_khuyenmai.setBorder(null);
        btn_khuyenmai.setBorderPainted(false);
        btn_khuyenmai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_khuyenmaiActionPerformed(evt);
            }
        });

        btn_nhanvien.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_nhanvien.setIcon(new javax.swing.ImageIcon("C:\\Test\\QLNhaHang\\src\\main\\java\\image\\Nhan vien.png")); // NOI18N
        btn_nhanvien.setText("Nhân Viên");
        btn_nhanvien.setBorder(null);
        btn_nhanvien.setBorderPainted(false);
        btn_nhanvien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nhanvienActionPerformed(evt);
            }
        });

        btn_thongke.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_thongke.setIcon(new javax.swing.ImageIcon("C:\\Test\\QLNhaHang\\src\\main\\java\\image\\thongKe.png")); // NOI18N
        btn_thongke.setText("Thống kê");
        btn_thongke.setBorder(null);
        btn_thongke.setBorderPainted(false);
        btn_thongke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thongkeActionPerformed(evt);
            }
        });

        btn_ban.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_ban.setIcon(new javax.swing.ImageIcon("C:\\Test\\QLNhaHang\\src\\main\\java\\image\\dining-table.png")); // NOI18N
        btn_ban.setText("QL Bàn");
        btn_ban.setBorder(null);
        btn_ban.setBorderPainted(false);
        btn_ban.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_banActionPerformed(evt);
            }
        });

        btn_donhang.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn_donhang.setIcon(new javax.swing.ImageIcon("C:\\Test\\QLNhaHang\\src\\main\\java\\image\\Ban hang.png")); // NOI18N
        btn_donhang.setText("Bán hàng");
        btn_donhang.setBorder(null);
        btn_donhang.setBorderPainted(false);
        btn_donhang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_donhangActionPerformed(evt);
            }
        });

        jButton15.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jButton15.setText("Đổi Mật Khẩu");
        jButton15.setBorder(null);
        jButton15.setBorderPainted(false);
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_donhang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_thucdon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_khuyenmai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_thongke, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_nhanvien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btn_hoadon, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
            .addComponent(btn_ban, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btn_donhang, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btn_thucdon, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btn_khuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btn_nhanvien, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btn_ban, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btn_hoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btn_thongke, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbl_hihi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        lbl_hihi.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel2.setText("Tài khoản :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel3.setText(" Vai trò :");

        lblVaiTro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblVaiTro.setText("jLabel4");

        lblTaiKhoan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTaiKhoan.setText("jLabel4");

        lbltime.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbltime.setForeground(new java.awt.Color(255, 0, 51));
        lbltime.setText("jLabel4");

        lblbantrong.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(537, 537, 537)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(285, 285, 285)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblTaiKhoan))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblVaiTro)))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblbantrong)
                            .addComponent(lbltime)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(lbl_hihi, javax.swing.GroupLayout.PREFERRED_SIZE, 1057, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lblTaiKhoan)
                            .addComponent(lbltime))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lblVaiTro)
                            .addComponent(lblbantrong))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_hihi, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_thucdonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thucdonActionPerformed
        show(new ThucDonpanel());
    }//GEN-LAST:event_btn_thucdonActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void btn_khuyenmaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_khuyenmaiActionPerformed
        show(new KhuyenMaiJpanel());
    }//GEN-LAST:event_btn_khuyenmaiActionPerformed

    private void btn_banActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_banActionPerformed
        show(new BanJPanel());
    }//GEN-LAST:event_btn_banActionPerformed

    private void btn_thongkeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thongkeActionPerformed
        show(new ThongKe());
    }//GEN-LAST:event_btn_thongkeActionPerformed

    private void btn_hoadonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hoadonActionPerformed
        show(new HoaDonJpanel());
    }//GEN-LAST:event_btn_hoadonActionPerformed

    private void btn_donhangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_donhangActionPerformed
        show(new TestDonHang());
//        lbl_hihi.removeAll();
//        TestDonHang test = new TestDonHang();
//        lbl_hihi.add(test);
    }//GEN-LAST:event_btn_donhangActionPerformed

    private void btn_nhanvienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nhanvienActionPerformed
        show(new NhanVienJpanel());
    }//GEN-LAST:event_btn_nhanvienActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        new DoiMK2().setVisible(true);
    }//GEN-LAST:event_jButton15ActionPerformed

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
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrangChu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ban;
    private javax.swing.JButton btn_donhang;
    private javax.swing.JButton btn_hoadon;
    private javax.swing.JButton btn_khuyenmai;
    private javax.swing.JButton btn_nhanvien;
    private javax.swing.JButton btn_thongke;
    private javax.swing.JButton btn_thucdon;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblTaiKhoan;
    private javax.swing.JLabel lblVaiTro;
    private javax.swing.JPanel lbl_hihi;
    private javax.swing.JLabel lblbantrong;
    private javax.swing.JLabel lbltime;
    // End of variables declaration//GEN-END:variables
}
