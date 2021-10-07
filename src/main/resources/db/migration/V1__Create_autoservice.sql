    CREATE TABLE autoservice.user (
    id BIGSERIAL PRIMARY KEY,
    login TEXT,
    password TEXT,
    email TEXT
    );

    CREATE TABLE autoservice.employee (
    id BIGSERIAL PRIMARY KEY,
    surname TEXT,
    user_id BIGINT NOT NULL REFERENCES autoservice.user(id)
    );