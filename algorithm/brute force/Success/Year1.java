package BruteForce.Success;

import java.io.*;
import java.util.StringTokenizer;

public class Year1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for(int i=0;;i++) {
            if(i%15 == (E-1) && i%28 == (S-1) && i%19 == (M-1)) {
                System.out.println(i+1);
                break;
            }
        }
    }
}
