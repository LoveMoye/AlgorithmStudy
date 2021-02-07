package DP.Success;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class QuadraticSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int[] d = new int[k+1];
        d[1] = 1;
        for(int i = 2; i<k+1; i++) {
            for(int j = 1; j*j<=i; j++) {
                if(d[i] > d[i-j*j] + 1 || d[i] == 0) {
                    d[i] = d[i-j*j] + 1;
                }
            }
        }
        System.out.println(d[k]);
    }
}
