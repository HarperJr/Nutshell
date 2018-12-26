package mapper;

import database.entity.EntityWithId;
import model.ModelWithId;

import java.util.List;

public interface AbstractMapper<Model extends ModelWithId, Entity extends EntityWithId> {

    Model entityToModel(Entity entity);

    Entity modelToEntity(Model model);

    List<Model> entitiesToModels(List<Entity> entities);

    List<Entity> modelsToEntities(List<Model> models);
}
