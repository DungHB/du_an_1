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

    @Override
    public boolean themNhanVien(NguoiDung nguoiDung) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public NguoiDung getNhanVienByIdNhanVien(String idNhanVien) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<NguoiDung> getAllViewTable() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean suaThongTinNhanVien(NguoiDung nguoiDung) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public NguoiDung getNhanVienByMaNhanVien(String maNhanVien) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<NguoiDung> getAllViewTableByPage(int offset, int limit) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getCountNhanVien() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<NguoiDung> getAllViewTableSearch(String keyWord) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private NguoiDung mapNguoiDung(ResultSet rs) throws SQLException {
        NguoiDung nd = new NguoiDung();
        nd.setIdNguoiDung(rs.getInt(1));
        nd.setMaNguoiDung(rs.getString(2));
        nd.setTenNguoiDung(rs.getString(3));
        nd.setSdt(rs.getString(4));
        nd.setDiaChi(rs.getString(5));
        nd.setNgaySinh(rs.getDate(6));
        nd.setGioiTinh(rs.getString(7));
        nd.setMatKhau(rs.getString(8));
        nd.setIdChucVu(rs.getInt(9));
        nd.setTrangThai(rs.getString(10));
        return nd;
    }

    @Override
    public ArrayList<Login> LoginSearch(String maND, String mk) {
        listLogin.clear();
        try {
            String sql = "SELECT MaNguoiDung, MatKhau, cv.TenChucVu FROM NguoiDung nd\n"
                    + "JOIN ChucVu cv ON nd.IdChucVu = cv.IdChucVu\n"
                    + "WHERE nd.MaNguoiDung = ? AND nd.MatKhau = ?";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, maND);
            stm.setString(2, mk);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Login lg = new Login();
                lg.setMaNguoiDung(rs.getString(1));
                lg.setMatKhau(rs.getString(2));
                lg.setChucVu(rs.getString(3));
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
        return listGetNameLogin.get(0).getMaNguoiDung();
    }

}
