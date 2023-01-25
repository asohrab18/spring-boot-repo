INSERT INTO user_details(id, birth_date, name)VALUES(10001, current_date(), 'Alizabeth');
INSERT INTO user_details(id, birth_date, name)VALUES(10002, current_date(), 'Celina');
INSERT INTO user_details(id, birth_date, name)VALUES(10003, current_date(), 'David');

INSERT INTO designation(id, description, user_details_id)
VALUES(20001, 'I am working on Spring Boot', 10001);

INSERT INTO designation(id, description, user_details_id)
VALUES(20002, 'I am working on Microservices', 10001);

INSERT INTO designation(id, description, user_details_id)
VALUES(20003, 'I am working on AWS', 10002);

INSERT INTO designation(id, description, user_details_id)
VALUES(20004, 'I am working on DevOps', 10002);