package service.Impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.HoaDon;
import ultil.DBConnect;

public class HoaDonServiceImpl {

    List<HoaDon> list = new ArrayList<>();

    public List<HoaDon> getAll() {
        list.clear();
        try {
            String sql = "select IdHoaDon,MaHoaDon,NgayTao,TrangThai,TongTien from HoaDon";
            Connection con = DBConnect.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setIdHoaDon(rs.getInt(1));
                hd.setMaHoaDon(rs.getString(2));
                hd.setNgayTao(rs.getString(3));
                hd.setTrangThai(rs.getString(4));
                hd.setTongTien(rs.getDouble(5));
                list.add(hd);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public HoaDon getRow(int row) {
        return list.get(row);
    }

    public HoaDon searchByMa(String Mahd) {
        list.clear();
        try {

            String sql = "select IdHoaDon,MaHoaDon,NgayTao,TrangThai,TongTien from HoaDon WHERE MaHoaDon like ?";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, Mahd);
            ResultSet rs = stm.executeQuery();
            rs = stm.executeQuery();
            while (rs.next()) {
                            HoaDon hd = new HoaDon();

                hd.setIdHoaDon(rs.getInt(1));
                hd.setMaHoaDon(rs.getString(2));
                hd.setNgayTao(rs.getString(3));
                hd.setTrangThai(rs.getString(4));
                hd.setTongTien(rs.getDouble(5));
                list.add(hd);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return (HoaDon) list;
    }

}
