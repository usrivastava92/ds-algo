package com.ib.stackqueue;

import java.util.Stack;

public class SimplifyDirectoryPath {


    public static void main(String... args) {
        SimplifyDirectoryPath simplifyDirectoryPath = new SimplifyDirectoryPath();
        String input = "/../";
        System.out.println(simplifyDirectoryPath.simplifyPath(input));
    }

    public String simplifyPath(String A) {
        String[] tokens = A.split("/");
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("..") ) {
                if(!stack.isEmpty()){
                    stack.pop();
                }
            } else if (!token.equals(".") && !token.equals("")) {
                stack.push(token);
            }
        }
        return "/" + String.join("/", stack);
    }

}
