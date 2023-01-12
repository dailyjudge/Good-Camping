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

select * from stuff_cart;

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



