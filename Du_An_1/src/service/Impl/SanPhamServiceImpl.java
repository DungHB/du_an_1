package service.Impl;

import java.util.ArrayList;
import java.util.List;
import model.SanPham;
import service.SanPhamService;
import java.sql.*;
import ultil.DBConnect;

public class SanPhamServiceImpl implements SanPhamService {

    ArrayList<SanPham> list = new ArrayList<>();

    @Override
    public ArrayList<SanPham> getAll() {
        list.clear();
        try {
            String sql = "SELECT distinct spct.MaSanPham,TenSanPham, TenThuongHieu, TenMauSac, TenChatLieu, Size, spct.SoLuong,\n"
                    + "case\n"
                    + "	when lsg.NgayBatDau <= CURRENT_TIMESTAMP AND lsg.NgayKetThuc >= CURRENT_TIMESTAMP THEN lsg.GiaEQuaLau\n"
                    + "	else lsg.GiaBanDau\n"
                    + "end as Gia\n"
                    + "FROM SanPhamChiTiet spct\n"
                    + "JOIN SanPham sp ON spct.MaSanPham = sp.MaSanPham\n"
                    + "JOIN ThuongHieu th ON spct.MaThuongHieu = th.MaThuongHieu\n"
                    + "JOIN LichSuGia lsg ON spct.MaSPCT = lsg.MaSPCT\n"
                    + "JOIN MauSac ms ON spct.MaMauSac = ms.MaMauSac\n"
                    + "JOIN Size s ON spct.MaSize = s.MaSize\n"
                    + "JOIN ChatLieu cl ON spct.MaChatLieu = cl.MaChatLieu\n"
                    + "group by spct.MaSanPham,TenSanPham,TenThuongHieu,GiaBanDau,spct.SoLuong,TenMauSac,Size,TenChatLieu,TenThuongHieu,lsg.NgayBatDau,lsg.NgayKetThuc,lsg.GiaEQuaLau";
            Connection conn = DBConnect.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSanPham(rs.getString(1));
                sp.setTenSanPham(rs.getString(2));
                sp.setTenThuongHieu(rs.getString(3));
                sp.setTenMauSac(rs.getString(4));
                sp.setTenChatLieu(rs.getString(5));
                sp.setTenSize(rs.getString(6));
                sp.setSoLuongSP(rs.getInt(7));
                sp.setDonGia(rs.getDouble(8));
                list.add(sp);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public SanPham getRowSP(int row) {
        return list.get(row);
    }

    @Override
    public ArrayList<SanPham> TimKiemSanPhamTheoTenSP(String keyWord) {
        list.clear();
        try {
            String sql = "SELECT distinct spct.MaSanPham, TenSanPham, TenThuongHieu, TenMauSac, TenChatLieu, Size, spct.SoLuong,\n"
                    + "case\n"
                    + "	when lsg.NgayBatDau <= CURRENT_TIMESTAMP AND lsg.NgayKetThuc >= CURRENT_TIMESTAMP THEN lsg.GiaEQuaLau\n"
                    + "	else lsg.GiaBanDau\n"
                    + "end as Gia\n"
                    + "FROM SanPhamChiTiet spct\n"
                    + "JOIN SanPham sp ON spct.MaSanPham = sp.MaSanPham\n"
                    + "JOIN ThuongHieu th ON spct.MaThuongHieu = th.MaThuongHieu\n"
                    + "JOIN LichSuGia lsg ON spct.MaSPCT = lsg.MaSPCT\n"
                    + "JOIN MauSac ms ON spct.MaMauSac = ms.MaMauSac\n"
                    + "JOIN Size s ON spct.MaSize = s.MaSize\n"
                    + "JOIN ChatLieu cl ON spct.MaChatLieu = cl.MaChatLieu\n"
                    + "group by spct.MaSanPham,TenSanPham,TenThuongHieu,GiaBanDau,spct.SoLuong,TenMauSac,Size,TenChatLieu,lsg.NgayBatDau,lsg.NgayKetThuc,lsg.GiaEQuaLau\n"
                    + "having TenSanPham like ?";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, "%" + keyWord + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSanPham(rs.getString(1));
                sp.setTenSanPham(rs.getString(2));
                sp.setTenThuongHieu(rs.getString(3));
                sp.setTenMauSac(rs.getString(4));
                sp.setTenChatLieu(rs.getString(5));
                sp.setTenSize(rs.getString(6));
                sp.setSoLuongSP(rs.getInt(7));
                sp.setDonGia(rs.getDouble(8));
                list.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ArrayList<SanPham> updateSanPhamTru(String maSP, Integer soLuong) {
        list.clear();
        try {
            String sql = "UPDATE SanPhamChiTiet set SoLuong = SoLuong - ? where MaSPCT = ?";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, soLuong);
            stm.setString(2, maSP);
            stm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ArrayList<SanPham> updateSanPhamCong(String maSP, Integer soLuong) {
        list.clear();
        try {
            String sql = "UPDATE SanPhamChiTiet set SoLuong = SoLuong + ? where MaSPCT = ?";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, soLuong);
            stm.setString(2, maSP);
            stm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ArrayList<SanPham> sapXepSanPhamTheoGia() {
        list.clear();
        try {
            String sql = "SELECT distinct spct.MaSanPham, TenSanPham, TenThuongHieu, TenMauSac, TenChatLieu, Size, spct.SoLuong,\n"
                    + "case\n"
                    + "	when lsg.NgayBatDau <= CURRENT_TIMESTAMP AND lsg.NgayKetThuc >= CURRENT_TIMESTAMP THEN lsg.GiaEQuaLau\n"
                    + "	else lsg.GiaBanDau\n"
                    + "end as Gia\n"
                    + "FROM SanPhamChiTiet spct\n"
                    + "JOIN SanPham sp ON spct.MaSanPham = sp.MaSanPham\n"
                    + "JOIN ThuongHieu th ON spct.MaThuongHieu = th.MaThuongHieu\n"
                    + "JOIN LichSuGia lsg ON spct.MaSPCT = lsg.MaSPCT\n"
                    + "JOIN MauSac ms ON spct.MaMauSac = ms.MaMauSac\n"
                    + "JOIN Size s ON spct.MaSize = s.MaSize\n"
                    + "JOIN ChatLieu cl ON spct.MaChatLieu = cl.MaChatLieu\n"
                    + "group by spct.MaSanPham,TenSanPham,TenThuongHieu,GiaBanDau,spct.SoLuong,TenMauSac,Size,TenChatLieu,lsg.NgayBatDau,lsg.NgayKetThuc,lsg.GiaEQuaLau\n"
                    + "order by Gia";
            Connection conn = DBConnect.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSanPham(rs.getString(1));
                sp.setTenSanPham(rs.getString(2));
                sp.setTenThuongHieu(rs.getString(3));
                sp.setTenMauSac(rs.getString(4));
                sp.setTenChatLieu(rs.getString(5));
                sp.setTenSize(rs.getString(6));
                sp.setSoLuongSP(rs.getInt(7));
                sp.setDonGia(rs.getDouble(8));
                list.add(sp);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public ArrayList<SanPham> sapXepSanPhamTheoTen() {
        list.clear();
        try {
            String sql = "SELECT distinct spct.MaSanPham, TenSanPham, TenThuongHieu, TenMauSac, TenChatLieu, Size, spct.SoLuong,\n"
                    + "case\n"
                    + "	when lsg.NgayBatDau <= CURRENT_TIMESTAMP AND lsg.NgayKetThuc >= CURRENT_TIMESTAMP THEN lsg.GiaEQuaLau\n"
                    + "	else lsg.GiaBanDau\n"
                    + "end as Gia\n"
                    + "FROM SanPhamChiTiet spct\n"
                    + "JOIN SanPham sp ON spct.MaSanPham = sp.MaSanPham\n"
                    + "JOIN ThuongHieu th ON spct.MaThuongHieu = th.MaThuongHieu\n"
                    + "JOIN LichSuGia lsg ON spct.MaSPCT = lsg.MaSPCT\n"
                    + "JOIN MauSac ms ON spct.MaMauSac = ms.MaMauSac\n"
                    + "JOIN Size s ON spct.MaSize = s.MaSize\n"
                    + "JOIN ChatLieu cl ON spct.MaChatLieu = cl.MaChatLieu\n"
                    + "group by spct.MaSanPham,TenSanPham,TenThuongHieu,GiaBanDau,spct.SoLuong,TenMauSac,Size,TenChatLieu,lsg.NgayBatDau,lsg.NgayKetThuc,lsg.GiaEQuaLau\n"
                    + "order by TenSanPham";
            Connection conn = DBConnect.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSanPham(rs.getString(1));
                sp.setTenSanPham(rs.getString(2));
                sp.setTenThuongHieu(rs.getString(3));
                sp.setTenMauSac(rs.getString(4));
                sp.setTenChatLieu(rs.getString(5));
                sp.setTenSize(rs.getString(6));
                sp.setSoLuongSP(rs.getInt(7));
                sp.setDonGia(rs.getDouble(8));
                list.add(sp);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
