/*
 *  서브 쿼리 (sub query) : 하나의 쿼리(주 쿼리)에 포함된 다른 쿼리(서브 쿼리) 입니다. 
 * DML 명령어 : insert, update, delete, select 의 조건식 검사에
 * 다른 쿼리를 실행한 결과로 주 쿼리를 실행합니다.
 *
 */

-- 예시 1 : 성적 테이블이 평균 점수 값보다 큰 점수들을 모두 조회하기
--			ㄴ 평균 구하기
--			ㄴ 성적 테이블의 점수와 평균을 비교

select avg(JUMSU) FROM TBL_SCORE ;

-- 1) with 구문 : 서브 쿼리 사용하지 않는 방법

WITH temp AS (SELECT avg(jumsu) AS avgjumsu FROM TBL_SCORE)
select * FROM TBL_SCORE
WHERE JUMSU  >= (SELECT avgjumsu FROM temp) ;

-- 2) 서브쿼리 사용하는 방법
select * FROM TBL_SCORE
WHERE JUMSU  >=(SELECT avg(jumsu) AS avgjumsu FROM TBL_SCORE);

-- 예시 2 : 국어 과목을 수강한 학생의 이름을 조회하기
--			ㄴ 성적 테이블에서 국어 과목을 수강한 학번 조회
SELECT * FROM TBL_SCORE 
WHERE SUBJECT = '국어';
-- ㄴ 위에서 조회된 값으로 학생 테이블에서 조회하기
SELECT name FROM TBL_STUDENT
-- WHERE STUNO IN ('2021001','2019019','2020017');
WHERE STUNO IN 
(SELECT STUNO FROM TBL_SCORE WHERE SUBJECT = '국어');

-- 서브 쿼리는 조회 성능에 나쁜 영향을 줄 수 있습니다. 
--  	ㄴ 그래서 대체 할 수 있는 방법 : with , join 으로 더 나은 성능을 갖도록 sql 을 작성할 수 있습니다. 

-- 코딩 테스트 연습 문제
-- 카테고리 별 상품 개수 구하기
/*
 * select category , count(*) as PRODUCT
from(
    SELECT substr(PRODUCT_CODE,1,2)  
            as category
    from PRODUCT )
group by category 
order by category ;
 */



















			