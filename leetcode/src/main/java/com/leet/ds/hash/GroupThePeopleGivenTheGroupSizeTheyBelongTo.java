package com.leet.ds.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupThePeopleGivenTheGroupSizeTheyBelongTo {

    public static void main(String[] args) {
        int[] groupSizes = {3,3,3,3,3,1,3};
        GroupThePeopleGivenTheGroupSizeTheyBelongTo group = new GroupThePeopleGivenTheGroupSizeTheyBelongTo();
        System.out.println(group.groupThePeople(groupSizes));
    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<List<Integer>>> map = new HashMap<>();

        for (int i = 0, len = groupSizes.length; i < len; i++) {
            int element = groupSizes[i];
            if (map.containsKey(element)) {
                List<List<Integer>> list = map.get(element);
                List<Integer> lastList = list.get(list.size()-1);
                if(lastList.size()<element){
                    lastList.add(i);
                }else {
                    lastList = new ArrayList<>();
                    lastList.add(i);
                    list.add(lastList);
                }
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                List<List<Integer>> val = new ArrayList<>();
                val.add(list);
                map.put(element, val);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for(Map.Entry<Integer,List<List<Integer>>> entry : map.entrySet()){
            result.addAll(entry.getValue());
        }
        return result;
    }


}
