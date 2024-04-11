package service.Impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Size;
import ultil.DBConnect;

public class SizeServiceImpl {

    List<Size> listsize = new ArrayList<>();

    public List<Size> getAllSize() {
        listsize.clear();
        try {
            String sql = "select MaSize, Size from Size";
            Connection con = DBConnect.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Size size = new Size();
                size.setMaSize(rs.getString(1));
                size.setSize(rs.getString(2));
                listsize.add(size);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listsize;
    }

    public Size getRowSize(int rowSize) {
        return listsize.get(rowSize);
    }

    public void Them(Size size) {
        try {
            String sql = "Insert into Size(MaSize,Size) VALUES(?,?)";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, size.getMaSize());
            stm.setString(2, size.getSize());
            stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void update(Size size) {
        try {
            String sql = "Update Size set Size=?  where MaSize=?";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(2, size.getMaSize());
            stm.setString(1, size.getSize());
            stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
