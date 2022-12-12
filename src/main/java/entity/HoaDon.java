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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "HoaDon")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class HoaDon implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    
    @Column(name = "MaHD")
    private String maHd;
    
    @Column(name = "NgayTao")
    private Date ngayTao;
    
    @Column(name = "NgayThanhToan")
    private Date ngayThanhToan;
    
    @Column(name = "TrangThai")
    private int trangThai;
    
    @Column(name = "GhiChu")
    private String ghiChu;
    
    @ManyToOne
    @JoinColumn(name = "IDDH")
    private DonHang idDonHang;
    
}
