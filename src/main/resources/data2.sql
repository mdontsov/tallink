drop table if exists guest;
drop table if exists room;
drop table if exists conference;

create table guest
(
  id        int(3) not null auto_increment,
  full_name VARCHAR(60),
  primary key (id)
);

create table conference
(
  row_id          int(3) not null auto_increment,
  conference_name varchar(40),
  active          bit,
  guest_full_name varchar(60),
);

create table room
(
  row_id          int(3)      not null auto_increment,
  room_name       varchar(40) not null,
  seats_num       int(3),
  conference_name varchar(60),
);

insert into room (room_name, seats_num)
values ('Cherucruz', 20),
       ('Marshallazora Satanwest', 30),
       ('Aleshark', 10),
       ('Bastinkie', 15),
       ('Yompson Hamoondancer', 10),
       ('Murratenna Brooksplanethopper', 5);

alter table room
  alter column room_name set not null;
alter table room
  alter column seats_num set not null;