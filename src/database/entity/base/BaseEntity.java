package database.entity.base;

public interface BaseEntity<Id> {

    Id getId();

    void setId(Id id);
}
