-- Table: users
CREATE TABLE learning.users
(
    id       INT          NOT NULL AUTO_INCREMENT,

    firstName     varchar(255),
    lastName  varchar(255),
    age      int          NOT NULL,

    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,

    PRIMARY KEY (id)
);

-- Table: roles
CREATE TABLE learning.roles
(
    id   INT          NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,

    PRIMARY KEY (id)
);

-- Table for mapping user and roles: user_roles
CREATE TABLE learning.users_roles
(
    user_id INT NOT NULL,
    role_id INT NOT NULL,

    FOREIGN KEY (user_id) REFERENCES users (id),
    FOREIGN KEY (role_id) REFERENCES roles (id),

    UNIQUE (user_id, role_id)
);

INSERT learning.users
VALUES (null, 'Admin', 'Admins', 35, 'ADMIN', '$2a$10$DK2Yd6NWHU9cGcJqOjbpBuV1RSF51HfEncxiD7XXLNTVYfPiR/KMi'),
       (null, 'Sasha', 'Sidorov', 23, '1', '1'),
       (null, 'Sveta', 'Petrov', 33, '2', '2'),
       (null, 'Ivan', 'Oveec', 24, '3', '3'),
       (null, 'Sergei', 'Kirovec', 55, '4', '4'),
       (null, 'Masha', 'Maheev', 88, '5', '5'),
       (null, 'Andrei', 'Kudrovec', 26, '6', '6');

INSERT learning.roles
VALUES (1, 'ROLE_USER'),
       (2, 'ROLE_ADMIN');

INSERT learning.users_roles
VALUES (1, 2),
       (2, 1),
       (3, 1),
       (4, 1),
       (5, 1),
       (6, 1),
       (7, 1);