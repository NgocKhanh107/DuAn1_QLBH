package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "KhuVuc")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KhuVuc implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    
    @Column(name = "MaKV")
    private String maKV;
    
    @Column(name = "TenKV")
    private String tenKV;
    
    @Column(name = "TrangThai")
    private int trangThai;
}
