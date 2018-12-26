package database.repository;

import model.Tool;

import java.util.List;

public interface ToolRepository extends AbstractRepository<Tool, Integer> {
    List<Tool> findMatchType(String type);
}
