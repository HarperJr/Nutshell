package localdb.jdbc;

import java.sql.SQLException;
import java.util.concurrent.Callable;

public class DbTransactionImpl implements DbTransaction {

    private final Database database;

    public DbTransactionImpl(Database database) {
        this.database = database;
    }

    @Override
    public void beginTransaction() {
        try {
            database.connect();
            database.beginTransaction();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void endTransaction() {
        try {
            database.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void executeInTx(Runnable runnable) {
        try {
            database.connect();
            database.executeInTransaction(runnable);
            database.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public <T> T executeInTx(Callable<T> callable) {
        T result = null;
        try {
            database.connect();
            result = database.executeInTransaction(callable);
            database.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
