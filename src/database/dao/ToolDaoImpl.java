package database.dao;

import database.entity.ToolEntity;
import database.mysql.ConnectionProperties;
import database.mysql.MySqlConnector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ToolDaoImpl implements ToolDao {

    private MySqlConnector sqlConnector;

    public ToolDaoImpl() {
        this.sqlConnector = new MySqlConnector(
                ConnectionProperties.createMySqlProperties("tool", "root", "root"));
    }

    @Override
    public List<ToolEntity> findOfType(String type) {
        try (PreparedStatement statement = sqlConnector.getConnection()
                .prepareStatement("select * from Tool where type = ?")) {
            statement.setString(1, type);
            return extractEntities(statement.executeQuery());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void insert(ToolEntity entity) {
        try (PreparedStatement statement = sqlConnector.getConnection()
                .prepareStatement("insert into Tool (name, type, description) values (?, ?, ?)")) {
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getType());
            statement.setString(3, entity.getDescription());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<ToolEntity> getAll() {
        try (PreparedStatement statement = sqlConnector.getConnection()
                .prepareStatement("select * from Tool")) {
            return extractEntities(statement.executeQuery());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public ToolEntity find(Integer id) {
        try (PreparedStatement statement = sqlConnector.getConnection()
                .prepareStatement("select * from Tool where id = ?")) {
            statement.setInt(1, id);
            return Optional.ofNullable(extractEntities(statement.executeQuery()))
                    .map(entities -> entities.stream().findFirst())
                    .get()
                    .orElse(null);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(ToolEntity entity) {
        try (PreparedStatement statement = sqlConnector.getConnection()
                .prepareStatement("delete from Tool where id = ? and name = ? and type = ? and description = ?")) {
            statement.setInt(1, entity.getId());
            statement.setString(2, entity.getName());
            statement.setString(3, entity.getType());
            statement.setString(4, entity.getDescription());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (PreparedStatement statement = sqlConnector.getConnection()
                .prepareStatement("delete from Tool where id = ?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(ToolEntity entity) {
        try (PreparedStatement statement = sqlConnector.getConnection()
                .prepareStatement("update Object set name = ?, type = ?, description = ? where id = ?")) {
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getType());
            statement.setString(3, entity.getDescription());
            statement.setInt(4, entity.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private List<ToolEntity> extractEntities(ResultSet resultSet) throws SQLException {
        if (resultSet == null) return null;
        List<ToolEntity> toolEntities = new ArrayList<>();
        try (ResultSet result = resultSet) {
            while (resultSet.next()) {
                ToolEntity toolEntity = new ToolEntity();
                toolEntity.setId(result.getInt("id"));
                toolEntity.setName(result.getString("name"));
                toolEntity.setType(result.getString("type"));
                toolEntity.setDescription(result.getString("description"));
                toolEntities.add(toolEntity);
            }
        }
        return toolEntities;
    }
}
