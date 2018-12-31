drop table if exists guest;
drop table if exists room;
drop table if exists conference;
drop table if exists event;

create table guest
(
  id int(3) not null auto_increment,
  g_name VARCHAR(60),
  birth_date date,
  primary key (id)
);

create table conference
(
  id int(3) not null auto_increment,
  c_name varchar(40),
  active bit,
  primary key (id),
  unique (c_name)
);

create table room
(
  id int(3) not null auto_increment,
  r_name varchar(40) not null,
  seats_num int(3),
  c_name varchar(60),
  primary key (id)
);

create table event
(
id int(3) not null auto_increment,
c_name varchar(60),
g_name varchar(60),
r_name varchar(60),
primary key (id)
)