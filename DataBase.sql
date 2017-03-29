drop database if exists bank;
create database if not exists bank ;
use bank;


create table CLIENT
(id int unique auto_increment primary key,
 name char(50),
 id_card_number char(6),
 pers_num_code char(13),
 address char (50));
 
 create table ACCOUNT
 (id int unique auto_increment primary key,
  id_client int,
  type char(50),
  amount float,
  creation_date date,
  foreign key (id_client) references CLIENT(id));
  
create table EMPLOYEE
(id int unique auto_increment primary key,
 name char(50),
 username varchar(50),
 password varchar(50));
 
create table ACTIVITY
(id int unique auto_increment primary key,
 id_employee int,
 description char(100),
 date date,
 foreign key (id_employee) references EMPLOYEE(id));
 
 create table ADMIN
 (id int unique auto_increment primary key,
  username varchar(50),
  password varchar(50));
 
insert into CLIENT (name, id_card_number, pers_num_code, address) values
('Matei Cristina','016080','2941208125774','Cluj-Napoca, Fantanele 63-65'),
('Lazar Raluca','123456','2950228127345','Jibou, Trandafirilor 22'),
('Sechel Raluca','236345','2950715127854','Jibou, Uzinei 13'),
('Dregan Anda','427456','2950614127835','Jibou, Bailor 11'),
('Puia Andreea','571233','2950721125634','Cluj-Napoca, Fantanele 24'),
('Balas Madalina','965234','2950618125783','Gilau, Florilor 4');

insert into ACCOUNT (id_client, type, amount, creation_date) values
(1,'Spending Account',200.0,'2010-01-12'),
(2,'Saving Account',1200.0,'2017-02-02'),
(3,'Spending Account',100.0,'2016-10-12'),
(3,'Saving Account',260.0,'2017-03-12'),
(4,'Saving Account',3480.0,'2015-04-06'),
(5,'Saving Account',2340.0,'2014-11-09'),
(6,'Spending Account',300.0,'2009-10-10'),
(6,'Saving Account',200.0,'2016-02-08');

insert into EMPLOYEE (name, username, password) values
('Radu Paul','radu_paul','1234'),
('Gliga Paula','gliga_paula','0000'),
('Damsa Madalina','damsa_madalina','1995');

insert into ACTIVITY(id_employee, description, date) values
(1,'Transfer 50.0 from account 1 to account 2','2017-03-03'),
(1,'Process bill of 70.0 from account 3','2017-01-12'),
(2,'Edit address from client Matei Cristina','2016-12-12'),
(3,'Transfer 100.0 from account 5 to account 6','2017-02-02');

insert into ADMIN(username, password) values
('admin1','1234'),
('admin2','0000');



 