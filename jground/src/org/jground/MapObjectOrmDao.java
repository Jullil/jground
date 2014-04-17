package org.jground;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.jground.entity.MyEntity;
import org.jground.entity.MapObject;
import org.jground.entity.MapObjectType;
import org.jground.entity.User;
import org.jground.util.Hibernate;

import java.util.List;

public class MapObjectOrmDao implements Dao {
    protected static final Logger logger = Logger.getRootLogger();

    @Override
    public boolean add(MyEntity entity) {
        boolean result = false;
        Session session = null;
        try {
            session = Hibernate.getSessionFactory().openSession();
            session.beginTransaction();

            session.save((MapObject) entity);

            session.getTransaction().commit();
            result = true;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }

    public boolean add(int x, int y, User user, MapObjectType type) {
        MapObject mapObject = new MapObject(x, y, user, type);
        return this.add(mapObject);
    }


    @Override
    public MyEntity get(int id) {
        return null;
    }

    @Override
    public List<MyEntity> list() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
