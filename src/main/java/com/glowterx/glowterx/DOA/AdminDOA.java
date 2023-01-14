package com.glowterx.glowterx.DOA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.glowterx.glowterx.Model.Admin;

public class AdminDOA {
    @Autowired
    private DataSource dataSource;

    public Admin validate(String username, String password) {
        Admin admin = null;

        try (Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection
                        .prepareStatement("SELECT * FROM admin WHERE username = ? AND password = ?")) {

            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                admin = new Admin();
                admin.setId(rs.getInt("id"));
                admin.setAdminUsername(rs.getString("username"));
                admin.setAdminPass(rs.getString("password"));
                admin.setFirstName(rs.getString("firstname"));
                admin.setLastName(rs.getString("lastname"));
                admin.setAddress(rs.getString("address"));
                admin.setCity(rs.getString("city"));
                admin.setState(rs.getString("state"));
                admin.setZip(rs.getString("zip"));
                admin.setPhone(rs.getString("phone"));
                admin.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return admin;
    }
}
