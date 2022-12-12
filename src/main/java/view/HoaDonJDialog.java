/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import custom.DHCTBanHangCustom;
import custom.HDCTBanHangCustom;
import entity.DonHang;
import entity.DonHangChiTiet;
import entity.HoaDon;
import entity.HoaDonChiTiet;
import entity.KhuyenMai;
import entity.MonAn;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.impl.DonHangChiTietServiceImpl;
import service.impl.DonHangServiceImpl;
import service.impl.HoaDonChiTietServiceImpl;
import service.impl.HoaDonServiceImpl;
import service.impl.KhuyenMaiServiceImpl;
import service.impl.MonAnServiceImpl;

/**
 *
 * @author hieu
 */
public class HoaDonJDialog extends javax.swing.JDialog {

    public int idDH, IdKM;
    BigDecimal tongtien;
    BigDecimal tiendoi;
    Date date;
    String MaBan, MaDH, TenBan, MaNV;
    NumberFormat chuyentien = new DecimalFormat("#,###,###");
    DonHangServiceImpl dhdao = new DonHangServiceImpl();
    HoaDonServiceImpl hddao = new HoaDonServiceImpl();
    DonHangChiTietServiceImpl dhctdao = new DonHangChiTietServiceImpl();
    HoaDonChiTietServiceImpl hdctdao = new HoaDonChiTietServiceImpl();
    KhuyenMaiServiceImpl kmdao = new KhuyenMaiServiceImpl();
    MonAnServiceImpl tddao = new MonAnServiceImpl();
    KhuyenMai km;
    BigDecimal tienthaydoi;
    List<HoaDon> list;
    DonHang listdh;
    List<DHCTBanHangCustom> order;
    List<HDCTBanHangCustom> listhdct;
    DonHang arrhd;
    HoaDonChiTiet hdct;
    private DefaultTableModel tblModel;
    private DefaultTableModel modelDHCT;
    private DefaultTableModel modelHDCT;
    public static HoaDonJDialog hdjd;
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm a");

    /**
     * Creates new form HoaDonJDialog
     *
     * @param parent
     * @param modal
     * @param IdDH
     * @param tien
     * @param ngaytao
     * @param maDH
     * @param tenBan
     */
    public HoaDonJDialog(java.awt.Frame parent, boolean modal, int IdDH, BigDecimal tien, Date ngaytao, String maBan, String maDH, String tenBan, String maNV) {
        super(parent, modal);
        initComponents();
        hdjd = this;
        idDH = IdDH;
        tongtien = tien;
        date = ngaytao;
        MaBan = maBan;
        TenBan = tenBan;
        MaDH = maDH;
        MaNV = maNV;
        DonHang dh = dhdao.findById(idDH);
        KhuyenMai km = dh.getIdKhuyenMai();
        lblmadh.setText(maDH);
        lblMaBan.setText(maBan);
        lblngayTao.setText(df.format(ngaytao));
        lblGiaTien.setText(String.valueOf(chuyentien.format(tien) + " VNĐ"));
        String magiamgia = km.getMaGiamGia();
        lblMakm.setText(magiamgia);
        lblMaNV.setText(maNV);
        loadtableHoaDon();
        // loadtblHDCT();
    }

    private void loadtableHoaDon() {
        list = hddao.getHDByMaDH(MaDH);
        tblModel = (DefaultTableModel) tblHoaDon.getModel();
        tblModel.setRowCount(0);
        int stt = 1;
        for (HoaDon hd : list) {
            tblModel.addRow(new Object[]{
                stt++, hd.getMaHd(), hd.getNgayTao(), hd.getIdDonHang().getMaDH()
            });
        }
    }

    public void clean() {
        txtMaHD.setText("");
        txtNgayTao.setText("");
        txtSL.setText("");
        txtSP.setText("");
        txtThanhTien.setText("");
    }

    private void loadTableDHCT() {
        arrhd = dhdao.getDHbyMa(MaBan);
        order = dhctdao.getDSOder(arrhd.getId());
        modelDHCT = (DefaultTableModel) tbldhCT.getModel();
        modelDHCT.setRowCount(0);
        int stt = 1;
        for (DHCTBanHangCustom dhct : order) {
            modelDHCT.addRow(new Object[]{
                stt++, dhct.getId(), dhct.getTenMon(), dhct.getSoLuong(), dhct.getDonGia()
            });
        }
    }

    private void loadtblHDCT() {
        HoaDon hd = hddao.getIDByMaHD(txtMaHD.getText());
        listhdct = hdctdao.getDSHDCT(hd.getId());
        modelHDCT = (DefaultTableModel) tblhdct.getModel();
        modelHDCT.setRowCount(0);
        int stt = 1;
        for (HDCTBanHangCustom hdct : listhdct) {
            modelHDCT.addRow(new Object[]{
                stt++, hdct.getId(), hdct.getTenMon(), hdct.getSoLuong(), hdct.getDonGia()
            });
        }
        tienthaydoi = new BigDecimal(0);
        for (int i = 0; i < listhdct.size(); i++) {
            int sl = listhdct.get(i).getSoLuong();
            BigDecimal dongia = new BigDecimal(listhdct.get(i).getDonGia() + "");
            BigDecimal tien = new BigDecimal(sl).multiply(dongia);
            tienthaydoi = tienthaydoi.add(tien);
        }
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnLapHoaDon = new javax.swing.JButton();
        lblmadh = new javax.swing.JLabel();
        lblMaBan = new javax.swing.JLabel();
        lblngayTao = new javax.swing.JLabel();
        lblGiaTien = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblMakm = new javax.swing.JLabel();
        btnThoat = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lblMaNV = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnSua = new javax.swing.JButton();
        txtThanhTien = new javax.swing.JTextField();
        txtSP = new javax.swing.JTextField();
        txtSL = new javax.swing.JTextField();
        txtMaHD = new javax.swing.JTextField();
        txtNgayTao = new javax.swing.JTextField();
        btnLuu = new javax.swing.JButton();
        btnAll = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbldhCT = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblhdct = new javax.swing.JTable();
        btnInhoadon = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin"));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Mã đơn hàng:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Mã bàn:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Ngày tạo:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Mã NV:");

        btnLapHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLapHoaDon.setText("Lập hoá đơn");
        btnLapHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLapHoaDonActionPerformed(evt);
            }
        });

        lblmadh.setText("jLabel5");

        lblMaBan.setText("jLabel6");

        lblngayTao.setText("jLabel7");

        lblGiaTien.setText("jLabel8");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Mã khuyến mãi:");

        lblMakm.setText("jLabel8");

        btnThoat.setIcon(new javax.swing.ImageIcon("C:\\Test\\QLNhaHang\\src\\main\\java\\image\\undo.png")); // NOI18N
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Giá tiền:");

        lblMaNV.setText("jLabel6");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(btnLapHoaDon)
                .addGap(58, 58, 58))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblGiaTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMaBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblmadh, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblMakm, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblngayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMaNV)))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblmadh))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblMaBan))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblMaNV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblngayTao)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGiaTien)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblMakm))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThoat)
                    .addComponent(btnLapHoaDon))
                .addGap(13, 13, 13))
        );

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Mã hoá đơn", "Ngày tạo", "Mã đơn hàng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblHoaDon);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin"));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Mã hoá đơn:");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Giá tiền:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("Sản phẩm:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Số lượng:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Ngày tạo:");

        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnLuu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnAll.setText("All");
        btnAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaHD)
                            .addComponent(txtNgayTao)
                            .addComponent(txtSP)
                            .addComponent(txtSL)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 30, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLuu, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                        .addGap(17, 17, 17)))
                .addGap(24, 24, 24))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAll)
                .addGap(95, 95, 95))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAll)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSua)
                    .addComponent(btnLuu))
                .addGap(16, 16, 16))
        );

        tbldhCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "IDDHCT", "Tên món", "Số lượng", "Thành Tiền"
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
        tbldhCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbldhCTMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbldhCT);

        tblhdct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "IDHDCT", "Tên Món", "Số Lượng", "Giá Tiền"
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
        tblhdct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblhdctMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblhdct);

        btnInhoadon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnInhoadon.setIcon(new javax.swing.ImageIcon("C:\\Test\\QLNhaHang\\src\\main\\java\\image\\inhoadon.png")); // NOI18N
        btnInhoadon.setText("In Hoá đơn");
        btnInhoadon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInhoadonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(284, 284, 284)
                .addComponent(btnInhoadon)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInhoadon)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLapHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLapHoaDonActionPerformed
        // TODO add your handling code here:
        HoaDon hd = new HoaDon();
        //  listdh = dhdao.getDHbyMa(MaBan);
        arrhd = dhdao.getDHbyMa(MaBan);
        hd.setIdDonHang(arrhd);
        list = hddao.getAll();
        int so = list.size();
        int so1 = so + 1;
        String AUTOMAHD = "HD".concat(String.valueOf(so1));

        hd.setMaHd(AUTOMAHD);
        hd.setNgayTao(date);
        hd.setTrangThai(0);
        String inserthd = hddao.insert(hd);
        loadtableHoaDon();
        loadtblHDCT();
    }//GEN-LAST:event_btnLapHoaDonActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        // TODO add your handling code here:
        loadTableDHCT();
        int r = tblHoaDon.getSelectedRow();
        if (r < 0) {
            return;
        }

        String idhoadon = tblHoaDon.getValueAt(r, 1).toString();
        String ngaytao = tblHoaDon.getValueAt(r, 2).toString();
        txtMaHD.setText(idhoadon);
        txtNgayTao.setText(ngaytao);
        loadtblHDCT();

    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void tbldhCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbldhCTMouseClicked
        // TODO add your handling code here:
        int r = tbldhCT.getSelectedRow();
        if (r < 0) {
            return;
        }
        String tenmon = tbldhCT.getValueAt(r, 2).toString();
        String sl = tbldhCT.getValueAt(r, 3).toString();
        String thanhtien = tbldhCT.getValueAt(r, 4).toString();
        txtSP.setText(tenmon);
        txtSL.setText(sl);
        txtThanhTien.setText(thanhtien);
    }//GEN-LAST:event_tbldhCTMouseClicked

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnInhoadonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInhoadonActionPerformed
        // TODO add your handling code here:
        String MaHD = txtMaHD.getText();
        String TenMon = txtSP.getText();
        DonHang dh = dhdao.findById(idDH);
        KhuyenMai km = dh.getIdKhuyenMai();
        KhuyenMai khuyenmai = kmdao.getbyMaKM(km.getMaGiamGia());
        int so = khuyenmai.getPhanTram();
        double giam = so * 0.01;
        BigDecimal phantram = new BigDecimal(giam);
        BigDecimal tiengiam = tienthaydoi.multiply(phantram);
        tiendoi = tienthaydoi.subtract(tiengiam);
//        HoaDon hd = new HoaDon();
//        hd.setMaHd(MaHD);
//        hd.setTrangThai(1);
//        String update = hddao.UpdateTrangThaiban(hd);
        DLThanhToan thanhtoan = new DLThanhToan(TrangChu.main, true, tiendoi, TenBan, MaBan, idDH, MaHD, date, TenMon, MaDH, tienthaydoi, MaNV);
        // ThanhToanJP thanhtoan = new ThanhToanJP(tiendoi, TenBan, MaBan, idDH, MaHD, date, TenMon, MaDH, tienthaydoi);

        thanhtoan.setVisible(true);

        //HoaDonJDialog.
        this.dispose();
    }//GEN-LAST:event_btnInhoadonActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:
//      
        HoaDon hd = hddao.getIDByMaHD(txtMaHD.getText());
        BigDecimal giaBan = new BigDecimal(txtThanhTien.getText());
//        

        DHCTBanHangCustom dhctview = dhctdao.GetIDDHCT(txtSP.getText(), MaDH);
        int idonhangct = dhctview.getId();
        DonHangChiTiet dhct = dhctdao.findById(idonhangct);

        HoaDonChiTiet hdct = new HoaDonChiTiet();
        hdct.setSoLuong(Integer.parseInt(txtSL.getText()));
        hdct.setDonGia(giaBan);
        hdct.setIdDonHangChiTiet(dhct);
        hdct.setIdHoaDon(hd);

//        HoaDonChiTiet hoaDonChiTiet = hdctdao.getByIDDHCT(idonhangct);
//        DonHangChiTiet donhangct = hoaDonChiTiet.getIdDonHangChiTiet();
//        int id = donhangct.getId();
////         
//        if (id != 0) {
//            JOptionPane.showMessageDialog(this, "Món ăn đã được lưu");
//            return;
//        } else {
//            String insert = hdctdao.addOrUpdate(hdct);
//             loadtblHDCT();
//        }
        String insert = hdctdao.addOrUpdate(hdct);
        loadtblHDCT();
        clean();

    }//GEN-LAST:event_btnLuuActionPerformed

    private void tblhdctMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblhdctMouseClicked
        // TODO add your handling code here:
        int r = tblhdct.getSelectedRow();
        if (r < 0) {
            return;
        }
        String tenmon = tblhdct.getValueAt(r, 2).toString();
        String sl = tblhdct.getValueAt(r, 3).toString();
        String thanhtien = tblhdct.getValueAt(r, 4).toString();
        int idhdct = (int) tblhdct.getValueAt(r, 1);
        txtSP.setText(tenmon);
        txtSL.setText(sl);
        txtThanhTien.setText(thanhtien);


    }//GEN-LAST:event_tblhdctMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        int r = tblhdct.getSelectedRow();
        if (r < 0) {
            return;
        }
        int idhdct = (int) tblhdct.getValueAt(r, 1);
        BigDecimal giaBan = new BigDecimal(txtThanhTien.getText());
        HoaDonChiTiet hdct = new HoaDonChiTiet();
        hdct.setId(idhdct);
        hdct.setDonGia(giaBan);
        hdct.setSoLuong(Integer.parseInt(txtSL.getText()));
        String update = hdctdao.UpdateChiTiet(hdct);
        loadtblHDCT();
    }//GEN-LAST:event_btnSuaActionPerformed
    public void insert() {
        DefaultTableModel model = (DefaultTableModel) tbldhCT.getModel();
        DefaultTableModel model2 = (DefaultTableModel) tblhdct.getModel();
        int row = model.getRowCount();
        int row2 = model2.getRowCount();
//        MonAn ma = tddao.getIdByTenMon((String) model.getValueAt(row, 2));
        DonHang dh = dhdao.getDHByMaDH(lblmadh.getText());
        List<DonHangChiTiet> list = dhctdao.getListByIDDH(dh.getId());
        for (int i = 0; i < list.size(); i++) {
            // List<DonHangChiTiet> list = dhctdao.getDHCT(dh.getId(), ma.getId());
            DonHangChiTiet donhangct = dhctdao.findById(list.get(i).getId());
            HoaDon hd = hddao.getIDByMaHD(txtMaHD.getText());
            HoaDonChiTiet hdct = new HoaDonChiTiet();
            hdct.setIdDonHangChiTiet(donhangct);
            hdct.setIdHoaDon(hd);
            hdct.setDonGia(list.get(i).getDonGia());
            hdct.setSoLuong(list.get(i).getSoLuong());
            String insert = hdctdao.insert(hdct);
            loadtblHDCT();
        }

    }
    private void btnAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllActionPerformed
        // TODO add your handling code here:
        insert();
        clean();
    }//GEN-LAST:event_btnAllActionPerformed

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
//            java.util.logging.Logger.getLogger(HoaDonJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(HoaDonJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(HoaDonJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(HoaDonJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                HoaDonJDialog dialog = new HoaDonJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAll;
    private javax.swing.JButton btnInhoadon;
    private javax.swing.JButton btnLapHoaDon;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThoat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblGiaTien;
    private javax.swing.JLabel lblMaBan;
    private javax.swing.JLabel lblMaNV;
    private javax.swing.JLabel lblMakm;
    private javax.swing.JLabel lblmadh;
    private javax.swing.JLabel lblngayTao;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tbldhCT;
    private javax.swing.JTable tblhdct;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtSL;
    private javax.swing.JTextField txtSP;
    private javax.swing.JTextField txtThanhTien;
    // End of variables declaration//GEN-END:variables
}
