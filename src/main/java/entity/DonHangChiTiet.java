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
@Table(name = "DonHangChiTiet")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class DonHangChiTiet implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    
    @Column(name = "SoLuong")
    private int soLuong;
    
    @Column(name = "DonGia")
    private BigDecimal donGia;
    
    @ManyToOne
    @JoinColumn(name = "IDDH")
    private DonHang idDonHang;
    
    @ManyToOne
    @JoinColumn(name = "IDMonAn")
    private MonAn idMonAn;
    
}
