/**
 * 탑
 * 스택
 * 108,644 kb
 * 676 ms
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static Stack<int[]> stack = new Stack<int[]>();
	static int[] arr;
	static int[] answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(input.readLine());
		StringTokenizer tokens = new StringTokenizer(input.readLine(), " ");
		arr = new int[N+1];
		answer = new int[N+1];
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(tokens.nextToken());
		}
		for(int i=N; i>=1; i--) {
			if(i==N) {
				stack.push(new int[] {N, arr[N]});
			}else {
				int temp = arr[i];
				while(true) {
					if(stack.isEmpty()) {
						stack.push(new int[] {i, temp});
						break;
					}else {
						if(temp>=stack.peek()[1]) {
							int[] popped = stack.pop();
							answer[popped[0]] = i;
						}else {
							stack.push(new int[] {i, temp});
							break;
						}
					}					
				}
			}
		}

		for(int i=1; i<N+1; i++) {
			output.append(answer[i]);
			if(i==N) {
				output.append("\n");
			}else {
				output.append(" ");
			}
		}
		System.out.println(output.toString());
	}
}
