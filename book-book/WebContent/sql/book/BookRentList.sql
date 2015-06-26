--책 빌린리스트
create table book_rent(
r_count			number primary key, 
serial_no		varchar2(10) not null,--책 식별번호
rent_date		date not null,--책 대여날짜/반환날짜 통합
rent_id			varchar2(20) not null,--책빌린사람 아이디
state			number not null,--책상태값/1 = nomal(도서관에 있는것) /2 = reservation(예약 들어온것) /3 = rent(도서관에 없는것)
);
commit;
