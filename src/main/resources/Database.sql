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
       (null, 'Sasha', 'Sidorov', 23, '1', '$2a$10$dHV9OjXcGqp9aP/tXEM30OAa9JXZU3zm7X5iTvSIodCRnUZO870sy'),
       (null, 'Sveta', 'Petrov', 33, '2', '$2a$10$7NZp/u/OmOWSKJtNs5lPX.BnwZUZiOxgW9Wuu43U/A1omD9muD1/K'),
       (null, 'Ivan', 'Oveec', 24, '3', '$2a$10$Ejx2lY7NyxdtacT6MJDF2uHM8r97R9mJb8bcKucDaoeKVNNr7tRnK'),
       (null, 'Sergei', 'Kirovec', 55, '4', '$2a$10$xp.ncI2d11tp32vOvBc7A.DhgSU4AuWhHndOc4HTObGWchMGP1uzS'),
       (null, 'Masha', 'Maheev', 88, '5', '$2a$10$W/.c9t/FBx51MKXZiAXW2OAls9JoKU/CrxnGJe7rRgrxgSvQfE0.e'),
       (null, 'Andrei', 'Kudrovec', 26, '6', '$2a$10$uzyxyKbTtLrEAaDZfu/rCejcest4H6RPwkKxr528t/cSJzOJ2x6QC');

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