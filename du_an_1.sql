
Create Database du_an_1
GO

USE du_an_1
GO
CREATE TABLE ChucVu (
IdChucVu int  identity(1,1) primary key,
MaChucVu varchar(10),
TenChucVu Nvarchar(20),
)


CREATE TABLE NguoiDung (
IdNguoiDung int  identity(1,1) primary key,
MaNguoiDung varchar(10),
TenNhanVien Nvarchar(30),
Sdt varchar (15),
DiaChi Nvarchar(50),
NgaySinh date,
GioiTinh Nvarchar(10),
MatKhau varchar(100),
IdChucVu int,
TrangThai Nvarchar(50)
)

CREATE TABLE ThuongHieu(
IdThuongHieu int  identity(1,1) primary key,
MaThuongHieu Nvarchar(50),
TenThuongHieu Nvarchar(50)
)

CREATE TABLE TheLoai(
IdTheLoai int  identity(1,1) primary key,
MaTheLoai Nvarchar(50),
TenTheLoai Nvarchar(50)
)

CREATE TABLE Size(
IdSize int  identity(1,1) primary key,
MaSize varchar(10),
Size int
)

CREATE TABLE MauSac(
IdMauSac int  identity(1,1) primary key,
MaMauSac Nvarchar(20),
TenMauSac Nvarchar(20)
)

CREATE TABLE ChatLieu(
IdChatLieu int  identity(1,1) primary key,
MaChatLieu Nvarchar(20),
TenChatLieu Nvarchar(20)
)

CREATE TABLE KhachHang(
IdKhachHang int  identity(1,1) primary key,
MaKhachHang varchar(50),
TenKhachHang Nvarchar(50),
Sdt varchar(15),
DiaChi Nvarchar(50),
GioiTinh Nvarchar(10),
NgaySinh date
)

CREATE TABLE SanPham(
IdSanPham int  identity(1,1) primary key,
MaSanPham varchar(50),
TenSanPham Nvarchar(50),
IdTheLoai int,
IdThuongHieu int,
TrangThai Nvarchar(50)
)

CREATE TABLE LichSuGia(
IdLSGia int identity(1,1) primary key,
MaLSGia varchar(50),
GiaBanDau decimal(18, 0),
GiaBanRa decimal(18, 0),
NgayBatDau date,
NgayKetThuc date
)

CREATE TABLE SanPhamChiTiet(
IdSanPhamChiTiet int  identity(1,1) primary key,
IdSanPham int,
IdChatLieu int,
IdMauSac int,
IdSize int,
Gia decimal(18, 0),
SoLuong int,
IdLSGia int
)

CREATE TABLE HoaDon(
IdHoaDon int  identity(1,1) primary key,
MaHoaDon varchar(50),
NgayTao date,
GhiChu Nvarchar(50),
IdNguoiDung int,
IdKhachHang int,
TongTien decimal(18, 0),
TrangThai Nvarchar(50),
IdPhieuGiamGia int
)

CREATE TABLE HoaDonChiTiet(
IdHoaDonChiTiet int  identity(1,1) primary key,
IdHoaDon int,
IdSanPhamChitiet int,
DonGia decimal(18, 0), 
SoLuong int,
ThanhTien decimal(18, 0),
TrangThai Nvarchar(50)
)

CREATE TABLE PhieuGiamGia(
IdPhieuGiamGia int  identity(1,1) primary key,
MaPhieuGiamGia varchar(50),
NgayBatDau date,
NgayKetThuc date,
SoLuong int,
GiaTriGiamGia decimal(18, 0),
TrangThai Nvarchar(50)
)


-- Constrain
ALTER TABLE NguoiDung
ADD CONSTRAINT FK_NguoiDung_ChucVu
FOREIGN KEY (IdChucVu) REFERENCES ChucVu(IdChucVu);

ALTER TABLE SanPham
ADD CONSTRAINT FK_SanPham_ThuongHieu
FOREIGN KEY (IdThuongHieu) REFERENCES ThuongHieu(IdThuongHieu)

ALTER TABLE SanPham
ADD CONSTRAINT FK_SanPham_TheLoai
FOREIGN KEY (IdTheLoai) REFERENCES TheLoai(IdTheLoai)

-- Thêm khoá phụ cho cột IdSanPham
ALTER TABLE SanPhamChiTiet
ADD CONSTRAINT FK_SanPhamChiTiet_IdSanPham
FOREIGN KEY (IdSanPham)
REFERENCES SanPham(IdSanPham);

ALTER TABLE SanPhamChiTiet
ADD CONSTRAINT FK_SanPhamChiTiet_IdLSGia
FOREIGN KEY (IdLSGia)
REFERENCES LichSuGia(IdLSGia);

-- Thêm khoá phụ cho cột IdChatLieu
ALTER TABLE SanPhamChiTiet
ADD CONSTRAINT FK_SanPhamChiTiet_IdChatLieu
FOREIGN KEY (IdChatLieu)
REFERENCES ChatLieu(IdChatLieu);

-- Thêm khoá phụ cho cột IdMauSac
ALTER TABLE SanPhamChiTiet
ADD CONSTRAINT FK_SanPhamChiTiet_IdMauSac
FOREIGN KEY (IdMauSac)
REFERENCES MauSac(IdMauSac);

-- Thêm khoá phụ cho cột IdSize
ALTER TABLE SanPhamChiTiet
ADD CONSTRAINT FK_SanPhamChiTiet_IdSize
FOREIGN KEY (IdSize)
REFERENCES Size(IdSize);

-- Thêm khoá phụ cho cột IdNhanVien
ALTER TABLE HoaDon
ADD CONSTRAINT FK_HoaDon_IdNguoiDung
FOREIGN KEY (IdNguoiDung)
REFERENCES NguoiDung(IdNguoiDung);

-- Thêm khoá phụ cho cột IdKhachHang
ALTER TABLE HoaDon
ADD CONSTRAINT FK_HoaDon_IdKhachHang
FOREIGN KEY (IdKhachHang)
REFERENCES KhachHang(IdKhachHang);

-- Thêm khoá phụ cho cột IdHoaDon
ALTER TABLE HoaDonChiTiet
ADD CONSTRAINT FK_HoaDonChiTiet_IdHoaDon
FOREIGN KEY (IdHoaDon)
REFERENCES HoaDon(IdHoaDon);

-- Thêm khoá phụ cho cột IdSanPhamChiTiet
ALTER TABLE HoaDonChiTiet
ADD CONSTRAINT FK_HoaDonChiTiet_IdSanPhamChiTiet
FOREIGN KEY (IdSanPhamChiTiet)
REFERENCES SanPhamChiTiet(IdSanPhamChiTiet);

ALTER TABLE HoaDon
ADD CONSTRAINT FK_HoaDon_IdPhieuGiamGia
FOREIGN KEY (IdPhieuGiamGia)
REFERENCES PhieuGiamGia;




--INSERT 
Insert into ChucVu(MaChucVu, TenChucVu) VALUES
('QL', N'Quản Lý'),
('NV', N'Nhân viên')

Select IdChucVu,MaChucVu, TenChucVu From ChucVu

INSERT INTO KhachHang (MaKhachHang, TenKhachHang, Sdt, DiaChi, GioiTinh, NgaySinh) VALUES ('KH001', 'Nguyen Van A', '0123456789', '123 Street, City A', 'Nam', '1990-01-01');
INSERT INTO KhachHang (MaKhachHang, TenKhachHang, Sdt, DiaChi, GioiTinh, NgaySinh) VALUES ('KH002', 'Tran Thi B', '0987654321', '456 Street, City B', 'Nữ', '1985-05-15');
INSERT INTO KhachHang (MaKhachHang, TenKhachHang, Sdt, DiaChi, GioiTinh, NgaySinh) VALUES ('KH003', 'Le Van C', '0345678901', '789 Street, City C', 'Nam', '1992-08-20');
INSERT INTO KhachHang (MaKhachHang, TenKhachHang, Sdt, DiaChi, GioiTinh, NgaySinh) VALUES ('KH004', 'Pham Thi D', '0765432109', '987 Street, City D', 'Nữ', '1988-03-10');
INSERT INTO KhachHang (MaKhachHang, TenKhachHang, Sdt, DiaChi, GioiTinh, NgaySinh) VALUES ('KH005', 'Hoang Van E', '0234567890', '654 Street, City E', 'Nam', '1995-12-25');
INSERT INTO KhachHang (MaKhachHang, TenKhachHang, Sdt, DiaChi, GioiTinh, NgaySinh) VALUES ('KH006', 'Trinh Thi F', '0456789012', '321 Street, City F', 'Nữ', '1987-06-30');
INSERT INTO KhachHang (MaKhachHang, TenKhachHang, Sdt, DiaChi, GioiTinh, NgaySinh) VALUES ('KH007', 'Do Van G', '0567890123', '987 Street, City G', 'Nam', '1994-09-15');
INSERT INTO KhachHang (MaKhachHang, TenKhachHang, Sdt, DiaChi, GioiTinh, NgaySinh) VALUES ('KH008', 'Luong Thi H', '0678901234', '654 Street, City H', 'Nữ', '1989-04-05');
INSERT INTO KhachHang (MaKhachHang, TenKhachHang, Sdt, DiaChi, GioiTinh, NgaySinh) VALUES ('KH009', 'Tran Van I', '0789012345', '321 Street, City I', 'Nam', '1991-07-17');
INSERT INTO KhachHang (MaKhachHang, TenKhachHang, Sdt, DiaChi, GioiTinh, NgaySinh) VALUES ('KH010', 'Le Thi K', '0890123456', '789 Street, City K', 'Nữ', '1986-02-28');
INSERT INTO KhachHang (MaKhachHang, TenKhachHang, Sdt, DiaChi, GioiTinh, NgaySinh) VALUES ('KH011', 'Nguyen Van L', '0901234567', '123 Street, City L', 'Nam', '1993-10-08');
INSERT INTO KhachHang (MaKhachHang, TenKhachHang, Sdt, DiaChi, GioiTinh, NgaySinh) VALUES ('KH012', 'Ho Thi M', '0912345678', '456 Street, City M', 'Nữ', '1984-11-22');
INSERT INTO KhachHang (MaKhachHang, TenKhachHang, Sdt, DiaChi, GioiTinh, NgaySinh) VALUES ('KH013', 'Do Van N', '0923456789', '789 Street, City N', 'Nam', '1996-04-03');
INSERT INTO KhachHang (MaKhachHang, TenKhachHang, Sdt, DiaChi, GioiTinh, NgaySinh) VALUES ('KH014', 'Le Van P', '0934567890', '987 Street, City P', 'Nữ', '1983-09-12');
INSERT INTO KhachHang (MaKhachHang, TenKhachHang, Sdt, DiaChi, GioiTinh, NgaySinh) VALUES ('KH015', 'Tran Thi Q', '0945678901', '654 Street, City Q', 'Nam', '1997-01-26');
INSERT INTO KhachHang (MaKhachHang, TenKhachHang, Sdt, DiaChi, GioiTinh, NgaySinh) VALUES ('KH016', 'Pham Van R', '0956789012', '321 Street, City R', 'Nữ', '1997-01-26');


Select * from KhachHang

Insert into NhanVien(MaNhanVien,TenNhanVien,  Sdt, DiaChi, NgaySinh, GioiTinh, MatKhau, IdChucVu) VALUES
('NV001', N'Thằng Nhân Viên', '0559577371', 'Hoàng Ngân', '2003-1-17', 'Nam', '321', 2),
('QL001', N'Thằng Quản Lý', '0826263688', 'Trần Duy Hưng', '2003-1-17', 'Nam', '123', 1),
('NV002', N'Bùi Huy', '0826263680', 'Xa la', '2003-1-17', 'Nam', '17012003', 2)


Insert into ThuongHieu (TenThuongHieu)VALUES
('Adidas'),
('Nike'),
('Puma'),
('Boo'),
('Hades')

Insert into TheLoai(TenTheLoai)VALUES
(N'Dép cao su'),
(N'Dép quai hậu'),
(N'Dép tông lào')

Insert into MauSac(TenMauSac)VALUES
(N'Xanh'),
(N'Đỏ'),
(N'Vàng'),
(N'Nâu'),
(N'Đen')


Insert into Size(Size)VALUES
(37),(38),(39),(40),(41),(42)

Insert into ChatLieu(TenChatLieu)Values
(N'Cao su'),
(N'Da lộn'),
(N'Hạt nhựa'),
(N'Xốp')

Select * from TheLoai
Select * from ThuongHieu

Insert into SanPham(MaSanPham, TenSanPham, IdTheLoai, IdThuongHieu)VALUES
('SP001', 'Dép cao su Nike', 1, 2),
('SP002', 'Dép tông lào Adidas', 3, 1),
('SP003', 'Dép tông lào Puma', 3, 3),
('SP004', 'Dép quai hậu Hades', 2, 5),
('SP005', 'Dép quai hậu Boo', 2, 4)

Select * from SanPham
Select * from ChatLieu
Select * from MauSac
select * from Size
Select * from ThuongHieu
Select * from NhanVien

Select * from KhachHang
Insert into SanPhamChiTiet(IdSanPham, IdChatLieu, IdMauSac, IdSize, Gia, SoLuong)VALUES
(5, 3, 2, 6, 2000000, 17),
(3, 1, 5, 2, 3900000, 11)

Insert into HoaDon(NgayTao, IdKhachHang)VALUES
('2023-1-15', 'Vãng lai')

INSERT INTO PhieuGiamGia (IdPhieuGiamGia, MaPhieuGiamGia, NgayBatDau, NgayKetThuc, SoLuong, GiaTriGiamGia, TrangThai)
VALUES (NEWID(), 'PGG20240219', '2024-02-19', '2024-03-19', 10, 50000, N'Đang Áp Dụng');

INSERT INTO PhieuGiamGia (IdPhieuGiamGia, MaPhieuGiamGia, NgayBatDau, NgayKetThuc, SoLuong, GiaTriGiamGia, TrangThai)
VALUES (NEWID(), 'SUMMER2024', '2024-02-19', '2024-03-19', 10, 100000, N'Đang hoạt động');

INSERT INTO PhieuGiamGia (IdPhieuGiamGia, MaPhieuGiamGia, NgayBatDau, NgayKetThuc, SoLuong, GiaTriGiamGia, TrangThai)
VALUES (NEWID(), 'SUMMER2023', '2023-02-19', '2023-03-19', 10, 100000, N'Đang hoạt động');

INSERT INTO PhieuGiamGia (IdPhieuGiamGia, MaPhieuGiamGia, NgayBatDau, NgayKetThuc, SoLuong, GiaTriGiamGia, TrangThai)
VALUES (NEWID(), 'SPRING24', '2024-02-19', '2024-03-19', 10, 66666, N'Đang hoạt động');

Select * from PhieuGiamGia
SELECT * FROM PhieuGiamGia WHERE IdPhieuGiamGia = 'E25AA509-0F65-4EAE-B937-6ED884AC5615'

SELECT IdPhieuGiamGia FROM ApMaGiamGia WHERE IdHoaDon = '6A94C991-82CB-49D9-968E-22DD0C92E4A1'


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


