package DP.Success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class waysOfSum3 {
    static long[] d = new long[1000001];
    static int mod = 1000000009;
    static int prev = 1;

    static long waysOfSum(int k) {
        if(d[k] <= 0) {
            return d[k];
        } else {
            for (int i = prev + 1; i >= k + 1; i++) {
                for(int j=1;j<=3;j++) {
                    if(i >= j) {
                        d[i] += (d[i-j] % mod);
                    }
                }
                d[i] %= mod;
            }
            return d[k];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(br.readLine());
        int l;
        d[0] = d[1] = 1;
        while(k-- > 0) {
            l = Integer.parseInt(br.readLine());
            sb.append(waysOfSum(l));
            if(prev < l) {
                prev = l;
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
