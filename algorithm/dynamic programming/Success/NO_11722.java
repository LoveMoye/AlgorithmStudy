package DP.Success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NO_11722 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arrStr = br.readLine().split(" ");
        int[] arr = new int[n+1];
        int[] d = new int[n+1];
        int max = 0;
        for(int i=1; i<n+1; i++) {
            arr[i] = Integer.parseInt(arrStr[i-1]);
        }
        for(int i=1; i<n+1; i++) {
            d[i] = 1;
            for(int j=i-1; j>0; j--) {
                if(arr[i] < arr[j] && d[i] < d[j] + 1) {
                    d[i] = d[j] + 1;
                }
            }
            if(max < d[i]) {
                max = d[i];
            }
        }
        System.out.println(max);
    }
}
