package database.dao;

import database.entity.EntityWithId;

import java.util.List;

public interface AbstractDao<Entity extends EntityWithId, Id> {

    void insert(Entity entity);

    List<Entity> getAll();

    Entity find(Id id);

    void delete(Entity entity);

    void delete(Id id);

    void update(Entity entity);
}
