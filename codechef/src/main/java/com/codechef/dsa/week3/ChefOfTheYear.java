package com.codechef.dsa.week3;

import com.codechef.utility.Reader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ChefOfTheYear {


    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();

        int m = reader.nextInt();
        int n = reader.nextInt();

        Map<String, String> country = new HashMap<>();

        for (int i = 0; i < m; i++) {
            String[] tokens = reader.nextLine().trim().split(" ");
            country.put(tokens[0], tokens[1]);
        }

        Map<String, Integer> playerVotes = new HashMap<>();
        Map<String, Integer> countryVotes = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String playerName = reader.nextLine();
            playerVotes.put(playerName, playerVotes.getOrDefault(playerName, 0) + 1);
            String playerCountry = country.get(playerName);
            countryVotes.put(playerCountry, countryVotes.getOrDefault(playerCountry, 0) + 1);
        }

        PriorityQueue<String> playerQueue = new PriorityQueue<>();
        fillQueueWithMax(playerVotes, playerQueue);

        PriorityQueue<String> countryQueue = new PriorityQueue<>();
        fillQueueWithMax(countryVotes, countryQueue);

        System.out.println(countryQueue.poll());
        System.out.println(playerQueue.poll());
        reader.close();
    }

    private static void fillQueueWithMax(Map<String, Integer> playerVotes, PriorityQueue<String> queue) {
        int max = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> entry : playerVotes.entrySet()) {
            if (entry.getValue() > max) {
                queue = new PriorityQueue<>();
                queue.add(entry.getKey());
                max = entry.getValue();
            } else if (entry.getValue().equals(max)) {
                queue.add(entry.getKey());
            }
        }
    }


}
