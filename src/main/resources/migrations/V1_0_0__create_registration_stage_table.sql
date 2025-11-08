CREATE TABLE IF NOT EXISTS registraton_stage
(
    document
    JSONB
);

CREATE UNIQUE INDEX IF NOT EXISTS registration_stage_type_uniq_idx
    ON registration_stage ((document ->> 'type'));
CREATE UNIQUE INDEX IF NOT EXISTS registration_stage_type_uniq_idx
    ON registration_stage ((document ->> 'order'));