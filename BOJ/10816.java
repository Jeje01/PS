// Binary Search

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    static int[][] t;

    public static int bin(int pos, int k){
        int start = 0;
        int end = pos;
        int mid;
        if(k<t[start][0] || k>t[end][0])
            return 0;
        while(start<=end){
            mid = (start+end)/2;
            if(k > t[mid][0]){
                start = mid+1;
            }else if(k < t[mid][0]){
                end = mid-1;
            }else{
                return t[mid][1];
            }
        }
        return 0;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] cards = new int[n];
        int i, j, pos=0;
        for(i=0; i<n; i++)
            cards[i] = sc.nextInt();
        int m = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int[] check = new int[m];
        for(i=0; i<m; i++)
            check[i] = sc.nextInt();
        Arrays.sort(cards);
        t = new int[n][2];
        t[0][0] = cards[0];
        t[0][1] = 1;
        for(i=1; i<n; i++){
            if(cards[i]==t[pos][0]) {
                t[pos][1]++;
            }else{
                t[++pos][0] = cards[i];
                t[pos][1]=1;
            }
        }
        for(i=0; i<m; i++){
            sb.append(bin(pos, check[i])+" ");
        }
        System.out.println(sb.toString());
    }
}

