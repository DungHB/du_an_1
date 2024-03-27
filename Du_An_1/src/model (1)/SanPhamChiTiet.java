package model;

public class SanPhamChiTiet {

    private int idSanPhamChiTiet;
    private int idSanPham;
    private int idChatLieu;
    private int idMauSac;
    private int idSize;
    private double gia;
    private int soLuong;
    private int idLSGia;
    private double giaBanDau;
    private String tenSanPham;
    private String tenChatLieu;
    private String tenMauSac;
    private int size;

    public SanPhamChiTiet() {
    }

    public SanPhamChiTiet(int idSanPhamChiTiet, int idSanPham, int idChatLieu, int idMauSac, int idSize, double gia, int soLuong, int idLSGia, double giaBanDau, String tenSanPham, String tenChatLieu, String tenMauSac, int size) {
        this.idSanPhamChiTiet = idSanPhamChiTiet;
        this.idSanPham = idSanPham;
        this.idChatLieu = idChatLieu;
        this.idMauSac = idMauSac;
        this.idSize = idSize;
        this.gia = gia;
        this.soLuong = soLuong;
        this.idLSGia = idLSGia;
        this.giaBanDau = giaBanDau;
        this.tenSanPham = tenSanPham;
        this.tenChatLieu = tenChatLieu;
        this.tenMauSac = tenMauSac;
        this.size = size;
    }

    public int getIdSanPhamChiTiet() {
        return idSanPhamChiTiet;
    }

    public void setIdSanPhamChiTiet(int idSanPhamChiTiet) {
        this.idSanPhamChiTiet = idSanPhamChiTiet;
    }

    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

    public int getIdChatLieu() {
        return idChatLieu;
    }

    public void setIdChatLieu(int idChatLieu) {
        this.idChatLieu = idChatLieu;
    }

    public int getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(int idMauSac) {
        this.idMauSac = idMauSac;
    }

    public int getIdSize() {
        return idSize;
    }

    public void setIdSize(int idSize) {
        this.idSize = idSize;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getIdLSGia() {
        return idLSGia;
    }

    public void setIdLSGia(int idLSGia) {
        this.idLSGia = idLSGia;
    }

    public double getGiaBanDau() {
        return giaBanDau;
    }

    public void setGiaBanDau(double giaBanDau) {
        this.giaBanDau = giaBanDau;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getTenChatLieu() {
        return tenChatLieu;
    }

    public void setTenChatLieu(String tenChatLieu) {
        this.tenChatLieu = tenChatLieu;
    }

    public String getTenMauSac() {
        return tenMauSac;
    }

    public void setTenMauSac(String tenMauSac) {
        this.tenMauSac = tenMauSac;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
