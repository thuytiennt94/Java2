create database DiemThiTHPTQG;
use DiemThiTHPTQG;
drop table if exists Diem;
create table Diem(
    id int primary key unique ,
    name nvarchar(50),
    SBD varchar(50),
    monToan float,
    monVan float,
    monAnh float,
    monTohop nvarchar(50),
    diemTohop float
);
insert into Diem values (1, N'hoang', 'SBD2121', 8.6,7.5,7,N'Sử - Địa - GDCD', 8);
insert into Diem values (2, N'Mai', 'SBD2122', 9,8.5,9.2,N'Sử - Địa - GDCD', 7.5);
insert into Diem values (3, N'Vũ', 'SBD2123', 7.6,9,8.2,N'Lý - Hoá - Sinh', 8.4);
insert into Diem values (4, N'Quỳnh', 'SBD2124', 8.8,6,8,N'Lý - Hoá - Sinh', 9);

create table tblSV(
    id int primary key auto_increment,
    name nvarchar(50),
    School nvarchar(50),
    title nvarchar(50)
);
insert into tblSV values (1,N'hoàng', N'thpt AAA','Đỗ');
--
//insert tblSV
            String sqlInsert1 = "insert into tblSV values (1, 'hoang', 'thpt ...','ĐỖ)";
            System.out.println(sqlInsert1);
//            int countInsert = stmt.executeUpdate(sqlInsert1);
//            System.out.println(countInsert);

            //delete
//            String sqlDelete = "delete from Diem where SBD = 'SBD2123'";
//            System.out.println(sqlDelete);
//            int countDelete = stmt.executeUpdate(sqlDelete);
//            System.out.println("delete sbd: " + countDelete + "\n");