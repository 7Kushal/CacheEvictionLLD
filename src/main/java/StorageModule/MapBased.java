package StorageModule;

import java.util.HashMap;
import Exception.*;

public class MapBased<Key, Value> implements Storage<Key,Value> {
    HashMap<Key, Value> map;
    int capacity;
    public MapBased(int capacity){
        this.map= new HashMap<Key, Value>();
        this.capacity =capacity;
    }

    @Override
    public void putValue(Key key, Value value) {
        if(map.size()==capacity) throw new StoageFullException("StorageModule.Storage is full, evicting the key");
        map.put(key,value);
    }

    @Override
    public Value getValue(Key key) {
        if(!map.containsKey(key))throw new NotFoundException("Key not found in the storage");
        return map.get(key);
    }

    @Override
    public void remove(Key key) {
        if(!map.containsKey(key)) throw new NotFoundException("Key is not present in the storage");
        map.remove(key);

    }
}
