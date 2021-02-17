package BruteForce.Success;

import java.io.*;
import java.util.*;

public class Tetromino {

    static int[][][] shapeArray = {
        // Square shape
        {{0,0}, {0,1}, {1,0}, {1,1}},
        // Bar shape (Horizontally)
        {{0,0}, {0,1}, {0,2}, {0,3}},
        {{0,0}, {1,0}, {2,0}, {3,0}},
        // L-shape 
        {{0,0}, {1,0}, {2,0}, {2,1}},
        {{0,0}, {0,1}, {0,2}, {-1,2}},
        {{0,0}, {1,0}, {2,0}, {2,-1}},
        {{0,0},{0,-1},{0,-2},{-1,-2}},
        {{0,0},{-1,0},{-2,0},{-2,1}},
        {{0,0},{0,1},{0,2},{1,2}},
        {{0,0},{-1,0},{-2,0},{-2,-1}},
        {{0,0},{0,-1},{0,-2},{1,-2}},
        // Z-shape
        {{0,0},{1,0},{1,1},{2,1}},
        {{0,0},{0,1},{-1,1},{-1,2}},
        {{0,0},{1,0},{1,-1},{2,-1}},
        {{0,0},{0,-1},{-1,-1},{-1,-2}},
        // T-shape
        {{0,0},{1,-1},{1,0},{1,1}},
        {{0,0},{-1,1},{0,1},{1,1}},
        {{0,0},{-1,-1},{-1,0},{-1,1}},
        {{0,0},{-1,-1},{0,-1},{1,-1}}
    };
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()); 
        int[][] d = new int[n+1][m+1];
        int ans = 0;
        int tmp = 0;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                d[i+1][j+1] = Integer.parseInt(st.nextToken());
            }
        }
        // brute force
        int minR, maxR;
        int minC, maxC;
        // row
        for(int i=1; i<=n; i++) {
            // column
            for(int j=1; j<=m; j++) {
                for(int k=0; k<19; k++) {
                    minR = Math.min(shapeArray[k][0][0], Math.min(shapeArray[k][1][0], Math.min(shapeArray[k][2][0], shapeArray[k][3][0])));
                    maxR = Math.max(shapeArray[k][0][0], Math.max(shapeArray[k][1][0], Math.max(shapeArray[k][2][0], shapeArray[k][3][0])));

                    minC = Math.min(shapeArray[k][0][1], Math.min(shapeArray[k][1][1], Math.min(shapeArray[k][2][1], shapeArray[k][3][1])));
                    maxC = Math.max(shapeArray[k][0][1], Math.max(shapeArray[k][1][1], Math.max(shapeArray[k][2][1], shapeArray[k][3][1])));

                    if(i + minR >= 0 && i + maxR <= n && j + minC >= 0 && j + maxC <= m) {
                        tmp = d[i+shapeArray[k][0][0]][j+shapeArray[k][0][1]] + d[i+shapeArray[k][1][0]][j+shapeArray[k][1][1]] + d[i+shapeArray[k][2][0]][j+shapeArray[k][2][1]] + d[i+shapeArray[k][3][0]][j+shapeArray[k][3][1]];

                        if(ans < tmp) ans = tmp;
                    }
                }
            }
        }
        System.out.println(ans);

    }
}
            
