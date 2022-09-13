CREATE SEQUENCE seq_free_board;

CREATE TABLE free_board (
   fb_no        NUMBER NOT NULL, 
   fb_title     VARCHAR2(250) NOT NULL, 
   fb_writer    VARCHAR2(100) NOT NULL,
   fb_content   CLOB,  
   fb_reg_date  DATE DEFAULT SYSDATE,
   CONSTRAINT pk_free_board PRIMARY KEY(fb_no),
   CONSTRAINT fk_fb_writer FOREIGN KEY(fb_writer) REFERENCES MEMBER (mem_id) ON DELETE CASCADE
);

ALTER TABLE free_board DROP CONSTRAINT fk_fb_writer;

desc free_board;

commit;

select * from free_board;

delete from free_board;
drop table free_board;
drop sequence seq_free_board;

insert into free_board (fb_no, fb_title, fb_writer, fb_content, fb_reg_date) 
values (seq_free_board.nextval, '테스트 제목1', 'test', '테스트 내용1', sysdate);
insert into free_board (fb_no, fb_title, fb_writer, fb_content, fb_reg_date) 
values (seq_free_board.nextval, '테스트 제목2', 'test1', '테스트 내용2', sysdate);
insert into free_board (fb_no, fb_title, fb_writer, fb_content, fb_reg_date) 
values (seq_free_board.nextval, '테스트 제목3', 'test', '테스트 내용3', sysdate);
insert into free_board (fb_no, fb_title, fb_writer, fb_content, fb_reg_date) 
values (seq_free_board.nextval, '테스트 제목4', 'test1', '테스트 내용4', sysdate);
insert into free_board (fb_no, fb_title, fb_writer, fb_content, fb_reg_date) 
values (seq_free_board.nextval, '테스트 제목5', 'test', '테스트 내용5', sysdate);
insert into free_board (fb_no, fb_title, fb_writer, fb_content, fb_reg_date) 
values (seq_free_board.nextval, '테스트 제목6', 'test1', '테스트 내용6', sysdate);
insert into free_board (fb_no, fb_title, fb_writer, fb_content, fb_reg_date) 
values (seq_free_board.nextval, '테스트 제목7', 'test', '테스트 내용7', sysdate);
insert into free_board (fb_no, fb_title, fb_writer, fb_content, fb_reg_date) 
values (seq_free_board.nextval, '테스트 제목8', 'test1', '테스트 내용8', sysdate);
insert into free_board (fb_no, fb_title, fb_writer, fb_content, fb_reg_date) 
values (seq_free_board.nextval, '테스트 제목9', 'test', '테스트 내용9', sysdate);
insert into free_board (fb_no, fb_title, fb_writer, fb_content, fb_reg_date) 
values (seq_free_board.nextval, '테스트 제목10', 'test1', '테스트 내용10', sysdate);

