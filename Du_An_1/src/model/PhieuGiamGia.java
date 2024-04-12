package model;

public class PhieuGiamGia {

    private String maPhieuGiamGia;
    private String tenPhieuGiamGia;
    private String ngayBatDau;
    private String ngayKetThuc;
    private Integer soLuongPGG;
    private Double giaTriGiam;
    private Double giaTriYeuCau;

    public PhieuGiamGia() {
    }

    public PhieuGiamGia(String maPhieuGiamGia, String tenPhieuGiamGia, String ngayBatDau, String ngayKetThuc, Integer soLuongPGG, Double giaTriGiam, Double giaTriYeuCau) {
        this.maPhieuGiamGia = maPhieuGiamGia;
        this.tenPhieuGiamGia = tenPhieuGiamGia;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.soLuongPGG = soLuongPGG;
        this.giaTriGiam = giaTriGiam;
        this.giaTriYeuCau = giaTriYeuCau;
    }

    public String getMaPhieuGiamGia() {
        return maPhieuGiamGia;
    }

    public void setMaPhieuGiamGia(String maPhieuGiamGia) {
        this.maPhieuGiamGia = maPhieuGiamGia;
    }

    public String getTenPhieuGiamGia() {
        return tenPhieuGiamGia;
    }

    public void setTenPhieuGiamGia(String tenPhieuGiamGia) {
        this.tenPhieuGiamGia = tenPhieuGiamGia;
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

    public Integer getSoLuongPGG() {
        return soLuongPGG;
    }

    public void setSoLuongPGG(Integer soLuongPGG) {
        this.soLuongPGG = soLuongPGG;
    }

    public Double getGiaTriGiam() {
        return giaTriGiam;
    }

    public void setGiaTriGiam(Double giaTriGiam) {
        this.giaTriGiam = giaTriGiam;
    }

    public Double getGiaTriYeuCau() {
        return giaTriYeuCau;
    }

    public void setGiaTriYeuCau(Double giaTriYeuCau) {
        this.giaTriYeuCau = giaTriYeuCau;
    }

}
