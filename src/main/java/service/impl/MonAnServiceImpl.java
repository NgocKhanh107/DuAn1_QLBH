/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import custom.MonAnCustom;
import entity.DanhMuc;
import entity.DonHang;
import entity.MonAn;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import repository.ICommonRepository;
import repository.impl.BanRepositoryImpl;
import repository.impl.KhuyenMaiRepositoryImpl;
import repository.impl.MonAnRepositoryImpl;
import service.ICommonService;

/**
 *
 * @author admin
 */
public class MonAnServiceImpl implements ICommonService<MonAnCustom> {

    private MonAnRepositoryImpl repo;
    private DanhMucService danhMucService;

    public MonAnServiceImpl() {
        repo = new MonAnRepositoryImpl();
        danhMucService = new DanhMucService();
    }

    @Override
    public List<MonAnCustom> findByKey(String key) {
        return this.repo.findByKey(key);
    }

    @Override
    public String addOrUpdate(MonAnCustom t) {
        String mess;
        DanhMuc danhMuc = danhMucService.getById(t.getIdDanhMuc());
        if (this.repo.addOrUpdate(new MonAn(t.getId(), t.getMaMon(), t.getTenMon()
                , t.getDonViTinh(), t.getHinhAnh(), t.getDonGia(), t.getGhiChu()
                , t.getTrangThai(), danhMuc))) {
            mess = "Thanh cong";
        }else{
            mess = "That bai";
        }
        return mess;
    }

    public MonAn getById(int id){
        return this.repo.findById(id);
    }
    
    public List<MonAn> getAll(){
        return this.repo.getAll();
    }
    
    public MonAn getIdByMa(String key) {
        return this.repo.getIdByMa(key);
    }
     public List<MonAn> GetThucDon(String key){
         return this.repo.GetThucDon(key);
     }
     public List<MonAn> TimKiem(String key){
         return this.repo.TimKiem(key);
     }
    public MonAn getIdByTenMon(String key){
         return this.repo.getIdBytenMon(key);
     } 
    public List<MonAnCustom> getListMonAnSort() {
        return this.repo.getListMonAnSort();
    }
    
    public List<MonAnCustom> getListMonAnSortByDay(Date date1, Date date2) {
        return this.repo.getListMonAnSortByDay(date1, date2);
    }
     public String UpdateMon(MonAn ma) {

        if (this.repo.UpdateMon(ma)) {
            return "Thanh cong";
        }
        return "That bai";
    }
}
