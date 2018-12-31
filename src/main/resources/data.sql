insert into room (r_name, seats_num)
values ('Cherucruz', 20),
       ('Marshallazora Satanwest', 30),
       ('Aleshark', 10),
       ('Bastinkie', 15),
       ('Yompson Hamoondancer', 10),
       ('Murratenna Brooksplanethopper', 5);

alter table room alter column r_name set not null;
alter table room alter column seats_num set not null;