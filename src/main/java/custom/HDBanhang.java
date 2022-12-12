/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package custom;

import java.util.Date;
import javax.swing.JButton;
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
public class HDBanhang {

    private String maHD;

    private Date ngayTao;

    private int trangThai;

    private String ghiChu;

    private String maKM;

    private String maBan;

    private String maNV;
    
    private String maKV;

}
