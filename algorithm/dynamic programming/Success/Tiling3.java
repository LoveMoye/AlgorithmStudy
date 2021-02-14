package DP.Success;

import java.io.*;

public class Tiling3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        long[] d = new long[k+1];
        if(k >= 2) {
            d[0] = 1;
            d[2] = 3;
        }
        int j;
        for(int i=3; i<k+1; i++) {
            j=2;
            d[i] = 3*d[i-2];
            while(i-(2*j) >= 0) {
                d[i] += 2*d[i-(2*j)];
                j++;
            }
        }
        System.out.println(d[k]);
    }
}
