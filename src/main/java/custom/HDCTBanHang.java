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
public class HDCTBanHang {
    
    private String maMon;
    
    private String tenMon;
    
    private BigDecimal giaTien;
    
    private int soLuong;
    
}
