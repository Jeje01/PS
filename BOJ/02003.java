import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m, n, i, j, cnt=0, sum;
        m = sc.nextInt();
        n = sc.nextInt();
        int[] arr = new int[m];
        for(i=0; i<arr.length; i++)
            arr[i] = sc.nextInt();
        for(i=0; i<arr.length; i++){
            sum=0;
            for(j=i; j<m; j++){
                sum+=arr[j];
                if(sum==n){
                    cnt++;
                    break;
                }
                else if(sum>n){
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
