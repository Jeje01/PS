// Binary Search

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static int bin(int[] cards, int a){
        int start=0;
        int end=cards.length-1;
        if(a>cards[end] || a<cards[start])
            return 0;
        while(start<=end){
            int mid = (start+end)/2;
            if(a>cards[mid]){
                start=mid+1;
            }else if(a<cards[mid]){
                end=mid-1;
            }else{
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] cards = new int[n];
        int i;
        for(i=0; i<n; i++)
            cards[i] = sc.nextInt();
        int m = sc.nextInt();
        int[] check = new int[m];
        for(i=0; i<m; i++) {
            check[i] = sc.nextInt();
        }
        Arrays.sort(cards);
        for(i=0; i<m; i++) {
            check[i] = bin(cards, check[i]);
        }
        for(i=0; i<m; i++)
            System.out.print(check[i]+" ");
    }
}

