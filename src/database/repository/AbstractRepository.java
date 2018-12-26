package database.repository;

import model.ModelWithId;

import java.util.List;

public interface AbstractRepository<Model extends ModelWithId, Id> {

    void insert(Model model);

    List<Model> getAll();

    Model find(Id id);

    void delete(Model model);

    void delete(Id id);

    void update(Model model);
}
