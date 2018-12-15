package localdb.model.base;

public interface ModelWithId<Id> {

    Id getId();

    void setId(Id id);
}
