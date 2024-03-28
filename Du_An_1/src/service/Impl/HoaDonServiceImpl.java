package service.Impl;

import java.util.List;
import model.HoaDon;
import service.HoaDonService;
import java.sql.*;
import ultil.DBConnect;

public class HoaDonServiceImpl implements HoaDonService {

    @Override
    public List<HoaDon> getAllHoaDon() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean themHoaDon(HoaDon hd) {
        if (hd != null) {
            try {
                String sql = "";
                Connection conn = DBConnect.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql);
                stm.setString(1, hd.getMaHoaDon());
                stm.setDate(2, new java.sql.Date(hd.getNgayTao().getTime()));
                stm.setString(3, hd.getGhiChu());
                stm.setInt(4, hd.getIdNhanVien());
                stm.setInt(5, hd.getIdKhachHang());
                stm.setString(6, hd.getTrangThai());
                stm.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean capNhatHoaDon(HoaDon hd) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public HoaDon getHoaDonByMaHoaDon(String maHoaDon) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<HoaDon> getHoaDonByTrangThai(String trangThai) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<HoaDon> getAllViewTable() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
