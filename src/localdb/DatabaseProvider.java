package localdb;

import localdb.jdbc.Database;
import localdb.jdbc.DbTransaction;
import localdb.jdbc.mapper.EnchantMapper;
import localdb.jdbc.mapper.ToolMapper;
import localdb.jdbc.repository.EnchantRepositoryImpl;
import localdb.jdbc.repository.ToolRepositoryImpl;
import localdb.repository.EnchantRepository;
import localdb.repository.ToolRepository;
import org.mapstruct.factory.Mappers;

public class DatabaseProvider extends Provider<Database> {

    private static DatabaseProvider INSTANCE;

    private Database database;
    private EnchantRepository enchantRepository;
    private ToolRepository toolRepository;

    private DatabaseProperties databaseProperties;

    public static DatabaseProvider provider() {
        if (INSTANCE == null) {
            INSTANCE = new DatabaseProvider();
        }
        return INSTANCE;
    }

    public DatabaseProvider withProperties(DatabaseProperties databaseProperties) {
        this.databaseProperties = databaseProperties;
        return this;
    }

    @Override
    protected Database provide() {
        if (database == null) {
            if (databaseProperties == null) {
                database = new Database(DatabaseProperties.LOCAL_DB_PROPERTIES);
            } else {
                database = new Database(databaseProperties);
            }
        }
        return database;
    }

    public EnchantRepository provideEnchantRepository() {
        if (enchantRepository == null) {
            final EnchantMapper mapper = Mappers.getMapper(EnchantMapper.class);
            enchantRepository = new EnchantRepositoryImpl(provide(), mapper);
        }
        return enchantRepository;
    }

    public ToolRepository provideToolRepository() {
        if (toolRepository == null) {
            final ToolMapper mapper = Mappers.getMapper(ToolMapper.class);
            toolRepository = new ToolRepositoryImpl(provide(), mapper);
        }
        return toolRepository;
    }

    public DbTransaction provideDbTransaction() {
        return provide().getDbTransaction();
    }
}
