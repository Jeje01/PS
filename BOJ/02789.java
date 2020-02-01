import java.util.Scanner;

public class Main {
	public static void check(char a) {
		char[] cam = "CAMBRIDGE".toCharArray();
		int i;
		for(i=0; i<cam.length; i++) {
			if(a==cam[i])
				break;
		}
		if(i==cam.length)
			System.out.print(a);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] ch = sc.next().toCharArray();
		int i;
		for(i=0; i<ch.length; i++)
			check(ch[i]);
		System.out.println();
	}	
}
