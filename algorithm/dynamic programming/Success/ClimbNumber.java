package DP.Success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClimbNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int mod = 10007;
        int[][] d = new int[n+1][10];
        for(int i=0; i<10; i++) {
            d[1][i] = 1;
        }
        for(int i=2; i<n+1; i++) {
            for(int j=0; j<10; j++) {
                for(int k=0; k<=j; k++) {
                    d[i][j] += (d[i-1][k] % mod);
                }
                d[i][j] %= mod;
            }
        }
        int ans = 0;
        for(int i=0; i<10; i++) {
            ans += d[n][i];            
        }
        System.out.println(ans%mod);
    }
}
