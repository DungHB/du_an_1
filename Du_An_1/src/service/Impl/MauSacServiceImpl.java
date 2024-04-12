package service.Impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.MauSac;
import ultil.DBConnect;

public class MauSacServiceImpl {

    List<MauSac> listMau = new ArrayList<>();

    public List<MauSac> getAllMau() {
        listMau.clear();
        try {
            String sql = "select MaMauSac,TenmauSac from MauSac";
            Connection con = DBConnect.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                MauSac mausac = new MauSac();
                mausac.setMaMauSac(rs.getString(1));
                mausac.setTenMauSac(rs.getString(2));
                listMau.add(mausac);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listMau;
    }

    public MauSac getRowMau(int rowMau) {
        return listMau.get(rowMau);
    }

    public void Them(MauSac mausac) {
        try {
            String sql = "insert into MauSac(MaMauSac,TenMauSac)values(?,?)";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, mausac.getMaMauSac());
            stm.setString(2, mausac.getTenMauSac());
            stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void update(MauSac mausac) {
        try {
            String sql = "Update MauSac set TenMauSac=?  where MaMauSac=?";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, mausac.getTenMauSac());
            stm.setString(2, mausac.getMaMauSac());
            stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
