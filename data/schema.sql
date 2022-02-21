BEGIN TRANSACTION;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS seq_user_id;
CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;
CREATE TABLE users (
	user_id SERIAL NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	is_NHRS boolean,
	salary_usd NUMERIC,
	salary_euro NUMERIC,
	industry varchar(250),
	final_salary NUMERIC,
CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE qualifying_industries (
        industry_id SERIAL NOT NULL PRIMARY KEY,
        industry_name varchar(250) UNIQUE NOT NULL,
        is_NHRS boolean
);

CREATE TABLE user_industry (
        user_id int,
        industry_id int,
CONSTRAINT pk_user_industry PRIMARY KEY (user_id, industry_id),
CONSTRAINT fk_users FOREIGN KEY (user_id) REFERENCES users (user_id),
CONSTRAINT fk_qualifying_industries FOREIGN KEY (industry_id) REFERENCES qualifying_industries (industry_id)
);


        
CREATE TABLE brackets (
        bracket_id SERIAL NOT NULL PRIMARY KEY,
        NHRS_bracket boolean,
        bracket_limit NUMERIC,
        percentage NUMERIC
); 

CREATE TABLE user_bracket (
        user_id Integer,
        bracket_id Integer,
Constraint pk_user_bracket PRIMARY KEY (user_id, bracket_id),
Constraint fk_users FOREIGN KEY (user_id) REFERENCES users (user_id),
Constraint fk_brackets FOREIGN KEY (bracket_id) REFERENCES brackets (bracket_id)
);

CREATE TABLE regions (
        region_id SERIAL NOT NULL UNIQUE PRIMARY KEY,
        region_name varchar(350) NOT NULL UNIQUE,
        average_temp_summer_f NUMERIC,
        average_temp_winter_f NUMERIC,
        average_temp_summer_c NUMERIC,
        average_temp_winter_c NUMERIC
);

CREATE TABLE cities (
        city_id SERIAL NOT NULL PRIMARY KEY,
        city_name varchar(500) NOT NULL,
        region varchar(350),
        is_coastal boolean,
        border_spain boolean,
        population NUMERIC,
        cost_of_living varchar(500),
 CONSTRAINT fk_regions FOREIGN KEY (region) REFERENCES regions (region_name)
 );
 
 CREATE TABLE region_cities (
        city_id Integer,
        region_id Integer,
CONSTRAINT pk_region_cities PRIMARY KEY (city_id, region_id),
CONSTRAINT fk_regions FOREIGN KEY (region_id) REFERENCES regions (region_id),
CONSTRAINT fk_cities FOREIGN KEY (city_id) REFERENCES cities (city_id)
);
        
CREATE TABLE user_preference (
        preference_id SERIAL NOT NULL PRIMARY KEY,
        user_id integer,
        salary NUMERIC,
        desired_temp_range_winter NUMERIC,
        desired_temp_range_summer NUMERIC,
        desires_coastal boolean,
        desires_border_spain boolean,
        desired_population_range varchar(300),
        desired_cost_of_living varchar(500),
        suggested_region varchar(500),
CONSTRAINT fk_users FOREIGN KEY (user_id) REFERENCES users (user_id),
CONSTRAINT fk_regions FOREIGN KEY (suggested_region) REFERENCES regions (region_name)
);
        
        
        

COMMIT TRANSACTION;
-- ALL TABLES INSERTED INTO DATABASE GO ABOVE THIS LINE
-- ALL DATA INSERTED INTO TABLES GOES BELOW THIS LINE
-- Insert Teachers & Admins
INSERT INTO users (username, password_hash, role) VALUES ('admin', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'ROLE_ADMIN');
INSERT INTO users (username, password_hash, role) VALUES ('user', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'ROLE_USER');

