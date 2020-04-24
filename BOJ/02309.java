import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] inp = new int[9];
        int i, j, sum=0, a=0, b=0;
        for(i=0; i<9; i++) {
            inp[i] = sc.nextInt();
            sum+=inp[i];
        }
        Arrays.sort(inp);
        loop:
        for(i=0; i<9; i++){
            for(j=0; j<9; j++){
                if(i==j) continue;
                if(inp[i]+inp[j]==sum-100){
                    a = i; b = j;
                    break loop;
                }
            }
        }
        for(i=0; i<9; i++)
            if(i!=a && i!=b)
                System.out.println(inp[i]);
    }
}
