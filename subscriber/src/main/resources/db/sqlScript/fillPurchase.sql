
CREATE sequence hibernate_sequence start 1 increment 1;

    CREATE TABLE purchase (
        id BIGSERIAL NOT NULL,
        msisdn int8 NOT NULL,
        action VARCHAR(255) NOT NULL,
        timestamp int4 NOT NULL,
        PRIMARY KEY (id));
