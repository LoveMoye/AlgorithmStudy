package DP;

import java.util.Scanner;

public class Tiling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        arr = new long[k+1];
        arr[0] = arr[1] = 1;
        System.out.println(tiling(k)%10007);
    }

    public static long arr[];
    // 나머지 연산은 분배법칙 성립
    // (a+b) % c = (a%c + b%c) %c
    public static long tiling(int n) {
        if(n <= 1 || arr[n] > 0) {
            return arr[n];
        } else {
            arr[n] = tiling(n-1)%10007 + tiling(n-2)%10007;
            return arr[n];
        }
    }
}
