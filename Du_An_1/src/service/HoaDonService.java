package service;

import java.util.ArrayList;
import java.util.List;
import model.HoaDon;

public interface HoaDonService {

    List<HoaDon> getAllHoaDon();

    HoaDon getRowHD(int row);

    ArrayList<HoaDon> themHoaDon(HoaDon hd);

    boolean capNhatHoaDon(HoaDon hd);

    HoaDon getHoaDonByMaHoaDon(String maHoaDon);

    List<HoaDon> getHoaDonByTrangThai(String trangThai);

    List<HoaDon> getAllViewTable();
}
