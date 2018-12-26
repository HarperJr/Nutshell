package mapper;

import database.entity.ToolEntity;
import model.Tool;

import java.util.List;
import java.util.stream.Collectors;

public class ToolMapper implements AbstractMapper<Tool, ToolEntity> {

    @Override
    public Tool entityToModel(ToolEntity entity) {
        if (entity == null) return null;
        final Tool tool = new Tool();
        tool.setId(entity.getId());
        tool.setName(entity.getName());
        tool.setType(entity.getType());
        tool.setDescription(entity.getDescription());
        return tool;
    }

    @Override
    public ToolEntity modelToEntity(Tool model) {
        if (model == null) return null;
        final ToolEntity entity = new ToolEntity();
        entity.setId(model.getId());
        entity.setName(model.getName());
        entity.setType(model.getType());
        entity.setDescription(model.getDescription());
        return entity;
    }

    @Override
    public List<Tool> entitiesToModels(List<ToolEntity> toolEntities) {
        return toolEntities.stream()
                .map(this::entityToModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<ToolEntity> modelsToEntities(List<Tool> toolModels) {
        return toolModels.stream()
                .map(this::modelToEntity)
                .collect(Collectors.toList());
    }
}
