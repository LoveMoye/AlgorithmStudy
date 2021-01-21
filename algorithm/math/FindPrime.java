import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindPrime {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int j, ans=n;
        while(n-- > 0) {
            j = Integer.parseInt(arr[n]);
            if(j == 1) {
                ans--;
            }
            for(int i = 2; i*i<=j; i++) {
                if(j%i==0){
                    ans--; break;
                }
            }
        }
        System.out.println(ans);
    }
}
