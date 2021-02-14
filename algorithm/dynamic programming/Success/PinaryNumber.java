package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PinaryNumber {
    static long[][] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        d = new long[k+1][2];
        d[1][1] = 1; // Initial Value;
        for(int i = 2; i < k+1; i++) {
            for(int j = 0; j < 2; j++) {
                if(j == 0) {
                    d[i][j] = d[i-1][0] + d[i-1][1];
                } else {
                    d[i][j] = d[i-1][0];
                }
            }
        }
        long ans = 0;
        for(int i = 0; i < 2; i++) {
            ans += d[k][i];
        }
        System.out.println(ans);

    }
}
