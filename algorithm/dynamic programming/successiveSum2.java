package DP.Success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class successiveSum2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        String[] arrStr = br.readLine().split(" ");
        int[] arr = new int[k+1];
        int[] d = new int[k+1];
        int[] d2 = new int[k+1];
        for(int i=1; i<k+1; i++) {
            arr[i] = Integer.parseInt(arrStr[i-1]);
        }
        // the successive sum when ended at ith
        for(int i=1; i<k+1; i++) {
            d[i] = arr[i];
            if(d[i-1] + arr[i] > d[i]) {
                d[i] = d[i-1] + arr[i];
            } 
        }
        // the successive sum when started at ith
        d2[k] = arr[k];
        for(int i=k-1; i>0; i--) {
            d2[i] = arr[i];
            if(d2[i+1] + arr[i] > d2[i] ) {
                d2[i] = d2[i+1] + arr[i];
            }
        }
        int max = d[1];
        for(int i=2; i<k+1; i++) {
            if(max < d[i]) {
                max = d[i];
            }
        }

        for(int i=2; i<k; i++) {
            if(max < d[i-1] + d2[i+1]) {
                max = d[i-1] + d2[i+1];
            }
        }
        
        System.out.println(max);        
    }
}
