package service.Impl;

import java.util.ArrayList;
import java.util.List;
import model.SanPham;
import service.SanPhamService;
import java.sql.*;
import ultil.DBConnect;

public class SanPhamServiceImpl implements SanPhamService {

    ArrayList<SanPham> list = new ArrayList<>();

    @Override
    public List<SanPham> getAll() {
        list.clear();
        try {
            String sql = "SELECT sp.idSanPham, sp.maSanPham, sp.tenSanPham, tl.tenTheLoai, th.tenThuongHieu, sp.trangThai FROM SanPham sp\n"
                    + "JOIN TheLoai tl ON sp.idTheLoai = tl.idTheLoai\n"
                    + "JOIN ThuongHieu th ON sp.idThuongHieu = th.idThuongHieu";
            Connection conn = DBConnect.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setIdSanPham(rs.getInt(1));
                sp.setMaSanPham(rs.getString(2));
                sp.setTenSanPham(rs.getString(3));
                sp.setIdTheLoai(rs.getInt(4));
                sp.setIdThuongHieu(rs.getInt(5));
                sp.setTrangThai(rs.getString(6));
                list.add(sp);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<SanPham> getSanPhamsByPage(int offset, int limit) {
        list.clear();
        try {
            String sql = "";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, offset);
            stm.setInt(2, limit);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setIdSanPham(rs.getInt(1));
                sp.setMaSanPham(rs.getString(2));
                sp.setTenSanPham(rs.getString(3));
                sp.setIdTheLoai(rs.getInt(4));
                sp.setIdThuongHieu(rs.getInt(5));
                sp.setTrangThai(rs.getString(6));
                list.add(sp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Boolean themSanPham(SanPham sp) {
        try {
            String sql = "";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean capNhatSanPham(SanPham sp) {
        
        return null;
        
    }

    @Override
    public SanPham layThongTinSanPhamTheoId(String idSanPham) {
        
        return null;
        
    }

    @Override
    public SanPham layThongTinSanPhamTheoMa(String maSanPham) {
        
        return null;
        
    }

    @Override
    public int getCountSanPham() {
        
        return 0;
        
    }

    @Override
    public List<SanPham> getSearchSP(String keyWordSP) {
        
        return null;
        
    }

}
