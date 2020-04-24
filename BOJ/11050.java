import java.util.Scanner;

public class Main{
    public static int fac(int a){
        int i;
        if(a==0||a==1) return 1;
        else
            return a*fac(a-1);
    }

    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int answer=0;
        if(k>n)
            System.out.println(0);
        else
            {
            answer = fac(n)/(fac(k)*fac(n-k));
            System.out.println(answer);
        }
    }
}
