package EvictionPolicy;

public interface Policy<Key> {
    void keyaccessed(Key key);
    Key evictKey();
}
