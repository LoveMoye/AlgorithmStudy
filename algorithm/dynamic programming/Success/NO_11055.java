package DP.Success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NO_11055 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arrStr = br.readLine().split(" ");
        int[] arr = new int[n+1];
        int[] d = new int[n+1];
        int tmp = 0, max = 0;
        
        for(int i=1; i<n+1; i++) {
            arr[i] = Integer.parseInt(arrStr[i-1]);
        }

        for(int i=1; i<n+1; i++) {
            tmp = arr[i];
            for(int j=i-1; j>0; j--) {
                if(arr[i] > arr[j] && tmp < arr[i] + d[j]) {
                    tmp = arr[i] + d[j];
                }
            }
            d[i] = tmp;
            if(max < d[i]) {
                max = d[i];
            }
        }
        System.out.println(max);        
    }
}
