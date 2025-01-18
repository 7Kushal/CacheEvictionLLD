import EvictionPolicy.Policy;
import Exception.*;
import StorageModule.Storage;

public class Cache <Key, Value> {
    final Policy<Key> policy;
    final Storage<Key,Value> storage;
    Cache(Policy<Key> policy, Storage<Key,Value> storage){
        this.policy = policy;
        this.storage=storage;
    }

    public void add(Key key, Value value){
        try {
            this.storage.putValue(key,value);
            this.policy.keyaccessed(key);
        }
        catch (StoageFullException e){
            System.out.println("The storage is full");
            Key KeyToRemove = policy.evictKey();
            if(KeyToRemove ==null)
                throw new RuntimeException("No StorageModule.Storage capacity");
            this.storage.remove(KeyToRemove);
            System.out.println(KeyToRemove +" has been removed from the pool ");
            add(key,value);
        }
    }

    public Value fetch(Key key){
        try {
            Value value = this.storage.getValue(key);
            System.out.println("The value for key : " + key + " is = "+ value);
            this.policy.keyaccessed(key);
            return value;
        } catch (NotFoundException e) {
            System.out.println("Key is not found, enter a valid key");
            return null;
        }
    }

}
