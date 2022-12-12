/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import java.util.List;
/**
 *
 * @author admin
 */
public interface ICommonRepository<T, K>{

    boolean addOrUpdate(T t);
    
    T findById(int id);

    List<K> findByKey(String key);

}
