/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;
import Model.Login;
import java.sql.*;

/**
 *
 * @author PC
 */
public class LoginService {
     public Login selectByND(String MaNguoiDung) {
        String sql = "SELECT MaNguoiDung,TenNhanVien,  Sdt, DiaChi, NgaySinh, GioiTinh, MatKhau,IdChucVu FROM NguoiDung WHERE MaNguoiDung=?";
        try (
                Connection con = DbConnect.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, MaNguoiDung);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Login login = new Login();                   
                    login.setMaNguoiDung(rs.getString("MaNguoiDung"));
                    login.setTenNhanVien(rs.getString("TenNhanVien"));
                    login.setSdt(rs.getString("Sdt"));
                    login.setMatKhau(rs.getString("DiaChi"));
                    login.setNgaySinh(rs.getString("NgaySinh"));
                    login.setGioiTinh(rs.getString("GioiTinh"));
                    login.setMatKhau(rs.getString("MatKhau"));
                    login.setId(rs.getInt("IdChucVu"));
                    return login;
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static Login lg = null;

    
}
