package com.leet.daysofcode.may.week1;


public class NumberComplement {

    public static void main(String[] args) {
        NumberComplement numberComplement = new NumberComplement();
        System.out.println(numberComplement.findComplement(10));
    }

    public int findComplement(int num) {
        if(num==0){
            return 1;
        }
        int powOf2 = 1;
        int ans = 0;
        while (num > 0) {
            ans += (powOf2 * (num % 2 == 0 ? 1 : 0));
            powOf2 *= 2;
            num = num / 2;
        }
        return ans;
    }

}
