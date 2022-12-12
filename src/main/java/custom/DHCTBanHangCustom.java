/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package custom;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author ngocKhanh
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DHCTBanHangCustom {
    private int id;
    private int idTD;
    private String maMon;
    private String maBan;
    private String maDH;
    private String tenMon;
    private String donViTinh;
    private int soLuong;
    private BigDecimal donGia;
    private int idDH;

    public DHCTBanHangCustom(int iddhct,int idTD,String maMon, String tenMon, String donViTinh, int soLuong, BigDecimal donGia, int idDH) {
        this.id = iddhct;
        this.idTD = idTD;
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.donViTinh = donViTinh;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.idDH = idDH;
    }

    public DHCTBanHangCustom(int soLuong, BigDecimal donGia,int id) {
        
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.id = id;
    }
    
    
}
