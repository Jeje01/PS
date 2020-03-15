import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int i, j, sum=0;
        int[] arr = new int[n];
        int[] sums = new int[n];
        int[] answer = new int[m];
        for(i=0; i<n; i++){
            arr[i] = sc.nextInt();
            sum+=arr[i];
            sums[i]=sum;
        }
        for(i=0; i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(a!=1)
                sum = sums[b-1] - sums[a-2];
            else
                sum = sums[b-1];
            answer[i]=sum;
        }
        for(i=0; i<m; i++)
            System.out.println(answer[i]);
    }
}
