import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int prime[] = new int[1000000];
    public static int n = 0;
    public static boolean check[] = new boolean[1000001];
    public static void prime() {
        for(int i = 2; i < 1000001; i++) {
            if(check[i] == false) {
                prime[n++] = i;
                for(int j = i*2; j<1000001; j+=i) {
                    check[j] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int k;
        prime();
        while(true) {
            k = Integer.parseInt(br.readLine());
            if(k == 0) break;

            for(int i = 0; prime[i] < k; i++) {
                if(check[k-prime[i]] == false) {
                    sb.append(k);
                    sb.append(" = ");
                    sb.append(prime[i]);
                    sb.append(" + ");
                    sb.append(k - prime[i]);
                    sb.append('\n');
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}