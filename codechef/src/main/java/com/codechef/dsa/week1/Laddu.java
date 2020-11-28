package com.codechef.dsa.week1;

import com.codechef.utility.Reader;

public class Laddu {

    public static void main(String[] args) throws Exception {
        Reader reader = new Reader();

        int testCase = reader.nextInt();

        while (testCase-- > 0) {
            String[] in = reader.nextLine().trim().split(" ");
            int activities = Integer.parseInt(in[0]);
            String origin = in[1];
            long ladduz = 0;
            for (int i = 0; i < activities; i++) {
                String[] inAct = reader.nextLine().trim().split(" ");
                String activity = inAct[0];
                switch (activity) {
                    case "CONTEST_WON": {
                        int rank = Integer.parseInt(inAct[1]);
                        ladduz += 300;
                        if (rank < 20) {
                            ladduz += (20 - rank);
                        }
                        break;
                    }
                    case "TOP_CONTRIBUTOR": {
                        ladduz += 300;
                        break;
                    }
                    case "BUG_FOUND": {
                        int severity = Integer.parseInt(inAct[1]);
                        ladduz += severity;
                        break;
                    }
                    case "CONTEST_HOSTED": {
                        ladduz += 50;
                        break;
                    }
                }
            }
            long ans = 0;
            if (origin.equals("INDIAN")) {
                ans = ladduz / 200;
            } else {
                ans = ladduz / 400;
            }
            System.out.println(ans);
        }

        reader.close();
    }


}
