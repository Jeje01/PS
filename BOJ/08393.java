import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int i, sum=0;
        int n=sc.nextInt();
        for(i=1;i<=n;i++)
            sum+=i;
        System.out.println(sum);
    }
}
