DROP TABLE IF EXISTS conference;
DROP TABLE IF EXISTS room;
DROP TABLE IF EXISTS conference_room;

CREATE TABLE conference
(
  id          INT(12) NOT NULL AUTO_INCREMENT,
  conference_name        VARCHAR(40),
  guest_full_name VARCHAR(60),
  active    BIT,
  PRIMARY KEY (id)
);

CREATE TABLE room
(
  id           INT(12) NOT NULL AUTO_INCREMENT,
  room_name         VARCHAR(40),
  seats_number INT(3),
  PRIMARY KEY (id)
);

INSERT INTO room (room_name, seats_number)
VALUES ('Cherucruz', 20),
       ('Marshallazora Satanwest', 30),
       ('Aleshark', 10),
       ('Bastinkie', 15),
       ('Yompson Hamoondancer', 10),
       ('Murratenna Brooksplanethopper', 5);

ALTER TABLE room
  ALTER COLUMN room_name SET NOT NULL;
ALTER TABLE room
  ALTER COLUMN seats_number SET NOT NULL;


CREATE TABLE conference_room
(
  conference_id INT(12),
  room_id       INT(12),
  FOREIGN KEY (conference_id) REFERENCES conference (id),
  FOREIGN KEY (room_id) REFERENCES room (id)
);
