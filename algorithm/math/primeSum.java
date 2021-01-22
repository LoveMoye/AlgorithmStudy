import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class primeSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] arr;
        long ans = 0;
        int k, n1, n2;
        while(n-- > 0) {
            arr = br.readLine().split(" ");
            k = Integer.parseInt(arr[0]);
            for(int i = 1; i <= k; i++) {
                n1 = Integer.parseInt(arr[i]);
                for(int j = i+1; j <= k; j++) {
                    n2 = Integer.parseInt(arr[j]);
                    ans += gcd(n1, n2);
                }
            }
            sb.append(ans);
            if(n > 0) {
                sb.append('\n');
            } 
            ans = 0;
        }
        System.out.print(sb);
    }

    public static int gcd(int n, int m) {
        if(m == 0) {
            return n;
        } else {
            return gcd(m, n%m);
        }
    }
}
