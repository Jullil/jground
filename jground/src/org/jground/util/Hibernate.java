package org.jground.util;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Hibernate {
    protected static final Logger logger = Logger.getRootLogger();
    private static SessionFactory sessionFactory;

    private static void configureSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            configureSessionFactory();
        }
        return sessionFactory;
    }
}
