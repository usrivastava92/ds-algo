package com.ib.greedy;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MeetingRooms {

    public static void main(String[] args) {
        int[][][] meetings = {{{0, 30}, {5, 10}, {15, 20}}, {{1, 18}, {18, 23}, {15, 29}, {4, 15}, {2, 11}, {5, 13}}, {{7, 10}, {4, 19}, {19, 26}, {14, 16}, {13, 18}, {16, 21}}, {{0, 14}, {6, 25}, {12, 19}, {13, 19}, {5, 9}}};
        int[] outputs = {2, 4, 3, 4};
        MeetingRooms meetingRooms = new MeetingRooms();
        IntStream.range(0, meetings.length).forEachOrdered(i -> {
            System.out.println("Input : " + Arrays.deepToString(meetings[i]));
            System.out.println("Output : " + meetingRooms.solve(meetings[i]));
            System.out.println("Expected : " + outputs[i]);
        });
    }

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
        System.out.println(Arrays.toString(starts));
        System.out.println(Arrays.toString(ends));
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
