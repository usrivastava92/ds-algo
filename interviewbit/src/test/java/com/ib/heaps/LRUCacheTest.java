package com.ib.heaps;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LRUCacheTest {

  @Test
  public void getAndSet_evictLeastRecentlyUsedEntries() {
    Solution cache = new Solution(2);

    cache.set(1, 10);
    cache.set(2, 20);
    assertEquals(10, cache.get(1));

    cache.set(3, 30);
    assertEquals(-1, cache.get(2));
    assertEquals(30, cache.get(3));

    cache.set(1, 15);
    assertEquals(15, cache.get(1));
  }
}
