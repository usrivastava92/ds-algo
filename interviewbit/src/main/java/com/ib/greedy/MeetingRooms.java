package com.ib.greedy;

import java.util.Arrays;

public class MeetingRooms {

  public int solve(int[][] A) {
    if (A == null || A.length == 0) {
      return 0;
    }
    int len = A.length;
    int[] starts = new int[A.length];
    int[] ends = new int[A.length];
    for (int i = 0; i < len; i++) {
      starts[i] = A[i][0];
      ends[i] = A[i][1];
    }
    int currMeetingRooms = 1;
    int maxMeetingRooms = 1;
    int startPointer = 1;
    int endPointer = 0;
    Arrays.sort(starts);
    Arrays.sort(ends);
    while (startPointer < len && endPointer < len) {
      if (starts[startPointer] < ends[endPointer]) {
        currMeetingRooms++;
        startPointer++;
      } else if (starts[startPointer] > ends[endPointer]) {
        currMeetingRooms--;
        endPointer++;
      } else {
        startPointer++;
        endPointer++;
      }
      maxMeetingRooms = Math.max(currMeetingRooms, maxMeetingRooms);
    }
    return maxMeetingRooms;
  }
}
