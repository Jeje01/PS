import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int i, sum=0;
        for(i=0; i<n; i++)
            sum += sc.nextInt();
        System.out.println(sum-n+1);
    }
}
