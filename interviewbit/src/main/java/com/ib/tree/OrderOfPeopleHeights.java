package com.ib.tree;

import java.util.ArrayList;
import java.util.Arrays;

public class OrderOfPeopleHeights {

    public static void main(String[] args) {
        OrderOfPeopleHeights orderOfPeopleHeights = new OrderOfPeopleHeights();
        ArrayList<Integer> heights = new ArrayList<>(Arrays.asList(5, 3, 2, 6, 1, 4));
        ArrayList<Integer> infronts = new ArrayList<>(Arrays.asList(0, 1, 2, 0, 3, 2));
        System.out.println(orderOfPeopleHeights.order(heights, infronts));
    }

    public ArrayList<Integer> order(ArrayList<Integer> heights, ArrayList<Integer> infronts) {
        ArrayList<Integer> result = new ArrayList<>();
        if (heights == null || infronts == null || heights.size() != infronts.size()) {
            return result;
        }
        int n = heights.size();
        Person[] persons = new Person[n];
        for (int i = 0; i < n; i++) {
            persons[i] = new Person(heights.get(i), infronts.get(i));
        }
        Arrays.sort(persons);
        Person[] temp = new Person[n];
        for (Person p : persons) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (count == p.infront) {
                    while (temp[i] != null && i < n - 1) {
                        i++;
                    }
                    temp[i] = p;
                    break;
                }
                if (temp[i] == null) {
                    count++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            result.add(temp[i].height);
        }
        return result;
    }
}

class Person implements Comparable<Person> {
    int height;
    int infront;

    public Person(int height, int infront) {
        this.height = height;
        this.infront = infront;
    }

    @Override
    public int compareTo(Person o) {
        return this.height - o.height;
    }

    @Override
    public String toString() {
        return "Person{" +
                "height=" + height +
                ", infront=" + infront +
                '}';
    }
}