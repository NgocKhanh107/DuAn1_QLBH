/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package custom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author admin
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BanCustom {
    
    private int id;

    private String maBan;
    
    private int soLuongChoNgoi;
    
    private int trangThai;
    
    private int khuVuc; 
}
