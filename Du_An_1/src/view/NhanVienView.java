package view;

import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.*;
import service.*;
import service.Impl.*;

public class NhanVienView extends javax.swing.JFrame {

    /**
     * Creates new form NhanVienForm
     */
    DefaultTableModel dtm;
    SanPhamService qlsp = new SanPhamServiceImpl();
    SanPhamChiTietService qlspct = new SanPhamChiTietServiceImpl();
    HoaDonService qlhd = new HoaDonServiceImpl();
    NguoiDungService qlnd = new NguoiDungServiceImpl();
    HoaDonChiTietService qlhdct = new HoaDonChiTietServiceImpl();
    PhieuGiamGiaService qlpgg = new PhieuGiamGiaServiceImpl();
    KhachHangService qlkh = new KhachHangServiceImpl();
    ArrayList<SanPham> listSP = new ArrayList<>();
    ArrayList<HoaDon> listHD = new ArrayList<>();
    ArrayList<HoaDon> listGH = new ArrayList<>();
    ArrayList<PhieuGiamGia> listPGG = new ArrayList<>();
    String thongBaoTienDu = "";

    public NhanVienView() {
        initComponents();
        setLocationRelativeTo(null);

        loadDanhSachSanPham(qlsp.getAll());
        loadDanhSachHoaDon(qlhd.getAllHoaDon());
        loadDataVoucher(qlpgg.getAllVoucher());
        loadDanhSachKhachHang(qlkh.getAllKhachHang());
        loadDSHD_QL(qlhd.getAllHoaDon());
        //loadDataHoaDonBanHangApDungKM(qlhd.getAllHoaDon());
    }

    void loadDanhSachKhachHang(ArrayList<KhachHang> listKH) {
        dtm = (DefaultTableModel) tblDanhSachKH.getModel();
        dtm.setRowCount(0);
        for (KhachHang kh : listKH) {
            dtm.addRow(new Object[]{
                kh.getMaKhachHang(),
                kh.getTenKhachHang(),
                kh.getGioiTinh() ? "Nam" : "Nữ",
                kh.getSdt(),
                kh.getDiaChi(),});
        }
    }

    void loadDanhSachSanPham(ArrayList<SanPham> list) {
        dtm = (DefaultTableModel) tblDanhSachSP.getModel();
        dtm.setRowCount(0);
        for (SanPham sp : list) {
            dtm.addRow(new Object[]{
                sp.getMaSanPham(),
                sp.getTenSanPham(),
                sp.getTenThuongHieu(),
                sp.getTenMauSac(),
                sp.getTenChatLieu(),
                sp.getTenSize(),
                sp.getSoLuongSP(),
                sp.getDonGia()
            });
        }
    }

    void loadDanhSachHoaDon(ArrayList<HoaDon> list) {
        dtm = (DefaultTableModel) tblHoaDon.getModel();
        dtm.setRowCount(0);
        for (HoaDon hd : list) {
            dtm.addRow(new Object[]{
                hd.getMaHoaDon(),
                hd.getMaNV(),
                hd.getNgayTao(),
                hd.getNgayHoanThanh(),
                hd.getTrangThai()
            });
        }
    }

    void loadDSHD_QL(ArrayList<HoaDon> list) {
        dtm = (DefaultTableModel) tblQLHoaDon.getModel();
        dtm.setRowCount(0);
        for (HoaDon hd : list) {
            dtm.addRow(new Object[]{
                hd.getMaHoaDon(),
                hd.getNgayTao(),
                hd.getNgayHoanThanh(),
                hd.getMaNV(),
                hd.getMaKhachHang(),
                hd.getTrangThai(),
                hd.getMaPGG()
            });
        }
    }

    void loadDataXacNhanVoucher(String maHoaDon, String maVoucher) {
        dtm = (DefaultTableModel) tblXacNhanVoucher.getModel();
        dtm.setRowCount(0);
        dtm.addRow(new Object[]{
            maHoaDon,
            maVoucher
        });
    }

    void loadDataHoaDonBanHangApDungKM(HoaDon hd) {
        dtm = (DefaultTableModel) tblHoaDonApDungVoucher.getModel();
        dtm.setRowCount(0);
        dtm.addRow(new Object[]{
            hd.getMaHoaDon(),
            hd.getMaNV(),
            hd.getNgayTao(),
            hd.getTrangThai(),
            hd.getMaKhachHang()
        });
    }

    double thanhTien(Integer soLuong, double donGiaSau) {
        return (soLuong * donGiaSau);
    }

    void loadAllDataHDCT(ArrayList<HDCT_LSG> listHDCT) {
        dtm = (DefaultTableModel) tblSP_HD.getModel();
        dtm.setRowCount(0);
        for (HDCT_LSG hdct_lsg : listHDCT) {
            dtm.addRow(new Object[]{
                hdct_lsg.getMaSanPham(),
                hdct_lsg.getTenSanPham(),
                hdct_lsg.getTenSize(),
                hdct_lsg.getTenMauSac(),
                hdct_lsg.getSoLuong(),
                hdct_lsg.getDonGiaDau(),
                hdct_lsg.getDonGiaSau(),
                thanhTien(hdct_lsg.getSoLuong(), hdct_lsg.getDonGiaSau())
            });
        }
    }

    void loadAllDataHDCT_QL(ArrayList<HDCT_LSG> listHDCT) {
        dtm = (DefaultTableModel) tblHDCT_QL.getModel();
        dtm.setRowCount(0);
        for (HDCT_LSG hdct_lsg : listHDCT) {
            dtm.addRow(new Object[]{
                hdct_lsg.getMaSanPham(),
                hdct_lsg.getTenSanPham(),
                hdct_lsg.getTenSize(),
                hdct_lsg.getTenMauSac(),
                hdct_lsg.getSoLuong(),
                hdct_lsg.getDonGiaDau(),
                hdct_lsg.getDonGiaSau(),
                thanhTien(hdct_lsg.getSoLuong(), hdct_lsg.getDonGiaSau())
            });
        }
    }

    void loadDataVoucher(ArrayList<PhieuGiamGia> list) {
        dtm = (DefaultTableModel) tblDanhSachVoucher.getModel();
        dtm.setRowCount(0);
        for (PhieuGiamGia vc : list) {
            dtm.addRow(new Object[]{
                vc.getMaPhieuGiamGia(),
                vc.getTenPhieuGiamGia(),
                vc.getSoLuongPGG(),
                vc.getNgayKetThuc(),
                vc.getNgayBatDau(),
                vc.getGiaTriGiam(),
                vc.getGiaTriYeuCau()
            });
        }
    }

    KhachHang getFormKhachHang() {
        KhachHang kh = new KhachHang();
        kh.setTenKhachHang(txtHoTenKH.getText());
        kh.setMaKhachHang(txtMaKH.getText());
        kh.setDiaChi(txtDiaChi.getText());
        kh.setSdt(txtSDT.getText());
        boolean gioiTinh = false;
        if (rdNam.isSelected()) {
            gioiTinh = true;
        }
        kh.setGioiTinh(gioiTinh);
        return kh;
    }

    public boolean validateForm() {
        if (txtMaKH.getText().isEmpty() || txtHoTenKH.getText().isEmpty()
                || txtDiaChi.getText().isEmpty() || txtSDT.getText().isEmpty()) {
            return false;
        }
        String maKH = txtMaKH.getText();
        for (KhachHang kh : qlkh.getAllKhachHang()) {
            if (kh.getMaKhachHang().equals(maKH)) {
                JOptionPane.showMessageDialog(this, "Mã khách hàng " + maKH + " đã tồn tại. Vui lòng nhập mã khách hàng mới để Save");
                return false;
            }
        }
        return true;
    }

    void setFormKhachHang(KhachHang kh) {
        txtMaKH.setText(kh.getMaKhachHang());
        txtHoTenKH.setText(kh.getTenKhachHang());
        txtSDT.setText(kh.getSdt());
        txtDiaChi.setText(kh.getDiaChi());
        if (kh.getGioiTinh() == true) {
            rdNam.setSelected(true);
        } else {
            rdNu.setSelected(true);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel12 = new javax.swing.JPanel();
        btnBanHang = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnQuanLyKhachHang = new javax.swing.JButton();
        btnQuanLyHoaDon = new javax.swing.JButton();
        btnDangXuat = new javax.swing.JButton();
        btnTrangChu = new javax.swing.JButton();
        btnQuanLyUuDai = new javax.swing.JButton();
        formNhanVien = new javax.swing.JPanel();
        formTrangChu = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        formBanHang = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtTienKhachTra = new javax.swing.JTextField();
        btnThanhToan = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        txtTimThongTinKH = new javax.swing.JTextField();
        btnTimKH = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        lblTenTimDuoc = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblMaHD = new javax.swing.JLabel();
        lblNgayTao = new javax.swing.JLabel();
        lblTenNV = new javax.swing.JLabel();
        lblMaKH = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblPhanTramTru = new javax.swing.JLabel();
        txtThanhTien = new javax.swing.JTextField();
        txtTienDu = new javax.swing.JTextField();
        btnApMaGG = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        lblNgayHoanThanh = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        txtTimSP = new javax.swing.JTextField();
        btnTimSP = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDanhSachSP = new javax.swing.JTable();
        btnThemSPVaoHD = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        rdTheoGia = new javax.swing.JRadioButton();
        rdTheoTen = new javax.swing.JRadioButton();
        rdTatCa = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSP_HD = new javax.swing.JTable();
        btnTaoHD = new javax.swing.JButton();
        btnSuaHD = new javax.swing.JButton();
        btnHuyHD = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btnSuaSLSP = new javax.swing.JButton();
        btnXoaSP = new javax.swing.JButton();
        btnNewForm = new javax.swing.JButton();
        formQuanLyKhachHang = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnThemKH = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        txtMaKH = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtHoTenKH = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        rdNam = new javax.swing.JRadioButton();
        rdNu = new javax.swing.JRadioButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtDiaChi = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        txtTimKH = new javax.swing.JTextField();
        btnTimKiemKH = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDanhSachKH = new javax.swing.JTable();
        jLabel21 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        formQuanLyHoaDon = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        txtTimMaHD_QL = new javax.swing.JTextField();
        btnSearchHoaDon_QL = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtNgayBD = new javax.swing.JTextField();
        jButton19 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtNgayKT = new javax.swing.JTextField();
        btnBoLoc = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblQLHoaDon = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblHDCT_QL = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        formVoucher = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblXacNhanVoucher = new javax.swing.JTable();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblDanhSachVoucher = new javax.swing.JTable();
        jScrollPane12 = new javax.swing.JScrollPane();
        tblHoaDonApDungVoucher = new javax.swing.JTable();
        jLabel36 = new javax.swing.JLabel();
        btnChonVoucher = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        txtTimKiemVoucher = new javax.swing.JTextField();
        btnTimKiemVoucher = new javax.swing.JButton();
        btnXacNhanVoucher = new javax.swing.JButton();
        btnHuyVoucher = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel12.setBackground(new java.awt.Color(153, 153, 153));
        jPanel12.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 51, 51)));

        btnBanHang.setBackground(new java.awt.Color(204, 255, 204));
        btnBanHang.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnBanHang.setText("Bán Hàng");
        btnBanHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBanHangMouseClicked(evt);
            }
        });

        jPanel13.setBackground(new java.awt.Color(204, 255, 255));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/nv.png"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel10.setText("Nhân Viên");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        btnQuanLyKhachHang.setBackground(new java.awt.Color(204, 255, 204));
        btnQuanLyKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnQuanLyKhachHang.setText("Khách Hàng");
        btnQuanLyKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQuanLyKhachHangMouseClicked(evt);
            }
        });

        btnQuanLyHoaDon.setBackground(new java.awt.Color(204, 255, 204));
        btnQuanLyHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnQuanLyHoaDon.setText("Hóa Đơn");
        btnQuanLyHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQuanLyHoaDonMouseClicked(evt);
            }
        });

        btnDangXuat.setBackground(new java.awt.Color(204, 255, 204));
        btnDangXuat.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnDangXuat.setText("Đăng Xuất");
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });

        btnTrangChu.setBackground(new java.awt.Color(204, 255, 204));
        btnTrangChu.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnTrangChu.setText("Trang Chủ");
        btnTrangChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrangChuActionPerformed(evt);
            }
        });

        btnQuanLyUuDai.setBackground(new java.awt.Color(204, 255, 204));
        btnQuanLyUuDai.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnQuanLyUuDai.setText("Voucher");
        btnQuanLyUuDai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQuanLyUuDaiMouseClicked(evt);
            }
        });
        btnQuanLyUuDai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyUuDaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnQuanLyKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnQuanLyHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBanHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTrangChu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnQuanLyUuDai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnTrangChu)
                .addGap(35, 35, 35)
                .addComponent(btnBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnQuanLyKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnQuanLyUuDai, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnQuanLyHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(btnDangXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jPanel12Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnBanHang, btnDangXuat, btnQuanLyHoaDon, btnQuanLyKhachHang, btnTrangChu});

        formNhanVien.setLayout(new java.awt.CardLayout());

        formTrangChu.setBackground(new java.awt.Color(255, 204, 204));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/anhdep2.jpg"))); // NOI18N
        jLabel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/anhdep3.jpg"))); // NOI18N

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/anhdep4.jpg"))); // NOI18N

        javax.swing.GroupLayout formTrangChuLayout = new javax.swing.GroupLayout(formTrangChu);
        formTrangChu.setLayout(formTrangChuLayout);
        formTrangChuLayout.setHorizontalGroup(
            formTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formTrangChuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(formTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formTrangChuLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jLabel32)
                        .addContainerGap(246, Short.MAX_VALUE))
                    .addGroup(formTrangChuLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        formTrangChuLayout.setVerticalGroup(
            formTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formTrangChuLayout.createSequentialGroup()
                .addGroup(formTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formTrangChuLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel32))
                    .addGroup(formTrangChuLayout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        formNhanVien.add(formTrangChu, "card5");

        formBanHang.setBackground(new java.awt.Color(255, 204, 204));

        jPanel15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel26.setText("Thành Tiền");

        jLabel27.setText("Tiền Khách Trả");

        jLabel28.setText("Tiền Dư");

        txtTienKhachTra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienKhachTraKeyReleased(evt);
            }
        });

        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        jPanel16.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel22.setText("Khách Hàng");

        btnTimKH.setText("🔎");
        btnTimKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTimKHMouseClicked(evt);
            }
        });

        jLabel23.setText("Tên khách hàng tìm được");

        jLabel25.setText("Tìm thông tin khách hàng");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(txtTimThongTinKH, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnTimKH))
                            .addComponent(jLabel23)
                            .addComponent(lblTenTimDuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jLabel22)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25)
                .addGap(12, 12, 12)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimThongTinKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKH))
                .addGap(18, 18, 18)
                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTenTimDuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel7.setText("Mã hóa đơn");

        jLabel8.setText("Ngày tạo");

        jLabel9.setText("Mã khách hàng");

        jLabel11.setText("Mã nhân viên");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 204, 51));
        jLabel12.setText("Hóa Đơn Bán Hàng");

        lblPhanTramTru.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPhanTramTru.setForeground(new java.awt.Color(255, 51, 51));

        txtThanhTien.setEditable(false);

        txtTienDu.setEditable(false);

        btnApMaGG.setText("Áp Mã");
        btnApMaGG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApMaGGActionPerformed(evt);
            }
        });

        jLabel30.setText("Ngày hoàn thành");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel28)
                        .addGap(48, 48, 48)
                        .addComponent(txtTienDu, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTienKhachTra)
                            .addComponent(txtThanhTien, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblPhanTramTru, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(btnApMaGG)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNgayHoanThanh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnApMaGG, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblNgayHoanThanh, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTienKhachTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTienDu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(lblPhanTramTru, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Danh Sách Sản Phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        btnTimSP.setText("🔎");
        btnTimSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimSPActionPerformed(evt);
            }
        });

        tblDanhSachSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm", "Thương Hiệu", "Màu Sắc", "Chất Liệu", "Size", "Số Lượng", "Giá"
            }
        ));
        tblDanhSachSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachSPMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblDanhSachSP);

        btnThemSPVaoHD.setText("Thêm sản phẩm ");
        btnThemSPVaoHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSPVaoHDActionPerformed(evt);
            }
        });

        jLabel24.setText("Tìm kiếm sản phẩm");

        buttonGroup1.add(rdTheoGia);
        rdTheoGia.setText("Sắp xếp theo giá");
        rdTheoGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdTheoGiaActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdTheoTen);
        rdTheoTen.setText("Sắp xếp theo tên");
        rdTheoTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdTheoTenActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdTatCa);
        rdTatCa.setSelected(true);
        rdTatCa.setText("Tất cả");
        rdTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdTatCaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane4)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTimSP, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTimSP, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(rdTheoTen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdTheoGia)
                        .addGap(18, 18, 18)
                        .addComponent(rdTatCa)
                        .addGap(49, 49, 49)
                        .addComponent(btnThemSPVaoHD)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTimSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTimSP)
                        .addComponent(jLabel24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThemSPVaoHD, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rdTatCa)
                        .addComponent(rdTheoGia)
                        .addComponent(rdTheoTen)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addContainerGap())
        );

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Hóa Đơn", "Mã Người Tạo", "Ngày Tạo", "Ngày Hoàn Thành", "Trạng Thái"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblHoaDon);

        tblSP_HD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm", "Size", "Màu", "Số Lượng", "Giá Gốc", "Giá Sau Khi Giảm", "Thành Tiền"
            }
        ));
        jScrollPane3.setViewportView(tblSP_HD);

        btnTaoHD.setText("Tạo HĐ");
        btnTaoHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHDActionPerformed(evt);
            }
        });

        btnSuaHD.setText("Sửa HĐ");
        btnSuaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaHDActionPerformed(evt);
            }
        });

        btnHuyHD.setText("Hủy HĐ");
        btnHuyHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyHDActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setText("Giỏ Hàng");
        jLabel17.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setText("Danh Mục Hóa Đơn");
        jLabel18.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);

        btnSuaSLSP.setText("Sửa số lượng");
        btnSuaSLSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaSLSPActionPerformed(evt);
            }
        });

        btnXoaSP.setText("Xóa sản phẩm");
        btnXoaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSPActionPerformed(evt);
            }
        });

        btnNewForm.setBackground(new java.awt.Color(51, 255, 255));
        btnNewForm.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNewForm.setText("Làm Mới");
        btnNewForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewFormActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout formBanHangLayout = new javax.swing.GroupLayout(formBanHang);
        formBanHang.setLayout(formBanHangLayout);
        formBanHangLayout.setHorizontalGroup(
            formBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formBanHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formBanHangLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(formBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(formBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSuaHD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTaoHD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnHuyHD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNewForm, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 28, Short.MAX_VALUE))
                    .addGroup(formBanHangLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSuaSLSP, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnXoaSP)
                        .addGap(68, 68, 68))
                    .addGroup(formBanHangLayout.createSequentialGroup()
                        .addGroup(formBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );
        formBanHangLayout.setVerticalGroup(
            formBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formBanHangLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(formBanHangLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(formBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(formBanHangLayout.createSequentialGroup()
                                .addComponent(btnTaoHD, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(formBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(formBanHangLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSuaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnHuyHD, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(formBanHangLayout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(btnNewForm, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(18, 18, 18)
                        .addGroup(formBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(formBanHangLayout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(formBanHangLayout.createSequentialGroup()
                                .addGroup(formBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnSuaSLSP, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnXoaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );

        formNhanVien.add(formBanHang, "card6");

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Mã Khách Hàng");

        jLabel2.setText("Họ Tên");

        jLabel4.setText("Giới Tính");

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnThemKH.setText("Thêm");
        btnThemKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKHActionPerformed(evt);
            }
        });

        btnLamMoi.setText("Làm Mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(btnThemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );

        jLabel5.setText("Số Điện Thoại");

        jLabel6.setText("Địa Chỉ");

        buttonGroup2.add(rdNam);
        rdNam.setText("Nam");

        buttonGroup2.add(rdNu);
        rdNu.setText("Nữ");

        txtDiaChi.setColumns(20);
        txtDiaChi.setRows(5);
        jScrollPane7.setViewportView(txtDiaChi);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaKH, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                            .addComponent(txtHoTenKH))
                        .addGap(92, 92, 92)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(26, 26, 26)
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(rdNam)
                        .addGap(50, 50, 50)
                        .addComponent(rdNu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 129, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdNam)
                            .addComponent(rdNu)
                            .addComponent(jLabel4))
                        .addGap(54, 54, 54))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(jLabel2)
                                .addComponent(txtHoTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(66, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnTimKiemKH.setText("Tìm Kiếm");
        btnTimKiemKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemKHActionPerformed(evt);
            }
        });

        tblDanhSachKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã Khách Hàng", "Họ Tên", "Giới Tính", "Số Điện Thoại", "Địa Chỉ"
            }
        ));
        tblDanhSachKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachKHMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDanhSachKH);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(txtTimKH, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTimKiemKH)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1038, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTimKH, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 153, 0));
        jLabel21.setText("Thiết Lập Thông Tin Khách Hàng");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("Thông Tin Khách Hàng");

        javax.swing.GroupLayout formQuanLyKhachHangLayout = new javax.swing.GroupLayout(formQuanLyKhachHang);
        formQuanLyKhachHang.setLayout(formQuanLyKhachHangLayout);
        formQuanLyKhachHangLayout.setHorizontalGroup(
            formQuanLyKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formQuanLyKhachHangLayout.createSequentialGroup()
                .addGroup(formQuanLyKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formQuanLyKhachHangLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(formQuanLyKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)))
                    .addGroup(formQuanLyKhachHangLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        formQuanLyKhachHangLayout.setVerticalGroup(
            formQuanLyKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formQuanLyKhachHangLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                .addComponent(jLabel20)
                .addGap(27, 27, 27)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        formNhanVien.add(formQuanLyKhachHang, "card3");

        jPanel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel13.setText("Mã Hóa Đơn");

        txtTimMaHD_QL.setForeground(new java.awt.Color(153, 153, 153));
        txtTimMaHD_QL.setText("Nhập mã hoá đơn cần tìm");
        txtTimMaHD_QL.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTimMaHD_QLFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTimMaHD_QLFocusLost(evt);
            }
        });

        btnSearchHoaDon_QL.setText("Search");
        btnSearchHoaDon_QL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchHoaDon_QLMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(txtTimMaHD_QL, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(btnSearchHoaDon_QL, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimMaHD_QL, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(btnSearchHoaDon_QL, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        jPanel14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel14.setText("Ngày Bắt Đầu");

        txtNgayBD.setForeground(new java.awt.Color(153, 153, 153));
        txtNgayBD.setText("yyyy-mm-dd");
        txtNgayBD.setToolTipText("");
        txtNgayBD.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNgayBDFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNgayBDFocusLost(evt);
            }
        });

        jButton19.setText("Lọc");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jLabel15.setText("Ngày Kết thúc");

        txtNgayKT.setForeground(new java.awt.Color(153, 153, 153));
        txtNgayKT.setText("yyyy-mm-dd");
        txtNgayKT.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNgayKTFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNgayKTFocusLost(evt);
            }
        });

        btnBoLoc.setText("Bỏ lọc");
        btnBoLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBoLocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addGap(33, 33, 33)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayKT, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBoLoc, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNgayKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(btnBoLoc, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)))
                .addGap(58, 58, 58))
        );

        tblQLHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Hóa Đơn", "Ngày Tạo", "Ngày Hoàn Thành", "Mã Nhân Viên", "Mã Khách Hàng", "Trạng Thái", "Mã Phiếu Giảm Giá"
            }
        ));
        tblQLHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblQLHoaDonMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblQLHoaDon);

        tblHDCT_QL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Sản Phẩm", "Tên Sản Phẩm", "Size", "Màu", "Số Lượng", "Giá Gốc", "Giá Sau Khi Giảm", "Thành Tiền"
            }
        ));
        jScrollPane6.setViewportView(tblHDCT_QL);

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("Hóa Đơn");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel29.setText("Sản Phẩm Trong Hóa Đơn");

        javax.swing.GroupLayout formQuanLyHoaDonLayout = new javax.swing.GroupLayout(formQuanLyHoaDon);
        formQuanLyHoaDon.setLayout(formQuanLyHoaDonLayout);
        formQuanLyHoaDonLayout.setHorizontalGroup(
            formQuanLyHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formQuanLyHoaDonLayout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(formQuanLyHoaDonLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(formQuanLyHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel29)
                    .addComponent(jLabel19)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 1167, Short.MAX_VALUE)
                    .addComponent(jScrollPane5))
                .addGap(0, 25, Short.MAX_VALUE))
        );
        formQuanLyHoaDonLayout.setVerticalGroup(
            formQuanLyHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formQuanLyHoaDonLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(formQuanLyHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        formNhanVien.add(formQuanLyHoaDon, "card4");

        tblXacNhanVoucher.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hoá đơn", "Mã áp dụng"
            }
        ));
        jScrollPane10.setViewportView(tblXacNhanVoucher);

        tblDanhSachVoucher.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã voucher", "Tên voucher", "Số lượng", "Hạn sử dụng", "Ngày bắt đầu", "Số tiền giảm", "Số tiền yêu cầu"
            }
        ));
        tblDanhSachVoucher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachVoucherMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tblDanhSachVoucher);

        tblHoaDonApDungVoucher.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hoá đơn", "Mã nhân viên", "Ngày tạo", "Trạng thái", "Mã khách hàng"
            }
        ));
        tblHoaDonApDungVoucher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonApDungVoucherMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(tblHoaDonApDungVoucher);

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(51, 153, 255));
        jLabel36.setText("Danh sách hoá đơn áp dụng");

        btnChonVoucher.setBackground(new java.awt.Color(51, 102, 255));
        btnChonVoucher.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnChonVoucher.setForeground(new java.awt.Color(255, 255, 255));
        btnChonVoucher.setText("Chọn");
        btnChonVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonVoucherActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(51, 153, 255));
        jLabel37.setText("Danh sách voucher");

        txtTimKiemVoucher.setToolTipText("");

        btnTimKiemVoucher.setBackground(new java.awt.Color(0, 153, 255));
        btnTimKiemVoucher.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTimKiemVoucher.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKiemVoucher.setText("Tìm kiếm");
        btnTimKiemVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemVoucherActionPerformed(evt);
            }
        });

        btnXacNhanVoucher.setBackground(new java.awt.Color(51, 153, 255));
        btnXacNhanVoucher.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXacNhanVoucher.setForeground(new java.awt.Color(255, 255, 255));
        btnXacNhanVoucher.setText("Xác nhận");
        btnXacNhanVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanVoucherActionPerformed(evt);
            }
        });

        btnHuyVoucher.setBackground(new java.awt.Color(51, 153, 255));
        btnHuyVoucher.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHuyVoucher.setForeground(new java.awt.Color(255, 255, 255));
        btnHuyVoucher.setText("Huỷ");
        btnHuyVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyVoucherActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout formVoucherLayout = new javax.swing.GroupLayout(formVoucher);
        formVoucher.setLayout(formVoucherLayout);
        formVoucherLayout.setHorizontalGroup(
            formVoucherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formVoucherLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(formVoucherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formVoucherLayout.createSequentialGroup()
                        .addGroup(formVoucherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36)
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(formVoucherLayout.createSequentialGroup()
                        .addGroup(formVoucherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(formVoucherLayout.createSequentialGroup()
                                .addComponent(jLabel37)
                                .addGap(219, 219, 219)
                                .addComponent(txtTimKiemVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnTimKiemVoucher)
                                .addGap(23, 23, 23))
                            .addComponent(btnChonVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(126, 126, 126)
                        .addComponent(btnHuyVoucher)
                        .addGap(34, 34, 34)
                        .addComponent(btnXacNhanVoucher)))
                .addContainerGap(165, Short.MAX_VALUE))
        );
        formVoucherLayout.setVerticalGroup(
            formVoucherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formVoucherLayout.createSequentialGroup()
                .addGroup(formVoucherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formVoucherLayout.createSequentialGroup()
                        .addGroup(formVoucherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(formVoucherLayout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addGroup(formVoucherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTimKiemVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnTimKiemVoucher))
                                .addGap(15, 15, 15))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, formVoucherLayout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel37)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(formVoucherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel36)
                            .addComponent(btnChonVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formVoucherLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(formVoucherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnHuyVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXacNhanVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(163, Short.MAX_VALUE))
        );

        formNhanVien.add(formVoucher, "card6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(formNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(formNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBanHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBanHangMouseClicked
        // TODO add your handling code here:
        formNhanVien.removeAll();
        formNhanVien.add(formBanHang);
        formNhanVien.repaint();
        formNhanVien.revalidate();
    }//GEN-LAST:event_btnBanHangMouseClicked

    private void btnQuanLyKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyKhachHangMouseClicked
        // TODO add your handling code here:
        formNhanVien.removeAll();
        formNhanVien.add(formQuanLyKhachHang);
        formNhanVien.repaint();
        formNhanVien.revalidate();
    }//GEN-LAST:event_btnQuanLyKhachHangMouseClicked

    private void btnQuanLyHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyHoaDonMouseClicked
        // TODO add your handling code here:
        formNhanVien.removeAll();
        formNhanVien.add(formQuanLyHoaDon);
        formNhanVien.repaint();
        formNhanVien.revalidate();
    }//GEN-LAST:event_btnQuanLyHoaDonMouseClicked
    private String taoMaHoaDon() {
        // Định dạng cho phần số ngẫu nhiên
        String format = "000";
        // Lấy ngày và giờ hiện tại
        LocalDateTime now = LocalDateTime.now();
        // Định dạng cho phần thời gian
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        // Tạo phần thời gian từ ngày và giờ hiện tại
        String part1 = now.format(formatter);
        // Tạo phần số ngẫu nhiên
        String part2 = String.format("%05d", new Random().nextInt(100));
        // Ghép các phần lại với nhau để tạo mã hóa đơn
        String maHoaDon = "HD" + part1 + part2;
        return maHoaDon;
    }
    private void btnTaoHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHDActionPerformed
        // TODO add your handling code here:
        String maHoaDon = taoMaHoaDon();
        LocalDate ngayTaoLocalDate = LocalDate.now();
        Date ngayTaoDate = java.sql.Date.valueOf(ngayTaoLocalDate);
        String maNhanVien = qlhd.searchMaNhanVienTheoTenDangNhap(qlnd.listLG());
        String trangThai = "Đang chờ";
        System.out.println(maNhanVien);
        int conFirm = JOptionPane.showConfirmDialog(this, "Bạn muốn tạo hóa đơn phải không ?");
        if (conFirm == JOptionPane.YES_OPTION) {
            HoaDon hd = new HoaDon(maHoaDon, ngayTaoDate + "", maNhanVien, trangThai);
            loadDanhSachHoaDon(qlhd.themHoaDon(hd));
            JOptionPane.showMessageDialog(this, "Thêm hoá đơn thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            loadDanhSachHoaDon(qlhd.getAllHoaDon());
        } else {
            JOptionPane.showMessageDialog(this, "Đã hủy!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnTaoHDActionPerformed
    void setFormHoaDon(HoaDon hd) {
        lblMaHD.setText(hd.getMaHoaDon());
        lblNgayTao.setText(hd.getNgayTao());
        lblNgayHoanThanh.setText(hd.getNgayHoanThanh());
        lblTenNV.setText(hd.getMaNV());
        lblMaKH.setText(hd.getMaKhachHang());
    }
    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        // TODO add your handling code here:
        int row = tblHoaDon.getSelectedRow();
        if (row >= 0) {
            if (qlhd.getRowHD(row).getTrangThai().equals("Đã hoàn thành") || qlhd.getRowHD(row).getTrangThai().equals("Đã hủy") || qlhd.getRowHD(row).getTrangThai().equals("Đã huỷ")) {
                btnThemSPVaoHD.setEnabled(false);
                btnSuaSLSP.setEnabled(false);
                btnXoaSP.setEnabled(false);
                btnSuaHD.setEnabled(false);
                btnHuyHD.setEnabled(false);
                btnThanhToan.setEnabled(false);
                btnApMaGG.setEnabled(false);
                txtTienKhachTra.setEnabled(false);
                //txtMaGiamGia.setEnabled(false);
                String maHD = qlhd.getRowHD(row).getMaHoaDon();
                loadAllDataHDCT(qlhdct.getAllHDCT_LSG(maHD));
                setFormHoaDon(qlhd.getRowHD(row));
                String maVoucher = qlhd.getRowHD(row).getMaPGG();
                if (maVoucher == null) {
                    tinhThanhTien();
                    loadDataVoucher(qlpgg.showHoaDonTheoVoucher(Integer.valueOf(txtThanhTien.getText())));
                } else {
                    double tongTien = 0;
                    int rowGH = tblSP_HD.getRowCount();
                    for (int i = 0; i < rowGH; i++) {
                        tongTien += Double.parseDouble(tblSP_HD.getValueAt(i, 7).toString());
                    }
                    Integer tongTienSet = (int) (tongTien);
                    Integer tienGiam = qlpgg.layGiaGiamVoucher(maVoucher);
                    //txtThanhTien.setText(tongTienSet + " - " + tienGiam);
                    lblPhanTramTru.setText("Đã giảm " + tienGiam + "VNĐ");
                }
            } else {
                btnThemSPVaoHD.setEnabled(true);
                btnSuaSLSP.setEnabled(true);
                btnXoaSP.setEnabled(true);
                btnSuaHD.setEnabled(true);
                btnHuyHD.setEnabled(true);
                btnApMaGG.setEnabled(true);
                btnThanhToan.setEnabled(true);
                txtTienKhachTra.setEnabled(true);
                //txtMaGiamGia.setEnabled(true);
                tblDanhSachSP.setEnabled(true);
                lblPhanTramTru.setText("");
                String maHD = qlhd.getRowHD(row).getMaHoaDon();
                loadAllDataHDCT(qlhdct.getAllHDCT_LSG(maHD));
                setFormHoaDon(qlhd.getRowHD(row));
                tinhThanhTien();
                loadDataVoucher(qlpgg.showHoaDonTheoVoucher(Integer.valueOf(txtThanhTien.getText())));
            }
        }else{
            listPGG.clear();
            loadDataHoaDonBanHangApDungKM(qlhd.getRowHD(row));
        }
    }//GEN-LAST:event_tblHoaDonMouseClicked

    Boolean checkTrungKhachHang(String tenKH) {
        int count = 0;
        for (KhachHang kh : qlkh.getAllKhachHang()) {
            if (kh.getTenKhachHang().equals(tenKH)) {
                count++;
            }
        }
        if (count == 0) {
            return false;
        } else {
            return true;
        }
    }
    private void btnSuaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaHDActionPerformed
        // TODO add your handling code here:
        int row = tblHoaDon.getSelectedRow();
        if (row >= 0) {
            int y = JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa hoá đơn không ?");
            if (y == JOptionPane.YES_OPTION) {
                String maKH = lblMaKH.getText().trim().toUpperCase();
                if (checkTrungKhachHang(maKH) || maKH.isEmpty() || maKH.equals("")) {
                    if (qlhd.getRowHD(row).getTrangThai().equals("Đang chờ")) {
                        HoaDon hd = qlhd.getRowHD(row);
                        HoaDon suaHD = new HoaDon(hd.getMaHoaDon(), hd.getNgayTao(), hd.getTrangThai(), hd.getMaPGG(), hd.getMaNV(), maKH, qlkh.getTenKHByMaKH(maKH));
                        loadDanhSachHoaDon(qlhd.updateMaKhachHangBanHang(hd));
                        JOptionPane.showMessageDialog(this, "Sửa hóa đơn thành công.");
                        loadDanhSachHoaDon(qlhd.getAllHoaDon());
                    } else {
                        JOptionPane.showMessageDialog(this, "Không thể thay đổi thông tin hoá đơn đã thanh toán hoặc đã huỷ");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Khách hàng không có trong danh sách, mời thêm khách hàng mới.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Đã dừng sửa hóa đơn.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn hoá đơn để sửa !");
        }
    }//GEN-LAST:event_btnSuaHDActionPerformed

    private void btnHuyHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyHDActionPerformed
        // TODO add your handling code here:
        int row = tblHoaDon.getSelectedRow();
        if (row >= 0) {
            if (qlhd.getRowHD(row).getTrangThai().equals("Đang chờ")) {
                if (qlhdct.getAllHDCT_LSG(qlhd.getRowHD(row).getMaHoaDon()).isEmpty()) {
                    //JOptionPane.showMessageDialog(this, "Hoá đơn này đang trống -> Xoá hoá đơn");
                    int xoaHD = JOptionPane.showConfirmDialog(this, "Hóa đơn này đang trống,\n" + "bạn có muốn xoá hoá đơn không?");
                    if (xoaHD == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(this, "Xóa hóa đơn thành công.");
                        loadDanhSachHoaDon(qlhd.xoaHoaDon(qlhd.getRowHD(row).getMaHoaDon()));
                        loadDanhSachHoaDon(qlhd.getAllHoaDon());
                    } else {
                        JOptionPane.showMessageDialog(this, "Hóa đơn chưa được xóa");
                    }
                } else {
                    //JOptionPane.showMessageDialog(this, "Hoá đơn này đã có sản phẩm, chỉ có thể huỷ");
                    int huyHD = JOptionPane.showConfirmDialog(this, "Hóa đơn này đã có sản phẩm,\n" + "bạn có muốn hủy hoá đơn không?");
                    if (huyHD == JOptionPane.YES_OPTION) {
                        loadDanhSachHoaDon(qlhd.huyHoaDon(qlhd.getRowHD(row).getMaHoaDon(), "Đã hủy"));

                        loadDanhSachHoaDon(qlhd.getAllHoaDon());
                    } else {
                        JOptionPane.showMessageDialog(this, "Không muốn hủy thì thôi.");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Không thể huỷ hoá đơn đã thanh toán hoặc đã huỷ !");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn hoá đơn muốn hủy !");
        }
    }//GEN-LAST:event_btnHuyHDActionPerformed
    Boolean checkSo(String so) {
        try {
            Integer.parseInt(so);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    void loadDataHDCT(String maHD) {
        for (HDCT_LSG hdct : qlhdct.getAllHDCT_LSG(maHD)) {
            hdct.inThongTinHDCT();
        }
    }

    public LocalDate getLocalDate() {
        return LocalDate.now();
    }

    Boolean checkTrungHDCT(String maHD, String maSPCT) {
        int dem = 0;
        for (HDCT_LSG hdct : qlhdct.getAllHDCT_LSG(maHD)) {
            if (hdct.getMaSanPham().equals(maSPCT)) {
                dem++;
            }
        }
        if (dem == 0) {
            return false;
        } else {
            return true;
        }
    }

    void tinhThanhTien() {
        double tongTien = 0;
        int row = tblSP_HD.getRowCount();
        for (int i = 0; i < row; i++) {
            tongTien += Double.parseDouble(tblSP_HD.getValueAt(i, 7).toString());
        }
        Integer tongTienSet = (int) (tongTien);
        txtThanhTien.setText(tongTienSet + "");
    }
    private void tblDanhSachSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachSPMouseClicked
        // TODO add your handling code here:
//        int row = tblDanhSachSP.getSelectedRow();
//        if (!qlsp.TimKiemSanPhamTheoTenSP(txtTimSP.getText().trim()).isEmpty() && !txtTimSP.getText().trim().isEmpty()) {
//            listSP.clear();
//            listSP = qlsp.TimKiemSanPhamTheoTenSP(txtTimSP.getText().trim());
//        } else {
//            System.out.println("Roong");
//            if (rdTatCa.isSelected()) {
//                listSP.clear();
//                listSP = qlsp.getAll();
//            } else if (rdTheoGia.isSelected()) {
//                listSP.clear();
//                listSP = qlsp.sapXepSanPhamTheoGia();
//            } else if (rdTheoTen.isSelected()) {
//                listSP.clear();
//                listSP = qlsp.sapXepSanPhamTheoTen();
//            }
//        }
    }//GEN-LAST:event_tblDanhSachSPMouseClicked

    private void btnThemSPVaoHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSPVaoHDActionPerformed
        // TODO add your handling code here:
//        if (!qlsp.TimKiemSanPhamTheoTenSP(txtTimSP.getText().trim()).isEmpty() && !txtTimSP.getText().trim().isEmpty()) {
//            listSP.clear();
//            listSP = qlsp.TimKiemSanPhamTheoTenSP(txtTimSP.getText().trim());
//            loadDanhSachSanPham(listSP);
//        } else {
//        System.out.println("Roong");
        if (rdTatCa.isSelected()) {
            listSP.clear();
            listSP = qlsp.getAll();
        } else if (rdTheoGia.isSelected()) {
            listSP.clear();
            listSP = qlsp.sapXepSanPhamTheoGia();
        } else if (rdTheoTen.isSelected()) {
            listSP.clear();
            listSP = qlsp.sapXepSanPhamTheoTen();
        }
//        }
        int rowSP = tblDanhSachSP.getSelectedRow();
        int rowHD = tblHoaDon.getSelectedRow();
        if (rowHD >= 0) {
            String maHD = qlhd.getRowHD(rowHD).getMaHoaDon();
            String trangThaiHoaDon = qlhd.getRowHD(rowHD).getTrangThai();
            System.out.println(trangThaiHoaDon);
            Integer soLuong = null;
            if (trangThaiHoaDon.equals("Đang chờ")) {
                if (rowSP >= 0) {
                    String input = JOptionPane.showInputDialog(this, "Mời chọn số lượng cần thêm");
                    if (input != null) {
                        if (checkSo(input)) {
                            soLuong = Integer.parseInt(input);
                            if (soLuong > qlsp.getAll().get(rowSP).getSoLuongSP()) {
                                JOptionPane.showMessageDialog(this, "Nhập quá nhiều số lượng trong kho");
                            } else if (soLuong == 0) {
                                JOptionPane.showMessageDialog(this, "Chưa thay đổi số lượng");
                            } else if (soLuong < 0) {
                                JOptionPane.showMessageDialog(this, "Số lượng không thể âm");
                            } else if (soLuong > 0 && soLuong <= qlsp.getAll().get(rowSP).getSoLuongSP()) {
                                System.out.println("soLuong: " + soLuong);
                                String maSP = qlsp.getRowSP(rowSP).getMaSanPham();
                                System.out.println("Mã Sản phẩm: " + maSP);
                                String tenMS = qlsp.getRowSP(rowSP).getTenMauSac();
                                System.out.println("Màu sắc: " + tenMS);
                                String maSPCT = qlspct.getMaSPCTFromSP(maSP, qlspct.getMaMSByTenMS(tenMS));
                                System.out.println("Mã màu sắc: " + qlspct.getMaMSByTenMS(tenMS));
                                System.out.println("Mã SPCT " + maSPCT);
                                System.out.println("Mã HD " + maHD);
                                loadDataHDCT(maSPCT);
                                if (checkTrungHDCT(maHD, maSPCT)) {
                                    JOptionPane.showMessageDialog(this, "Thêm số lượng sản phẩm thành công");
                                    loadAllDataHDCT(qlhdct.updateSoluongSPVaoHD(maSPCT, soLuong, maHD));
                                    loadDanhSachSanPham(qlsp.updateSanPhamTru(maHD, soLuong));
                                    loadAllDataHDCT(qlhdct.getAllHDCT_LSG(maHD));
                                    loadDanhSachSanPham(qlsp.getAll());
                                    tinhThanhTien();
                                    txtTimSP.setText("");
                                } else {
                                    JOptionPane.showMessageDialog(this, "Đã thêm sản phẩm mới vào hoá đơn");
                                    loadAllDataHDCT(qlhdct.addHDCT(new HDCT_LSG(maHD, soLuong, maSPCT)));
                                    loadDanhSachSanPham(qlsp.updateSanPhamTru(maSPCT, soLuong));
                                    loadAllDataHDCT(qlhdct.getAllHDCT_LSG(maHD));
                                    loadDanhSachSanPham(qlsp.getAll());
                                    tinhThanhTien();
                                    txtTimSP.setText("");
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Không thể nhập ký tự ngoài số");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Đã huỷ");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Chưa chọn sản phẩm để thêm");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Hoá đơn này không thể thêm sản phẩm vì hoá đơn " + trangThaiHoaDon.toLowerCase());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn hóa đơn trước chứ !");
        }
    }//GEN-LAST:event_btnThemSPVaoHDActionPerformed

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed
        // TODO add your handling code here:
        int i = JOptionPane.showConfirmDialog(this, "Bạn muốn đăng xuất phải không ?");
        if (i == JOptionPane.YES_OPTION) {
            LoginView viewDN = new LoginView();
            this.setVisible(false);
            viewDN.setVisible(true);
        }
    }//GEN-LAST:event_btnDangXuatActionPerformed

    private void btnTrangChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrangChuActionPerformed
        // TODO add your handling code here:
        formNhanVien.removeAll();
        formNhanVien.add(formTrangChu);
        formNhanVien.repaint();
        formNhanVien.revalidate();
    }//GEN-LAST:event_btnTrangChuActionPerformed

    private void rdTheoGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdTheoGiaActionPerformed
        // TODO add your handling code here:
        loadDanhSachSanPham(qlsp.sapXepSanPhamTheoGia());
    }//GEN-LAST:event_rdTheoGiaActionPerformed

    private void rdTheoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdTheoTenActionPerformed
        // TODO add your handling code here:
        loadDanhSachSanPham(qlsp.sapXepSanPhamTheoTen());
    }//GEN-LAST:event_rdTheoTenActionPerformed

    private void rdTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdTatCaActionPerformed
        // TODO add your handling code here:
        loadDanhSachSanPham(qlsp.getAll());
    }//GEN-LAST:event_rdTatCaActionPerformed

    private void btnSuaSLSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaSLSPActionPerformed
        // TODO add your handling code here:
        int rowGH = tblSP_HD.getSelectedRow();
        int rowHD = tblHoaDon.getSelectedRow();
        if (rowHD >= 0) {
            listSP.clear();
            if (rdTatCa.isSelected()) {
                listSP = qlsp.getAll();
            } else if (rdTheoGia.isSelected()) {
                listSP = qlsp.sapXepSanPhamTheoGia();
            } else if (rdTheoTen.isSelected()) {
                listSP = qlsp.sapXepSanPhamTheoTen();
            }
            String maHD = qlhd.getRowHD(rowHD).getMaHoaDon();
            System.out.println("mhd: " + maHD);
            String trangThaiHoaDon = qlhd.getRowHD(rowHD).getTrangThai();
            System.out.println("Trạng thái: " + trangThaiHoaDon);
            Integer soLuong = null;
            if (trangThaiHoaDon.equals("Đang chờ")) {
                if (rowGH >= 0) {
                    String input = JOptionPane.showInputDialog(this, "Mời điền số lượng sản phẩm cần giảm");
                    if (input != null) {
                        if (checkSo(input)) {
                            soLuong = Integer.parseInt(input);
                            if (soLuong >= qlhdct.getAllHDCT_LSG(maHD).get(rowGH).getSoLuong()) {
                                JOptionPane.showMessageDialog(this, "Số lượng sản phẩm tối thiểu là 1");
                            }
                            if (soLuong == 0) {
                                JOptionPane.showMessageDialog(this, "Chưa thay đổi số lượng sản phẩm");
                            } else if (soLuong < 0) {
                                JOptionPane.showMessageDialog(this, "Số lượng không thể âm");
                            } else if (soLuong > 0 && soLuong < qlhdct.getAllHDCT_LSG(maHD).get(rowGH).getSoLuong()) {
                                String maSPCT = qlspct.getMaSPCTByMaSP(qlhdct.getAllHDCT_LSG(maHD).get(rowGH).getMaSanPham());
                                System.out.println("Mã SPCT: " + maSPCT);
                                JOptionPane.showMessageDialog(this, "Giảm số lượng thành công");
                                loadAllDataHDCT(qlhdct.updateTruSoluongSPVaoHD(maSPCT, soLuong, maHD));
                                loadDanhSachSanPham(qlsp.updateSanPhamCong(maSPCT, soLuong));
                                loadAllDataHDCT(qlhdct.getAllHDCT_LSG(maHD));
                                loadDanhSachSanPham(qlsp.getAll());
                                tinhThanhTien();
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Không thể nhập ký tự ngoài số");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Đã huỷ");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Chưa chọn dòng");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Không thể bớt sản phẩm vì hoá đơn " + trangThaiHoaDon.toLowerCase());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn hóa đơn trước chứ !");
        }
    }//GEN-LAST:event_btnSuaSLSPActionPerformed

    private void btnXoaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSPActionPerformed
        // TODO add your handling code here:
        int rowGH = tblSP_HD.getSelectedRow();
        int rowHD = tblHoaDon.getSelectedRow();
        if (rowHD >= 0) {
            listSP.clear();
            if (rdTatCa.isSelected()) {
                listSP = qlsp.getAll();
            } else if (rdTheoGia.isSelected()) {
                listSP = qlsp.sapXepSanPhamTheoGia();
            } else if (rdTheoTen.isSelected()) {
                listSP = qlsp.sapXepSanPhamTheoTen();
            }

            String trangThaiHoaDon = qlhd.getRowHD(rowHD).getTrangThai();
            System.out.println("Trạng thái: " + trangThaiHoaDon);
            if (trangThaiHoaDon.equals("Đang chờ")) {
                if (rowGH >= 0) {
                    String maHD = qlhd.getRowHD(rowHD).getMaHoaDon();
                    System.out.println("mhd: " + maHD);
                    String maSPCT = qlspct.getMaSPCTByMaSP(qlhdct.getAllHDCT_LSG(maHD).get(rowGH).getMaSanPham());
                    System.out.println("mSPCT: " + maSPCT);
                    int soLuong = qlhdct.getAllHDCT_LSG(maHD).get(rowGH).getSoLuong();
                    System.out.println(soLuong);
                    int y = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xoá sản phẩm không??");
                    if (y == JOptionPane.YES_OPTION) {
                        loadAllDataHDCT(qlhdct.deleteHDCT(maSPCT, maHD));
                        loadDanhSachSanPham(qlsp.updateSanPhamCong(maSPCT, soLuong));
                        loadDanhSachSanPham(qlsp.getAll());
                        loadAllDataHDCT(qlhdct.getAllHDCT_LSG(maHD));
                        JOptionPane.showMessageDialog(this, "Xoá thành công sản phẩm khỏi hoá đơn");
                        tinhThanhTien();
                    } else {
                        JOptionPane.showMessageDialog(this, "Đã huỷ");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Chưa chọn dòng để xoá");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Hoá đơn này không thể xoá sản phầm vì hoá đơn " + trangThaiHoaDon.toLowerCase());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn hóa đơn trước chứ !");
        }
    }//GEN-LAST:event_btnXoaSPActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
        System.out.println(thongBaoTienDu);
        int rowHD = tblHoaDon.getSelectedRow();
        int y = JOptionPane.showConfirmDialog(this, "Bạn muốn thanh toán ?");
        if (!qlhd.getRowHD(rowHD).getTrangThai().equals("Đã hoàn thành") || !qlhd.getRowHD(rowHD).getTrangThai().equals("Đã hủy")) {
            if (y == JOptionPane.YES_OPTION) {
                if (rowHD >= 0) {
                    if (qlhdct.getAllHDCT_LSG(qlhd.getRowHD(rowHD).getMaHoaDon()).isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Không có sản phẩm trong hóa dơn muốn thanh toán");
                    } else {
                        if (txtTienKhachTra.getText().trim().isEmpty()) {
                            JOptionPane.showMessageDialog(this, "Mời bạn nhập số tiền");
                        } else {
                            if (txtTienDu.getText().startsWith("Thiếu")) {
                                JOptionPane.showMessageDialog(this, "Thiếu tiền !!!");
                            } else {
                                int rowVC = tblDanhSachVoucher.getSelectedRow();
                                if (rowVC >= 0) {
                                    String maPGG = listPGG.get(rowVC).getMaPhieuGiamGia();
                                    System.out.println("VC hoá đơn: " + maPGG);
                                    String trangThai = "Đã hoàn thành";
                                    loadDanhSachHoaDon(qlhd.thanhToanApPGG(maPGG, qlhd.getRowHD(rowHD).getMaHoaDon()));
                                    System.out.println("MaHD: " + qlhd.thanhToanApPGG(maPGG, qlhd.getRowHD(rowHD).getMaHoaDon()));
                                    JOptionPane.showMessageDialog(this, qlhd.thanhToanHoaDon(trangThai, getLocalDate() + "", qlhd.getRowHD(rowHD).getMaHoaDon()));
                                    System.out.println("Ngày hiện tại :" + getLocalDate());
                                    JOptionPane.showMessageDialog(this, "Đã hoàn thành hoá đơn và trả khách: " + thongBaoTienDu + "VND");
                                    JOptionPane.showMessageDialog(this, qlpgg.updateSoLuongVoucherTru(maPGG));
                                    loadDataVoucher(qlpgg.getAllVoucher());
                                    loadDanhSachHoaDon(qlhd.getAllHoaDon());
                                } else {
                                    int yVC = JOptionPane.showConfirmDialog(this, "Bạn chưa chọn voucher, có muốn thêm không");
                                    if (yVC == JOptionPane.NO_OPTION) {
                                        String maPGG = null;
                                        String trangThai = "Đã hoàn thành";
                                        loadDanhSachHoaDon(qlhd.thanhToanApPGG(maPGG, qlhd.getRowHD(rowHD).getMaHoaDon()));
                                        JOptionPane.showMessageDialog(this, qlhd.thanhToanHoaDon(trangThai, getLocalDate() + "", qlhd.getRowHD(rowHD).getMaHoaDon()));
                                        JOptionPane.showMessageDialog(this, "Đã hoàn thành hoá đơn và trả khách: " + thongBaoTienDu + "VND");
                                        loadDanhSachHoaDon(qlhd.getAllHoaDon());
                                        txtThanhTien.setText("");
                                        txtTienDu.setText("");
                                        txtTienKhachTra.setText("");
                                        lblMaHD.setText("");
                                        lblMaKH.setText("");
                                        lblNgayHoanThanh.setText("");
                                        lblTenNV.setText("");
                                    } else {
                                        JOptionPane.showMessageDialog(this, "Mời áp voucher giảm giá");
                                    }
                                }
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Bạn chưa chọn hoá đơn để thanh toán");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Đã huỷ");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Hóa đơn này đã hoàn thành hoặc đã huỷ");
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void txtTienKhachTraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachTraKeyReleased
        // TODO add your handling code here:
        thongBaoTienDu = "";
        String tienKhachTraText = txtTienKhachTra.getText();
        String thanhTienText = txtThanhTien.getText();
        Integer thanhTien = Integer.parseInt(thanhTienText);
        Integer tienKhachTra = 0;
        Integer tienThua = 0;
        if (checkSo(tienKhachTraText)) {
            tienKhachTra = Integer.parseInt(tienKhachTraText);
            tienThua = tienKhachTra - thanhTien;
            if (tienThua < 0) {
                txtTienDu.setText("Thiếu: " + (-tienThua));
            } else {
                txtTienDu.setText(tienThua + "");
                thongBaoTienDu = txtTienDu.getText();
                System.out.println(thongBaoTienDu);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Không thể nhập ký tự");
        }
    }//GEN-LAST:event_txtTienKhachTraKeyReleased

    private void btnHuyVoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyVoucherActionPerformed
        loadDataXacNhanVoucher("", "");
        formNhanVien.removeAll();
        formNhanVien.add(formBanHang);
        formNhanVien.repaint();
        formNhanVien.revalidate();
    }//GEN-LAST:event_btnHuyVoucherActionPerformed

    private void btnXacNhanVoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanVoucherActionPerformed
        listPGG.clear();
        int rowVC = tblDanhSachVoucher.getSelectedRow();
        listPGG = qlpgg.showHoaDonTheoVoucher(Integer.valueOf(txtThanhTien.getText()));
        if (rowVC >= 0) {
            double tien = listPGG.get(rowVC).getGiaTriGiam();
            Integer tienGiam = (int) tien;
            lblPhanTramTru.setText("<html>Số tiền giảm:<br>" + tienGiam + "</html>");
            Integer tongTienthis = Integer.valueOf(txtThanhTien.getText());
            Integer kq = tongTienthis - tienGiam;
            txtThanhTien.setText(kq + "");
        }
        formNhanVien.removeAll();
        formNhanVien.add(formBanHang);
        formNhanVien.repaint();
        formNhanVien.revalidate();
    }//GEN-LAST:event_btnXacNhanVoucherActionPerformed

    private void btnTimKiemVoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemVoucherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTimKiemVoucherActionPerformed

    private void btnChonVoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonVoucherActionPerformed
        // TODO add your handling code here:
        listHD.clear();
        listPGG.clear();
        int rowHD = tblSP_HD.getSelectedRow();
        int rowVC = tblDanhSachVoucher.getSelectedRow();
        listPGG = qlpgg.showHoaDonTheoVoucher(Integer.valueOf(txtThanhTien.getText()));
        if (rowHD >= 0 && rowVC >= 0) {
            String maVoucher = listPGG.get(rowVC).getMaPhieuGiamGia();
            String maHoaDon = qlhd.getRowHD(rowHD).getMaHoaDon();
            String trangThai = qlhd.getRowHD(rowHD).getTrangThai();
            System.out.println("Hoa don voucher: " + maHoaDon);
            System.out.println("Voucher: " + maVoucher);
            //listHoaDonApVoucherPhu.clear();
            if (trangThai.equals("Đang chờ")) {
                loadDataXacNhanVoucher(maHoaDon, maVoucher);
            } else {
                JOptionPane.showMessageDialog(this, "Hoá đơn đã hoàn thành hoặc đã huỷ không thể áp dụng voucher");
                loadDataXacNhanVoucher("", "");
            }
        }
    }//GEN-LAST:event_btnChonVoucherActionPerformed

    private void tblHoaDonApDungVoucherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonApDungVoucherMouseClicked
        // TODO add your handling code here:
        //        int rowHD = tblHoaDonApDungVoucher.getSelectedRow();
        //        int rowVC = tblDanhSachVoucher.getSelectedRow();
        //        String maVoucher = ser.getAllVoucher().get(rowVC).getMaVoucher();
        //        String maHoaDon = listHoaDonApVoucherPhu.get(rowHD).getMaHoaDon();
        //        String trangThai = listHoaDonApVoucherPhu.get(rowHD).getTrangThai();
        //        System.out.println("Hoa don voucher" + maHoaDon);
        //        listHoaDonApVoucherPhu.clear();
        //        if (rowHD >= 0 && rowVC >= 0) {
        //
        //            loadDataXacNhanVoucher(maHoaDon, maVoucher);
        //        }
    }//GEN-LAST:event_tblHoaDonApDungVoucherMouseClicked

    private void tblDanhSachVoucherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachVoucherMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDanhSachVoucherMouseClicked

    private void btnQuanLyUuDaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLyUuDaiActionPerformed
        formNhanVien.removeAll();
        formNhanVien.add(formVoucher);
        formNhanVien.repaint();
        formNhanVien.revalidate();
    }//GEN-LAST:event_btnQuanLyUuDaiActionPerformed

    private void btnQuanLyUuDaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyUuDaiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnQuanLyUuDaiMouseClicked

    private void btnApMaGGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApMaGGActionPerformed
        formNhanVien.removeAll();
        formNhanVien.add(formVoucher);
        formNhanVien.repaint();
        formNhanVien.revalidate();
//        String maVoucher = JOptionPane.showInputDialog(this, "Vui lòng nhập mã Voucher Giảm Giá");
//        if (maVoucher == null) {
//            return;
//        }
//        if (!maVoucher.isEmpty()) {
//            PhieuGiamGia voucher = qlpgg.findKhuyenMaiByMaKhuyenMai(maVoucher);
//            tinhTienKhuyenMai(voucher);
//        }
//        if (txt_tienKhachTra.getText().isEmpty()) {
//            return;
//        }
//        Double tienSauGiamGia = (Double.parseDouble(txt_tiensgg.getText().trim().toString()));
//        Double tienKhachTra = Double.parseDouble(txt_tienKhachTra.getText().trim().toString());
//        if (tienKhachTra > tienSauGiamGia) {
//            Double tienThua = tienKhachTra - tienSauGiamGia;
//            txt_tienthua.setText(tienThua.toString());
//        } else {
//            JOptionPane.showMessageDialog(this, "Tiền khách trả chưa đủ còn thiếu ");
//            return;
//        }
    }//GEN-LAST:event_btnApMaGGActionPerformed

    private void btnNewFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewFormActionPerformed
        // TODO add your handling code here:
        loadDanhSachHoaDon(qlhd.getAllHoaDon());
        loadDanhSachSanPham(qlsp.getAll());
        tblDanhSachSP.setEnabled(false);
        btnThemSPVaoHD.setEnabled(false);
        btnXoaSP.setEnabled(false);
        btnSuaSLSP.setEnabled(false);
        txtThanhTien.setText("");
        setFormHoaDon(new HoaDon("", "", "", "", "", "", ""));
        rdTatCa.setSelected(true);
        txtTimSP.setText("");
        txtTienKhachTra.setEditable(false);
        txtTienDu.setEditable(false);
        txtThanhTien.setEditable(false);
        txtTienKhachTra.setText("");
        txtTienDu.setText("");
        lblPhanTramTru.setText("");
    }//GEN-LAST:event_btnNewFormActionPerformed

    private void tblDanhSachKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachKHMouseClicked
        // TODO add your handling code here:
        int row = tblDanhSachKH.getSelectedRow();
        if (row >= 0) {
            setFormKhachHang(qlkh.getRowKH(row));
        }
    }//GEN-LAST:event_tblDanhSachKHMouseClicked

    private void btnThemKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKHActionPerformed
        // TODO add your handling code here:
        if (validateForm()) {
            qlkh.themKH(getFormKhachHang());
            JOptionPane.showMessageDialog(this, "Save thành công");
            loadDanhSachKhachHang(qlkh.getAllKhachHang());
        } else {
            JOptionPane.showMessageDialog(this, "Không được để trống các trường dữ liệu !");
        }
    }//GEN-LAST:event_btnThemKHActionPerformed

    private void btnTimKiemKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemKHActionPerformed
        // TODO add your handling code here:
        String maKH = txtTimKH.getText();
        if (qlkh.searchKH(maKH).isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy khách hàng");
            return;
        }
        if (maKH.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập mã khách hàng");
        } else {
            dtm.setRowCount(0);
            for (KhachHang kh : qlkh.searchKH(maKH)) {
                dtm.addRow(new Object[]{
                    kh.getMaKhachHang(),
                    kh.getTenKhachHang(),
                    kh.getGioiTinh() ? "Nam" : "Nữ",
                    kh.getSdt(),
                    kh.getDiaChi()
                });
            }
        }

    }//GEN-LAST:event_btnTimKiemKHActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        txtHoTenKH.setText("");
        txtDiaChi.setText("");
        txtSDT.setText("");
        txtMaKH.setText("");
        buttonGroup2.clearSelection();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void tblQLHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblQLHoaDonMouseClicked
        // TODO add your handling code here:
        int row = tblQLHoaDon.getSelectedRow();
        if (row >= 0) {
            String maHD = qlhd.getRowHD(row).getMaHoaDon();
            System.out.println(maHD);
            loadAllDataHDCT_QL(qlhdct.getAllHDCT_LSG(maHD));
        }
    }//GEN-LAST:event_tblQLHoaDonMouseClicked

    private void btnTimSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimSPActionPerformed
        // TODO add your handling code here:
        //String maSP = txtTimSP.getText().trim();
        //int row = tblDanhSachSP.getSelectedRow();
        if (!qlsp.TimKiemSanPhamTheoTenSP(txtTimSP.getText().trim()).isEmpty() && !txtTimSP.getText().trim().isEmpty()) {
            listSP.clear();
            //listSP = qlsp.TimKiemSanPhamTheoTenSP(txtTimSP.getText().trim());
            loadDanhSachSanPham(qlsp.TimKiemSanPhamTheoTenSP(txtTimSP.getText().trim()));
        } else {
            System.out.println("Roong");
            if (rdTatCa.isSelected()) {
                listSP.clear();
                listSP = qlsp.getAll();
                loadDanhSachSanPham(qlsp.getAll());
            } else if (rdTheoGia.isSelected()) {
                listSP.clear();
                listSP = qlsp.sapXepSanPhamTheoGia();
                loadDanhSachSanPham(listSP);
            } else if (rdTheoTen.isSelected()) {
                listSP.clear();
                listSP = qlsp.sapXepSanPhamTheoTen();
                loadDanhSachSanPham(listSP);
            }
        }
    }//GEN-LAST:event_btnTimSPActionPerformed

    private void btnTimKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKHMouseClicked
        // TODO add your handling code here:
        if (!qlkh.searchKH(txtTimThongTinKH.getText().trim()).isEmpty() && !txtTimThongTinKH.getText().trim().isEmpty()) {
            String tenKH = qlkh.searchKH(txtTimThongTinKH.getText().trim()).get(0).getTenKhachHang();
            System.out.println(tenKH);
            lblTenTimDuoc.setText(tenKH);
        } else {
            JOptionPane.showMessageDialog(this, "Không được để trống trường dữ liệu !");
            lblTenTimDuoc.setText("");
        }
    }//GEN-LAST:event_btnTimKHMouseClicked

    private void btnSearchHoaDon_QLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchHoaDon_QLMouseClicked
        // TODO add your handling code here:
        String searchHD = txtTimMaHD_QL.getText();
        ArrayList<HoaDon> listSearchHD = qlhd.searchQLHD(searchHD);
        System.out.println(listSearchHD);
//        System.out.println(searchHD);
        if (searchHD.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã hoá đơn");
        } else {
            if (listSearchHD.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Không tồn tại hoá đơn này");
                loadDSHD_QL(qlhd.getAllHoaDon());
            } else {
                loadDSHD_QL(qlhd.searchQLHD(searchHD));
                loadAllDataHDCT_QL(qlhdct.getAllHDCT_LSG(searchHD));
            }
        }
    }//GEN-LAST:event_btnSearchHoaDon_QLMouseClicked

    private void txtTimMaHD_QLFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimMaHD_QLFocusGained
        // TODO add your handling code here:
        if (txtTimMaHD_QL.getText().equals("Nhập mã hoá đơn cần tìm")) {
            txtTimMaHD_QL.setText("");
            txtTimMaHD_QL.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtTimMaHD_QLFocusGained

    private void txtTimMaHD_QLFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTimMaHD_QLFocusLost
        // TODO add your handling code here:
        if (txtTimMaHD_QL.getText().equals("")) {
            txtTimMaHD_QL.setText("Nhập mã hoá đơn cần tìm");
            txtTimMaHD_QL.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtTimMaHD_QLFocusLost

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
        int count = 0;
        String ngayBD = txtNgayBD.getText();
        String ngayKT = txtNgayKT.getText();

        if (ngayBD.isEmpty()) {
            JOptionPane.showMessageDialog(this, " Vui lòng nhập ngày bắt đầu");
            count++;
        }
        if (ngayKT.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập ngày kết thúc");
            count++;
        }
        if (count == 0) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            try {
                Date date1 = sdf.parse(ngayBD);
                System.out.println(ngayBD);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(this, "Ngày bắt đầu không đúng định dạng");
//                return;
            }
            try {
                Date date2 = sdf.parse(ngayKT);
                System.out.println(ngayKT);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(this, "Ngày kết thúc không đúng định dạng");
//                return;
            }
            ArrayList<HoaDon> listLocHD = qlhd.locHDTheoNgay(ngayBD, ngayKT);
            if (listLocHD.isEmpty()) {
                JOptionPane.showMessageDialog(this, " Không tìm thấy hoá đơn");
                txtNgayBD.setText("");
                txtNgayKT.setText("");
                ArrayList<HoaDon> listHD = new ArrayList<>();
                loadDSHD_QL(listHD);
            } else {
                loadDSHD_QL(qlhd.locHDTheoNgay(ngayBD, ngayKT));
            }
        }
    }//GEN-LAST:event_jButton19ActionPerformed

    private void txtNgayBDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNgayBDFocusGained
        // TODO add your handling code here:
        if (txtNgayBD.getText().equals("yyyy-mm-dd")) {
            txtNgayBD.setText("");
            txtNgayBD.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtNgayBDFocusGained

    private void txtNgayBDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNgayBDFocusLost
        // TODO add your handling code here:
        if (txtNgayBD.getText().equals("")) {
            txtNgayBD.setText("yyyy-mm-dd");
            txtNgayBD.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtNgayBDFocusLost

    private void txtNgayKTFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNgayKTFocusGained
        // TODO add your handling code here:
        if (txtNgayKT.getText().equals("yyyy-mm-dd")) {
            txtNgayKT.setText("");
            txtNgayKT.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtNgayKTFocusGained

    private void txtNgayKTFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNgayKTFocusLost
        // TODO add your handling code here:
        if (txtNgayKT.getText().equals("")) {
            txtNgayKT.setText("yyyy-mm-dd");
            txtNgayKT.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtNgayKTFocusLost

    private void btnBoLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBoLocActionPerformed
        // TODO add your handling code here:
        loadDSHD_QL(qlhd.getAllHoaDon());
    }//GEN-LAST:event_btnBoLocActionPerformed
//void tinhTienKhuyenMai(Voucher voucher) {
//        if (voucher == null) {
//            JOptionPane.showMessageDialog(this, "Mã khuyến mãi không hợp lệ");
//        } else {
//            if (voucher.getNgayKT().getTime() <= new Date().getTime()) {
//                JOptionPane.showMessageDialog(this, "Voucher đã hết hạn");
//                return;
//            }
//            if (voucher.getLoaiGiam().equalsIgnoreCase("Dành Cho Khách Hàng")) {
//                // Check xem Voucher còn hạn sử dụng không
//                // Check xem khách hàng đã được thêm chưa. 
//                String maKH = txt_maKH.getText().toString();
//                if (maKH == null || maKH.equalsIgnoreCase("")) {
//                    JOptionPane.showMessageDialog(this, "Voucher này chỉ dành cho khách hàng");
//                    return;
//                }
//            }
//            Double tongTien = 0.0;
//            for (ChiTietSanPham chiTietSanPhamTrongGioHang : listChiTietGioHang) {
//                tongTien = tongTien + (chiTietSanPhamTrongGioHang.getGiaBan() * chiTietSanPhamTrongGioHang.getSoLuongTrongGioHang());
//            }
//            txt_voucher.setText(voucher.getMa());
//
//            Double soTienDuocGiam = tongTien * ((double) voucher.getGiatri() / 100);
//            txt_tienDuocGiam.setText(soTienDuocGiam.toString());
//            Double tienConLai = tongTien - soTienDuocGiam;
//            txt_tiensgg.setText(String.valueOf(tienConLai));
//        }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NhanVienView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhanVienView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhanVienView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhanVienView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NhanVienView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApMaGG;
    private javax.swing.JButton btnBanHang;
    private javax.swing.JButton btnBoLoc;
    private javax.swing.JButton btnChonVoucher;
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnHuyHD;
    private javax.swing.JButton btnHuyVoucher;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnNewForm;
    private javax.swing.JButton btnQuanLyHoaDon;
    private javax.swing.JButton btnQuanLyKhachHang;
    private javax.swing.JButton btnQuanLyUuDai;
    private javax.swing.JButton btnSearchHoaDon_QL;
    private javax.swing.JButton btnSuaHD;
    private javax.swing.JButton btnSuaSLSP;
    private javax.swing.JButton btnTaoHD;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThemKH;
    private javax.swing.JButton btnThemSPVaoHD;
    private javax.swing.JButton btnTimKH;
    private javax.swing.JButton btnTimKiemKH;
    private javax.swing.JButton btnTimKiemVoucher;
    private javax.swing.JButton btnTimSP;
    private javax.swing.JButton btnTrangChu;
    private javax.swing.JButton btnXacNhanVoucher;
    private javax.swing.JButton btnXoaSP;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JPanel formBanHang;
    private javax.swing.JPanel formNhanVien;
    private javax.swing.JPanel formQuanLyHoaDon;
    private javax.swing.JPanel formQuanLyKhachHang;
    private javax.swing.JPanel formTrangChu;
    private javax.swing.JPanel formVoucher;
    private javax.swing.JButton jButton19;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblMaHD;
    private javax.swing.JLabel lblMaKH;
    private javax.swing.JLabel lblNgayHoanThanh;
    private javax.swing.JLabel lblNgayTao;
    private javax.swing.JLabel lblPhanTramTru;
    private javax.swing.JLabel lblTenNV;
    private javax.swing.JLabel lblTenTimDuoc;
    private javax.swing.JRadioButton rdNam;
    private javax.swing.JRadioButton rdNu;
    private javax.swing.JRadioButton rdTatCa;
    private javax.swing.JRadioButton rdTheoGia;
    private javax.swing.JRadioButton rdTheoTen;
    private javax.swing.JTable tblDanhSachKH;
    private javax.swing.JTable tblDanhSachSP;
    private javax.swing.JTable tblDanhSachVoucher;
    private javax.swing.JTable tblHDCT_QL;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblHoaDonApDungVoucher;
    private javax.swing.JTable tblQLHoaDon;
    private javax.swing.JTable tblSP_HD;
    private javax.swing.JTable tblXacNhanVoucher;
    private javax.swing.JTextArea txtDiaChi;
    private javax.swing.JTextField txtHoTenKH;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtNgayBD;
    private javax.swing.JTextField txtNgayKT;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtThanhTien;
    private javax.swing.JTextField txtTienDu;
    private javax.swing.JTextField txtTienKhachTra;
    private javax.swing.JTextField txtTimKH;
    private javax.swing.JTextField txtTimKiemVoucher;
    private javax.swing.JTextField txtTimMaHD_QL;
    private javax.swing.JTextField txtTimSP;
    private javax.swing.JTextField txtTimThongTinKH;
    // End of variables declaration//GEN-END:variables
}
