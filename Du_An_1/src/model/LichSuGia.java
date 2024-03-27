package model;

public class LichSuGia {

    private int idLSGia;
    private String maLSGia;
    private double giaBanDau;
    private double giaBanRa;
    private String ngayBatDau;
    private String ngayKetThuc;

    public LichSuGia() {
    }

    public LichSuGia(int idLSGia, String maLSGia, double giaBanDau, double giaBanRa, String ngayBatDau, String ngayKetThuc) {
        this.idLSGia = idLSGia;
        this.maLSGia = maLSGia;
        this.giaBanDau = giaBanDau;
        this.giaBanRa = giaBanRa;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getIdLSGia() {
        return idLSGia;
    }

    public void setIdLSGia(int idLSGia) {
        this.idLSGia = idLSGia;
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

    public double getGiaBanRa() {
        return giaBanRa;
    }

    public void setGiaBanRa(double giaBanRa) {
        this.giaBanRa = giaBanRa;
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
