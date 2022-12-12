/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import custom.NhanVienCustom;
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
public class NhanVienRepositoryImpl implements ICommonRepository<NhanVien, NhanVienCustom> {

    @Override
    public boolean addOrUpdate(NhanVien t) {
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
    public List<NhanVienCustom> findByKey(String key) {
        List<NhanVienCustom> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select new custom.NhanVienCustom(a.id, a.maNV, "
                    + " a.email, a.gioiTinh, a.hoTenNV, a.ngaySinh, "
                    + "a.sdt, a.diaChi, a.thanhPho, a.trangThai, a.vaiTro) FROM NhanVien a"
                    + " WHERE a.maNV LIKE CONCAT('%',:ma,'%') OR a.hoTenNV LIKE CONCAT('%',:hoTen,'%')";
            TypedQuery<NhanVienCustom> query = session.createQuery(hql, NhanVienCustom.class);
            query.setParameter("ma", key);
            query.setParameter("hoTen", key);
            list = query.getResultList();
        }
        return list;
    }

    public NhanVienCustom getNhanVien(String user, String pass) {
        NhanVienCustom nhanVien = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select new custom.NhanVienCustom(a.id, a.maNV, "
                    + "a.matKhau, a.email, a.gioiTinh, a.hoTenNV, a.ngaySinh, "
                    + "a.sdt, a.diaChi, a.thanhPho, a.trangThai, a.vaiTro) FROM NhanVien a"
                    + " WHERE a.maNV = :ma and a.matKhau = :matKhau";
            TypedQuery<NhanVienCustom> query = session.createQuery(hql, NhanVienCustom.class);
            query.setParameter("ma", user);
            query.setParameter("matKhau", pass);
            nhanVien = query.getSingleResult();
        }
        return nhanVien;
    }
    
    public NhanVienCustom getNhanVienEmail(String user, String email) {
        NhanVienCustom nhanVien = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select new custom.NhanVienCustom(a.id, a.maNV, "
                    + "a.matKhau, a.email, a.gioiTinh, a.hoTenNV, a.ngaySinh, "
                    + "a.sdt, a.diaChi, a.thanhPho, a.trangThai, a.vaiTro) FROM NhanVien a"
                    + " WHERE a.maNV = :ma AND a.email = :email";
            TypedQuery<NhanVienCustom> query = session.createQuery(hql, NhanVienCustom.class);
            query.setParameter("ma", user);
            query.setParameter("email", email);
            nhanVien = query.getSingleResult();
        }
        return nhanVien;
    }

    @Override
    public NhanVien findById(int id) {
        NhanVien nhanVien = new NhanVien();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select a FROM NhanVien a"
                    + " WHERE a.id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            nhanVien = (NhanVien) query.getSingleResult();
        }
        return nhanVien;
    }
     public NhanVien findByMa(String manv) {
        NhanVien nhanVien = new NhanVien();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select a FROM NhanVien a"
                    + " WHERE a.maNV = :manv";
            Query query = session.createQuery(hql);
            query.setParameter("manv", manv);
            nhanVien = (NhanVien) query.getSingleResult();
        }
        return nhanVien;
    }
     public NhanVienCustom getNhanVienByUser(String user) {
        NhanVienCustom nhanVien = new NhanVienCustom();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select new custom.NhanVienCustom(a.id, a.maNV, "
                    + "a.matKhau, a.email, a.gioiTinh, a.hoTenNV, a.ngaySinh, "
                    + "a.sdt, a.diaChi, a.thanhPho, a.trangThai, a.vaiTro) FROM NhanVien a"
                    + " WHERE a.maNV = :ma";
            TypedQuery<NhanVienCustom> query = session.createQuery(hql, NhanVienCustom.class);
            query.setParameter("ma", user);
            nhanVien = (NhanVienCustom) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
        return nhanVien;
    }

    public NhanVienCustom getNhanVienByEmail(String email) {
        NhanVienCustom nhanVien = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select new custom.NhanVienCustom(a.id, a.maNV, "
                    + "a.matKhau, a.email, a.gioiTinh, a.hoTenNV, a.ngaySinh, "
                    + "a.sdt, a.diaChi, a.thanhPho, a.trangThai, a.vaiTro) FROM NhanVien a"
                    + " WHERE a.email = :email";
            TypedQuery<NhanVienCustom> query = session.createQuery(hql, NhanVienCustom.class);
            query.setParameter("email", email);
            nhanVien = query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
        return nhanVien;
    }
    
    public NhanVienCustom getNhanVienByEmail(String email, int id) {
        NhanVienCustom nhanVien = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select new custom.NhanVienCustom(a.id, a.maNV, "
                    + "a.matKhau, a.email, a.gioiTinh, a.hoTenNV, a.ngaySinh, "
                    + "a.sdt, a.diaChi, a.thanhPho, a.trangThai, a.vaiTro) FROM NhanVien a"
                    + " WHERE a.email = :email and a.id <> :id";
            TypedQuery<NhanVienCustom> query = session.createQuery(hql, NhanVienCustom.class);
            query.setParameter("email", email);
            query.setParameter("id", id);
            nhanVien = query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
        return nhanVien;
    }
    public NhanVienCustom getNhanVienByPassword(String pass) {
        NhanVienCustom nhanVien = new NhanVienCustom();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select new custom.NhanVienCustom(a.id, a.maNV, "
                    + "a.matKhau, a.email, a.gioiTinh, a.hoTenNV, a.ngaySinh, "
                    + "a.sdt, a.diaChi, a.thanhPho, a.trangThai, a.vaiTro) FROM NhanVien a"
                    + " WHERE a.matKhau = :pass ";
            TypedQuery<NhanVienCustom> query = session.createQuery(hql, NhanVienCustom.class);
            query.setParameter("pass", pass);
            nhanVien = query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
        return nhanVien;
    }
   
    public NhanVienCustom getNhanVienByPhone(String phone) {
        NhanVienCustom nhanVien = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select new custom.NhanVienCustom(a.id, a.maNV, "
                    + "a.matKhau, a.email, a.gioiTinh, a.hoTenNV, a.ngaySinh, "
                    + "a.sdt, a.diaChi, a.thanhPho, a.trangThai, a.vaiTro) FROM NhanVien a"
                    + " WHERE a.sdt = :phone";
            TypedQuery<NhanVienCustom> query = session.createQuery(hql, NhanVienCustom.class);
            query.setParameter("phone", phone);
            nhanVien = query.getSingleResult();
} catch (Exception e) {
            return null;
        }
        return nhanVien;
    }
    public List<NhanVienCustom> getNhanVienByPhone(String phone, int id) {
        List<NhanVienCustom> nhanVien = null;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "Select new custom.NhanVienCustom(a.id, a.maNV, "
                    + "a.matKhau, a.email, a.gioiTinh, a.hoTenNV, a.ngaySinh, "
                    + "a.sdt, a.diaChi, a.thanhPho, a.trangThai, a.vaiTro) FROM NhanVien a"
                    + " WHERE a.sdt = :phone and a.id <> :id";
            TypedQuery<NhanVienCustom> query = session.createQuery(hql, NhanVienCustom.class);
            query.setParameter("phone", phone);
            query.setParameter("id", id);
            nhanVien = query.getResultList();
        } catch (Exception e) {
            return null;
        }
        return nhanVien;
    }
    public List<NhanVien> getAll() {
        List<NhanVien> lists = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession();) {
            Query query = session.createQuery("From NhanVien");
            lists = query.getResultList();
        }  catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return lists;
    }
     public boolean UpdateNhanVien(NhanVien nv) {
        try {
            Session session = HibernateUtil.getFACTORY().openSession();
            Transaction tran = session.beginTransaction();
            String hql = "UPDATE NhanVien SET hoTenNV =: ten,gioiTinh =: gt,diaChi =:dc, thanhPho =: tp,sdt =: sdt,email =: email,ngaySinh =:ngay"
                    + ", trangThai =: tt  WHERE id = :id";
            Query query = session.createQuery(hql);
         
            query.setParameter("ten", nv.getHoTenNV());
            query.setParameter("gt", nv.getGioiTinh());
            query.setParameter("tp", nv.getThanhPho());
            query.setParameter("dc",nv.getDiaChi());
            query.setParameter("sdt",nv.getSdt());
           query.setParameter("email",nv.getEmail());
           query.setParameter("ngay",nv.getNgaySinh());
            //query.setParameter("vt", nv.get);
            query.setParameter("tt", nv.getTrangThai());
            query.setParameter("id", nv.getId());
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
