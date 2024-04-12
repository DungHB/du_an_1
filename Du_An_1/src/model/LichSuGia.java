package model;

public class LichSuGia {

    private String maLSGia;
    private double giaBanDau;
    private double giaSau;
    private String ngayBatDau;
    private String ngayKetThuc;

    public LichSuGia() {
    }

    public LichSuGia(String maLSGia, double giaBanDau, double giaSau, String ngayBatDau, String ngayKetThuc) {
        this.maLSGia = maLSGia;
        this.giaBanDau = giaBanDau;
        this.giaSau = giaSau;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getMaLSGia() {
        return maLSGia;
    }

    public void setMaLSGia(String maLSGia) {
        this.maLSGia = maLSGia;
    }

    public double getGiaBanDau() {
        return giaBanDau;
    }

    public void setGiaBanDau(double giaBanDau) {
        this.giaBanDau = giaBanDau;
    }

    public double getGiaSau() {
        return giaSau;
    }

    public void setGiaSau(double giaSau) {
        this.giaSau = giaSau;
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

}
