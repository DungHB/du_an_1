package service;

import java.util.List;
import model.NguoiDung;

public interface NguoiDungService {

    List<NguoiDung> getAll();

    NguoiDung getLoginInfo(String maNguoiDung, String matKhau);

    boolean themNhanVien(NguoiDung nguoiDung);

    NguoiDung getNhanVienByIdNhanVien(String idNhanVien);

    List<NguoiDung> getAllViewTable();

    boolean suaThongTinNhanVien(NguoiDung nguoiDung);

    NguoiDung getNhanVienByMaNhanVien(String maNhanVien);

    List<NguoiDung> getAllViewTableByPage(int offset, int limit);

    int getCountNhanVien();

    List<NguoiDung> getAllViewTableSearch(String keyWord);
}
