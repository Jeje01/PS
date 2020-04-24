import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int i, j;
        int[] a = new int[3];
        int[] b = new int[3];
        for(i=0; i<3; i++){
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int x = a[1]==a[0] ? a[2] : a[0];
        int y = b[1]==b[0] ? b[2] : b[0];
        System.out.println(x+" "+y);
    }
}
