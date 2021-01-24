package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WaysOfSum2 {
    static int d[][] = new int[100001][4];
    static int mod = 1000000009;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for(int i = 1; i<=3; i++) {
            d[0][i] = 1;
            if(i==1) d[1][i]=1; 
            if(i==2) d[2][i]=1;
            if(i==3) d[3][i]=1;
        }
        int k;
        long ans=0;
        while(n-- > 0) {
            k = Integer.parseInt(br.readLine());
            for(int j = 1; j <= 3; j++) {
                ans += waysOfSum(k, j);
            }   
            ans %= mod;
            sb.append(ans);
            sb.append('\n');
            ans = 0;
        }
        System.out.println(sb);
    }

    public static long waysOfSum(int k, int j) {
        if(k <= 2) {
            return d[k][j];
        } else {
            if(d[k][j] > 0) {
                return d[k][j];
            }
            long tmp = 0;
            for(int i = 1; i <= 3; i++) {
                if(i != j) {
                    tmp += waysOfSum(k-j, i)%mod;
                }
            }
            d[k][j] = (int) (tmp % mod);
            
            return d[k][j];
        }
    }
}
