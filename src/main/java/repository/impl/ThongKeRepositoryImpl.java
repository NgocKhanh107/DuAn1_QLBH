/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository.impl;

import custom.MonAnCustom;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

/**
 *
 * @author hieu
 */
public class ThongKeRepositoryImpl {
    
    public BigDecimal TongTien2() {
        BigDecimal a =  new BigDecimal(0);
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT SUM (H.soLuong * H.DonGia) \n"
                    + "From HoaDonChiTiet H \n"
                    + " join HoaDon S on H.idHoaDon = S.id\n"
                    + "where S.trangThai = 1 ";
                    //+ "where MONTH(HD.ThoiGianTao) = MONTH(GETDATE()) AND HD.TrangThai = 2 OR HD.TrangThai = 3";
            try {
                Query<?> query = session.createQuery(hql);
                session.beginTransaction();
                session.getTransaction().commit();
               a = (BigDecimal) query.uniqueResult();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Không có dữ liệu thống kê");
            }
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return a;
    }
    
     public BigDecimal TongTienHomNay() {
        BigDecimal a =  new BigDecimal(0);
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT SUM (H.soLuong * H.DonGia) \n"
                    + "From HoaDonChiTiet H \n"
                    + " join HoaDon S on H.idHoaDon = S.id\n"
                    + "where DAY(S.ngayThanhToan) = DAY(GETDATE()) ";
            try {
                Query<?> query = session.createQuery(hql);
                session.beginTransaction();
                session.getTransaction().commit();
               a = (BigDecimal) query.uniqueResult();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Không có dữ liệu thống kê");
            }
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return a;
    }
    
    public long TongTien3() {
        long a = 0;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT count (S.id) \n"
                    + "From HoaDon S  \n"
//                    + " join HoaDon S on H.idHoaDon = S.id\n"
                    + "where S.trangThai = 1 ";
                    
            try {
                Query<?> query = session.createQuery(hql);
                session.beginTransaction();
                session.getTransaction().commit();
                a =  (long) query.uniqueResult();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Không có dữ liệu thống kê ");
            }
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return a;
    }
    
      public long Tonghoadontrongngay() {
        long a = 0;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT COUNT (S.id) \n"
                    + "From HoaDon S \n"
                   // + " join HoaDon S on H.idHoaDon = S.id\n"
                     + "where DAY(S.ngayThanhToan) = DAY(GETDATE()) AND S.trangThai = 1 ";
            try {
                Query<?> query = session.createQuery(hql);
                session.beginTransaction();
                session.getTransaction().commit();
                a =  (long) query.uniqueResult();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Không có dữ liệu thống kê ");
            }
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return a;
    }
    
    public long Tonghoadonngay(Date date1, Date date2) {
        long a = 0;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT COUNT (S.id) \n"
                    + "From HoaDon S \n"
                   // + " join HoaDon S on H.idHoaDon = S.id\n"
                    + "where CONVERT(date, S.ngayThanhToan) >= :date1 and CONVERT(date, S.ngayThanhToan) <= :date2 AND S.trangThai = 1 ";
            try {
                Query<?> query = session.createQuery(hql);
                query.setParameter("date1",date1);
                query.setParameter("date2",date2);
                session.beginTransaction();
                session.getTransaction().commit();
                a =  (long) query.uniqueResult();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Không có dữ liệu thống kê ");
            }
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return a;
    }
    
      public long TongTien4() {
        long a = 0;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT SUM (H.soLuong) \n"
                    + "From HoaDonChiTiet H \n"
                    + " join HoaDon S on H.idHoaDon = S.id\n" 
                    + "where S.trangThai = 1 ";
            try {
                Query<?> query = session.createQuery(hql);
                session.beginTransaction();
                session.getTransaction().commit();
                a =  (long) query.uniqueResult();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Không có dữ liệu thống kê ");
            }
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return a;
    }
         
      
        public long TongTientheongay(Date date1, Date date2) {
        long a = 0;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT SUM (H.soLuong) \n"
                    + "From HoaDonChiTiet H \n"
                    + " join HoaDon S on H.idHoaDon = S.id\n"
                    + "where CONVERT(date, S.ngayThanhToan) >= :date1 and CONVERT(date, S.ngayThanhToan) <= :date2";
            try {
                Query<?> query = session.createQuery(hql);
                query.setParameter("date1",date1);
                query.setParameter("date2",date2);
//                session.beginTransaction();
//                session.getTransaction().commit();
                a =  (long) query.uniqueResult();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Không có dữ liệu thống kê ");
            }
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return a;
    }
        
        public BigDecimal Tongtien1theongay(Date date1, Date date2) {
        BigDecimal a = new BigDecimal(0);
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT SUM (H.soLuong * H.DonGia) \n"
                    + "From HoaDonChiTiet H \n"
                    + " join HoaDon S on H.idHoaDon = S.id\n"
                    + "where CONVERT(date, S.ngayThanhToan) >= :date1 and CONVERT(date, S.ngayThanhToan) <= :date2";
            try {
                Query<?> query = session.createQuery(hql);
                query.setParameter("date1",date1);
                query.setParameter("date2",date2);
//                session.beginTransaction();
//                session.getTransaction().commit();
                a =  (BigDecimal) query.uniqueResult();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Không có dữ liệu thống kê ");
            }
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return a;
    }
        
        
        
        
        
        public List<Object[]> thongke4(int top) {
        List<Object[]> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = " SELECT  S.id, S.maMon,S.tenMon,S.donGia,Sum(HD.soLuong)\n " 
                    + "From MonAn S\n"
                    + "Inner join DonHangChiTiet H on S.id = H.idMonAn\n"
                    + "Inner join HoaDonChiTiet HD on H.id = HD.idDonHangChiTiet\n"
                    + "Inner join HoaDon HDD on HD.idHoaDon = HDD.id\n"
                    + "where HDD.trangThai = 1 "
                    
                    + "group by S.id, S.maMon,S.tenMon,S.donGia\n"
                    + "order by maMon desc ";
            Query<?> query = session.createQuery(hql).setMaxResults(top);
            //query.setParameter("top", top);
            session.beginTransaction();
            session.getTransaction().commit();

            list = (List<Object[]>) query.getResultList();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
        
        
       public List<Object[]> thongke5(int top) {
        List<Object[]> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = " SELECT  S.tenMon\n " 
                    + "From MonAn S\n"
                    + "Inner join DonHangChiTiet H on S.id = H.idMonAn\n"
                    + "Inner join HoaDonChiTiet HD on H.id = HD.idDonHangChiTiet\n"
                    + "Inner join HoaDon HDD on HD.idHoaDon = HDD.id\n"
                   // + "where DAY(HDD.ngayTao) = DAY(GETDATE()) "
                    + "group by S.id, S.maMon,S.tenMon\n"
                    + "order by maMon desc ";
            Query<?> query = session.createQuery(hql).setMaxResults(top);
            //query.setParameter("top", top);
            session.beginTransaction();
            session.getTransaction().commit();

            list = (List<Object[]>) query.getResultList();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
      
    public List<Object[]> thongketrongngay() {
        List<Object[]> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = " SELECT  S.id, S.maMon,S.tenMon,S.donGia,sum(HD.soLuong)\n " 
                    + "From MonAn S\n"
                    + "Inner join DonHangChiTiet H on S.id = H.idMonAn\n"
                    + "Inner join HoaDonChiTiet HD on H.id = HD.idDonHangChiTiet\n"
                    + "Inner join HoaDon HDD on HD.idHoaDon = HDD.id\n"
                    + "where DAY(HDD.ngayThanhToan) = DAY(GETDATE()) "
                    + "group by S.id, S.maMon,S.tenMon,S.donGia\n"
                    + "order by maMon desc ";
            Query<?> query = session.createQuery(hql);
            session.beginTransaction();
            session.getTransaction().commit();

            list = (List<Object[]>) query.getResultList();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return list;
    } 
    
    public BigDecimal Tongtiencharttheongay(Date date1, Date date2) {
        BigDecimal a = new BigDecimal(0);
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT SUM (H.soLuong * H.DonGia) \n"
                    + "From HoaDonChiTiet H \n"
                    + " join HoaDon S on H.idHoaDon = S.id\n"
                    + "where CONVERT(date, S.ngayThanhToan) >= :date1 and CONVERT(date, S.ngayThanhToan) <= :date2";
            try {
                Query<?> query = session.createQuery(hql);
                query.setParameter("date1",date1);
                query.setParameter("date2",date2);
//                session.beginTransaction();
//                session.getTransaction().commit();
                a =  (BigDecimal) query.uniqueResult();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Không có dữ liệu thống kê ");
            }
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return a;
    }
    
    public List<Object[]> thongketheodate(Date date1, Date date2) {
        List<Object[]> list = new ArrayList<>();
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = " SELECT  S.id, S.maMon,S.tenMon,S.donGia,sum(HD.soLuong)\n " 
                    + "From MonAn S\n"
                    + "Inner join DonHangChiTiet H on S.id = H.idMonAn\n"
                    + "Inner join HoaDonChiTiet HD on H.id = HD.idDonHangChiTiet\n"
                    + "Inner join HoaDon HDD on HD.idHoaDon = HDD.id\n"
                    + " where CONVERT(date, HDD.ngayThanhToan) >= :date1 and CONVERT(date, HDD.ngayThanhToan) <= :date2 AND  HDD.trangThai = 1   "
                    + "group by S.id, S.maMon,S.tenMon,S.donGia\n"
                    + "order by maMon desc ";
            Query<?> query = session.createQuery(hql);
            query.setParameter("date1",date1);
                query.setParameter("date2",date2);
            session.beginTransaction();
            session.getTransaction().commit();

            list = (List<Object[]>) query.getResultList();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return list;
    } 
    
    public long Tonghmghomnay() {
        long a = 0;
        try ( Session session = HibernateUtil.getFACTORY().openSession()) {
            String hql = "SELECT SUM (H.soLuong) \n"
                    + "From HoaDonChiTiet H \n"
                    + " join HoaDon S on H.idHoaDon = S.id\n"
                    + "where Day(S.ngayThanhToan) = DAY(GETDATE()) AND  S.trangThai = 1 ";
            try {
                Query<?> query = session.createQuery(hql);
                
                session.beginTransaction();
                session.getTransaction().commit();
                a =  (long) query.uniqueResult();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Không có dữ liệu thống kê ");
            }
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
        return a;
    }
}
