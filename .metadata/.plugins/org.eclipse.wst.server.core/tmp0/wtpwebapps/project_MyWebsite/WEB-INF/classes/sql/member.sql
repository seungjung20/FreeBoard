

CREATE TABLE member (
   mem_id        varchar2(100) primary key,
   mem_pass      varchar2(100),
   mem_name      varchar2(100),
   mem_mail      varchar2(100)
);

select * from member;

DROP TABLE member;

commit;