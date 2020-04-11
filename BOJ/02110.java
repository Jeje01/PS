// Binary Search - 공유기 설치

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] x = new int[n];
        int i, answer=0, pos, cnt, mid;
        for(i=0; i<n; i++)
            x[i] = sc.nextInt();
        Arrays.sort(x);
        int left = 1, right = x[n-1]-x[0];

        while(left<=right) {
            pos = 0; cnt = 1;
            mid = (right+left)/2;

            for (i = 1; i < n; i++) {
                if (x[i] - x[pos] >= mid) {
                    cnt++;
                    pos = i;
                }
            }
            if(c <= cnt){
                left = mid+1;
                answer = mid;
            }
            else{
                right = mid-1;
            }
        }
        System.out.println(answer);
    }
}
