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
  subtitle VARCHAR2(255),
  description VARCHAR2(8000),
  ongoing boolean,
  notes VARCHAR2(8000)
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

CREATE TABLE roles(
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  name VARCHAR2(255) NOT NULL UNIQUE,
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
  own_copy BOOLEAN,
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

CREATE TABLE reading_sessions_series (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  series_id REFERENCES series(id),
  user_id REFERENCES users(id),
  notes VARCHAR2(8000),
  date_started DATETIME,
  date_finished DATETIME,
  rating INTEGER
);

--The linking tables

CREATE TABLE lk_tags_works(
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  tag_id REFERENCES tags(id),
  work_id REFERENCES works(id)
);

CREATE TABLE lk_series_works(
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  series_id REFERENCES series(id),
  work_id REFERENCES works(id)
);

CREATE TABLE lk_series_franchises(
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  series_id REFERENCES series(id),
  franchise_id REFERENCES franchises(id)
);
--can there really be more than one publisher?
CREATE TABLE lk_publishers_works(
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  publisher_id REFERENCES publishers(id),
  work_id REFERENCES works(id)
);

CREATE TABLE lk_authors_works(
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  author_id REFERENCES authors(id),
  work_id REFERENCES works(id),
  role_id REFERENCES roles(id),
  notes VARCHAR2(8000)
);

--Some likely roles that will be wanted by default
INSERT INTO roles(name, notes) VALUES("Author", "Someone who writes a book, screenplay, etc.");
INSERT INTO roles(name, notes) VALUES("Illustrator", "Someone who draws pictures for a work.");
INSERT INTO roles(name, notes) VALUES("Director", "Someone who directs a movie or television show.");
INSERT INTO roles(name, notes) VALUES("Actor", "Someone who acts in a movie or television show.");
INSERT INTO roles(name, notes) VALUES("ADR Director", "Someone who directs voice actors.");
INSERT INTO roles(name, notes) VALUES("Translator", "Someone who translates a work into another language.");

INSERT INTO media_types(name, description) VALUES("Book", "A written work.");
INSERT INTO media_types(name, description) VALUES("Comic Book", "A work mainly composed of pictures in panels that tell a story.");
INSERT INTO media_types(name, description) VALUES("Manga", "A Japanese comic book. Usually has a distinctive style.");
INSERT INTO media_types(name, description) VALUES("Anime", "A Japanese cartoon.");
INSERT INTO media_types(name, description) VALUES("Movie", "A long-length visual media. Or a short-length one presented as a movie.");
INSERT INTO media_types(name, description) VALUES("Television", "A short-length visual media that usually comes in installments called episodes, which are packed into groups called seasons..");


