package EvictionPolicy;

import java.util.HashMap;
import algo.*;
public class LRU<Key> implements Policy<Key>{
    DoublyLinkedList<Key> dll;
    HashMap<Key,DoublyLinkedListNode<Key>> mapper;
    int capacity;
    public LRU(){
        dll = new DoublyLinkedList<>();
        mapper= new HashMap<>();
    }
    @Override
    public void keyaccessed(Key key) {
        if (mapper.containsKey(key)) {
            dll.detachNode(mapper.get(key));
            dll.addNodeAtLast(mapper.get(key));
        } else {
            DoublyLinkedListNode<Key> newNode = dll.addElementAtLast(key);
            mapper.put(key, newNode);
        }
    }

    @Override
    public Key evictKey() {
        DoublyLinkedListNode<Key> first = dll.getFirstNode();
        if(first == null) {
            return null;
        }
        dll.detachNode(first);
        return first.getElement();
    }
}
