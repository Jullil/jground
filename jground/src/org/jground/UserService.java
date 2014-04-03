package org.jground;

public class UserService {
    private final static UserService INSTANCE = new UserService();
    private final UserDao dao = new UserRuntimeDao();

    private UserService() {}

    public static UserService getInstance() {
        return INSTANCE;
    }

    public boolean register(String userName, String login, String password) {
        return dao.addUser(userName, login, password);
    }

    public boolean login(String login, String password) {
        User user = dao.getUser(login);
        if (user.getPassword() == password) {
            return true;
        }
        return false;
    }
}
