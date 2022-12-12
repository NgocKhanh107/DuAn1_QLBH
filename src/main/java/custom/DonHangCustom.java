/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package custom;

import java.util.Date;
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
public class DonHangCustom {
    
    private int id;
    
    private String maDH;
    
    private Date ngayTao;
    
    private Date ngayDatBan;
    
    private int trangThai;
    
    private String ghiChu;
    
    private int idBan;
    
    private int idNhanVien;
    
    private int idKhuyenMai;  
    
}
