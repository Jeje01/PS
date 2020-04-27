import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int len = str.length();
        int i, cnt=0;
        for(i=0; i<len; i++) {
            char ch = str.charAt(i);
            if(ch==90) ch--;
            if(ch>82) ch--;
            int num = (int) (ch-65) / 3 + 2;
            cnt+=num+1;
        }
        System.out.println(cnt);
    }
}
