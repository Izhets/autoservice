    CREATE TABLE profiles.client (
    id BIGSERIAL PRIMARY KEY NOT NULL,
    "name" VARCHAR NOT NULL,
    surname VARCHAR NOT NULL,
    patronymic VARCHAR,
    date_of_birth DATE NOT NULL,
    phone_number VARCHAR NOT NULL,
    user_id BIGINT NOT NULL REFERENCES profiles.user(id)
    );