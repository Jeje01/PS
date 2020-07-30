/**
 * 암호생성기
 * 큐
 * 21,420 kb
 * 137 ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Solution {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static Queue<Integer> queue = new LinkedList<Integer>();
    static StringTokenizer tokens;
    static int temp;
     
    public static void main(String[] args) throws NumberFormatException, IOException {
        String line = null;
        int count=0;
        while((line = input.readLine())!=null) {
            count++;
            queue.clear();
            int subtract = 1;
            int n = Integer.parseInt(line);
            tokens = new StringTokenizer(input.readLine(), " ");
            for(int i=0; i<8; i++) {
                queue.offer(Integer.parseInt(tokens.nextToken()));
            }
            do {
                if(queue.peek()==0) {
                    queue.poll();
                    queue.offer(0);
                    break;
                }else {
                    temp = queue.poll();
                    if(temp-subtract<0) {
                        temp=0;
                    }else {
                        temp-=subtract;
                        if(subtract==5)
                            subtract=1;
                        else
                            subtract++;
                    }
                    queue.offer(temp);
                }
            }while(temp!=0);
            output.append("#").append(n).append(" ");
            for(int i=0; i<8; i++) {
                output.append(queue.poll());
                if(i!=7)
                    output.append(" ");
                else
                    output.append("\n");
            }
        }
 
        System.out.println(output.toString());
    }
 
}
