SELECT COUNT(*)
FROM BIKE_RENT br 
WHERE AREA1 LIKE '%구로%';


SELECT REGEXP_SUBSTR(area1,'[가-힣]+구',1,1) AS gu  -- 정규표현식으로 문자열 추출. xx구
FROM BIKE_RENT br;

SELECT gu,COUNT(*) AS count
from(
	SELECT REGEXP_SUBSTR(area1,'[가-힣]+구',1,1) AS gu  -- 정규표현식으로 문자열 추출. xx구
	FROM BIKE_RENT br
	)
GROUP BY gu
ORDER BY count desc;