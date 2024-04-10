package service.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.SanPham;
import model.SanPhamChiTiet;
import ultil.DBConnect;

public class SanPhamChiTietServiceImpl {
 List<SanPhamChiTiet> list = new ArrayList<>();

    public List<SanPhamChiTiet> getAll2() {
        list.clear();
        try {
            String sql = "select TenSanPham ,TenChatLieu,TenMauSac,Size,Gia,SoLuong \n"
                    + "from SanPhamChiTiet spct\n"
                    + "join SanPham sp on spct.IdSanPham = sp.IdSanPham\n"
                    + "join ChatLieu cl on spct.IdChatLieu = cl.IdChatLieu\n"
                    + "join MauSac ms on spct.IdMauSac = ms.IdMauSac\n"
                    + "join Size on spct.IdSize= Size.IdSize";
            Connection con = DBConnect.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                SanPhamChiTiet spct = new SanPhamChiTiet();
                spct.setTenSanPham(rs.getString(1));
                spct.setTenChatLieu(rs.getString(2));
                spct.setTenMauSac(rs.getString(3));
                spct.setSize(rs.getInt(4));
                spct.setGia(rs.getDouble(5));
                spct.setSoLuong(rs.getInt(6));
                list.add(spct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public SanPhamChiTiet getRow2(int row2) {
        return list.get(row2);
    }

    public void Them(SanPham sp) {
        try {
            String sql = "Insert into SanPham(MaSanPham, TenSanPham)VALUES(?,?)";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, sp.getMaSanPham());
            stm.setString(2, sp.getTenSanPham());
            //stm.setInt(3, sp.getIdTheLoai());
            //stm.setInt(4, sp.getIdThuongHieu());
            stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void update(SanPham sp) {
        try {
            String sql = "Update SanPham set TenSanPham=?  where MaSanPham=?";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, sp.getTenSanPham());
            //stm.setInt(2, sp.getIdTheLoai());
            //stm.setInt(3, sp.getIdThuongHieu());
            stm.setString(2, sp.getMaSanPham());
            stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteByMa(String Ma) {
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "DELETE FROM SanPham WHERE MaSanPham=?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, Ma);
            stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<SanPhamChiTiet> searchByMa(String keyword) {
        String sql = "select IdSanPham,MaSanPham,TenSanPham from SanPham WHERE  MaSanPham= ?";
        list.clear();
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, keyword);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                SanPhamChiTiet spct = new SanPhamChiTiet();
                spct.setIdSanPham(rs.getInt(1));
                //spct.setMaSanPham(rs.getString(2));
                spct.setTenSanPham(rs.getString(3));
                list.add(spct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
