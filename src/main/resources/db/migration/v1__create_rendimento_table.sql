CREATE SEQUENCE IF NOT EXISTS rendimento_id_seq START WITH 1 INCREMENT BY 1;

ALTER TABLE rendimento
    ALTER COLUMN id SET DEFAULT nextval('rendimento_id_seq');