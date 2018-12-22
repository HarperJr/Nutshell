package mapper;

import database.entity.ObjectEntity;
import mapper.base.BaseMapper;
import model.ObjectModel;

import java.util.List;
import java.util.stream.Collectors;

public class ObjectMapper implements BaseMapper<ObjectModel, ObjectEntity> {

    @Override
    public ObjectModel entityToModel(ObjectEntity objectEntity) {
        if (objectEntity == null) {
            return null;
        }
        final ObjectModel objectModel = new ObjectModel();
        objectModel.setId(objectEntity.getId());
        objectModel.setName(objectEntity.getName());
        objectModel.setType(objectEntity.getType());
        return objectModel;
    }

    @Override
    public ObjectEntity modelToEntity(ObjectModel objectModel) {
        if (objectModel == null) {
            return null;
        }
        final ObjectEntity objectEntity = new ObjectEntity();
        objectEntity.setId(objectModel.getId());
        objectEntity.setName(objectModel.getName());
        objectEntity.setType(objectModel.getType());
        return objectEntity;
    }

    @Override
    public List<ObjectModel> entitiesToModels(List<ObjectEntity> objectEntities) {
        if (objectEntities == null) {
            return null;
        }
        return objectEntities.stream()
                .map(this::entityToModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<ObjectEntity> modelsToEntities(List<ObjectModel> objectModels) {
        if (objectModels == null) {
            return null;
        }
        return objectModels.stream()
                .map(this::modelToEntity)
                .collect(Collectors.toList());
    }
}
