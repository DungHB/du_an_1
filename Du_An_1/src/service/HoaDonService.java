package service;

import java.util.List;
import model.HoaDon;

public interface HoaDonService {

    List<HoaDon> getAllHoaDon();

    boolean themHoaDon(HoaDon hd);

    boolean capNhatHoaDon(HoaDon hd);

    HoaDon getHoaDonByMaHoaDon(String maHoaDon);

    List<HoaDon> getHoaDonByTrangThai(String trangThai);

    List<HoaDon> getAllViewTable();
}
