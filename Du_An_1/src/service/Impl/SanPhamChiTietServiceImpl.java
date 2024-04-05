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
    public List<SanPhamChiTiet> getAll() {
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
                spct.setIdSanPhamChiTiet(rs.getInt(1));
                spct.setTenSanPham(rs.getString(2));
                spct.setTenMauSac(rs.getString(3));
                spct.setSize(rs.getInt(4));
                spct.setTenChatLieu(rs.getString(5));
                spct.setGia(rs.getDouble(6));
                spct.setSoLuong(rs.getInt(7));
                list.add(spct);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Boolean themSanPhamChiTiet(SanPhamChiTiet spct) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public SanPhamChiTiet getSanPhamChiTietById(String idSPCT) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean capNhatSanPhamChiTiet(SanPhamChiTiet spct) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<SanPhamChiTiet> getAllSanPhamChiTietViewTable(int offset, int limit) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }

    @Override
    public List<SanPhamChiTiet> getAllSanPhamChiTietViewTableSearch(String searchKeyWord) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    public int getIdSPCTFromSP(int idSP) {
        Integer idsp = null;
        try {
            String sql = "SELECT IdSanPhamChiTiet FROM SanPhamChiTiet\n"
                    + "JOIN SanPham ON SanPham.IdSanPham = SanPhamChiTiet.IdSanPham\n"
                    + "WHERE SanPham.IdSanPham = ?";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, idSP);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                idsp = rs.getInt("IdSanPhamChiTiet");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idsp;
    }

}
