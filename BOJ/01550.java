import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		char[] ch = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
		char[] input = sc.next().toCharArray();
		int answer = 0;
		for(int j = input.length-1; j>=0; j--)
			for(int i = 0; i<16; i++)
				if(input[j]==ch[i])
					answer+=Math.pow(16, input.length-j-1)*i;
		System.out.println(answer);
	}
}
