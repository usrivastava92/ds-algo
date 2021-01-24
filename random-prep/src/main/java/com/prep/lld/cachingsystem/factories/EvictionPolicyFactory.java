package com.prep.lld.cachingsystem.factories;

import com.prep.lld.cachingsystem.policies.EEvictionPolicies;
import com.prep.lld.cachingsystem.policies.IEvictionPolicy;
import com.prep.lld.cachingsystem.policies.LRUEvictionPolicy;
import com.prep.lld.cachingsystem.policies.NoEvictionPolicy;


public class EvictionPolicyFactory {

    public static <Key> IEvictionPolicy<Key> getFactory(EEvictionPolicies evictionPolicy) {
        switch (evictionPolicy) {
            case LRU:
                return new LRUEvictionPolicy<>();
        }
        return new NoEvictionPolicy<>();
    }

}
