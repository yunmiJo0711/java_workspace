/*
 * 예시 :	영어-한글 나만의 사전
 * << 요구사항>>
 * 1. 영어단어, 한글 뜻은 필수입력값입니다.  
 * 2. 난이도 수준을 1~3 으로 설정. null 허용
 * 3. 영어단어 동일한 값은 중복 안되도록 함. 유니크
 * 4. 입력한 순서에 따라 일련번호를 부여함. 필수입력값 not null + 중복 없음 -> 기본키로 설정
 * 
 * 테이블명 : tbl_dict
 * 컬럼명 : english, korean, step, idx
 * 
 */

-- 1. 테이블 생성
CREATE TABLE tbl_dict(
idx NUMBER(8) PRIMARY KEY ,  -- 기본키(검색의 성능과 관련)
english  varchar2(100) not  NULL UNIQUE ,
korean  varchar2 (100) NOT NULL,
step  number(1) CHECK (step BETWEEN 1 AND 3)
);

--3. SELECT 컬럼1,컬럼2,... from 테이블명 where 조건식(행추출), order by 컬럼1,컬럼2,...

-- UNIQUE , pk(null 허용하지 않는 행 식별) 컬럼으로 조건식
SELECT * FROM  TBL_DICT WHERE IDX =2;  -- 오직 1개의 행 추출
SELECT * FROM  TBL_DICT WHERE  ENGLISH ='order';

-- order by : 정렬 (오름차순 또는 내림차순)
SELECT * FROM  TBL_DICT 
order by IDX ; -- idx 컬럼 값 기준 오름차순. ASC 키워드 생략

SELECT * FROM  TBL_DICT 
order by IDX DESC ;  -- idx 컬럼 값 기준 내림차순

SELECT * FROM  TBL_DICT 
order by ENGLISH  ;  -- english 컬럼 값 기준 오름차순

SELECT * FROM  TBL_DICT 
order by ENGLISH  DESC ;  -- english 컬럼 값 기준 내림차순

SELECT * FROM  TBL_DICT 
ORDER BY STEP ;  -- step 컬럼은 같은 값을 갖는 행이 많습니다.  -> 2번째 정렬기준 컬럼 지정

SELECT * FROM  TBL_DICT 
ORDER BY STEP,IDX ;  -- 2번째 정렬 기준 컬럼 idx 지정

SELECT * FROM  TBL_DICT 
ORDER BY STEP DESC ,ENGLISH  ;  -- 2번째 정렬기준 컬럼 english 지정

-- 꼭 where 후에 ORDER BY 가 나와야함. 안그러면 오류남.
SELECT * FROM  TBL_DICT 
WHERE STEP =1  -- 조건 먼저 쓰기 
ORDER BY STEP DESC ,ENGLISH ;


-- 2. 데이터 추가 
INSERT INTO tbl_dict VALUES (
	1,
	'public',
	'공용의',
	'1'  -- 문자열 1을 정수 1로 변환
);

INSERT INTO tbl_dict (IDX, english, KOREAN)
		VALUES (2,'private','사적인');  
	
INSERT INTO tbl_dict VALUES (
	3,
	'deprecated',
	'비난하다.반대하다.',
	'3'
);

INSERT INTO tbl_dict VALUES (
	4,
	'list',
	'목록',
	'2'
);

INSERT INTO tbl_dict VALUES (
   5,
   'constraint',
   '제약사항',
   3
);

INSERT INTO tbl_dict VALUES (
   6,
   'order',
   '순서',
   1
);

INSERT INTO tbl_dict VALUES (
   7,
   'main',
   '주요한',
   1
);

INSERT INTO tbl_dict VALUES (
   8,
   'order',
   '순서',
   1
);  -- 'order' 값이 중복 : 무결성 제약조건 위반 오류

INSERT INTO tbl_dict VALUES (
   9,
   'reverse',
   '반대로',
   2
);

INSERT INTO tbl_dict VALUES (
   10,
   'double',
   '이중의',
   1
);
 