package database.entity;

public interface EntityWithId<Id> {

    Id getId();

    void setId(Id id);
}
