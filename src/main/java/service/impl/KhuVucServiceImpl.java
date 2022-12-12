/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import custom.KhuVucCustom;
import entity.KhuVuc;
import java.util.ArrayList;
import java.util.List;
import repository.ICommonRepository;
import repository.impl.KhuVucRepositoryImpl;
import repository.impl.NhanVienRepositoryImpl;
import service.ICommonService;
import util.Validate;

/**
 *
 * @author admin
 */
public class KhuVucServiceImpl implements ICommonService<KhuVucCustom> {

    private KhuVucRepositoryImpl repo;

    public KhuVucServiceImpl() {
        repo = new KhuVucRepositoryImpl();
    }

    @Override
    public List<KhuVucCustom> findByKey(String key) {
        return this.repo.findByKey(key);
    }

    @Override
    public String addOrUpdate(KhuVucCustom t) {  
        String mess = "";
        if (this.repo.addOrUpdate(new KhuVuc(t.getId(), t.getMaKV(), t.getTenKV(), t.getTrangThai()))) {
            mess = "Thanh cong";
        }else{
            mess = "That bai";
        }
        return mess;
    }
    
    public KhuVuc getById(int id) {
        return this.repo.findById(id);
    }
     public List<KhuVuc> getLists() {
       return this.repo.getAll();
    }
      public KhuVuc getByTen(String ten){
        return this.repo.getByTen(ten);
    }
      public  KhuVuc getByMa(String maKV){
          return repo.findByMA(maKV);
      }
      public String checkInfor(KhuVucCustom khuVuc1, KhuVucCustom khuVuc2) {
        if (khuVuc1.getId() == 0) {
            if (khuVuc1.getMaKV().trim().equals("")) {
                return "Mã khu vực trống";
            } else if (getByMa(khuVuc1.getMaKV()) != null) {
                return "Mã khu vực đã tồn tại";
            } else if (khuVuc1.getTenKV().trim().equals("")) {
                return "Tên khu vực trống";
            } else {
                return "OK";
            }
        } else {
            if (khuVuc1.getMaKV().trim().equals("")) {
                return "Mã khu vực trống";
            } else if (khuVuc1.getTenKV().trim().equals("")) {
                return "Tên khu vực trống";
            } else {
                KhuVuc khuVucCheck = getByMa(khuVuc2.getMaKV());
                if (khuVucCheck == null) {
                    return "OK";
                } else if (khuVuc1.getMaKV().equals(khuVuc2.getMaKV())) {
                    return "OK";
                } else {
                    return "Mã khu vực đã tồn tại";
                }
            }
        }
    }
      public String Update(KhuVuc kv) {

        if (this.repo.Update(kv)) {
            return "Thanh cong";
        }
        return "That bai";
    }
}
