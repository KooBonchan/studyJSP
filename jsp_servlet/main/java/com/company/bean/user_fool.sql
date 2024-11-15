USE jsp_board;

DROP TABLE IF EXISTS user_full;

CREATE TABLE user_full (
  idx int PRIMARY KEY AUTO_INCREMENT,
  id char(20) UNIQUE,
  password_hash BLOB NOT NULL,
  name varchar(30) NOT NULL,
  email varchar(30) NULL,
  phone varchar(30) NULL,
  zipcode char(30) NULL,
  address varchar(60) NULL,
  job varchar(30) null
);


INSERT INTO user_full
(id, password_hash, name, email, phone, zipcode, address, job)
VALUES
('power', unhex('ef92b778ba4f8a2b9ab9e1b4a2cc8be8fc30ee6b709e1ba66bcddc28ed2f83d1'),
'Marcus Miller', 'run@4.cover', '012-3456-7890', '12345', 'US', 'Bassist'),
('eastbound', unhex('ef92b778ba4f8a2b9ab9e1b4a2cc8be8fc30ee6b709e1ba66bcddc28ed2f83d1'),
'Nathan East', 'four@play','010-1010-1010', '13579', 'US', 'Vocal');

INSERT INTO user_full
(id, password_hash, name)
VALUES
('davie504', unhex('ef92b778ba4f8a2b9ab9e1b4a2cc8be8fc30ee6b709e1ba66bcddc28ed2f83d1'),'Davide Biale');

SELECT * FROM user_full;
