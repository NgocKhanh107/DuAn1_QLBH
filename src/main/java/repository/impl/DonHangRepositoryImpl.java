/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import custom.DonHangCustom;
import custom.NhanVienCustom;
import entity.DonHang;
import entity.NhanVien;
import java.util.ArrayList;
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
public class DonHangRepositoryImpl implements ICommonRepository<DonHang, DonHangCustom> {

    @Override
    public boolean addOrUpdate(DonHang t) {
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
    public List<DonHangCustom> findByKey(String key) {
        List<DonHangCustom> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select new custom.DonHangCustom(a.id, a.maDH, "
                    + "a.ngayTao, a.ngayDatBan, a.trangThai, a.ghiChu, a.idBan.id, "
                    + "a.idNhanVien.id, a.idKhuyenMai.id) FROM DonHang a"
                    + " WHERE a.maDH LIKE CONCAT('%',:ma,'%') ";
            TypedQuery<DonHangCustom> query = session.createQuery(hql, DonHangCustom.class);
            query.setParameter("ma", key);
            query.setParameter("hoTen", key);
            list = query.getResultList();
        }
        return list;
    }

    public DonHangCustom getDonHangByMa(String maBan) {
        DonHangCustom donHang = new DonHangCustom();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select new custom.DonHangCustom(a.id, a.maDH, "
                    + "a.ngayTao, a.ngayDatBan, a.trangThai, a.ghiChu, a.idBan.id, "
                    + "a.idNhanVien.id, a.idKhuyenMai.id) FROM DonHang a"
                    + " WHERE a.idBan.maBan = :maBan AND a.trangThai = :tt";
            TypedQuery<DonHangCustom> query = session.createQuery(hql, DonHangCustom.class);
            query.setParameter("maBan", maBan);
            query.setParameter("tt", 0);
            donHang = query.getSingleResult();
        }
        return donHang;
    }

    public boolean updateDonHangGiamGia(DonHang dh) {
        try {
            Session session = HibernateUtil.getFACTORY().openSession();
            Transaction tran = session.beginTransaction();
            String hql = "UPDATE DonHang SET idKhuyenMai = :km WHERE maDH = :maDH";
            TypedQuery query = session.createQuery(hql);
            query.setParameter("km", dh.getIdKhuyenMai());
            query.setParameter("maDH", dh.getMaDH());
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

    @Override
    public DonHang findById(int id) {
        DonHang donHang = new DonHang();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select a FROM DonHang a"
                    + " WHERE a.id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            donHang = (DonHang) query.getSingleResult();
        }
        return donHang;
    }
     public List<DonHang> getAll() {
        List<DonHang> lists = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession();) {
            Query query = session.createQuery("From DonHang");
            lists = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return lists;
    }
     public DonHang getDHbyMa(String maban) {
        DonHang donHang = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            try {
                String hql = "SELECT a FROM DonHang a WHERE a.idBan.maBan =: ma and a.trangThai =: tt";
                TypedQuery<DonHang> query = session.createQuery(hql, DonHang.class);
                query.setParameter("ma", maban);
                query.setParameter("tt", 0);
                donHang = query.getSingleResult();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return donHang;
    }
      public DonHang getDH(String maban) {
        DonHang donHang = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT a FROM DonHang a WHERE a.idBan.maBan =: ma ";
            TypedQuery<DonHang> query = session.createQuery(hql, DonHang.class);
            query.setParameter("ma", maban);
            //query.setParameter("tt", 0);
            donHang = query.getSingleResult();
        }
        return donHang;
    }

      public boolean updateDonHang(DonHang dh) {
        try {
            Session session = HibernateUtil.getFACTORY().openSession();
            Transaction tran = session.beginTransaction();
            String hql = "UPDATE DonHang SET trangThai = :tt WHERE id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("tt", 1);
            query.setParameter("id", dh.getId());
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
      public boolean deleteDHTamThoi(String MaDHGop){
        try {     
             Session session = HibernateUtil.getFACTORY().openSession(); 
             Transaction tran = session.beginTransaction();
            String hql = "Delete from DonHang a WHERE a.maDH = :ma";
            Query query = session.createQuery(hql);
            query.setParameter("ma", MaDHGop);
           
            
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
       public DonHang getDHByMaDH(String madh) {
        DonHang donHang = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT a FROM DonHang a WHERE a.maDH=: ma ";
            TypedQuery<DonHang> query = session.createQuery(hql, DonHang.class);
            query.setParameter("ma", madh);
            //query.setParameter("tt", 0);
            donHang = query.getSingleResult();
        }
        return donHang;
    }
       public List<DonHang> getListDHMa(String maban) {
        List<DonHang> list = new ArrayList<>();
        String hql;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {

            hql = "select a  FROM DonHang a WHERE a.idBan.maBan =: ma and a.trangThai =: tt";
            //String hql = "select a from Ban a WHERE a.id = :id ";
            Query query = session.createQuery(hql);
            query.setParameter("ma", maban);
            query.setParameter("tt", 0);
            list = query.getResultList();
        }
        return list;
    }
}
