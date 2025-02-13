/*
 * 	특정 컬럼 값이 동일한 행들을 그룹으로 묶고
 * 	집계 함수를 그룹단위로 결과값을 조회할 수 있습니다. 
 * 	기본키, 유니크(값의 고유성) 컬럼은 그룹화 의미 없습니다.
 * 
 * 	select
 * 	from
 *  [where]
 * 	group by 컬럼명 -- 지정된 컬럼의 값으로 그룹화
 * 	order by 컬럼명 
 * 
 */
SELECT * FROM TBL_SCORE; 

-- 동일한 값이 많은 컬럼으로 정렬
SELECT * FROM TBL_SCORE order by STUNO ;  	-- 학번
SELECT * FROM TBL_SCORE order by SUBJECT  ; -- 과목
SELECT * FROM TBL_SCORE order by TEACHER  ; -- 선생님
SELECT * FROM TBL_SCORE order by TERM  ;  	-- 학기

-- 학생별 수강과목수
SELECT stuno , count(*) AS "수강과목수"  -- AS 별칭부여
from TBL_SCORE  
group by STUNO ;

-- 과목별 수강인원수
SELECT SUBJECT , count(*) AS "수강인원"
from TBL_SCORE  
group by SUBJECT ;

-- 교사별 수강인원수
SELECT TEACHER , count(*) AS "수강인원"
from TBL_SCORE  
group by TEACHER ;

-- 학기별 수강인원수
SELECT TERM , count(*) AS "수강인원"
from TBL_SCORE
group by TERM 
ORDER BY TERM ;

----
SELECT * FROM TBL_SCORE;

--- (1) 점수 80점 이상인 행에 대해 과목별 평균구하기
SELECT subject, COUNT(*), avg(jumsu)
from TBL_SCORE
WHERE JUMSU >= 80   -- 조건식 일치하는 행 추출 후
GROUP BY SUBJECT ;  -- 그룹화

-- (2) 과목별 평균구하기
SELECT subject ,COUNT(*), AVG(jumsu)
from TBL_SCORE
group by SUBJECT ;

-- (3) 위의 결과에서 평균점수가 85점 이사인 과목만 조회하기 - (1)번과 다른 점은?
SELECT subject, COUNT(*), avg(jumsu) AS "과목별평균점수"
from TBL_SCORE
GROUP BY SUBJECT     	  -- 그룹화 후 
HAVING avg(jumsu) >= 85;  -- 그룹화 함수 결과에 대한 조건 : HAVING

--(4) 정렬
SELECT subject, COUNT(*), avg(jumsu) AS "과목별평균점수"
from TBL_SCORE
GROUP BY SUBJECT     	  	-- 그룹화 후 
HAVING avg(jumsu) >= 85   	-- 별칭 사용 못함(오류)
ORDER BY "과목별평균점수" DESC ; -- 별칭 사용 가능

-- 문제 : 2과목 이상의 점수가 있는 학생의 학번, 과목수, 평균점수(소수점 2자리로 반올림) 구해주세요.
-- 정렬은 학번순으로 해주세요
SELECT STUNO, COUNT(*), round(avg(JUMSU),2)
from TBL_SCORE
group BY STUNO
HAVING count(*) >=2;

SELECT * FROM  TBL_SCORE ;

-- 국어 과목에 대해서만 학기별(term)로 그룹화. -> 학기, 수강인원수, 평균점수 조회
-- where 또는 HAVING ? WHERE  가 더 쉽습니다.
SELECT term, COUNT(*), round(avg(JUMSU),2)
from TBL_SCORE
WHERE SUBJECT = '국어'
group BY TERM ;

-- 코딩테스트 연습
-- 문제 : 진료과별 총 예약 횟수 출력하기
/*
SELECT MCDP_CD, COUNT(*) AS "예약한 환자수"
from APPOINTMENT 
WHERE to_char (APNT_YMD,'yyyy-mm')='2022-05'
GROUP BY MCDP_CD
ORDER BY "예약한 환자수",MCDP_CD ;
*/

-- 문제 : 동명 동물 수 찾기
/*
SELECT NAME, count(*) AS count 
from ANIMAL_INS
where name is not null
group BY NAME
having count(*) >= 2
ORDER BY NAME;
*/
















