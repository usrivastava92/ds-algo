package com.codechef.longchallenge.june;

import com.codechef.utility.Reader;

import java.util.HashMap;
import java.util.Map;

public class ChefAndIcecream {

    public static void main(String[] args) throws Exception {
        Reader reader = new Reader();
        int testCases = reader.nextInt();
        while (testCases-- > 0) {
            int n = reader.nextInt();
            Map<Integer, Integer> map = new HashMap<>();
            boolean serve = true;
            while (n-- > 0) {
                int buyer = reader.nextInt();
                if (serve) {
                    int balance = buyer - 5;
                    if (balance == 5) {
                        if (map.containsKey(5)) {
                            map.put(5, map.get(5) - 1);
                            if (map.get(5) <= 0) {
                                map.remove(5);
                            }
                        } else {
                            serve = false;
                        }
                    } else if (balance == 10) {
                        if (map.containsKey(10)) {
                            map.put(10, map.get(10) - 1);
                            if (map.get(10) <= 0) {
                                map.remove(10);
                            }
                        } else if (map.containsKey(5) && map.get(5) >= 2) {
                            map.put(5, map.get(5) - 2);
                            if (map.get(5) <= 0) {
                                map.remove(5);
                            }
                        } else {
                            serve = false;
                        }
                    }
                    map.put(buyer, map.getOrDefault(buyer, 0) + 1);
                }
            }
            System.out.println(serve ? "YES" : "NO");
        }
        reader.close();
    }
}