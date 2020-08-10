/**
 * 로또
 * 조합
 * 13,192 kb
 * 88 ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
   static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
   static StringBuilder output = new StringBuilder();
   static StringTokenizer tokens;
   static int[] arr;
   static String line;
   
   static void makeCombination(int r, int start, int[] tmp) {
      if(r==5) {
         for(int a: tmp) {
            output.append(a).append(" ");
         }
         output.append("\n");
         return;
      }
      for(int i=start; i<arr.length; i++) {
         tmp[r+1] = arr[i];
         makeCombination(r+1, i+1, tmp);
      }
   }

   public static void main(String[] args) throws NumberFormatException, IOException {
      while(true) {
         line = input.readLine();
         if(line.equals("0")) break;
         tokens = new StringTokenizer(line, " ");
         int N = Integer.parseInt(tokens.nextToken());
         arr = new int[N];
         for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(tokens.nextToken());
         }
         makeCombination(-1, 0, new int[6]);
         output.append("\n");
      }
      System.out.println(output.toString());

   }

}
