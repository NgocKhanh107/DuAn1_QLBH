package repository.impl;

import custom.DanhMucCustom;
import entity.DanhMuc;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.ICommonRepository;
import util.HibernateUtil;

public class DanhMucRepository implements ICommonRepository<DanhMuc, DanhMucCustom> {

    @Override
    public boolean addOrUpdate(DanhMuc t) {
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Transaction trans = session.getTransaction();
            trans.begin();
            try {
                session.saveOrUpdate(t);
                trans.commit();
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                trans.rollback();
                return false;
            }
        }
    }

    @Override
    public List<DanhMucCustom> findByKey(String key) {
        List<DanhMucCustom> lists = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("SELECT new custom.DanhMucCustom("
                    + "a.id, a.maLoai, a.tenLoai, a.trangThai)  FROM DanhMuc a WHERE "
                    + "a.maLoai LIKE CONCAT('%',:ma,'%') OR a.tenLoai LIKE CONCAT('%',:ten,'%')");
            query.setParameter("ma", key);
            query.setParameter("ten", key);
            lists = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lists;
    }

    public DanhMuc getById(int id) {
        DanhMuc danhMuc = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("SELECT a FROM DanhMuc a WHERE "
                    + "a.id = :id ");
            query.setParameter("id", id);
            danhMuc = (DanhMuc) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhMuc;
    }

    @Override
    public DanhMuc findById(int id) {
        DanhMuc danhMuc = new DanhMuc();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select a FROM DanhMuc a"
                    + " WHERE a.id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            danhMuc = (DanhMuc) query.getSingleResult();
        }
        return danhMuc;
    }
     public List<DanhMuc> getAll() {
        List<DanhMuc> lists = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession();) {
            Query query = session.createQuery("select a from DanhMuc a where a.trangThai = 0 ");
            lists = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return lists;
    }
      public boolean UpdateBan(DanhMuc dm) {
        try {
            Session session = HibernateUtil.getFACTORY().openSession();
            Transaction tran = session.beginTransaction();
            String hql = "UPDATE DanhMuc SET  trangThai =:tt , tenLoai =: tenloai  WHERE id = :id";
            Query query = session.createQuery(hql);
            //query.setParameter("maloai", dm.getMaLoai());
            query.setParameter("tt", dm.getTrangThai());
            query.setParameter("tenloai", dm.getTenLoai());
            query.setParameter("id", dm.getId());
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
      public DanhMuc getByTenDM(String ten) {
        DanhMuc danhMuc = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("SELECT a FROM DanhMuc a WHERE "
                    + "a.tenLoai = :ten ");
            query.setParameter("ten", ten);
            danhMuc = (DanhMuc) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhMuc;
    }
}
