package view;

import com.raven.chart.Chart;
import com.raven.chart.ModelChart;
import java.awt.Color;
import java.awt.Frame;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Formatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.formula.ptg.TblPtg;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import repository.impl.ThongKeRepositoryImpl;

public class ThongKe extends javax.swing.JPanel {

    private ThongKeRepositoryImpl _ThongKeRepository;
    private SimpleDateFormat spd;

    public ThongKe() {
        initComponents();
        _ThongKeRepository = new ThongKeRepositoryImpl();

        lbl_tongtien.setText(tongtien2() + " VND");
        lbl_tonghoadon.setText(tongHoadon() + "Hoá đơn");
        lbl_sanpham.setText(tongmathang() + "mat hang");
        combobox();
        fillTableTheoNam();
        //fillTableHomNay();
    }

    public void combobox() {
        DefaultComboBoxModel cbx = new DefaultComboBoxModel();
        cbx.addElement("Hôm Nay");
        cbx_theongay.setModel(cbx);
    }

    public BigDecimal tongtien2() {

        return _ThongKeRepository.TongTien2();
    }

    public BigDecimal tongtienchart(Date date1, Date date2) {

        return _ThongKeRepository.Tongtiencharttheongay(date1, date2);
    }

    public String tongHoadon() {
        String s = NumberFormat.getIntegerInstance().format(_ThongKeRepository.TongTien3());
        return s;
    }

    public String tongmathangtrongngay() {

        String s = NumberFormat.getIntegerInstance().format(_ThongKeRepository.Tonghmghomnay());

        return s;
    }

    public String tongmathang() {
        String s = NumberFormat.getIntegerInstance().format(_ThongKeRepository.TongTien4());
        return s;
    }

    public BigDecimal tongtienhomnay() {

        return _ThongKeRepository.TongTienHomNay();
    }

    public String tongHoadonhomnay() {
        String s = NumberFormat.getIntegerInstance().format(_ThongKeRepository.Tonghoadontrongngay());
        return s;
    }

    void fillTableTheoNam() {
        DefaultTableModel model = (DefaultTableModel) tblsanpham.getModel();
        model.setRowCount(0);
        List<Object[]> list = _ThongKeRepository.thongke4(10);
        for (Object[] row : list) {
            model.addRow(row);
        }
    }

    void fillTableHomNay() {
        DefaultTableModel model = (DefaultTableModel) tblsanpham.getModel();
        model.setRowCount(0);
        List<Object[]> list = _ThongKeRepository.thongketrongngay();
        for (Object[] row : list) {
            model.addRow(row);
        }
    }

    void fillTabledate(Date date1, Date date2) {
        DefaultTableModel model = (DefaultTableModel) tblsanpham.getModel();
        model.setRowCount(0);
        List<Object[]> list = _ThongKeRepository.thongketheodate(date1, date2);
        for (Object[] row : list) {
            model.addRow(row);
        }
    }

    public String tongmathang(Date date1, Date date2) {

        String s = NumberFormat.getIntegerInstance().format(_ThongKeRepository.TongTientheongay(date1, date2));

        return s;
    }

    public String tongHoadon(Date date1, Date date2) {

        String s = NumberFormat.getIntegerInstance().format(_ThongKeRepository.Tonghoadonngay(date1, date2));

        return s;
    }

    public BigDecimal tongtien(Date date1, Date date2) {

        return _ThongKeRepository.Tongtien1theongay(date1, date2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblsanpham = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lbl_nam = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbl_tongtien = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        lbl_tonghoadon = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        lbl_sanpham = new javax.swing.JLabel();
        txtdate1 = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtdate2 = new com.toedter.calendar.JDateChooser();
        btnloc = new javax.swing.JButton();
        btntim = new javax.swing.JButton();
        cbx_theongay = new javax.swing.JComboBox<>();
        btntimkiem = new javax.swing.JButton();

        jPanel4.setBackground(new java.awt.Color(153, 153, 255));

        tblsanpham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã sp", "Tên sp", "Giá", "Số lượng "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblsanpham);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Thống kê ");

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbl_nam.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Tổng:");

        lbl_tongtien.setText("jLabel7");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_tongtien))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(lbl_nam, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lbl_nam)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(lbl_tongtien))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Tổng hoá đơn:");

        lbl_tonghoadon.setText("jLabel3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_tonghoadon)
                .addContainerGap(86, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lbl_tonghoadon))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Tổng sản phẩm đã bán:");

        lbl_sanpham.setText("jLabel4");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_sanpham)
                .addContainerGap(119, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lbl_sanpham))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("Từ ngày:");

        jLabel11.setText("Đến ngày:");

        btnloc.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnloc.setText("Bieu do trong ngay");
        btnloc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlocActionPerformed(evt);
            }
        });

        btntim.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btntim.setText("Bieu do tong");
        btntim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntimActionPerformed(evt);
            }
        });

        cbx_theongay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbx_theongay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_theongayActionPerformed(evt);
            }
        });

        btntimkiem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btntimkiem.setText("Tìm kiếm");
        btntimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntimkiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(cbx_theongay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtdate1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(txtdate2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btntimkiem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnloc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btntim)
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(447, 447, 447))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnloc)
                            .addComponent(btntim)
                            .addComponent(btntimkiem))
                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtdate2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtdate1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cbx_theongay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnlocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlocActionPerformed
        if(txtdate2.getDate().compareTo(txtdate1.getDate()) == -1){
            JOptionPane.showMessageDialog(this, "Ngày lọc ko hợp lệ");
            return;
                    
        }
        if (txtdate1.getDate() == null || txtdate2.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Chua chon ngay de loc");
            return ;
        }
        if (tongtien(txtdate1.getDate(), txtdate2.getDate()) == null || tongmathang(txtdate1.getDate(), txtdate2.getDate()) == null) {
            lbl_tongtien.setText(0 + "VNĐ");
            lbl_sanpham.setText(0 + "Mặt hàng");
            lbl_tonghoadon.setText(0 + "Hoá Đơn");
            return;
        }

        lbl_tongtien.setText(this.tongtien(txtdate1.getDate(), txtdate2.getDate()) + " VND");

        lbl_sanpham.setText(this.tongmathang(txtdate1.getDate(), txtdate2.getDate()) + "Mặt Hàng");

        lbl_tonghoadon.setText(this.tongHoadon(txtdate1.getDate(), txtdate2.getDate()) + "hoá đơn");
        
        fillTabledate(txtdate1.getDate(),txtdate2.getDate());
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(tongtienchart(txtdate1.getDate(), txtdate2.getDate()), "Alo", "123");
        JFreeChart chart = ChartFactory.createBarChart("stdent sc", "name", "mark", dataset, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.BLUE);
        ChartFrame frame = new ChartFrame("bar chart", chart);
        frame.setVisible(true);
        frame.setSize(600, 460);
    }//GEN-LAST:event_btnlocActionPerformed

    private void cbx_theongayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_theongayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_theongayActionPerformed

    private void btntimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntimActionPerformed
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(tongtien2(), "Alo", "123");
        JFreeChart chart = ChartFactory.createBarChart("stdent sc", "name", "mark", dataset, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.BLUE);
        ChartFrame frame = new ChartFrame("bar chart", chart);
        frame.setVisible(true);
        frame.setSize(600, 460);

    }//GEN-LAST:event_btntimActionPerformed

    private void btntimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntimkiemActionPerformed
        if (cbx_theongay.getSelectedItem().toString().equals("Hôm Nay")) {
            fillTableHomNay();
//            lbl_tongtien.setText(tongtienhomnay().toString());
            lbl_tonghoadon.setText(tongHoadonhomnay());
            lbl_sanpham.setText(tongmathangtrongngay());
        }
    }//GEN-LAST:event_btntimkiemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnloc;
    private javax.swing.JButton btntim;
    private javax.swing.JButton btntimkiem;
    private javax.swing.JComboBox<String> cbx_theongay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_nam;
    private javax.swing.JLabel lbl_sanpham;
    private javax.swing.JLabel lbl_tonghoadon;
    private javax.swing.JLabel lbl_tongtien;
    private javax.swing.JTable tblsanpham;
    private com.toedter.calendar.JDateChooser txtdate1;
    private com.toedter.calendar.JDateChooser txtdate2;
    // End of variables declaration//GEN-END:variables
}
