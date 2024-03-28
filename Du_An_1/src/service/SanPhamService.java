package service;

import java.util.List;
import model.SanPham;

public interface SanPhamService {

    List<SanPham> getAll();

    List<SanPham> getSanPhamsByPage(int offset, int limit);

    Boolean themSanPham(SanPham sanPham);

    Boolean capNhatSanPham(SanPham sanPham);

    SanPham layThongTinSanPhamTheoId(String idSanPham);

    SanPham layThongTinSanPhamTheoMa(String maSanPham);

    int getCountSanPham();

    List<SanPham> getSearchSP(String keyWordSP);
}
