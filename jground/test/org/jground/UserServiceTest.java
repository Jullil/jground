package org.jground;

import junit.framework.Assert;
import org.junit.Test;

import java.util.Date;

public final class UserServiceTest {
    @Test
     public void testRegister() {
        boolean result = UserService.getInstance().register("Test User", "test", "12345");
        Assert.assertTrue(result);
    }

    @Test
    public void testRegisterWithSameLogin() {
        final String login = "test2";
        UserService.getInstance().register("Test User", login, "12345");
        final boolean result = UserService.getInstance().register("Test User3", login, "123453333");
        Assert.assertFalse(result);
    }

    @Test
    public void testLogin() {
        final String login = "test33";
        final String password = "12345233333";
        UserService.getInstance().register("Test User2", login, password);
        final boolean loginResult = UserService.getInstance().login(login, password);
        Assert.assertTrue(loginResult);
    }

    @Test
    public void testLoginWithNotExistedUser() {
        final boolean loginResult = UserService.getInstance().login("no existed login", "no existed password");
        Assert.assertFalse(loginResult);
    }

    @Test
    public void testLoginWithNoValidPassword() {
        final String login = "test2";
        final String password = "12345233333";
        UserService.getInstance().register("Test User2", login, password);
        final boolean loginResult = UserService.getInstance().login(login, "no existed password");
        Assert.assertFalse(loginResult);
    }

    @Test
    public void testRegisterAndLoginUsingDatabaseDao() {
        final String login = "test" + (new Date()).getTime();
        final String password = "12345233333sdsd";

        UserService.getInstance().setDao(new UserDatabaseDao());
        Assert.assertTrue(UserService.getInstance().getDao() instanceof UserDatabaseDao);

        boolean result = UserService.getInstance().register("Test User222", login, password);
        Assert.assertTrue(result);

        final boolean loginResult = UserService.getInstance().login(login, password);
        Assert.assertTrue(loginResult);
    }
}
