package service.Impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.NguoiDung;
import ultil.DbConnect;
import view.NhanVienView;

public class NguoiDungServiceImpl {

    List<NguoiDung> list;
    java.sql.Connection con = null;
    PreparedStatement ps = null;
    Statement stm = null;
    ResultSet rs = null;
    String sql = null;

    public List<NguoiDung> getAll() {
        list = new ArrayList<>();
        list.clear();
        sql = "select * from NguoiDung";
        try {
            con = DbConnect.getConnection();
            stm = con.createStatement();
            rs =stm.executeQuery(sql);
            while (rs.next()) {
                NguoiDung ND = new NguoiDung();
                ND.setIdNguoiDung(rs.getInt(1));
                ND.setMaNguoiDung(rs.getString(2));
                ND.setTenNguoiDung(rs.getString(3));
                ND.setSdt(rs.getString(4));
                ND.setDiaChi(rs.getString(5));
                ND.setNgaySinh(rs.getString(6));
                ND.setGioiTinh(rs.getBoolean(7));
                ND.setMatKhau(rs.getString(8));
                ND.setIdChucVu(rs.getInt(9));
                ND.setTrangThai(rs.getBoolean(10));
                list.add(ND);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public NguoiDung getRow(int row) {
        return list.get(row);
    }


    public int insertND(NguoiDung ND) {
        sql = " insert into NguoiDung values(?,?,?,?,?,?,?,?,?,?)";
        try {
            con = DbConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ND.getIdNguoiDung());
            ps.setString(2, ND.getMaNguoiDung());
            ps.setString(3, ND.getTenNguoiDung());
            ps.setString(4, ND.getSdt());
            ps.setString(5, ND.getDiaChi());
            ps.setString(6, ND.getNgaySinh());
            ps.setBoolean(7, ND.isGioiTinh());
            ps.setString(8, ND.getMatKhau());
            ps.setInt(9, ND.getIdChucVu());
            ps.setBoolean(10, ND.isTrangThai());
            if(ps.executeUpdate() > 0){
                System.out.println("Thêm thành công");
                return 1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int Update(String ma, NguoiDung nd) {
        sql = "Update NguoiDung set IdNguoiDung = ? , MaNguoiDung = ?, TenNguoiDung = ?, Sdt = ? ,DiaChi = ? , NgaySinh = ? , GioiTinh = ? , MatKhau = ?  ,IdChucvu = ? , TrangThai = ? \n" + "where maNguoiDung = ?;";
        try {
            con = DbConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, nd.getIdNguoiDung());
            ps.setString(2, nd.getMaNguoiDung());
            ps.setString(3, nd.getTenNguoiDung());
            ps.setString(4, nd.getSdt());
            ps.setString(5, nd.getDiaChi());
            ps.setString(6, nd.getNgaySinh());
            ps.setBoolean(7, nd.isGioiTinh());
            ps.setString(8, nd.getMatKhau());
            ps.setInt(9, nd.getIdChucVu());
            ps.setBoolean(10, nd.isTrangThai());
            ps.setString(11, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public NguoiDung findTen(String tenNhanVien) throws SQLException {
        rs = null;
        ps = null;
        try {
            sql = "Select * from NguoiDung Where =" + tenNhanVien;
            con = DbConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                NguoiDung ND = new NguoiDung();
                ND.setIdNguoiDung(rs.getInt(1));
                ND.setMaNguoiDung(rs.getString(2));
                ND.setTenNguoiDung(rs.getString(3));
                ND.setSdt(rs.getString(4));
                ND.setDiaChi(rs.getString(5));
                ND.setNgaySinh(rs.getString(7));
                ND.setGioiTinh(rs.getBoolean(6));
                ND.setMatKhau(rs.getString(8));
                ND.setIdChucVu(rs.getInt(9));
                ND.setTrangThai(rs.getBoolean(10));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
}
