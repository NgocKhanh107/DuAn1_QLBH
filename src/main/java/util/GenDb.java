package util;

import entity.Ban;
import entity.DanhMuc;
import entity.DonHang;
import entity.DonHangChiTiet;
import entity.HoaDon;
import entity.HoaDonChiTiet;
import entity.KhuVuc;
import entity.KhuyenMai;
import entity.MonAn;
import entity.NhanVien;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Properties;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import static util.HibernateUtil.getConfiguration;

public class GenDb {

    public static void main(String[] args) {
        Properties prop = HibernateUtil.getProperties();
        prop.put(Environment.HBM2DDL_AUTO, "create");

        //Tạo đối tượng ServiceRegistry từ Hibernate.cfg.xml
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
                applySettings(prop).build();

        //Tạo lớp giao tiếp với JDBC
        Configuration conf = getConfiguration(prop);
        SessionFactory factory = conf.buildSessionFactory(serviceRegistry);
        Session session = factory.openSession();
        // tạo giao dịch tương ứng 
        Transaction trans = session.beginTransaction();
        
        //Khu vực
        KhuVuc kv1 = new KhuVuc();
        kv1.setMaKV("KV01");
        kv1.setTenKV("Khu Vuc A");
        kv1.setTrangThai(0);
        session.save(kv1);
        
        KhuVuc kv2 = new KhuVuc();
        kv2.setMaKV("KV02");
        kv2.setTenKV("Khu Vuc B");
        kv2.setTrangThai(0);
        session.save(kv2);
        
        //Bàn
        Ban ban1 = new Ban();
        ban1.setMaBan("BA01");
        ban1.setTrangThai(1);
        ban1.setSoLuongChoNgoi(6);
        ban1.setIdKhuVuc(kv2);
        session.save(ban1);

        Ban ban2 = new Ban();
        ban2.setMaBan("BA02");
        ban2.setTrangThai(1);
        ban2.setSoLuongChoNgoi(4);
        ban2.setIdKhuVuc(kv1);
        session.save(ban2);

        // Danh mục 
        DanhMuc danhMuc1 = new DanhMuc();
        danhMuc1.setMaLoai("Loai01");
        danhMuc1.setTenLoai("Mon Han");
        session.save(danhMuc1);

        DanhMuc danhMuc2 = new DanhMuc();
        danhMuc2.setMaLoai("Loai02");
        danhMuc2.setTenLoai("Mon Au");
        session.save(danhMuc2);

        // Nhân viên
        NhanVien nhanVien1 = new NhanVien();
        nhanVien1.setHoTenNV("HoangNguyen");
        nhanVien1.setDiaChi("Ninh Binh");
        nhanVien1.setEmail("hoangntph19818@fpt.edu.vn");
        nhanVien1.setGioiTinh(0);
        nhanVien1.setMaNV("NV01");
        nhanVien1.setNgaySinh(Date.valueOf("1995-07-01"));
        nhanVien1.setSdt("0333613132");
        nhanVien1.setMatKhau("hnt123");
        nhanVien1.setTrangThai(0);
        nhanVien1.setVaiTro(true);
        session.save(nhanVien1);

        NhanVien nhanVien2 = new NhanVien();
        nhanVien2.setHoTenNV("KhanhDo");
        nhanVien2.setDiaChi("Thanh Hoa");
        nhanVien2.setEmail("khanhdqph21233@fpt.edu.vn");
        nhanVien2.setGioiTinh(0);
        nhanVien2.setMaNV("NV02");
        nhanVien2.setNgaySinh(Date.valueOf("2003-01-05"));
        nhanVien2.setSdt("0333123446");
        nhanVien2.setMatKhau("dnk123");
        nhanVien2.setTrangThai(1);
        nhanVien2.setVaiTro(false);
        session.save(nhanVien2);

        // Khuyến mãi
        KhuyenMai khuyenMai1 = new KhuyenMai();
        khuyenMai1.setMaGiamGia("KM01");
        khuyenMai1.setNgayBatDau(Date.valueOf("2022-11-10"));
        khuyenMai1.setNgayKetThuc(Date.valueOf("2022-11-15"));
        khuyenMai1.setPhanTram(10);
        session.save(khuyenMai1);

        KhuyenMai khuyenMai2 = new KhuyenMai();
        khuyenMai2.setMaGiamGia("KM02");
        khuyenMai2.setNgayBatDau(Date.valueOf("2022-11-20"));
        khuyenMai2.setNgayKetThuc(Date.valueOf("2022-11-25"));
        khuyenMai2.setPhanTram(15);
        session.save(khuyenMai2);

        // Đơn hàng
        DonHang donHang1 = new DonHang();
        donHang1.setIdBan(ban2);
        donHang1.setIdKhuyenMai(khuyenMai2);
        donHang1.setIdNhanVien(nhanVien2);
        donHang1.setMaDH("DH01");
        donHang1.setNgayTao(Date.valueOf("2022-11-10"));
        donHang1.setTrangThai(0);
        session.save(donHang1);

        DonHang donHang2 = new DonHang();
        donHang2.setIdBan(ban1);
        donHang2.setIdKhuyenMai(khuyenMai1);
        donHang2.setIdNhanVien(nhanVien1);
        donHang2.setMaDH("DH02");
        donHang2.setNgayTao(Date.valueOf("2022-11-11"));
        donHang2.setTrangThai(1);
        session.save(donHang2);

        // Thực đơn
        MonAn monAn1 = new MonAn();
        monAn1.setMaMon("Mon01");
        monAn1.setDanhMuc(danhMuc2);
        monAn1.setDonViTinh("Dia");
        monAn1.setHinhAnh("abc");
        monAn1.setDonGia(BigDecimal.valueOf(200000));
        monAn1.setTenMon("Thit cho 36 mon");
        session.save(monAn1);

        MonAn monAn2 = new MonAn();
        monAn2.setMaMon("Mon02");
        monAn2.setDanhMuc(danhMuc1);
        monAn2.setDonViTinh("Goi");
        monAn2.setHinhAnh("abc");
        monAn2.setDonGia(BigDecimal.valueOf(500000));
        monAn2.setTenMon("Thit Dui 36 mon");
        session.save(monAn2);

        // Hóa đơn
        HoaDon hoaDon1 = new HoaDon();
        hoaDon1.setIdDonHang(donHang2);
        hoaDon1.setMaHd("HD01");
        hoaDon1.setNgayTao(Date.valueOf("2022-11-11"));
        hoaDon1.setTrangThai(0);
        session.save(hoaDon1);

        HoaDon hoaDon2 = new HoaDon();
        hoaDon2.setIdDonHang(donHang1);
        hoaDon2.setMaHd("HD02");
        hoaDon2.setNgayTao(Date.valueOf("2022-11-12"));
        hoaDon2.setTrangThai(0);
        session.save(hoaDon2);

        // Đơn hàng CT
        DonHangChiTiet dhct1 = new DonHangChiTiet();
        dhct1.setIdDonHang(donHang2);
        dhct1.setIdMonAn(monAn2);
        dhct1.setSoLuong(5);
        dhct1.setDonGia(BigDecimal.valueOf(500000));
        session.save(dhct1);

        DonHangChiTiet dhct2 = new DonHangChiTiet();
        dhct2.setIdDonHang(donHang1);
        dhct2.setIdMonAn(monAn1);
        dhct2.setSoLuong(2);
        dhct2.setDonGia(BigDecimal.valueOf(200000));
        session.save(dhct2);

        // Hóa đơn chi tiết
        HoaDonChiTiet hdct1 = new HoaDonChiTiet();
        hdct1.setIdDonHangChiTiet(dhct2);
        hdct1.setIdHoaDon(hoaDon2);
        hdct1.setSoLuong(1);
        hdct1.setDonGia(BigDecimal.valueOf(500000));
        session.save(hdct1);
        
        HoaDonChiTiet hdct2 = new HoaDonChiTiet();
        hdct2.setIdDonHangChiTiet(dhct1);
        hdct2.setIdHoaDon(hoaDon1);
        hdct2.setSoLuong(1);
        hdct2.setDonGia(BigDecimal.valueOf(200000));
        session.save(hdct2);
        
        trans.commit();
    }
}
