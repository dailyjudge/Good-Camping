create table stuff(
	
	s_no number(7) primary key,
	-- 기본키
	s_productId number(30) default ON NULL 0,
	-- 소분류
	s_category varchar2(100 char) default ON NULL '미제공',
	-- 세분류
	s_detail_category varchar2(100 char) default ON NULL '미제공',
	-- 타이틀
	s_title varchar2(500 char) default ON NULL '캠핑용품 판매',
	-- 이미지 
	s_image varchar2(500 char) default ON NULL 'resources/stuff/stuff_default.png',	
	-- 브랜드
	s_brand varchar2(100 char) default ON NULL '미제공',
	-- 가격
	s_price number(10)
);


select * from stuff

select count(*) from stuff;

create sequence stuff_seq

drop table stuff
delete stuff