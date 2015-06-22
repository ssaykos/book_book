--책 리스트--
create table book(
serial_no		varchar(10), -- 책식별번호 --
b_title			varchar(40), -- 책이름 --
author			varchar(20), -- 책저자 --
publisher		varchar(20), -- 출판사 --
b_group			varchar(40), -- 책분류 --
press_date		date, -- 출판일 --
entrada			date  -- 입고일 --
);
commit;
