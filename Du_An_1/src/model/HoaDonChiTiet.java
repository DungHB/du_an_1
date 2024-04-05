package model;

public class HoaDonChiTiet {

    private int idHoaDonChiTiet;
    private int idHoaDon;
    private int idSanPhamChiTiet;
    private double donGia;
    private double donGiaSau;
    private int soLuong;
    private double thanhTien;
    private String trangThai;
    private String tenSanPham;
    private int size;
    private String mauSac;
    private String tenChatLieu;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(int idHoaDonChiTiet, int idHoaDon, int idSanPhamChiTiet, double donGia, double donGiaSau, int soLuong, double thanhTien, String trangThai, String tenSanPham, int size, String mauSac, String tenChatLieu) {
        this.idHoaDonChiTiet = idHoaDonChiTiet;
        this.idHoaDon = idHoaDon;
        this.idSanPhamChiTiet = idSanPhamChiTiet;
        this.donGia = donGia;
        this.donGiaSau = donGiaSau;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
        this.trangThai = trangThai;
        this.tenSanPham = tenSanPham;
        this.size = size;
        this.mauSac = mauSac;
        this.tenChatLieu = tenChatLieu;
    }

    public HoaDonChiTiet(int idHoaDon, int idSanPhamChiTiet, int soLuong) {
        this.idHoaDon = idHoaDon;
        this.idSanPhamChiTiet = idSanPhamChiTiet;
        this.soLuong = soLuong;
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

    public double getDonGiaSau() {
        return donGiaSau;
    }

    public void setDonGiaSau(double donGiaSau) {
        this.donGiaSau = donGiaSau;
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

    @Override
    public String toString() {
        return "HoaDonChiTiet{" + "idHoaDonChiTiet=" + idHoaDonChiTiet + ", idHoaDon=" + idHoaDon + ", idSanPhamChiTiet=" + idSanPhamChiTiet + ", donGia=" + donGia + ", donGiaSau=" + donGiaSau + ", soLuong=" + soLuong + ", thanhTien=" + thanhTien + ", trangThai=" + trangThai + ", tenSanPham=" + tenSanPham + ", size=" + size + ", mauSac=" + mauSac + ", tenChatLieu=" + tenChatLieu + '}';
    }

    public void inThongTin() {
        System.out.println("HoaDonChiTiet{" + "idHoaDonChiTiet=" + idHoaDonChiTiet + ", idHoaDon=" + idHoaDon + ", idSanPhamChiTiet=" + idSanPhamChiTiet + ", donGia=" + donGia + ", donGiaSau=" + donGiaSau + ", soLuong=" + soLuong + ", thanhTien=" + thanhTien + ", trangThai=" + trangThai + ", tenSanPham=" + tenSanPham + ", size=" + size + ", mauSac=" + mauSac + ", tenChatLieu=" + tenChatLieu + '}');
    }
}
