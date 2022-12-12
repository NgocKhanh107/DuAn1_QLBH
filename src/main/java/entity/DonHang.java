package entity;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "DonHang")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class DonHang implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    
    @Column(name = "MaDH")
    private String maDH;
    
    @Column(name = "NgayTao")
    private Date ngayTao;
    
    @Column(name = "NgayDatBan")
    private Date ngayDatBan;
    
    @Column(name = "TrangThai")
    private int trangThai;
    
    @Column(name = "GhiChu")
    private String ghiChu;
    
    @ManyToOne
    @JoinColumn(name = "IDBan")
    private Ban idBan;
    
    @ManyToOne
    @JoinColumn(name = "IDNV")
    private NhanVien idNhanVien;
   
    @ManyToOne
    @JoinColumn(name = "IDKM")
    private KhuyenMai idKhuyenMai;
    
}
