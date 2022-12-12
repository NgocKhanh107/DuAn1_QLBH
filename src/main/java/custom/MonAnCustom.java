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
 * @author admin
 */
@Data
@NoArgsConstructor
@AllArgsConstructor

public class MonAnCustom {

    private int id;

    private String maMon;

    private String tenMon;

    private String donViTinh;

    private String hinhAnh;

    private BigDecimal donGia;

    private String ghiChu;

    private int trangThai;

    private int idDanhMuc;

    public MonAnCustom(String maMon, String tenMon, String donViTinh, BigDecimal donGia) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.donViTinh = donViTinh;
        this.donGia = donGia;
    }
    
    
}
