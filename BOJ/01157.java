import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] cnt = new int[26];
        char[] sp = sc.next().toUpperCase().toCharArray();
        int i, max=0, pos=-1;
        for(i=0; i<sp.length; i++){
            cnt[(int)sp[i]-65]++;
        }
        for(i=0; i<cnt.length; i++){
            if(max<cnt[i]) {
                max = cnt[i];
                pos = i;
            }
        }
        Arrays.sort(cnt);
        if(cnt[25]==cnt[24]) System.out.println("?");
        else System.out.println((char)(pos+65));
    }
}
