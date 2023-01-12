package com.glowterx.glowterx.DBUtil;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class InitialDataLoader {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public InitialDataLoader(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void createTables() {

        List<String> tables = jdbcTemplate.queryForList("SHOW TABLES", String.class);
        if (tables.contains("admin")) {
            System.out.println("Table 'admin' already exists.");
        } else {
            jdbcTemplate.execute(
                    "CREATE TABLE admin (id INT(11) AUTO_INCREMENT PRIMARY KEY, username VARCHAR(255),password VARCHAR(255))");
            System.out.println("Table 'users' created.");
        }

        if (tables.contains("instructor")) {
            System.out.println("Table 'instructor' already exists.");
        } else {
            jdbcTemplate.execute(
                    "CREATE TABLE instructor (id INT(11) AUTO_INCREMENT PRIMARY KEY, username VARCHAR(255),password VARCHAR(255))");
            System.out.println("Table 'products' created.");
        }

        if (tables.contains("trainee")) {
            System.out.println("Table 'trainee' already exists.");
        } else {
            jdbcTemplate.execute(
                    "CREATE TABLE trainee (id INT(11) AUTO_INCREMENT PRIMARY KEY, username VARCHAR(255),password VARCHAR(255))");
            System.out.println("Table 'trainee' created.");
        }
    }

    public void loadInitialData() {
        jdbcTemplate.execute("INSERT INTO admin (username, password) VALUES ('iesz', '123')");
        jdbcTemplate.execute("INSERT INTO instructor (username, password) VALUES ('hude', '123')");
        jdbcTemplate.execute("INSERT INTO trainee (username, password) VALUES ('fiker', '123')");
    }

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        createTables();
        loadInitialData();
    }
}
