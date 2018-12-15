package localdb.jdbc;

import java.util.concurrent.Callable;

public interface DbTransaction {

    void beginTransaction();

    void endTransaction();

    void executeInTx(Runnable runnable);

    <T> T executeInTx(Callable<T> callable);
}
