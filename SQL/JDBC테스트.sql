
-- 키워드로 상품검색 SQL
SELECT * FROM TBL_PRODUCT tp 
WHERE PNAME LIKE '%라면%';

SELECT * FROM TBL_PRODUCT tp 
WHERE PNAME LIKE '%' || '라면' || '%';

insert into tbl_postcode values ('08301', '서울특별시 구로구 가마산로25길 9-24 (구로동, 구로구의회)');
insert into tbl_postcode values ('08299', '서울특별시 구로구 구로중앙로28길 66 (구로동, 구로5동 주민센터, 구로구보건소)');
insert into tbl_postcode values ('08286', '서울특별시 구로구 벚꽃로72길 32 (구로동, 서울아트빌)');
insert into tbl_postcode values ('08268', '서울특별시 구로구 경인로19길 39 (오류동, 서울오류초등학교)');

SELECT * FROM TBL_POSTCODE tp ;