package service.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.HoaDonChiTiet;
import ultil.DBConnect;
import java.sql.*;

public class HoaDonChiTietServiceImpl {
List<HoaDonChiTiet> list=new ArrayList<>();
      
       public List<HoaDonChiTiet> getAllGioHangByIDHoaDon(Integer IdHoaDon) {
        String sql="SELECT HDT.IdHoaDonChiTiet, SP.TenSanPham, SZ.Size, MS.TenMauSac, HDT.SoLuong, SPC.Gia, HDT.ThanhTien, SPC.IdSanPhamChiTiet,  CL.TenChatLieu\n" +
"FROM HoaDonChiTiet HDT\n" +
"INNER JOIN SanPhamChiTiet SPC ON HDT.IdSanPhamChiTiet = SPC.IdSanPhamChiTiet\n" +
"INNER JOIN SanPham SP ON SPC.IdSanPham = SP.IdSanPham\n" +
"INNER JOIN Size SZ ON SPC.IdSize = SZ.IdSize\n" +
"INNER JOIN MauSac MS ON SPC.IdMauSac = MS.IdMauSac\n" +
"INNER JOIN HoaDon HD ON HDT.IdHoaDon = HD.IdHoaDon\n" +
"INNER JOIN ChatLieu CL ON SPC.IdChatLieu = CL.IdChatLieu\n" +
"WHERE HD.IdHoaDon =  ?";
        list.clear();
           try {
               Connection conn=DBConnect.getConnection();
               PreparedStatement stm=conn.prepareStatement(sql);
      stm.setInt(1, IdHoaDon);
               ResultSet rs=stm.executeQuery();
               while(rs.next()){
                   HoaDonChiTiet ct=new HoaDonChiTiet();
                    ct.setIdHoaDonChiTiet(rs.getInt("IdHoaDonChiTiet"));
                   ct.setTenSanPham(rs.getString("TenSanPham"));
                   ct.setDonGia(rs.getDouble("Gia"));
                   ct.setSize(rs.getInt("Size"));
                   ct.setMauSac(rs.getString("TenMauSac"));
                   ct.setSoLuong(rs.getInt("SoLuong"));
                   ct.setTenChatLieu(rs.getString("TenChatLieu"));
                   ct.setThanhTien(rs.getDouble("ThanhTien"));
                   ct.setIdSanPhamChiTiet(rs.getInt("IdSanPhamChiTiet"));    
                   list.add(ct);
                  conn.close();
                   
               }
               
               
               
               
           } catch (Exception e) {
           }
    return list;
       }
    
    
    
     
}
