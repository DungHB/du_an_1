package service.Impl;

import java.util.ArrayList;
import model.HoaDonChiTiet;
import service.HoaDonChiTietService;
import java.sql.*;
import model.*;
import ultil.DBConnect;

public class HoaDonChiTietServiceImpl implements HoaDonChiTietService {

    ArrayList<HoaDonChiTiet> listHDCT = new ArrayList<>();
    ArrayList<HDCT_LSG> listHDCT_LSG = new ArrayList<>();
    ArrayList<SanPhamChiTiet> listSPCT = new ArrayList<>();

    @Override
    public ArrayList<HDCT_LSG> getAllHDCT_LSG(String maHD) {
        listHDCT_LSG.clear();
        try {
            String sql = "SELECT spct.MaSanPham, sp.TenSanPham, s.Size, ms.TenMauSac, hdct.SoLuong, lsg.GiaBanDau,\n"
                    + "CASE\n"
                    + "	WHEN lsg.NgayBatDau <= CURRENT_TIMESTAMP AND lsg.NgayKetThuc >= CURRENT_TIMESTAMP THEN lsg.GiaEQuaLau\n"
                    + "	ELSE lsg.GiaBanDau\n"
                    + "END AS DonGia\n"
                    + "FROM SanPhamChiTiet spct\n"
                    + "JOIN LichSuGia lsg ON lsg.MaSPCT = spct.MaSPCT\n"
                    + "JOIN SanPham sp ON sp.MaSanPham= spct.MaSanPham\n"
                    + "JOIN HoaDonChiTiet hdct ON hdct.MaSPCT = spct.MaSPCT\n"
                    + "JOIN Size s ON s.MaSize = spct.MaSize\n"
                    + "JOIN MauSac ms ON ms.MaMauSac = spct.MaMauSac\n"
                    + "where hdct.MaHoaDon = ?";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, maHD);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                HDCT_LSG hdct_lsg = new HDCT_LSG();
                hdct_lsg.setMaSanPham(rs.getString(1));
                hdct_lsg.setTenSanPham(rs.getString(2));
                hdct_lsg.setTenSize(rs.getString(3));
                hdct_lsg.setTenMauSac(rs.getString(4));
                hdct_lsg.setSoLuong(rs.getInt(5));
                hdct_lsg.setDonGiaDau(rs.getDouble(6));
                hdct_lsg.setDonGiaSau(rs.getDouble(7));
                listHDCT_LSG.add(hdct_lsg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHDCT_LSG;
    }

    @Override
    public ArrayList<HDCT_LSG> updateSoluongSPVaoHD(String maSPCT, Integer soLuong, String maHD) {
        listHDCT_LSG.clear();
        try {
            String sql = "UPDATE HoaDonChiTiet set SoLuong = SoLuong + ? where MaHoaDon = ? and MaSPCT = ?";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, soLuong);
            stm.setString(2, maHD);
            stm.setString(3, maSPCT);
            stm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHDCT_LSG;
    }

    @Override
    public ArrayList<SanPhamChiTiet> updateSPVaoHD(String maHD, Integer soLuong) {
        listSPCT.clear();
        try {
            String sql = "UPDATE SanPhamChiTiet set SoLuong = SoLuong - ? where MaSPCT = ?";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, soLuong);
            stm.setString(2, maHD);
            stm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSPCT;
    }

    @Override
    public ArrayList<HDCT_LSG> addHDCT(HDCT_LSG hdct) {
        try {
            String sql = "INSERT INTO HoaDonChiTiet (MaHoaDon, MaSPCT, SoLuong) values(?,?,?)";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, hdct.getMaHoaDon());
            stm.setString(2, hdct.getMaSanPham());
            stm.setInt(3, hdct.getSoLuong());
            stm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHDCT_LSG;
    }

    @Override
    public ArrayList<HDCT_LSG> updateTruSoluongSPVaoHD(String maSPCT, Integer soLuong, String maHD) {
        listHDCT_LSG.clear();
        try {
            String sql = "UPDATE HoaDonChiTiet set SoLuong = SoLuong - ? where MaHoaDon = ? and MaSPCT = ?";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, soLuong);
            stm.setString(2, maHD);
            stm.setString(3, maSPCT);
            stm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHDCT_LSG;
    }

    @Override
    public ArrayList<HDCT_LSG> deleteHDCT(String maSPCT, String maHD) {
        String sql = "delete HoaDonChiTiet where MaHoaDon = ? and MaSPCT = ?";
        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, maHD);
            stm.setString(2, maSPCT);
            stm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHDCT_LSG;
    }

}
