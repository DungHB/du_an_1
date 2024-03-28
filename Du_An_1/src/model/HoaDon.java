package model;

import java.util.Date;

public class HoaDon {

    private int idHoaDon;
    private String maHoaDon;
    private Date ngayTao;
    private String ghiChu;
    private int idNhanVien;
    private int idKhachHang;
    private double tongTien;
    private String trangThai;
    private String tenNhanVien;
    private String tenKhachHang;

    public HoaDon() {
    }

    public HoaDon(int idHoaDon, String maHoaDon, Date ngayTao, String ghiChu, int idNhanVien, int idKhachHang, double tongTien, String trangThai, String tenNhanVien, String tenKhachHang) {
        this.idHoaDon = idHoaDon;
        this.maHoaDon = maHoaDon;
        this.ngayTao = ngayTao;
        this.ghiChu = ghiChu;
        this.idNhanVien = idNhanVien;
        this.idKhachHang = idKhachHang;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
        this.tenNhanVien = tenNhanVien;
        this.tenKhachHang = tenKhachHang;
    }

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public int getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(int idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

}
