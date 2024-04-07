package model;

public class NguoiDung {

    private int idNhanvien;
    private String maNhanVien;
    private String tenNhanvien;
    private String sdt;
    private String diaChi ;
    private String ngaySinh;
    private String gioiTinh;
    private String matKhau;
    private String tenChucVu;
    private String trangThai;

    public NguoiDung() {
    }

    public NguoiDung(int idNhanvien, String maNhanVien, String tenNhanvien, String sdt, String diaChi, String ngaySinh, String gioiTinh, String matKhau, String tenChucVu, String trangThai) {
        this.idNhanvien = idNhanvien;
        this.maNhanVien = maNhanVien;
        this.tenNhanvien = tenNhanvien;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.matKhau = matKhau;
        this.tenChucVu = tenChucVu;
        this.trangThai = trangThai;
    }

    public NguoiDung(String maNhanVien, String tenNhanvien, String sdt, String diaChi, String ngaySinh, String gioiTinh, String matKhau, String tenChucVu, String trangThai) {
        this.maNhanVien = maNhanVien;
        this.tenNhanvien = tenNhanvien;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.matKhau = matKhau;
        this.tenChucVu = tenChucVu;
        this.trangThai = trangThai;
    }


    public int getIdNhanvien() {
        return idNhanvien;
    }

    public void setIdNhanvien(int idNhanvien) {
        this.idNhanvien = idNhanvien;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String gettenNhanvien() {
        return tenNhanvien;
    }

    public void settenNhanvien(String tenNhanvien) {
        this.tenNhanvien = tenNhanvien;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getTenChucVu() {
        return tenChucVu;
    }

    public void setTenChucVu(String tenChucVu) {
        this.tenChucVu = tenChucVu;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    public Object[] toDataRow(){
        return new Object[]{this.idNhanvien,this.maNhanVien,this.tenNhanvien,this.sdt,this.diaChi,this.ngaySinh,this.gioiTinh,this.matKhau,this.tenChucVu,this.trangThai};
    }
    @Override
    public String toString() {
        return "NguoiDung{"+"IdNhanVien"+idNhanvien+", maNhanVien"+maNhanVien+", tenNhanVien"+tenNhanvien+", sdt"+sdt+", diaChi"+diaChi+", ngaySinh"+ngaySinh+", matKhau"+matKhau+", trangThai"+trangThai+'}';
    }

    public void add(String trim) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
