package com.codechef.dsa.week3;

import com.codechef.utility.Reader;

import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

public class SaveKonoha {

    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        int testcaseCount = reader.nextInt();
        while (testcaseCount-- > 0) {
            int n = reader.nextInt();
            int z = reader.nextInt();

            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

            for (int i = 0; i < n; i++) {
                maxHeap.add(reader.nextInt());
            }

            int count = 0;
            while (z > 0 && !maxHeap.isEmpty()) {
                int power = maxHeap.poll();
                z -= power;
                int newPower = power / 2;
                if (newPower != 0) {
                    maxHeap.add(newPower);
                }
                count++;
            }
            if (z > 0) {
                System.out.println("Evacuate");
            }else{
                System.out.println(count);
            }
        }

        reader.close();
    }


}
