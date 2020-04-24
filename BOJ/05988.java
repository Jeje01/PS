import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i;
        String[] s = new String[n];
        for(i=0; i<n; i++) {
            String str = sc.next();
            char ch = str.charAt(str.length()-1);
            if((ch-'0')%2==0)
                s[i]="even";
            else
                s[i]="odd";
        }
        for(i=0; i<n; i++) {
            System.out.println(s[i]);
        }
    }
}
