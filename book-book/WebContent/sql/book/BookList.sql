--책 리스트--
create table book(
serial_no		varchar2(10) primary key, -- 책식별번호 --
b_title			varchar2(100) not null, -- 책이름 --
author			varchar2(100) not null, -- 책저자 --
publisher		varchar2(30) not null, -- 출판사 --
b_group			varchar2(42) not null, -- 책분류 --
b_picture		varchar2(255) not null,
press_date		date not null, -- 출판일 --
entrada			date not null,  -- 입고일 --
);
commit;
--alter table book
--add constraint book_pk primary key(serial_no);
--commit;
