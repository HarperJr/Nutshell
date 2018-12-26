package repository;

import database.dao.ToolDao;
import database.dao.ToolDaoImpl;
import database.repository.ToolRepository;
import mapper.ToolMapper;
import model.Tool;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

@ManagedBean(name = "ToolRepository")
@SessionScoped
public class ToolRepositoryImpl implements ToolRepository {

    private ToolDao toolDao;
    private ToolMapper mapper;

    public ToolRepositoryImpl() {
        toolDao = new ToolDaoImpl();
        mapper = new ToolMapper();
    }

    @Override
    public List<Tool> findMatchType(String type) {
        return mapper.entitiesToModels(toolDao.findOfType(type));
    }

    @Override
    public void insert(Tool tool) {
        toolDao.insert(mapper.modelToEntity(tool));
    }

    @Override
    public List<Tool> getAll() {
        return mapper.entitiesToModels(toolDao.getAll());
    }

    @Override
    public Tool find(Integer id) {
        return mapper.entityToModel(toolDao.find(id));
    }

    @Override
    public void delete(Tool tool) {
        toolDao.delete(mapper.modelToEntity(tool));
    }

    @Override
    public void delete(Integer id) {
        toolDao.delete(id);
    }

    @Override
    public void update(Tool tool) {
        toolDao.update(mapper.modelToEntity(tool));
    }
}
