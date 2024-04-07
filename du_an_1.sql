
Create Database Duan_1
GO

USE Duan_1
GO
CREATE TABLE ChucVu (
IdChucVu int  identity(1,1) primary key,
MaChucVu varchar(10),
TenChucVu Nvarchar(20),
)


CREATE TABLE NguoiDung (
IdNguoiDung int  identity(1,1) primary key,
MaNguoiDung varchar (20),
TenNhanVien Nvarchar(30),
Sdt varchar (15),
DiaChi Nvarchar(50),
NgaySinh date,
GioiTinh Nvarchar(10),
MatKhau varchar(100),
tenChucvu Nvarchar(20),
TrangThai Nvarchar(50)
)
drop table NguoiDung

Select * from NguoiDung
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

select MaNguoiDung, TenNhanVien, Sdt, DiaChi, GioiTinh, NgaySinh, TenChucVu, TrangThai, IdNguoiDung, MatKhau from NguoiDung