package model;

public class Login {

    private String tenDangNhap, matKhau, email, chucVu;

    public Login() {
    }

    public Login(String tenDangNhap, String matKhau, String email, String chucVu) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.email = email;
        this.chucVu = chucVu;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public Login(String tenDangNhap, String matKhau, String chucVu) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.chucVu = chucVu;
    }

    public Login(String tenDangNhap, String email) {
        this.tenDangNhap = tenDangNhap;
        this.email = email;
    }
}
