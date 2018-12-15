package localdb.jdbc.dao;

import localdb.jdbc.base.BaseDatabase;
import localdb.jdbc.dao.base.BaseDao;
import localdb.jdbc.entity.ToolEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ToolDao implements BaseDao<ToolEntity> {

    private final Logger logger;
    private final BaseDatabase database;

    public ToolDao(BaseDatabase database) {
        this.database = database;
        this.logger = database.getLogger();
    }

    @Override
    public List<ToolEntity> getAll() {
        List<ToolEntity> toolEntities = new ArrayList<>();
        try (final PreparedStatement preparedStatement = database.getConnection()
                .prepareStatement("select * from Tool")) {
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    final ToolEntity toolEntity = new ToolEntity();
                    toolEntity.setId(resultSet.getInt("id"));
                    toolEntity.setName(resultSet.getString("name"));
                    toolEntity.setDamage(resultSet.getFloat("damage"));
                    toolEntity.setHardness(resultSet.getFloat("hardness"));
                    toolEntity.setEnchantId(resultSet.getInt("enchant_id"));

                    toolEntities.add(toolEntity);
                }
            }
        } catch (SQLException ex) {
            logger.log(Level.FINE, ex.getMessage());
        }
        return toolEntities;
    }

    @Override
    public boolean update(ToolEntity toolEntity) {
        try (final PreparedStatement preparedStatement = database.getConnection()
                .prepareStatement("update Tool set id = ?, name = ?, damage = ?, hardness = ?, enchant_id = ? where id = ?")) {
            preparedStatement.setInt(1, toolEntity.getId());
            preparedStatement.setString(2, toolEntity.getName());
            preparedStatement.setFloat(3, toolEntity.getDamage());
            preparedStatement.setFloat(4, toolEntity.getHardness());
            preparedStatement.setInt(5, toolEntity.getEnchantId());
            preparedStatement.setInt(6, toolEntity.getId());

            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException ex) {
            logger.log(Level.FINE, ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(ToolEntity toolEntity) {
        try (final PreparedStatement preparedStatement = database.getConnection()
                .prepareStatement("delete from Tool where id = ? and name = ? and damage = ? and hardness = ? and enchant_id = ?")) {
            preparedStatement.setInt(1, toolEntity.getId());
            preparedStatement.setString(2, toolEntity.getName());
            preparedStatement.setFloat(3, toolEntity.getDamage());
            preparedStatement.setFloat(4, toolEntity.getHardness());
            preparedStatement.setInt(5, toolEntity.getEnchantId());

            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException ex) {
            logger.log(Level.FINE, ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean insert(ToolEntity toolEntity) {
        try (final PreparedStatement preparedStatement = database.getConnection()
                .prepareStatement("insert into Tool (name, damage, hardness, enchant_id) values (?, ?, ?, ?)")) {
            preparedStatement.setString(1, toolEntity.getName());
            preparedStatement.setFloat(2, toolEntity.getDamage());
            preparedStatement.setFloat(3, toolEntity.getHardness());
            if (toolEntity.getEnchantId() != 0) {
                preparedStatement.setInt(4, toolEntity.getEnchantId());
            } else {
                preparedStatement.setNull(4, Types.INTEGER);
            }

            return preparedStatement.executeUpdate() == 1;
        } catch (SQLException ex) {
            logger.log(Level.FINE, ex.getMessage());
        }
        return false;
    }

    @Override
    public ToolEntity getById(int id) {
        try (final PreparedStatement preparedStatement = database.getConnection()
                .prepareStatement("select * from Tool where id = ? limit 1")) {
            preparedStatement.setInt(1, id);
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    final ToolEntity toolEntity = new ToolEntity();
                    toolEntity.setId(resultSet.getInt("id"));
                    toolEntity.setName(resultSet.getString("name"));
                    toolEntity.setDamage(resultSet.getFloat("damage"));
                    toolEntity.setHardness(resultSet.getFloat("hardness"));
                    toolEntity.setEnchantId(resultSet.getInt("enchant_id"));

                    return toolEntity;
                }
            }
        } catch (SQLException ex) {
            logger.log(Level.FINE, ex.getMessage());
        }
        return null;
    }

    public ToolEntity getByEnchantId(int enchantId) {
        try (final PreparedStatement preparedStatement = database.getConnection()
                .prepareStatement("select * from Tool where enchantId = ? limit 1")) {
            preparedStatement.setInt(1, enchantId);
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    final ToolEntity toolEntity = new ToolEntity();
                    toolEntity.setId(resultSet.getInt("id"));
                    toolEntity.setName(resultSet.getString("name"));
                    toolEntity.setDamage(resultSet.getFloat("damage"));
                    toolEntity.setHardness(resultSet.getFloat("hardness"));
                    toolEntity.setEnchantId(resultSet.getInt("enchant_id"));

                    return toolEntity;
                }
            }
        } catch (SQLException ex) {
            logger.log(Level.FINE, ex.getMessage());
        }
        return null;
    }
}
