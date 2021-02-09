CREATE TABLE MEMBERS (

	id VARCHAR2(20) PRIMARY KEY,
	passwd VARCHAR2(20),
	name VARCHAR2(20),
	phone1 VARCHAR2(20),
	phone2 VARCHAR2(20),
	phone3 VARCHAR2(20),
	sex VARCHAR2(20),
	blood VARCHAR2(20),
	hobby VARCHAR2(50),
	city VARCHAR2(50),
	info VARCHAR2(1000)
);


insert into members (id,passwd,name) values ('tiger','1234','È«±æµ¿');
insert into members (id,passwd,name) values ('kim','1234','±èÀ¯½Å');
insert into members (id,passwd,name) values ('lee','1234','ÀÌ¼ø½Å');
commit;

select * from members;

select * from members where id = 'kim';

desc members;
