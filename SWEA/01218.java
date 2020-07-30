/**
 * 괄호 짝짓기
 * 스택
 * 18,264 kb
 * 113 ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
 
public class Solution {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static int answer;
    static Stack<Character> brackets = new Stack<Character>();
     
    public static void main(String[] args) throws NumberFormatException, IOException {
        for(int t=1; t<=10; t++) {
            brackets.clear();
 
            answer = 0;
            int N = Integer.parseInt(input.readLine());
            String str = input.readLine();
            outer: for(int i=0; i<N; i++) {
                char bracket = str.charAt(i);
                if(bracket=='(' || bracket=='[' || bracket=='{' || bracket=='<') {
                    brackets.push(bracket);
                }else {
                    switch(bracket) {
                    case ')':
                        if(brackets.peek()=='(')
                            brackets.pop();
                        else
                            break outer;
                        break;
                    case ']':
                        if(brackets.peek()=='[')
                            brackets.pop();
                        else
                            break outer;
                        break;
                    case '}':
                        if(brackets.peek()=='{')
                            brackets.pop();
                        else
                            break outer;
                        break;
                    case '>':
                        if(brackets.peek()=='<')
                            brackets.pop();
                        else
                            break outer;
                        break;
             
                    }
                }
            }
         
            if(brackets.isEmpty()) answer=1;
            output.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(output.toString());
    }
 
}
