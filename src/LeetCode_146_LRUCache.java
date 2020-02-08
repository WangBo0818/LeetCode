import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author wb
 * @date 2020/2/8 - 10:08
 * LeetCode---146. LRU 缓存机制
 */
public class LeetCode_146_LRUCache {

    int capacity;
    LinkedHashMap<Integer, Integer> cache;

    public LeetCode_146_LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return cache.size() > capacity;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}
