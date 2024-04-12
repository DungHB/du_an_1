package service;

import java.util.ArrayList;
import java.util.List;
import model.SanPhamChiTiet;

public interface SanPhamChiTietService {

    ArrayList<SanPhamChiTiet> getAll();

    int getIdByMaND(String maND);

    SanPhamChiTiet getRowSPCT(int row);

    String getMaSPCTFromSP(String maSP, String maMS);

    String getMaMSByTenMS(String tenMS);

    String getMaSPCTByMaSP(String maSP);

    int getCountSPCT();
}
