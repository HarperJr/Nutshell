package localdb.jdbc.dao;

import localdb.jdbc.base.BaseDatabase;
import localdb.jdbc.dao.base.BaseDao;
import localdb.jdbc.entity.EnchantEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EnchantDao implements BaseDao<EnchantEntity> {

    private final Logger logger;
    private final BaseDatabase database;

    public EnchantDao(BaseDatabase database) {
        this.database = database;
        this.logger = database.getLogger();
    }

    @Override
    public List<EnchantEntity> getAll() {
        List<EnchantEntity> enchantEntities = new ArrayList<>();
        try (final PreparedStatement preparedStatement = database.getConnection()
                .prepareStatement("select * from Enchant")) {
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    final EnchantEntity enchantEntity = new EnchantEntity();
                    enchantEntity.setId(resultSet.getInt("id"));
                    enchantEntity.setName(resultSet.getString("name"));
                    enchantEntity.setDescription(resultSet.getString("description"));
                    enchantEntity.setDuration(resultSet.getTime("duration"));

                    enchantEntities.add(enchantEntity);
                }
            }
        } catch (SQLException ex) {
            logger.log(Level.FINE, ex.getMessage());
        }
        return enchantEntities;
    }

    @Override
    public boolean update(EnchantEntity enchantEntity) {
        try (final PreparedStatement preparedStatement = database.getConnection()
                .prepareStatement("update Enchant set id = ?, name = ?, description = ?, duration = ? where id = ?")) {
            preparedStatement.setInt(1, enchantEntity.getId());
            preparedStatement.setString(2, enchantEntity.getName());
            preparedStatement.setString(3, enchantEntity.getDescription());
            preparedStatement.setTime(4, enchantEntity.getDuration());
            preparedStatement.setInt(5, enchantEntity.getId());

            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException ex) {
            logger.log(Level.FINE, ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(EnchantEntity enchantEntity) {
        try (final PreparedStatement preparedStatement = database.getConnection()
        .prepareStatement("delete from Enchant where id = ? and name = ? and description = ? and duration = ?")) {
            preparedStatement.setInt(1, enchantEntity.getId());
            preparedStatement.setString(2, enchantEntity.getName());
            preparedStatement.setString(3, enchantEntity.getDescription());
            preparedStatement.setTime(4, enchantEntity.getDuration());

            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException ex) {
            logger.log(Level.FINE, ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean insert(EnchantEntity enchantEntity) {
        try (final PreparedStatement preparedStatement = database.getConnection()
        .prepareStatement("insert into Enchant (name, description, duration) values (?, ?, ?)")) {
            preparedStatement.setString(1, enchantEntity.getName());
            preparedStatement.setString(2, enchantEntity.getDescription());
            preparedStatement.setTime(3, enchantEntity.getDuration());

            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException ex) {
            logger.log(Level.FINE, ex.getMessage());
        }
        return false;
    }

    @Override
    public EnchantEntity getById(int id) {
        try (final PreparedStatement preparedStatement = database.getConnection()
        .prepareStatement("select * from Enchant where id = ? limit 1")) {
            preparedStatement.setInt(1, id);
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    final EnchantEntity enchantEntity = new EnchantEntity();
                    enchantEntity.setId(resultSet.getInt("id"));
                    enchantEntity.setName(resultSet.getString("name"));
                    enchantEntity.setDescription(resultSet.getString("description"));
                    enchantEntity.setDuration(resultSet.getTime("duration"));

                    return enchantEntity;
                }
            }
        } catch (SQLException ex) {
            logger.log(Level.FINE, ex.getMessage());
        }
        return null;
    }

    public EnchantEntity getMatchesName(String name) {
        try (final PreparedStatement preparedStatement = database.getConnection()
        .prepareStatement("select * from Enchant where name like ?")) {
            preparedStatement.setString(1, name);
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    final EnchantEntity enchantEntity = new EnchantEntity();
                    enchantEntity.setId(resultSet.getInt("id"));
                    enchantEntity.setName(resultSet.getString("name"));
                    enchantEntity.setDescription(resultSet.getString("description"));
                    enchantEntity.setDuration(resultSet.getTime("duration"));

                    return enchantEntity;
                }
            }
        } catch (SQLException ex) {
            logger.log(Level.FINE, ex.getMessage());
        }
        return null;
    }

    public List<EnchantEntity> getByDurationLessThen(Time duration) {
        List<EnchantEntity> enchantEntities = new ArrayList<>();
        try (final PreparedStatement preparedStatement = database.getConnection()
                .prepareStatement("select * from Enchant where duration < ?")) {
            preparedStatement.setTime(1, duration);
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    final EnchantEntity enchantEntity = new EnchantEntity();
                    enchantEntity.setId(resultSet.getInt("id"));
                    enchantEntity.setName(resultSet.getString("name"));
                    enchantEntity.setDescription(resultSet.getString("description"));
                    enchantEntity.setDuration(resultSet.getTime("duration"));

                    enchantEntities.add(enchantEntity);
                }
            }
        } catch (SQLException ex) {
            logger.log(Level.FINE, ex.getMessage());
        }
        return enchantEntities;
    }
}
