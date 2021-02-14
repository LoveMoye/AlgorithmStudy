package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CardGacha2 {
    static int[] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        String[] p = br.readLine().split(" ");
        d = new int[k+1];
        d[0]=0; d[1]=Integer.parseInt(p[0]);
        for(int i = 2; i<=k; i++) {
            d[i] = -1;
        }
        for(int i = 2; i<=k; i++) {
            for(int j = 1; j<=i; j++) {
                if (d[i] == -1 || d[i] > d[i-j] + Integer.parseInt(p[j-1])){
                    d[i] = d[i-j] + Integer.parseInt(p[j-1]);
                }
            }
        }
        System.out.println(d[k]);

    }
}
