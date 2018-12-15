package localdb.jdbc.repository;

import localdb.jdbc.Database;
import localdb.jdbc.dao.ToolDao;
import localdb.jdbc.entity.ToolEntity;
import localdb.jdbc.mapper.base.BaseMapper;
import localdb.model.Tool;
import localdb.repository.ToolRepository;

import java.util.List;

public class ToolRepositoryImpl implements ToolRepository {

    private final Database database;
    private final BaseMapper mapper;

    public ToolRepositoryImpl(Database database, BaseMapper mapper) {
        this.database = database;
        this.mapper = mapper;
    }

    @Override
    public BaseMapper<Tool, ToolEntity> getMapper() {
        return mapper;
    }

    @Override
    public ToolDao getDao() {
        return database.getToolDao();
    }

    @Override
    public Tool getById(int id) {
        return getMapper().entityToModel(getDao().getById(id));
    }

    @Override
    public List<Tool> getAll() {
        return getMapper().entityListToModelList(getDao().getAll());
    }

    @Override
    public boolean update(Tool tool) {
        return getDao().update(getMapper().modelToEntity(tool));
    }

    @Override
    public boolean delete(Tool tool) {
        return getDao().delete(getMapper().modelToEntity(tool));
    }

    @Override
    public boolean insert(Tool tool) {
        return getDao().insert(getMapper().modelToEntity(tool));
    }

    @Override
    public Tool getByEnchantId(int enchantId) {
        return getMapper().entityToModel(getDao().getByEnchantId(enchantId));
    }
}
