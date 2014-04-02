package org.jground;

import java.util.Random;

public class Field {
    private int n;

    private int x, y;



    public Field(int n) {
        this.n = n;
    }

    public long getType(int x, int y) {
        final int seed = (n + (31 * x)) * 31 + y;
        final Random random = new Random(seed);
        return random.nextInt(n);
    }


}
