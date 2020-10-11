/**
 * 스택 - S4
 * 스택
 * 17,304 kb
 * 176 ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
   static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
   static StringBuilder output = new StringBuilder();
   static Stack<Integer> stack = new Stack<>();
   
   static void push(int x) {
      stack.push(x);
   }
   
   static void pop() {
      if(stack.isEmpty()) {
         output.append("-1\n");
      }else {
         output.append(stack.pop()+"\n");
      }
   }
   
   static void size() {
      output.append(stack.size()+"\n");
   }
   
   static void empty() {
      int tmp = stack.isEmpty()? 1: 0;
      output.append(tmp+"\n");
   }
   
   static void top() {
      if(stack.isEmpty()) {
         output.append("-1\n");
      }else {
         output.append(stack.lastElement()+"\n");
      }
   }
   
   public static void main(String[] args) throws NumberFormatException, IOException {
      int N = Integer.parseInt(input.readLine());
      for(int i=0; i<N; i++) {
         String[] sp = input.readLine().split(" ");
         switch(sp[0]) {
         case "push":
            push(Integer.parseInt(sp[1]));
            break;
         case "pop":
            pop();
            break;
         case "size":
            size();
            break;
         case "empty":
            empty();
            break;
         case "top":
            top();
            break;
         }
      }
      System.out.println(output.toString());
   }
}
