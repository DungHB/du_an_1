package model;

public class PhieuGiamGia {

    private int idPhieuGiamGia;
    private String maPhieuGiamGia;
    private String ngayBatDau;
    private String ngayKetThuc;
    private int soLuong;
    private double giaTriGiamGia;
    private String trangThai;

    public PhieuGiamGia() {
    }

    public PhieuGiamGia(int idPhieuGiamGia, String maPhieuGiamGia, String ngayBatDau, String ngayKetThuc, int soLuong, double giaTriGiamGia, String trangThai) {
        this.idPhieuGiamGia = idPhieuGiamGia;
        this.maPhieuGiamGia = maPhieuGiamGia;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.soLuong = soLuong;
        this.giaTriGiamGia = giaTriGiamGia;
        this.trangThai = trangThai;
    }

    public int getIdPhieuGiamGia() {
        return idPhieuGiamGia;
    }

    public void setIdPhieuGiamGia(int idPhieuGiamGia) {
        this.idPhieuGiamGia = idPhieuGiamGia;
    }

    public String getMaPhieuGiamGia() {
        return maPhieuGiamGia;
    }

    public void setMaPhieuGiamGia(String maPhieuGiamGia) {
        this.maPhieuGiamGia = maPhieuGiamGia;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaTriGiamGia() {
        return giaTriGiamGia;
    }

    public void setGiaTriGiamGia(double giaTriGiamGia) {
        this.giaTriGiamGia = giaTriGiamGia;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

}
