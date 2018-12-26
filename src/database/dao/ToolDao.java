package database.dao;

import database.entity.ToolEntity;

import java.util.List;

public interface ToolDao extends AbstractDao<ToolEntity, Integer> {
    List<ToolEntity> findOfType(String type);
}
