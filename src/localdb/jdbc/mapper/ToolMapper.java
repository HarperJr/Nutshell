package localdb.jdbc.mapper;

import localdb.jdbc.entity.ToolEntity;
import localdb.jdbc.mapper.base.BaseMapper;
import localdb.model.Tool;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = EnchantTypeMapper.class)
public interface ToolMapper extends BaseMapper<Tool, ToolEntity> {

    @Override
    @Mapping(target = "enchant", source = "enchantId")
    Tool entityToModel(ToolEntity entity);

    @Override
    @Mapping(target = "enchantId", source = "enchant")
    ToolEntity modelToEntity(Tool model);
}
