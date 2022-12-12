/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.impl;

import custom.BanCustom;
import custom.HDBanhang;
import custom.HoaDonCustom;
import custom.KhuyenMaiCustom;
import entity.Ban;
import entity.DonHang;
import entity.HoaDon;
import entity.KhuVuc;
import entity.KhuyenMai;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import repository.ICommonRepository;
import repository.impl.BanRepositoryImpl;
import repository.impl.DonHangRepositoryImpl;
import repository.impl.HoaDonRepositoryImpl;
import repository.impl.KhuyenMaiRepositoryImpl;
import service.ICommonService;

/**
 *
 * @author admin
 */
public class HoaDonServiceImpl implements ICommonService<HoaDonCustom> {

    private HoaDonRepositoryImpl repo;
    private DonHangRepositoryImpl repoDonHang;

    public HoaDonServiceImpl() {
        repo = new HoaDonRepositoryImpl();
    }

    @Override
    public List<HoaDonCustom> findByKey(String key) {
        return this.repo.findByKey(key);
    }

    @Override
    public String addOrUpdate(HoaDonCustom t) {
        String mess = "";
        DonHang donHang = repoDonHang.findById(t.getIdDonHang());
        if (this.repo.addOrUpdate(new HoaDon(t.getId(), t.getMaHD(), t.getNgayTao(),
                t.getNgayThanhToan(), t.getTrangThai(), t.getGhiChu(), donHang))) {
            mess = "Thanh cong";
        } else {
            mess = "That bai";
        }
        return mess;
    }

    public String UpdateTrangThaiban(HoaDon hd) {

        if (!repo.UpdateTrangThaiban(hd)) {
            return "That bai";
        }
        return "Thanh cong";
    }

    public List<HoaDon> getAll() {
        return this.repo.getAll();
    }

    public List<HDBanhang> getListHDCustom(String ma) {
        return this.repo.getListHDCustom(ma);
    }

    public List<HoaDon> getHDByMaDH(String madh) {
        return this.repo.getHDByMaDH(madh);
    }

    public HoaDon getIDByMaHD(String mahd) {
        return this.repo.getIDByMaHD(mahd);
    }

    public String insert(HoaDon hd) {
        if (!this.repo.addOrUpdate(hd)) {
            return "That bai";
        }
        return "Thanh cong";
    }

    public HoaDon getByMaDH(String madh) {
        return this.repo.getByMaDH(madh);
    }

    public String ExportExcel(List<HDBanhang> lists) {
        String mess = "";

        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Danh sách hóa đơn");

            XSSFRow row = null;
            Cell cell = null;
            row = sheet.createRow(0);

            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("STT");

            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Mã HĐ");

            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Ngày tạo");

            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("Trạng thái");

            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("Ghi chú");

            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("Mã KM");

            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue("Mã Bàn");

            cell = row.createCell(7, CellType.STRING);
            cell.setCellValue("Mã NV");

            for (int i = 0; i < lists.size(); i++) {
                HDBanhang hd = lists.get(i);
                row = sheet.createRow(1 + i);

                cell = row.createCell(0, CellType.NUMERIC);
                cell.setCellValue(i + 1);

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(hd.getMaHD());

                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                String date = dateFormat.format(hd.getNgayTao());
                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(date);

                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(hd.getTrangThai() == 0 ? "Đã thanh toán" : "Chưa thanh toán");

                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(hd.getGhiChu());

                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue(hd.getMaKM());

                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue(hd.getMaBan());

                cell = row.createCell(7, CellType.STRING);
                cell.setCellValue(hd.getMaNV());
            }

            File file = new File("C:\\Users\\lenovo\\Documents\\QLNhaHang\\Danhsach.xlsx");
            try {
                FileOutputStream fos = new FileOutputStream(file);
                workbook.write(fos);
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            mess = "In thành công !";
        } catch (Exception e) {
            e.printStackTrace();
            mess = "In không thành công !";
        }
        return mess;
    }
     public List<HDBanhang> getListHDByNgayTao(Date date1,Date date2){
         return repo.getListHDByNgayTao(date1, date2);
     }
     public long getTongHD(){
        return this.repo.getTongHD();
    }
    
    public long getTongHDByDay(Date date1, Date date2){
        return this.repo.getTongHDByDay(date1, date2);
    }
}
