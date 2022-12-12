/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import custom.BanCustom;
import custom.KhuyenMaiCustom;
import entity.Ban;
import entity.KhuVuc;
import entity.KhuyenMai;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import repository.ICommonRepository;
import repository.impl.BanRepositoryImpl;
import repository.impl.KhuyenMaiRepositoryImpl;
import service.ICommonService;

/**
 *
 * @author admin
 */
public class KhuyenMaiServiceImpl implements ICommonService<KhuyenMaiCustom> {

    private KhuyenMaiRepositoryImpl repo;

    public KhuyenMaiServiceImpl() {
        repo = new KhuyenMaiRepositoryImpl();
    }

    @Override
    public List<KhuyenMaiCustom> findByKey(String key) {
        return this.repo.findByKey(key);
    }

    @Override
    public String addOrUpdate(KhuyenMaiCustom t) {
        String mess = "";
        if (this.repo.addOrUpdate(new KhuyenMai(t.getId(), t.getMaKM(),
                t.getPhanTram(), t.getNgayBatDau(), t.getNgayKetThuc(), t.getTrangThai()))) {
            mess = "Thanh cong";
        } else {
            mess = "That bai";
        }
        return mess;
    }

    public List<KhuyenMai> getAll() {
        return this.repo.getAll();
    }
    
    public KhuyenMai getIDbyPhanTram(int phanTram) {
        return this.repo.getIDbyPhanTram(phanTram);
    }
    public KhuyenMai getbyMaKM (String makm){
        return this.repo.getbyMaKM(makm);
    }
     public String Update(KhuyenMai km) {

        if (this.repo.UpdateKM(km)) {
            return "Thanh cong";
        }
        return "That bai";
    }
     public List<KhuyenMai> getKhuyenMai( Date date1){
         return repo.getKhuyenMai(date1);
     }
}
