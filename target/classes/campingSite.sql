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

select * from account, camping
create sequence campingSite_like_seq;

delete campingSite_like

select * from campingSite_like;

insert into campingSite_like values(campingSite_like_seq.nextval, 'test3', 17191);

select * from campingSite_like
where cl_siteno = 17191

delete campingSite_like where cl_siteno = 17191
-- 사이트 정보를 조회수 순으로 나오게끔!
select *
from camping_site, campingSite_view
where c_no left outer join cv_siteNo

SELECT * 
FROM camping_site, campingSite_view ;

select * from campingSite_view


create sequence cv_count_seq

select * from camping_site
where c_addr1 like '%강원도%'

select * 
from ( select *
		from camping_site left outer join campingSite_view
		on c_no = cv_siteNo
		where cv_viewcount is not null
		and c_donm like '%제주%'
		order by cv_viewcount desc
	 )
where rownum <= 10;

-- dailyjudge
-- 

select count(*)
from
(select camping_site.*, nvl(cv_viewcount, 0) as cv_viewcount, nvl(likecount, 0) as likecount
	from (camping_site left outer join campingSite_view
	on c_no = cv_siteNo) left outer join (select cl_siteno, count(cl_siteno) as likecount
							from campingSite_like
							group by cl_siteno)
						on c_no = cl_siteno
	
order by cv_viewcount desc, likecount desc)

-- campingSite_view > cv_no, cv_siteNo, cv_viewCount
-- campingSite_like > cl_no, cl_userId, cl_siteNo
-- campingSite_review > cr_no, cr_campingSiteNo, cr_author, cr_title, cr_star, cr_content, cr_date

select camping_site.*, nvl(cv_viewcount, 0) as cv_viewcount, nvl(siteLikeCount, 0) as siteLikeCount, nvl(reviewcount, 0) as reviewcount
from (camping_site left outer join campingSite_view
	  on c_no = cv_siteNo) 
	  left outer join 
	  (select cl_siteno, count(cl_siteno) as siteLikeCount
	   from campingSite_like
	   group by cl_siteno)
	   on c_no = cl_siteno
	   left outer join
	  (select cr_campingSiteno, count(cr_campingSiteno) as reviewcount
	   from campingSite_review
	   group by cr_campingSiteNo
		)
	  on cl_siteno = cr_campingSiteno
order by cv_viewcount desc, siteLikeCount desc, reviewcount desc


select cl_siteno, count(cl_siteno)
from campingSite_like
group by cl_siteno

select count(*), cl_userid, cl_siteno from campingSite_like
group by cl_userid, cl_siteno
order by count(*) desc

select * from campingSite_like
where cl_userid = 'test' and cl_siteno = 17371

select * from campingSite_like
delete campingSite_like where cl_no = 325

select count(c_no), c_no from camping_Site

select count(*)
	from (camping_site left outer join campingSite_view
	on c_no = cv_siteNo), (select count(*) as likeCount
					from camping_site left outer join campingSite_like
					on c_no = cl_siteno
					group by c_no)
order by cv_viewcount desc, likecount desc

select * 
from (camping_site left outer join campingSite_view on c_no = cv_siteNo)







select count(*) from campingSite_view where cv_siteNo = 17191

-- 데이터 넣기
insert into campingSite_view values(campingSite_view_seq.nextval, 17152, 8);

-- 19300 17841
-- 가데이터 조회
select * from camping_site where c_donm like '%대구%' order by c_no
-- 16588 16688 16703 16704 16745 16853 16931 16942 16997 17152

-- 에러잡기용
select count(*) as count, cv_siteno from campingSite_view
group by cv_siteno
order by count desc

-- 에러 삭제
delete campingSite_view where cv_siteno = 18824

-- 유저가 좋아요 누른 사이트 정보 받아오기
select camping_site.*
from account, camping_site, campingSite_like
where ac_id = cl_userId and cl_siteNo = c_no
and ac_id = 'test'

select * from campingSite_like

-- 사이트 정보에 따른 리뷰 체크
select avg(cr_star) 
from camping_site, campingSite_review
where c_no = cr_campingSiteNo and c_no = 17362

select round(avg(cr_star), 2)
from camping_site, campingSite_review
where c_no = cr_campingSiteNo and c_no = 17851


select * from camping_site, campingSite_view
where c_no = cv_siteNo



select camping_site.*, NVL(cv_viewcount, 0) as cv_viewcount, NVL(siteLikeCount, 0) as siteLikeCount, NVL(reviewCount, 0) as reviewCount
	from (camping_site left outer join campingSite_view
	 	  on c_no = cv_siteNo) 
	  	left outer join 
	  (select cl_siteno, count(cl_siteno) as siteLikeCount
	   from campingSite_like
	   group by cl_siteno)
	   on c_no = cl_siteno
	   left outer join
	  (select cr_campingSiteno, count(cr_campingSiteno) as reviewCount
	   from campingSite_review
	   group by cr_campingSiteNo)
	  on cl_siteno = cr_campingSiteno
where c_donm like '%충청북도%' and ROWNUM <= 10
