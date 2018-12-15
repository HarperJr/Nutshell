package localdb.jdbc;

import localdb.DatabaseProperties;
import localdb.jdbc.base.BaseDatabase;
import localdb.jdbc.dao.EnchantDao;
import localdb.jdbc.dao.ToolDao;

import java.sql.SQLException;

public class Database extends BaseDatabase {

    private final DatabaseProperties databaseProperties;
    private final DbTransaction dbTransaction;
    private final EnchantDao enchantDao;
    private final ToolDao toolDao;

    public Database(DatabaseProperties databaseProperties) {
        this.databaseProperties = databaseProperties;
        this.dbTransaction = new DbTransactionImpl(this);
        /*Dao*/
        this.enchantDao = new EnchantDao(this);
        this.toolDao = new ToolDao(this);
    }

    public void connect() throws SQLException {
        super.connect(databaseProperties);
    }

    public DbTransaction getDbTransaction() {
        return dbTransaction;
    }

    public EnchantDao getEnchantDAO() {
        return enchantDao;
    }

    public ToolDao getToolDao() {
        return toolDao;
    }
}
