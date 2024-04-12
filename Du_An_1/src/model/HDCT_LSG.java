package model;

public class HDCT_LSG {

    String maHoaDon;
    String maHDCT;
    Integer soLuong;
    double donGiaDau;
    double donGiaSau;
    String maSanPham;
    String tenSanPham;
    String tenSize;
    String tenMauSac;

    public HDCT_LSG() {
    }

    public HDCT_LSG(String maHoaDon, String maHDCT, Integer soLuong, double donGiaDau, double donGiaSau, String maSanPham, String tenSanPham, String tenSize, String tenMauSac) {
        this.maHoaDon = maHoaDon;
        this.maHDCT = maHDCT;
        this.soLuong = soLuong;
        this.donGiaDau = donGiaDau;
        this.donGiaSau = donGiaSau;
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.tenSize = tenSize;
        this.tenMauSac = tenMauSac;
    }
    public HDCT_LSG(String maHoaDon, Integer soLuong, String maSanPham) {
        this.maHoaDon = maHoaDon;
        this.soLuong = soLuong;
        this.maSanPham = maSanPham;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaHDCT() {
        return maHDCT;
    }

    public void setMaHDCT(String maHDCT) {
        this.maHDCT = maHDCT;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGiaDau() {
        return donGiaDau;
    }

    public void setDonGiaDau(double donGiaDau) {
        this.donGiaDau = donGiaDau;
    }

    public double getDonGiaSau() {
        return donGiaSau;
    }

    public void setDonGiaSau(double donGiaSau) {
        this.donGiaSau = donGiaSau;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getTenSize() {
        return tenSize;
    }

    public void setTenSize(String tenSize) {
        this.tenSize = tenSize;
    }

    public String getTenMauSac() {
        return tenMauSac;
    }

    public void setTenMauSac(String tenMauSac) {
        this.tenMauSac = tenMauSac;
    }

    @Override
    public String toString() {
        return "HDCT_LSG{" + "maHoaDon=" + maHoaDon + ", maHDCT=" + maHDCT + ", soLuong=" + soLuong + ", donGiaDau=" + donGiaDau + ", donGiaSau=" + donGiaSau + ", maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", tenSize=" + tenSize + ", tenMauSac=" + tenMauSac + '}';
    }

    public void inThongTinHDCT() {
        System.out.println("HDCT_LSG{" + "maHoaDon=" + maHoaDon + ", maHDCT=" + maHDCT + ", soLuong=" + soLuong + ", donGiaDau=" + donGiaDau + ", donGiaSau=" + donGiaSau + ", maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", tenSize=" + tenSize + ", tenMauSac=" + tenMauSac + '}');
    }
}
