--Creates tables for managing books, movies, etc. that a person has read
--@author: Vincent Yahna

--SQLite doesn't actually enforce limits on VARCHAR, due to limited data types being used,
--but the tables will be written thusly in case there is a switch to an SQL server
CREATE TABLE media_types(
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  name VARCHAR2(255) NOT NULL,
  description VARCHAR2(8000)
);

CREATE TABLE tags(
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  name VARCHAR2(255) NOT NULL,
  description VARCHAR2(8000)
);

CREATE TABLE users(
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  username VARCHAR2(20) NOT NULL
  --password hash might be added in future, but everything is local and unencrypted, so it doesn't matter too much.
);

CREATE TABLE series(
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  title VARCHAR2(255) NOT NULL,
  description VARCHAR2(8000)
);

CREATE TABLE franchises(
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  title VARCHAR2(255) NOT NULL,
  description VARCHAR2(8000)
);

CREATE TABLE authors(
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  last_name VARCHAR2(255) NOT NULL,
  first_name VARCHAR2(255),
  notes VARCHAR2(8000)
);

CREATE TABLE publishers(
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  name VARCHAR2(255) NOT NULL
);

--Tables that reference other tables

CREATE TABLE works (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  title VARCHAR2(255) NOT NULL,
  subtitle VARCHAR2(255),
  volume INTEGER,
  summary VARCHAR2(8000),
  notes VARCHAR2(8000),
  own_copy BIT,
  media_type_id REFERENCES media_types(id)
);

CREATE TABLE reading_sessions (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  work_id REFERENCES works(id),
  user_id REFERENCES users(id),
  notes VARCHAR2(8000), 
  date_started DATETIME,
  date_finished DATETIME,
  rating INTEGER
);

--The linking tables

CREATE TABLE lk_tags_works(
  tag_id REFERENCES tags(id),
  work_id REFERENCES works(id)
);

CREATE TABLE lk_series_works(
  series_id REFERENCES series(id),
  work_id REFERENCES works(id)
);

CREATE TABLE lk_series_franchises(
  series_id REFERENCES series(id),
  franchise_id REFERENCES franchises(id)
);
--can there really be more than one publisher?
CREATE TABLE lk_publishers_works(
  publisher_id REFERENCES publishers(id),
  work_id REFERENCES works(id)
);

CREATE TABLE lk_authors_works(
  author_id REFERENCES authors(id),
  work_id REFERENCES works(id)
);

