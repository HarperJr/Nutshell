package database.dao;

import database.dao.base.BaseDao;
import database.entity.ObjectEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObjectDao extends BaseDao<ObjectEntity, Integer> {
    List<ObjectEntity> findObjectsOfType(String type);
}
