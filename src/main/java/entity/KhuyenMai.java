package entity;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "KhuyenMai")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class KhuyenMai implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    
    @Column(name = "MaGiamGia")
    private String maGiamGia;
    
    @Column(name = "PhanTram")
    private int phanTram;
    
    @Column(name = "NgayBatDau")
    private Date ngayBatDau;
    
    @Column(name = "NgayKetThuc")
    private Date ngayKetThuc;
    
    @Column(name = "TrangThai")
    private int trangThai;
    
}
