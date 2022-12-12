package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "NhanVien")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class NhanVien implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;
    
    @Column(name = "MaNV")
    private String maNV;
    
    @Column(name = "HoTenNV")
    private String hoTenNV;
    
    @Column(name = "GioiTinh")
    private int gioiTinh;
    
    @Column(name = "DiaChi")
    private String diaChi;
    
    @Column(name = "ThanhPho")
    private String thanhPho;
    
    @Column(name = "Sdt")
    private String sdt;
    
    @Column(name = "Email")
    private String email;
    
    @Column(name = "NgaySinh")
    private Date ngaySinh;
    
    @Column(name = "MatKhau")
    private String matKhau;
    
    @Column(name = "VaiTro")
    private boolean vaiTro;
    
    @Column(name = "TrangThai")
    private int trangThai;
    
}
