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

update stuff set s_brand = 'GoodCamping' where s_brand = '미제공'

-- 1번 : 주문 테이블에 데이터 넣기
insert into stuff_order values(nextval, id, #{ta, 주소들 , 날짜);
-- 날짜로 뽑자 (1, 3, 5, 10, 22)
-- list -> list.get(0).getSo_no()
select * from stuff_order
where so_userId = #{so_userId}
order by so_date desc

select max(so_no) from stuff_order
where so_userId = #{so_userId}

-- 주문 상품 테이블 (pk, 주문 테이블no, 상품  id, 상품 개수)
select * from stuff

select count(*) from stuff;

create sequence stuff_seq

drop table stuff
delete stuff

select * from stuff_cart;

select  *from stuff_cart  where  sc_user_id='test' and  sc_stuff_no=8380;

create table stuff_cart(
	
sc_cart_id number not null primary key,
sc_user_id varchar2(20 char) not null,
sc_stuff_no number(7) not null,
sc_amount  number default 0
);

select * from stuff_cart
create sequence stuff_cart_seq;
drop sequence stuff_cart_seq;
delete stuff_cart


select * from stuff_sale;
insert  into stuff_cart values(stuff_cart_seq.nextval,'test',8075,4);

-- 상품, 유저, 장바구니
select  s_title,s_price,s_image, sc_amount, s_price*sc_amount money
from stuff, stuff_cart, account
where account.ac_id = stuff_cart.sc_user_id and
stuff.s_no = stuff_cart.sc_stuff_no and
account.ac_id = 'test'



--주문번호 (PK), 상품번호,사용자 id ,갯수,우편번호, 주소,주문 날짜,
--create table stuff_order(
--	
--	so_no number(7) primary key,
--	so_user_id varchar2(20 char) not null,
--	so_stuff_no number(7) not null,
--	so_sc_amount number(2) not null,
--	so_user_zoncode number(5)not null, -- 우편번호
--	so_user_addr varchar2(300 char) not null, -- 주소
--	so_user_detailAddr varchar2(200 char) not null, --상세 주
--	so_date date not null
--	
--);

create table stuff_order(
	so_no number(7) primary key,
	so_user_id varchar2(20 char) not null,
	so_user_zoncode number(5)not null,
	so_user_addr varchar2(300 char) not null,
	so_user_detailAddr varchar2(200 char) not null,
	so_date date not null
);

create sequence stuff_order_seq;
insert into stuff_order values(stuff_order_seq.nextval,'test',08015,'서울 양천구 신목로12길 22 (신정동, 롯데캐슬)','103동 502호',sysdate);
select * from stuff_order;

create table stuff_order_items(
	soi_no number(7)primary key,
	soi_so_no number(7) not null,
	soi_stuff_no number(7) not null,
	soi_sc_amount number(2)not null 
);
select stuff
insert into stuff_order_items values(stuff_order_items_seq.nextval,stuff_order_seq.nextval,8075,2);
delete stuff_order_items;

create sequence stuff_order_items_seq;

select * from stuff_order_items;

drop table stuff_order;
drop sequence  stuff_order_seq;

select so_no, s_no, s_title, s_price, soi_sc_amount, so_date, so_user_zonecode, so_user_addr, so_user_detailaddr
from stuff, stuff_order, stuff_order_items 
where s_no = soi_stuff_no and so_no = soi_so_no and so_no = #{so_no}



-- 주문
create table stuff_order(
   so_no number(7) primary key,
   so_user_id varchar2(20 char) not null,
   so_user_zoncode number(5)not null,
   so_user_addr varchar2(300 char) not null,
   so_user_detailAddr varchar2(200 char) not null,
   so_date date not null
);

select * from stuff_order
delete stuff_order
create sequence stuff_order_seq;

-- 주문 상품
create table stuff_order_items(
   soi_no number(7)primary key,
   soi_so_no number(7) not null,
   soi_stuff_no number(7) not null,
   soi_sc_amount number(2)not null 
);

select * from stuff_order_items where soi_so_no = 462;
select * from stuff_order_items
delete from stuff_order_items
create sequence stuff_order_items_seq;

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

-- 테이블 세개. 상품, 주문, 주문 상품
-- s_no = soi_stuff_no

select * from stuff_order order by so_date desc

select * from stuff_cart
select * from stuff_order_items where soi_so_no = 181
delete stuff_order_items
delete stuff_order
select * from stuff_order;
select sc_stuff_no, sc_amount, s_title, s_image, s_price
from stuff, stuff_cart
where s_no = sc_stuff_no
and sc_cart_id = 67 

-- 등산장비 - 핫팩, 로프
-- 취사용품 - 코펠, 바비큐그릴/화로대, 버너
-- 제습/방향/탈취 - 숯
-- 캠핑매트 - 미제공 ( 캠핑매트)
-- 캠핑가구 - 야전침대, 캠핑테이블, 캠핑의자
-- 랜턴 - 겁나 많음

-- 판매량 DB, why? 상품 추천 해주기 위함. (카테고리 별로 상품 추천)
-- 판매량 DB pk
-- 상품 번호
-- category 이름 (s_category)
-- 판매량

create table stuff_sale (
   ss_no number(7) primary key,
   ss_stuff_no number(7),
   ss_category varchar2(100 char),
   ss_count number(7)
);

create sequence stuff_sale_seq

select * from stuff_sale;

select * from stuff_sale where ss_category='취사용품'

select * from stuff_sale where ss_stuff_no= 8127;
delete from stuff_sale where ss_no=50;

select * from (select * from stuff_sale where ss_category='랜턴' order by ss_count desc) where rownum<=4;
--조인 stuff,stuff_sale
--select so_no, s_no, s_title, s_price, soi_sc_amount, so_date, so_user_zonecode, so_user_addr, so_user_detailaddr
from stuff, stuff_order, stuff_order_items 
where s_no = soi_stuff_no and so_no = soi_so_no and so_no = #{so_no}


select s_image,s_title,s_price,s_no,ss_no,ss_stuff_no,ss_category,ss_count
from stuff,(select * from stuff_sale where ss_category='랜턴' order by ss_count desc) where rownum<=4 and s_no = ss_stuff_no;

insert into stuff_sale values(stuff_sale_seq.nextval, 11070, '캠핑가구', 3);

select s_no,s_category from stuff;

insert into stuff_sale (ss_stuff_no,ss_category)select s_no,s_category from stuff ;

update stuff_sale set ss_count=ss_count + 5 where ss_stuff_no = 8127

delete stuff_sale;
select count(*)
from stuff, stuff_sale
where s_no = ss_stuff_no and s_no = #{sc_stuff_no}


--
select * from stuff_sale

select s_image, s_title, s_price, s_no, ss_no, ss_stuff_no, ss_category, ss_count
		from stuff, (
				select * from stuff_sale 
				where ss_category = '버너' 
				order by ss_count DESC
				) 
where ROWNUM <= 5 and s_no = ss_stuff_no 

