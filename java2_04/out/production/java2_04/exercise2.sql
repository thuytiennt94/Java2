/*1.Hiển thị danh sách khách hàng*/
select * from customer.customers;
/*2. Tìm khaách hàng theo tên*/
select * from customer.customers where ContactName like "%Aria Cruz%";
/*3.Hiển thị danh sach sản phẩm */
select * from customer.products;
/*4.Tìm sản phẩm theo giá bán trong khoảng do người dùng nhập vào*/
select ProductName from customer.products where UnitPrice = 24.0000;
/*5.Hiển thị thông tin chi tiết của một đơn hàng*/
select * from customer.orders inner join customer.products where ProductName = 'Mishi Kobe Niku';