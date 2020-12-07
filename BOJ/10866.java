/**
 * 덱 - S4
 * 덱
 * 19,704 kb
 * 228 ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static Deque<Integer> deque = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(input.readLine());
        for(int i=0; i<N; i++){
            String[] words = input.readLine().split(" ");
            if (words.length == 2) {
                switch(words[0]){
                    case "push_front":
                        deque.offerFirst(Integer.parseInt(words[1]));
                        break;
                    case "push_back":
                        deque.offerLast(Integer.parseInt(words[1]));
                        break;
                }
            } else {
               switch(words[0]){
                   case "pop_front":
                       output.append(deque.isEmpty()? -1: deque.removeFirst());
                       break;
                   case "pop_back":
                       output.append(deque.isEmpty()? -1: deque.removeLast());
                       break;
                   case "size":
                       output.append(deque.size());
                       break;
                   case "empty":
                       output.append(deque.isEmpty()? 1: 0);
                       break;
                   case "front":
                       output.append(deque.isEmpty() ? -1: deque.peekFirst());
                       break;
                   case "back":
                       output.append(deque.isEmpty() ? -1: deque.peekLast());
                       break;
               }
               output.append("\n");
            }
        }
        System.out.println(output.toString());
    }
}
