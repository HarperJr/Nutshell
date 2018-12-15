package localdb.repository;

import localdb.jdbc.entity.EnchantEntity;
import localdb.model.Enchant;
import localdb.repository.base.BaseRepository;

import java.sql.Time;
import java.util.List;

public interface EnchantRepository extends BaseRepository<Enchant, EnchantEntity> {

    Enchant getMatchesName(String name);

    List<Enchant> getByDurationLessThen(Time duration);
}
