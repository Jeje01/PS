/**
 * 통계학 - S4
 * 구현, 정렬
 * 53,484 kb
 * 636 ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
   static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
   static StringBuilder output = new StringBuilder();
   static int N, count, frequent;
   static long sum;
   static int[] arr;
   static ArrayList<int[]> list = new ArrayList<int[]>();

   public static void main(String[] args) throws NumberFormatException, IOException {
      N = Integer.parseInt(input.readLine());
      arr = new int[N];
      for(int i=0; i<N; i++) {
         arr[i] = Integer.parseInt(input.readLine());
         sum+=arr[i];
      }
      Arrays.sort(arr);
      frequent = 0;
      for(int i=0; i<N; i++) {
         if(i==0) {
            count=1;
         }else {
            if(arr[i]!=arr[i-1]) {
               list.add(new int[] {arr[i-1], count});
               count=1;
            }else {
               count++;
            }
         }
      }
      list.add(new int[] {arr[N-1], count});
      if(list.size()==1) {
         frequent = list.get(0)[0];
      }else {
         Collections.sort(list, (o1, o2)-> {
            if(o1[1]==o2[1]) {
               return Integer.compare(o1[0], o2[0]);
            }
            return Integer.compare(o1[1], o2[1])*-1;
         });
         if(list.get(0)[1]==list.get(1)[1]) {
            frequent = list.get(1)[0];
         }else {
            frequent = list.get(0)[0];
         }
      }
      
      output.append(Math.round((double)sum/N)).append("\n");
      output.append(arr[N/2]).append("\n");
      output.append(frequent).append("\n");
      output.append((arr[N-1]-arr[0])).append("\n");
      System.out.println(output.toString());
   }

}
