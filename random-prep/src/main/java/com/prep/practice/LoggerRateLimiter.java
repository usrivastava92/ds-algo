package com.prep.practice;

import org.junit.Assert;

import java.util.HashMap;
import java.util.stream.IntStream;

public class LoggerRateLimiter {

    public static void main(String[] args) {
        String[][] messages = {{"foo", "bar", "foo", "bar", "foo", "foo"}};
        int[][] timestamps = {{1, 2, 3, 8, 10, 11}};
        boolean[][] outputs = {{true, true, false, false, false, true}};
        IntStream.range(0, messages.length).forEachOrdered(i -> {
            Logger logger = new Logger();
            IntStream.range(0, messages[i].length).forEachOrdered(j -> {
                System.out.println("timestamp : " + timestamps[i][j] + ", message : " + messages[i][j]);
                boolean output = logger.shouldPrintMessage(timestamps[i][j], messages[i][j]);
                System.out.println("Output : " + output);
                Assert.assertEquals(outputs[i][j], output);
            });
        });
    }

    private static final class Logger {

        private final HashMap<String, Integer> map;

        public Logger() {
            this.map = new HashMap<>();
        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            if (map.containsKey(message) && timestamp - map.get(message) < 10) {
                return false;
            }
            map.put(message, timestamp);
            return true;
        }

    }


}
