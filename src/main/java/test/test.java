/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import custom.DHCTBanHangCustom;
import custom.HDCTBanHang;
import custom.HDCTBanHangCustom;
import custom.NhanVienCustom;
import entity.DonHang;
import entity.DonHangChiTiet;
import entity.HoaDon;
import entity.MonAn;
import java.util.List;
import repository.impl.NhanVienRepositoryImpl;
import service.impl.DonHangChiTietServiceImpl;
import service.impl.DonHangServiceImpl;
import service.impl.HoaDonChiTietServiceImpl;
import service.impl.HoaDonServiceImpl;
import service.impl.MonAnServiceImpl;
import service.impl.NhanVienServiceImpl;

/**
 *
 * @author ngocKhanh
 */
public class test {
    public static void main(String[] args) {
//        HoaDonChiTietServiceImpl serviceHdct = new HoaDonChiTietServiceImpl();
//        List<HDCTBanHangCustom> listsHDCT  =serviceHdct.getDSHDCT(2);
//        //System.out.println("test.test.main()");
//        System.out.println(listsHDCT.get(0).getTenMon());
//        NhanVienRepositoryImpl nv = new NhanVienRepositoryImpl();
//        NhanVienCustom nhanvien = nv.getNhanVienEmail("NV02", "khanhdnph27550@fpt.edu.vn");
//        System.out.println(nhanvien.getHoTenNV());
        
        NhanVienServiceImpl nv1 = new NhanVienServiceImpl();
        NhanVienCustom nv2 = nv1.getNhanVienEmail("NV02", "khanhdnph27550@fpt.edu.vn");
        System.out.println(nv2.getHoTenNV());
//        HoaDonServiceImpl hd = new HoaDonServiceImpl();
//        HoaDon h = hd.getIDByMaHD("HD02");
//        System.out.println(h.getId());
//            DonHangServiceImpl donhangdao = new DonHangServiceImpl();
//            DonHangChiTietServiceImpl dhctdao = new DonHangChiTietServiceImpl();
//            MonAnServiceImpl thucdondao = new MonAnServiceImpl();
//          DonHang  arrhd = donhangdao.getDHbyMa("BA15");;
//        List<DHCTBanHangCustom> order= dhctdao.getDSOder(arrhd.getId());
//       // System.out.println(order);
//           for (DHCTBanHangCustom dHCT : order) {
//                 if(dHCT.getMaMon().equals("Mon02") ){
//                      MonAn ma = thucdondao.getIdByMa("Mon02");
//            DonHangChiTiet donhangct = dhctdao.getDS(arrhd.getId(),ma.getId());
//                     System.out.println(donhangct.getId());
                   // System.out.println(ma.getId());
                 //}
//                 }else{
//                     System.out.println("test.test.main()");
//                 }
               
         //  }
       
    }
}
