package BruteForce.Success;

import java.io.*;

public class CandyGame {

    static String[][] d;
    static int N;

    static void swap(int i, int j, int dir) {
        if(dir == 0) { // row direction
            String k = d[i][j];
            d[i][j] = d[i][j+1];
            d[i][j+1] = k;
        } else if(dir == 1) { // col direction
            String k = d[i][j];
            d[i][j] = d[i+1][j];
            d[i+1][j] = k;
        }
    }

    static int count() {
        int cnt = 1, max = 0;
        String prev;
        for(int i=0; i<N; i++) {
            prev = d[i][0];
            for(int j=1; j<N; j++) {
                if(d[i][j].equals(prev)) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                
                if(max < cnt) max = cnt;
                prev = d[i][j];
            }
            cnt = 1;
        }
        
        for(int i=0; i<N; i++) {
            prev = d[0][i];
            for(int j=1; j<N; j++) {
                if(d[j][i].equals(prev)) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                
                if(max < cnt) max = cnt;
                prev = d[j][i];
            }
            cnt = 1;
        }
        return max;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String str;
        d = new String[N][N];
        for(int i=0; i<N; i++) {
            str = br.readLine();
            for(int j=0; j<N; j++) {
                d[i][j] = str.substring(j, j+1);
            }
        }
        int max = 0, k;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(j < N-1) {
                    swap(i, j, 0);
                    k = count();
                    if(k > max) max = k;
                    swap(i, j, 0);
                }
                if(i < N-1) {
                    swap(i, j, 1);
                    k = count();
                    if(k > max) max = k;
                    swap(i, j, 1);
                }
            }
        }
        System.out.println(max);
    }    
}

