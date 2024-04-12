package service.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ultil.DBConnect;
import java.sql.*;
import model.SanPhamChiTiet;
import service.SanPhamService;

public class SanPhamChiTietServiceImpl {

    List<SanPhamChiTiet> list = new ArrayList<>();

    public List<SanPhamChiTiet> getAll2() {
        list.clear();
        try {
            String sql = "select DISTINCT ct.MaSPCT, TenSanPham, TenThuongHieu, TenChatLieu, TenMauSac, Size, ct.SoLuong \n"
                    + "from SanPhamChiTiet ct\n"
                    + "join SanPham sp on sp.MaSanpham = ct.MaSanPham\n"
                    + "join ThuongHieu th on th.MaThuongHieu=ct.MaThuonghieu\n"
                    + "join ChatLieu cl on cl.MaChatLieu = ct.MaChatLieu\n"
                    + "join MauSac ms on ms.MaMauSac = ct.MaMauSac\n"
                    + "join Size size on size.MaSize = ct.MaSize\n"
                    + "Group BY ct.MaSPCT, TenSanPham, TenThuongHieu, TenChatLieu, TenMauSac, Size, ct.SoLuong ";
            Connection con = DBConnect.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                SanPhamChiTiet spct = new SanPhamChiTiet();
                spct.setMaSPCT(rs.getString(1));
                spct.setTenSanPham(rs.getString(2));
                spct.setTenThuongHieu(rs.getString(3));
                spct.setTenChatLieu(rs.getString(4));
                spct.setTenMauSac(rs.getString(5));
                spct.setSize(rs.getString(6));
                spct.setSoLuong(rs.getInt(7));
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

    public void Them(SanPhamChiTiet spct) {
        try {
            String sql = "Insert into SanPhamChiTiet(MaSPCT, MaSanPham, MaThuongHieu, MaChatLieu, MaMauSac, MaSize, SoLuong)VALUES(?,?,?,?,?,?,?)";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, spct.getMaSPCT());
            stm.setString(2, spct.getMaSanPham());
            stm.setString(3, spct.getMaThuongHieu());
            stm.setString(4, spct.getMaChatLieu());
            stm.setString(5, spct.getMaMauSac());
            stm.setString(6, spct.getMaSize());
            stm.setInt(7, spct.getSoLuong());
            stm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updatect(SanPhamChiTiet spct) {
        try {
            String sql = "Update SanPhamChiTiet set  MaSanPham=?, MaThuongHieu=?, MaChatLieu=?, MaMauSac=?, MaSize=?, SoLuong=?  where MaSPCT=?";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(7, spct.getMaSPCT());
            stm.setString(1, spct.getMaSanPham());
            stm.setString(2, spct.getMaThuongHieu());
            stm.setString(3, spct.getMaChatLieu());
            stm.setString(4, spct.getMaMauSac());
            stm.setString(5, spct.getMaSize());
            stm.setInt(6, spct.getSoLuong());
            stm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteByMa(String Ma) {
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "DELETE FROM SanPham WHERE MaSPCT=?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, Ma);
            stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<SanPhamChiTiet> searchByMa(String keywordspct) {
        String sql = " select DISTINCT ct.MaSPCT, TenSanPham, TenThuongHieu, TenChatLieu, TenMauSac, Size, ct.SoLuong \n"
                + "from SanPhamChiTiet ct\n"
                + "join SanPham sp on sp.MaSanpham = ct.MaSanPham\n"
                + "join ThuongHieu th on th.MaThuongHieu=ct.MaThuonghieu\n"
                + "join ChatLieu cl on cl.MaChatLieu = ct.MaChatLieu\n"
                + "join MauSac ms on ms.MaMauSac = ct.MaMauSac\n"
                + "join Size size on size.MaSize = ct.MaSize\n"
                + "where MaSPCT=? \n"
                + "Group BY ct.MaSPCT, TenSanPham, TenThuongHieu, TenChatLieu, TenMauSac, Size, ct.SoLuong ";
        list.clear();
        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, keywordspct);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                SanPhamChiTiet spct = new SanPhamChiTiet();
                spct.setMaSPCT(rs.getString(1));
                spct.setMaSanPham(rs.getString(2));
                spct.setMaThuongHieu(rs.getString(3));
                spct.setMaChatLieu(rs.getString(4));
                spct.setMaMauSac(rs.getString(5));
                spct.setMaSize(rs.getString(6));
                spct.setSoLuong(rs.getInt(7));
                list.add(spct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public String getIDSanPham(String tenSP) {
        list.clear();
        try {
            String sql = "Select MaSanPham from SanPham where TenSanPham = ?";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, tenSP);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                return rs.getString(1);
            }
            stm.executeUpdate();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();

        }

        return null;
    }

    public String getIDMauSac(String tenMS) {
        list.clear();
        String sql = "Select MaMauSac from MauSac where TenMauSac = ?";
        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, tenMS);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {

                return rs.getString(1);
            }
            stm.executeUpdate();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();

        }

        return null;
    }

    public String getIDKichThuoc(String tenKT) {
        list.clear();
        String sql = "Select MaSize from Size where Size = ?";
        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, tenKT);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {

                return rs.getString(1);
            }
            stm.executeUpdate();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();

        }

        return null;
    }

    public String getIDChatLieu(String tenCL) {
        list.clear();
        String sql = "Select MaChatLieu from ChatLieu where TenChatLieu = ?";
        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, tenCL);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {

                return rs.getString(1);
            }
            stm.executeUpdate();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();

        }

        return null;
    }

    public String getIDTH(String tenTH) {
        list.clear();
        String sql = "Select MaThuongHieu from ThuongHieu where TenThuongHieu = ?";
        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, tenTH);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {

                return rs.getString(1);
            }
            stm.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();

        }

        return null;
    }

    public static void main(String[] args) {
        //SanPhamChiTietServiceImpl ser = new SanPhamChiTietServiceImpl();
        //System.out.println(ser.getIDNCC("Công ty TNHH A"));
        //System.out.println(ser.getMaSPCT("SP001"));
    }
}
