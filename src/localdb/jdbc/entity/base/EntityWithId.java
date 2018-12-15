package localdb.jdbc.entity.base;

public interface EntityWithId<Id> {

    Id getId();

    void setId(Id id);
}
