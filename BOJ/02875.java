// Greedy

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int i;
        for(i=0; i<k; i++){
            int redn = Math.min((n-1)/2, m);
            int redm = Math.min(n/2, m-1);
            if(redn>=redm)
                n--;
            else
                m--;
        }
        System.out.println(Math.min(n/2, m));
    }
}

