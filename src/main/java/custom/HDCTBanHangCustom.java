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
public class HDCTBanHangCustom {
     private int id;
    private int hd;
    private String tenMon ;
    private int soLuong;
    private BigDecimal donGia;
    private int idThucDon;

    public HDCTBanHangCustom (int id, String tenMon, int soLuong, BigDecimal donGia) {
        this.id = id;
        this.tenMon = tenMon;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }
}
