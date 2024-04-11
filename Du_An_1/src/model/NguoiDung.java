package model;

import java.util.Date;

public class NguoiDung {

    private String maNguoiDung;
    private String tenNguoiDung;
    private boolean gioiTinh;
    private int tuoi;
    private String sdt;
    private String email;
    private String maCV;
    private String tenDN;
    private String matKhau;
    private boolean trangThai;

    public NguoiDung() {
    }

    public NguoiDung(String maNguoiDung, String tenNguoiDung, boolean gioiTinh, int tuoi, String sdt, String email, String maCV, String tenDN, String matKhau, boolean trangThai) {
        this.maNguoiDung = maNguoiDung;
        this.tenNguoiDung = tenNguoiDung;
        this.gioiTinh = gioiTinh;
        this.tuoi = tuoi;
        this.sdt = sdt;
        this.email = email;
        this.maCV = maCV;
        this.tenDN = tenDN;
        this.matKhau = matKhau;
        this.trangThai = trangThai;
    }

    public String getMaNguoiDung() {
        return maNguoiDung;
    }

    public void setMaNguoiDung(String maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }

    public String getTenNguoiDung() {
        return tenNguoiDung;
    }

    public void setTenNguoiDung(String tenNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMaCV() {
        return maCV;
    }

    public void setMaCV(String maCV) {
        this.maCV = maCV;
    }

    public String getTenDN() {
        return tenDN;
    }

    public void setTenDN(String tenDN) {
        this.tenDN = tenDN;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "NguoiDung{" + "maNguoiDung=" + maNguoiDung + ", tenNguoiDung=" + tenNguoiDung + ", gioiTinh=" + gioiTinh + ", tuoi=" + tuoi + ", sdt=" + sdt + ", email=" + email + ", maCV=" + maCV + ", tenDN=" + tenDN + ", matKhau=" + matKhau + ", trangThai=" + trangThai + '}';
    }

    public void inThongTinNguoiDung() {
        System.out.println("NguoiDung{" + "maNguoiDung=" + maNguoiDung + ", tenNguoiDung=" + tenNguoiDung + ", gioiTinh=" + gioiTinh + ", tuoi=" + tuoi + ", sdt=" + sdt + ", email=" + email + ", maCV=" + maCV + ", tenDN=" + tenDN + ", matKhau=" + matKhau + ", trangThai=" + trangThai + '}');
    }
}
