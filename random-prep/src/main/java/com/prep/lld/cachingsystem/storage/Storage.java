package com.prep.lld.cachingsystem.storage;

import com.prep.lld.cachingsystem.factories.EvictionPolicyFactory;
import com.prep.lld.cachingsystem.policies.EEvictionPolicies;
import com.prep.lld.cachingsystem.policies.IEvictionPolicy;

public abstract class Storage<Key, Value> {

    protected final IEvictionPolicy<Key> evictionPolicy;
    protected final Long maxSize;

    public Storage(EEvictionPolicies policy, Long maxSize) {
        this.maxSize = maxSize;
        this.evictionPolicy = EvictionPolicyFactory.getFactory(policy);
    }

    abstract public boolean add(Key key, Value value);

    abstract public Value get(Key key);

    abstract public void remove(Key key);

}
