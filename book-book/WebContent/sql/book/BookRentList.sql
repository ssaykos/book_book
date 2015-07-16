--책 빌린리스트
create table book_rent(
rent_id			number primary key, --거래 카운트
serial_no		varchar2(10) foreign key,--책 식별번호
rent_date		date not null,--책 대여날짜/반환날짜 통합
rent_id			varchar2(20) foreign key,--책 빌린 사람 아이디
state			number not null,--책상태값/1 = nomal(도서관에 있는것(반환 및 예약취소)) /2 = reservation(예약 들어온것) /3 = rent(도서관에 없는것)
);
commit;
