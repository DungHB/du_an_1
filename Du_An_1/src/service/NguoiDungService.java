package service;

import java.util.ArrayList;
import java.util.List;
import model.*;
import model.NguoiDung;

public interface NguoiDungService {

    List<NguoiDung> getAll();

    ArrayList<Login> LoginSearch(String tenDN, String mk);

    ArrayList<Login> tenNV(Login lg);

    String listLG();

    NguoiDung getLoginInfo(String maNguoiDung, String matKhau);

//    boolean themNhanVien(NguoiDung nguoiDung);
//
//    NguoiDung getNhanVienByIdNhanVien(String idNhanVien);
//
//    List<NguoiDung> getAllViewTable();
//
//    boolean suaThongTinNhanVien(NguoiDung nguoiDung);
//
//    NguoiDung getNhanVienByMaNhanVien(String maNhanVien);
//
//    List<NguoiDung> getAllViewTableByPage(int offset, int limit);
//
//    int getCountNhanVien();
//
//    List<NguoiDung> getAllViewTableSearch(String keyWord);
}
