--INSERT 
Insert into ChucVu(MaChucVu, TenChucVu) VALUES
('QL', N'Quản Lý'),
('NV', N'Nhân viên')

Select IdChucVu,MaChucVu, TenChucVu From ChucVu

INSERT INTO KhachHang (MaKhachHang, TenKhachHang, Sdt, DiaChi, GioiTinh, NgaySinh) VALUES ('KH001', N'Nguyễn Văn A', '0123456789', N'123 Street, City A', N'Nam', '1990-01-01');
INSERT INTO KhachHang (MaKhachHang, TenKhachHang, Sdt, DiaChi, GioiTinh, NgaySinh) VALUES ('KH002', N'Trần Thị B', '0987654321', N'456 Street, City B', N'Nữ', '1985-05-15');
INSERT INTO KhachHang (MaKhachHang, TenKhachHang, Sdt, DiaChi, GioiTinh, NgaySinh) VALUES ('KH003', N'Lê Văn C', '0345678901', N'789 Street, City C', N'Nam', '1992-08-20');
INSERT INTO KhachHang (MaKhachHang, TenKhachHang, Sdt, DiaChi, GioiTinh, NgaySinh) VALUES ('KH004', N'Phạm Thị D', '0765432109', N'987 Street, City D', N'Nữ', '1988-03-10');
INSERT INTO KhachHang (MaKhachHang, TenKhachHang, Sdt, DiaChi, GioiTinh, NgaySinh) VALUES ('KH005', N'Hoàng Văn E', '0234567890', N'654 Street, City E', N'Nam', '1995-12-25');
INSERT INTO KhachHang (MaKhachHang, TenKhachHang, Sdt, DiaChi, GioiTinh, NgaySinh) VALUES ('KH006', N'Trịnh Thị F', '0456789012', N'321 Street, City F', N'Nữ', '1987-06-30');
INSERT INTO KhachHang (MaKhachHang, TenKhachHang, Sdt, DiaChi, GioiTinh, NgaySinh) VALUES ('KH007', N'Đỗ Văn G', '0567890123', N'987 Street, City G', N'Nam', '1994-09-15');
INSERT INTO KhachHang (MaKhachHang, TenKhachHang, Sdt, DiaChi, GioiTinh, NgaySinh) VALUES ('KH008', N'Lương Thị H', '0678901234', N'654 Street, City H', N'Nữ', '1989-04-05');
INSERT INTO KhachHang (MaKhachHang, TenKhachHang, Sdt, DiaChi, GioiTinh, NgaySinh) VALUES ('KH009', N'Trần Văn I', '0789012345', N'321 Street, City I', N'Nam', '1991-07-17');
INSERT INTO KhachHang (MaKhachHang, TenKhachHang, Sdt, DiaChi, GioiTinh, NgaySinh) VALUES ('KH010', N'Lê Thị K', '0890123456', N'789 Street, City K', N'Nữ', '1986-02-28');
INSERT INTO KhachHang (MaKhachHang, TenKhachHang, Sdt, DiaChi, GioiTinh, NgaySinh) VALUES ('KH011', N'Nguyễn Văn L', '0901234567', N'123 Street, City L', N'Nam', '1993-10-08');
INSERT INTO KhachHang (MaKhachHang, TenKhachHang, Sdt, DiaChi, GioiTinh, NgaySinh) VALUES ('KH012', N'Hồ Thị M', '0912345678', N'456 Street, City M', N'Nữ', '1984-11-22');
INSERT INTO KhachHang (MaKhachHang, TenKhachHang, Sdt, DiaChi, GioiTinh, NgaySinh) VALUES ('KH013', N'Đỗ Văn N', '0923456789', N'789 Street, City N', N'Nam', '1996-04-03');
INSERT INTO KhachHang (MaKhachHang, TenKhachHang, Sdt, DiaChi, GioiTinh, NgaySinh) VALUES ('KH014', N'Lê Văn P', '0934567890', N'987 Street, City P', N'Nữ', '1983-09-12');
INSERT INTO KhachHang (MaKhachHang, TenKhachHang, Sdt, DiaChi, GioiTinh, NgaySinh) VALUES ('KH015', N'Trần Thị Q', '0945678901', N'654 Street, City Q', N'Nam', '1997-01-26');
INSERT INTO KhachHang (MaKhachHang, TenKhachHang, Sdt, DiaChi, GioiTinh, NgaySinh) VALUES ('KH016', N'Phạm Văn R', '0956789012', N'321 Street, City R', N'Nữ', '1997-01-26');


Select * from KhachHang

Insert into NguoiDung(MaNguoiDung,TenNhanVien,  Sdt, DiaChi, NgaySinh, GioiTinh, MatKhau, tenChucvu, TrangThai) VALUES
('NV001', N'Hoàng Văn Trí', '0559577371', N'54 Hoàng Ngân', '2003-1-17', N'Nam', N'nv123', N'Nhân viên', 1),
('NV009', N'Đào Duy Hà', '0826263688', N'21 Trần Duy Hưng', '2003-1-17', N'Nam', N'ql123',  N'Nhân viên', 2),
('NV002', N'Bùi Thị Hân', '0826263680', N'43 Nguyễn Chí Thanh', '2003-1-17', N'Nữ', N'nv123', N'Nhân viên', 2),
('NV003', N'Trần Thu Vy', '0926243680', N'12 Hoàng Cầu', '2003-1-17', N'Nữ', N'nv123', N'Phó Phòng', 2),
('NV0235', N'Trần Thu Thúy', '0926243680', N'12 Hoàng Cầu', '2003-1-17', N'Nữ', N'nv123', N'Nhân viên', 2),
('NV0468', N'Trần Thị Thu Hạnh', '0926243680', N'12 Hoàng Cầu', '2003-1-17', N'Nữ', N'nv123',N'Nhân viên', 2),
('NV0543', N'Trần Thu Vỹ', '0926243680', N'12 Hoàng Cầu', '2003-1-17', N'Nữ', N'nv123',  N'Nhân viên', 1),
('NV0358', N'Phan Văn Lương', '0926243680', N'12 Hoàng Cầu', '2003-1-17', N'Nam', N'nv123',  N'Tổng phòng', 2),
('NV0597', N'Trần Uy Nghi', '0926243680', N'12 Hoàng Cầu', '2003-1-17', N'Nam', N'nv123',  N'Nhân viên', 1),
('NV02136', N'Trần Văn Cương', '0926243680', N'12 Hoàng Cầu', '2003-1-17', N'Nam', N'nv123',  N'Nhân viên', 2),
('NV0236', N'Lê Anh Túc', '0926243680', N'12 Hoàng Cầu', '2003-1-17', N'Nam', N'nv123',  N'Trưởng Phòng', 2),
('NV0958', N'Ma Văn Cao', '0926243680', N'12 Hoàng Cầu', '2003-1-17', N'Nam', N'nv123',  N'Nhân viên', 3),
('NV03447', N'Trần Thúy Hằng', '0926243680', N'12 Hoàng Cầu', '2003-1-17', N'Nữ', N'nv123',  N'Nhân viên', 3)

select * from NguoiDung
Update NguoiDung set IdNguoiDung = ? , MaNguoiDung = ?, TenNhanVien = ?, Sdt = ? ,DiaChi = ? , NgaySinh = ? , GioiTinh = ? , MatKhau = ? , IdChucVu = ? , tenChucvu = ? , TrangThai = ? \n
SELECT * FROM NguoiDung WHERE MaNguoiDung = 'NV001' AND MatKhau = 'nv123'
Insert into ThuongHieu (TenThuongHieu)VALUES
(N'Adidas'),
(N'Nike'),
(N'Puma'),
(N'Boo'),
(N'Hades')

Insert into TheLoai(TenTheLoai)VALUES
(N'Dép cao su'),
(N'Dép lê'),
(N'Dép xỏ ngón'),
(N'Dép kẹp')

Insert into MauSac(TenMauSac)VALUES
(N'Xanh'),
(N'Đỏ'),
(N'Đen')


Insert into Size(Size)VALUES
(37),(38),(39),(40),(41)

Insert into ChatLieu(TenChatLieu)Values
(N'Cao su'),
(N'Da lộn'),
(N'Nhựa đúc')

Select * from TheLoai
Select * from ThuongHieu

Insert into SanPham(MaSanPham, TenSanPham, IdTheLoai, IdThuongHieu)VALUES
('SP001', N'Dép Birkenstock Arizona', 2, 4),
('SP002', N'Dép Crocs Classic Clog', 2, 1),
('SP003', N'Dép Havaianas Slim Flip Flop', 4, 3),
('SP004', N'Dép Ugg Classic Femme Mini', 1, 5),
('SP005', N'Dép Nike Benassi JDI Slide', 3, 2)

Select * from SanPham
Select * from ChatLieu
Select * from MauSac
select * from Size
Select * from ThuongHieu
Select * from NguoiDung
Select * from KhachHang
select * from SanPhamChiTiet
Insert into SanPhamChiTiet(IdSanPham, IdChatLieu, IdMauSac, IdSize, Gia, SoLuong)VALUES
(1, 2, 1, 2, 250000, 36),(1, 2, 1, 1, 250000, 24),(1, 2, 1, 3, 250000, 20),
(1, 2, 1, 4, 250000, 14),(1, 2, 1, 5, 250000, 39),
(1, 2, 2, 1, 250000, 39),(1, 2, 2, 2, 250000, 39),(1, 2, 2, 3, 250000, 39),
(1, 2, 2, 4, 250000, 39),(1, 2, 2, 5, 250000, 39),
(1, 2, 3, 2, 250000, 36),(1, 2, 3, 1, 250000, 24),(1, 2, 3, 3, 250000, 20),
(1, 2, 3, 4, 250000, 14),(1, 2, 3, 5, 250000, 39),
--
(2, 3, 1, 2, 250000, 36),(2, 3, 1, 1, 250000, 24),(2, 3, 1, 3, 250000, 20),
(2, 3, 1, 4, 250000, 14),(2, 3, 1, 5, 250000, 39),
(2, 3, 2, 2, 250000, 36),(2, 3, 2, 1, 250000, 24),(2, 3, 2, 3, 250000, 20),
(2, 3, 2, 4, 250000, 14),(2, 3, 2, 5, 250000, 39),
(2, 3, 3, 2, 250000, 36),(2, 3, 3, 1, 250000, 24),(2, 3, 3, 3, 250000, 20),
(2, 3, 3, 4, 250000, 14),(2, 3, 3, 5, 250000, 39),
--
(3, 1, 1, 2, 250000, 36),(3, 1, 1, 1, 250000, 24),(3, 1, 1, 3, 250000, 20),
(3, 1, 1, 4, 250000, 14),(3, 1, 1, 5, 250000, 39),
(3, 1, 2, 2, 250000, 36),(3, 1, 2, 1, 250000, 24),(3, 1, 2, 3, 250000, 20),
(3, 1, 2, 4, 250000, 14),(3, 1, 2, 5, 250000, 39),
(3, 1, 3, 2, 250000, 36),(3, 1, 3, 1, 250000, 24),(3, 1, 3, 3, 250000, 20),
(3, 1, 3, 4, 250000, 14),(3, 1, 3, 5, 250000, 39),
--
(4, 2, 1, 2, 250000, 36),(4, 2, 1, 1, 250000, 24),(4, 2, 1, 3, 250000, 20),
(4, 2, 1, 4, 250000, 14),(4, 2, 1, 5, 250000, 39),
(4, 2, 2, 2, 250000, 36),(4, 2, 2, 1, 250000, 24),(4, 2, 2, 3, 250000, 20),
(4, 2, 2, 4, 250000, 14),(4, 2, 2, 5, 250000, 39),
(4, 2, 3, 2, 250000, 36),(4, 2, 3, 1, 250000, 24),(4, 2, 3, 3, 250000, 20),
(4, 2, 3, 4, 250000, 14),(4, 2, 3, 5, 250000, 39),
--
(5, 1, 1, 2, 250000, 36),(5, 1, 1, 1, 250000, 24),(5, 1, 1, 3, 250000, 20),
(5, 1, 1, 4, 250000, 14),(5, 1, 1, 5, 250000, 39),
(5, 1, 2, 2, 250000, 36),(5, 1, 2, 1, 250000, 24),(5, 1, 2, 3, 250000, 20),
(5, 1, 2, 4, 250000, 14),(5, 1, 2, 5, 250000, 39),
(5, 1, 3, 2, 250000, 36),(5, 1, 3, 1, 250000, 24),(5, 1, 3, 3, 250000, 20),
(5, 1, 3, 4, 250000, 14),(5, 1, 3, 5, 250000, 39)

Insert into HoaDon(MaHoaDon, NgayTao, IdKhachHang, TrangThai)VALUES
('HD001', GETDATE(), 1, 'Đang chờ');

INSERT INTO PhieuGiamGia (MaPhieuGiamGia, NgayBatDau, NgayKetThuc, SoLuong, GiaTriGiamGia, TrangThai)
VALUES ('PGG10K', '2024-03-29', '2024-05-29', 50, 10000, N'Đang Áp Dụng');

INSERT INTO PhieuGiamGia (MaPhieuGiamGia, NgayBatDau, NgayKetThuc, SoLuong, GiaTriGiamGia, TrangThai)
VALUES ('PGG15K', '2024-03-29', '2024-05-29', 40, 15000, N'Đang Hoạt Động');

INSERT INTO PhieuGiamGia (MaPhieuGiamGia, NgayBatDau, NgayKetThuc, SoLuong, GiaTriGiamGia, TrangThai)
VALUES ('PGG20K', '2024-03-29', '2024-05-29', 30, 20000, N'Đang Hoạt Động');

INSERT INTO PhieuGiamGia (MaPhieuGiamGia, NgayBatDau, NgayKetThuc, SoLuong, GiaTriGiamGia, TrangThai)
VALUES ('PGG25K', '2024-03-29', '2024-05-29', 20, 25000, N'Đang Áp Dụng');

Select * from PhieuGiamGia
--SELECT * FROM PhieuGiamGia WHERE IdPhieuGiamGia = 'E25AA509-0F65-4EAE-B937-6ED884AC5615'

--SELECT IdPhieuGiamGia FROM ApMaGiamGia WHERE IdHoaDon = 


Select * from HoaDon

Select * from HoaDonChiTiet


Select *from SanPhamChiTiet

SELECT SP.TenSanPham AS 'Tên Sản phẩm',
       SPC.Gia AS 'Giá',
       TH.TenThuongHieu AS 'Thương hiệu',
       MS.TenMauSac AS 'Màu sắc',
       S.Size AS 'Size',
       CL.TenChatLieu AS 'Chất liệu',
       TL.TenTheLoai AS 'Thể loại',
       SPC.SoLuong AS 'Số lượng'
FROM SanPham SP
JOIN SanPhamChiTiet SPC ON SP.IdSanPham = SPC.IdSanPham
JOIN ThuongHieu TH ON SP.IdThuongHieu = TH.IdThuongHieu
JOIN MauSac MS ON SPC.IdMauSac = MS.IdMauSac
JOIN Size S ON SPC.IdSize = S.IdSize
JOIN ChatLieu CL ON SPC.IdChatLieu = CL.IdChatLieu
JOIN TheLoai TL ON SP.IdTheLoai = TL.IdTheLoai;


SELECT NhanVien.MaNhanVien, NhanVien.MatKhau, ChucVu.TenChucVu
FROM NhanVien
JOIN ChucVu ON NhanVien.IdChucVu = ChucVu.IdChucVu;

Select * from HoaDonChiTiet where IdSanPhamChiTiet like '108A7637-B594-4F3F-BEF2-1A86800D08AA'
SELECT COUNT(*) FROM SanPham;
SELECT 
    HoaDon.IdHoaDon,
    HoaDon.MaHoaDon,
    HoaDon.NgayTao,
    HoaDon.GhiChu,
    HoaDon.IdNhanVien,
    HoaDon.IdKhachHang,
    HoaDon.TongTien,
    HoaDon.TrangThai
FROM HoaDon
JOIN HoaDonChiTiet ON HoaDon.IdHoaDon = HoaDonChiTiet.IdHoaDon
WHERE HoaDonChiTiet.IdSanPhamChitiet = '108A7637-B594-4F3F-BEF2-1A86800D08AA'

SELECT *
FROM HoaDon
WHERE TrangThai = N'Đã thanh toán' 
    AND NgayTao BETWEEN '2024-01-01' AND '2024-01-30'
    AND IdNhanVien like null
ORDER BY NgayTao DESC;

SELECT HDT.IdHoaDonChiTiet, SP.TenSanPham, SZ.Size, MS.TenMauSac, HDT.SoLuong, SPC.Gia, HDT.ThanhTien, SPC.IdSanPhamChiTiet,  CL.TenChatLieu
FROM HoaDonChiTiet HDT
INNER JOIN SanPhamChiTiet SPC ON HDT.IdSanPhamChiTiet = SPC.IdSanPhamChiTiet
INNER JOIN SanPham SP ON SPC.IdSanPham = SP.IdSanPham
INNER JOIN Size SZ ON SPC.IdSize = SZ.IdSize
INNER JOIN MauSac MS ON SPC.IdMauSac = MS.IdMauSac
INNER JOIN HoaDon HD ON HDT.IdHoaDon = HD.IdHoaDon
INNER JOIN ChatLieu CL ON SPC.IdChatLieu = CL.IdChatLieu
WHERE HD.IdHoaDon = 'D94648F1-194C-4F2A-89EE-2BE00C25C0A5'

	Delete HoaDon where IdHoaDon = '903C52CB-6DE3-4181-9887-09E817B89A0E'

	SELECT N.*, CV.TenChucVu
FROM NhanVien N
LEFT JOIN ChucVu CV ON N.IdChucVu = CV.IdChucVu
ORDER BY N.IdNhanVien
OFFSET 3 ROWS FETCH NEXT 1 ROWS ONLY
;


SELECT S.IdSanPhamChiTiet, SanPham.TenSanPham , Size.Size, MauSac.TenMauSac, ChatLieu.TenChatLieu, S.SoLuong, S.Gia
FROM SanPhamChiTiet S
JOIN Size ON S.IdSize = Size.IdSize
JOIN MauSac ON S.IdMauSac = MauSac.IdMauSac
JOIN ChatLieu ON S.IdChatLieu = ChatLieu.IdChatLieu
JOIN SanPham ON S.IdSanPham = SanPham.IdSanPham

SELECT 
    HD.IdHoaDon, 
    HD.MaHoaDon , 
    HD.NgayTao , 
    HD.TrangThai, 
    HD.TongTien , 
    NV.TenNhanVien, 
    KH.TenKhachHang,
	HD.TrangThai
FROM 
    HoaDon HD
INNER JOIN 
    NhanVien NV ON HD.IdNhanVien = NV.IdNhanVien
LEFT JOIN 
    KhachHang KH ON HD.IdKhachHang = KH.IdKhachHang

WHERE NgayTao BETWEEN ? AND ? AND IdNhanVien=?

select * from NhanVien

SELECT *
FROM SanPham
WHERE CONCAT(MaSanPham, ' ', TenSanPham, ' ', IdTheLoai, ' ', IdThuongHieu, ' ', TrangThai) LIKE N'%Hoạt động%';

SELECT S.IdSanPhamChiTiet, SanPham.TenSanPham, Size.Size, MauSac.TenMauSac, ChatLieu.TenChatLieu, S.SoLuong, S.Gia, SanPham.TrangThai
FROM SanPhamChiTiet S
JOIN Size ON S.IdSize = Size.IdSize
JOIN MauSac ON S.IdMauSac = MauSac.IdMauSac
JOIN ChatLieu ON S.IdChatLieu = ChatLieu.IdChatLieu
JOIN SanPham ON S.IdSanPham = SanPham.IdSanPham
WHERE CONCAT(SanPham.TenSanPham, ' ', MauSac.TenMauSac, ' ', ChatLieu.TenChatLieu) Like N'%%' AND SanPham.TrangThai like N'Hoạt động';


SELECT sp.idSanPham, sp.maSanPham, sp.tenSanPham, tl.tenTheLoai, th.tenThuongHieu, sp.trangThai FROM SanPham sp
JOIN TheLoai tl ON sp.idTheLoai = tl.idTheLoai
JOIN ThuongHieu th ON sp.idThuongHieu = th.idThuongHieu
SELECT spct.IdSanPhamChiTiet, sp.TenSanPham, mau.TenMauSac, size.Size, cl.TenChatLieu, Gia, SoLuong FROM SanPhamChiTiet spct
JOIN SanPham sp ON spct.IdSanPham = sp.IdSanPham
JOIN MauSac mau ON spct.IdMauSac = mau.IdMauSac
JOIN ChatLieu cl ON spct.IdChatLieu = cl.IdChatLieu
JOIN Size size ON spct.IdSize = size.IdSize

SELECT * FROM HoaDon WHERE TrangThai='Đang chờ'