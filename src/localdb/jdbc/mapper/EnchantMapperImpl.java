package localdb.jdbc.mapper;

import localdb.jdbc.entity.EnchantEntity;
import localdb.model.Enchant;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.List;

@Generated(
        value = "org.mapstruct.ap.MappingProcessor",
        date = "2018-12-15T17:07:35+0300",
        comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
public class EnchantMapperImpl implements EnchantMapper {

    @Override
    public EnchantEntity modelToEntity(Enchant model) {
        if (model == null) {
            return null;
        }

        EnchantEntity enchantEntity = new EnchantEntity();

        enchantEntity.setId(model.getId());
        enchantEntity.setName(model.getName());
        enchantEntity.setDescription(model.getDescription());
        enchantEntity.setDuration(model.getDuration());

        return enchantEntity;
    }

    @Override
    public Enchant entityToModel(EnchantEntity entity) {
        if (entity == null) {
            return null;
        }

        Enchant enchant = new Enchant();

        enchant.setId(entity.getId());
        enchant.setName(entity.getName());
        enchant.setDescription(entity.getDescription());
        enchant.setDuration(entity.getDuration());

        return enchant;
    }

    @Override
    public List<EnchantEntity> modelListToEntityList(List<Enchant> models) {
        if (models == null) {
            return null;
        }

        List<EnchantEntity> list = new ArrayList<EnchantEntity>(models.size());
        for (Enchant enchant : models) {
            list.add(modelToEntity(enchant));
        }

        return list;
    }

    @Override
    public List<Enchant> entityListToModelList(List<EnchantEntity> entities) {
        if (entities == null) {
            return null;
        }

        List<Enchant> list = new ArrayList<Enchant>(entities.size());
        for (EnchantEntity enchantEntity : entities) {
            list.add(entityToModel(enchantEntity));
        }

        return list;
    }
}
