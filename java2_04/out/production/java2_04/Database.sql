create database ebookshop;
use ebookshop;
drop table if exists books;
create table books (
    id int,
    title varchar(50),
    author varchar(50),
    price float,
    qty int,
    primary key (id)
);
insert into books values (1001, 'java for dummies', 'dang thi kim', 11.11, 11);
insert into books values (1002, 'more java for dummies', 'codelean vn', 22.22, 22);
insert into books values (1003, 'more java for more dummies', 'mohammand ali', 33.33, 33);
insert into books values (1004, 'a cup of java', 'kumar', 44.44, 44);
insert into books values (1005, 'a teaspoon of java', 'kevin jones', 55.55, 55);

select * from books;
select title , price from books where author = 'codelean vn';
select title, author, price, qty from books where author = 'codelean vn' or price >=30
order by price desc,id asc;