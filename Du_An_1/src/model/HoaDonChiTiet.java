package model;

public class HoaDonChiTiet {

    private String maHoaDon, ngayTao, maPGG, maNhanVien, maKhachHang, maSPCT;
    private Integer soLuong;
    private Double thanhTien;
    private String trangThai;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String maHoaDon, String ngayTao, String maPGG, String maNhanVien, String maKhachHang, String maSPCT, Integer soLuong, Double thanhTien, String trangThai) {
        this.maHoaDon = maHoaDon;
        this.ngayTao = ngayTao;
        this.maPGG = maPGG;
        this.maNhanVien = maNhanVien;
        this.maKhachHang = maKhachHang;
        this.maSPCT = maSPCT;
        this.soLuong = soLuong;
        this.thanhTien = thanhTien;
        this.trangThai = trangThai;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getMaPGG() {
        return maPGG;
    }

    public void setMaPGG(String maPGG) {
        this.maPGG = maPGG;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getMaSPCT() {
        return maSPCT;
    }

    public void setMaSPCT(String maSPCT) {
        this.maSPCT = maSPCT;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(Double thanhTien) {
        this.thanhTien = thanhTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

}
