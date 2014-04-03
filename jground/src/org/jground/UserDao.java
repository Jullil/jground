package org.jground;

public interface UserDao {

    boolean addUser(String userName, String login, String password);

    User getUser(String login);
}
