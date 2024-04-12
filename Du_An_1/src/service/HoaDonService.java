package service;

import java.util.ArrayList;
import model.HoaDon;

public interface HoaDonService {

    ArrayList<HoaDon> getAllHoaDon();

    HoaDon getRowHD(int row);

    String searchMaNhanVienTheoTenDangNhap(String tenDangNhap);

    ArrayList<HoaDon> themHoaDon(HoaDon hd);

    ArrayList<HoaDon> updateMaKhachHangBanHang(HoaDon hd);
    ArrayList<HoaDon> xoaHoaDon(String maHoaDon);
    ArrayList<HoaDon> huyHoaDon(String maHoaDon, String trangThai);
    ArrayList<HoaDon> thanhToanApPGG(String maPGG, String maHoaDon);
    String thanhToanHoaDon(String trangThai, String ngayHoanThanh, String maHoaDon);
    ArrayList<HoaDon> searchQLHD(String maHoaDon);
    ArrayList<HoaDon> locHDTheoNgay(String ngayBatDau, String ngayKetThuc);
//
//    boolean capNhatHoaDon(HoaDon hd);
//
//    HoaDon getHoaDonByMaHoaDon(String maHoaDon);
//
//    List<HoaDon> getHoaDonByTrangThai(String trangThai);
//
//    List<HoaDon> getAllViewTable();
}
