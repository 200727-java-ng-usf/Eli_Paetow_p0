/* 
 * create the user and password
 * */

CREATE USER project0_DB_user
WITH PASSWORD 'password';

/* 
 * grant privaleges
 * */
GRANT ALL PRIVILEGES 
ON DATABASE postgres 
TO project0_DB_user;

/* 
 * create user role table
 * */
CREATE TABLE user_roles(
	id serial, 
	name varchar(25) NOT NULL,
	
	CONSTRAINT user_roles_pk
	PRIMARY KEY (id)
);

/* 
 * create users table 
 * */

CREATE TABLE app_users(
	id serial,
	username varchar(25) UNIQUE NOT NULL,
	password varchar(256) NOT NULL, 
	first_name varchar(25) NOT NULL, 
	last_name varchar(25) NOT NULL , 
	email varchar (256) UNIQUE NOT NULL, 
	role_id int NOT NULL, 
	
	
	CONSTRAINT app_users_pk
	PRIMARY KEY (id) , 
	
	CONSTRAINT user_role_fk 
	FOREIGN KEY (role_id) 
	REFERENCES user_roles
	
	
);

/* 
 * insrting values 
 * */
INSERT INTO user_roles (name)
VALUES ('Admin'), ('Manager') , ('Basic member') , ('Premium Member') , ('Locked');

SELECT * 
FROM user_roles ;

INSERT INTO app_users (username , password , first_name , last_name , email , role_id )
VALUES 
	('aanderson', 'password' , 'Alice' , 'Anderson' , 'alice@email.com' , 1) , 
	('batman', 'password' , 'Bruce' , 'Wayne' , 'notBatman@email.com' , 2) ,
	('ironman', 'password' , 'Tony' , 'Stark' , 'iAmIronMan@email.com' , 3) ,
	('greenman', 'password' , 'Charlie' , 'Kelly' , 'kittenMittens@email.com' , 4) ,
	('trashman', 'password' , 'Frank' , 'Reynolds' , 'WolfCola@email.com' , 5) ; 


SELECT * 
FROM app_users ;
	





