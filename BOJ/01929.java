import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        int i, j;
        arr[1]=1;
        for(i=2; i<n+1; i++){
            if(arr[i]==1)
                continue;
            for(j=i*2; j<n+1; j+=i){
               arr[j]=1;
            }
        }
        for(i=m; i<n+1; i++){
            if(arr[i]==0)
                System.out.println(i);
        }
    }
}
