package DP.Success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SuccessiveSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        String[] arrStr = br.readLine().split(" ");
        int[] arrInt = new int[len+1];
        for(int i = 0; i<len;i++) {
            arrInt[i+1] = Integer.parseInt(arrStr[i]);
        }
        long[] sum = new long[len+1];
        long max = (long) -(Math.pow(2, 63));
        for(int i = 1;i<len+1;i++) {
            sum[i] = Math.max(arrInt[i], sum[i-1]+arrInt[i]);
            if(max < sum[i]) {
                max = sum[i];
            }
        }
        System.out.println(max);
    }
}
