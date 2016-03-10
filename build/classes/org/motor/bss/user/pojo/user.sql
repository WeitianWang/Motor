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
  is '用户编号';
comment on column M_USER.username
  is '用户名';
comment on column M_USER.password
  is '密码';
comment on column M_USER.organid
  is '组织机构编号';
comment on column M_USER.job
  is '职位';
comment on column M_USER.gender
  is '性别';
comment on column M_USER.birthday
  is '出生日期';
comment on column M_USER.mobile
  is '手机';
comment on column M_USER.tel
  is '电话';
comment on column M_USER.qq
  is 'QQ号码';
comment on column M_USER.email
  is '电子邮件';
comment on column M_USER.addr
  is '联系住址';
comment on column M_USER.party
  is '政治面貌';
comment on column M_USER.hiredate
  is '入职日期';
comment on column M_USER.idcard
  is '身份证号';
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
