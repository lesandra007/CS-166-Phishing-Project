CREATE DATABASE PhishingDatabase; 
USE PhishingDatabase;

CREATE TABLE Student(
	student_id INTEGER PRIMARY KEY NOT NULL,
    student_password VARCHAR(25) NOT NULL
);

INSERT INTO Student(student_id, student_password)
VALUES(1010, "Example Password");