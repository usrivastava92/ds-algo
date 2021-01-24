package com.prep.lld.cachingsystem.policies;

public interface IEvictionPolicy<Key> {

    void access(Key key);
    Key getKeyToBeEvicted();
    void remove(Key key);

}
