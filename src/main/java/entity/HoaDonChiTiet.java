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
@Table(name = "HoaDonChiTiet")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class HoaDonChiTiet implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    
    @Column(name = "SL")
    private int soLuong;
    
    @Column(name = "DonGia")
    private BigDecimal DonGia;
    
    @ManyToOne
    @JoinColumn(name = "IDDHCT")
    private DonHangChiTiet idDonHangChiTiet;
    
    @ManyToOne
    @JoinColumn(name = "IDHD")
    private HoaDon idHoaDon;
    
}
