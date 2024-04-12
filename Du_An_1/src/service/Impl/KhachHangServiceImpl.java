package service.Impl;

import java.util.ArrayList;
import model.KhachHang;
import service.KhachHangService;
import java.sql.*;
import ultil.DBConnect;

public class KhachHangServiceImpl implements KhachHangService {

    ArrayList<KhachHang> listKH = new ArrayList<>();

    @Override
    public ArrayList<KhachHang> getAllKhachHang() {
        listKH.clear();
        try {
            String sql = "select * from KhachHang";
            Connection conn = DBConnect.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKhachHang(rs.getString(1));
                kh.setTenKhachHang(rs.getString(2));
                kh.setGioiTinh(rs.getBoolean(3));
                kh.setSdt(rs.getString(4));
                kh.setDiaChi(rs.getString(5));
                listKH.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listKH;
    }

    @Override
    public String getTenKHByMaKH(String maKH) {
        String maKHNew = "";
        try {
            String sql = "select kh.TenKhachHang from HoaDon hd\n"
                    + "join KhachHang kh on kh.MaKhachHang = hd.MaKhachHang\n"
                    + "where hd.MaKhachHang = ?";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, maKH);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return maKHNew = rs.getString(1);
            }
            stm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maKHNew;
    }

    @Override
    public KhachHang getRowKH(int row) {
        return listKH.get(row);
    }

    @Override
    public boolean themKH(KhachHang kh) {
        try {
            String sql = "insert into KhachHang(MaKhachHang, TenKhachHang, GioiTinh, Sdt,DiaChi) values(?,?,?,?,?)";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, kh.getMaKhachHang());
            stm.setString(2, kh.getTenKhachHang());
            stm.setBoolean(3, kh.getGioiTinh());
            stm.setString(4, kh.getSdt());
            stm.setString(5, kh.getDiaChi());
            stm.executeUpdate();
            conn.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ArrayList<KhachHang> searchKH(String maKH) {
        listKH.clear();
        try {
            String sql = "select * from KhachHang where MaKhachHang like ?";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, "%" + maKH + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKhachHang(rs.getString(1));
                kh.setTenKhachHang(rs.getString(2));
                kh.setGioiTinh(rs.getBoolean(3));
                kh.setSdt(rs.getString(4));
                kh.setDiaChi(rs.getString(5));
                listKH.add(kh);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKH;
    }

}
