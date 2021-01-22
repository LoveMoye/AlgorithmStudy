import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GoldBach2 {
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int k, ans=0;
        prime();
        while(n-- > 0) {
            k = Integer.parseInt(br.readLine());
            for(int i=0;prime[i]<=(k/2);i++) {
                if(check[k-prime[i]] == false) {
                    ans++;
                }
            }
            sb.append(ans);
            sb.append('\n');
            ans = 0;
        }
        System.out.println(sb);
    }
} 
