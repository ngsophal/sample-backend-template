DROP DATABASE IF EXISTS sample;
CREATE DATABASE sample  CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';
USE sample ;

DROP USER IF EXISTS 'ggbackendApp'@'localhost';
CREATE USER 'ggbackendApp'@'localhost' IDENTIFIED BY '@gg225jLLi22aA!';
GRANT  ALL PRIVILEGES ON nawras.* TO 'ggbackendApp'@'localhost';

DROP TABLE IF EXISTS offer;
CREATE TABLE offer (
  id BIGINT NOT NULL AUTO_INCREMENT,
  title VARCHAR(256) NOT NULL,
  description VARCHAR(256),
  brandId VARCHAR(256),
  categoryId VARCHAR(256),
  imageUrl VARCHAR(256) ,
  state BIGINT,
  version MEDIUMINT,
  createdBy VARCHAR(256),
  createdDate BIGINT,
  updatedBy VARCHAR(256),
  updatedDate BIGINT,
  PRIMARY KEY (id)  
) ENGINE=InnoDB CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';


DROP TABLE IF EXISTS category;
CREATE TABLE category (
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(256) NOT NULL,
  description VARCHAR(256),
  type VARCHAR(256),
  parentId BIGINT,
  logoUrl VARCHAR(256) ,  
  PRIMARY KEY (id)  
) ENGINE=InnoDB CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';

insert into category(id,name,description) values(1,'cat1','cat description1');
insert into category(id,name,description) values(2,'cat2','cat description2');
insert into category(id,name,description) values(3,'cat3','cat description3');