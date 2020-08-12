/**
 * 큐 2 - S4
 * 큐, 덱
 * 375,844 kb
 * 1,712 ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
   static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
   static StringBuilder output = new StringBuilder();
   static StringTokenizer tokens;
   static int N;
   static Deque<Integer> queue = new LinkedList<Integer>();
   
   public static void main(String[] args) throws NumberFormatException, IOException {
      N = Integer.parseInt(input.readLine());
      for(int i=0; i<N; i++) {
         String[] sp = input.readLine().split(" ");
         if(sp.length==2) {
            queue.offer(Integer.parseInt(sp[1]));
         }else {
            switch(sp[0]) {
            case "pop":
               if(queue.isEmpty()) {
                  output.append(-1).append("\n");
               }else {
                  output.append(queue.poll()).append("\n");
               }
               break;
            case "size":
               output.append(queue.size()).append("\n");
               break;
            case "empty":
               if(queue.isEmpty()) {
                  output.append(1).append("\n");
               }else {
                  output.append(0).append("\n");
               }
               break;
            case "front":
               if(queue.isEmpty()) {
                  output.append(-1).append("\n");
               }else {
                  output.append(queue.peekFirst()).append("\n");
               }
               break;
            case "back":
               if(queue.isEmpty()) {
                  output.append(-1).append("\n");
               }else {
                  output.append(queue.peekLast()).append("\n");
               }
               break;
            }
         }
      }
      System.out.println(output.toString());
      
   }

}
