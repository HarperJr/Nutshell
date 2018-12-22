package repository;

import database.dao.ObjectDao;
import mapper.ObjectMapper;
import model.ObjectModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ObjectRepositoryImpl implements  ObjectRepository {

    private ObjectDao objectDao;
    private ObjectMapper objectMapper;

    @Autowired
    public ObjectRepositoryImpl(ObjectDao objectDao, ObjectMapper objectMapper) {
        this.objectDao = objectDao;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<ObjectModel> findObjectsOfType(String type) {
        return objectMapper.entitiesToModels(objectDao.findObjectsOfType(type));
    }

    @Override
    public ObjectModel find(Integer id) {
        return objectMapper.entityToModel(objectDao.find(id));
    }

    @Override
    public List<ObjectModel> getAll() {
        return objectMapper.entitiesToModels(objectDao.getAll());
    }

    @Override
    public void insert(ObjectModel objectModel) {
        objectDao.insert(objectMapper.modelToEntity(objectModel));
    }

    @Override
    public void delete(ObjectModel objectModel) {
        objectDao.delete(objectMapper.modelToEntity(objectModel));
    }

    @Override
    public void update(ObjectModel objectModel) {
        objectDao.update(objectMapper.modelToEntity(objectModel));
    }
}
