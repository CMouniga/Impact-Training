create database Products;
use Products;
create table products_table(product_id int primary key,product_name varchar(20),product_price decimal(10,2));
select * from products_table;
insert into products_table values 
(1,'Book',300.00),
(2,'Pen',200.00),
(3,'Pencil',150.00),
(4,'chalk',40.00);
create table employee_table(
emp_id int primary key,
emp_name varchar(30),
emp_salary decimal(10,2)
);
select * from employee_table;

insert into employee_table values
(1,'Abinaya',15000),
(2,'Kowsalya',25000),
(3,'Kavitha',25000);

drop table products_table;
drop table employee_table;

DELIMITER $$
CREATE PROCEDURE GetProductDetails (IN product_id INT)
BEGIN
	SELECT * FROM products_table WHERE product_id = product_id;
END $$
DELIMITER ;
call GetProductDetails(3);

drop procedure GetProductDetails;

DELIMITER $$
CREATE FUNCTION employeedetails(employee_salary INT) RETURNS VARCHAR(200)
DETERMINISTIC
BEGIN
DECLARE emp2_details varchar(2000);
SELECT CONCAT(emp_id,';',emp_name,';',emp_salary,';') INTO emp2_details FROM employee_table WHERE emp_salary > employee_salary LIMIT 1;
RETURN emp2_details;
END $$
DELIMITER ;
drop function employeedetails;

DELIMITER $$
CREATE PROCEDURE tableStructure(IN employee_table VARCHAR(255))
BEGIN 
	SELECT * from employee_table;
END $$
DELIMITER ;
DROP PROCEDURE tableStructure;
call tableStructure;



DELIMITER $$
CREATE TRIGGER employee_row_count_trigger
AFTER INSERT ON employee_table
FOR EACH ROW 
BEGIN 
INSERT INTO row_count_log(table_name,row_count)
values('employee_table',(select count(*) from employee_table));
END $$
DELIMITER ;

create view employee_view as 
select emp_id,emp_name,emp_salary
from
employee_table;
