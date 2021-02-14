package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EasyStairNumber {
    static int[][] d;
    static int mod = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        d = new int[k+1][10];
        for(int i =1 ; i<10;i++) {
            d[1][i] = 1;
        }
        long tmp = 0;
        for(int i=2; i<k+1;i++) {
            for(int j = 0; j<10; j++) {
                if(j-1>=0) tmp += d[i-1][j-1]%mod;
                if(j+1<=9) tmp += d[i-1][j+1]%mod; 
                d[i][j] = (int) (tmp % mod);
                tmp = 0;
            }
        }
        long ans = 0;
        for(int i =0 ; i<10;i++) {
            ans += d[k][i];
        }
        System.out.println(ans%mod);
    }
}
