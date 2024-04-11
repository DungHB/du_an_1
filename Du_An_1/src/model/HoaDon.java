package model;

public class HoaDon {

    private String maHoaDon;
    private String ngayTao;
    private String ngayHoanThanh;
    private String trangThai;
    private String maPGG;
    private String maNV;
    private String maKhachHang;

    public HoaDon() {
    }

    public HoaDon(String maHoaDon, String ngayTao, String ngayHoanThanh, String trangThai, String maPGG, String maNV, String maKhachHang) {
        this.maHoaDon = maHoaDon;
        this.ngayTao = ngayTao;
        this.ngayHoanThanh = ngayHoanThanh;
        this.trangThai = trangThai;
        this.maPGG = maPGG;
        this.maNV = maNV;
        this.maKhachHang = maKhachHang;
    }

    public HoaDon(String maHoaDon, String ngayTao, String maNV, String trangThai) {
        this.maHoaDon = maHoaDon;
        this.ngayTao = ngayTao;
        this.maNV = maNV;
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

    public String getNgayHoanThanh() {
        return ngayHoanThanh;
    }

    public void setNgayHoanThanh(String ngayHoanThanh) {
        this.ngayHoanThanh = ngayHoanThanh;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getMaPGG() {
        return maPGG;
    }

    public void setMaPGG(String maPGG) {
        this.maPGG = maPGG;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

}
