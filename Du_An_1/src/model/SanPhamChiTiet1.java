package model;

public class SanPhamChiTiet1 {

    
    private String MaSPCT, MaSanPham, MaThuongHieu, MaChatLieu, MaMauSac, MaSize;
    private String TenSanPham,TenThuongHieu,TenChatLieu,TenMauSac,Size;
    private int SoLuong;

    public SanPhamChiTiet1() {
    }

    public SanPhamChiTiet1(String MaSPCT, String MaSanPham, String MaThuongHieu, String MaChatLieu, String MaMauSac, String MaSize, String TenSanPham, String TenThuongHieu, String TenChatLieu, String TenMauSac, String Size, int SoLuong) {
        this.MaSPCT = MaSPCT;
        this.MaSanPham = MaSanPham;
        this.MaThuongHieu = MaThuongHieu;
        this.MaChatLieu = MaChatLieu;
        this.MaMauSac = MaMauSac;
        this.MaSize = MaSize;
        this.TenSanPham = TenSanPham;
        this.TenThuongHieu = TenThuongHieu;
        this.TenChatLieu = TenChatLieu;
        this.TenMauSac = TenMauSac;
        this.Size = Size;
        this.SoLuong = SoLuong;
    }

    public String getMaSPCT() {
        return MaSPCT;
    }

    public void setMaSPCT(String MaSPCT) {
        this.MaSPCT = MaSPCT;
    }

    public String getMaSanPham() {
        return MaSanPham;
    }

    public void setMaSanPham(String MaSanPham) {
        this.MaSanPham = MaSanPham;
    }

    public String getMaThuongHieu() {
        return MaThuongHieu;
    }

    public void setMaThuongHieu(String MaThuongHieu) {
        this.MaThuongHieu = MaThuongHieu;
    }

    public String getMaChatLieu() {
        return MaChatLieu;
    }

    public void setMaChatLieu(String MaChatLieu) {
        this.MaChatLieu = MaChatLieu;
    }

    public String getMaMauSac() {
        return MaMauSac;
    }

    public void setMaMauSac(String MaMauSac) {
        this.MaMauSac = MaMauSac;
    }

    public String getMaSize() {
        return MaSize;
    }

    public void setMaSize(String MaSize) {
        this.MaSize = MaSize;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String TenSanPham) {
        this.TenSanPham = TenSanPham;
    }

    public String getTenThuongHieu() {
        return TenThuongHieu;
    }

    public void setTenThuongHieu(String TenThuongHieu) {
        this.TenThuongHieu = TenThuongHieu;
    }

    public String getTenChatLieu() {
        return TenChatLieu;
    }

    public void setTenChatLieu(String TenChatLieu) {
        this.TenChatLieu = TenChatLieu;
    }

    public String getTenMauSac() {
        return TenMauSac;
    }

    public void setTenMauSac(String TenMauSac) {
        this.TenMauSac = TenMauSac;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String Size) {
        this.Size = Size;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

}
