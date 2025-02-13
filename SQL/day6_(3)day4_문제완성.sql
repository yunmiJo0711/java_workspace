/*
 *	day4_문제.pdf 파일의 3)번부터 
 */

CREATE TABLE tbl_postcode(
	POSTCODE CHAR(5) PRIMARY key,
	AREA1 VARCHAR2(200) NOT NULL
);

ALTER TABLE TBL_CUSTOMER ADD postcode char(5);


ALTER TABLE TBL_CUSTOMER 
	ADD CONSTRAINT tbl_customer_fk 
	foreign key(postcode)
	REFERENCES tbl_postcode(postcode);






