--[ 전자제품 매장 관리 프로그램 ]

--상품 정보 테이블 생성
create table com_product(
    code varchar2(10) primary key not null,
    pname varchar2(30) not null,
    price number not null
);

--판매 정보 테이블 생성
create table com_sales(
    num number primary key not null,
    inputdate date default sysdate,
    code not null REFERENCES com_product(code),
    quantity number not null
);

--판매정보 일련번호에 사용할 시퀀스 생성
create sequence com_sales_seq;
