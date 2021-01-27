package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LIS {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int[] d = new int[k];
        int tmp = 1, max = 0;
        for(int i = 0; i < k; i++) {
            d[i] = 1;
            for(int j = i-1; j>=0; j--) {
                if(Integer.parseInt(arr[j]) < Integer.parseInt(arr[i]) && tmp < d[i] + d[j]) {
                    tmp = d[i] + d[j];
                }
            }
            d[i] = tmp;
            tmp = 1;
            if(max < d[i]) {
                max = d[i];
            }
        }
        System.out.println(max);
    }
}