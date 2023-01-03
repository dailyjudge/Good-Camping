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