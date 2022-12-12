/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import custom.DHCTBanHangCustom;
import custom.DonHangChiTietCustom;
import custom.DonHangCustom;
import entity.DonHang;
import entity.DonHangChiTiet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import repository.ICommonRepository;
import util.HibernateUtil;

/**
 *
 * @author admin
 */
public class DonHangChiTietRepositoryImpl implements ICommonRepository<DonHangChiTiet, DonHangChiTietCustom> {

    @Override
    public boolean addOrUpdate(DonHangChiTiet t) {
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
    public List<DonHangChiTietCustom> findByKey(String key) {
        List<DonHangChiTietCustom> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select new custom.DonHangChiTietCustom(a.id, a.soLuong, "
                    + "a.donGia, a.idDonHang.id, a.idMonAn.id) FROM DonHangChiTiet a"
                    + " WHERE  a.idMonAn.maMon LIKE CONCAT('%',:monAn,'%')";
            TypedQuery<DonHangChiTietCustom> query = session.createQuery(hql, DonHangChiTietCustom.class);
            query.setParameter("monAn", key);
            list = query.getResultList();
        }
        return list;
    }

    public DonHangChiTietCustom getDonHang(String id) {
        DonHangChiTietCustom donHangChiTiet = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select new custom.DonHangChiTietCustom(a.id, a.soLuong, "
                    + "a.donGia, a.idDonHang.id, a.idMonAn.id) FROM DonHangChiTiet a"
                    + " WHERE  a.idMonAn.maMon LIKE CONCAT('%',:monAn,'%')";
            TypedQuery<DonHangChiTietCustom> query = session.createQuery(hql, DonHangChiTietCustom.class);
            query.setParameter("ma", id);
            donHangChiTiet = query.getSingleResult();
        }
        return donHangChiTiet;
    }

    @Override
    public DonHangChiTiet findById(int id) {
        DonHangChiTiet dhct = new DonHangChiTiet();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select a FROM DonHangChiTiet a"
                    + " WHERE a.id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            dhct = (DonHangChiTiet) query.getSingleResult();
        }
        return dhct;
    }
    public DonHangChiTiet findByMa(String mamon) {
        DonHangChiTiet dhct = new DonHangChiTiet();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select a FROM DonHangChiTiet a"
                    + " WHERE a.idMonAn.maMon = :mamon";
            Query query = session.createQuery(hql);
            query.setParameter("mamon", mamon);
            dhct = (DonHangChiTiet) query.getSingleResult();
        }
        return dhct;
    }

    public List<DHCTBanHangCustom> getDSOder(int idDH) {
        List<DHCTBanHangCustom> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT new custom.DHCTBanHangCustom"
                    + "(a.id,a.idMonAn.id,a.idMonAn.maMon, a.idMonAn.tenMon,"
                    + "a.idMonAn.donViTinh, a.soLuong, a.donGia, a.idDonHang.id) "
                    + " FROM DonHangChiTiet a WHERE a.idDonHang.id =: idDH";
            TypedQuery<DHCTBanHangCustom> query = session.createQuery(hql, DHCTBanHangCustom.class);
            query.setParameter("idDH", idDH);
            list = query.getResultList();
        }
        return list;
    }

    public boolean xoamon(int iddh, int idtd) {
        try {
            Session session = HibernateUtil.getFACTORY().openSession();
            Transaction tran = session.beginTransaction();
            String hql = "Delete from DonHangChiTiet a WHERE a.idDonHang.id = :iddh and a.idMonAn.id = : idtd";
            Query query = session.createQuery(hql);
            query.setParameter("iddh", iddh);
            query.setParameter("idtd", idtd);

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

    public DHCTBanHangCustom GetDsChiTiet(String mamon, String maban) {
        DHCTBanHangCustom dhct = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT new custom.DHCTBanHangCustom "
                    + "(a.soLuong, a.donGia,a.id)"
                    + " FROM DonHangChiTiet a "
                    + "where a.idMonAn.maMon =: ma and a.idDonHang.idBan.maBan =: maBan and a.idDonHang.trangThai =: tt";
            Query query = session.createQuery(hql);
            query.setParameter("ma", mamon);
            query.setParameter("maBan", maban);
            query.setParameter("tt", 0);
            dhct =  (DHCTBanHangCustom) query.getSingleResult();

        }
       
        return dhct;
    }
    public DHCTBanHangCustom GetIDDHCT(String tenMon, String maDH){
        DHCTBanHangCustom dhct = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT new custom.DHCTBanHangCustom "
                    + "(a.soLuong, a.donGia,a.id)"
                    + " FROM DonHangChiTiet a "
                    + "where a.idMonAn.tenMon =: tenMon and a.idDonHang.maDH =: maDH and a.idDonHang.trangThai =: tt";       
            Query query = session.createQuery(hql);
            query.setParameter("tenMon", tenMon);
            query.setParameter("maDH", maDH);
            query.setParameter("tt", 0);
            dhct =  (DHCTBanHangCustom) query.getSingleResult();
           
        }        
        return dhct;
    }
    
    public boolean UpdateChiTiet(DonHangChiTiet dhct){
         try {     
             Session session = HibernateUtil.getFACTORY().openSession(); 
             Transaction tran = session.beginTransaction();
            String hql = "UPDATE DonHangChiTiet SET soLuong = :soLuong,donGia =:donGia  WHERE id = :id";
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
    public List<DonHangChiTiet> getListByIDDH(int iddh){
         List<DonHangChiTiet> list = null;
          try(Session session = HibernateUtil.getFACTORY().openSession()){
                                              
            String hql ="SELECT a FROM DonHangChiTiet a where a.idDonHang.id = : iddh and a.idDonHang.trangThai =: tt ";
            
            Query query = session.createQuery(hql);
            query.setParameter("iddh", iddh);
            query.setParameter("tt", 0);
            list=   query.getResultList();
          }
         return list;
     }
    public List<DonHangChiTiet> getDHCT(int iddh, int idmonan){
        List<DonHangChiTiet> list = new ArrayList<>();
        try (Session session = HibernateUtil.getFACTORY().openSession()){           
            // Transaction tran = session.beginTransaction();
            String hql = "select a from DonHangChiTiet a where a.idDonHang.id = : iddh and a.idMonAn.id =: idmonan";
            Query query = session.createQuery(hql);
            query.setParameter("iddh", iddh);
            query.setParameter("idmonan", idmonan);
            list = query.getResultList();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public boolean delete(int iddhct) {
         try {
            Session session = HibernateUtil.getFACTORY().openSession();
            Transaction tran = session.beginTransaction();
            String hql = "DELETE FROM DonHangChiTiet a WHERE a.id = : iddhct";
            Query query = session.createQuery(hql);
            query.setParameter("iddhct", iddhct);
           

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
     public boolean deleteByIDDH(int iddh) {
         try {
            Session session = HibernateUtil.getFACTORY().openSession();
            Transaction tran = session.beginTransaction();
            String hql = "DELETE FROM DonHangChiTiet a WHERE a.idDonHang.id = : iddh";
            Query query = session.createQuery(hql);
            query.setParameter("iddh", iddh);
           

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
    public DonHangChiTiet getDS(int iddh, int idmonan){
        DonHangChiTiet list = null;
        try (Session session = HibernateUtil.getFACTORY().openSession()){           
            // Transaction tran = session.beginTransaction();
            String hql = "select a from DonHangChiTiet a where a.idDonHang.id = : iddh and a.idMonAn.id =: idmonan";
            Query query = session.createQuery(hql);
            query.setParameter("iddh", iddh);
            query.setParameter("idmonan", idmonan);
            list = (DonHangChiTiet) query.getSingleResult();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
