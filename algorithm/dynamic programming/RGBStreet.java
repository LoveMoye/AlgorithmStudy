package DP.Success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RGBStreet {

    static int[][] d;

    static int toInt(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int fi = k;
        d = new int[k+1][3];
        int i = 1;
        String[] valueStr = br.readLine().split(" ");
        d[i][0] = toInt(valueStr[0]);
        d[i][1] = toInt(valueStr[1]);
        d[i][2] = toInt(valueStr[2]);
        k--;
        i++;

        while(k-- > 0) {
            valueStr = br.readLine().split(" ");
            for(int j=0;j<3;j++) {
                for(int l=0;l<3;l++) {
                    if(l!=j && (d[i][j] > d[i-1][l] + toInt(valueStr[j]) || d[i][j] == 0)) {
                        d[i][j] = d[i-1][l] + toInt(valueStr[j]); 
                    }
                }
            }
            i++;    
        }
        int min = (int) Math.pow(2,31) - 1;
        for(int j=0; j<3;j++) {
            if(min > d[fi][j]) {
                min = d[fi][j];
            }
        }
        System.out.println(min);
    }
}
