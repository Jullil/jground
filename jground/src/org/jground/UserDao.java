package org.jground;

import org.jground.entity.User;

public interface UserDao {

    boolean addUser(String userName, String login, String password);

    User getUser(String login);
}
