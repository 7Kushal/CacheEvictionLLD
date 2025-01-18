import EvictionPolicy.LRU;
import StorageModule.MapBased;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Cache<Integer,Integer> cache = new Cache<>(new LRU<>(),new MapBased<>(3));
        cache.add(3,10);
        cache.add(5,30);
        cache.add(10,50);
        cache.fetch(5);
        cache.add(4,5);
        cache.fetch(3);
    }
}