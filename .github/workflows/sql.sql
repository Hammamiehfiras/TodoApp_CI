USE todoapp;
DROP TABLE IF EXISTS app_user;
CREATE TABLE app_user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

INSERT INTO app_user (username, password) VALUES ('testuser1', 'abc123');
INSERT INTO app_user (username, password) VALUES ('testuser2', 'xyz789');

SELECT * FROM app_user;
