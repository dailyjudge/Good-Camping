
create table account(
	ac_id varchar2(20 char) primary key,
	ac_pw varchar2(20 char) not null,
	ac_name varchar2(20 char) not null,
	ac_img varchar2(20 char) not null
);

drop table account
select * from account

insert into account values('test', '1111', '민규', 'aa.jpg');
insert into account values('test2', '1111', '예은', 'aa.jpg');
insert into account values('test3', '1111', '준영', 'aa.jpg');
