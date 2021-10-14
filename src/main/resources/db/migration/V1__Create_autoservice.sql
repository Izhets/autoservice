    CREATE TABLE autoservice.user (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    login TEXT NOT NULL,
    password TEXT NOT NULL,
    email TEXT NOT NULL
    );

    CREATE TABLE autoservice.employee (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    "name" VARCHAR NOT NULL,
    surname VARCHAR NOT NULL,
    patronymic VARCHAR,
    date_of_birth DATE NOT NULL,
    phone_number VARCHAR NOT NULL,
    post VARCHAR NOT NULL,
    salary INTEGER NOT NULL,
    work_experience INTEGER NOT NULL,
    duty TEXT NOT NULL,
    seniority_allowance VARCHAR NOT NULL,
    user_id BIGINT NOT NULL REFERENCES autoservice.user(id)
    );

