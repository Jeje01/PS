import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i;
        String tmp;
        String[] s = new String[n];
        for(i=0; i<n; i++){
            tmp = sc.next();
            if(tmp.length()<10)
                s[i] = "0";
            else s[i] = "";
            s[i] += tmp.length() + tmp;
        }
        Arrays.sort(s);

        for(i=0; i<n; i++){
            tmp = s[i].substring(2);
            if(i==0) System.out.println(tmp);
            else {
                if(!s[i].equals(s[i-1]))
                    System.out.println(tmp);
            }
        }
    }
}
