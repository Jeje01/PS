/**
 * 큐 - S4
 * 자료구조
 * 18,552 kb
 * 216 ms
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static Deque<Integer> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(input.readLine());
        for (int i=0; i<N; i++) {
            String[] str = input.readLine().split(" ");
            if (str.length == 2) {
                deque.offer(Integer.parseInt(str[1]));
            } else {
                switch(str[0]) {
                    case "pop":
                        output.append(deque.isEmpty()? -1 : deque.pollFirst());
                        break;
                    case "size":
                        output.append(deque.size());
                        break;
                    case "empty":
                        output.append(deque.isEmpty()? 1 : 0);
                        break;
                    case "front":
                        output.append(deque.isEmpty()? -1 : deque.peekFirst());
                        break;
                    case "back":
                        output.append(deque.isEmpty()? -1 : deque.peekLast());
                        break;
                }
                output.append("\n");
            }
        }
        System.out.print(output.toString());
    }
}
