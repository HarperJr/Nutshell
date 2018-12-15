package localdb.repository.base;

import localdb.jdbc.dao.base.BaseDao;
import localdb.jdbc.entity.base.EntityWithId;
import localdb.jdbc.mapper.base.BaseMapper;
import localdb.model.base.ModelWithId;

import java.util.List;

public interface BaseRepository<Model extends ModelWithId, Entity extends EntityWithId> {
    BaseMapper<Model, Entity> getMapper();

    BaseDao<Entity> getDao();

    Model getById(int id);

    List<Model> getAll();

    boolean update(Model model);

    boolean delete(Model model);

    boolean insert(Model model);
}
