package az.lld.cachingsystem.policies;

import com.ds.linkedlist.DoublyLinkedListNode;

import java.util.HashMap;
import java.util.Map;

public class LRUEvictionPolicy<Key> implements IEvictionPolicy<Key> {

    private final Map<Key, DoublyLinkedListNode<Key>> map;
    private DoublyLinkedListNode<Key> start;
    private DoublyLinkedListNode<Key> end;

    public LRUEvictionPolicy() {
        this.map = new HashMap<>();
    }

    @Override
    public void access(Key key) {
    }

    @Override
    public Key getKeyToBeEvicted() {
        return null;
    }

    @Override
    public void remove(Key key) {

    }

}
