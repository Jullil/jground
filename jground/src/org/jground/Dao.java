package org.jground;

import org.jground.entity.MyEntity;

import java.util.List;

public interface Dao {
    boolean add(MyEntity entity);
    MyEntity get(int id);
    List<MyEntity> list();
}
