package BruteForce.Success;

import java.io.*;
import java.util.*;

public class SevenMinion {

    static int[] s = new int[9];
    static int sum = 0;

    static int find() {
        for(int i=0; i<8; i++) {
            for(int j=i+1; j<9; j++) {
                if(sum - s[i] - s[j] == 100) {
                    s[i] = s[j] = 0;
                    return 0;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // Save the value in the array and total sum of the input values.
        for(int i=0; i<9 ; i++) {
            s[i] = Integer.parseInt(br.readLine());
            sum += s[i];
        }
        // Find the target values.
        find();
        
        // Sort array
        Arrays.sort(s,0,9);

        // Print the answer.
        for(int i=0; i<9; i++) {
            if(s[i] != 0) {
                sb.append(s[i] + "\n");
            }
        }
        // System.out.println("Answer");
        System.out.println(sb);
    }
}
