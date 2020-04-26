import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int x;
        if((a+b)%2==0 && a>=b) {
            x = (a+b)/2;
            System.out.println(x+" "+(a-x));
        }
        else
            System.out.println(-1);
    }
}
