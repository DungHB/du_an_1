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
    public ArrayList<HoaDon> getAllHoaDon() {
        list.clear();
        try {
            String sql = "select * from HoaDon";
            Connection conn = DBConnect.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHoaDon(rs.getString(1));
                hd.setNgayTao(rs.getString(2));
                hd.setNgayHoanThanh(rs.getString(3));
                hd.setMaNV(rs.getString(4));
                hd.setMaKhachHang(rs.getString(5));
                hd.setTrangThai(rs.getString(6));
                hd.setMaPGG(rs.getString(7));
//                hd.setTenNV(rs.getString(8));
//                hd.setTenKH(rs.getString(9));
                list.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public HoaDon getRowHD(int row) {
        return list.get(row);
    }

    @Override
    public String searchMaNhanVienTheoTenDangNhap(String tenDangNhap) {
        String kq = "";
        try {
            String sql = "select MaNguoiDung from NguoiDung where TenDangNhap = ?";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, tenDangNhap);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                kq = rs.getString(1);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    @Override
    public ArrayList<HoaDon> themHoaDon(HoaDon hd) {
        try {
            String sql = "insert into HoaDon(MaHoaDon, NgayTao, MaNV, TrangThai) values(?,?,?,?)";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, hd.getMaHoaDon());
            stm.setString(2, hd.getNgayTao());
            stm.setString(3, hd.getMaNV());
            stm.setString(4, hd.getTrangThai());
            stm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ArrayList<HoaDon> updateMaKhachHangBanHang(HoaDon hd) {
        try {
            String sql = "update HoaDon set MaKhachHang = ? where MaHoaDon = ?";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, hd.getMaKhachHang());
            stm.setString(2, hd.getMaHoaDon());
            stm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ArrayList<HoaDon> xoaHoaDon(String maHoaDon) {
        try {
            String sql = "delete HoaDon where MaHoaDon = ?";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, maHoaDon);
            stm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ArrayList<HoaDon> huyHoaDon(String maHoaDon, String trangThai) {
        try {
            String sql = "update HoaDon set TrangThai = ? where MaHoaDon = ?";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, trangThai);
            stm.setString(2, maHoaDon);
            stm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ArrayList<HoaDon> thanhToanApPGG(String maPGG, String maHoaDon) {
        String sql = "update HoaDon set MaPhieuGiamGia = ? where MaHoaDon = ?";
        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, maPGG);
            stm.setString(2, maHoaDon);
            stm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public String thanhToanHoaDon(String trangThai, String ngayHoanThanh, String maHoaDon) {
        String sql = "update HoaDon set TrangThai = ?, NgayHoanThanh = ? where MaHoaDon = ?";
        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, trangThai);
            stm.setString(2, ngayHoanThanh);
            stm.setString(3, maHoaDon);
            stm.executeUpdate();
            conn.close();
            return "Thanh toán thành công";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Thanh toán thất bại";
    }

}
