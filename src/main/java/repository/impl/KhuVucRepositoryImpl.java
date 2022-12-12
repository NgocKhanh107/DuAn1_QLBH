/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import custom.KhuVucCustom;
import entity.KhuVuc;
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
public class KhuVucRepositoryImpl implements ICommonRepository<KhuVuc, KhuVucCustom> {

    @Override
    public boolean addOrUpdate(KhuVuc t) {
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
    public List<KhuVucCustom> findByKey(String key) {
        List<KhuVucCustom> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select new custom.KhuVucCustom(a.id, a.maKV, "
                    + "a.tenKV, a.trangThai) FROM KhuVuc a"
                    + " WHERE a.maKV LIKE CONCAT('%',:ma,'%') OR a.tenKV LIKE CONCAT('%',:hoTen,'%')";
            TypedQuery<KhuVucCustom> query = session.createQuery(hql, KhuVucCustom.class);
            query.setParameter("ma", key);
            query.setParameter("hoTen", key);
            list = query.getResultList();
        }
        return list;
    }

    @Override
    public KhuVuc findById(int id) {
        KhuVuc khuVuc = new KhuVuc();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select a FROM KhuVuc a"
                    + " WHERE a.id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            khuVuc = (KhuVuc) query.getSingleResult();
        }
        return khuVuc;
    }
    public List<KhuVuc> getAll() {
       List<KhuVuc> lists = new ArrayList<KhuVuc>();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT m FROM KhuVuc m";
            TypedQuery<KhuVuc> query = session.createQuery(hql, KhuVuc.class);
            lists = query.getResultList();
        }
        return lists;
    }
    public KhuVuc getByTen(String ten){
        KhuVuc kv = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "select a from KhuVuc a WHERE a.tenKV = :tenKV ";
            TypedQuery<KhuVuc> query = session.createQuery(hql, KhuVuc.class);
            query.setParameter("tenKV", ten);

            kv = query.getSingleResult();
        }
        return kv;
    }
    public KhuVuc findByMA(String maKV) {
        KhuVuc khuVuc = new KhuVuc();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select a FROM KhuVuc a"
                    + " WHERE a.maKV = :maKV";
            Query query = session.createQuery(hql);
            query.setParameter("maKV", maKV);
            khuVuc = (KhuVuc) query.getSingleResult();
            return khuVuc;
        } catch (Exception e) {
            return null;
        }
    }
     public boolean Update(KhuVuc kv) {
        try {
            Session session = HibernateUtil.getFACTORY().openSession();
            Transaction tran = session.beginTransaction();
            String hql = "UPDATE KhuVuc SET trangThai =:tt, tenKV =: tenKV  WHERE id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("tt", kv.getTrangThai());
            query.setParameter("tenKV", kv.getTenKV());
           
            query.setParameter("id", kv.getId());
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
}
