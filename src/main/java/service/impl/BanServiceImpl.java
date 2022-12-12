/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import custom.BanCustom;
import entity.Ban;
import entity.KhuVuc;
import java.util.ArrayList;
import java.util.List;
import repository.ICommonRepository;
import repository.impl.BanRepositoryImpl;
import repository.impl.KhuVucRepositoryImpl;
import service.ICommonService;

/**
 *
 * @author admin
 */
public class BanServiceImpl implements ICommonService<BanCustom> {

    private BanRepositoryImpl repo;
    private KhuVucRepositoryImpl KhuVucRepo;
    private List<BanCustom> list;

    public BanServiceImpl() {
        repo = new BanRepositoryImpl();
        list = new ArrayList<>();
        KhuVucRepo = new KhuVucRepositoryImpl();
    }

    @Override
    public List<BanCustom> findByKey(String key) {
        return this.repo.findByKey(key);
    }

    @Override
    public String addOrUpdate(BanCustom t) {
        String mess = "";
        KhuVuc khuVuc = KhuVucRepo.findById(t.getKhuVuc());
        if (this.repo.addOrUpdate(new Ban(t.getId(), t.getMaBan(),
                t.getSoLuongChoNgoi(), t.getTrangThai(), khuVuc))) {
            mess = "Thanh cong";
        } else {
            mess = "That bai";
        }
        return mess;
    }

    public BanCustom Getban(String ma) {
        return this.repo.Getban(ma);
    }

    public List<BanCustom> getkhuvuc(int idkv) {
        return this.repo.getkhuvuc(idkv);
    }

    public List<Ban> getAll() {
        return this.repo.getAll();
    }

    public String UpdateBan(Ban ban) {

        if (this.repo.UpdateBan(ban)) {
            return "Thanh cong";
        }
        return "That bai";
    }

    public Ban findById(int id) {
        return this.repo.findById(id);
    }

    public Ban getIDbyMa(String maBan) {
        return this.repo.getIDbyMa(maBan);
    }
     public Ban getBanByKV(String maban, String tenkv){
         return this.repo.getBanByKV(maban, tenkv);
     }
       public List<BanCustom> GetbanByTrangThai(int tt){
         return this.repo.GetbanByTrangThai(tt);
     }
       public String checkInfor(BanCustom ban1, BanCustom ban2){
        if (ban1.getId() == 0){
            if (ban1.getMaBan().trim().equals("")){
                return "Mã bàn trống";
            } else if (getIDbyMa(ban1.getMaBan()) != null){
                return "Mã bàn đã tồn tại";
            } else {
                return "OK";
            }
        } else {
            if (ban1.getMaBan().trim().equals("")){
                return "Mã bàn trống";
            } else {
                Ban banCheck = getIDbyMa(ban2.getMaBan());
                if (banCheck == null){
                    return "OK";
                } else if (ban1.getMaBan().equals(ban2.getMaBan())){
                    return "OK";
                } else {
                    return "Mã bàn đã tồn tại";
                }
            }
        }
    }
    
    public String checkNumber(String number){
        String matches = "^[0-9]{1,}$";
        if (number.trim().equals("")){
            return "Số lượng trống";
        } else if (!number.matches(matches)){
            return "Số lượng sai định dạng";
        }else if(Integer.parseInt(number)<=0){
             return "Số lượng sai định dạng";
        }
        return "OK";
    }
    public List<Ban> findBan(String key) {
        return this.repo.findBan(key);
    }
    public int genMaHD(){
        return repo.genMaHD();
    }
      public String Update(Ban ban) {

        if (this.repo.Update(ban)) {
            return "Thanh cong";
        }
        return "That bai";
    }
       public List<Ban> GetTrangThai(int tt){
           return repo.GetTrangThai(tt);
       }
}
