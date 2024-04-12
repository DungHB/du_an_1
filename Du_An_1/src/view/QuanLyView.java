/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ChatLieu;
import model.KhachHang;
import model.MauSac;
import model.NguoiDung;
import model.SanPham1;
import model.SanPhamChiTiet1;
import model.Size;
import model.ThuongHieu;
import service.Impl.ChatLieuServiceImpl;
import service.Impl.KhachHangServiceImpl;
import service.Impl.MauSacServiceImpl;
import service.Impl.NguoiDungServiceImpl;
import service.Impl.SanPhamChiTietServiceImpl1;
import service.Impl.SanPhamServiceImpl1;
import service.Impl.SizeServiceImpl;
import service.Impl.ThuongHieuServiceImpl;
import service.KhachHangService;

/**
 *
 * @author Hi Windows 10
 */
public class QuanLyView extends javax.swing.JFrame {

    ThuongHieuServiceImpl serviceTH = new ThuongHieuServiceImpl();
    MauSacServiceImpl serviceMS = new MauSacServiceImpl();
    SizeServiceImpl serviceSize = new SizeServiceImpl();
    ChatLieuServiceImpl serviceChatlieu = new ChatLieuServiceImpl();
    SanPhamServiceImpl1 spService = new SanPhamServiceImpl1();
    SanPhamChiTietServiceImpl1 spctService = new SanPhamChiTietServiceImpl1();
    DefaultTableModel model1;
    DefaultTableModel model2;
    DefaultTableModel dtm;
    List<MauSac> listMS;
    List<Size> listSize;
    List<ChatLieu> listChatlieu;
    List<ThuongHieu> listTH;
    NguoiDungServiceImpl qlnd = new NguoiDungServiceImpl();
    KhachHangService qlkh = new KhachHangServiceImpl();

    public QuanLyView() {
        initComponents();
        setLocationRelativeTo(null);
        model1 = (DefaultTableModel) tblSanpham.getModel();
        model2 = (DefaultTableModel) tbl_sanPhamChiTiet1.getModel();
        loadDataSP();
        loadDataSPCT();
        fillCombMauSac();
        fillCombSize();
        fillCombChatLieu();
        fillCombThuongHieu();
        loadDataNguoiDung();
        loadDanhSachKhachHang(qlkh.getAllKhachHang());
    }

    void setFormKhachHang(KhachHang kh) {
        txtMaKH.setText(kh.getMaKhachHang());
        txtHoTenKH.setText(kh.getTenKhachHang());
        txtSoDT.setText(kh.getSdt());
        txtDiaChi.setText(kh.getDiaChi());
        if (kh.getGioiTinh() == true) {
            rdNam.setSelected(true);
        } else {
            rdNu.setSelected(true);
        }
    }

    KhachHang getFormKhachHang() {
        KhachHang kh = new KhachHang();
        kh.setTenKhachHang(txtHoTenKH.getText());
        kh.setMaKhachHang(txtMaKH.getText());
        kh.setDiaChi(txtDiaChi.getText());
        kh.setSdt(txtSoDT.getText());
        boolean gioiTinh = false;
        if (rdNam.isSelected()) {
            gioiTinh = true;
        }
        kh.setGioiTinh(gioiTinh);
        return kh;
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

    void loadDataNguoiDung() {
        dtm = (DefaultTableModel) tblThongTinNhanVien.getModel();
        dtm.setRowCount(0);
        for (NguoiDung nd : qlnd.getAll()) {
            dtm.addRow(new Object[]{
                nd.getMaNguoiDung(),
                nd.getTenNguoiDung(),
                nd.isGioiTinh() ? "Nam" : "Nữ",
                nd.getTuoi(),
                nd.getSdt(),
                nd.getEmail(),
                nd.getMaCV(),
                nd.getTenDN(),
                nd.getMatKhau(),
                nd.isTrangThai() ? "Đi làm" : "Đã nghỉ"
            });
        }
    }

    void setFormND(NguoiDung nd) {
        txtTenDN.setText(nd.getMaNguoiDung());
        txtTenNV.setText(nd.getTenNguoiDung());
        txtMaNhanVien.setText(nd.getTenNguoiDung());
        txt_Tuoi.setText(nd.getTuoi() + "");
        boolean gt = nd.isGioiTinh();
        if (gt == true) {
            rb_nam1.setSelected(true);

        } else {
            rb_nu1.setSelected(true);

        }
        txtChucvu.setText(nd.getMaCV());
        txtSDT.setText(nd.getSdt());
        txtEmail.setText(nd.getEmail());
        txtMK.setText(nd.getMatKhau());
        boolean TT = nd.isTrangThai();
        if (TT == true) {
            rb_diLam.setSelected(true);

        } else {
            rb_daNghi.setSelected(true);

        }
        txtEmail.setText(nd.getMatKhau());
    }

    void loadDataSP() {
        model1.setRowCount(0);
        for (SanPham1 sp : spService.getAll1()) {
            Object[] row = new Object[]{
                sp.getMaSanPham(),
                sp.getTenSanPham(),
                sp.getTheloai()
            };
            model1.addRow(row);

        }
    }

    void loadDataSPCT() {
        model2.setRowCount(0);
        for (SanPhamChiTiet1 spct : spctService.getAll2()) {
            Object[] row2 = new Object[]{
                spct.getMaSPCT(),
                spct.getTenSanPham(),
                spct.getTenThuongHieu(),
                spct.getTenChatLieu(),
                spct.getTenMauSac(),
                spct.getSize(),
                spct.getSoLuong(),};
            model2.addRow(row2);
        }
    }

    SanPham1 getForm() {
        SanPham1 sp = new SanPham1();
        sp.setMaSanPham(txtMasp.getText());
        sp.setTenSanPham(txtTensp.getText());
        sp.setTheloai(cboTheloai.getSelectedItem().toString());
        //sp.setTenThuonghieu(cboThuonghieu.getSelectedItem().toString());
        return sp;
    }

    void setForm2(SanPhamChiTiet1 spct) {
        txtMaSPCT.setText(spct.getMaSPCT());
        txtTenSP.setText(spct.getTenSanPham());
        cboTh.setSelectedItem(spct.getTenThuongHieu());
        cbo_chatLieu.setSelectedItem(spct.getTenChatLieu());
        cbo_mauSac.setSelectedItem(spct.getTenMauSac());
        cbo_size.setSelectedItem(String.valueOf(spct.getSize()));
        txtSL.setText(spct.getSoLuong() + "");
    }

    Boolean checkNull() {
        String ma = txtMasp.getText();
        if (ma.equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sản phẩm");
            return false;
        }
        String hoten = txtTensp.getText();
        if (hoten.equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên sản phẩm");
            return false;
        }

        return true;

    }

    Boolean checkNullSPCT() {
        String ma = txtMaSPCT.getText();
        if (ma.equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã sản phẩm chi tiết");
            return false;
        }
        String hoten = txtTenSP.getText();
        if (hoten.equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên sản phẩm chi tiết");
            return false;
        }
        String sl = txtSL.getText();
        if (sl.equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng sản phẩm chi tiết");
            return false;
        }

        return true;

    }

    void setForm(SanPham1 sp) {
        txtMasp.setText(sp.getMaSanPham());
        txtTensp.setText(sp.getTenSanPham());
        cboTheloai.setSelectedItem(sp.getTheloai());
        //cboThuonghieu.setSelectedItem(sp.getTenThuonghieu());

    }

    public void fillCombMauSac() {
        DefaultComboBoxModel<String> modelMS = new DefaultComboBoxModel<>();
        cbo_mauSac.setModel(modelMS);
        listMS = serviceMS.getAllMau();
        for (MauSac mausac : listMS) {
            modelMS.addElement(mausac.getTenMauSac());
        }

    }

    public void fillCombSize() {
        DefaultComboBoxModel<String> modelSize = new DefaultComboBoxModel<>();
        cbo_size.setModel(modelSize);
        listSize = serviceSize.getAllSize();
        for (Size size : listSize) {
            modelSize.addElement(size.getSize() + "");
        }
    }

    public void fillCombChatLieu() {
        DefaultComboBoxModel<String> modelCL = new DefaultComboBoxModel<>();
        cbo_chatLieu.setModel(modelCL);
        listChatlieu = serviceChatlieu.getAllChatLieu();
        for (ChatLieu cl : listChatlieu) {
            modelCL.addElement(cl.getTenChatLieu());
        }
    }

    public void fillCombThuongHieu() {
        DefaultComboBoxModel<String> modelTH = new DefaultComboBoxModel<>();
        cboTh.setModel(modelTH);
        listTH = serviceTH.getAllTH();
        for (ThuongHieu th : listTH) {
            modelTH.addElement(th.getTenThuongHieu());
        }
    }

    SanPhamChiTiet1 getForm2() {
        SanPhamChiTiet1 spct = new SanPhamChiTiet1();
        spct.setMaSPCT(txtMaSPCT.getText());
        spct.setMaSanPham(spctService.getIDSanPham(txtTenSP.getText()));
        spct.setMaThuongHieu(spctService.getIDTH(cboTh.getSelectedItem().toString()));
        spct.setMaChatLieu(spctService.getIDChatLieu(cbo_chatLieu.getSelectedItem().toString()));
        spct.setMaMauSac(spctService.getIDMauSac(cbo_mauSac.getSelectedItem().toString()));
        spct.setMaSize(spctService.getIDKichThuoc(cbo_size.getSelectedItem().toString()));
        spct.setSoLuong(Integer.valueOf(txtSL.getText()));
        System.out.println("" + spct.toString());
        return spct;
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
        jPanel31 = new javax.swing.JPanel();
        btnQuanLySanPham = new javax.swing.JButton();
        jPanel32 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        btnQuanLyKhachHang = new javax.swing.JButton();
        btnQuanLyHoaDon = new javax.swing.JButton();
        btnQuanLyNhanVien = new javax.swing.JButton();
        btnQuanLyVoucher = new javax.swing.JButton();
        btnTrangChu = new javax.swing.JButton();
        btnDangXuat = new javax.swing.JButton();
        formQuanLy = new javax.swing.JPanel();
        formTrangChu = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        formQuanLySanPham = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtMasp = new javax.swing.JTextField();
        txtTensp = new javax.swing.JTextField();
        btnXoa = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        cboTheloai = new javax.swing.JComboBox<>();
        jPanel20 = new javax.swing.JPanel();
        btnThemsp = new javax.swing.JButton();
        btnSuasp = new javax.swing.JButton();
        btnResert = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblSanpham = new javax.swing.JTable();
        btnTimsp = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        txtTimsp = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel23 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        btn_themSPCT = new javax.swing.JButton();
        btn_suaSPCT = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        txtTenSP = new javax.swing.JTextField();
        txtSL = new javax.swing.JTextField();
        cbo_size = new javax.swing.JComboBox<>();
        cbo_mauSac = new javax.swing.JComboBox<>();
        cbo_chatLieu = new javax.swing.JComboBox<>();
        txtMaSPCT = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        cboTh = new javax.swing.JComboBox<>();
        jPanel26 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbl_sanPhamChiTiet1 = new javax.swing.JTable();
        jLabel39 = new javax.swing.JLabel();
        txtTimSPCT = new javax.swing.JTextField();
        btnTimSPCT = new javax.swing.JButton();
        formQuanLyNhanVien = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtMaNhanVien = new javax.swing.JTextField();
        txtTenDN = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtTenNV = new javax.swing.JTextField();
        txt_Tuoi = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        rb_nam1 = new javax.swing.JRadioButton();
        rb_nu1 = new javax.swing.JRadioButton();
        jLabel19 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btn_themNhanVien = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        rb_diLam = new javax.swing.JRadioButton();
        rb_daNghi = new javax.swing.JRadioButton();
        txtMK = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtChucvu = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblThongTinNhanVien = new javax.swing.JTable();
        txt_keyWord1 = new javax.swing.JTextField();
        btn_tim1 = new javax.swing.JButton();
        formQuanLyKhachHang = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtHoTenKH = new javax.swing.JTextField();
        rdNam = new javax.swing.JRadioButton();
        rdNu = new javax.swing.JRadioButton();
        txtSoDT = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        btnThemKH = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        txtTimKH = new javax.swing.JTextField();
        btnTimKiemKH = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDanhSachKH = new javax.swing.JTable();
        formQuanLyHoaDon = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_hoaDon = new javax.swing.JTable();
        jButton11 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        cbb_nhanVien = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txt_batDau = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_ketThuc = new javax.swing.JTextField();
        jPanel33 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_maHoaDon = new javax.swing.JTextField();
        btn_timKiem = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_dsGioHang = new javax.swing.JTable();
        formQuanLyVoucher = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel31.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));

        btnQuanLySanPham.setBackground(new java.awt.Color(204, 255, 204));
        btnQuanLySanPham.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnQuanLySanPham.setText("Quản Lý Sản Phẩm");
        btnQuanLySanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQuanLySanPhamMouseClicked(evt);
            }
        });

        jPanel32.setBackground(new java.awt.Color(204, 255, 255));

        jLabel38.setIcon(new javax.swing.ImageIcon("C:\\Users\\Hi Windows 10\\Documents\\9_PRO1041_du_an_1\\du_an_1\\Du_An_1\\src\\hinh\\ql.png")); // NOI18N

        jLabel35.setFont(new java.awt.Font("Sitka Subheading", 1, 18)); // NOI18N
        jLabel35.setText("Quản Lý");

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel38))
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jLabel35)
                .addGap(21, 21, 21))
        );

        btnQuanLyKhachHang.setBackground(new java.awt.Color(204, 255, 204));
        btnQuanLyKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnQuanLyKhachHang.setText("Quản Lý Khách Hàng");
        btnQuanLyKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQuanLyKhachHangMouseClicked(evt);
            }
        });

        btnQuanLyHoaDon.setBackground(new java.awt.Color(204, 255, 204));
        btnQuanLyHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnQuanLyHoaDon.setText("Quản Lý Hóa Đơn");
        btnQuanLyHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQuanLyHoaDonMouseClicked(evt);
            }
        });

        btnQuanLyNhanVien.setBackground(new java.awt.Color(204, 255, 204));
        btnQuanLyNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnQuanLyNhanVien.setText("Quản Lý Nhân Viên");
        btnQuanLyNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQuanLyNhanVienMouseClicked(evt);
            }
        });

        btnQuanLyVoucher.setBackground(new java.awt.Color(204, 255, 204));
        btnQuanLyVoucher.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnQuanLyVoucher.setText("Quản Lý Voucher");
        btnQuanLyVoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuanLyVoucherActionPerformed(evt);
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

        btnDangXuat.setBackground(new java.awt.Color(204, 255, 204));
        btnDangXuat.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnDangXuat.setText("Đăng Xuất");
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnQuanLyHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnQuanLySanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuanLyKhachHang)
                    .addComponent(btnQuanLyNhanVien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuanLyVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTrangChu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDangXuat))
                .addContainerGap())
        );

        jPanel31Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDangXuat, btnQuanLyHoaDon, btnQuanLyKhachHang, btnQuanLyNhanVien, btnQuanLySanPham, btnQuanLyVoucher, btnTrangChu});

        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTrangChu, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnQuanLySanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnQuanLyNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnQuanLyKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnQuanLyHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnQuanLyVoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(btnDangXuat)
                .addGap(20, 20, 20))
        );

        jPanel31Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnDangXuat, btnQuanLyHoaDon, btnQuanLyKhachHang, btnQuanLyNhanVien, btnQuanLySanPham, btnQuanLyVoucher, btnTrangChu});

        formQuanLy.setLayout(new java.awt.CardLayout());

        formTrangChu.setBackground(new java.awt.Color(255, 204, 204));

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/anhdep2.jpg"))); // NOI18N
        jLabel40.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/anhdep4.jpg"))); // NOI18N

        javax.swing.GroupLayout formTrangChuLayout = new javax.swing.GroupLayout(formTrangChu);
        formTrangChu.setLayout(formTrangChuLayout);
        formTrangChuLayout.setHorizontalGroup(
            formTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formTrangChuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 574, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 490, Short.MAX_VALUE)
                .addContainerGap())
        );
        formTrangChuLayout.setVerticalGroup(
            formTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formTrangChuLayout.createSequentialGroup()
                .addGroup(formTrangChuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formTrangChuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(formTrangChuLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(109, Short.MAX_VALUE))
        );

        formQuanLy.add(formTrangChu, "card6");

        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel37.setText("Thông Tin Sản Phẩm");

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel36.setText("Danh Sách Sản Phẩm");

        jPanel18.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel19.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel22.setText("Tên sản phẩm");

        jLabel23.setText("Mã sản phẩm");

        btnXoa.setText("XOA");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jLabel24.setText("Thể loại");

        cboTheloai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dép cao su", "Dép lê", "Dép xỏ ngón", "Dép kẹp" }));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jLabel22))
                .addGap(31, 31, 31)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMasp, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                    .addComponent(txtTensp))
                .addGap(18, 18, 18)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cboTheloai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXoa)
                .addGap(28, 28, 28))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtMasp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(cboTheloai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(btnXoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtTensp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        jPanel20.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnThemsp.setText("Thêm");
        btnThemsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemspActionPerformed(evt);
            }
        });

        btnSuasp.setText("Sửa");
        btnSuasp.setPreferredSize(new java.awt.Dimension(77, 22));
        btnSuasp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaspActionPerformed(evt);
            }
        });

        btnResert.setText("Làm mới");
        btnResert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResertActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnResert)
                    .addComponent(btnSuasp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThemsp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnThemsp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSuasp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnResert)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(405, 405, 405))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );

        jPanel21.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblSanpham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "MÃ SP", "TÊN SP", "THỂ LOẠI"
            }
        ));
        tblSanpham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanphamMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblSanpham);

        btnTimsp.setText("Tìm");
        btnTimsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimspActionPerformed(evt);
            }
        });

        jLabel26.setText("Tìm kiếm");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(32, 32, 32)
                        .addComponent(txtTimsp, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnTimsp))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 832, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTimsp)
                    .addComponent(jLabel26)
                    .addComponent(txtTimsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(45, 45, 45)
                            .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, 865, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel36)
                                .addComponent(jLabel37)))))
                .addContainerGap(178, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel37)
                .addGap(29, 29, 29)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel36)
                .addGap(27, 27, 27)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sản Phẩm", jPanel1);

        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Thông tin sản phẩm"), "Thông Tin Sản Phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel27.setText("Mã SPCT:");

        jLabel28.setText("Tên Sản Phẩm:");

        jLabel31.setText("Số lượng:");

        jLabel32.setText("Size");

        jLabel33.setText("Màu sắc");

        jPanel24.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btn_themSPCT.setText("Thêm mới");
        btn_themSPCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themSPCTActionPerformed(evt);
            }
        });

        btn_suaSPCT.setText("Sửa");
        btn_suaSPCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaSPCTActionPerformed(evt);
            }
        });

        jButton7.setText("Làm mới");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_suaSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_themSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(btn_themSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_suaSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel34.setText("Chất liệu");

        txtSL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSLActionPerformed(evt);
            }
        });

        cbo_size.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "37", "38", "39", "40", "41" }));

        cbo_mauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Xanh", "Đỏ", "Đen" }));

        cbo_chatLieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cao su", "Da lộn", "Nhựa đúc" }));
        cbo_chatLieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_chatLieuActionPerformed(evt);
            }
        });

        jButton3.setText("...");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setText("...");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton4.setText("...");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel43.setText("Thương hiệu");

        jButton6.setText("...");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        cboTh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Boo", "Adidas", "Puma", "Hades", "Nike" }));

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cboTh, 0, 146, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton6))
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel28))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtTenSP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                                    .addComponent(txtMaSPCT, javax.swing.GroupLayout.Alignment.LEADING))))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel34)
                            .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel32)
                                .addComponent(jLabel33))))
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbo_size, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(cbo_mauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbo_chatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3)
                            .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton4))))
                    .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel23Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(jLabel34)
                            .addComponent(cbo_chatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33)
                            .addComponent(cbo_mauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbo_size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32)
                            .addComponent(jButton4)
                            .addComponent(jLabel43)
                            .addComponent(jButton6)
                            .addComponent(cboTh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31))))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel26.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Danh sách sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tbl_sanPhamChiTiet1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã SPCT", "Sản phẩm", "Thương hiệu", "Chất liệu", "Màu sắc", "Size", "Số lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_sanPhamChiTiet1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_sanPhamChiTiet1MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tbl_sanPhamChiTiet1);

        jLabel39.setText("Tìm kiếm");

        btnTimSPCT.setText("Tìm");
        btnTimSPCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimSPCTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 839, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel26Layout.createSequentialGroup()
                        .addComponent(jLabel39)
                        .addGap(18, 18, 18)
                        .addComponent(txtTimSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btnTimSPCT)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(txtTimSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimSPCT))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(141, 141, 141))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(125, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Chi Tiết Sản Phẩm", jPanel2);

        javax.swing.GroupLayout formQuanLySanPhamLayout = new javax.swing.GroupLayout(formQuanLySanPham);
        formQuanLySanPham.setLayout(formQuanLySanPhamLayout);
        formQuanLySanPhamLayout.setHorizontalGroup(
            formQuanLySanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1088, Short.MAX_VALUE)
            .addGroup(formQuanLySanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING))
        );
        formQuanLySanPhamLayout.setVerticalGroup(
            formQuanLySanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 761, Short.MAX_VALUE)
            .addGroup(formQuanLySanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane1))
        );

        formQuanLy.add(formQuanLySanPham, "card2");

        jPanel15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel12.setText("Tên đăng nhập ");

        jLabel13.setText("Tên nhân viên");

        jLabel14.setText("Số điện thoại");

        jLabel15.setText("Mã nhân viên");

        jLabel16.setText("Giới tính");

        jLabel17.setText("Tuổi");

        jLabel18.setText("Mật khẩu");

        buttonGroup1.add(rb_nam1);
        rb_nam1.setText("Nam");

        buttonGroup1.add(rb_nu1);
        rb_nu1.setText("Nữ");

        jLabel19.setText("Email");

        btn_themNhanVien.setText("Thêm");

        btn_sua.setText("Sửa");

        jLabel20.setText("Trạng thái");

        buttonGroup2.add(rb_diLam);
        rb_diLam.setText("Đi làm");

        buttonGroup2.add(rb_daNghi);
        rb_daNghi.setText("Đã nghỉ");

        jLabel25.setText("Chức vụ");

        txtChucvu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtChucvuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel15Layout.createSequentialGroup()
                                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(25, 25, 25))
                                .addGroup(jPanel15Layout.createSequentialGroup()
                                    .addComponent(jLabel13)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel15Layout.createSequentialGroup()
                                    .addComponent(jLabel15)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaNhanVien)
                            .addComponent(txtTenNV)
                            .addComponent(txt_Tuoi)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(rb_nam1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                                .addComponent(rb_nu1))
                            .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_themNhanVien)
                        .addGap(18, 18, 18)
                        .addComponent(btn_sua)
                        .addGap(48, 48, 48))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTenDN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtChucvu, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel15Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(rb_diLam)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rb_daNghi))))
                            .addComponent(txtMK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(15, Short.MAX_VALUE))))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel15Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rb_nam1)
                            .addComponent(rb_nu1)
                            .addComponent(jLabel16)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel15Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenDN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)))
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(8, 8, 8)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_Tuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtChucvu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(rb_diLam)
                            .addComponent(rb_daNghi)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))))
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_sua)
                            .addComponent(btn_themNhanVien))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addGap(52, 52, 52))))
        );

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin nhân viên"));

        jLabel21.setText("Tìm kiếm");

        tblThongTinNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã NV", "Tên Nhân viên", "Giới tính", "Tuổi", "SDT", "Email", "Tên đăng nhập", "Mật khẩu", "Chức vụ", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblThongTinNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblThongTinNhanVienMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblThongTinNhanVien);

        btn_tim1.setText("Tìm");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_keyWord1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_tim1)
                .addGap(265, 509, Short.MAX_VALUE))
            .addComponent(jScrollPane4)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txt_keyWord1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_tim1))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout formQuanLyNhanVienLayout = new javax.swing.GroupLayout(formQuanLyNhanVien);
        formQuanLyNhanVien.setLayout(formQuanLyNhanVienLayout);
        formQuanLyNhanVienLayout.setHorizontalGroup(
            formQuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formQuanLyNhanVienLayout.createSequentialGroup()
                .addGroup(formQuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formQuanLyNhanVienLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(formQuanLyNhanVienLayout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(184, Short.MAX_VALUE))
        );
        formQuanLyNhanVienLayout.setVerticalGroup(
            formQuanLyNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formQuanLyNhanVienLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        formQuanLy.add(formQuanLyNhanVien, "card3");

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Thiết lập thông tin khách hàng"));

        jLabel6.setText("Họ tên");

        jLabel7.setText("Giới tính");

        jLabel9.setText("Số điện thoại");

        jLabel10.setText("Địa chỉ");

        buttonGroup3.add(rdNam);
        rdNam.setText("Nam");

        buttonGroup3.add(rdNu);
        rdNu.setText("Nữ");

        jPanel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnThemKH.setText("Thêm");
        btnThemKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemKHMouseClicked(evt);
            }
        });

        btnLamMoi.setText("Làm mới");
        btnLamMoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLamMoiMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLamMoi)
                    .addComponent(btnThemKH))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(btnThemKH)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(btnLamMoi)
                .addGap(58, 58, 58))
        );

        jLabel11.setText("Mã khách hàng");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtHoTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(rdNam)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rdNu)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSoDT)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 133, Short.MAX_VALUE)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtSoDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtHoTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))))
                .addGap(25, 25, 25)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(rdNam)
                    .addComponent(rdNu))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Thông tin khách hàng")));

        btnTimKiemKH.setText("Tìm kiếm");
        btnTimKiemKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTimKiemKHMouseClicked(evt);
            }
        });

        tblDanhSachKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã khách hàng", "Họ tên", "Giới tính", "Số điện thoại ", "Địa chỉ"
            }
        ));
        tblDanhSachKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachKHMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDanhSachKH);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(txtTimKH, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(btnTimKiemKH)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiemKH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout formQuanLyKhachHangLayout = new javax.swing.GroupLayout(formQuanLyKhachHang);
        formQuanLyKhachHang.setLayout(formQuanLyKhachHangLayout);
        formQuanLyKhachHangLayout.setHorizontalGroup(
            formQuanLyKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formQuanLyKhachHangLayout.createSequentialGroup()
                .addContainerGap(100, Short.MAX_VALUE)
                .addGroup(formQuanLyKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formQuanLyKhachHangLayout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formQuanLyKhachHangLayout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );
        formQuanLyKhachHangLayout.setVerticalGroup(
            formQuanLyKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formQuanLyKhachHangLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(75, 75, 75))
        );

        formQuanLy.add(formQuanLyKhachHang, "card4");

        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tbl_hoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID hoá đơn", "Mã hoá đơn", "Ngày Tạo", "Trạng Thái", "Tổng tiền", "Nhân Viên", "Khách Hàng"
            }
        ));
        jScrollPane1.setViewportView(tbl_hoaDon);

        jButton11.setText("Tất cả");

        jPanel9.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        cbb_nhanVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Nhân Viên");

        jButton1.setText("Lọc");

        jLabel2.setText("Bắt đầu");

        txt_batDau.setText("2024-01-01");

        jLabel4.setText("Kết thúc");

        txt_ketThuc.setText("2024-01-31");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_batDau, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_ketThuc, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(cbb_nhanVien, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(72, 72, 72)
                        .addComponent(jButton1)))
                .addGap(16, 16, 16))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_batDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txt_ketThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbb_nhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(16, 16, 16))
        );

        jPanel33.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Tìm hoá đơn");

        jLabel5.setText("Mã hoá đơn");

        btn_timKiem.setText("Tìm");

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(jLabel1))
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_maHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(btn_timKiem)))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_maHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_timKiem)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11)
                    .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        tbl_dsGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Sản phẩm", "Giá", "Size", "Màu", "Số lượng", "Thành tiền", "ID HDCT", "ID SPCT"
            }
        ));
        jScrollPane3.setViewportView(tbl_dsGioHang);

        javax.swing.GroupLayout formQuanLyHoaDonLayout = new javax.swing.GroupLayout(formQuanLyHoaDon);
        formQuanLyHoaDon.setLayout(formQuanLyHoaDonLayout);
        formQuanLyHoaDonLayout.setHorizontalGroup(
            formQuanLyHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formQuanLyHoaDonLayout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addGroup(formQuanLyHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(formQuanLyHoaDonLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 834, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(formQuanLyHoaDonLayout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(153, 153, 153))))
        );
        formQuanLyHoaDonLayout.setVerticalGroup(
            formQuanLyHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formQuanLyHoaDonLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        formQuanLy.add(formQuanLyHoaDon, "card5");

        javax.swing.GroupLayout formQuanLyVoucherLayout = new javax.swing.GroupLayout(formQuanLyVoucher);
        formQuanLyVoucher.setLayout(formQuanLyVoucherLayout);
        formQuanLyVoucherLayout.setHorizontalGroup(
            formQuanLyVoucherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1088, Short.MAX_VALUE)
        );
        formQuanLyVoucherLayout.setVerticalGroup(
            formQuanLyVoucherLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 761, Short.MAX_VALUE)
        );

        formQuanLy.add(formQuanLyVoucher, "card8");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1092, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(0, 212, Short.MAX_VALUE)
                    .addComponent(formQuanLy, javax.swing.GroupLayout.PREFERRED_SIZE, 1088, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(formQuanLy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnQuanLySanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLySanPhamMouseClicked
        // TODO add your handling code here:
        formQuanLy.removeAll();
        formQuanLy.add(formQuanLySanPham);
        formQuanLy.repaint();
        formQuanLy.revalidate();
    }//GEN-LAST:event_btnQuanLySanPhamMouseClicked

    private void btnQuanLyKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyKhachHangMouseClicked
        // TODO add your handling code here:
        formQuanLy.removeAll();
        formQuanLy.add(formQuanLyKhachHang);
        formQuanLy.repaint();
        formQuanLy.revalidate();
    }//GEN-LAST:event_btnQuanLyKhachHangMouseClicked

    private void btnQuanLyHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyHoaDonMouseClicked
        // TODO add your handling code here:
        formQuanLy.removeAll();
        formQuanLy.add(formQuanLyHoaDon);
        formQuanLy.repaint();
        formQuanLy.revalidate();
    }//GEN-LAST:event_btnQuanLyHoaDonMouseClicked

    private void btnQuanLyNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuanLyNhanVienMouseClicked
        // TODO add your handling code here:
        formQuanLy.removeAll();
        formQuanLy.add(formQuanLyNhanVien);
        formQuanLy.repaint();
        formQuanLy.revalidate();
    }//GEN-LAST:event_btnQuanLyNhanVienMouseClicked

    private void btnQuanLyVoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuanLyVoucherActionPerformed
        // TODO add your handling code here:
        formQuanLy.removeAll();
        formQuanLy.add(formQuanLyVoucher);
        formQuanLy.repaint();
        formQuanLy.revalidate();
    }//GEN-LAST:event_btnQuanLyVoucherActionPerformed

    private void btnTrangChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrangChuActionPerformed
        // TODO add your handling code here:
        formQuanLy.removeAll();
        formQuanLy.add(formTrangChu);
        formQuanLy.repaint();
        formQuanLy.revalidate();
    }//GEN-LAST:event_btnTrangChuActionPerformed

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed
        // TODO add your handling code here:
        int i = JOptionPane.showConfirmDialog(this, "Bạn muốn đăng xuất phải không ?");
        if (i == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_btnDangXuatActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int row = tblSanpham.getSelectedRow();
        if (row >= 0) {
            String Ma = spService.getRow(row).getMaSanPham();
            spService.deleteByMa(Ma);
            loadDataSP();
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnThemspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemspActionPerformed
        // TODO add your handling code here:

        if (!checkNull()) {
            return;
        } else {
            spService.Them(getForm());
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            loadDataSP();

        }
    }//GEN-LAST:event_btnThemspActionPerformed

    private void btnSuaspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaspActionPerformed
        // TODO add your handling code here:
        int row = tblSanpham.getSelectedRow();
        //if (row >= 0) {
        // SanPham sp = getForm();
        // sp.setMaSanPham(spService.getRow(row).getMaSanPham());
        // spService.update(sp);
        //loadDataSP();
        //}

        if (row >= 0) {

            int hoi = JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa sản phẩm này hay không ?");
            if (hoi != JOptionPane.YES_OPTION) {
                return;
            }
            if (row >= 0) {
                SanPham1 sp = getForm();
                sp.setMaSanPham(spService.getRow(row).getMaSanPham());
                spService.update(sp);
                JOptionPane.showMessageDialog(this, "Sửa thành công");
                loadDataSP();
            } else {
                JOptionPane.showMessageDialog(this, "Sửa thất bại");
            }

        }
    }//GEN-LAST:event_btnSuaspActionPerformed

    private void btnResertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResertActionPerformed
        // TODO add your handling code here:
        txtMasp.setText("");
        txtTensp.setText("");
    }//GEN-LAST:event_btnResertActionPerformed

    private void tblSanphamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanphamMouseClicked
        // TODO add your handling code here:
        int row = tblSanpham.getSelectedRow();
        if (row >= 0) {
            // confirm
            setForm(spService.getRow(row));
        }
    }//GEN-LAST:event_tblSanphamMouseClicked

    private void btnTimspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimspActionPerformed
        // TODO add your handling code here:
        //String Ma = txtMasp.getText();
        //if (Ma.isEmpty()) {
        //this.model1(spService.getAll1());
        //}else{
        //try {
        //int ma = Integer.parseInt(Ma);
        // List<SanPham> list1 = spService.timKiem(Ma);
        // this.model1(list1);
        //} catch (NumberFormatException e) {
        //    JOptionPane.showMessageDialog(this, "Mã phải là số nguyên");
        // }
        //}
        //         else {
        //
        //            JOptionPane.showMessageDialog(this, "Vui lòng nhập mã để tìm kiếm.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        //        }
        String keyword = txtTimsp.getText();
        model1.setRowCount(0);
        for (SanPham1 sp : spService.searchByMa(keyword)) {
            Object[] row = new Object[]{
                sp.getMaSanPham(), sp.getTenSanPham(), sp.getTheloai()
            };
            model1.addRow(row);
        }
    }//GEN-LAST:event_btnTimspActionPerformed

    private void btn_themSPCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themSPCTActionPerformed
        // TODO add your handling code here:
        if (!checkNullSPCT()) {
            return;
        } else {
            spctService.Them(getForm2());
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            loadDataSPCT();

        }
    }//GEN-LAST:event_btn_themSPCTActionPerformed

    private void btn_suaSPCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaSPCTActionPerformed
        // TODO add your handling code here:
        int row = tbl_sanPhamChiTiet1.getSelectedRow();
        //if (row >= 0) {
        // String ma = spctService.getAll2().get(row).getMaSPCT();
        //SanPhamChiTiet spct = getForm2();
        //spct.setMaSPCT(ma);
        //spctService.updatect(spct);
        //loadDataSPCT();
        // }
        if (row >= 0) {

            int hoi = JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa sản phẩm này hay không ?");
            if (hoi != JOptionPane.YES_OPTION) {
                return;
            }
            if (row >= 0) {
                String ma = spctService.getAll2().get(row).getMaSPCT();
                SanPhamChiTiet1 spct = getForm2();
                spct.setMaSPCT(ma);
                spctService.updatect(spct);
                loadDataSPCT();
            } else {
                JOptionPane.showMessageDialog(this, "Sửa thất bại");
            }

        }
    }//GEN-LAST:event_btn_suaSPCTActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        txtMaSPCT.setText("");
        txtTenSP.setText("");
        txtSL.setText("");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void txtSLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSLActionPerformed

    private void cbo_chatLieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_chatLieuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_chatLieuActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        new ChatLieuDialog(null, true).setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        new MauSacDialog(null, true).setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        new KichCoDialog(null, true).setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        new ThuongHieuDialog(null, true).setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void tbl_sanPhamChiTiet1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_sanPhamChiTiet1MouseClicked
        // TODO add your handling code here:
        int row2 = tbl_sanPhamChiTiet1.getSelectedRow();
        if (row2 >= 0) {
            // confirm
            setForm2(spctService.getRow2(row2));
        }
    }//GEN-LAST:event_tbl_sanPhamChiTiet1MouseClicked

    private void btnTimSPCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimSPCTActionPerformed
        // TODO add your handling code here:
        String keywordspct = txtTimSPCT.getText();
        model2.setRowCount(0);
        for (SanPhamChiTiet1 spct : spctService.searchByMa(keywordspct)) {
            Object[] row = new Object[]{
                spct.getMaSPCT(),
                spct.getMaSanPham(),
                spct.getMaThuongHieu(),
                spct.getMaChatLieu(),
                spct.getMaMauSac(),
                spct.getMaSize(),
                spct.getSoLuong()
            };
            model2.addRow(row);
        }
    }//GEN-LAST:event_btnTimSPCTActionPerformed
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

    private void txtChucvuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtChucvuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtChucvuActionPerformed

    private void tblThongTinNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblThongTinNhanVienMouseClicked
        // TODO add your handling code here:
        int row = tblThongTinNhanVien.getSelectedRow();
        if (row >= 0) {
            setFormND(qlnd.getRow(row));
        }
    }//GEN-LAST:event_tblThongTinNhanVienMouseClicked

    private void tblDanhSachKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachKHMouseClicked
        // TODO add your handling code here:
        int row = tblDanhSachKH.getSelectedRow();
        if (row >= 0) {
            setFormKhachHang(qlkh.getRowKH(row));
        }
    }//GEN-LAST:event_tblDanhSachKHMouseClicked

    private void btnThemKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemKHMouseClicked
        // TODO add your handling code here:
        if (validateForm()) {
            qlkh.themKH(getFormKhachHang());
            JOptionPane.showMessageDialog(this, "Save thành công");
            loadDanhSachKhachHang(qlkh.getAllKhachHang());
        } else {
            JOptionPane.showMessageDialog(this, "Không được để trống các trường dữ liệu !");
        }
    }//GEN-LAST:event_btnThemKHMouseClicked

    private void btnLamMoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLamMoiMouseClicked
        // TODO add your handling code here:
        txtHoTenKH.setText("");
        txtDiaChi.setText("");
        txtSDT.setText("");
        txtMaKH.setText("");
        buttonGroup2.clearSelection();
        loadDanhSachKhachHang(qlkh.getAllKhachHang());
    }//GEN-LAST:event_btnLamMoiMouseClicked

    private void btnTimKiemKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKiemKHMouseClicked
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
    }//GEN-LAST:event_btnTimKiemKHMouseClicked

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
            java.util.logging.Logger.getLogger(QuanLyView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnQuanLyHoaDon;
    private javax.swing.JButton btnQuanLyKhachHang;
    private javax.swing.JButton btnQuanLyNhanVien;
    private javax.swing.JButton btnQuanLySanPham;
    private javax.swing.JButton btnQuanLyVoucher;
    private javax.swing.JButton btnResert;
    private javax.swing.JButton btnSuasp;
    private javax.swing.JButton btnThemKH;
    private javax.swing.JButton btnThemsp;
    private javax.swing.JButton btnTimKiemKH;
    private javax.swing.JButton btnTimSPCT;
    private javax.swing.JButton btnTimsp;
    private javax.swing.JButton btnTrangChu;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_suaSPCT;
    private javax.swing.JButton btn_themNhanVien;
    private javax.swing.JButton btn_themSPCT;
    private javax.swing.JButton btn_tim1;
    private javax.swing.JButton btn_timKiem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox<String> cbb_nhanVien;
    private javax.swing.JComboBox<String> cboTh;
    private javax.swing.JComboBox<String> cboTheloai;
    private javax.swing.JComboBox<String> cbo_chatLieu;
    private javax.swing.JComboBox<String> cbo_mauSac;
    private javax.swing.JComboBox<String> cbo_size;
    private javax.swing.JPanel formQuanLy;
    private javax.swing.JPanel formQuanLyHoaDon;
    private javax.swing.JPanel formQuanLyKhachHang;
    private javax.swing.JPanel formQuanLyNhanVien;
    private javax.swing.JPanel formQuanLySanPham;
    private javax.swing.JPanel formQuanLyVoucher;
    private javax.swing.JPanel formTrangChu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rb_daNghi;
    private javax.swing.JRadioButton rb_diLam;
    private javax.swing.JRadioButton rb_nam1;
    private javax.swing.JRadioButton rb_nu1;
    private javax.swing.JRadioButton rdNam;
    private javax.swing.JRadioButton rdNu;
    private javax.swing.JTable tblDanhSachKH;
    private javax.swing.JTable tblSanpham;
    private javax.swing.JTable tblThongTinNhanVien;
    private javax.swing.JTable tbl_dsGioHang;
    private javax.swing.JTable tbl_hoaDon;
    private javax.swing.JTable tbl_sanPhamChiTiet1;
    private javax.swing.JTextField txtChucvu;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTenKH;
    private javax.swing.JTextField txtMK;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtMaNhanVien;
    private javax.swing.JTextField txtMaSPCT;
    private javax.swing.JTextField txtMasp;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSL;
    private javax.swing.JTextField txtSoDT;
    private javax.swing.JTextField txtTenDN;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtTensp;
    private javax.swing.JTextField txtTimKH;
    private javax.swing.JTextField txtTimSPCT;
    private javax.swing.JTextField txtTimsp;
    private javax.swing.JTextField txt_Tuoi;
    private javax.swing.JTextField txt_batDau;
    private javax.swing.JTextField txt_ketThuc;
    private javax.swing.JTextField txt_keyWord1;
    private javax.swing.JTextField txt_maHoaDon;
    // End of variables declaration//GEN-END:variables
}
