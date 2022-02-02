BEGIN TRANSACTION;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS seq_user_id;
CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;
CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	is_NHRS boolean,
	salary_usd NUMERIC,
	salary_euro NUMERIC,
	industry varchar(250);
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE qualifying_industries (
        industry_id SERIAL NOT NULL PRIMARY KEY,
        industry_name varchar(250) NOT NULL,
        is_NHRS boolean,
CONSTRAINT fk_users FOREIGN KEY (industry_name) REFERENCES users (industry)
);


        
CREATE TABLE brackets (
        bracket_id SERIAL NOT NULL PRIMARY KEY,
        NHRS_bracket boolean,
        bracket_limit NUMERIC,
        percentage NUMERIC,
CONSTRAINT fk_qualifying_industries FOREIGN KEY (NHRS_bracket) REFERENCES qualifying_industries (is_NHRS)
); 

COMMIT TRANSACTION;
-- ALL TABLES INSERTED INTO DATABASE GO ABOVE THIS LINE
-- ALL DATA INSERTED INTO TABLES GOES BELOW THIS LINE
-- Insert Teachers & Admins
INSERT INTO users (username, password_hash, role) VALUES ('admin', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'ROLE_ADMIN');
INSERT INTO users (username, password_hash, role) VALUES ('user', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'ROLE_USER');

