package com.ib.bitmanipulation;

import java.io.*;
import java.math.*;
import java.util.*;

public class Test {

  public static void main(String... args) {
    int a = 5;
    System.out.println(Integer.toBinaryString(a));

    System.out.println(Integer.toBinaryString(a << 2));

    System.out.println(Integer.toBinaryString(a >> 1));
  }
}
