/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import custom.HDBanhang;
import custom.HoaDonCustom;
import entity.HoaDon;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import repository.ICommonRepository;
import util.HibernateUtil;

/**
 *
 * @author admin
 */
public class HoaDonRepositoryImpl implements ICommonRepository<HoaDon, HoaDonCustom> {

    @Override
    public boolean addOrUpdate(HoaDon t) {
        boolean check = false;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction tran = session.beginTransaction();
            try {
                session.saveOrUpdate(t);
                tran.commit();
                check = true;
            } catch (Exception e) {
                e.printStackTrace();
                tran.rollback();
            }
        }
        return check;
    }

    @Override
    public List<HoaDonCustom> findByKey(String key) {
        List<HoaDonCustom> result = null;
        String hql;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            hql = "select custom.HoaDonCustom(a.id, a.maHD, a.ngayTao,"
                    + "a.ngayThanhToan, a.trangThai, a.ghiChu, a.idDonHang.id) "
                    + "From Ban a WHERE a.maHD LIKE CONCAT('%',:ma,'%')";
            Query query = session.createQuery(hql);
            query.setParameter("ma", key);
            result = query.getResultList();
        }

        return result;
    }

    public List<HoaDon> getAll() {
        List<HoaDon> lists = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession();) {
            javax.persistence.Query query = session.createQuery("From HoaDon");
            lists = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return lists;
    }

    @Override
    public HoaDon findById(int id) {
        HoaDon hoaDon = new HoaDon();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select a FROM HoaDon a"
                    + " WHERE a.id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            hoaDon = (HoaDon) query.getSingleResult();
        }
        return hoaDon;
    }

//    public List<HDBanhang> getListHDCustom(String ma) {
//        List<HDBanhang> list = new ArrayList<>();
//        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
//            String hql = "select new custom.HDBanhang(a.maHd, a.ngayTao, a.trangThai,"
//                    + "a.ghiChu, d.maGiamGia, c.maBan, n.maNV, e.maKV) From HoaDon a "
//                    + "LEFT JOIN DonHang b ON a.idDonHang.id = b.id "
//                    + "LEFT JOIN Ban c ON b.idBan.id = c.id "
//                    + "LEFT JOIN KhuyenMai d ON d.id = b.idKhuyenMai.id "
//                    + "LEFT JOIN KhuVuc e ON e.id = c.idKhuVuc.id "
//                    + "LEFT JOIN NhanVien n ON n.id = b.idNhanVien.id WHERE a.maHd LIKE CONCAT('%',:ma,'%')";
//            Query query = session.createQuery(hql);
//            query.setParameter("ma", ma);
//            list = query.getResultList();
//        }
//        return list;
//    }

     public List<HoaDon> getHDByMaDH(String madh){
          List<HoaDon> lists = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT m FROM HoaDon m where m.idDonHang.maDH =:madh and m.trangThai =: tt";
             Query query = session.createQuery(hql);
             query.setParameter("madh", madh);
             query.setParameter("tt", 0);
            lists = query.getResultList();
        }
        return lists;
     }
      public HoaDon getIDByMaHD(String mahd){
          HoaDon hd = new HoaDon();
          try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT m FROM HoaDon m where m.maHd =: mahd ";
             TypedQuery<HoaDon> query = session.createQuery(hql, HoaDon.class);
            query.setParameter("mahd", mahd);
           
            hd =  query.getSingleResult();
        }catch(Exception e){
            return null;
        }
         return hd;
      }
       public boolean UpdateTrangThaiban(HoaDon hd) {
        try {
            Session session = HibernateUtil.getFACTORY().openSession();
            Transaction tran = session.beginTransaction();
            String hql = "UPDATE HoaDon SET trangThai =:tt, ngayThanhToan =:ngay  WHERE maHd = :ma";
            Query query = session.createQuery(hql);
            query.setParameter("tt", hd.getTrangThai());
            query.setParameter("ngay", hd.getNgayThanhToan());
            query.setParameter("ma", hd.getMaHd());
            if (query.executeUpdate() < 1) {
                return false;
            }
            tran.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
       public HoaDon getByMaDH(String madh){
         HoaDon hd = null;
          try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT m FROM HoaDon m where m.idDonHang.maDH =:madh ";
             TypedQuery<HoaDon> query = session.createQuery(hql, HoaDon.class);
            query.setParameter("madh", madh);
            
            hd =  query.getSingleResult();
        }
         return hd;
     }
       public List<HDBanhang> getListHDByNgayTao(Date date1,Date date2) {
        List<HDBanhang> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "select new custom.HDBanhang(a.maHd, a.ngayTao, a.trangThai,"
                    + "a.ghiChu, d.maGiamGia, c.maBan, n.maNV, e.maKV) From HoaDon a "
                    + "LEFT JOIN DonHang b ON a.idDonHang.id = b.id "
                    + "LEFT JOIN Ban c ON b.idBan.id = c.id "
                    + "LEFT JOIN KhuyenMai d ON d.id = b.idKhuyenMai.id "
                    + "LEFT JOIN KhuVuc e ON e.id = c.idKhuVuc.id "
                    + "LEFT JOIN NhanVien n ON n.id = b.idNhanVien.id"
                    + " WHERE a.ngayTao >= :date1 AND a.ngayTao <= :date2";
            Query query = session.createQuery(hql);
            query.setParameter("date1", date1);
            query.setParameter("date2", date2);
            list = query.getResultList();
        }
        return list;
    }
       public long getTongHD() {
        long tongHd = 0;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT count(m.id) FROM HoaDon m where m.trangThai = 0";
            Query query = session.createQuery(hql);
            tongHd = (long) query.getSingleResult();
        }
        return tongHd;
    }

    public long getTongHDByDay(Date date1, Date date2) {
        long tongHd = 0;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT count(m.id) FROM HoaDon m where m.trangThai = 0"
                    + " AND m.ngayTao between :date1 and :date2";
            Query query = session.createQuery(hql);
            query.setParameter("date1", date1);
            query.setParameter("date2", date2);
            tongHd = (long) query.getSingleResult();
        }
        return tongHd;
    }
    public List<HDBanhang> getListHDCustom(String ma) {
        List<HDBanhang> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "select new custom.HDBanhang(a.maHd, a.ngayTao, a.trangThai,"
                    + "a.ghiChu, d.maGiamGia, c.maBan, n.maNV, e.maKV) From HoaDon a "
                    + "LEFT JOIN DonHang b ON a.idDonHang.id = b.id "
                    + "LEFT JOIN Ban c ON b.idBan.id = c.id "
                    + "LEFT JOIN KhuyenMai d ON d.id = b.idKhuyenMai.id "
                    + "LEFT JOIN KhuVuc e ON e.id = c.idKhuVuc.id "
                    + "LEFT JOIN NhanVien n ON n.id = b.idNhanVien.id"
                    + " WHERE a.maHd LIKE CONCAT('%',:maHD,'%') OR n.maNV LIKE CONCAT('%',:maNV,'%')";
            Query query = session.createQuery(hql);
            query.setParameter("maHD", ma);
            query.setParameter("maNV", ma);
            list = query.getResultList();
        }
        return list;
    }
}
