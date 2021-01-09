package com.leet.daysofcode.year2020.may.week5;


import com.ds.utils.ArrayUtils;

import java.util.*;

public class CourseSchedule {

    public static void main(String[] args) {
        int[] numCourses = {2, 2, 3};
        int[][][] prerequisites = {{{1, 0}}, {{1, 0}, {0, 1}}, {{0, 1}, {0, 2}, {1, 2}}};
        boolean[] outputs = {true, false, true};
        CourseSchedule courseSchedule = new CourseSchedule();
        for (int i = 0; i < numCourses.length; i++) {
            System.out.println("Input : numCourses -> " + numCourses[i] + " prerequisites -> " + ArrayUtils.toString(prerequisites[i]));
            System.out.println("Output : " + courseSchedule.canFinish(numCourses[i], prerequisites[i]));
            System.out.println("Expected : " + outputs[i]);
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int from = prerequisite[0];
            int to = prerequisite[1];
            List<Integer> list = map.getOrDefault(from, new ArrayList<>());
            list.add(to);
            map.put(from, list);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!hasCyclicDependency(map, i, new HashSet<>())) {
                return false;
            }
        }
        return true;
    }

    public boolean hasCyclicDependency(Map<Integer, List<Integer>> adjacencyList, Integer from, Set<Integer> visited) {
        if (visited.contains(from)) {
            return false;
        }
        if (!adjacencyList.containsKey(from)) {
            return true;
        }
        visited.add(from);
        for (Integer i : adjacencyList.get(from)) {
            if (!hasCyclicDependency(adjacencyList, i, visited)) {
                return false;
            }
        }
        visited.remove(from);
        return true;
    }

}
