package BruteForce.Review;

import java.util.*;
import java.io.*;

public class RemoteControl {

    static int[] broken = new int[10];

    static boolean inBroken(int num) {
        int k;
        // if num is equal to zero, we need to check that it is broken.
        do {
            k = num % 10;
            if(broken[k] == 1) {
                return true;
            }
            num /= 10;
        } while(num > 0);
        return false;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        // M is the number of broken numbers.
        if(M != 0) {
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++) {
                broken[Integer.parseInt(st.nextToken())] = 1;
            }
        }

        int ans;
        int cnt = Math.abs(N-100); // Change the channel using only + and -.
        if(cnt == 0) { // N is equal to 100
            System.out.println(cnt);
        } else { // Component number of N is broken.
            ans = cnt;
            for(int i=0; i<=1000000; i++) {
                if(!inBroken(i)) { 
                    cnt = Math.abs(N-i);
                    if(ans > cnt + Integer.toString(i).length()) {
                        ans = cnt + Integer.toString(i).length();
                    }
                } 
            }
            System.out.println(ans);
        }
    }
}
