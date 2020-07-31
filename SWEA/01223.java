/**
 * 계산기2
 * 스택
 * 19,416 kb
 * 99 ms
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
 
public class Solution {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static int answer;
    static String line;
    static Stack<Integer> numbers;
    static int mul;
 
    public static void multiply() {
        int a, b;
        a = numbers.pop();
        b = numbers.pop();
        numbers.push(a*b);
        mul--;
    }
     
    public static void main(String[] args) throws NumberFormatException, IOException {
        for(int t=1; t<=10; t++) {
            int N = Integer.parseInt(input.readLine());
            numbers = new Stack<Integer>();
            line = input.readLine();
            mul = 0;
            answer = 0;
            for(int i=0; i<N; i++) {
                char tmp = line.charAt(i);
                if(tmp-'0'>=0 && tmp-'0'<10) {
                    numbers.push(tmp-'0');
                }else {
                      if(tmp=='*') {//곱하기가 나오면 개수 저장
                          mul++;
                      }else { // 플러스가 나오면 밀린 곱하기
                        
                          if(mul!=0) {
                              while(mul!=0) {
                                  multiply();
                              }
                          }
                      }
                }
            }
            while(mul!=0)
                multiply();
            while(!numbers.isEmpty()) {
                answer+=numbers.pop();
            }
            output.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(output.toString());
 
    }
 
}
