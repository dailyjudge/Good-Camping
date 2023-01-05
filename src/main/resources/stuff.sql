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

insert  into stuff_cart values(stuff_cart_seq.nextval,'test',8075,4);

-- 상품, 유저, 장바구니
select  s_title,s_price,s_image, sc_amount, s_price*sc_amount money
from stuff, stuff_cart, account
where account.ac_id = stuff_cart.sc_user_id and
stuff.s_no = stuff_cart.sc_stuff_no and
account.ac_id = 'test'