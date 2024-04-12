package service;

import java.util.ArrayList;
import model.PhieuGiamGia;

public interface PhieuGiamGiaService {

    ArrayList<PhieuGiamGia> showHoaDonTheoVoucher(Integer tongTien);
    Integer layGiaGiamVoucher(String maPGG);
    ArrayList<PhieuGiamGia> getAllVoucher();
    String updateSoLuongVoucherTru(String maVoucher);
    PhieuGiamGia findKhuyenMaiByMaKhuyenMai(String maPGG);
}
