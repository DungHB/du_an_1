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
    ResultSet rs = null;
    String sql = null;

    public List<NguoiDung> getAll() {
        list = new ArrayList<>();
        sql = "select IDNguoiDung, MaNguoiDung, TenNhanVien, Sdt, DiaChi, NgaySinh, GioiTinh, TenChucVu, MatKhau, TrangThai from NguoiDung";
        try {
            con = DbConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                NguoiDung ND = new NguoiDung();
                ND.setIdNhanvien(rs.getInt(1));
                ND.setMaNhanVien(rs.getString(2));
                ND.settenNhanvien(rs.getString(3));
                ND.setSdt(rs.getString(4));
                ND.setDiaChi(rs.getString(5));
                ND.setNgaySinh(rs.getString(7));
                ND.setGioiTinh(rs.getString(6));
                ND.setMatKhau(rs.getString(8));
                ND.setTenChucVu(rs.getString(9));
                ND.setTrangThai(rs.getString(10));
                list.add(ND);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public NguoiDung getRow(int row){
        return list.get(row);
    }
    
    public int insertND(NguoiDung ND){
        sql =" insert into NguoiDung values(?,?,?,?,?,?,?,?,?,?)";
        try {
            con = DbConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ND.getIdNhanvien());
            ps.setString(2, ND.getMaNhanVien());
            ps.setString(3, ND.gettenNhanvien());
            ps.setString(4, ND.getSdt());
            ps.setString(5, ND.getDiaChi());
            ps.setString(6, ND.getNgaySinh());
            ps.setString(7, ND.getGioiTinh());
            ps.setString(8, ND.getMatKhau());
            ps.setString(9, ND.getTenChucVu());
            ps.setString(10, ND.getTrangThai());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
public int Update(String ma , NguoiDung nd){
    sql="Update NguoiDung set IdNguoiDung = ? , MaNguoiDung = ?, TenNhanVien = ?, Sdt = ? ,DiaChi = ? , NgaySinh = ? , GioiTinh = ? , MatKhau = ? , tenChucvu = ? , TrangThai = ? \n"+"where MaNguoiDung = ?;";
    try {
        con = DbConnect.getConnection();
        ps = con.prepareStatement(sql);
        ps.setInt(1, nd.getIdNhanvien());
        ps.setString(2, nd.getMaNhanVien());
        ps.setString(3, nd.getMaNhanVien());
        ps.setString(4, nd.getMaNhanVien());
        ps.setString(5, nd.getMaNhanVien());
        ps.setString(6, nd.getMaNhanVien());
        ps.setString(7, nd.getMaNhanVien());
        ps.setString(8, nd.getMaNhanVien());
        ps.setString(9, nd.getMaNhanVien());
        ps.setString(10, nd.getMaNhanVien());
        ps.setString(11, nd.getMaNhanVien());
        ps.setString(12, ma);
        return ps.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
        return 0;
    }
}
public List<NguoiDung> timTheoTen(String ten) {
        try {
            list = new ArrayList<>();
            con = DbConnect.getConnection();
            sql = " select * from NguoiDung where hoten like ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, "%"+ten+"%");
            rs = ps.executeQuery();
            while (rs.next()) {
                NguoiDung ND = new NguoiDung(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
                list.add(ND);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
              return null;
        }
      
    }
}
