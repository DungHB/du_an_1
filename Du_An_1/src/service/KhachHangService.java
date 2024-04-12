package service;

import java.util.ArrayList;
import model.KhachHang;

public interface KhachHangService {

    ArrayList<KhachHang> getAllKhachHang();
    String getTenKHByMaKH(String maKH);
    KhachHang getRowKH(int row);
    boolean themKH(KhachHang kh);
    ArrayList<KhachHang> searchKH(String maKH);
}
