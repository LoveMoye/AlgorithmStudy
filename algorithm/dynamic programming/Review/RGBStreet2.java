package DP.Review;

import java.io.*;

public class RGBStreet2 {

    static int[][] d;
    static int[][] value;

    static int toInt(String s) {
        return Integer.parseInt(s);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int fi = k;
        d = new int[k+1][3];
        value = new int[k+1][3];
        String[] valueStr;

        for(int i=1; i<k+1; i++) {
            valueStr = br.readLine().split(" ");
            for(int j=0; j<3; j++) {
                value[i][j] = toInt(valueStr[j]);
            }
        }
        int min = (int) Math.pow(2,31) - 1;
        for(int firstColor=0; firstColor<3; firstColor++) {
            d = new int[k+1][3];
            for(int j=0; j<3; j++) {
                d[1][j] = value[1][j];
            }
            // dynamic programming
            for(int i=2; i < k+1; i++) {
                // current color
                for(int j=0;j<3; j++) {
                    if(i == 2) {
                        if(j != firstColor && (d[i][j] > d[i-1][firstColor] + value[i][j] || d[i][j] == 0)) {
                            d[i][j] = d[i-1][firstColor] + value[i][j];
                        }
                    } else {
                        // previous color
                        for(int l=0; l<3; l++) {
                            if(i == k) {
                                if(j!=firstColor && l!=j && d[i-1][l] != 0 && (d[i][j] > d[i-1][l] + value[i][j] || d[i][j] == 0)) {
                                    d[i][j] = d[i-1][l] + value[i][j];
                                }
                            } else {
                                if(l!=j && d[i-1][l] != 0 && (d[i][j] > d[i-1][l] + value[i][j] || d[i][j] == 0)){
                                    d[i][j] = d[i-1][l] + value[i][j];
                                }
                            }
                        }
                    }
                }
            }
            for(int j=0; j<3;j++) {
                if(min > d[fi][j] && d[fi][j] != 0) {
                    min = d[fi][j];
                }
            }

        }
        System.out.println(min);
    }
}
