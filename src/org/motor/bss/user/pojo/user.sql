-- Create table
create table M_USER
(
  userid   VARCHAR2(20) not null,
  username VARCHAR2(36) not null,
  password VARCHAR2(32) not null,
  organid  VARCHAR2(36) not null,
  job      VARCHAR2(36) not null,
  gender   CHAR(1) not null,
  birthday VARCHAR2(20) not null,
  mobile   VARCHAR2(11) not null,
  tel      VARCHAR2(13),
  qq       VARCHAR2(14),
  email    VARCHAR2(36),
  addr     VARCHAR2(100),
  party    CHAR(4) not null,
  hiredate VARCHAR2(20) not null,
  idcard   VARCHAR2(18)
)
tablespace MOTOR
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
-- Add comments to the columns 
comment on column M_USER.userid
  is '�û����';
comment on column M_USER.username
  is '�û���';
comment on column M_USER.password
  is '����';
comment on column M_USER.organid
  is '��֯�������';
comment on column M_USER.job
  is 'ְλ';
comment on column M_USER.gender
  is '�Ա�';
comment on column M_USER.birthday
  is '��������';
comment on column M_USER.mobile
  is '�ֻ�';
comment on column M_USER.tel
  is '�绰';
comment on column M_USER.qq
  is 'QQ����';
comment on column M_USER.email
  is '�����ʼ�';
comment on column M_USER.addr
  is '��ϵסַ';
comment on column M_USER.party
  is '������ò';
comment on column M_USER.hiredate
  is '��ְ����';
comment on column M_USER.idcard
  is '���֤��';
-- Create/Recreate primary, unique and foreign key constraints 
alter table M_USER
  add constraint PK_M_USER primary key (USERID)
  using index 
  tablespace MOTOR
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
