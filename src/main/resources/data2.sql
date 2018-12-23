drop table if exists guest;
drop table if exists room;
drop table if exists conference;

create table guest
(
  id        int(12) not null auto_increment,
  full_name VARCHAR(60),
  primary key (id)
);

create table conference
(
  id              int(12) not null auto_increment,
  conference_name varchar(40),
  active          bit,
  guest_id        int(12),
  primary key (id),
  constraint guest_fk foreign key (guest_id) references guest (id)
    on update cascade on delete cascade
);

create table room
(
  id            int(12)     not null auto_increment,
  room_name     varchar(40) not null,
  seats_num     int(3),
  conference_id int(12),
  primary key (id),
  constraint conference_fk foreign key (conference_id) references conference (id)
    on update cascade on delete cascade
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