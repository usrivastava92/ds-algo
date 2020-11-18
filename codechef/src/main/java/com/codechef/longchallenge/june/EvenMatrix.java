package com.codechef.longchallenge.june;

import com.codechef.utility.Reader;

public class EvenMatrix {

    public static void main(String[] args) throws Exception {
        Reader reader = new Reader();
        int testcase = reader.nextInt();
        while (testcase-- > 0) {
            int n = reader.nextInt();
            int odd = 1;
            int even = 2;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                boolean rowEven = i % 2 == 0;
                for (int j = 0; j < n; j++) {
                    boolean colEven = j % 2 == 0;
                    if (rowEven) {
                        if(colEven){
                            sb.append(odd+" ");
                            odd += 2;
                        }else{
                            sb.append(even+" ");
                            even += 2;
                        }
                    } else {
                        if(colEven){
                            sb.append(even+" ");
                            even += 2;
                        }else{
                            sb.append(odd+" ");
                            odd += 2;
                        }
                    }
                }
                sb.append("\n");
            }
            System.out.println(sb.toString());
        }
    }

}
