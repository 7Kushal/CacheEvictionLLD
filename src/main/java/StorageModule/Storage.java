package StorageModule;

public interface Storage<Key,Value> {
    void putValue(Key key, Value value);
    Value getValue(Key key);
    void remove(Key key);
}
