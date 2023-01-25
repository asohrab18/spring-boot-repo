-- GETDATE() is current date function for SQL Server Database. 
-- But Current_Date() function was used for H2 in-memory database.
INSERT INTO user_details(id, birth_date, name)VALUES(10001, GETDATE(), 'Alizabeth');
INSERT INTO user_details(id, birth_date, name)VALUES(10002, GETDATE(), 'Celina');
INSERT INTO user_details(id, birth_date, name)VALUES(10003, GETDATE(), 'David');

INSERT INTO designation(designation_id, description, user_details_id)
VALUES(20001, 'I am working on Spring Boot', 10001);

INSERT INTO designation(designation_id, description, user_details_id)
VALUES(20002, 'I am working on Microservices', 10001);

INSERT INTO designation(designation_id, description, user_details_id)
VALUES(20003, 'I am working on AWS', 10002);