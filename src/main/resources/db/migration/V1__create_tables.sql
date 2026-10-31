CREATE TABLE wanted_criminals (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    nickname VARCHAR(255) NOT NULL,
    reward NUMERIC(15, 2) NOT NULL CHECK (reward >= 0),
    latitude DOUBLE PRECISION,
    longitude DOUBLE PRECISION,
    location_note TEXT,
    difficulty INTEGER NOT NULL CHECK (difficulty BETWEEN 1 AND 10),
    armed BOOLEAN NOT NULL DEFAULT FALSE,
    has_crew BOOLEAN NOT NULL DEFAULT FALSE,
    escape_master BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE hunt_logs (
    id BIGSERIAL PRIMARY KEY,
    criminal_id BIGINT NOT NULL REFERENCES wanted_criminals (id) ON DELETE CASCADE,
    success BOOLEAN NOT NULL,
    notes TEXT,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_hunt_logs_criminal_id ON hunt_logs (criminal_id);
