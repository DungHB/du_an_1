package service.Impl;

import java.util.List;
import model.HoaDon;
import service.HoaDonService;
import java.sql.*;
import java.util.ArrayList;
import ultil.DBConnect;

public class HoaDonServiceImpl implements HoaDonService {

    ArrayList<HoaDon> list = new ArrayList<>();

    @Override
    public List<HoaDon> getAllHoaDon() {
        list.clear();
        try {
            String sql = "Select * from HoaDon";
            Connection conn = DBConnect.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                HoaDon hd = new HoaDon();
                hd.setIdHoaDon(rs.getInt(1));
                hd.setMaHoaDon(rs.getString(2));
                hd.setNgayTao(rs.getDate(3));
                hd.setGhiChu(rs.getString(4));
                hd.setIdNguoiDung(rs.getInt(5));
                hd.setIdKhachHang(rs.getInt(6));
                hd.setTongTien(rs.getInt(7));
                hd.setTrangThai(rs.getString(8));
                list.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean themHoaDon(HoaDon hd) {
        if (hd != null) {
            try {
                String sql = "INSERT INTO HoaDon ( MaHoaDon, NgayTao, GhiChu, IdNguoiDung, IdKhachHang,TrangThai) VALUES (?, ?, ?, ?, ?, ?)";
                Connection conn = DBConnect.getConnection();
                PreparedStatement stm = conn.prepareStatement(sql);
                stm.setString(1, hd.getMaHoaDon());
                stm.setDate(2, new java.sql.Date(hd.getNgayTao().getTime()));
                stm.setString(3, hd.getGhiChu());
                stm.setInt(4, hd.getIdNguoiDung());
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
        list.clear();
        try {
            String sql = "";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, trangThai);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setIdHoaDon(rs.getInt(1));
                hd.setMaHoaDon(rs.getString(2));
                hd.setNgayTao(rs.getDate(3));
                hd.setGhiChu(rs.getString(4));
                hd.setIdNguoiDung(rs.getInt(5));
                hd.setIdKhachHang(rs.getInt(6));
                hd.setTongTien(rs.getInt(7));
                hd.setTrangThai(rs.getString(8));
                list.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<HoaDon> getAllViewTable() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
