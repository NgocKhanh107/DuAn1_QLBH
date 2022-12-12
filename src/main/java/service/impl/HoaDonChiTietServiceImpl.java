/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import custom.HDCTBanHang;
import custom.HDCTBanHangCustom;
import custom.HoaDonChiTietCustom;
import custom.HoaDonCustom;
import entity.DonHang;
import entity.DonHangChiTiet;

import entity.HoaDon;
import entity.HoaDonChiTiet;
import entity.KhuVuc;
import entity.KhuyenMai;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import repository.ICommonRepository;
import repository.impl.BanRepositoryImpl;
import repository.impl.DonHangChiTietRepositoryImpl;
import repository.impl.DonHangRepositoryImpl;
import repository.impl.HoaDonChiTietRepositoryImpl;
import repository.impl.HoaDonRepositoryImpl;
import repository.impl.KhuyenMaiRepositoryImpl;
import service.ICommonService;

/**
 *
 * @author admin
 */
public class HoaDonChiTietServiceImpl implements ICommonService<HoaDonChiTietCustom> {

    private HoaDonChiTietRepositoryImpl repo;
    private DonHangChiTietRepositoryImpl repoDonHangCT;
    private HoaDonRepositoryImpl repoHoaDon;

    public HoaDonChiTietServiceImpl() {
        repo = new HoaDonChiTietRepositoryImpl();
        repoDonHangCT = new DonHangChiTietRepositoryImpl();
        repoHoaDon = new HoaDonRepositoryImpl();
    }

    @Override
    public List<HoaDonChiTietCustom> findByKey(String key) {
        return this.repo.findByKey(key);
    }

    @Override
    public String addOrUpdate(HoaDonChiTietCustom t) {
        String mess = "";
        DonHangChiTiet dhct = repoDonHangCT.findById(t.getIdDonHangChiTiet());
        HoaDon hoaDon = repoHoaDon.findById(t.getIdHoaDon());
        if (this.repo.addOrUpdate(new HoaDonChiTiet(t.getId(), t.getSoLuong(), 
                t.getDonGia(), dhct, hoaDon))) {
            mess  ="Thanh cong";
        }else{
            mess = "That bai";
        }
        return mess;
    }
     public String addOrUpdate(HoaDonChiTiet t) {
        if(!this.repo.addOrUpdate(t)){
           return "Thất bại";
       }
       return "Thành công";
    }
    public List<HoaDonChiTiet> getAll(){
        return this.repo.getAll();
    }

    public List<HDCTBanHang> getHDCTByHD(String key){
        return this.repo.getHDCTByHD(key);
    }
    public List<HDCTBanHangCustom> getDSHDCT(int idhd){
        return this.repo.getDSHDCT(idhd);
    }
     public String UpdateChiTiet(HoaDonChiTiet hdct){
        if (this.repo.UpdateChiTiet(hdct)) {
            return "Thanh cong";
        }
        return "That bai";
    }
     public BigDecimal getTongTien() {
        return this.repo.getTongTien();
    }

    public long getTongSPDaBan() {
        return this.repo.getTongSPDaBan();
    }

    public BigDecimal getTongTienByDay(Date date1, Date date2) {
        return this.repo.getTongTienByDay(date1, date2);
    }

    public long getTongSPDaBanByDay(Date date1, Date date2) {
        return this.repo.getTongSPDaBanByDay(date1, date2);
    }
     public String insert(HoaDonChiTiet t){
         if (this.repo.addOrUpdate(t)) {
            return "Thanh cong";
        }
        return "That bai";
     }
}
