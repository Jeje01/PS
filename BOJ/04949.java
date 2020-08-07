/**
 * 균형잡힌 세상
 * 스택
 * 17,812 kb
 * 172 ms
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder output = new StringBuilder();
	static Stack<Character> stack = new Stack<Character>();

	public static void main(String[] args) throws IOException {
		while(true) {
			String line = input.readLine();
			if(line.equals(".")){
				break;
			}
			for(int i=0; i<line.length(); i++) {
				char tmp = line.charAt(i);
				if(tmp=='(' || tmp=='[') {
					stack.push(tmp);
				}else if(tmp==')') {
					if(stack.peek()=='(') {
						stack.pop();
					}else {
						break;
					}
				}else if(tmp==']'){
					if(stack.peek()=='[') {
						stack.pop();
					}else {
						break;
					}
				}
			}
			if(stack.isEmpty()) {
				output.append("yes");
			}else {
				output.append("no");
			}
			
			output.append("\n");
			
		}
		System.out.println(output.toString());
	}

}
