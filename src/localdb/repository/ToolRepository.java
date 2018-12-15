package localdb.repository;

import localdb.jdbc.entity.ToolEntity;
import localdb.model.Tool;
import localdb.repository.base.BaseRepository;

public interface ToolRepository extends BaseRepository<Tool, ToolEntity> {
    Tool getByEnchantId(int enchantId);
}
