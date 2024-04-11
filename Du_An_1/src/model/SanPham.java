package model;

public class SanPham {

    private String maSanPham;
    private String tenSanPham;
    private String theLoai;
    private String maThuongHieu;
    private String tenThuongHieu;
    private String maChatLieu;
    private String tenChatLieu;
    private String maMauSac;
    private String tenMauSac;
    private String maSize;
    private String tenSize;
    private String maSPCT;
    private double donGia;
    private int soLuongSP;

    public SanPham() {
    }

    public SanPham(String maSanPham, String tenSanPham, String theLoai, String maThuongHieu, String tenThuongHieu, String maChatLieu, String tenChatLieu, String maMauSac, String tenMauSac, String maSize, String tenSize, String maSPCT, double donGia, int soLuongSP) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.theLoai = theLoai;
        this.maThuongHieu = maThuongHieu;
        this.tenThuongHieu = tenThuongHieu;
        this.maChatLieu = maChatLieu;
        this.tenChatLieu = tenChatLieu;
        this.maMauSac = maMauSac;
        this.tenMauSac = tenMauSac;
        this.maSize = maSize;
        this.tenSize = tenSize;
        this.maSPCT = maSPCT;
        this.donGia = donGia;
        this.soLuongSP = soLuongSP;
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

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getMaThuongHieu() {
        return maThuongHieu;
    }

    public void setMaThuongHieu(String maThuongHieu) {
        this.maThuongHieu = maThuongHieu;
    }

    public String getTenThuongHieu() {
        return tenThuongHieu;
    }

    public void setTenThuongHieu(String tenThuongHieu) {
        this.tenThuongHieu = tenThuongHieu;
    }

    public String getMaChatLieu() {
        return maChatLieu;
    }

    public void setMaChatLieu(String maChatLieu) {
        this.maChatLieu = maChatLieu;
    }

    public String getTenChatLieu() {
        return tenChatLieu;
    }

    public void setTenChatLieu(String tenChatLieu) {
        this.tenChatLieu = tenChatLieu;
    }

    public String getMaMauSac() {
        return maMauSac;
    }

    public void setMaMauSac(String maMauSac) {
        this.maMauSac = maMauSac;
    }

    public String getTenMauSac() {
        return tenMauSac;
    }

    public void setTenMauSac(String tenMauSac) {
        this.tenMauSac = tenMauSac;
    }

    public String getMaSize() {
        return maSize;
    }

    public void setMaSize(String maSize) {
        this.maSize = maSize;
    }

    public String getTenSize() {
        return tenSize;
    }

    public void setTenSize(String tenSize) {
        this.tenSize = tenSize;
    }

    public String getMaSPCT() {
        return maSPCT;
    }

    public void setMaSPCT(String maSPCT) {
        this.maSPCT = maSPCT;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getSoLuongSP() {
        return soLuongSP;
    }

    public void setSoLuongSP(int soLuongSP) {
        this.soLuongSP = soLuongSP;
    }

    @Override
    public String toString() {
        return "SanPham{" + "maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", theLoai=" + theLoai + ", maThuongHieu=" + maThuongHieu + ", tenThuongHieu=" + tenThuongHieu + ", maChatLieu=" + maChatLieu + ", tenChatLieu=" + tenChatLieu + ", maMauSac=" + maMauSac + ", tenMauSac=" + tenMauSac + ", maSize=" + maSize + ", tenSize=" + tenSize + ", maSPCT=" + maSPCT + ", donGia=" + donGia + ", soLuongSP=" + soLuongSP + '}';
    }

    public void inThongTinSP() {
        System.out.println("SanPham{" + "maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", theLoai=" + theLoai + ", maThuongHieu=" + maThuongHieu + ", tenThuongHieu=" + tenThuongHieu + ", maChatLieu=" + maChatLieu + ", tenChatLieu=" + tenChatLieu + ", maMauSac=" + maMauSac + ", tenMauSac=" + tenMauSac + ", maSize=" + maSize + ", tenSize=" + tenSize + ", maSPCT=" + maSPCT + ", donGia=" + donGia + ", soLuongSP=" + soLuongSP + '}');
    }
}
