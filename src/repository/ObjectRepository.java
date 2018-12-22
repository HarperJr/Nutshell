package repository;

import repository.base.BaseRepository;
import model.ObjectModel;

import java.util.List;

public interface ObjectRepository extends BaseRepository<ObjectModel, Integer> {
    List<ObjectModel> findObjectsOfType(String type);

}
