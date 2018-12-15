package localdb.jdbc.mapper;

import localdb.jdbc.entity.ToolEntity;
import localdb.model.Tool;
import org.mapstruct.factory.Mappers;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.List;

@Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        date = "2018-12-15T17:07:35+0300",
        comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
public class ToolMapperImpl implements ToolMapper {

    private final EnchantTypeMapper enchantTypeMapper = Mappers.getMapper(EnchantTypeMapper.class);

    @Override
    public List<ToolEntity> modelListToEntityList(List<Tool> models) {
        if (models == null) {
            return null;
        }

        List<ToolEntity> list = new ArrayList<ToolEntity>(models.size());
        for (Tool tool : models) {
            list.add(modelToEntity(tool));
        }

        return list;
    }

    @Override
    public List<Tool> entityListToModelList(List<ToolEntity> entities) {
        if (entities == null) {
            return null;
        }

        List<Tool> list = new ArrayList<Tool>(entities.size());
        for (ToolEntity toolEntity : entities) {
            list.add(entityToModel(toolEntity));
        }

        return list;
    }

    @Override
    public Tool entityToModel(ToolEntity entity) {
        if (entity == null) {
            return null;
        }

        Tool tool = new Tool();

        tool.setEnchant(enchantTypeMapper.entityToModel(entity.getEnchantId()));
        tool.setId(entity.getId());
        tool.setDamage(entity.getDamage());
        tool.setHardness(entity.getHardness());
        tool.setName(entity.getName());

        return tool;
    }

    @Override
    public ToolEntity modelToEntity(Tool model) {
        if (model == null) {
            return null;
        }

        ToolEntity toolEntity = new ToolEntity();

        toolEntity.setEnchantId(enchantTypeMapper.modelToEntity(model.getEnchant()));
        toolEntity.setId(model.getId());
        toolEntity.setName(model.getName());
        toolEntity.setDamage(model.getDamage());
        toolEntity.setHardness(model.getHardness());

        return toolEntity;
    }
}
