package mapper.base;

import java.util.List;

public interface BaseMapper<Model, Entity> {

    Model entityToModel(Entity entity);

    Entity modelToEntity(Model model);

    List<Model> entitiesToModels(List<Entity> entities);

    List<Entity> modelsToEntities(List<Model> models);
}
