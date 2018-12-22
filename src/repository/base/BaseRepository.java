package repository.base;

import java.util.List;

public interface BaseRepository<Model, Id> {

    Model find(Id id);

    List<Model> getAll();

    void insert(Model model);

    void delete(Model model);

    void update(Model model);
}
