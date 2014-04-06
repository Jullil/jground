package org.jground;

public class UserService {
    private final static UserService INSTANCE = new UserService();
    private UserDao dao = new UserRuntimeDao();

    private UserService() {}

    public static UserService getInstance() {
        return INSTANCE;
    }

    public boolean register(String userName, String login, String password) {
        return dao.addUser(userName, login, password);
    }

    public boolean login(String login, String password) {
        final User user = dao.getUser(login);
        return user != null && user.getPassword().equals(password);
    }

    void setDao(UserDao dao) {
        this.dao = dao;
    }

    UserDao getDao() {
        return dao;
    }
}
