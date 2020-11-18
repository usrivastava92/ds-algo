package az.lld.cachingsystem.factories;

import az.lld.cachingsystem.policies.EEvictionPolicies;
import az.lld.cachingsystem.policies.IEvictionPolicy;
import az.lld.cachingsystem.policies.LRUEvictionPolicy;
import az.lld.cachingsystem.policies.NoEvictionPolicy;


public class EvictionPolicyFactory {

    public static <Key> IEvictionPolicy<Key> getFactory(EEvictionPolicies evictionPolicy) {
        switch (evictionPolicy) {
            case LRU:
                return new LRUEvictionPolicy<>();
        }
        return new NoEvictionPolicy<>();
    }

}
