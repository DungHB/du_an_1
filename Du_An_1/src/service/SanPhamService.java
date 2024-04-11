package service;

import java.util.ArrayList;
import java.util.List;
import model.SanPham;

public interface SanPhamService {

    ArrayList<SanPham> getAll();
    SanPham getRowSP (int row);
    ArrayList<SanPham> TimKiemSanPhamTheoTenSP(String keyWord);
    ArrayList<SanPham> updateSanPhamTru(String maSP, Integer soLuong);
    ArrayList<SanPham> updateSanPhamCong(String maSP, Integer soLuong);
    ArrayList<SanPham> sapXepSanPhamTheoGia();
    ArrayList<SanPham> sapXepSanPhamTheoTen();
    
//    List<SanPham> getSanPhamsByPage(int offset, int limit);
//
//    Boolean themSanPham(SanPham sanPham);
//
//    Boolean capNhatSanPham(SanPham sanPham);
//
//    SanPham layThongTinSanPhamTheoId(String idSanPham);
//
//    SanPham layThongTinSanPhamTheoMa(String maSanPham);
//
//    int getCountSanPham();
//
//    List<SanPham> getSearchSP(String keyWordSP);
}
