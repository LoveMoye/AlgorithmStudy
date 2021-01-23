package DP;

import java.util.Scanner;

public class Tiling2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        arr = new int[k+1];
        arr[0] = arr[1] = 1;
        tiling(k);
        System.out.println(arr[k]);
        sc.close();
    }

    public static int arr[];
    public static void tiling(int n) {
        for(int i = 2; i<n+1; i++) {
            arr[i] = (arr[i-1] + arr[i-2] * 2)%10007;
        }
    }
} 
