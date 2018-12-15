package localdb.jdbc.base;

import localdb.DatabaseProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDatabase {

    private final Logger logger = Logger.getLogger(BaseDatabase.class.getSimpleName());

    private Connection connection;

    public void connect(DatabaseProperties databaseProperties) throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception ex) {
            logger.log(Level.FINE, ex.getMessage());
        }
        final String connectionString = String
                .format("jdbc:mysql://%s:%d/%s?user=%s&password=%s&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&serverTimezone=UTC",
                        databaseProperties.getHost(),
                        databaseProperties.getPort(),
                        databaseProperties.getDatabase(),
                        databaseProperties.getUser(),
                        databaseProperties.getPassword());
        connection = DriverManager.getConnection(connectionString);
        logger.log(Level.FINE, "connected");
    }

    public void disconnect() throws SQLException {
        if (connection == null && !connection.isClosed()) {
            connection.close();
        }
    }

    public void beginTransaction() {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            logger.log(Level.FINE, e.getMessage());
        }
    }

    public void endTransaction() {
        try {
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            logger.log(Level.FINE, e.getMessage());
        }
    }

    public void executeInTransaction(final Runnable runnable) {
        beginTransaction();
        runnable.run();
        endTransaction();
    }

    public <T> T executeInTransaction(Callable<T> callable) {
        beginTransaction();
        try {
            return callable.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
        endTransaction();
        return null;
    }

    public Connection getConnection() {
        return connection;
    }

    public Logger getLogger() {
        return logger;
    }
}
