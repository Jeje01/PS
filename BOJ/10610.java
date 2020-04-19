// Greedy

import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sp = br.readLine().split("");
        int[] num = new int[sp.length];
        int i, sum=0;
        StringBuilder sb = new StringBuilder();
        for(i=0; i<num.length; i++){
            num[i] = Integer.parseInt(sp[i]);
            sum+=num[i];
        }
        // 3의 배수인지 확인
        if(sum%3!=0)
            System.out.println(-1);
        else {
            Arrays.sort(num);
            if(num[0]!=0) // 10의 배수인지
                System.out.println(-1);
            else{
                for(i=num.length-1; i>=0; i--) {
                    sb.append(num[i]);
                }
                System.out.println(sb.toString());
            }
        }
    }
}
