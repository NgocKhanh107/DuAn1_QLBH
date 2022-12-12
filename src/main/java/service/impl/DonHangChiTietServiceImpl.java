/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import custom.DHCTBanHangCustom;
import custom.DonHangChiTietCustom;
import custom.NhanVienCustom;
import entity.DonHangChiTiet;
import entity.NhanVien;
import java.util.ArrayList;
import java.util.List;
import repository.ICommonRepository;
import repository.impl.DonHangChiTietRepositoryImpl;
import repository.impl.NhanVienRepositoryImpl;
import service.ICommonService;
import util.Validate;

/**
 *
 * @author admin
 */
public class DonHangChiTietServiceImpl implements ICommonService<DonHangChiTietCustom> {

    private DonHangChiTietRepositoryImpl repo;
    private List<NhanVienCustom> list;

    public DonHangChiTietServiceImpl() {
        repo = new DonHangChiTietRepositoryImpl();
        list = new ArrayList<>();
    }

    @Override
    public String addOrUpdate(DonHangChiTietCustom t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DonHangChiTietCustom> findByKey(String key) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
     public DonHangChiTiet findById(int id){
         return this.repo.findById(id);
     }
    public List<DHCTBanHangCustom> getDSOder(int idDH) {
        return this.repo.getDSOder(idDH);
    }
    
    public String xoamon(int iddh, int idtd) {
        if (this.repo.xoamon(iddh, idtd)) {
            return "Thanh cong";
        }
        return "That bai";
    }
    
    public DHCTBanHangCustom GetDsChiTiet(String mamon, String maban) {
        return this.repo.GetDsChiTiet(mamon, maban);
    }
    public DHCTBanHangCustom GetIDDHCT(String tenMon, String maDH){
          return this.repo.GetIDDHCT(tenMon, maDH);
      }
    public String UpdateChiTiet(DonHangChiTiet dhct){
        if (this.repo.UpdateChiTiet(dhct)) {
            return "Thanh cong";
        }
        return "That bai";
    }
     public String insert (DonHangChiTiet t) {
        if(!this.repo.addOrUpdate(t)){
           return "Thất bại";
       }
       return "Thành công";
    }
     public List<DonHangChiTiet> getListByIDDH(int iddh){
           return this.repo.getListByIDDH(iddh);
       }
      public List<DonHangChiTiet> getDHCT(int iddh, int idmonan){
          return this.repo.getDHCT(iddh, idmonan);
      }
       public String xoadhct(int iddhct){
         if (!this.repo.delete(iddhct)) {
            return "That bai";
        }
        return "Thanh cong";
       
     }
       public DonHangChiTiet findByMa(String mamon){
        return repo.findByMa(mamon);
    } 
       public DonHangChiTiet getDS(int iddh, int idmonan){
           return repo.getDS(iddh, idmonan);
       }
       public String xoaByIDDH(int iddh){
        if(!repo.deleteByIDDH(iddh)){
            return "That bai";
        }
        return "Thanhcong";
    }
}
