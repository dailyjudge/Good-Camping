create table board_list(
	bo_no int primary key,
	bo_title varchar2(20 char) not null,
	bo_write_id varchar2(20 char) not null,
	bo_time date not null,
	bo_readcount varchar2(2000 char) not null,
	bo_file varchar2(200 char) not null
);

drop table board_list;

insert into board_list values(board_list_seq.nextval,'1111','jun', sysdate, 0, 'a.jpg');
create sequence board_list_seq;
drop sequence board_list_seq;

select * from board_list;  
select board_list from board where ac_name = 'jun' and ac_phone ='010-1111-1111';
-----------------------

create table comu_info(
	comu_no varchar2(30 char) primary key,
	comu_groupid varchar2(30 char) not null,
	comu_title varchar2(30 char) not null,
	comu_write_id varchar2(20 char) not null,
	comu_w_time date not null,
	comu_d_time date,
	comu_readcount varchar2(300 char) not null,
	comu_content varchar2(1000 char) not null,
	comu_file varchar2(200 char)
);

drop table comu_info;
create sequence comu_info_seq;


drop sequence comu_info_seq;

insert into comu_info values(comu_info_seq.nextval,'서울특별시','이용 안내','test1@naver.com',sysdate,null,'12','이용 수칙을 안내드리겠습니다','a.jpg');
insert into comu_info values(comu_info_seq.nextval,'서울특별시','이용 안내2','as@naver.com',sysdate,null,'22','이용 수칙을 안내드리겠습니다2','b.jpg');
insert into comu_info values(comu_info_seq.nextval,'서울특별시','이용 안내3','1212@naver.com',sysdate,null,'100','이용 수칙을 안내드리겠습니다3','4.jpg');
insert into comu_info values(comu_info_seq.nextval,'경기도','이용 안내4','jun19975@naver.com',sysdate,null,'101','이용 수칙을 안내드리겠습니다4','5.jpg');

select * from comu_info where comu_groupid = '서울특별시';
select * from comu_info; 