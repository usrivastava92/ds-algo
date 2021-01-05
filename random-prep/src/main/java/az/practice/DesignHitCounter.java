package az.practice;

import org.junit.Assert;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;

public class DesignHitCounter {

    public static void main(String[] args) {
        HitCounter counter = new HitCounter();
        counter.hit(1);
        counter.hit(2);
        counter.hit(3);
        Assert.assertEquals(3, counter.getHits(4));
        counter.hit(300);
        Assert.assertEquals(4, counter.getHits(300));
        Assert.assertEquals(3, counter.getHits(301));
        System.out.println("Success...");
    }

    private static final class HitCounter {

        private final Queue<Integer> hits;

        public HitCounter() {
            this.hits = new ArrayDeque<>();
        }

        public void hit(int i) {
            while (!hits.isEmpty() && i - hits.peek() >= 300) {
                hits.poll();
            }
            hits.add(i);
        }

        public int getHits(int i) {
            while (!hits.isEmpty() && i - hits.peek() >= 300) {
                hits.poll();
            }
            return hits.size();
        }

    }

}
