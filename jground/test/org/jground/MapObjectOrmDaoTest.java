package org.jground;

import junit.framework.Assert;
import org.jground.entity.User;
import org.junit.Test;
import org.jground.entity.MapObjectType;

import java.util.Date;

public final class MapObjectOrmDaoTest {
    @Test
    public void testRegister() {
        final String login = "test" + (new Date()).getTime();
        final String password = "12345233333sdsd44";

        UserOrmDao userDao = new UserOrmDao();
        boolean result = userDao.addUser("Hibernate Test User22244", login, password);
        Assert.assertTrue(result);

        User user = userDao.getUser(login);

        MapObjectOrmDao dao = new MapObjectOrmDao();

        boolean result2 = dao.add(100, 100, user, MapObjectType.TYPE1);
        Assert.assertTrue(result2);
    }
}
