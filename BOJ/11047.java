// Greedy

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int i, cnt=0;
        int[] arr = new int[n];
        for(i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        for(i=n-1; i>=0; i--){
            if(arr[i] <= k){
                cnt += k/arr[i];
                k %= arr[i];
            }
        }
        System.out.println(cnt);
    }
}

