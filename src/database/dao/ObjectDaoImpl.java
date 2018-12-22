package database.dao;

import database.entity.ObjectEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ObjectDaoImpl implements ObjectDao {

    private final DataSource dataSource;

    @Autowired
    public ObjectDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public ObjectEntity find(Integer id) {
        try (Connection connection = dataSource.getConnection()) {
            final PreparedStatement statement = connection.prepareStatement("select * from Object where id = ? limit 1");
            statement.setInt(1, id);
            return Optional.ofNullable(extractEntity(statement.executeQuery()))
                    .map(entities -> entities.stream().findFirst())
                    .get().orElse(null);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ObjectEntity> findObjectsOfType(String type) {
        try (Connection connection = dataSource.getConnection()) {
            final PreparedStatement statement = connection.prepareStatement("select * from Object where type like ?");
            statement.setString(1, type);
            return extractEntity(statement.executeQuery());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ObjectEntity> getAll() {
        try (Connection connection = dataSource.getConnection()) {
            final PreparedStatement statement = connection.prepareStatement("select * from Object");
            return extractEntity(statement.executeQuery());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public void insert(ObjectEntity objectEntity) {
        try (Connection connection = dataSource.getConnection()) {
            final PreparedStatement statement = connection.prepareStatement("insert into Object (name, type) values (?, ?)");
            statement.setString(1, objectEntity.getName());
            statement.setString(2, objectEntity.getType());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(ObjectEntity objectEntity) {
        try (Connection connection = dataSource.getConnection()) {
            final PreparedStatement statement = connection.prepareStatement("delete from Object where id = ? and name = ? and type = ?");
            statement.setInt(1, objectEntity.getId());
            statement.setString(2, objectEntity.getName());
            statement.setString(3, objectEntity.getType());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(ObjectEntity objectEntity) {
        try (Connection connection = dataSource.getConnection()) {
            final PreparedStatement statement = connection.prepareStatement("update Object set name = ?, type = ? where id = ?");
            statement.setString(1, objectEntity.getName());
            statement.setString(2, objectEntity.getType());
            statement.setInt(3, objectEntity.getId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private List<ObjectEntity> extractEntity(ResultSet result) {
        final List<ObjectEntity> entities = new ArrayList<>();
        try (ResultSet set = result) {
            while (set.next()) {
                ObjectEntity entity = new ObjectEntity();
                entity.setId(result.getInt("id"));
                entity.setName(result.getString("name"));
                entity.setType(result.getString("type"));
                entities.add(entity);
            }
            return entities;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
