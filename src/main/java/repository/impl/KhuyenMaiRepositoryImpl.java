/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import custom.KhuyenMaiCustom;
import entity.KhuyenMai;
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
public class KhuyenMaiRepositoryImpl implements ICommonRepository<KhuyenMai, KhuyenMaiCustom> {

    @Override
    public boolean addOrUpdate(KhuyenMai t) {
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
    public List<KhuyenMaiCustom> findByKey(String key) {
        List<KhuyenMaiCustom> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT new custom.KhuyenMaiCustom(a.id, a.maGiamGia"
                    + ", a.phanTram, a.ngayBatDau, a.ngayKetThuc, a.trangThai)"
                    + " FROM KhuyenMai a WHERE a.maGiamGia LIKE CONCAT('%',:ma,'%') ";
            TypedQuery<KhuyenMaiCustom> query = session.createQuery(hql, KhuyenMaiCustom.class);
            query.setParameter("ma", key);
            list = query.getResultList();
        }
        return list;
    }

    @Override
    public KhuyenMai findById(int id) {
        KhuyenMai khuyenMai = new KhuyenMai();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select a FROM KhuyenMai a"
                    + " WHERE a.id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            khuyenMai = (KhuyenMai) query.getSingleResult();
        }
        return khuyenMai;
    }

    public List<KhuyenMai> getAll() {
        List<KhuyenMai> lists = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession();) {
            Query query = session.createQuery("From KhuyenMai");
            lists = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return lists;
    }

    public KhuyenMai getIDbyPhanTram(int phanTram) {
        KhuyenMai km = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "select a from KhuyenMai a WHERE a.phanTram = :phanTram ";
            TypedQuery<KhuyenMai> query = session.createQuery(hql, KhuyenMai.class);
            query.setParameter("phanTram", phanTram);

            km = query.getSingleResult();
        }
        return km;
    }
    public KhuyenMai getbyMaKM (String makm){
        KhuyenMai km = null;
         try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "select a from KhuyenMai a WHERE a.maGiamGia = :maGiamGia ";
           TypedQuery<KhuyenMai> query = session.createQuery(hql, KhuyenMai.class);
            query.setParameter("maGiamGia", makm);
          
            km =  query.getSingleResult();
        }
        return km;
    }
    public boolean UpdateKM(KhuyenMai km) {
        try {
            Session session = HibernateUtil.getFACTORY().openSession();
            Transaction tran = session.beginTransaction();
            String hql = "UPDATE KhuyenMai SET  trangThai =:tt , phanTram =: phantram, ngayBatDau =: ngaybd, ngayKetThuc =: ngaykt  WHERE id = :id";
            Query query = session.createQuery(hql);
            //query.setParameter("maloai", dm.getMaLoai());
            query.setParameter("tt", km.getTrangThai());
            query.setParameter("phantram", km.getPhanTram());
            query.setParameter("ngaybd", km.getNgayBatDau());
            query.setParameter("ngaykt", km.getNgayKetThuc());
            query.setParameter("id", km.getId());
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
     public List<KhuyenMai> getKhuyenMai( Date date1) {
        List<KhuyenMai> lists = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession();) {
            String hql = "select a from KhuyenMai a where a.ngayKetThuc >= : date1 and a.ngayBatDau <=: date1";
            TypedQuery<KhuyenMai> query = session.createQuery(hql, KhuyenMai.class);
            query.setParameter("date1", date1);
            lists = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return lists;
    }
}
