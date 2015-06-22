--책 빌린리스트
create table book_rent(
serial_no		varchar(10)--책 식별번호
rent_date		date,--책 대여날짜/반환날짜 통합
rent_id			varchar(20),--책빌린사람 아이디
state		number,--책상태값/1 = 도서관에 있는것 /2 = 예약 들어온것 /3 = 도서관에 없는것
);
commit