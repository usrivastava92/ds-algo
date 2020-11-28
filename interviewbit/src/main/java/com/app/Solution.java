package com.app;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String... args) {

        int[] ar = new int[]{1, 2, 3, -5, -6, 7, 8, -9};

        for (int i = 0, len = ar.length; i < len; i++) {
            if (ar[i] < 0) {
                moveToStart(ar, i);
            }
        }

        System.out.println(Arrays.toString(ar));

    }

    static void moveToStart(int[] arr, int index) {
        while (index > 0) {
            int temp = arr[index];
            arr[index] = arr[index - 1];
            arr[index - 1] = temp;
            index--;
        }
    }

    static int equalizeArray(int[] arr) {
        List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Set<Integer> set = new HashSet<>(arrList);
        int maxFreq = -1;
        Integer element = null;
        for (Integer in : set) {
            int freq = Collections.frequency(arrList, in);
            if (freq > maxFreq) {
                maxFreq = freq;
                element = in;
            }
        }
        return arr.length - maxFreq;
    }

    public int power(String A) {
        String check = "2";
        while (compareNos(check, A) < 0) {
            check = multiplyBy2(check);
        }
        if (check.equals(A)) {
            return 1;
        }
        return 0;
    }

    public String multiplyBy2(String input) {
        int len = input.length();
        int carry = 0;
        String ans = "";
        for (int i = len; i > 0; i--) {
            int prod = (Integer.parseInt(input.substring(i - 1, i)) * 2) + carry;
            String p = String.valueOf(prod);
            if (p.length() > 1) {
                carry = Integer.parseInt(p.substring(0, p.length() - 1));
                ans = p.substring(p.length() - 1) + ans;
            } else {
                carry = 0;
                ans = p + ans;
            }
        }
        if (carry != 0) {
            ans = carry + ans;
        }
        return ans;
    }

    public ArrayList<String> fullJustify(List<String> A, int B) {
        String justString = "";
        ArrayList<String> returnList = new ArrayList<>();
        String temp = "";
        String justified = "";
        for (String word : A) {
            temp = "".equals(justString) ? "" : " ";
            temp += word;
            if ((temp.length() + justString.length()) > B) {
                justified = makeStringJustified(justString, B);
                if (!"".equals(justified)) {
                    returnList.add(justified);
                    justString = temp.trim();
                }
            } else {
                justString += temp;
            }
        }
        justified = leftJustify(justString, B);
        if (!"".equals(justified)) {
            returnList.add(justified);
        }
        return returnList;
    }

    private String leftJustify(String input, int B) {
        input = input.trim();
        if (input.length() == 0) {
            return "";
        }
        while (input.length() < B) {
            input += " ";
        }
        return input;
    }

    private String makeStringJustified(String input, int B) {
        input = input.trim();
        if (input.length() == 0) {
            return "";
        }
        int len = input.length();
        int diff = B - len;
        int countSpaces = input.split(" ").length - 1;
        int spaceRequired = countSpaces + diff;
        if (countSpaces == 0) {
            while (input.length() != B) {
                input += " ";
            }
            return input;
        }
        int allSpace = spaceRequired / countSpaces;
        int firstSpace = spaceRequired % countSpaces;
        String allSpaceString = "";
        for (int i = 0; i < allSpace; i++) {
            allSpaceString += " ";
        }
        input = input.replaceAll(" ", allSpaceString);
        while (firstSpace > 0) {
            input = input.replaceFirst(allSpaceString, "~");
            firstSpace--;
        }
        input = input.replaceAll("[~]", allSpaceString + " ");
        return input;
    }


    public int atoi(final String A) {
        String[] numTokens = A.replaceAll("[^0-9-+]", " ").replaceAll("[ ]+", " ").split(" ");
        try {
            return Integer.parseInt(numTokens[0].trim());
        } catch (Exception e) {
            String num = numTokens[0].trim();
            if (num.matches("[-]{0,1}[+]{0,1}[0-9]+")) {
                if (compareNos(num, "2147483648") > 0) {
                    return Integer.MAX_VALUE;
                } else if (compareNos(num, "-2147483648") < 0) {
                    return Integer.MIN_VALUE;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        }
    }

    private int compareNos(String a, String b) {

        if (a.charAt(0) == '+') {
            a = a.substring(1);
        }

        if (b.charAt(0) == '+') {
            b = b.substring(1);
        }
        int multiplier = 1;
        if (a.charAt(0) == '-' && b.charAt(0) != '-') {
            return -1;
        } else if (a.charAt(0) != '-' && b.charAt(0) == '-') {
            return 1;
        } else if (a.charAt(0) == '-' && b.charAt(0) == '-') {
            a = a.substring(1);
            b = b.substring(1);
            multiplier = -1;
        }

        while (a.charAt(0) == '0' && a.length() > 1) {
            a = a.substring(1);
        }

        while (b.charAt(0) == '0' && b.length() > 1) {
            b = b.substring(1);
        }

        int aLen = a.length();
        int bLen = b.length();

        if (aLen > bLen) {
            return multiplier * 1;
        } else if (bLen > aLen) {
            return multiplier * -1;
        } else {
            for (int i = 0; i < aLen; i++) {
                int aVal = Integer.parseInt(a.substring(i, i + 1));
                int bVal = Integer.parseInt(b.substring(i, i + 1));
                if (aVal > bVal) {
                    return multiplier * 1;
                } else if (bVal > aVal) {
                    return multiplier * -1;
                }
            }
            return multiplier * 0;
        }
    }


    public boolean isValidIpAdd(String ipAdd) {
        String[] tokens = ipAdd.split("[.]");
        if (tokens.length > 4 || tokens.length < 4) {
            return false;
        } else {
            for (String token : tokens) {
                if (token.length() > 1 && token.startsWith("0")) {
                    return false;
                } else {
                    try {
                        int val = Integer.valueOf(token);
                        if (!(0 <= val && val <= 255)) {
                            return false;
                        }
                    } catch (Exception e) {
                        return false;
                    }
                }
            }
            return true;
        }
    }


    public ArrayList<String> restoreIpAddresses(String A) {
        ArrayList<String> result = new ArrayList<>();
        int size = A.length();
        if (size > 12 || size < 4) {
            return result;
        }
        for (int i = 1; i <= size && i < 4; i++) {
            String a = A.substring(0, i);
            for (int j = i + 1; j <= size && j - i < 4; j++) {
                String b = A.substring(i, j);
                for (int k = j + 1; k <= size && k - j < 4; k++) {
                    String ipAdd = a + "." + b + "." + A.substring(j, k) + "." + A.substring(k);
                    if (isValidIpAdd(ipAdd)) {
                        System.out.println(ipAdd);
                        result.add(ipAdd);
                    }
                }
            }
        }
        return result;
    }


    public int isNumber(final String a) {
        String A = a.trim();
        if (A.endsWith(".") || A.length() == 0) {
            return 0;
        }
        String[] tokens = A.split("e");
        String validBaseRegex = "[-]*[0-9]+[.]*[0-9]*$";
        String validExponentRegex = "[-]*[0-9]+$";
        if (tokens.length > 2) {
            return 0;
        } else if (tokens.length == 2) {
            String exponent = tokens[1];
            String base = tokens[0];
            if (base.endsWith(".") || base.length() == 0) {
                return 0;
            }
            if (exponent.matches(validExponentRegex) && base.matches(validBaseRegex)) {
                return 1;
            } else {
                return 0;
            }
        } else {
            String base = tokens[0];
            if (base.endsWith(".") || base.length() == 0) {
                return 0;
            }
            if (base.matches(validBaseRegex)) {
                return 1;
            } else {
                return 0;
            }
        }
    }


    public int compareVersion(String A, String B) {

        while (A.charAt(0) == '0' && A.length() > 1) {
            A = A.substring(1);
        }

        while ((A.charAt(A.length() - 1) == '0' || A.charAt(A.length() - 1) == '.') && A.length() > 1) {
            A = A.substring(0, A.length() - 1);
        }

        while (B.charAt(0) == '0' && B.length() > 1) {
            B = B.substring(1);
        }

        while ((B.charAt(B.length() - 1) == '0' || B.charAt(B.length() - 1) == '.') && B.length() > 1) {
            B = B.substring(0, B.length() - 1);
        }

        System.out.println(A);
        System.out.println(B);

        String[] aSplit = A.split("[.]");
        String[] bSplit = B.split("[.]");
        int aLen = aSplit.length;
        int bLen = bSplit.length;
        int minLen = aLen < bLen ? aLen : bLen;
        for (int i = 0; i < minLen; i++) {
            String aToken = aSplit[i];
            String bToken = bSplit[i];
            if (compareNos(aToken, bToken) == 1) {
                return 1;
            } else if (compareNos(aToken, bToken) == -1) {
                return -1;
            }
        }
        if (aLen > bLen) {
            return 1;
        } else if (bLen > aLen) {
            return -1;
        }
        return 0;
    }


}
