package DP.Success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_9465 {
    static BufferedReader br;
    static StringTokenizer st;
    static int[][] d;

    static int[][] valuePrepare(int k) throws IOException {
        int l = 1;
        int[][] value;
        value = new int[3][k+1];
        for(int i=1; i<3;i++) {
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                value[i][l++] = Integer.parseInt(st.nextToken());
            }
            l = 1;
        }
        
        return value;
    }

    static void bottomUp(int k, int[][] value) {
        d = new int[k+1][3];
        d[1][0] = 0;
        d[1][1] = value[1][1];
        d[1][2] = value[2][1];

        for(int i=2; i<k+1; i++) {
            d[i][0] = Math.max(d[i-1][0], Math.max(d[i-1][1], d[i-1][2]));
            d[i][1] = Math.max(d[i-1][0], d[i-1][2]) + value[1][i];
            d[i][2] = Math.max(d[i-1][0], d[i-1][1]) + value[2][i];
        }
}

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k;
        int[][] value;
        while(n-- > 0) {
            k = Integer.parseInt(br.readLine());
            value = valuePrepare(k);
            bottomUp(k, value);
            System.out.println(Math.max(d[k][0], Math.max(d[k][1], d[k][2])));
        }
    }
}
