import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int i, sum=0;
        int n = sc.nextInt();
        String[] str= sc.next().split("");
        for(i=0; i<n; i++){
            sum+=Integer.parseInt(str[i]);
        }
        System.out.println(sum);
    }
}
