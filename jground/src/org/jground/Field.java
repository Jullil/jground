package org.jground;

import java.util.Random;

public final class Field {
    private final int n;

    public Field(int n) {
        this.n = n;
    }

    public long getType(int x, int y) {
        final int seed = (n + (31 * x)) * 31 + y;
        final Random random = new Random(seed);
        return random.nextInt(n);
    }


}
