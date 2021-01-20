import java.io.*;
import java.util.Stack;

public class reverse2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder ans = new StringBuilder();

        Stack<Character> s = new Stack<Character>();
        boolean open = false;
        long beforeTime = System.currentTimeMillis();
        for(char ch : str.toCharArray()) {
            if(ch == '<') {
                while(!(s.empty())) {
                    ans.append(s.pop());
                }
                open = true;
                ans.append(ch);
            } else if (ch == '>') {
                open = false;
                ans.append(ch);
            } else {
                if(!open) {
                    if(ch == ' ') {
                        while(!(s.empty())) {
                            ans.append(s.pop());
                        }
                        ans.append(' ');
                    } else {
                        s.push(ch);
                    }
                } else {
                    ans.append(ch);
                }
            }
        }
        while(!(s.empty())) {
            ans.append(s.pop());
        }
        System.out.println(ans);
        
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
        System.out.println("시간차이(m) : "+secDiffTime);
    }
}