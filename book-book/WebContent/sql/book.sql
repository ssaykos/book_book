drop table admin ;
create table admin (
    admin    number default 0 ,  
    constraint admin_pk primary key( admin )
);


insert into admin ( admin )
values(0);

insert into admin ( admin )
values(1);

drop table member ;
create table member (
    id       varchar2(15 ) default 'NULL' ,
    pass       varchar2 ( 15 ) default 'NULL' ,
    name     varchar2(20 ) default 'NULL' ,
    email      varchar2 ( 30 ) default 'NULL' ,
    sent       number        default 0 ,
    ph         number       default 0 ,
    gender     number         default 0,
    birth      date           default sysdate,
    address    varchar2 ( 50 ) default 'NULL' ,      
    admin    number       default 0,   
    constraint id_pk primary key(id),
    constraint admin_fk foreign key( admin )
    references admin(admin )
);


insert into member ( id, pass, name, email, sent , ph, gender, birth , address, admin )
values('ABC110', 'ABC110' , '운영자' , 'ABC110@naver.com' , 0 , 01042342412 , 0 , '1990-01-20' , '서울시' , 1 );

insert into member
values('ABC111', 'ABC111' , '운영순' , 'ABC111@naver.com' , 0 , 01089594890 , 1 , '1980-02-02' , '서울시' , 1 );

insert into member
values('ABC112', 'ABC112' , '김길동' , 'ABC112@naver.com' , 1 , 01034535434 , 0 , '1960-05-05' , '인천시' , 0 );

insert into member
values('ABC113', 'ABC113' , '박길동' , 'ABC113@naver.com' , 1 , 01045234235 , 0 , '1990-01-20' , '대구시' , 0 );

insert into member
values('ABC114', 'ABC114' , '뭐길동' , 'ABC114@naver.com' , 0 ,0107866584 , 1 , '1990-01-20' , '경기시' , 0 );

insert into member
values('ABC115', 'ABC115' , '김탱구' , 'ABC115@naver.com' , 1 ,01042342410 , 0 ,'1970-01-20' ,'인천시', 0 );

insert into member
values('ABC116', 'ABC116' , '장동건' , 'ABC116@naver.com' , 0 ,01042342412 , 0 ,'1980-01-20' ,'대구시', 0 );

insert into member
values('ABC117', 'ABC117' , '김태희' , 'ABC117@naver.com' , 1 ,01042342412 , 1 ,'1990-01-20' ,'부산시', 0 );

insert into member
values('ABC118', 'ABC118' , '원빈' , 'ABC118@naver.com' , 0 , 01042342412 , 0 , '1990-01-20' , '서울시' , 0 );

insert into member
values('ABC119', 'ABC119' , '홍길동' , 'ABC119@naver.com' , 0 ,01042342412 , 0 ,'1990-01-20' ,'인천시', '0' );

insert into member
values('ABC120', 'ABC120' , '송혜교' , 'ABC120@naver.com' , 0 ,01042342412 , 1 ,'1990-01-20' ,'서울시', '0' );

-- 블린 표시 0이 운영자 아님, 이메일 수신거부, 남성 표시입니니다.
 

drop table board ;
CREATE table BOARD (
    BOARD_CATE_NUM NUMBER default 0,
    BOARD_CATE_NAME VARCHAR2 ( 20 ) default 'NULL' ,
    constraint BOARD_PK primary key( BOARD_CATE_NUM)
);
insert into BOARD
values(1, '공지사항' );

insert into BOARD
values(2, '자유게시판' );


drop sequence SEQ_ARTICLE ;
CREATE SEQUENCE SEQ_ARTICLE
START WITH 1
INCREMENT BY 1 ;

drop table ARTICLE ;
create table ARTICLE (
    SEQ_ARTICLE NUMBER default 0,
    ID VARCHAR2( 15 ) default 'NULL' ,
    TITLE VARCHAR2 ( 200 ) default 'NULL' ,
    CONTENT VARCHAR2( 2000 ) default 'NULL' ,
    POSTING_DATE DATE default sysdate,
    CATEGORY VARCHAR2(20 ) default 'NULL' ,
    READ_COUNT NUMBER default 0,
    FILE_SRC VARCHAR2 ( 200 ) default 'NULL' ,
    BOARD_CATE_NUM NUMBER default 0,
    constraint ARTICLE_PK primary key( SEQ_ARTICLE),
    constraint ARTICLE_FK_BOARD foreign key( BOARD_CATE_NUM) references BOARD ( BOARD_CATE_NUM ),
    constraint ARTICLE_FK_MEMBER foreign key( ID) references MEMBER (ID)
);


insert into ARTICLE ( SEQ_ARTICLE , ID, TITLE , CONTENT, POSTING_DATE, CATEGORY, READ_COUNT, FILE_SRC , BOARD_CATE_NUM )
values(SEQ_ARTICLE.nextval, 'ABC111' , '청산별곡' , '살어리 살어리랏다. / 청산(靑山)애 살어리랏다.' , '2015-06-26' , '고전문학' , '10' , 'C:\Users\공지사항\고전문학' , 1 );

insert into ARTICLE ( SEQ_ARTICLE , ID, TITLE , CONTENT, POSTING_DATE, CATEGORY, READ_COUNT, FILE_SRC , BOARD_CATE_NUM )
values(SEQ_ARTICLE.nextval, 'ABC112' , '사미인곡' , '엊그제 님을 뫼셔 廣寒殿(광한전)의 올낫더니 / 그 더ㄷㆎ 엇디ㅎㆍ야 下界(하계)에 ㄴㆍ려오니' , '2015-06-26', '고전문학' , '13', 'C:\Users\공지사항\고전문학' , 1 );

insert into ARTICLE ( SEQ_ARTICLE , ID, TITLE , CONTENT, POSTING_DATE, CATEGORY, READ_COUNT, FILE_SRC , BOARD_CATE_NUM )
values(SEQ_ARTICLE.nextval, 'ABC113' , '동백꽃' , '나는 눈물을 우선 씻고 뭘 안 그러는지 명색도 모르건만' , '2015-06-26' , '현대문학' , '5' , 'C:\Users\공지사항\현대문학' , 1 );

insert into ARTICLE ( SEQ_ARTICLE , ID, TITLE , CONTENT, POSTING_DATE, CATEGORY, READ_COUNT, FILE_SRC , BOARD_CATE_NUM )
values(SEQ_ARTICLE.nextval, 'ABC113' , '중2병의 뜻' , '중학교 2학년 나이 또래의 청소년들이 사춘기 자아 형성 과정에서 겪는 혼란이나 불만과 같은 심리적 상태, 또는 그로 말미암은 반항과 일탈 행위를 일컫는다.' , '2015-06-26' , '상식', '10' , 'C:\Users\자유게시판\상식' , 2 );

insert into ARTICLE ( SEQ_ARTICLE , ID, TITLE , CONTENT, POSTING_DATE, CATEGORY, READ_COUNT, FILE_SRC , BOARD_CATE_NUM )
values(SEQ_ARTICLE.nextval, 'ABC114' , '사미인곡' , '중학교 2학년 나이 또래의 청소년들이 사춘기 자아 형성 과정에서 겪는 혼란이나 불만과 같은 심리적 상태, 또는 그로 말미암은 반항과 일탈 행위를 일컫는다.' , '2015-06-26' , '상식', '15' , 'C:\Users\자유게시판\상식' , 2 );

insert into ARTICLE ( SEQ_ARTICLE , ID, TITLE , CONTENT, POSTING_DATE, CATEGORY, READ_COUNT, FILE_SRC , BOARD_CATE_NUM )
values(SEQ_ARTICLE.nextval, 'ABC115' , '훈민정음해례본' , '나랏말싸미 듕귁에 달아 / 문자와로 서르 사맛디 아니할쎄' , '2015-06-26' , '상식' , '20' , 'C:\Users\자유게시판\상식' , 2 );

insert into ARTICLE ( SEQ_ARTICLE , ID, TITLE , CONTENT, POSTING_DATE, CATEGORY, READ_COUNT, FILE_SRC , BOARD_CATE_NUM )
values(SEQ_ARTICLE.nextval, 'ABC116' , '오감도(烏瞰圖)' , '13인의아해(兒孩)가도로로질주하오. / (길은막다른골목이적당하오)' , '2015-06-26' ,      '현대시' , '13' , 'C:\Users\공지사항\현대시' , 1 );

insert into ARTICLE ( SEQ_ARTICLE , ID, TITLE , CONTENT, POSTING_DATE, CATEGORY, READ_COUNT, FILE_SRC , BOARD_CATE_NUM )
values(SEQ_ARTICLE.nextval, 'ABC116' , '빈집' , '장님처럼 나 이제 더듬거리며 문을 잠그네 / 가엾은 내 사랑 빈집에 갇혔네', '2015-06-26', '현대시' , '25' , 'C:\Users\공지사항\현대시' , 1 );

insert into ARTICLE ( SEQ_ARTICLE , ID, TITLE , CONTENT, POSTING_DATE, CATEGORY, READ_COUNT, FILE_SRC , BOARD_CATE_NUM )
values(SEQ_ARTICLE.nextval, 'ABC117' , '그리스 협상 막판 충돌...디폴트 우려 고조', '유럽은 물론 세계가 주목하고 있는 그리스 구제금융 협상이 부채 상환 시한을 이틀 앞두고 파국을 맞았습니다.', '2015-06-27', '시사' , '30' , 'C:\Users\자유게시판\시사' , 2 );

insert into ARTICLE ( SEQ_ARTICLE , ID, TITLE , CONTENT, POSTING_DATE, CATEGORY, READ_COUNT, FILE_SRC , BOARD_CATE_NUM )
values(SEQ_ARTICLE.nextval, 'ABC118' , '모란이 피기까지는 ' , '모란이 피기까지는, 나는 아직 나의 봄을 기다리고 있을 테요.' , '2015-06-27' , '현대시' , '25' , 'C:\Users\공지사항\현대시' , 2 );

insert into ARTICLE ( SEQ_ARTICLE , ID, TITLE , CONTENT, POSTING_DATE, CATEGORY, READ_COUNT, FILE_SRC , BOARD_CATE_NUM )
values(SEQ_ARTICLE.nextval, 'ABC119' , '유승민 사퇴 압박…축출이냐 사수냐, 친박-비박 29일부터 정면충돌 ' , '유승민 원내대표의 사퇴와 사수를 놓고 친박(친 박근혜)과 비박간의 정면 충돌이 임박했다. ' , '2015-06-28' , '시사' , '25' , 'C:\Users\자유게시판\시사' , 2 );

insert into ARTICLE ( SEQ_ARTICLE , ID, TITLE , CONTENT, POSTING_DATE, CATEGORY, READ_COUNT, FILE_SRC , BOARD_CATE_NUM )
values(SEQ_ARTICLE.nextval, 'ABC120' , '시문학파' , '시전문지 《시문학(詩文學)》을 중심으로 순수시 운동을 주도하였던 시인들.', '2015-06-28', '상식' , '25', 'C:\Users\자유게시판\상식' , 2 );



drop table seat ;
create table seat (
    SEAT_NO VARCHAR2 ( 5) default 'NULL' ,
    constraint SEAT_NO_pk primary key( SEAT_NO)
);
insert into seat
values('S001');
insert into seat
values('S002');
insert into seat
values('S003');
insert into seat
values('S004');
insert into seat
values('S005');
insert into seat
values('S006');
insert into seat
values('S007');
insert into seat
values('S008');
insert into seat
values('S009');
insert into seat
values('S010');

drop table reservation ;
create table reservation (
    RES_NO VARCHAR2 ( 10) default 'NULL' ,
    SEAT_NO VARCHAR2 ( 10) default 'NULL' ,
    ID VARCHAR( 15 ) default 'NULL' ,
    r_date date default sysdate,
    constraint RES_NO_pk primary key( RES_NO),
    constraint SEAT_NO_fk foreign key( SEAT_NO)
    references SEAT( SEAT_NO ),
    constraint ID_fk foreign key(ID)
    references MEMBER(ID)
);

insert into reservation(res_no, seat_no, id, r_date) values(
	'AA0001', 'S001', 'ABC111', sysdate 
);
insert into reservation(res_no, seat_no, id, r_date) values(
	'AA0002', 'S002', 'ABC112', sysdate 
);
insert into reservation(res_no, seat_no, id, r_date) values(
	'AA0003', 'S003', 'ABC113', sysdate 
);
insert into reservation(res_no, seat_no, id, r_date) values(
	'AA0004', 'S004', 'ABC114', sysdate 
);
insert into reservation(res_no, seat_no, id, r_date) values(
	'AA0005', 'S005', 'ABC115', sysdate 
);
insert into reservation(res_no, seat_no, id, r_date) values(
	'AA0006', 'S006', 'ABC116', sysdate 
);
insert into reservation(res_no, seat_no, id, r_date) values(
	'AA0007', 'S007', 'ABC117', sysdate 
);
insert into reservation(res_no, seat_no, id, r_date) values(
	'AA0008', 'S008', 'ABC118', sysdate 
);
insert into reservation(res_no, seat_no, id, r_date) values(
	'AA0009', 'S009', 'ABC119', sysdate 
);
insert into reservation(res_no, seat_no, id, r_date) values(
	'AA0010', 'S010', 'ABC120', sysdate 
);







drop table PUBLISHER ;
create table PUBLISHER (
    publisher         varchar2( 30) default 'NULL' ,
    constraint publisher_pk primary key( publisher )
);
insert into PUBLISHER values( '더클래식' );
insert into PUBLISHER values( '숲과나무' );
insert into PUBLISHER values( '한빛미디어' );
insert into PUBLISHER values( '지학사' );
insert into PUBLISHER values( '교학사' );
insert into PUBLISHER values( '헤커스어학연구소' );
insert into PUBLISHER values( '웅진씽크빅' );
insert into PUBLISHER values( '천재교육' );
insert into PUBLISHER values( '와이비엠' );
insert into PUBLISHER values( '천상천하유아독존' );

drop table book_group ;
create table BOOK_GROUP (
    book_group_code         varchar2( 6) default 'NULL' ,
    book_group_value        varchar2 ( 45 ) default 'NULL' ,
    constraint book_group_code_pk primary key ( book_group_code)
);
insert into BOOK_GROUP values( '010101' , '소설/고전소설/한국고전소설' );
insert into BOOK_GROUP values( '010102' , '소설/고전소설/일본고전소설' );
insert into BOOK_GROUP values( '010103' , '소설/고전소설/중국고전소설' );
insert into BOOK_GROUP values( '010104' , '소설/고전소설/러시아고전소설' );
insert into BOOK_GROUP values( '010201' , '소설/세계소설/미국소설' );
insert into BOOK_GROUP values( '010202' , '소설/세계소설/일본소설' );
insert into BOOK_GROUP values( '010203' , '소설/세계소설/중국소설' );
insert into BOOK_GROUP values( '010204' , '소설/세계소설/러시아소설' );
insert into BOOK_GROUP values( '010301' , '소설/추리소설/한국추리소설' );
insert into BOOK_GROUP values( '010401' , '소설/테마소설/로맨스소설' );

drop table KDC ;
create table KDC (
    KDC_code                varchar2( 10) default 'NULL' ,
    KDC_value               varchar2( 45) default 'NULL' ,
    constraint KDC_code_pk primary key ( KDC_code )
);
insert into KDC values( '800' , '문학/문학일반' );
insert into KDC values( '810' , '문학/한국문학' );
insert into KDC values( '820' , '문학/중국문학' );
insert into KDC values( '830' , '문학/일본문학' );
insert into KDC values( '840' , '문학/영미문학' );
insert into KDC values( '850' , '문학/독일문학' );
insert into KDC values( '811' , '문학/문학일반' );

drop table BOOK ;
create table BOOK (
    book_title         varchar2( 100) default 'NULL' ,
    author             varchar2( 100) default 'NULL' ,
    img_addr           varchar2( 255) default 'NULL' ,
    press_day          date default sysdate,
    entrada            date default sysdate,
    book_serial_no     varchar2 ( 10 ) default 'NULL' ,
    publisher         varchar2( 30) default 'NULL' ,
    book_group_code varchar2 ( 45 ) default 'NULL' ,
    KDC_code           varchar2( 10) default 'NULL' ,
    constraint book_serial_no_pk primary key( book_serial_no),
    constraint publisher_fk foreign key( publisher )
        references PUBLISHER ( publisher ),
    constraint book_group_code_fk foreign key( book_group_code)
        references BOOK_GROUP ( book_group_code ),
    constraint KDC_code_fk foreign key( KDC_code)
        references KDC ( KDC_code )
);

insert into book ( book_title , author , img_addr , press_day , entrada , book_serial_no , publisher ,
    book_group_code , kdc_code )
    values ('책1' , '김작가' , 'book_test.png' , sysdate, sysdate, '0101010001' , '더클래식' , '010101' , '800' );
insert into book ( book_title , author , img_addr , press_day , entrada , book_serial_no , publisher ,
    book_group_code , kdc_code )
    values ('책2' , '이작가' , 'book_test.png' , sysdate, sysdate, '0101010002' , '더클래식' , '010101' , '810' );
insert into book ( book_title , author , img_addr , press_day , entrada , book_serial_no , publisher ,
    book_group_code , kdc_code )
    values ('책3' , '신작가' , 'book_test.png' , sysdate, sysdate, '0101010003' , '더클래식' , '010101' , '820' );
insert into book ( book_title , author , img_addr , press_day , entrada , book_serial_no , publisher ,
    book_group_code , kdc_code )
    values ('책4' , '안작가' , 'book_test.png' , sysdate, sysdate, '0101010004' , '더클래식' , '010101' , '830' );
insert into book ( book_title , author , img_addr , press_day , entrada , book_serial_no , publisher ,
    book_group_code , kdc_code )
    values ('책5' , '윤작가' , 'book_test.png' , sysdate, sysdate, '0101010005' , '더클래식' , '010101' , '840' );
insert into book ( book_title , author , img_addr , press_day , entrada , book_serial_no , publisher ,
    book_group_code , kdc_code )
    values ('책6' , '최작가' , 'book_test.png' , sysdate, sysdate, '0101010006' , '더클래식' , '010101' , '840' );
insert into book ( book_title , author , img_addr , press_day , entrada , book_serial_no , publisher ,
    book_group_code , kdc_code )
    values ('책7' , '황작가' , 'book_test.png' , sysdate, sysdate, '0101010007' , '더클래식' , '010101' , '850' );
insert into book ( book_title , author , img_addr , press_day , entrada , book_serial_no , publisher ,
    book_group_code , kdc_code )
    values ('책8' , '임작가' , 'book_test.png' , sysdate, sysdate, '0101010008' , '더클래식' , '010101' , '810' );
insert into book ( book_title , author , img_addr , press_day , entrada , book_serial_no , publisher ,
    book_group_code , kdc_code )
    values ('책9' , '전작가' , 'book_test.png' , sysdate, sysdate, '0101010009' , '더클래식' , '010101' , '850' );
insert into book ( book_title , author , img_addr , press_day , entrada , book_serial_no , publisher ,
    book_group_code , kdc_code )
    values ('책10' , '하작가' , 'book_test.png' , sysdate, sysdate, '0101010010' , '더클래식' , '010101' , '820' );


drop table STATE ;
create table STATE (
    state             number default 0 ,
    constraint state_pk primary key( state )
);
insert into state ( state )
    values(1 );
insert into state ( state )
    values(2 );
insert into state ( state )
    values(3 );


drop table RENT ;
create table RENT (
    proc_date          date default sysdate,
    book_serial_no     varchar2 ( 10 ) default 'NULL' ,
    state             number default 0 ,
    id              varchar2(15 )default 'NULL' ,
    constraint book_serial_no_fk foreign key( book_serial_no)
        references BOOK ( book_serial_no ),
    constraint rent_id_fk foreign key(id)
        references MEMBER (id),
    constraint state_fk foreign key( state )
        references STATE ( state )
);
--insert into 테이블명()
--values('');


insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010001', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010001', 2, 'ABC111' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010001', 1, 'ABC112' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010001', 3, 'ABC113' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010001', 1, 'ABC114' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010001', 2, 'ABC115' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010001', 1, 'ABC116' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010001', 3, 'ABC117' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010001', 1, 'ABC118' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010001', 3, 'ABC119' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010001', 1, 'ABC120' );


insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010003', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010002', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010004', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010002', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010003', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010004', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010004', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010005', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010002', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010005', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010004', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010004', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010005', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010005', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010003', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010002', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010005', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010004', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010006', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010005', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010006', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010002', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010004', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010003', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010004', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010006', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010006', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010006', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010002', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010004', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010007', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010004', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010005', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010006', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010002', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010003', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010004', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010004', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010006', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010006', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010008', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010010', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010010', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010004', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010003', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010005', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010005', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010003', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010006', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010005', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010004', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010008', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010004', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010003', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010008', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010005', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010003', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010009', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010006', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010005', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010004', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010005', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010003', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010008', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010009', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010006', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010004', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010006', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010005', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010009', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010008', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010004', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010003', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010004', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010010', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010009', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010004', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010003', 1, 'ABC110' );
insert into rent ( proc_date , book_serial_no , state, id)
    values(sysdate, '0101010002', 1, 'ABC110' );

    
    

drop sequence seq_stat ;
create sequence seq_stat
    start with 1
    increment by 1;


drop table rent_stat ;
create table rent_stat (
    stat_no number constraint stat_no_pk primary key,
    reg_date date default sysdate
);

drop table rent_stat_by_age ;
create table rent_stat_by_age (
    stat_no number constraint
    stat_no_fk references rent_stat ( stat_no ),
    age_grp varchar2 (10 ) default 'NULL' ,
    rank number default 0,
    rent_cnt number default 0,
    book_serial_no varchar2 (10 )
    constraint stat_serial_no_fk
    references book( book_serial_no )
);

drop table rent_stat_by_cat ;
create table rent_stat_by_cat (
    stat_no number
    constraint rent_stat_no_fk references rent_stat ( stat_no ),
    rank number default 0,
    rent_cnt number default 0,
    book_serial_no varchar2 (10 )
    constraint rent_stat_serial_no_fk references book ( book_serial_no ),
    cat_all varchar2( 3 ) default 'NO'
);


create or replace procedure gather_rent_stat_by_cat ( stat_date in date, p_book_group_code in book_group.book_group_code %type, cat_all in boolean default false)
as
    seq number := seq_stat.nextval ;
    statRecord number := 0;
    fetched boolean := false;
begin
    insert into rent_stat( stat_no, reg_date ) values ( seq, stat_date );
    if cat_all = true then
        for i in (     
            select
                rownum rnk,
                a.book_serial_no ,
                a.rent_cnt
            from
                (
                  select
                        book_serial_no ,
                        count(*) rent_cnt
                    from
                        rent
                    where
                        state = 1
                        and trunc( proc_date, 'MM') = trunc(sysdate, 'MM')
                        and rownum <= 25
                    group by
                        book_serial_no
                    order by
                        2 desc
                )a
        ) loop
            fetched := true;
            insert into rent_stat_by_cat ( stat_no , rank, rent_cnt , book_serial_no, cat_all)
                values ( seq, i.rnk, i.rent_cnt , i.book_serial_no , 'YES');
        end loop;
    else
        for i in (
           select
               rownum rnk,
               a.book_serial_no ,
               a.rent_cnt
           from
               (
                   select
                       rent.book_serial_no,
                       count(*) rent_cnt
                   from
                       rent
                       join book on book.book_serial_no = rent.book_serial_no
                       join book_group book_grp on book_grp.book_group_code = book.book_group_code
                   where
                       rent.state = 1
                       and trunc( rent.proc_date , 'MM') = trunc(stat_date, 'MM' )
                       and book_grp.book_group_code = p_book_group_code
                       and rownum <= 25
                   group by
                       rent.book_serial_no, book.book_title
                   order by
                       2 desc
               )a
        ) loop
            fetched := true;
            insert into rent_stat_by_cat ( stat_no , rank, rent_cnt , book_serial_no, cat_all)
                values ( seq, i.rnk, i.rent_cnt , i.book_serial_no , 'NO');
        end loop;
    end if;
    if fetched <> true then
        rollback;
    else
        commit;
    end if;
end;
/


create or replace procedure gather_rent_stat_by_age_group ( stat_date in date, age_grp in rent_stat_by_age.age_grp%type)
as
    seq number := seq_stat.nextval ;
    fetched boolean := false;
begin 
    insert into rent_stat( stat_no, reg_date ) values ( seq, stat_date );
  
    if age_grp = 'ALL' then
        for i in (
            select
                rownum rnk,
                a.book_serial_no ,
                a.rent_cnt
            from
                (
                    select
                        rent.book_serial_no,
                        count(*) rent_cnt
                    from
                        rent
                        join member mem on rent.id = mem.id
                    where
                        rent.state = 1
                        and trunc( rent.proc_date , 'MM') = trunc(stat_date, 'MM' )
                        and rownum <= 10
                    group by
                        rent.book_serial_no
                    order by
                        2 desc
                )a        
        ) loop
            fetched := true;
            insert into rent_stat_by_age ( stat_no , age_grp , rank, rent_cnt, book_serial_no)
                values(seq, age_grp, i.rnk, i.rent_cnt , i.book_serial_no);
        end loop;
    else
        for i in (
            select
                rownum rnk,
                a.book_serial_no ,
                a.rent_cnt
            from
                (
                    select
                        rent.book_serial_no,
                        count(*) rent_cnt
                    from
                        rent
                        join member mem on rent.id = mem.id
                    where
                        rent.state = 1
                        and trunc( rent.proc_date , 'MM') = trunc(stat_date, 'MM' )
                        and trunc( ( to_number(to_char(sysdate, 'yyyy' )) - to_number(to_char( birth, 'yyyy')) ), -1 ) = to_number( age_grp)
                        and rownum <= 10
                    group by
                        rent.book_serial_no
                    order by
                        2 desc
                )a
        ) loop
            fetched := true;
            insert into rent_stat_by_age ( stat_no , age_grp , rank, rent_cnt, book_serial_no)
                values(seq, age_grp, i.rnk, i.rent_cnt , i.book_serial_no);
        end loop;
    end if;
    if fetched <> true then
        rollback;
    else
        commit;
    end if;
end;
/


create or replace procedure gather_rent_stats
as
    l_stat_date date := sysdate;
    l_age_grp rent_stat_by_age.age_grp%type;
begin
    for i in (
        select book_group_code from book_group
    ) loop
        gather_rent_stat_by_cat(
            stat_date => l_stat_date,
            p_book_group_code => i.book_group_code,
            cat_all => false);
    end loop;
    gather_rent_stat_by_cat(
        stat_date => l_stat_date,
        p_book_group_code => null,
        cat_all => true);
    for i in 1..6 loop
        l_age_grp := to_char(i * 10 );
        gather_rent_stat_by_age_group(
            stat_date => l_stat_date,
            age_grp => l_age_grp);
    end loop;
    gather_rent_stat_by_age_group(
            stat_date => l_stat_date,
            age_grp => 'ALL' );
end;
/  




begin
    dbms_scheduler.drop_job(
        job_name => 'COLLECT_BOOK_RENT_STAT' ,
        force => true
    );
    exception
        when others then
            null;
end;
/

begin
    dbms_scheduler.create_job(
        job_name => 'COLLECT_BOOK_RENT_STAT' ,
        job_type => 'STORED_PROCEDURE' ,
        job_action => 'BOOK.GATHER_RENT_STATS' ,
        start_date => sysdate,
        repeat_interval => 'FREQ=MONTHLY; INTERVAL=1' ,
        enabled => true,
        auto_drop => false,
        comments => '도서 대여 순위 구하기'
    );
end;
/

