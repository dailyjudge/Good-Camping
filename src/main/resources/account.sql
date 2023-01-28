create table account(
	ac_id varchar2(20 char) primary key,
	ac_pw varchar2(20 char) not null,
	ac_name varchar2(20 char) not null,
	ac_birth varchar2(20 char) not null,
	ac_phone varchar2(20 char) not null,
	ac_postcode varchar2(200 char) not null,
	ac_address varchar2(200 char) not null,
	ac_detailAddress varchar2(20 char) not null,
	ac_extraAddress varchar2(20 char) not null,
	ac_gender varchar2(1 char) not null,
	ac_file varchar2(200 char) not null
);
select * from account
-- 자동로그인 위한 컬럼 추가 설정
-- 고유 세션키 
alter table account add ac_sessionkey varchar(50) default 'none' not null;
-- 세션 유효기간
alter table account add ac_sessionlimit timestamp;

-- 세션 테스트
select * from account and ac_sessionlimit > systimestamp
select * from account where ac_sessionkey = '6D6FDA1F96413C09419DEFA151AAB587'
select * from account
select * from account;

drop table account CASCADE CONSTRAINTS 
drop sequence account_seq;
create sequence account_seq;

select * from all_constraints
where table_name like '%stuff'


insert into account values('test@naver.com','1111','jun','971229','010-1111-1111','a','b','c','d','n','a.jpg');
insert into account values('test2@naver.com','1111','jun1','971229','010-2222-2222','a','b','c','d','n','a.jpg');
insert into account values('test3@naver.com','1111','jun3','971229','010-3333-3333','a','b','c','d','n','a.jpg');
insert into account values('jun19975@naver.com','1111','jun6','971229','010-4444-4444','a','b','c','d','n','a.jpg','jun19975@naver.com',sysdate);
insert into account values('judgemk1@naver.com','1111','jun4','971229','010-4444-4444','a','b','c','d','n','a.jpg');
delete account where ac_id like '%judgemk1%'

select * from account;  
select ac_id from account where ac_name = 'jun' and ac_phone ='010-1111-1111';