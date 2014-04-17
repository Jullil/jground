package org.jground;

import org.jground.entity.User;

import java.util.ArrayList;

public class UserRuntimeDao implements UserDao {
    private final ArrayList<User> userList = new ArrayList<User>();

    @Override
    public boolean addUser(String name, String login, String password) {
        if (this.getUser(login) != null) {
            return false;
        }
        User user = new User(name, login, password);
        return userList.add(user);
    }

    @Override
    public User getUser(String login) {
        for (User user: userList) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }
}
