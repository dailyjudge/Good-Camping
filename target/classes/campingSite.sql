create table camping_site(
	c_no number(6) primary key,
	c_zipcode number(6) default ON NULL 0,
	c_addr1 varchar2(1000 char) default ON NULL '미제공',
	c_animalCmgCl varchar2(1000 char) default ON NULL '불가능',
	c_bizrno varchar2(1000 char) default ON NULL '미제공',
	c_brazierCl varchar2(1000 char) default ON NULL '미제공',
	c_caravAcmpnyAt varchar2(1000 char) default ON NULL 'N',
	c_caravInnerFclty varchar2(1000 char) default ON NULL '미제공',
	c_caravSiteCo varchar2(1000 char) default ON NULL '미제공',
	c_clturEventAt varchar2(1000 char) default ON NULL '0',
	c_trlerAcmpnyAt varchar2(1000 char) default ON NULL 'N',
	c_exprnProgrmAt varchar2(1000 char) default ON NULL 'N',
	c_clturEvent varchar2(1000 char) default ON NULL '미제공',
	c_doNm varchar2(1000 char) default ON NULL '미제공',
	c_sigunguNm varchar2(1000 char) default ON NULL '미제공',
	c_exprnProgrm varchar2(1000 char) default ON NULL '미제공',
	c_facltNm varchar2(1000 char) default ON NULL '미제공',
	c_firstImageUrl varchar2(1000 char) default ON NULL '#',
	c_glampInnerFclty varchar2(1000 char) default ON NULL '미제공',
	c_glampSiteCo varchar2(1000 char) default ON NULL '0',
	c_gnrlSiteCo varchar2(1000 char) default ON NULL '0',
	c_homepage varchar2(1000 char) default ON NULL '#',
	c_insrncAt varchar2(1000 char) default ON NULL 'N',
	c_intro varchar2(1000 char) default ON NULL '미제공',
	c_lineIntro varchar2(1000 char) default ON NULL '미제공',
	c_mapX varchar2(1000 char) default ON NULL '0',
	c_mapY varchar2(1000 char) default ON NULL '0',
	c_operDeCl varchar2(1000 char) default ON NULL '미제공',
	c_operPdCl varchar2(1000 char) default ON NULL '미제공',
	c_posblFcltyCl varchar2(1000 char) default ON NULL '미제공',
	c_resveCl varchar2(1000 char) default ON NULL '미제공',
	c_resveUrl varchar2(1000 char) default ON NULL '#',
	c_sbrsCl varchar2(1000 char) default ON NULL '미제공',
	c_tel varchar2(1000 char) default ON NULL '미제공',
	c_themaEnvrnCl varchar2(1000 char) default ON NULL '미제공',
	c_toiletCo varchar2(1000 char) default ON NULL '0',
	c_wtrplCo varchar2(1000 char) default ON NULL '0',
	c_tooltip varchar2(1000 char) default ON NULL '미제공'
);

drop table camping_site

create sequence camping_site_seq

drop sequence camping_site_seq

select * from camping_site
select c_lineIntro from camping_site where c_no = 13281

select count(*) from camping_site;


----- 캠핑장 리뷰
create table campingSite_review(
	-- pk
	cr_no number(7) primary key,
	-- 게시글 pk
	cr_campingSiteNo number(7) not null,
	-- 리뷰 작성자
	cr_author varchar2(20 char) not null,
	-- 리뷰 제목
	cr_title varchar2(30 char) not null,
	-- 리뷰 별점
	cr_star varchar2(4 char) not null,
	-- 리뷰 내용
	cr_content varchar2(100 char) not null,
	-- 리뷰 작성 시간
	cr_date date not null
);

drop table campingSite_review;

create sequence campingSite_review_seq;

insert into campingSite_review values(campingSite_review_seq.nextval, 13268, 'test2', '테스트 제목', '5.0', '테스트 내용입니다 너무 즐거워요!!', sysdate);
insert into campingSite_review values(campingSite_review_seq.nextval, 13268, 'test', '테스트 제목2', '4.5', '테스트 내용2입니다 너무 좋아요!!', sysdate);

select * from campingSite_review;

SELECT CR_NO, CR_CAMPINGSITENO, CR_AUTHOR, CR_TITLE, CR_STAR, CR_CONTENT, CR_DATE
from CAMPING_SITE, CAMPINGSITE_REVIEW
WHERE CAMPING_SITE.C_NO = CAMPINGSITE_REVIEW.CR_CAMPINGSITENO 
AND CR_CAMPINGSITENO = 13268

-- 조회수
-- 컨셉 : 조회수 기준은 비로그인 - 로그인 상관 없음. 바로 1 올려주기. 다만 재요청시만 제어
create table campingSite_view(
	-- 조회수 테이블 pk
	cv_no number(7) primary key,
	-- 조회한 사이트 넘버
	cv_siteNo number(7) not null,
	-- 조회수
	cv_viewCount number(7)
);

select * from campingSite_view
insert into campingSite_view values(campingSite_view_seq.nextval, 13268, 8);
drop table campingSite_view
create sequence campingSite_view_seq;
drop sequence campingSite_view_seq;

-- 캠핑 사이트 좋아요 
create table campingSite_like(
	-- 캠핑 기본키
	cl_no number(7) primary key,
	
	-- 좋아요 누른 유저 id
	cl_userId varchar2(20 char) not null,
	
	-- 좋아요 누른 사이트 no
	cl_siteNo number(7) not null
);

create sequence campingSite_like_seq;

select * from campingSite_like;

insert into campingSite_like values(campingSite_like_seq.nextval, 'test', 13268);