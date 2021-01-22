package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakeOne {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        memo = new int[k+1];
        // System.out.println(makeOne(k));
        System.out.println(makeOne2(k));

    }
    public static int memo[];
    public static int makeOne(int n) {
        if(memo[n] > 0 || n <= 1) {
            return memo[n];
        } else {
            int k = makeOne(n-1);
            if(n%2==0) {
                int l = makeOne(n/2);
                if(k > l) {
                    k = l;
                }
            }
            if(n%3==0) {
                int m = makeOne(n/3);
                if(k > m) {
                    k = m;
                }
            }
            memo[n] = k + 1;
            return memo[n];
        }
    }
    public static int makeOne2(int n) {
        if(n <= 1) {
            return memo[n];
        } else {
            for(int i = 2; i < n+1 ;i++) {
                memo[i] = memo[i-1] + 1;
                if(i%2==0 && memo[i] > memo[i/2] + 1) {
                    memo[i] = memo[i/2] + 1;
                }
               if(i%3==0 && memo[i] > memo[i/3] + 1) {
                    memo[i] = memo[i/3] + 1;
                }
            }
            return memo[n];
        }
    }
}
