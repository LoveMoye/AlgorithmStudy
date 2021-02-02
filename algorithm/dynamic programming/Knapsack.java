package DP.Success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Knapsack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] weightAndLen = br.readLine().split(" ");
        String[] valueStr = br.readLine().split(" ");
        String[] weightStr = br.readLine().split(" ");
        int limitWeight = Integer.parseInt(weightAndLen[0]);
        int len = Integer.parseInt(weightAndLen[1]);
        int[] weights = new int[len+1];
        int[] values = new int[len+1];
        int[][] d = new int[limitWeight+1][len+1];

        for(int i=0; i<len;i++) {
            weights[i+1] = Integer.parseInt(weightStr[i]);
            values[i+1] = Integer.parseInt(valueStr[i]);
        }     
        for(int i=1; i<limitWeight+1; i++) {
            if(i >= weights[1]) {
                d[i][1] = values[1];
            } 
            for(int j=2; j<len+1; j++) {
                if(i < weights[j]) {
                    d[i][j] = d[i][j-1];
                } else {
                    d[i][j] = Math.max(d[i][j-1], d[i-weights[j]][j-1]+values[j]);
                }
            }
        }
        
        System.out.println(d[limitWeight][len]);
        
    }
}