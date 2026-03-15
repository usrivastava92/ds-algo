package com.ib.arrays;

import java.util.List;

public class HotelBookingsPossible {

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
    return maxRoomsNeeded <= K;
  }
}
