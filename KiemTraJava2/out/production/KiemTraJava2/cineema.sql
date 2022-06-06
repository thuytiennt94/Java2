create database Cinema;
use Cinema;
create table tblcinema(
    MaPhim varchar(50) primary key,
    Tenphim nvarchar(50),
    GioChieu date,
    daodien nvarchar(50),
    time int
);
insert into tblcinema values ('M002', 'Spider-Man:Into the Spider-Verse 2','2022/6/2' ,'Joaquim Dos Santos',115);
insert into tblcinema values ('M001', 'doraemon', '2022/5/27', 'Yamaguchi susumu',108);

select * from tblcinema;

