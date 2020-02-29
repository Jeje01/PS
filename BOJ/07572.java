import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = (sc.nextInt()+56) % 60;
        char c = (char) (65 + n % 12);
        int num = n % 10;
        System.out.print(c);
        System.out.println(num);
    }
}
