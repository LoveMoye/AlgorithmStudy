import java.io.*;

public class GCDLCM {
    public static int gcd(int n, int m) {
        if(m == 0) {
            return n;
        } else {
            return gcd(m, n%m);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int f = Integer.parseInt(arr[0]);
        int s = Integer.parseInt(arr[1]);

        int g = gcd(f, s);
        int l = (f*s/g);
        System.out.println(g);
        System.out.println(l);

    }
}
