package service;

import java.util.ArrayList;
import model.*;

public interface HoaDonChiTietService {

    ArrayList<HoaDonChiTiet> getAllHDCT(int idHDCT);
    ArrayList<HoaDonChiTiet> updateSoluongSPVaoHD(Integer idSP, Integer soLuong, Integer idHD);
    ArrayList<SanPhamChiTiet> updateSPVaoHD(Integer idSP, Integer soLuong);
    ArrayList<HoaDonChiTiet> addHDCT(HoaDonChiTiet hdct);
}
