package com.ib.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class HotelBookingsPossible {

    public static void main(String... args) {
        Integer[] arrivals = new Integer[]{17, 0, 45, 11, 16, 43, 15, 42, 2, 41, 0, 27, 37, 25, 17, 42, 24, 23, 11, 4, 29, 39, 6, 10, 42, 16, 17, 39, 1};
        Integer[] departures = new Integer[]{25, 24, 52, 51, 26, 46, 25, 45, 9, 51, 49, 48, 51, 66, 65, 57, 69, 43, 50, 9, 32, 55, 10, 58, 62, 46, 19, 87, 12};
        int k = 16;

        HotelBookingsPossible hotelBookingsPossible = new HotelBookingsPossible();
        System.out.println(hotelBookingsPossible.hotel(Arrays.asList(arrivals), Arrays.asList(departures), k));
    }

    public boolean hotel(List<Integer> arrive, List<Integer> depart, int K) {

        int size = arrive.size();
        if (null == arrive || 0 == size) {
            return true;
        }
        arrive.sort(Integer::compareTo);
        depart.sort(Integer::compareTo);
        int maxRoomsNeeded = 0, currentRoomsCount = 0;
        int i = 0, j = 0;
        while (i < size || j < size) {
            int arrival = i < size ? arrive.get(i) : Integer.MAX_VALUE;
            int departure = j < size ? depart.get(j) : Integer.MAX_VALUE;
            if (Math.min(arrival, departure) == departure) {
                j++;
                currentRoomsCount--;
            } else {
                i++;
                currentRoomsCount++;
            }
            maxRoomsNeeded = Math.max(maxRoomsNeeded, currentRoomsCount);
        }
        return maxRoomsNeeded <= K ? true : false;
    }

}
