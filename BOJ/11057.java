import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] dec = new long[10];
        int i, j;
        long sum=0;
        for(i=0; i<dec.length; i++){
            dec[i]=1;
        }
        for(i=1; i<n+1; i++){
            sum=0;
            for(j=0; j<dec.length; j++){
                sum = (sum+dec[j])%10007;
                if(j>0) dec[j] = (dec[j] + dec[j-1])%10007;
            }
        }
        System.out.println(sum%10007);
    }
}
