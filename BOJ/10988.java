import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] ch = sc.next().toCharArray();
		int i, answer=1;
		for(i=0; i<ch.length/2; i++) {
			if(ch[i]!=ch[ch.length-i-1])
				answer=0;
		}
		System.out.println(answer);
	}	
}
