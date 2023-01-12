package com.glowterx.glowterx.DOA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.glowterx.glowterx.Model.Trainee;

public class TraineeDOA {
    @Autowired
    private DataSource dataSource;

    public Trainee validate(String username, String password) {
        Trainee trainee = null;

        try (Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection
                        .prepareStatement("SELECT * FROM trainee WHERE username = ? AND password = ?")) {

            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                trainee = new Trainee();
                trainee.setUsername(resultSet.getString("username"));
                trainee.setFirstName(resultSet.getString("first_name"));
                trainee.setLastName(resultSet.getString("last_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return trainee;
    }
}
