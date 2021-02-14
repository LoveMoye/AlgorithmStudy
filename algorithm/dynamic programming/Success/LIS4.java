package DP.Success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class LIS4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int len = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        Stack<Integer> s = new Stack<Integer>();
        int[] arrInt = new int[len+1];
        int[] d = new int[len+1];
        int[] memo = new int[len+1];
        int maxIdx = 0;

        // int로 변경.
        for(int i = 0; i<len; i++) {
            arrInt[i+1] = Integer.parseInt(arr[i]);
        }

        for(int i = 1; i < len+1; i++) {
            d[i] = 1; //
            memo[i] = 0; // 이전 수 index, 0이면 수열의 길이 1
            for(int j=i-1; j>0;j--) {
                if(arrInt[j] < arrInt[i] && d[i] < d[j]+1) {
                    d[i] = d[j] + 1;
                    memo[i] = j;
                }
            }
            if(d[maxIdx] < d[i]) {
                maxIdx = i;
            }
        }

        sb.append(d[maxIdx]);
        sb.append('\n');
        while(maxIdx != 0) {
            s.push(arrInt[maxIdx]);
            maxIdx = memo[maxIdx];
        }
        while(!(s.isEmpty())) {
            sb.append(s.pop());
            sb.append(" ");
        }
        System.out.println(sb);
    }
}
