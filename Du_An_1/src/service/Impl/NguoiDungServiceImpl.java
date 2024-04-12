package service.Impl;

import com.sun.source.tree.StatementTree;
import java.util.ArrayList;
import java.util.List;
import model.NguoiDung;
import service.NguoiDungService;
import java.sql.*;
import model.*;
import ultil.DBConnect;

public class NguoiDungServiceImpl implements NguoiDungService {

    ArrayList<NguoiDung> listNguoiDung = new ArrayList<>();
    ArrayList<Login> listLogin = new ArrayList<>();
    ArrayList<Login> listGetNameLogin = new ArrayList<>();

    @Override
    public List<NguoiDung> getAll() {
        listNguoiDung.clear();
        try {
            String sql = "SELECT * FROM NguoiDung";
            Connection conn = DBConnect.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                NguoiDung nd = mapNguoiDung(rs);
                listNguoiDung.add(nd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNguoiDung;
    }

    @Override
    public NguoiDung getLoginInfo(String maNguoiDung, String matKhau) {
        NguoiDung nd = new NguoiDung();
        try {
            String sql = "SELECT * FROM NguoiDung WHERE MaNguoiDung = ? AND MatKhau = ?";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, maNguoiDung);
            stm.setString(2, matKhau);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                NguoiDung nguoiDung = mapNguoiDung(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nd;
    }

    private NguoiDung mapNguoiDung(ResultSet rs) throws SQLException {
        NguoiDung nd = new NguoiDung();
//        nd.setIdNguoiDung(rs.getInt(1));
//        nd.setMaNguoiDung(rs.getString(2));
//        nd.setTenNguoiDung(rs.getString(3));
//        nd.setSdt(rs.getString(4));
//        nd.setDiaChi(rs.getString(5));
//        nd.setNgaySinh(rs.getDate(6));
//        nd.setGioiTinh(rs.getString(7));
//        nd.setMatKhau(rs.getString(8));
//        nd.setIdChucVu(rs.getInt(9));
//        nd.setTrangThai(rs.getString(10));
        return nd;
    }

    @Override
    public ArrayList<Login> LoginSearch(String tenDN, String mk) {
        listLogin.clear();
        try {
            String sql = "select TenDangNhap, MatKhau, ChucVu.MaChucVu, Email from NguoiDung\n"
                    + "join ChucVu on NguoiDung.MaChucVu = ChucVu.MaChucVu\n"
                    + "where NguoiDung.TenDangNhap = ? and MatKhau = ?";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, tenDN);
            stm.setString(2, mk);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Login lg = new Login();
                lg.setTenDangNhap(rs.getString(1));
                lg.setMatKhau(rs.getString(2));
                lg.setChucVu(rs.getString(3));
                lg.setEmail(rs.getString(4));
                listLogin.add(lg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listLogin;
    }

    @Override
    public ArrayList<Login> tenNV(Login lg) {
        listGetNameLogin.add(lg);
        return listGetNameLogin;
    }

    @Override
    public String listLG() {
        return listGetNameLogin.get(0).getTenDangNhap();
    }

    @Override
    public ArrayList<NguoiDung> fogotPassword(String tenDN, String sdt) {
        listNguoiDung.clear();
        try {
            String sql = "select TenDangNhap, MatKhau, Sdt from NguoiDung\n"
                    + "where TenDangNhap = ? and Sdt = ?";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, tenDN);
            stm.setString(2, sdt);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                NguoiDung nd = new NguoiDung();
                nd.setTenDN(rs.getString(1));
                nd.setMatKhau(rs.getString(2));
                nd.setSdt(rs.getString(3));
                listNguoiDung.add(nd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNguoiDung;
    }

}
