package service;

import java.util.List;
import model.SanPhamChiTiet;

public interface SanPhamChiTietService {

    List<SanPhamChiTiet> getAll();

    Boolean themSanPhamChiTiet(SanPhamChiTiet spct);

    SanPhamChiTiet getSanPhamChiTietById(String idSPCT);

    boolean capNhatSanPhamChiTiet(SanPhamChiTiet spct);

    List<SanPhamChiTiet> getAllSanPhamChiTietViewTable(int offset, int limit);

    List<SanPhamChiTiet> getAllSanPhamChiTietViewTableSearch(String searchKeyWord);

    int getCountSPCT();
}
