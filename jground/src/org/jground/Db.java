package org.jground;

import org.apache.log4j.Logger;
import java.sql.Connection;

public class Db {
    static Logger logger = Logger.getRootLogger();
    private final Connection connection;

    protected Db(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }
}
