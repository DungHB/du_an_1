package model;

public class SanPham {

    private int idSanPham;
    private String maSanPham;
    private String tenSanPham;
    private int idTheLoai;
    private int idThuongHieu;
    private String Theloai;
    private String trangThai;

    public SanPham() {
    }

    public SanPham(int idSanPham, String maSanPham, String tenSanPham, int idTheLoai, int idThuongHieu, String Theloai, String trangThai) {
        this.idSanPham = idSanPham;
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.idTheLoai = idTheLoai;
        this.idThuongHieu = idThuongHieu;
        this.Theloai = Theloai;
        this.trangThai = trangThai;
    }

    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
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

    public int getIdTheLoai() {
        return idTheLoai;
    }

    public void setIdTheLoai(int idTheLoai) {
        this.idTheLoai = idTheLoai;
    }

    public int getIdThuongHieu() {
        return idThuongHieu;
    }

    public void setIdThuongHieu(int idThuongHieu) {
        this.idThuongHieu = idThuongHieu;
    }

    public String getTheloai() {
        return Theloai;
    }

    public void setTheloai(String Theloai) {
        this.Theloai = Theloai;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

   
    
}
