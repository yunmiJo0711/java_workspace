/*
 * 집계 (통계) 함수 : count, sum, avg(평균), max, min
 * 
 * 테이블 행의 컬럼값을 대상으로 실행되는 통계 함수. 
 * -> 결과는 항상 1개 컬럼과 행이 나온다.
 */

CREATE TABLE tbl_item(
	name varchar2(20),
	price number(8)
);

INSERT INTO TBL_ITEM VALUES ('새우깡',2500);
INSERT INTO TBL_ITEM VALUES ('삼각김밥',1400);
INSERT INTO TBL_ITEM VALUES ('하겐다즈',10500);
INSERT INTO TBL_ITEM VALUES ('참이슬',3600);
INSERT INTO TBL_ITEM VALUES ('카스',7900);
INSERT INTO TBL_ITEM VALUES ('사탕',6700);
INSERT INTO TBL_ITEM VALUES ('삼다수',2200);

SELECT * FROM  TBL_ITEM;

-- 1. count 함수는 행의 개수. () 인자로 컬럼은 상관없음이므로 * 표시
SELECT  COUNT(*) FROM TBL_ITEM ;  -- 전체 행의 개수 

-- 가격이 5000 원 이상인 행의 개수.
SELECT  COUNT(*) FROM TBL_ITEM
WHERE  PRICE > 5000;

-- 2. sum : 합계를 구할 컬럼을 인자로 전달
SELECT sum(price) FROM TBL_ITEM;
SELECT sum(price) FROM TBL_ITEM
WHERE  PRICE > 5000;

-- 3. avg : 평균을 구할 컬럼을 인자로 전달
SELECT avg(price) FROM TBL_ITEM;

-- 소수점 이하 둘째자리로 반올림
SELECT ROUND(avg(PRICE),2) FROM TBL_ITEM; 
SELECT avg(price) FROM TBL_ITEM
WHERE  PRICE > 5000;

-- 4. max : 수치 또는 날짜 타입 컬럼을 인자로 전달
SELECT max(price) FROM TBL_ITEM;
SELECT max(price) FROM TBL_ITEM
WHERE  PRICE < 5000;

-- 5. min : 수치 또는 날짜 타입 컬럼을 인자로 전달
SELECT min(price) FROM TBL_ITEM;
SELECT min(price) FROM TBL_ITEM
WHERE  PRICE > 5000;

-- 주의 사항 : 집계 함수 결과를 조회할 때 다른 컬럼과 같이 SELECT(조회)못함. 쓸 수 없음
SELECT name, min(price) FROM TBL_ITEM;   
-- 오류 메시지 : 단일 그룹의 그룹 함수가 아닙니다.

-- 미리 해보기
-- TBL_DICT 테이블은 step 컬럼이 같은 값을 갖는 행이 여러개 입니다.
-- 같은 값을 갖는 행이 여러개일 때, group by 그룹화 가능합니다. 
SELECT STEP, COUNT(*) FROM TBL_DICT
GROUP BY STEP ; 











