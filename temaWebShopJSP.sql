create database temaWebShopJSP;
create table product(
id int primary key auto_increment,
name_product varchar(100),
description_product varchar(255),
stock int,
price double
);
insert into product values(null, 'Xiaomi', 'Redmi Note11' ,10, 900.0);
insert into product values(null, 'Samsung', 'A90' ,3, 1500.0);
insert into product values(null, 'Nokia', 'C3300', 45, 350.0);
select*from product;
select*from product where id=8;
select id from product order by id desc limit 1;

create table sales(
id int primary key auto_increment,
id_client int,
id_produs int,
quantity int
);
select*from sales;


create table buyers(
id int primary key auto_increment,
name_client varchar(100),
address varchar(255)
);
insert into buyers values(null, 'Ion', 'Chisinau, Strada cu flori nr.4');
select*from buyers;
select id from buyers order by id desc limit 1;