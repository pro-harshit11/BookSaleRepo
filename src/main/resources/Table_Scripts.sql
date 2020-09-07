DROP TABLE IF EXISTS Customer CASCADE CONSTRAINTS;
DROP TABLE IF EXISTS Book CASCADE CONSTRAINTS;
DROP SEQUENCE hibernate_sequence;
CREATE SEQUENCE hibernate_sequence start with 2005 increment by  1;
CREATE TABLE Customer (
    customer_id bigint NOT NULL,
    contact_no bigint NOT NULL,
    name varchar(20) NOT NULL,
    college_name varchar(40) NOT NULL,
    password varchar(40) NOT NULL,
    CONSTRAINT pk_customer PRIMARY KEY (customer_id)
);
CREATE TABLE Book (
    book_id bigint NOT NULL,
    name varchar(20) NOT NULL,
    book_year TIMESTAMP(0) NOT NULL,
    customer_id  bigint,
    price bigint NOT NULL,
    branch varchar(20) NOT NULL,
    semester varchar(20) NOT NULL,
    CONSTRAINT pk_book PRIMARY KEY (book_id),
    CONSTRAINT fk_cust_book FOREIGN KEY (customer_id) REFERENCES Customer
);
INSERT INTO Customer VALUES (1001,9876543210, 'Tom', 'ABC University','tom@123');
INSERT INTO Book VALUES (2001,'Mathematics','24-MAR-2006',1001,500,'COMPUTER_SCIENCE','SEMESTER2');
INSERT INTO Book VALUES (2002,'Software Engineering','24-MAR-2006',1001,600,'COMPUTER_SCIENCE','SEMESTER3');
INSERT INTO Book VALUES (2003,'Engineering Drawing','24-MAR-2006',1001,400,'COMPUTER_SCIENCE','SEMESTER4');
INSERT INTO Book VALUES (2004,'Data Structure','24-MAR-2006',1001,700,'COMPUTER_SCIENCE','SEMESTER2');

select * from Customer;

select * from Book;

