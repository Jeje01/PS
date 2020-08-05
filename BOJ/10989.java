/**
 * 수 정렬하기 3
 * Counting Sort
 * 464,190 kb
 * 1,516 ms
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static int[] arr;
    static int count;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        int N = Integer.parseInt(input.readLine());
        arr = new int[10001];
        for(int i=0; i<N; i++) {
            arr[Integer.parseInt(input.readLine())] ++;
        }
        outerLoop: for(int i=1; i<arr.length; i++) {
            for(int j=0; j<arr[i]; j++) {
                output.append(i).append("\n");
                count++;
                if(count==N)
                    break outerLoop;
            }
        }
        System.out.println(output.toString());
    }

}
 
