/**
 * 조합
 * 조합 계산
 * 14476kb
 * 120ms
 */
 
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int i;
        BigInteger p = new BigInteger("1");
        for(i=n; i>=n-m+1; i--) {
            p=p.multiply(BigInteger.valueOf(i));
        }
        for(i=1; i<=m; i++) {
            p=p.divide(BigInteger.valueOf(i));
        }
        System.out.println(p);      
       
    }

}
