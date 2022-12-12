/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import custom.HDCTBanHang;
import custom.HDCTBanHangCustom;
import custom.HoaDonChiTietCustom;
import custom.HoaDonCustom;
import entity.HoaDon;
import entity.HoaDonChiTiet;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import repository.ICommonRepository;
import util.HibernateUtil;

/**
 *
 * @author admin
 */
public class HoaDonChiTietRepositoryImpl implements ICommonRepository<HoaDonChiTiet, HoaDonChiTietCustom>{

    @Override
    public boolean addOrUpdate(HoaDonChiTiet t) {
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
    public List<HoaDonChiTietCustom> findByKey(String key) {
        List<HoaDonChiTietCustom> result = null;
        String hql;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            hql = "select custom.HoaDonChiTietCustom(a.id, a.soLuong, a.donGia,"
                    + "a.idDonHangChiTiet.id, a.idHoaDon.id) "
                    + "From Ban a WHERE a.idHoaDon.id LIKE CONCAT('%',:ma,'%')";
            Query query = session.createQuery(hql);
            query.setParameter("ma", key);
            result = query.getResultList();
        }

        return result;
    }
    
    public List<HoaDonChiTiet> getAll(){
        List<HoaDonChiTiet> lists = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession();) {
            javax.persistence.Query query = session.createQuery("From HoaDonChiTiet");
            lists = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return lists;
    }

    @Override
    public HoaDonChiTiet findById(int id) {
        HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select a FROM HoaDonChiTiet a"
                    + " WHERE a.id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            hoaDonChiTiet = (HoaDonChiTiet) query.getSingleResult();
        }
        return hoaDonChiTiet;
    }
    
    public List<HDCTBanHang> getHDCTByHD(String key) {
        List<HDCTBanHang> result = null;
        String hql;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            hql = "select new custom.HDCTBanHang(c.maMon, c.tenMon, a.DonGia, a.soLuong) "
                    + "From HoaDonChiTiet a Left join DonHangChiTiet b ON a.idDonHangChiTiet.id = b.id "
                    + "Left join MonAn c ON b.idMonAn.id = c.id "
                    + "Left join HoaDon d ON d.id = a.idHoaDon where d.maHd = :ma";
            Query query = session.createQuery(hql);
            query.setParameter("ma", key);
            result = query.getResultList();
            
        }

        return result;
    }
     public List<HDCTBanHangCustom> getDSHDCT(int idhd) {
         List<HDCTBanHangCustom> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()){           
           
            String hql = "SELECT new custom.HDCTBanHangCustom"
                    + "(a.id,a.idDonHangChiTiet.idMonAn.tenMon, a.soLuong, a.DonGia) "
                    + " FROM HoaDonChiTiet a WHERE a.idHoaDon.id =: idhd";
            Query query = session.createQuery(hql);
            query.setParameter("idhd", idhd);
            list = query.getResultList();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
     }
     public boolean UpdateChiTiet(HoaDonChiTiet dhct){
         try {     
             Session session = HibernateUtil.getFACTORY().openSession(); 
             Transaction tran = session.beginTransaction();
            String hql = "UPDATE HoaDonChiTiet SET soLuong = :soLuong,DonGia =:donGia  WHERE id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("soLuong", dhct.getSoLuong());
            query.setParameter("donGia", dhct.getDonGia());
            query.setParameter("id", dhct.getId());
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
     public BigDecimal getTongTien() {
        BigDecimal tongTien = new BigDecimal(0);
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select sum(a.soLuong * a.DonGia) FROM HoaDonChiTiet a"
                    + " LEFT JOIN HoaDon b"
                    + " ON a.idHoaDon.id = b.id"
                    + " WHERE b.trangThai = 0";
            Query query = session.createQuery(hql);
            tongTien = (BigDecimal) query.getSingleResult();
        }
        return tongTien;
    }

    public long getTongSPDaBan() {
        long tongSPDaBan = 0;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT sum(m.soLuong) FROM HoaDonChiTiet m";
            Query query = session.createQuery(hql);
            tongSPDaBan = (long) query.getSingleResult();
        }
        return tongSPDaBan;
    }

    public BigDecimal getTongTienByDay(Date date1, Date date2) {
        BigDecimal tongTien = new BigDecimal(0);
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select sum(a.soLuong * a.DonGia) FROM HoaDonChiTiet a"
                    + " LEFT JOIN HoaDon b"
                    + " ON a.idHoaDon.id = b.id"
                    + " WHERE b.trangThai = 0 AND b.ngayTao between :date1 AND :date2";
            Query query = session.createQuery(hql);
            query.setParameter("date1", date1);
            query.setParameter("date2", date2);
            tongTien = (BigDecimal) query.getSingleResult();
        }
        return tongTien;
    }

    public long getTongSPDaBanByDay(Date date1, Date date2) {
        long tongSPDaBan = 0;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT sum(m.soLuong) FROM HoaDonChiTiet m LEFT JOIN "
                    + " HoaDon b ON m.idHoaDon.id = b.id WHERE b.trangThai = 0 "
                    + " AND b.ngayTao between :date1 AND :date2";
            Query query = session.createQuery(hql);
            query.setParameter("date1", date1);
            query.setParameter("date2", date2);
            tongSPDaBan = (long) query.getSingleResult();
        }
        return tongSPDaBan;
    }
}
