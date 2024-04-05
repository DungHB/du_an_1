package model;

public class Login {

    private String maNguoiDung, matKhau, chucVu;

    public Login() {
    }

    public Login(String maNguoiDung, String matKhau, String chucVu) {
        this.maNguoiDung = maNguoiDung;
        this.matKhau = matKhau;
        this.chucVu = chucVu;
    }

    public String getMaNguoiDung() {
        return maNguoiDung;
    }

    public void setMaNguoiDung(String maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

}
