/**
 * 가장 긴 증가하는 부분 수열 - S2
 * DP, LIS
 * 13,696 kb
 * 104 ms
 * 
 * 6달 전과 같은 로직으로 풀었음
 * 최댓값 구할 때 Math.max 쓰는 것만 달라짐
 * 입출력 방식 때문에 시간 단축
 */

// 2

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];
        int i, j, max=0;
        dp[1] = 1;
        for(i=1; i<n+1; i++){
            arr[i] = sc.nextInt();
        }
        for(i=2; i<n+1; i++){
            dp[i] = 1;
            for(j=1; j<i; j++){
                if(arr[j] < arr[i] && dp[j] >= dp[i]){
                    dp[i] = dp[j]+1;
                }else if(arr[j] == arr[i]){
                    dp[i] = dp[j];
                }
            }
        }
        for(i=1; i<n+1; i++){
            if(dp[i] > max) max = dp[i];
        }
        System.out.println(max);
    }
} 

// 1

//dp

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];
        int i, j, max=0;
        dp[1] = 1;
        for(i=1; i<n+1; i++){
            arr[i] = sc.nextInt();
        }
        for(i=2; i<n+1; i++){
            dp[i] = 1;
            for(j=1; j<i; j++){
                if(arr[j] < arr[i] && dp[j] >= dp[i]){
                    dp[i] = dp[j]+1;
                }else if(arr[j] == arr[i]){
                    dp[i] = dp[j];
                }
            }
        }
        for(i=1; i<n+1; i++){
            if(dp[i] > max) max = dp[i];
        }
        System.out.println(max);
    }
}
