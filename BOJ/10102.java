import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int a=0, b=0;
		char[] ch = sc.next().toCharArray();
		int i;
		for(i=0; i<v; i++) {
			if(ch[i]=='A') a++;
			else b++;
		}
		if(a>b) System.out.println("A");
		else if(a<b) System.out.println("B");
		else System.out.println("Tie");
	}
}
