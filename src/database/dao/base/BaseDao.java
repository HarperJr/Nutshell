package database.dao.base;

import java.util.List;

public interface BaseDao<Entity, Id> {

    Entity find(Id id);

    List<Entity> getAll();

    void insert(Entity model);

    void delete(Entity model);

    void update(Entity model);
}
