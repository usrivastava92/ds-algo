package com.ib.heaps;

import lombok.ToString;

import java.util.*;

public class LRUCache {
    public static void main(String[] args) {
        String inputString = "95 11 S 1 1 G 11 G 11 S 3 10 G 10 S 3 12 S 1 15 S 4 12 G 15 S 8 6 S 5 3 G 2 G 12 G 10 S 11 5 G 7 S 5 1 S 15 5 G 2 S 13 8 G 3 S 14 2 S 12 11 S 7 10 S 5 4 G 9 G 2 S 13 5 S 10 14 S 9 11 G 5 S 13 11 S 8 12 G 10 S 5 12 G 8 G 11 G 8 S 9 11 S 10 6 S 7 12 S 1 7 G 10 G 9 G 15 G 15 G 3 S 15 4 G 10 G 14 G 10 G 12 G 12 S 14 7 G 11 S 9 10 S 6 12 S 14 11 G 3 S 7 5 S 1 14 S 2 8 S 11 12 S 8 4 G 3 S 13 15 S 1 4 S 5 3 G 3 G 9 G 14 G 9 S 13 10 G 14 S 3 9 G 8 S 3 5 S 6 4 S 10 3 S 11 13 G 8 G 4 S 2 11 G 2 G 9 S 15 1 G 9 S 7 8 S 4 3 G 3 G 1 S 8 4 G 13 S 1 2 G 3";
        String[] tokens = inputString.split(" ");
        int capacity = Integer.parseInt(tokens[1]);
        Solution solution = new Solution(capacity);
        int i = 2;
        int len = tokens.length;
        while (i < len) {
            if (tokens[i].equals("G")) {
                int arg = Integer.parseInt(tokens[i + 1]);
                System.out.print("solution.get(" + arg + ") -> ");
                System.out.println(solution.get(arg));
                i += 2;
            } else if (tokens[i].equals("S")) {
                int firstArg = Integer.parseInt(tokens[i + 1]);
                int secondArg = Integer.parseInt(tokens[i + 2]);
                System.out.println("solution.set(" + firstArg + "," + secondArg + ")");
                solution.set(firstArg, secondArg);
                i += 3;
            }
        }
    }
}

class Solution {

    Map<Integer, Element> map = new HashMap<>();
    Element start;
    Element end;
    int capacity;

    public Solution(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Element element = removeElementFromMap(key);
            addElementToMap(element);
            return element.value;
        }
        return -1;
    }

    private Element removeElementFromMap(int key) {
        Element element = map.remove(key);
        boolean removed = false;
        if (element == start) {
            removed = true;
            start = start.next;
            if (start != null) {
                start.prev = null;
            }
        }
        if (element == end) {
            removed = true;
            end = end.prev;
            if (end != null) {
                end.next = null;
            }
        }

        if (!removed) {
            Element next = element.next;
            Element prev = element.prev;
            prev.next = next;
            next.prev = prev;
        }
        return element;
    }

    private void addElementToMap(Element element) {
        if (end == null) {
            start = element;
            end = element;
        } else {
            end.next = element;
            element.prev = end;
            end = end.next;
        }
        map.put(element.key, element);
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            Element element = removeElementFromMap(key);
            element.value = value;
            addElementToMap(element);
            return;
        }
        Element elementToBeInserted = new Element();
        elementToBeInserted.key = key;
        elementToBeInserted.value = value;
        if (map.size() == this.capacity) {
            removeElementFromMap(start.key);
        }
        addElementToMap(elementToBeInserted);
    }


    public void printMap() {
        System.out.println(map);
    }
}

@ToString
class Element {

    int key;
    int value;
    @ToString.Exclude
    Element next;
    @ToString.Exclude
    Element prev;

}
