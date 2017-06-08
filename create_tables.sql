--Creates tables for managing books, movies, etc. that a person has read
--@author: Vincent Yahna

CREATE TABLE media_types(
  id int primary key identity(1,1),
  name varchar(255),
  description varchar(255)
);

CREATE TABLE works (
  id int primary key identity(1,1),
  title varchar2(255) not null,
  subtitle varchar2(255),
  volume int,
  summary varchar2(255),
  notes varchar2(255),
  own_copy bit,
  media_type_id REFERENCES media_types(id)
);