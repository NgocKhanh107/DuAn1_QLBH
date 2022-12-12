/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import custom.NhanVienCustom;
import java.util.List;

/**
 *
 * @author admin
 */
public interface ICommonService<T> {

    String addOrUpdate(T t);

    List<T> findByKey(String key);

   
}
