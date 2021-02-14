package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WaysOfSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int k;
        memo[0]=1; memo[1]=1;memo[2]=2;
        while(n-- > 0) {
            k = Integer.parseInt(br.readLine());
            sb.append(waysOfSum(k));
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static int[] memo = new int[11];
    static int waysOfSum(int k) {
        if(memo[k] > 0) {
            return memo[k];
        } else {
            if(k == 1) {
                memo[k] = waysOfSum(k-1);
            } else if(k == 2) {
                memo[k] = waysOfSum(k-1)+waysOfSum(k-2);
            } else if(k >= 3) {
                memo[k] = waysOfSum(k-1)+waysOfSum(k-2)+waysOfSum(k-3);
            }
            return memo[k];
        }
    }
}
