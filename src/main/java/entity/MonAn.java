package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MonAn")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class MonAn implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    
    @Column(name = "MaMon")
    private String maMon;
    
    @Column(name = "TenMon")
    private String tenMon;
    
    @Column(name = "DVT")
    private String donViTinh;
    
    @Column(name = "HinhAnh")
    private String hinhAnh;
    
    @Column(name = "DonGia")
    private BigDecimal donGia;
    
    @Column(name = "GhiChu")
    private String ghiChu;
    
    @Column(name = "TrangThai")
    private int trangThai;
    
    @ManyToOne
    @JoinColumn(name = "IDDanhMuc")
    private DanhMuc danhMuc;
    
}
