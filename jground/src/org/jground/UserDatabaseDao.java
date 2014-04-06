package org.jground;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDatabaseDao implements UserDao {
    private final Db db = MySqlDb.create();

    @Override
    public boolean addUser(String userName, String login, String password) {
        try {
            PreparedStatement statement = getConnection().prepareStatement("INSERT INTO user SET name=?, login=?, password=?");
            statement.setString(1, userName);
            statement.setString(2, login);
            statement.setString(3, password);
            statement.executeUpdate();

            return true;
        } catch (SQLException ex) {
            Db.logger.error(ex.getMessage(), ex);
        }
        return false;
    }

    @Override
    public User getUser(String login) {
        try {
            PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM user WHERE login=?");
            statement.setString(1, login);
            ResultSet result = statement.executeQuery();
            result.next();

            return new User(result.getString("name"), result.getString("login"), result.getString("password"));
        } catch (SQLException ex) {
            Db.logger.error(ex.getMessage(), ex);
        }
        return null;
    }

    private Connection getConnection() {
        return db.getConnection();
    }
}
