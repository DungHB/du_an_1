package model;

public class HoaDonChiTiet {

    private int idHoaDonChiTiet;
    private int idHoaDon;
    private int idSanPhamChiTiet;
    private double donGia;
    private int soLuong;
    private double thanhTien;
    private String trangThai;
    private String tenSanPham;
    private int size;
    private String mauSac;
    private String tenChatLieu;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(int idHoaDonChiTiet, int idHoaDon, int idSanPhamChiTiet, double donGia, int soLuong, double thanhTien, String trangThai, String tenSanPham, int size, String mauSac, String tenChatLieu) {
        this.idHoaDonChiTiet = idHoaDonChiTiet;
        this.idHoaDon = idHoaDon;
        this.idSanPhamChiTiet = idSanPhamChiTiet;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
        this.trangThai = trangThai;
        this.tenSanPham = tenSanPham;
        this.size = size;
        this.mauSac = mauSac;
        this.tenChatLieu = tenChatLieu;
    }

    public int getIdHoaDonChiTiet() {
        return idHoaDonChiTiet;
    }

    public void setIdHoaDonChiTiet(int idHoaDonChiTiet) {
        this.idHoaDonChiTiet = idHoaDonChiTiet;
    }

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public int getIdSanPhamChiTiet() {
        return idSanPhamChiTiet;
    }

    public void setIdSanPhamChiTiet(int idSanPhamChiTiet) {
        this.idSanPhamChiTiet = idSanPhamChiTiet;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getTenChatLieu() {
        return tenChatLieu;
    }

    public void setTenChatLieu(String tenChatLieu) {
        this.tenChatLieu = tenChatLieu;
    }

}
