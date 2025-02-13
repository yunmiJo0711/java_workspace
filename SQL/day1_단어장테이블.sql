/*
 * 자바에서 파일에 저장했었던 '단어장'을 위한 테이블 만들기 
 * 
 * 0. 테이블 이름 : tbl_javaword
 * 1. 테이블 칼럼 :
 * 				idx(순서)				: number
 * 				english(영어 키워드)	: varchar2(100)
 * 				korean(한글 뜻)		: varchar2(500)
 * 				step				: char(1)
 * 
 * 2. insert 명령으로 샘플값을 추가
 * 
 *
 */
-- 1) DDL
CREATE  TABLE tbl_javaword (
		idx number (10),
		english  varchar2 (100),
		korean  varchar2 (500),
		step  char (1)
);

-- 2) DML
-- insert 형식1 : 컬럼명 안쓸때는 모든 값을 컬럼 정의 순서대로 나열
INSERT INTO TBL_JAVAWORD VALUES (
	1,
	'public',
	'공용의',
	'1'
);
-- insert 형식2 : 선택적으로 컬럼이름 지정할 수 있습니다. 
INSERT INTO TBL_JAVAWORD (english, KOREAN)
		VALUES ('private','사적인');
-- 값이 없는 컬럼 idx, step 은 null 상태입니다. 
	
INSERT INTO TBL_JAVAWORD VALUES (
	3,
	'deprecated',
	'비난하다.반대하다.',
	'3'
);

INSERT INTO TBL_JAVAWORD VALUES (
	4,
	'list',
	'목록',
	'2'
);

INSERT INTO TBL_JAVAWORD VALUES (
   5,
   'constraint',
   '제약사항',
   3
);

INSERT INTO TBL_JAVAWORD VALUES (
   6,
   'order',
   '순서',
   1
);

INSERT INTO TBL_JAVAWORD VALUES (
   7,
   'main',
   '주요한',
   1
);

INSERT INTO TBL_JAVAWORD VALUES (
   8,
   'order',
   '순서',
   1
);

INSERT INTO TBL_JAVAWORD VALUES (
   9,
   'reverse',
   '반대로',
   2
);

INSERT INTO TBL_JAVAWORD VALUES (
   10,
   'double',
   '이중의',
   1
);

-- 데이터 조회 SELECT 명령어로 지정된 컬럼 또는 행을 조회(추출)
/*
 *	select 컬럼1, 컬럼2,...
 *	from 테이블명
 *	[where 컬럼명=값 (조건식)]
 */

-- 모든 컬럼과 모든 행 가져오기
SELECT * FROM  TBL_JAVAWORD;

-- 일부 컬럼(열)세로 추출하기
SELECT english FROM TBL_JAVAWORD ;   -- 전체 행
SELECT english,STEP  FROM TBL_JAVAWORD ;  -- 전체 행

-- 일부 로우(행)가로 추출하기 : 1) 전체 행(조건이 없을 때) 2) 조건에 맞는 행
SELECT * FROM  TBL_JAVAWORD   -- 모든 컬럼
		WHERE STEP > 2;    -- 조건식. 조건에 일치하는 행 추출
		
-- 예시 1 : idx 값이 4인 행을 조회
SELECT  * FROM  TBL_JAVAWORD
		WHERE  IDX =4;
		
-- 예시 2 : idx 값이 null 인 행을 조회
SELECT  * FROM  TBL_JAVAWORD
		WHERE  IDX IS NULL;	
		
-- 예시 3 : english 값이 'private' 인 행을 조회
SELECT  * FROM  TBL_JAVAWORD
		WHERE ENGLISH = 'private';
		
-- 예시 4 : korean  값에 '반대' 포함(like와 %)한 행을 조회
SELECT  * FROM  TBL_JAVAWORD
		WHERE  KOREAN LIKE '%반대%';
	
-- 예시 5 : english 값이 'd'로 시작하는 행을 조회
SELECT  * FROM  TBL_JAVAWORD
		WHERE  ENGLISH LIKE 'd%';

-- 조건식 사용 연산 : < , > , <= , >= , and , or
SELECT * FROM  TBL_JAVAWORD
		WHERE  ENGLISH > 'public';  -- 사전순으로 'public'보다 뒤에 나오는 단어
	
-- between , in 연산
SELECT  * FROM  TBL_JAVAWORD
		WHERE  IDX  BETWEEN 6 AND 9;
	-- idx >=6 and idx <=9
		
SELECT  * FROM  TBL_JAVAWORD
		WHERE  IDX IN (4,7,9);
	-- idx=4 or idx=7 or idx=9
	
-- not 연산
SELECT  * FROM  TBL_JAVAWORD
		WHERE  IDX  NOT BETWEEN 6 AND 9;

SELECT  * FROM  TBL_JAVAWORD
		WHERE  IDX NOT IN (4,7,9);
	
SELECT  * FROM  TBL_JAVAWORD
		WHERE  IDX IS NOT NULL ;
	
-- 문제 만들기
SELECT  * FROM  TBL_JAVAWORD
		WHERE IDX  >5;
SELECT  * FROM  TBL_JAVAWORD
		WHERE IDX  <=5;
-- 크다, 작다 연산 null 값은 제외.
	
-- 2개 이상의 컬럼으로 조건식 만들기 가능합니다. : and, OR 
SELECT  * FROM  TBL_JAVAWORD
		WHERE ENGLISH  LIKE 'd%' AND STEP =1;

-- 문자열 함수 : length, upper, lower, substr, replace, instr...
-- 컬럼 값에 적용하여 조회하기
SELECT UPPER(english),LENGTH (english)
	from TBL_JAVAWORD;

-- where 조건을 활용하는 명령 : update, delete
-- 데이터의 수정 update 

update TBL_JAVAWORD 
SET IDX =2,STEP ='1'  -- 변경할 컬럼이름=값, 나열
WHERE IDX  IS NULL;   -- 변경할 행의 조건식

UPDATE TBL_JAVAWORD 
SET STEP ='3'
WHERE ENGLISH = 'public';  -- 값은 대소문자 구분합니다.

UPDATE  TBL_JAVAWORD 
SET STEP ='2'
WHERE IDX BETWEEN 3 AND 5;

-- 행의 삭제(컬럼만 삭제하는 것은 불가능 -> 테이블 구조가 변경되기 때문에)
DELETE FROM TBL_JAVAWORD
	WHERE IDX BETWEEN 3 AND 5; 

-- update, delete 에 where 없이 사용하는 것은 위험한 작업
-- 			ㄴ 조건에 맞는 컬럼 또는 행에 적용되어야 합니다.

-- 전체 테이블 삭제
TRUNCATE TABLE TBL_JAVAWORD ;

-- 병합 COALESCE
	
	

	










