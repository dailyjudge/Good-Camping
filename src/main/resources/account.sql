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
drop table account;
drop sequence account_seq
create sequence account_seq;

insert into account values('test@naver.com','1111','jun','971229','010-1111-1111','a','b','c','d','n','a.jpg');
insert into account values('test2@naver.com','1111','jun1','971229','010-1111-1111','a','b','c','d','n','a.jpg');


select * from account;