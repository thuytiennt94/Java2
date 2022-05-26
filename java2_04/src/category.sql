create database if not exists category;
use category;
create table tblcategory(
    genre int(11),
    nameCate varchar(50),
    primary key(genre),
)
insert into tblcategory values (1, 'Fiction');
insert into tblcategory values (2, 'Science');
insert into tblcategory values (3, 'Literature');

select * from tblcategory;