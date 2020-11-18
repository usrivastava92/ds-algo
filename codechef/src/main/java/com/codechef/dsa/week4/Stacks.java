package com.codechef.dsa.week4;

import com.codechef.utility.Reader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Stacks {

    public static void main(String[] args) throws Exception {

        Reader reader = new Reader();

        int testCases = reader.nextInt();

        while (testCases-- > 0) {
            int n = reader.nextInt();

            List<Integer> stacks = new ArrayList<Integer>() {
                @Override
                public boolean add(Integer i) {
                    int high = size() - 1;
                    if (super.isEmpty() || i.compareTo(get(high)) >= 0) {
                        return super.add(i);
                    }
                    int low = 0;
                    while (high > low) {
                        int mid = low + ((high - low) / 2);
                        if (get(mid).compareTo(i) > 0) {
                            high = mid - 1;
                        } else {
                            low = mid + 1;
                        }
                    }
                    if (get(low) > i) {
                        set(low, i);
                    } else {
                        set(low + 1, i);
                    }
                    return true;
                }
            };

            for (int i = 0; i < n; i++) {
                stacks.add(reader.nextInt());
            }

            System.out.println(stacks.size() + " " + stacks.toString().replaceAll("[,]", "").replace("]", "").replace("[", ""));

        }

        reader.close();

    }

}
