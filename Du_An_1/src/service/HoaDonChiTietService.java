package service;

import java.util.ArrayList;
import model.*;

public interface HoaDonChiTietService {

    ArrayList<HDCT_LSG> getAllHDCT_LSG(String maHD);
    ArrayList<HDCT_LSG> updateSoluongSPVaoHD(String maSPCT, Integer soLuong, String maHD);
    ArrayList<HDCT_LSG> updateTruSoluongSPVaoHD(String maSPCT, Integer soLuong, String maHD);
    ArrayList<SanPhamChiTiet> updateSPVaoHD(String maHD, Integer soLuong);
    ArrayList<HDCT_LSG> addHDCT(HDCT_LSG hdct);
    ArrayList<HDCT_LSG> deleteHDCT(String maSPCT, String maHD);
}
