// Flatten

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=10;
        for(int t=1; t<=10; t++) {
            int dumps = sc.nextInt();
            int[] arr = new int[100];
            for(int i=0; i<100; i++) {
                arr[i] = sc.nextInt();
            }
            for(int i=0; i<dumps; i++) {
                Arrays.sort(arr);
                arr[0]++; 
                arr[arr.length-1]--;
            }
            Arrays.sort(arr);
             
            System.out.printf("#%d %d\n", t, arr[arr.length-1]-arr[0]);
        }
 
    }
}
