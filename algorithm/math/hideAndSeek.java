import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class hideAndSeek {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr1 = br.readLine().split(" ");
        String[] arr2 = br.readLine().split(" ");
        int N = Integer.parseInt(arr1[0]);
        int S = Integer.parseInt(arr1[1]);
        int[] diff = new int[N];
        for(int i = 0; i<N; i++){
            diff[i] = Math.abs(S-Integer.parseInt(arr2[i]));
        }
        int k = diff[0];
        for(int i = 1; i<N; i++) {
            k = gcd(k, diff[i]);
        }
        System.out.println(k);
    }

    public static int gcd(int n, int m) {
        if(m == 0) {
            return n;
        } else {
            return gcd(m, n%m);
        }
    }
}
