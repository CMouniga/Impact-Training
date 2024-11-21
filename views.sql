create database employee;
use employee;
drop table employee_table;
create table employee_table (
EMP_ID INT PRIMARY KEY, EMP_NAME VARCHAR(20),EMP_SALARY DECIMAL(10,2),EMP_DOJ DATE,EMP_BRANCH VARCHAR(20));
insert into employee_table values
(1,'Abinaya',15000,'2024-11-01','chennai'),
(2,'Kowsalya',25000,'2024-12-02','chennai'),
(3,'Kavitha',25000,'2024-10-03','salem');
 
create view employees_table as 
select * from employee_table where EMP_BRANCH='chennai';
drop view employees_table;
 
create view SeniorEmployee as
select EMP_ID,EMP_NAME from employee_table where min(EMP_DOJ);


 create table products(
 PRODUCT_ID INT PRIMARY KEY, PRODUCT_NAME VARCHAR(20),PRODUCT_PRICE DECIMAL(10,2),EXPIRY_DATE DATE);
 