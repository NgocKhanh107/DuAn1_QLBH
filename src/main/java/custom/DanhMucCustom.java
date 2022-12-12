/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package custom;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author hieu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DanhMucCustom {

    private int id;

    private String maLoai;

    private String tenLoai;

    private int trangThai;
    
    public String TrangThaiToString(){
        return trangThai == 0 ?"Còn kinh doanh":"Không còn kinh doanh";
    }

}
