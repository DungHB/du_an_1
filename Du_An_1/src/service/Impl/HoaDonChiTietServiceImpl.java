package service.Impl;

import java.util.ArrayList;
import model.HoaDonChiTiet;
import service.HoaDonChiTietService;
import java.sql.*;
import model.*;
import ultil.DBConnect;

public class HoaDonChiTietServiceImpl implements HoaDonChiTietService {

    ArrayList<HoaDonChiTiet> listHDCT = new ArrayList<>();
    ArrayList<SanPhamChiTiet> listSPCT = new ArrayList<>();

    @Override
    public ArrayList<HoaDonChiTiet> getAllHDCT(int idHDCT) {
        listHDCT.clear();
        try {
            String sql = "SELECT hdct.IdHoaDon, hdct.IdSanPhamChitiet, sp.TenSanPham, hdct.SoLuong, lsg.GiaBanDau,\n"
                    + "CASE\n"
                    + "	WHEN lsg.NgayBatDau <= CURRENT_TIMESTAMP AND lsg.NgayKetThuc >= CURRENT_TIMESTAMP THEN lsg.GiaSau\n"
                    + "	ELSE lsg.GiaBanDau\n"
                    + "END AS DonGia\n"
                    + "FROM SanPhamChiTiet spct\n"
                    + "JOIN LichSuGia lsg ON lsg.IdSanPhamChiTiet = spct.IdSanPhamChiTiet\n"
                    + "JOIN SanPham sp ON sp.IdSanPham= spct.IdSanPham\n"
                    + "JOIN HoaDonChiTiet hdct ON hdct.IdSanPhamChitiet = spct.IdSanPhamChiTiet\n"
                    + "WHERE hdct.IdHoaDonChiTiet = ?";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, idHDCT);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                HoaDonChiTiet hdct = new HoaDonChiTiet();
                hdct.setIdHoaDonChiTiet(rs.getInt(1));
                hdct.setIdSanPhamChiTiet(rs.getInt(2));
                hdct.setTenSanPham(rs.getString(3));
                hdct.setSoLuong(rs.getInt(4));
                hdct.setDonGia(rs.getDouble(4));
                hdct.setDonGiaSau(rs.getDouble(6));
                listHDCT.add(hdct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHDCT;
    }

    @Override
    public ArrayList<HoaDonChiTiet> updateSoluongSPVaoHD(Integer idSP, Integer soLuong, Integer idHD) {
        listHDCT.clear();
        try {
            String sql = "UPDATE HoaDonChiTiet set SoLuong = SoLuong + ? where IdHoaDon = ? and IdSanPhamChitiet = ?";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, soLuong);
            stm.setInt(2, idHD);
            stm.setInt(3, idSP);
            stm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHDCT;
    }

    @Override
    public ArrayList<SanPhamChiTiet> updateSPVaoHD(Integer idSP, Integer soLuong) {
        listSPCT.clear();
        try {
            String sql = "UPDATE SanPhamChiTiet set SoLuong = SoLuong - ? where IdSanPhamChiTiet = ?";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, idSP);
            stm.setInt(2, soLuong);
            stm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSPCT;
    }

    @Override
    public ArrayList<HoaDonChiTiet> addHDCT(HoaDonChiTiet hdct) {
        listHDCT.clear();
        try {
            String sql = "INSERT INTO HoaDonChiTiet (IdHoaDon, IdSanPhamChitiet, SoLuong) values(?,?,?)";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, hdct.getIdHoaDon());
            stm.setInt(2, hdct.getIdSanPhamChiTiet());
            stm.setInt(3, hdct.getSoLuong());
            stm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHDCT;
    }

}
