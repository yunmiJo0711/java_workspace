CREATE TABLE AUTHOR (
	AUTHOR_ID number(8) PRIMARY KEY,  -- 저자 ID
	AUTHOR_NAME varchar2(100) NOT NULL  -- 저자명 
);

CREATE TABLE BOOK(
	BOOK_ID number(8) PRIMARY KEY,   -- 도서 ID
	CATEGORY varchar2(100) NOT NULL, -- 카테고리
	AUTHOR_ID number(8) NOT NULL, -- 저자 ID
	PRICE number(8) NOT NULL,  -- 판매가(원)
	PUBLISHED_DATE DATE NOT NULL, -- 출판일
	FOREIGN KEY (AUTHOR_ID)
	REFERENCES  AUTHOR(AUTHOR_ID)
);

-- 데이터 추가 : AUTHOR 먼저 INSERT -> book 
INSERT INTO AUTHOR (AUTHOR_ID,AUTHOR_NAME)
values(1,'홍길동');
INSERT INTO AUTHOR (AUTHOR_ID,AUTHOR_NAME)
values(2,'김영호');

CREATE SEQUENCE BOOK_ID_SEQ;

INSERT INTO BOOK (BOOK_ID,CATEGORY,AUTHOR_ID,PRICE,PUBLISHED_DATE)
VALUES (book_id_seq.nextval,'인문',1,10000,'2020-01-01');
INSERT INTO BOOK (BOOK_ID,CATEGORY,AUTHOR_ID,PRICE,PUBLISHED_DATE)
VALUES (book_id_seq.nextval,'경제',1,9000,'2021-04-11');
INSERT INTO BOOK (BOOK_ID,CATEGORY,AUTHOR_ID,PRICE,PUBLISHED_DATE)
VALUES (book_id_seq.nextval,'경제',2,11000,'2021-02-05');

SELECT * FROM  AUTHOR;
SELECT * FROM  BOOK;

-- 같은 이름의 시뭔스를 초기화 못함. 삭제 후 다시 생성
DROP SEQUENCE book_id_seq ;

-- 테이블 간의 참조 관계에서 무결성을 위한 처리 방식.

-- 테이블 삭제 : 참조 테이블이 있으면 테이블 삭제 못합니다.
--			  BOOK 테이블 삭제 후 AUTHOR 삭제하기 
DROP  TABLE BOOK; -- 외래 키에 의해 참조되는 고유/기본 키가 테이블에 있습니다. 
DROP  TABLE AUTHOR; 

-- 데이터 삭제 : 참조 관계 고려해야 합니다.
--				BOOK 테이블에서 참조하고 있는 값은 삭제 할 수 없다. 
DELETE FROM AUTHOR WHERE AUTHOR_ID=1;













