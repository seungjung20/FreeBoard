


create table MP_MEMBER_AUTH(
MEMBEREMAIL varchar2(100),
AUTHKEY varchar2(50)
);

alter table mp_member add member_auth number default 0;

commit;