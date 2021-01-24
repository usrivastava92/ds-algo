package com.prep.lld.cachingsystem.policies;

public class NoEvictionPolicy<Key> implements IEvictionPolicy<Key> {

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
