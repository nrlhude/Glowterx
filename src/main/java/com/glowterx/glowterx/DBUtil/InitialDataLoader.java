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
                    "CREATE TABLE admin (id INT(11) AUTO_INCREMENT PRIMARY KEY, username VARCHAR(255),password VARCHAR(255), firstname VARCHAR(255), lastname VARCHAR(255), address VARCHAR(255), city VARCHAR(255), state VARCHAR(255), zip VARCHAR(255), phone VARCHAR(255), email VARCHAR(255), UNIQUE KEY (username))");
            System.out.println("Table 'admin' created.");
        }

        if (tables.contains("instructor")) {
            System.out.println("Table 'instructor' already exists.");
        } else {
            jdbcTemplate.execute(
                    "CREATE TABLE instructor (id INT(11) AUTO_INCREMENT PRIMARY KEY, username VARCHAR(255),password VARCHAR(255), firstname VARCHAR(255), lastname VARCHAR(255), address VARCHAR(255), city VARCHAR(255), state VARCHAR(255), zip VARCHAR(255), phone VARCHAR(255), email VARCHAR(255), UNIQUE KEY (username))");
            System.out.println("Table 'instructor' created.");
        }
        if (tables.contains("trainee")) {
            System.out.println("Table 'trainee' already exists.");
        } else {
            jdbcTemplate.execute(
                    "CREATE TABLE trainee (id INT(11) AUTO_INCREMENT PRIMARY KEY, username VARCHAR(255),password VARCHAR(255), MembershipStatus VARCHAR(255), firstname VARCHAR(255), lastname VARCHAR(255), address VARCHAR(255), city VARCHAR(255), state VARCHAR(255), zip VARCHAR(255), phone VARCHAR(255), email VARCHAR(255), UNIQUE KEY (username))");
            System.out.println("Table 'trainee' created.");
        }
        if (tables.contains("payment")) {
            System.out.println("Table 'payment' already exists.");
        } else {
            jdbcTemplate.execute(
                    "CREATE TABLE payment (id INT(11) AUTO_INCREMENT PRIMARY KEY, person_id INT(11), amount DECIMAL(10,2), payment_date DATE, payment_status VARCHAR(255),FOREIGN KEY (person_id) REFERENCES trainee(id))");
            System.out.println("Table 'payment' created.");
        }

        if (tables.contains("product")) {
            System.out.println("Table 'product' already exists.");
        } else {
            jdbcTemplate.execute(
                    "CREATE TABLE product (id INT(11) AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), price DECIMAL(10,2), quantity INT(11))");
            System.out.println("Table 'product' created.");
        }

        if (tables.contains("cart")) {
            System.out.println("Table 'cart' already exists.");
        } else {
            jdbcTemplate.execute(
                    "CREATE TABLE cart (id INT(11) AUTO_INCREMENT PRIMARY KEY, person_id INT(11), product_id INT(11),FOREIGN KEY (person_id) REFERENCES trainee(id),FOREIGN KEY (product_id) REFERENCES product(id))");
            System.out.println("Table 'cart' created.");
        }
        if (tables.contains("order")) {
            System.out.println("Table 'order' already exists.");
        } else {
            jdbcTemplate.execute(
                    "CREATE TABLE `order` (id INT(11) AUTO_INCREMENT PRIMARY KEY, person_id INT(11), payment_id INT(11), order_date DATE, order_status VARCHAR(255),FOREIGN KEY (person_id) REFERENCES trainee(id),FOREIGN KEY (payment_id) REFERENCES payment(id))");
            System.out.println("Table 'order' created.");
        }

        if (tables.contains("training")) {
            System.out.println("Table 'training' already exists.");
        } else {
            jdbcTemplate.execute(
                    "CREATE TABLE training (id INT(11) AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), start_date DATE, end_date DATE)");
            System.out.println("Table 'training' created.");
        }

        if (tables.contains("attendance")) {
            System.out.println("Table 'attendance' already exists.");
        } else {
            jdbcTemplate.execute(
                    "CREATE TABLE attendance (id INT(11) AUTO_INCREMENT PRIMARY KEY, person_id INT(11), training_id INT(11), attendance_status VARCHAR(255),FOREIGN KEY (person_id) REFERENCES trainee(id),FOREIGN KEY (training_id) REFERENCES training(id))");
            System.out.println("Table 'attendance' created.");
        }
        if (tables.contains("membership")) {
            System.out.println("Table 'membership' already exists.");
        } else {
            jdbcTemplate.execute(
                    "CREATE TABLE membership (id INT(11) AUTO_INCREMENT PRIMARY KEY, person_id INT(11), start_date DATE, end_date DATE, membership_status VARCHAR(255),FOREIGN KEY (person_id) REFERENCES trainee(id))");
            System.out.println("Table 'membership' created.");
        }
    }

    public void loadInitialData() {
        jdbcTemplate.execute(
                "INSERT INTO admin(username, password, firstname, lastname, address, city, state, zip, phone, email) VALUES ('iesz', '123', 'Ieskandar', 'Zulqarnain', 'M21 KTDI', 'Taman U', 'Skudai', '83130', '014916193', 'zieszx@gmail.com')");
        jdbcTemplate.execute(
                "INSERT INTO admin(username, password, firstname, lastname, address, city, state, zip, phone, email) VALUES ('hude', '123', 'Nurul', 'Huda', 'W3 KDSE', 'Taman Plentong', 'Masai', '83213', '0123456789', 'hude@gmail.com')");
        jdbcTemplate.execute(
                "INSERT INTO instructor(username, password, firstname, lastname, address, city, state, zip, phone, email) VALUES ('johndoe', '123', 'John', 'Doe', 'MA1 KTDI', 'Taman J', 'Impian Emas', '83130', '014934563', 'john@gmail.com')");
    }

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        createTables();
    }
}
