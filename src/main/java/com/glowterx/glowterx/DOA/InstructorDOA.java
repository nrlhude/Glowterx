package com.glowterx.glowterx.DOA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.glowterx.glowterx.Model.Instructor;

public class InstructorDOA {
    @Autowired
    private DataSource dataSource;

    public Instructor validate(String username, String password) {
        Instructor instructor = null;

        try (Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection
                        .prepareStatement("SELECT * FROM instructor WHERE username = ? AND password = ?")) {

            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                instructor = new Instructor();
                instructor.setUsername(resultSet.getString("username"));
                instructor.setFirstName(resultSet.getString("first_name"));
                instructor.setLastName(resultSet.getString("last_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return instructor;
    }
}
