package service.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.SanPham;
import ultil.DBConnect;
import java.sql.*;

public class SanPhamServiceImpl {

    List<SanPham> list = new ArrayList<>();

    public List<SanPham> getAll1() {
        list.clear();
        try {
            String sql = "select MaSanPham, TenSanPham, TheLoai from SanPham";
            Connection con = DBConnect.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSanPham(rs.getString(1));
                sp.setTenSanPham(rs.getString(2));
                sp.setTheloai(rs.getString(3));
                //sp.setTenThuonghieu(rs.getString(5));
                list.add(sp);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public SanPham getRow(int row) {
        return list.get(row);
    }

    public void Them(SanPham sp) {
        try {
            String sql = "Insert into SanPham(MaSanPham, TenSanPham, TheLoai)VALUES(?,?,?)";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, sp.getMaSanPham());
            stm.setString(2, sp.getTenSanPham());
            stm.setString(3, sp.getTheloai());
            //stm.setInt(4, sp.getIdThuongHieu());
            stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void update(SanPham sp) {
        try {
            String sql = "Update SanPham set TenSanPham=?,TheLoai=?  where MaSanPham=?";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, sp.getTenSanPham());
            stm.setString(2, sp.getTheloai());
            //stm.setInt(3, sp.getIdThuongHieu());
            stm.setString(3, sp.getMaSanPham());
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

    public List<SanPham> searchByMa(String keyword) {
        String sql = "select MaSanPham,TenSanPham,TheLoai from SanPham where MaSanPham = ?";
        list.clear();
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, keyword);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSanPham(rs.getString(1));
                sp.setTenSanPham(rs.getString(2));
                sp.setTheloai(rs.getString(3));
                list.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
