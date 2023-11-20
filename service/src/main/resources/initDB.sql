CREATE TABLE IF NOT EXISTS users
(
    id         BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(200) NOT NULL,
    last_name  VARCHAR(200) NOT NULL,
    email      VARCHAR(254) NOT NULL
);

CREATE TABLE IF NOT EXISTS user_info
(
    id         BIGSERIAL PRIMARY KEY,
    avatar_uri VARCHAR(254) NOT NULL,
    age        VARCHAR(254) NOT NULL
    );