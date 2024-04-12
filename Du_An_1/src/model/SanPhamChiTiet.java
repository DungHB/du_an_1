package model;

public class SanPhamChiTiet {

    private String maSPCT;
    private String maSanPham;
    private String size;
    private String tenThuongHieu;
    private String tenSanPham;
    private String tenChatLieu;
    private String tenMauSac;

    public SanPhamChiTiet() {
    }

    public SanPhamChiTiet(String maSPCT, String maSanPham, String size, String tenThuongHieu, String tenSanPham, String tenChatLieu, String tenMauSac) {
        this.maSPCT = maSPCT;
        this.maSanPham = maSanPham;
        this.size = size;
        this.tenThuongHieu = tenThuongHieu;
        this.tenSanPham = tenSanPham;
        this.tenChatLieu = tenChatLieu;
        this.tenMauSac = tenMauSac;
    }

    public String getMaSPCT() {
        return maSPCT;
    }

    public void setMaSPCT(String maSPCT) {
        this.maSPCT = maSPCT;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTenThuongHieu() {
        return tenThuongHieu;
    }

    public void setTenThuongHieu(String tenThuongHieu) {
        this.tenThuongHieu = tenThuongHieu;
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

}
