package az.lld.cachingsystem.storage;

import az.lld.cachingsystem.policies.EEvictionPolicies;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashStorage<Key, Value> extends Storage<Key, Value> {

    private final Map<Key, Value> map;

    public HashStorage(EEvictionPolicies evictionPolicy, long maxSize) {
        super(evictionPolicy, maxSize);
        this.map = new HashMap<>();
    }

    public HashStorage(EEvictionPolicies evictionPolicy) {
        super(evictionPolicy, null);
        this.map = new HashMap<>();
    }

    @Override
    public boolean add(Key key, Value value) {
        if (isStorageFull()) {
            Key evictionKey = evictionPolicy.getKeyToBeEvicted();
            map.remove(evictionKey);
        }
        map.put(key, value);
        return true;
    }

    @Override
    public Value get(Key key) {
        evictionPolicy.access(key);
        return map.get(key);
    }

    @Override
    public void remove(Key key) {
        evictionPolicy.remove(key);
        map.remove(key);
    }

    private boolean isStorageFull() {
        if (Objects.isNull(maxSize)) {
            return false;
        }
        return map.size() >= maxSize;
    }

}
