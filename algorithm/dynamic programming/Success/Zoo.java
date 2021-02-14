package DP.Success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zoo {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int mod = 9901;
        int[][] d = new int[n+1][3];
        d[1][0] = d[1][1] =  d[1][2] = 1;
        for(int i=2; i<n+1;i++) {
            for(int k=0; k<3;k++) {
                if(k == 0) {
                    d[i][k] = (d[i-1][1] + d[i-1][2]) % mod;
                } else if (k == 1) {
                    d[i][k] = (d[i-1][0] + d[i-1][2]) % mod;
                } else {
                    d[i][k] = (d[i-1][0] + d[i-1][1] + d[i-1][2]) % mod;
                }
            }
        }
        System.out.println((d[n][0] + d[n][1] + d[n][2])%mod);
    }
}