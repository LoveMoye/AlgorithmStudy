import java.io.*; 
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String arr[] = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        Stack<Integer> s = new Stack<Integer>();
        int ans[] = new int[n];
        ans[n-1] = -1;
        int l, k, m = 0;

        for(int i = n-2; i >= 0; i--) {
             l = Integer.parseInt(arr[i]);
             k = Integer.parseInt(arr[i+1]);
             if(l < k) {
                 ans[i] = k;
                 s.push(k);
             } else {
                 if(!(s.empty())) {
                    while(!(s.empty())) {
                        m = s.pop();
                        if(l < m) {
                            ans[i] = m;
                            break;
                         } else {
                            ans[i] = -1;
                         }
                     }
                     s.push(m);
                 } else {
                     ans[i] = -1;
                 }
             }
        }
        for(int i = 0; i < n; i++) {
            sb.append(ans[i]);
            sb.append(" ");
        }
        System.out.println(sb);
    }
}
