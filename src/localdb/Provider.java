package localdb;

public abstract class Provider<Entity> {
    protected abstract Entity provide();
}
