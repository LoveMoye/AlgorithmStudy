package DP.Success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IntTriangle {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        String[] values;
        int[][] d = new int[k+1][k+1];
        d[1][1] = Integer.parseInt(br.readLine());
        for(int i=2; i<k+1; i++) {
            values = br.readLine().split(" ");
            for(int j=1;j<i+1;j++) {
                d[i][j] = Math.max(d[i-1][j-1], d[i-1][j]) + Integer.parseInt(values[j-1]);
            }
        }
        int max = 0;
        for(int i=1;i<k+1;i++) {
            if(max < d[k][i]) {
                max = d[k][i];
            }
        }
        System.out.println(max);
    }
}
