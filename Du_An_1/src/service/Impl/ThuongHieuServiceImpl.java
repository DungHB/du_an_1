package service.Impl;

import java.util.ArrayList;
import java.util.List;
import model.ThuongHieu;
import java.sql.*;
import ultil.DBConnect;
public class ThuongHieuServiceImpl {

    List<ThuongHieu> listTH = new ArrayList<>();

    public List<ThuongHieu> getAllTH() {
        listTH.clear();
        try {
            String sql = "select MaThuongHieu, TenThuongHieu from ThuongHieu";
            Connection con = DBConnect.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                ThuongHieu th = new ThuongHieu();
                th.setMaThuongHieu(rs.getString(1));
                th.setTenThuongHieu(rs.getString(2));
                listTH.add(th);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listTH;
    }

    public ThuongHieu  getRowTH(int rowTh) {
        return listTH.get(rowTh);
    }

    public void Them(ThuongHieu th) {
        try {
            String sql = "Insert into ThuongHieu(MaThuongHieu,TenThuongHieu) VALUES(?,?)";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, th.getMaThuongHieu());
            stm.setString(2, th.getTenThuongHieu());
            stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void update(ThuongHieu th) {
        try {
            String sql = "Update ThuongHieu set TenThuongHieu=?  where MaThuongHieu=?";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(2, th.getMaThuongHieu());
            stm.setString(1, th.getTenThuongHieu());
            stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
