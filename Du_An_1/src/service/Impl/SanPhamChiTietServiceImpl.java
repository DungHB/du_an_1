package service.Impl;

import java.util.ArrayList;
import java.util.List;
import model.SanPhamChiTiet;
import service.SanPhamChiTietService;
import java.sql.*;
import ultil.DBConnect;

public class SanPhamChiTietServiceImpl implements SanPhamChiTietService {

    ArrayList<SanPhamChiTiet> list = new ArrayList<>();

    @Override
    public ArrayList<SanPhamChiTiet> getAll() {
        list.clear();
        try {
            String sql = "SELECT spct.IdSanPhamChiTiet, TenSanPham, TenMauSac, Size, TenChatLieu, lsg.GiaBanDau, spct.SoLuong FROM SanPhamChiTiet spct\n"
                    + "JOIN SanPham sp ON sp.IdSanPham = spct.IdSanPham\n"
                    + "JOIN MauSac ms ON ms.IdMauSac = spct.IdMauSac\n"
                    + "JOIN Size s ON s.IdSize = spct.IdSize\n"
                    + "JOIN ChatLieu cl ON cl.IdChatLieu = spct.IdChatLieu\n"
                    + "JOIN LichSuGia lsg ON lsg.IdSanPhamChiTiet = spct.IdSanPhamChiTiet";
            Connection conn = DBConnect.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                SanPhamChiTiet spct = new SanPhamChiTiet();
                //spct.setIdSanPhamChiTiet(rs.getInt(1));
                spct.setTenSanPham(rs.getString(2));
                spct.setTenMauSac(rs.getString(3));
                //spct.setSize(rs.getInt(4));
                spct.setTenChatLieu(rs.getString(5));
                //spct.setGia(rs.getDouble(6));
                //spct.setSoLuong(rs.getInt(7));
                list.add(spct);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int getCountSPCT() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getIdByMaND(String ma) {
        int id = 0;
        try {
            String sql = "SELECT IdNguoiDung FROM NguoiDung WHERE MaNguoiDung = ?";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, ma);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public SanPhamChiTiet getRowSPCT(int row) {
        return list.get(row);
    }

    @Override
    public String getMaSPCTFromSP(String maSP, String maMS) {
        String kq = "";
        try {
            String sql = "SELECT MaSPCT FROM SanPhamChiTiet\n"
                    + "JOIN SanPham ON SanPham.MaSanPham = SanPhamChiTiet.MaSanPham\n"
                    + "WHERE SanPham.MaSanPham = ? and MaMauSac = ?";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, maSP);
            stm.setString(2, maMS);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                kq = rs.getString("MaSPCT");
            }
            System.out.println(kq);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    @Override
    public String getMaMSByTenMS(String tenMS) {
        String kq = "";
        try {
            String sql = "select MaMauSac from MauSac where TenMauSac = ?";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, tenMS);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                kq = rs.getString("MaMauSac");
            }
            System.out.println(kq);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    @Override
    public String getMaSPCTByMaSP(String maSP) {
        String kq = "";
        try {
            String sql = "select MaSPCT from SanPhamChiTiet where MaSanPham = ?";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, maSP);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                kq = rs.getString("MaSPCT");
            }
            System.out.println(kq);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

}
