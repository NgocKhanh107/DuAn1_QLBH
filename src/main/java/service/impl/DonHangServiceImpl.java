/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import custom.DonHangCustom;
import custom.NhanVienCustom;
import entity.Ban;
import entity.DonHang;
import entity.KhuyenMai;
import entity.NhanVien;
import java.util.ArrayList;
import java.util.List;
import repository.ICommonRepository;
import repository.impl.BanRepositoryImpl;
import repository.impl.DonHangRepositoryImpl;
import repository.impl.KhuyenMaiRepositoryImpl;
import repository.impl.NhanVienRepositoryImpl;
import service.ICommonService;
import util.Validate;

/**
 *
 * @author admin
 */
public class DonHangServiceImpl implements ICommonService<DonHangCustom> {

    private DonHangRepositoryImpl repo;
    private BanRepositoryImpl repoBan;
    private NhanVienRepositoryImpl repoNhanVien;
    private KhuyenMaiRepositoryImpl repoKhuyenMai;

    public DonHangServiceImpl() {
        repo = new DonHangRepositoryImpl();
        repoBan = new BanRepositoryImpl();
        repoKhuyenMai = new KhuyenMaiRepositoryImpl();
        repoNhanVien = new NhanVienRepositoryImpl();
    }

    @Override
    public List<DonHangCustom> findByKey(String key) {
        return this.repo.findByKey(key);
    }

    @Override
    public String addOrUpdate(DonHangCustom t) {
        String mess;
        Ban ban = repoBan.findById(t.getIdBan());
        NhanVien nhanVien = repoNhanVien.findById(t.getIdNhanVien());
        KhuyenMai khuyenMai = repoKhuyenMai.findById(t.getIdKhuyenMai());
        if (this.repo.addOrUpdate(new DonHang(t.getId(), t.getMaDH(), t.getNgayTao(),
                 t.getNgayDatBan(), t.getTrangThai(), t.getGhiChu(), ban,
                nhanVien, khuyenMai))) {
            mess = "Thanh cong";
        } else {
            mess = "That bai";
        }
        return mess;
    }

    public DonHang findById(int id) {
        return repo.findById(id);
    }

    public DonHangCustom getDonHangByMa(String maBan) {
        return this.repo.getDonHangByMa(maBan);
    }

    public String updateDonHangGiamGia(DonHang dh) {
        if (this.repo.updateDonHangGiamGia(dh)) {
            return "Thanh cong";
        }
        return "That bai";
    }

    public List<DonHang> getLists() {
        return this.repo.getAll();
    }

    public String insert(DonHang dh) {
        if (!this.repo.addOrUpdate(dh)) {
            return "That bai";
        }
        return "Thanh cong";
    }

    public DonHang getDHbyMa(String ma) {
        return this.repo.getDHbyMa(ma);
    }

    public String updatedonhang(DonHang t) {
        if (!this.repo.updateDonHang(t)) {
            return "That bai";
        }
        return "Thanh cong";
    }

    public String deleteDHTamThoi(String MaDHGop) {
        if (!this.repo.deleteDHTamThoi(MaDHGop)) {
            return "That bai";
        }
        return "Thanh cong";
    }

    public DonHang getDHByMaDH(String madh) {
        return this.repo.getDHByMaDH(madh);
    }

    public List<DonHang> getListDHMa(String maban) {
        return this.repo.getListDHMa(maban);
    }

    public DonHang getDH(String maban) {
        return this.repo.getDH(maban);
    }
}
