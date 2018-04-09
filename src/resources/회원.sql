drop table users;

-- 사용자 정보 저장을 위한 테이블 생성
CREATE TABLE users(
     id         VARCHAR2(8),
     name       VARCHAR2(40)    NOT NULL,
     passwd     VARCHAR2(8)     NOT NULL,
     email      VARCHAR2(50)    NOT NULL,
     telephone  VARCHAR2(30),
     upddate    DATE DEFAULT sysdate NOT NULL,
     regdate    DATE DEFAULT sysdate NOT NULL
);

-- 테이블 변경을 이용한 제약사항 추가
ALTER TABLE users
  ADD(CONSTRAINT users_id_pk    PRIMARY KEY(id),
      CONSTRAINT users_email_uk UNIQUE(email));
  
desc users;

-- 테스트(Dummy) 데이터 인서트
INSERT INTO users 
            (id, 
             name, 
             passwd,
             email,
             telephone
             ) VALUES (
             'admin', 
             '관리자', 
             'admin',
             'admin@admin.com',
             '010-0000-0000'
             );

INSERT INTO users 
            (id, 
             name, 
             passwd,
             email,
             telephone
             ) VALUES (
             'jisung', 
             '박지성', 
             '1234',
             'jisung@korea.com',
             '010-1111-2222'
             );

INSERT INTO users 
            (id, 
             name, 
             passwd,
             email,
             telephone
            ) VALUES (
             'sujin', 
             '한수진', 
             '1111',
             'sujin@korea.com',
             '010-1111-2222'
            ); 

commit;

-- 전체 조회
SELECT id, 
       name, 
       passwd,
       email,
       telephone,
       TO_CHAR(regdate, 'YYYY-MM-DD DAY') regdate 
FROM   users;