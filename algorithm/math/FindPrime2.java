import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindPrime2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] arr = br.readLine().split(" ");
        int min = Integer.parseInt(arr[0]);
        int max = Integer.parseInt(arr[1]);
        boolean[] check = new boolean[max+1];
        check[1] = true;
        for(int i = 2; i < max+1; i++) {
            if(check[i] == false) {
                if(min <= i) {
                    sb.append(i);
                    sb.append('\n');
                }
                for(int j = i*2; j < max+1; j+=i) {
                    check[j]=true;
                }
            }
        }
        System.out.println(sb);
    }
}
