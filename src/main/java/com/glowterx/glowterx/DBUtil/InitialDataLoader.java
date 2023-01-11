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
        if (tables.contains("users")) {
            System.out.println("Table 'users' already exists.");
        } else {
            jdbcTemplate.execute("CREATE TABLE users (id INT(11) AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255))");
            System.out.println("Table 'users' created.");
        }

        if (tables.contains("products")) {
            System.out.println("Table 'products' already exists.");
        } else {
            jdbcTemplate.execute(
                    "CREATE TABLE products (id INT(11) AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), price DECIMAL(10,2))");
            System.out.println("Table 'products' created.");
        }

    }

    public void loadInitialData() {
        jdbcTemplate.execute("INSERT INTO users (id, name) VALUES (1, 'John Doe')");
        jdbcTemplate.execute("INSERT INTO products (id, name, price) VALUES (1,'Product 1', 9.99)");
    }

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        createTables();
    }
}
