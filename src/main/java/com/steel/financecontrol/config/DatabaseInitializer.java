package com.steel.financecontrol.config;


import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;

    public DatabaseInitializer(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    @Override
    public void run(String... args) {
        String createSequenceSQL = "CREATE SEQUENCE IF NOT EXISTS rendimento_id_seq START WITH 1 INCREMENT BY 1";
        String alterTableSQL = "ALTER TABLE rendimento ALTER COLUMN id SET DEFAULT nextval('rendimento_id_seq')";

        jdbcTemplate.execute(createSequenceSQL);
        jdbcTemplate.execute(alterTableSQL);
    }
}
