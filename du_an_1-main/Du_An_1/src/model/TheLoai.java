package model;

public class TheLoai {

    private int idTheloai;
    private String maTheLoai;
    private String tenTheLoai;

    public TheLoai() {
    }

    public TheLoai(int idTheloai, String maTheLoai, String tenTheLoai) {
        this.idTheloai = idTheloai;
        this.maTheLoai = maTheLoai;
        this.tenTheLoai = tenTheLoai;
    }

    public int getIdTheloai() {
        return idTheloai;
    }

    public void setIdTheloai(int idTheloai) {
        this.idTheloai = idTheloai;
    }

    public String getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai(String maTheLoai) {
        this.maTheLoai = maTheLoai;
    }

    public String getTenTheLoai() {
        return tenTheLoai;
    }

    public void setTenTheLoai(String tenTheLoai) {
        this.tenTheLoai = tenTheLoai;
    }

}
