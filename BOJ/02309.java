/**
 * 일곱 난쟁이
 * 조합
 * 14324 kb
 * 116 ms
 */

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    static int[] dwarfs, pick;
    static int sum;
    static void combination(int r, int start, int[] temp) {
        if(r==0) {
            if(temp[0]+temp[1]==sum-100) {
                pick[0]=temp[0];
                pick[1]=temp[1];
            }
            return;
        }
        for(int i=start; i<dwarfs.length; i++) {
            temp[r-1]=dwarfs[i];
            combination(r-1, i+1, temp);
        }
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        dwarfs = new int[9];
        int i, j, a=0, b=0;
        sum=0;
        for(i=0; i<9; i++) {
            dwarfs[i] = sc.nextInt();
            sum+=dwarfs[i];
        }
        pick = new int[2];
        combination(2, 0, new int[2]);
        Arrays.sort(dwarfs);
        for(i=0; i<9; i++)
            if(dwarfs[i]!=pick[0] && dwarfs[i]!=pick[1])
                System.out.println(dwarfs[i]);
    }
}