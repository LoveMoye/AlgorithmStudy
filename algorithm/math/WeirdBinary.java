import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class WeirdBinary {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(br.readLine());
        if(k == 0) {
            System.out.println(0);
        } else {
            transform(k, sb); 
            System.out.println(sb.reverse());
        }
    }

    public static void transform(int k, StringBuilder sb) {
        int r;
        while(k != 0) {
            r = Math.abs(k%-2);
            if(k > 0 || r == 0) {
                k = k/-2;
            } else {
                k = k/-2 + 1;
            }
            sb.append(r);
        }
    }
}
