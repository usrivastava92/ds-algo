package com.leet.ds.array;

import java.util.ArrayDeque;
import java.util.Arrays;

public class RevealCardsInIncreasingOrder {
    public static void main(String[] args) {
        RevealCardsInIncreasingOrder revealCardsInIncreasingOrder = new RevealCardsInIncreasingOrder();
        int[] deck = new int[]{17, 13, 11, 2, 3, 5, 7, 19, 23};
        revealCardsInIncreasingOrder.deckRevealedIncreasing(deck);
    }

    public int[] deckRevealedIncreasing(int[] deck) {
        int len = deck.length;
        int[] result = new int[len];

        Arrays.sort(deck);
        int j = 0;
        boolean insert = true;
        int i = 0;
        while (j < len) {
            if (i >= len) {
                i = 0;
            }
            if (insert) {
                if (result[i] == 0) {
                    result[i] = deck[j++];
                    insert = false;
                }
            } else {
                if (result[i] == 0) {
                    insert = true;
                }
            }
            System.out.println(Arrays.toString(result)+" -> "+i);

            i++;
        }

        removeDeck(result);
        return result;
    }

    public void removeDeck(int[] deck) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i : deck) {
            deque.add(i);
        }
        boolean firstTurn = true;
        while (!deque.isEmpty()) {
            if (firstTurn) {
                System.out.print(deque.removeFirst() + " ");
            } else {
                deque.add(deque.removeFirst());
            }
            firstTurn = !firstTurn;
        }
    }
}
