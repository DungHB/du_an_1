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
            String sql = "SELECT spct.IdSanPhamChiTiet, sp.TenSanPham, mau.TenMauSac, size.Size, cl.TenChatLieu, Gia, SoLuong FROM SanPhamChiTiet spct\n"
                    + "JOIN SanPham sp ON spct.IdSanPham = sp.IdSanPham\n"
                    + "JOIN MauSac mau ON spct.IdMauSac = mau.IdMauSac\n"
                    + "JOIN ChatLieu cl ON spct.IdChatLieu = cl.IdChatLieu\n"
                    + "JOIN Size size ON spct.IdSize = size.IdSize";
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

}
