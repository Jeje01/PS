import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int i, j, sum;
        int[] arr = new int[n];
        int[] answer = new int[m];
        for(i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        for(i=0; i<m; i++){
            sum=0;
            int a = sc.nextInt();
            int b = sc.nextInt();
            for(j=a-1; j<b; j++){
                sum+=arr[j];
            }
            answer[i]=sum;
        }
        for(i=0; i<m; i++)
            System.out.println(answer[i]);
    }
}
