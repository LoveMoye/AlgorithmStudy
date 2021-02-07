package DP.Success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NO_2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] d = new int[n+1][2];
        int[] values = new int[n+1];
        for(int i=1; i<n+1; i++) {
            values[i] = Integer.parseInt(br.readLine());
        }
        d[1][1] = values[1];
        for(int i=2; i<n+1; i++) {
            d[i][0] = Math.max(d[i-1][0], d[i-1][1]);
            d[i][1] = Math.max(d[i-2][0] + values[i-1] + values[i], d[i-2][1] + values[i]);
        }
        System.out.println(Math.max(d[n][0], d[n][1]));
    }

}
