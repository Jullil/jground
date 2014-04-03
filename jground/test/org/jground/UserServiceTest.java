package org.jground;

import junit.framework.Assert;
import org.junit.Test;

public final class UserServiceTest {
    @Test
    public void testRegister() {
        boolean result = UserService.getInstance().register("Test User", "test", "12345");
        Assert.assertTrue(result);
    }
}
