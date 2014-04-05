package org.jground;

import java.sql.*;

class MySqlDb extends Db {
    private final static String url = "jdbc:mysql://localhost:3306/jground";
    private final static String name = "root";
    private final static String password = "123";

    private MySqlDb(Connection connection) {
        super(connection);
    }

    public static Db create() {
        Connection connection = null;
        try {
            Class.forName("org.mysql5.Driver");

            connection = DriverManager.getConnection(url, name, password);

            return new MySqlDb(connection);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    logger.error(ex.getMessage());
                }
            }
        }
        return null;
    }
}
