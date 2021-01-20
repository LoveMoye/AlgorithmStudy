import java.io.*;

public class pipe {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        boolean first = true; // 처음으로 stack에서 pop한지에 대한 여부;
        int ans = 0, left = 0, right = 0;

        for(char ch : str.toCharArray()) {
            if(ch == '(') {
                left++;
                if(!first) {
                    first = true;
                }
            } else if(ch == ')') {
                left--;
                if(first) {
                    first = false;
                    ans += left;
                } else {
                   right++;
                }
            }
            if(left == 0) {
                ans += right;
                right = 0;
            }
            
        }
        System.out.println(ans);
    }
}
