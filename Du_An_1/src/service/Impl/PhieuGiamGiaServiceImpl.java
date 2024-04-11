package service.Impl;

import java.util.ArrayList;
import model.PhieuGiamGia;
import service.PhieuGiamGiaService;
import java.sql.*;
import ultil.DBConnect;

public class PhieuGiamGiaServiceImpl implements PhieuGiamGiaService {

    ArrayList<PhieuGiamGia> listPGG = new ArrayList<>();

    @Override
    public ArrayList<PhieuGiamGia> showHoaDonTheoVoucher(Integer tongTien) {
        listPGG.clear();
        try {
            String sql = "select * from VoucherGiamGia where ? >= YeuCauDonHang and NgayKetThuc >= CURRENT_TIMESTAMP order by GiaTriGiam desc";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, tongTien);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                PhieuGiamGia pgg = new PhieuGiamGia();
                pgg.setMaPhieuGiamGia(rs.getString(1));
                pgg.setTenPhieuGiamGia(rs.getString(2));
                pgg.setNgayBatDau(rs.getString(3));
                pgg.setNgayKetThuc(rs.getString(4));
                pgg.setSoLuongPGG(rs.getInt(5));
                pgg.setGiaTriGiam(rs.getDouble(6));
                pgg.setGiaTriYeuCau(rs.getDouble(7));
                listPGG.add(pgg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPGG;
    }

    @Override
    public Integer layGiaGiamVoucher(String maPGG) {
        Integer gia = 0;
        try {
            String sql = "select GiaTriGiam from VoucherGiamGia where MaVoucherGiamGia = ?";
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, maPGG);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return gia = rs.getInt(1);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gia;
    }

    @Override
    public ArrayList<PhieuGiamGia> getAllVoucher() {
        listPGG.clear();
        try {
            String sql = "select * from VoucherGiamGia";
            Connection conn = DBConnect.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                PhieuGiamGia vc = new PhieuGiamGia();
                vc.setMaPhieuGiamGia(rs.getString(1));
                vc.setTenPhieuGiamGia(rs.getString(2));
                vc.setNgayBatDau(rs.getString(3));
                vc.setNgayKetThuc(rs.getString(4));
                vc.setSoLuongPGG(rs.getInt(5));
                vc.setGiaTriGiam(rs.getDouble(6));
                vc.setGiaTriYeuCau(rs.getDouble(7));
                listPGG.add(vc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPGG;
    }

    @Override
    public String updateSoLuongVoucherTru(String maVoucher) {
        String sql = "update VoucherGiamGia set SoLuong = SoLuong - 1 where MaVoucherGiamGia = ?";
        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, maVoucher);
            stm.executeUpdate();
            conn.close();
            return "Số lượng voucher " + maVoucher + " -1";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Error";
    }

    @Override
    public PhieuGiamGia findKhuyenMaiByMaKhuyenMai(String maPGG) {
        PhieuGiamGia km = null;
        String sql = "select * from VoucherGiamGia where MaVoucherGiamGia = ?";
        try {
            Connection conn = DBConnect.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, maPGG);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                km = new PhieuGiamGia(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getDouble(6),
                        rs.getDouble(7));
            }
            return km;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
