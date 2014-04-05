package org.jground;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
            Db.logger.error(ex.getMessage());
        }
        return false;
    }

    @Override
    public User getUser(String login) {
        return null;
    }

    private Connection getConnection() {
        return db.getConnection();
    }
}
