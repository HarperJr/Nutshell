package interactor;

import localdb.DatabaseProperties;
import localdb.DatabaseProvider;
import localdb.jdbc.DbTransaction;
import localdb.model.Enchant;
import localdb.model.Tool;
import localdb.repository.EnchantRepository;
import localdb.repository.ToolRepository;

import java.util.List;

public class Interactor {

    private static Interactor instance;

    public static final Interactor getInstance() {
        if (instance == null) {
            instance = new Interactor();
        }
        return instance;
    }

    private final DatabaseProperties databaseProperties = new DatabaseProperties("localhost", 3306, "tools_database")
            .setUser("root")
            .setPassword("170899");
    private final DatabaseProvider provider = DatabaseProvider.provider()
            .withProperties(databaseProperties);
    private final DbTransaction dbTransaction = provider.provideDbTransaction();
    private final ToolRepository toolRepository = provider.provideToolRepository();
    private final EnchantRepository enchantRepository = provider.provideEnchantRepository();

    public List<Tool> getTools() {
        return dbTransaction.executeInTx(() -> {
            final List<Tool> tools = toolRepository.getAll();
            for (Tool tool : tools) {
                final Enchant enchant = enchantRepository
                        .getById(tool.getEnchant().getId());
                tool.setEnchant(enchant);
            }
            return tools;
        });
    }

    public List<Enchant> getEnchants() {
        return dbTransaction.executeInTx(enchantRepository::getAll);
    }

    public Tool getToolById(int id) {
        return dbTransaction.executeInTx(() -> toolRepository.getById(id));
    }

    public boolean deleteTool(Tool tool) {
        return dbTransaction.executeInTx(() -> toolRepository.delete(tool));
    }

    public boolean createTool(Tool tool) {
        return dbTransaction.executeInTx(() -> toolRepository.insert(tool));
    }

    public boolean updateTool(Tool tool) {
        return dbTransaction.executeInTx(() -> toolRepository.update(tool));
    }
}
