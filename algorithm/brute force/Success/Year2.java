package BruteForce.Success;

import java.io.*;
import java.util.*;

public class Year2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(M < N) {
                for(int i=x; ;i+=M) {
                    if((i-1)%N == (y-1)) {
                        sb.append(i);
                        sb.append('\n');
                        break;
                    }

                    if(i >= M*N) {
                        sb.append(-1);
                        sb.append('\n');
                        break;
                    }
                }
            } else {
                for(int i=y; ; i+=N) {
                    if((i-1)%M == (x-1)) {
                        sb.append(i);
                        sb.append('\n');
                        break;
                    }
                    
                    if(i >= M*N) {
                        sb.append(-1);
                        sb.append('\n');
                        break;
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
