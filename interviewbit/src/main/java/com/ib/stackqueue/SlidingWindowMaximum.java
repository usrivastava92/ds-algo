package com.ib.stackqueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SlidingWindowMaximum {

    public static void main(String... args){

    }

    public ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        if(B >= A.size()){
            result.add(A.stream().max(Integer::compareTo).get());
            return result;
        }
        Deque<Integer> queue = new ArrayDeque<>();
        int currMax = Integer.MIN_VALUE;
        for(int i=0,j = A.size();i<j;i++){
            Integer element = A.get(i);
            if(queue.size()<B){
                if(element>currMax){
                    currMax = element;
                }
                queue.add(element);
            }else{
                result.add(currMax);
                Integer old = queue.removeFirst();
                queue.add(element);
                if(old.equals(currMax)){
                    currMax = queue.stream().max(Integer::compareTo).get();
                }else{
                    if(element>currMax){
                        currMax = element;
                    }
                }

            }
        }
        return result;
    }
}
