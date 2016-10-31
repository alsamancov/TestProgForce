# TestProgForce

This is the task management project.
As the repository uses a MySQL database. But it is possible to switch to another database. Just change the settings in the file db.properties.

To create database and tables, you can use requests below.

CREATE DATABASE test;

CREATE TABLE task(
ID INT NOT NULL AUTO_INCREMENT,
NAME VARCHAR(50) NOT NULL,
DATE DATE NOT NULL,
PRIORITY INT NOT NULL);

CREATE TABLE completed(
ID INT NOT NULL AUTO_INCREMENT,
NAME VARCHAR(50) NOT NULL,
DATE DATE NOT NULL,
PRIORITY INT NOT NULL);

With best regards,
Samantsov Oleksii
