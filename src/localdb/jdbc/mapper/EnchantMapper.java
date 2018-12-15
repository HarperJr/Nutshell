package localdb.jdbc.mapper;

import localdb.jdbc.entity.EnchantEntity;
import localdb.jdbc.mapper.base.BaseMapper;
import localdb.model.Enchant;
import org.mapstruct.Mapper;

@Mapper
public interface EnchantMapper extends BaseMapper<Enchant, EnchantEntity> {
}
