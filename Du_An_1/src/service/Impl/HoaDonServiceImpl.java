package service.Impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.HoaDon;
import java.sql.*;
import ultil.DBConnect;

public class HoaDonServiceImpl {
 List<HoaDon> list=new ArrayList<>();
    public List<HoaDon> getAll(){
        list.clear();
        String sql="SELECT \n" +
"    HD.IdHoaDon, \n" +
"    HD.MaHoaDon , \n" +
"    HD.NgayTao , \n" +
"    HD.TrangThai, \n" +
"    HD.TongTien , \n" +
"    NV.TenNhanVien, \n" +
"    KH.TenKhachHang,\n" +
"	HD.TrangThai\n" +
"FROM \n" +
"    HoaDon HD\n" +
"INNER JOIN \n" +
"    NguoiDung NV ON HD.IdNguoiDung = NV.IdNguoiDung\n" +
"LEFT JOIN \n" +
"    KhachHang KH ON HD.IdKhachHang = KH.IdKhachHang";
        try {
            Connection conn=DBConnect.getConnection();
            Statement stm=conn.createStatement();
            ResultSet rs=stm.executeQuery(sql);
            while(rs.next()){
                HoaDon hd=new HoaDon();
                hd.setIdHoaDon(rs.getInt(1));
                hd.setMaHoaDon(rs.getString(2));
                hd.setNgayTao(rs.getString(3));
                hd.setTrangThai(rs.getString(4));
                hd.setTongTien(rs.getDouble(5));
                hd.setTenNhanVien(rs.getString(6));
                hd.setTenKhachHang(rs.getString(7));
                list.add(hd);
                        
                
            }
            
            
        } catch (Exception e) {
        }
        return list;
        
    }
    public List<HoaDon> getHoaDonbyMa(String maHoaDon){
        
        String sql="SELECT \n" +
"    HD.IdHoaDon, \n" +
"    HD.MaHoaDon , \n" +
"    HD.NgayTao , \n" +
"    HD.TrangThai, \n" +
"    HD.TongTien , \n" +
"    NV.TenNhanVien, \n" +
"    KH.TenKhachHang,\n" +
"	HD.TrangThai\n" +
"FROM \n" +
"    HoaDon HD\n" +
"INNER JOIN \n" +
"    NguoiDung NV ON HD.IdNguoiDung = NV.IdNguoiDung\n" +
"LEFT JOIN \n" +
"    KhachHang KH ON HD.IdKhachHang = KH.IdKhachHang    "+
                "Where MaHoaDon=?";
            list.clear();
                
        try {
            Connection conn=DBConnect.getConnection();
            PreparedStatement stm=conn.prepareStatement(sql);
            stm.setString(1, maHoaDon);
            ResultSet rs=stm.executeQuery();
            while(rs.next()){
                HoaDon hd=new HoaDon();
                 hd.setIdHoaDon(rs.getInt(1));
                    hd.setMaHoaDon(rs.getString(2));
                    hd.setNgayTao(rs.getString(3));
                    hd.setTrangThai(rs.getString(4));
                    
                    hd.setTongTien(rs.getDouble(5));
                    hd.setTenNhanVien(rs.getString(6));
                    hd.setTenKhachHang(rs.getString(7));
                    
                   
                    list.add(hd);
                    
                
            }
            
            
        } catch (Exception e) {
        }
        
        return list;
    }
        private static final String SQL_GET_ALL = "SELECT * FROM HoaDon";
  public List<HoaDon> getAll1() {
        try ( Connection connection = DBConnect.getConnection();  PreparedStatement preparedStatement = connection.prepareStatement(SQL_GET_ALL);  ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                HoaDon hoaDon = new HoaDon();
                hoaDon.setIdHoaDon(resultSet.getInt("IdHoaDon"));
                hoaDon.setMaHoaDon(resultSet.getString("MaHoaDon"));
                hoaDon.setNgayTao(resultSet.getString("NgayTao"));
                hoaDon.setGhiChu(resultSet.getString("GhiChu"));
                hoaDon.setIdNhanVien(resultSet.getInt("IdNhanVien"));
                hoaDon.setIdKhachHang(resultSet.getInt("IdKhachHang"));
                hoaDon.setTongTien(resultSet.getLong("TongTien"));
                hoaDon.setTrangThai(resultSet.getString("TrangThai"));
                list.add(hoaDon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
