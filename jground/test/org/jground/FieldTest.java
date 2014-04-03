package org.jground;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

public final class FieldTest {
    private Field field;
    private final static int N = 100;

    @Before
    public void init() {
        field = new Field(N);
    }

    @Test
    public void testLessThenN() {
        for (int i = 0; i < N; i++) {
            double value = field.getType((int) Math.pow(2, i), (int) Math.pow(3, i));
            Assert.assertFalse(value < N);
        }
    }

    @Test
    public void testSameResult() {
        double value1 = field.getType(15, 7);
        double value2 = field.getType(15, 7);
        Assert.assertEquals(value1, value2);
    }

    @Test
    public void testDispersion() {
        long num = field.getType(0, 0);
        int count = 0;
        for (int i = 0; i < N * N; i++) {
            long value = field.getType(i, i);
            if (value == num) {
                count++;
            }
        }
        float part = Math.abs(N - count) / (float) N;
        Assert.assertFalse(part > 0.05);
    }
}
