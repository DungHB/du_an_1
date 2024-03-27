package model;

public class ThuongHieu {

    private int idThuongHieu;
    private String maThuongHieu;
    private String tenThuongHieu;

    public ThuongHieu() {
    }

    public ThuongHieu(int idThuongHieu, String maThuongHieu, String tenThuongHieu) {
        this.idThuongHieu = idThuongHieu;
        this.maThuongHieu = maThuongHieu;
        this.tenThuongHieu = tenThuongHieu;
    }

    public int getIdThuongHieu() {
        return idThuongHieu;
    }

    public void setIdThuongHieu(int idThuongHieu) {
        this.idThuongHieu = idThuongHieu;
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

}
