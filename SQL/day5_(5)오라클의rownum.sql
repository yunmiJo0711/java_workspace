/*
 * 	오라클의 rownum 컬럼 : 조회결과 순서를 저장하는 메타데이터 컬럼
 * 			ㄴ 순위(RANK)에 활용
 * 			ㄴ RANK 함수도 있습니다. 
 * 
 */
SELECT *
FROM TBL_PRODUCT tp 
ORDER BY PRICE DESC;

SELECT *
FROM TBL_PRODUCT tp ;

--- 1) rownum 조회하기
SELECT rownum, tp.*  -- rownum 은 정렬하기 전의 행 순서값
FROM TBL_PRODUCT tp 
ORDER BY PRICE DESC;


--- 2) 정렬 후의 rownum 을 부여
SELECT rownum ,tpp.*
FROM (
	SELECT *
	FROM TBL_PRODUCT tp 
	ORDER BY PRICE DESC)tpp;


--- 3) 2)번 쿼리에 rownum 조건식 테스트
-- 정렬한 결과 1번째 행이 가장 높은 가격입니다. - 조회하기
SELECT rownum ,tp.*
FROM (
	SELECT *
	FROM TBL_PRODUCT tp 
	ORDER BY PRICE DESC)tp
-- WHERE rownum =1;
-- WHERE rownum <=3;  				-- top 3
-- WHERE rownum =2;  				-- 조회 안됨 (중간값부터 x)
-- WHERE rownum >2 AND rownum <5;  	-- 조회 안됨
-- WHERE rownum BETWEEN 2 AND 4;  	-- 조회 안됨

-- 결론 : rownum 메타데이터 컬럼이며 첫번째 행부터 가져오는 것만 가능하다. 

--- 4) 위의 조회 안되는 조건을 해결하는 방법 -> rownum 을 일반 컬럼으로 바꾸기 위해 한번 더 서브쿼리 (중간값을 가져오기 위해서 다시 서브쿼리)
SELECT *
FROM 
	(SELECT rownum r, tp.*      -- rownum 에 대한 별칭이 필요합니다.
	 FROM (	
	    	SELECT *
		    FROM TBL_PRODUCT 
		    ORDER BY PRICE DESC
            ) tp)
WHERE r BETWEEN 2 AND 4;

/*
 * <문제> 즐겨찾기가 가장 많은 식당 정보 출력하기
REST_INFO 테이블에서 음식종류별로 즐겨찾기수가 가장 많은 식당의 음식 종류, ID, 식당 이름, 즐겨찾기수를 조회하는 
SQL문을 작성해주세요. 
이때 결과는 음식 종류를 기준으로 내림차순 정렬해주세요.

select ri.FOOD_TYPE, REST_ID, REST_NAME, ri.FAVORITES
from REST_INFO ri
join
(	
	select FOOD_TYPE, Max(FAVORITES) as FAVORITES
    from REST_INFO 
    group by FOOD_TYPE) foodfav
on ri.FOOD_TYPE = foodfav.FOOD_TYPE
and ri.FAVORITES = foodfav.FAVORITES
order by ri.FOOD_TYPE desc;

 */


/*
 * <문제> 조건에 부합하는 중고거래 댓글 조회하기
USED_GOODS_BOARD와
USED_GOODS_REPLY 테이블에서 

2022년 10월에 작성된 게시글 제목, TITLE, 게시글 BOARD_ID, 댓글 ID, REPLY_ID, 댓글 작성자 ID, WRITER_ID, 
댓글 내용, CONTENTS, 댓글 작성일 CREATED_DATE 을 조회하는 SQL문을 작성해주세요. 
결과는 댓글 작성일CREATED_DATE 을 기준으로 오름차순 정렬해주시고, 
댓글 작성일이 같다면 게시글 제목 TITLE, 을 기준으로 오름차순 정렬해주세요.

select  TITLE, 
        b.BOARD_ID, 
        r.REPLY_ID, 
        r.WRITER_ID, 
        r.CONTENTS, 
        to_char(r.CREATED_DATE,'yyyy-mm-dd') as CREATED_DATE
from USED_GOODS_BOARD b
join USED_GOODS_REPLY r
on b.BOARD_ID = r.BOARD_ID
and to_char(b.CREATED_DATE,'yyyy-mm')='2022-10'
order by r.CREATED_DATE, b.TITLE ;

 */

	
 
	