/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import custom.DanhMucCustom;
import entity.DanhMuc;
import java.util.ArrayList;
import java.util.List;
import repository.ICommonRepository;
import repository.impl.DanhMucRepository;
import service.ICommonService;

/**
 *
 * @author admin
 */
public class DanhMucService implements ICommonService<DanhMucCustom> {

    private DanhMucRepository _repodanhmuc;
    List<DanhMucCustom> _lstDanhMuc;

    public DanhMucService() {
        _repodanhmuc = new DanhMucRepository();
        _lstDanhMuc = new ArrayList<>();
    }

    DanhMuc getdanhmuc(DanhMucCustom danhmucc) {
        DanhMuc danhmuc = new DanhMuc();

        danhmuc.setId(danhmucc.getId());
        danhmuc.setMaLoai(danhmucc.getMaLoai());
        danhmuc.setTenLoai(danhmucc.getTenLoai());
        danhmuc.setTrangThai(danhmucc.getTrangThai());

        return danhmuc;
    }

    @Override
    public String addOrUpdate(DanhMucCustom t) {
        String mess = "";
        if (this._repodanhmuc.addOrUpdate(getdanhmuc(t))) {
            mess = "Thanh cong";
        } else {
            mess = "That bai";
        }
        return mess;
    }

    @Override
    public List<DanhMucCustom> findByKey(String key) {
        return this._repodanhmuc.findByKey(key);
    }
    
    public DanhMuc getById(int id) {
        return this._repodanhmuc.getById(id);
    }
     public List<DanhMuc> getLists(){
         return  this._repodanhmuc.getAll();
     }
      public String UpdateBan(DanhMuc dm) {

        if (this._repodanhmuc.UpdateBan(dm)) {
            return "Thanh cong";
        }
        return "That bai";
    }
      public DanhMuc getByTenDM(String ten){
          return _repodanhmuc.getByTenDM(ten);
      }
}
